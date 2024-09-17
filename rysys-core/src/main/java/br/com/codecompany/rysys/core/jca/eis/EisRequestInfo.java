package br.com.codecompany.rysys.core.jca.eis;

import javax.resource.spi.ConnectionRequestInfo;

import br.com.codecompany.rysys.core.balancing.BalancingStrategy;
import br.com.codecompany.rysys.core.balancing.Server;
import br.com.codecompany.rysys.util.CheckUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EisRequestInfo implements ConnectionRequestInfo {

    private static Logger log = LoggerFactory.getLogger(EisRequestInfo.class);

	private Server server = new Server();
	private String driver = null;
	private BalancingStrategy strategy;

	public Server getServer() {
		return server;
	}
	
	public void setServer(Server server) {
		this.server = server;
	}
	
	/**
	 * @return the driver
	 */
	public String getDriver() {
		CheckUtils.checkNull(log, this, "driver", driver);
		return driver;
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(String driver) {
		CheckUtils.checkNull(log, this, "driver", driver);
		this.driver = driver;
	}
	
	public BalancingStrategy getStrategy() {
		return strategy;
	}
	
	public void setStrategy(BalancingStrategy balancingStrategy) {
		this.strategy = balancingStrategy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driver == null) ? 0 : driver.hashCode());
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
		EisRequestInfo other = (EisRequestInfo) obj;
		if (driver == null) {
			if (other.driver != null)
				return false;
		} else if (!driver.equals(other.driver))
			return false;
		return true;
	}
}
