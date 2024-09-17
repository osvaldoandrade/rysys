package br.com.codecompany.rysys.core.driver;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trilead.ssh2.ChannelCondition;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.KnownHosts;
import com.trilead.ssh2.Session;
import java.util.UUID;

public abstract class SshAdapter extends AbstractConnectionDriver {

	private static final Logger log = LoggerFactory.getLogger(SshAdapter.class);

	private String id;

        private static final String RYSYS_SUBSYSTEM = "rysys";
        
        // fim de comando
        protected static final Pattern RETURN_PATTERN =
            Pattern.compile(".*(\\<rysys type\\=\"2\"\\>.+\\<\\/rysys\\>).*",
			Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	
	// erro
	protected static final Pattern ERROR_PATTERN =
		Pattern.compile(".*\\<error\\>.*" +
                        "\\<code\\>(.+)\\<\\/code\\>.*" +
                        "\\<description\\>(.+)\\<\\/description\\>.*" +
                        "\\<\\/error\\>.*",
                        Pattern.CASE_INSENSITIVE);

	private static final String knownHostPath = "~/.ssh/known_hosts";

	private KnownHosts database = new KnownHosts();
	protected Connection connection = null;
	protected Session session = null;
    protected String successReturn = null;

	public SshAdapter() {
		log.info("New Adapter created!");
		id = UUID.randomUUID().toString();
		File knownHostFile = new File(knownHostPath);
		if (knownHostFile.exists()) {
			try {
				database.addHostkeys(knownHostFile);
			} catch (IOException e) {
			}
		}
	}

	public Serializable execute(Serializable command) {
		try {
			connect();
			successReturn = null;
			String cmd = String.valueOf(command);
			log.debug("[{}] Executing command:[{}]", id, cmd);

			if (!cmd.endsWith("\n")) {
				cmd += "\n";
			}

			log.debug("[{}] Waiting for command to finish...", id);
			return runCommandWaitToFinish(cmd);

		} catch (ConnectionException e) {
                        log.error("Error executing command", e);
			throw new RuntimeException("[" + id + "] Error executing command", e);
		} catch (IOException e) {
                        log.error("Error executing command", e);
			throw new RuntimeException("[" + id + "] Error executing command", e);
		}
	}

    private void openSession() {
        try {
            if (session == null) {
                log.debug("[{}] Connected. Opening SSH session...", id);
                session = connection.openSession();
                                
                log.debug("[{}] Starting rysys sshd subsystem...", id);
                session.startSubSystem(RYSYS_SUBSYSTEM);

                log.debug("[{}] Shell successfully started", id);
            }
        } catch (IOException e) {
			throw new RuntimeException("[" + id + "] Error opening SSH session", e);
		}
    }

	private String runCommandWaitToFinish(String cmd) throws IOException {
		if (getTimeout() == 0) {
			log.warn("[{}] Warning: Infinite timeout was set!", id);
		}
		StringBuffer result = new StringBuffer();

		/*
		 * Don't wrap these streams and don't let other threads work on these
		 * streams while you work with Session.waitForCondition()!!!
		 */
		InputStream stdin = session.getStdout();
		OutputStream stdout = session.getStdin();

		// run executable
		stdout.write(cmd.getBytes());
		stdout.flush();

		byte[] buffer = new byte[8192];

		boolean finished = false;
		while (!finished) {
			if (stdin.available() == 0) {
				/*
				 * Even though currently there is no data available, it may be
				 * that new data arrives and the session's underlying channel is
				 * closed before we call waitForCondition(). This means that EOF
				 * and STDOUT_DATA (or STDERR_DATA, or both) may be set
				 * together.
				 */
				int conditions = session.waitForCondition(
						ChannelCondition.STDOUT_DATA | ChannelCondition.EOF,
						getTimeout());

				/* Wait no longer than TIMEOUT miliseconds */
				if ((conditions & ChannelCondition.TIMEOUT) != 0) {
					/* A timeout occured. */
					throw new IOException(
							"[" + id + "] Timeout while waiting for data from peer. " +
							"Current timeout is " + getTimeout() +
							"ms. Response read until now: [" + result + "]");
				}

				/*
				 * Here we do not need to check separately for CLOSED, since
				 * CLOSED implies EOF
				 */
				if ((conditions & ChannelCondition.EOF) != 0) {
					/* The remote side won't send us further data... */

					if ((conditions & ChannelCondition.STDOUT_DATA) == 0) {
						/*
						 * ... and we have consumed all data in the local
						 * arrival window.
						 */
						break;
					}
				}

				/* OK, either STDOUT_DATA or STDERR_DATA (or both) is set. */
			}

			while (stdin.available() > 0) {
				int len = stdin.read(buffer);
				if (len > 0) { // this check is somewhat paranoid
					String line = new String(buffer, 0, len);
					result.append(line);
					log.trace("[{}] Analyzing console response: [{}]", id, result);
					if (finished = isEndOfCommand(result) || line == null) {
                        log.debug("[{}] End of command found in response: [{}]", id, result);
                        if (line != null) {
                            result = new StringBuffer(successReturn);
                        }
						break;
					}
					else {
						log.trace("[{}] Command not finished yet", id);
					}
				}
			}
		}

		return result.toString();
	}
	
	protected boolean isEndOfCommand(StringBuffer buffer) {
		boolean end = false;
		if (buffer == null) {
			log.warn("[{}] Null response found!", id);
			end = true;
		}
        else {
            // comando finalizado?
            Matcher complete = RETURN_PATTERN.matcher(buffer);
            if (complete.matches()) {
                end = true;
				// pega o ultimo grupo, pois podem existir comandos anteriores
				String group = complete.group(complete.groupCount());
                // finalizado com erro?
                Matcher error = ERROR_PATTERN.matcher(group);
                if (error.matches()) {
                    String code = error.group(1);
                    String description = error.group(2);
                    throw new MessageExecutionException("Error executing message: " +
							description + " (" + code + ")");
                }
                // execucao com sucesso
                else {
					log.info("Command successfully executed. Response is [{}]", group);
					successReturn = group;
                }
            }
			else {
				successReturn = null;
			}
        }

		return end;
	}

	public void connect() throws ConnectionException {
		if (connection == null) {
			log.info("[{}] Opening SSH connecting in {}:{}", new Object[]{id, getHostname(), getPort()});
			connection = new Connection(getHostname(), getPort());
			try {
				/*
				 * CONNECT AND VERIFY SERVER HOST KEY (with callback)
				 */
				String[] hostkeyAlgos = database
						.getPreferredServerHostkeyAlgorithmOrder(getHostname());

				if (hostkeyAlgos != null) {
					connection.setServerHostKeyAlgorithms(hostkeyAlgos);
				}

				connection.connect(new AdvancedVerifier(database, knownHostPath));

				/*
				 * AUTHENTICATION PHASE
				 */
				if (connection.isAuthMethodAvailable(getUsername(), "password")) {
					boolean res = connection.authenticateWithPassword(getUsername(), getPassword());
					if (!res) {
						throw new IOException("[" + id + "] Password authentication failed.");
					}

				} else {
					throw new IOException("[" + id + "] No supported " +
							"authentication methods available.");
				}

				openSession();

			} catch (IOException e) {
				throw new ConnectionException("[" + id + "] Error connecting to EIS", e);
			}
		}
	}

    public void disconnect() {
        log.info("[{}] Closing SSH session...", id);
        if (session != null) {
            try {
                session.close();
                session = null;
                log.info("[{}] SSH session successfully closed", id);
            } catch (Exception e) {
                log.error("[" + id + "] Error closing SSH session", e);
            }
        }
        else {
            log.warn("[{}] SSH session is null", id);
        }

        log.info("[{}] Closing SSH connection...", id);
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                log.info("[{}] SSH connection successfully closed", id);
            } catch (Exception e) {
                log.error("[" + id + "] Error closing SSH connection", e);
            }
        }
        else {
            log.warn("[{}] SSH connection is null", id);
        }
    }
}
