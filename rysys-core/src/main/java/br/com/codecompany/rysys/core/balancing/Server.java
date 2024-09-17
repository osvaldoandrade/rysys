package br.com.codecompany.rysys.core.balancing;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.driver.ConnectionDriver;
import br.com.codecompany.rysys.core.driver.ConnectionProps;
import br.com.codecompany.rysys.core.jce.EncrypterHelper;
import br.com.codecompany.rysys.util.CheckUtils;

public final class Server implements ConnectionProps, Serializable {

	private static final long serialVersionUID = -1215521456411651800L;
	
	private static final Logger log = LoggerFactory.getLogger(Server.class);
	
	private String hostname;
	private String password;	
	private Integer port;
	private Integer timeout;
	private Integer pingFrequency;
	private String username;

	public String getHostname() {
		CheckUtils.checkNull(log, this, "hostname", hostname);
		return hostname;
	}

	public void setHostname(String hostname) {
		CheckUtils.checkNull(log, this, "hostname", hostname);
		this.hostname = hostname;
	}

	public String getPassword() {
		CheckUtils.checkNull(log, this, "password", password);
		return password;
	}

	public void setPassword(String password) {
		CheckUtils.checkNull(log, this, "password", password);
		this.password = password;
		// o password eh guardado descriptografado
		decryptPassword();
	}
	
	public void decryptPassword() {
		if (password != null) {
			password = EncrypterHelper.decryptPassword(password);
		}
	}

	public Integer getPort() {
		CheckUtils.checkNull(log, this, "port", port);
		return port;
	}

	public void setPort(Integer port) {
		CheckUtils.checkNull(log, this, "port", port);
		this.port = port;
	}

	public Integer getTimeout() {
		CheckUtils.checkNull(log, this, "timeout", timeout);
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		CheckUtils.checkNull(log, this, "timeout", timeout);
		this.timeout = timeout;
	}
	
	public Integer getPingFrequency() {
		CheckUtils.checkNull(log, this, "pingFrequency", pingFrequency);
		return pingFrequency;
	}

	public void setPingFrequency(Integer pingFrequency) {
		CheckUtils.checkNull(log, this, "pingFrequency", pingFrequency);
		this.pingFrequency = pingFrequency;
	}

	public String getUsername() {
		CheckUtils.checkNull(log, this, "username", username);
		return username;
	}

	public void setUsername(String username) {
		CheckUtils.checkNull(log, this, "username", username);
		this.username = username;
	}	
	
	public boolean isHealthy(ConnectionDriver adapter) {
		boolean healthy = true;
		
		Socket socket = null;
		try {
			log.debug("Testing connection health on " + hostname + 
					"@" + port + " via socket");
			socket = new Socket(hostname, port);
			healthy = socket.isConnected() && !socket.isClosed();
		} catch (IOException e) {
			log.error("Could not connect to server " + this, e);
		} finally {
			if (socket != null) {
				try {
					socket.close();
					socket = null;
				} catch (IOException e) {
					log.error("Could not close test socket", e);
				}				
			}
		}
		
		return healthy;
	}
	
    @Override
	public String toString() {
		return username + "@" + hostname + ":" + port;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hostname == null) ? 0 : hostname.hashCode());
		result = prime * result + ((port == null) ? 0 : port);
		return result;
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (hostname == null) {
			if (other.hostname != null)
				return false;
		} else if (!hostname.equals(other.hostname))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;		
		return true;
	}
}
