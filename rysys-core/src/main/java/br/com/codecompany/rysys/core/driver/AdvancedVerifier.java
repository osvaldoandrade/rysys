package br.com.codecompany.rysys.core.driver;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trilead.ssh2.KnownHosts;
import com.trilead.ssh2.ServerHostKeyVerifier;

/**
 * This ServerHostKeyVerifier asks the user on how to proceed if a key
 * cannot be found in the in-memory database.
 * 
 */
public class AdvancedVerifier implements ServerHostKeyVerifier {
	
	private static final Logger log = LoggerFactory.getLogger(AdvancedVerifier.class);
	
	private KnownHosts database;
	private String knownHostPath;
	
	public AdvancedVerifier(KnownHosts database, String knownHostPath) {
		this.database = database;
		this.knownHostPath = knownHostPath;
	}

	public boolean verifyServerHostKey(String hostname, int port,
			String serverHostKeyAlgorithm, byte[] serverHostKey)
			throws Exception {
		
		final String host = hostname;
		final String algo = serverHostKeyAlgorithm;

		String message;

		/* Check database */
		int result = database.verifyHostkey(hostname,
				serverHostKeyAlgorithm, serverHostKey);

		switch (result) {
			case KnownHosts.HOSTKEY_IS_OK:
				message = "Hostkey (type " + algo
				+ ") from " + host + " accepted ";
				return true;
	
			case KnownHosts.HOSTKEY_IS_NEW:
				message = "New hostkey (type " + algo
						+ ") from " + host + " accepted ";
				break;
	
			case KnownHosts.HOSTKEY_HAS_CHANGED:
				message = "Hostkey for " + host
						+ " has changed. Accepting anyway ";
				break;
	
			default:
				throw new IllegalStateException();
		}

		/* Include the fingerprints in the message */
		String hexFingerprint = KnownHosts.createHexFingerprint(
				serverHostKeyAlgorithm, serverHostKey);
		String bubblebabbleFingerprint = KnownHosts
				.createBubblebabbleFingerprint(serverHostKeyAlgorithm,
						serverHostKey);

		message += "Hex Fingerprint: [" + hexFingerprint
				+ "] Bubblebabble Fingerprint: [" + bubblebabbleFingerprint + "]";

		/* Ever accept hostkey */	
		boolean acceptHostkey = true; 

		if (acceptHostkey) {			
			log.info(message);
			
			/* Be really paranoid. We use a hashed hostname entry */
			String hashedHostname = KnownHosts
					.createHashedHostname(hostname);

			/* Add the hostkey to the in-memory database */
			database.addHostkey(new String[] { hashedHostname },
					serverHostKeyAlgorithm, serverHostKey);

			/* Also try to add the key to a known_host file */
			try {
				KnownHosts.addHostkeyToFile(new File(knownHostPath),
						new String[] { hashedHostname },
						serverHostKeyAlgorithm, serverHostKey);
			} catch (IOException ignore) {
				
			}

			return true;
		}

		return false;
	}
}
