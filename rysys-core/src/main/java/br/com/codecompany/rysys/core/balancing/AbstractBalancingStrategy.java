package br.com.codecompany.rysys.core.balancing;

public abstract class AbstractBalancingStrategy implements BalancingStrategy {

	private static final long serialVersionUID = -5705062940851278684L;

	protected Server server;

	public Server serverInfo() {
		if (server == null) {
			throw new NoServerConfiguredException(
					"No server configured for using with strategy " + this);
		}

		Server info = new Server();
		info.setHostname(server.getHostname());
		info.setPassword(server.getPassword());
		info.setPort(server.getPort());
		info.setTimeout(server.getTimeout());
		info.setUsername(server.getUsername());
		info.setPingFrequency(server.getPingFrequency());

		return info;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((server == null) ? 0 : server.hashCode());
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
		AbstractBalancingStrategy other = (AbstractBalancingStrategy) obj;
		if (server == null) {
			if (other.server != null)
				return false;
		} else if (!server.equals(other.server))
			return false;
		return true;
	}
}
