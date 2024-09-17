package br.com.codecompany.rysys.core.balancing;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.util.ResourceUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class RoundRobinBalancingStrategy extends AbstractBalancingStrategy {

	private static final long serialVersionUID = 5310500433216234882L;

	private final Logger log = LoggerFactory
			.getLogger(RoundRobinBalancingStrategy.class);

	private Queue<Server> servers = new ConcurrentLinkedQueue<Server>();

	public void addServer(Server server) {
		servers.offer(server);
	}

	public void removeServer(Server server) {
		servers.remove(server);
	}

	public Server currentServer() {
		log.debug("Retrieving server from list " + servers);
		server = (Server) servers.poll();
		if (server == null) {
			throw new NoServerConfiguredException("Server list is empty");
		}
		servers.offer(server);
		return server;
	}

	public int serverCount() {
		return servers.size();
	}

	public void configure(String file) {
		log.info("Configuring balancing strategy from file only. "
				+ "All other configurations will be ignored");

		// remove default server (configured in application server), because
		// all configuration information comes from an external file
		servers.clear();

		if (file != null) {
			InputStream stream = ResourceUtils.getResourceAsStream(this, file);
			if (stream != null) {
				log.debug("Balancing config file (" + file
						+ ") loaded as stream: " + stream
						+ ". Loading servers' information from file");
				List<Server> serverList = serversFromFile(stream);
				for (Server server : serverList) {
					// descriptografa o password
					server.decryptPassword();
					servers.add(server);
				}
				log.info("Servers' configuration successfully loaded: "
						+ servers);
			} else {
				log.error("Could not load balancing configuration file: "
						+ file);
			}
			log.info("Servers avaliable: " + servers);
		} else {
			log.error("Invalid balancing configuration file: '" + file);
			throw new NoServerConfiguredException("Server list is empty");
		}
	}

	@SuppressWarnings("unchecked")
	private List<Server> serversFromFile(InputStream stream) {
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("servers", ArrayList.class);
		xstream.alias("server", Server.class);
		List<Server> servers = (List<Server>) xstream.fromXML(stream);
		return servers;
	}

	public String getName() {
		return ROUND_ROBIN;
	}
}
