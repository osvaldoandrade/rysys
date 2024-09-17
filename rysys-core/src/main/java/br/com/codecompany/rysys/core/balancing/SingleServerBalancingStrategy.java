package br.com.codecompany.rysys.core.balancing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleServerBalancingStrategy extends AbstractBalancingStrategy {

	private static final long serialVersionUID = -1190269746360220287L;

	private final Logger log = LoggerFactory
			.getLogger(SingleServerBalancingStrategy.class);

	public void addServer(Server server) {
		this.server = server;
	}

	public void configure(String file) {
		log.warn("Method 'configure(String)' is not implemented in this class");
	}

	public Server currentServer() {
		if (server == null) {
			throw new NoServerConfiguredException(
					"No server configured for using with strategy " + this);
		}
		return server;
	}

	public void removeServer(Server server) {
		this.server = null;
	}

	public int serverCount() {
		return server == null ? 0 : 1;
	}
	
	public String getName() {
		return SINGLE_SERVER;
	}	
}
