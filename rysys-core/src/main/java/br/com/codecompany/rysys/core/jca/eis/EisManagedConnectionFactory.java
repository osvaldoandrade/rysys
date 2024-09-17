package br.com.codecompany.rysys.core.jca.eis;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.security.auth.Subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.balancing.BalancingStrategy;
import br.com.codecompany.rysys.core.balancing.BalancingStrategyFactory;
import br.com.codecompany.rysys.core.balancing.Server;
import br.com.codecompany.rysys.core.driver.ConnectionProps;
import br.com.codecompany.rysys.core.driver.DriverFactory;
import br.com.codecompany.rysys.util.CheckUtils;
import br.com.codecompany.rysys.util.ToStringUtils;

public class EisManagedConnectionFactory implements ManagedConnectionFactory,
		ResourceAdapterAssociation, ConnectionProps {

	private static final long serialVersionUID = -525366847091934434L;

	private static final Logger log = LoggerFactory.getLogger(EisManagedConnectionFactory.class);

	private EisResourceAdapter resourceAdapter = null;

	private Server server = new Server();
	private String driver = null;

	private String balancingStrategy;
	private String balancingConfigFile;
	private BalancingStrategy strategy;

	private String monitoringDataSource;
	private String cacheConfigFile;
	
	public EisManagedConnectionFactory() {
		log.info("Creating EisManagedConnectionFactory...");
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.spi.ManagedConnectionFactory#createConnectionFactory()
	 */
	public Object createConnectionFactory() throws ResourceException {
		log.info("Creating Connection Factory: '" + 
				this.getClass().getName() + "'");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.spi.ManagedConnectionFactory#createConnectionFactory(javax
	 * .resource.spi.ConnectionManager)
	 */
	public Object createConnectionFactory(ConnectionManager connectionManager)
			throws ResourceException {
		log.info("Creating Connection Factory: '" + this.getClass().getName()
				+ "'. ConnectionManager = " + connectionManager);
		return new EisConnectionFactory(this, connectionManager);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.spi.ManagedConnectionFactory#createManagedConnection(javax
	 * .security.auth.Subject, javax.resource.spi.ConnectionRequestInfo)
	 */
	public ManagedConnection createManagedConnection(Subject subject,
			ConnectionRequestInfo connectionRequestInfo)
			throws ResourceException {
		log.info("Creating Managed Connection. Subject = " + subject
				+ ". ConnectionRequestInfo = " + connectionRequestInfo);
		ManagedConnection mc = new EisManagedConnection(subject,
				connectionRequestInfo);
		return mc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.spi.ManagedConnectionFactory#getLogWriter()
	 */
	public PrintWriter getLogWriter() throws ResourceException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.spi.ManagedConnectionFactory#matchManagedConnections(java
	 * .util.Set, javax.security.auth.Subject,
	 * javax.resource.spi.ConnectionRequestInfo)
	 */
	public ManagedConnection matchManagedConnections(Set set, Subject subject,
			ConnectionRequestInfo info) throws ResourceException {
		log.info("Matching Managed Connections (size is {}): ", + set.size());
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			if (obj instanceof EisManagedConnection) {
				EisManagedConnection mc = (EisManagedConnection) obj;
				if (mc.match(subject, info)) {
					return mc;
				}
			}
		}
        log.warn("No match found for any of the {} connections", set.size());
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.spi.ManagedConnectionFactory#setLogWriter(java.io.PrintWriter
	 * )
	 */
	public void setLogWriter(PrintWriter arg0) throws ResourceException {

	}

	/**
	 * @return the resourceAdapter
	 */
	public ResourceAdapter getResourceAdapter() {
		if (resourceAdapter == null)
			log.warn("Resource Adapter is NULL");
		return resourceAdapter;
	}

	/**
	 * @param resourceAdapter
	 *            the resourceAdapter to set
	 */
	public void setResourceAdapter(ResourceAdapter resourceAdapter) {
		this.resourceAdapter = (EisResourceAdapter) resourceAdapter;
		
		this.resourceAdapter.setBalancingConfigFile(getBalancingConfigFile());
		this.resourceAdapter.setBalancingStrategy(getBalancingStrategy());
		this.resourceAdapter.setDriver(getDriver());
		this.resourceAdapter.setHostname(getHostname());
		this.resourceAdapter.setPassword(getPassword());
		this.resourceAdapter.setPort(getPort());
		this.resourceAdapter.setTimeout(getTimeout());
		this.resourceAdapter.setUsername(getUsername());
		this.resourceAdapter.setPingFrequency(getPingFrequency());
		
		// JMX monitoring
		this.resourceAdapter.setMonitoringDataSource(getMonitoringDataSource());
		
		// cache configuration
		this.resourceAdapter.setCacheConfigFile(getCacheConfigFile());
				
		log.info("Resource Adapter is SET with these properties: " +
				ToStringUtils.toString(resourceAdapter));
	}

	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return server.getHostname();
	}

	/**
	 * @param hostname
	 *            the hostname to set
	 */
	public void setHostname(String hostname) {
		server.setHostname(hostname);
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return server.getPassword();
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		server.setPassword(password);	
	}

	/**
	 * @return the port
	 */
	public Integer getPort() {
		return server.getPort();
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(Integer port) {
		server.setPort(port);
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return server.getUsername();
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		server.setUsername(username);
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
		this.driver = DriverFactory.getStrategy(driver);
	}

	/**
	 * @return the timeout
	 */
	public Integer getTimeout() {
		return server.getTimeout();
	}

	/**
	 * @param timeout
	 *            the timeout to set
	 */
	public void setTimeout(Integer timeout) {
		server.setTimeout(timeout);
	}
	
	public Integer getPingFrequency() {	
		return server.getPingFrequency();
	}

	public void setPingFrequency(Integer pingFrequency) {			
		server.setPingFrequency(pingFrequency);
	}		
	
	public String getBalancingStrategy() {
		CheckUtils.checkNull(log, this, "balancingStrategy", balancingStrategy);
		return balancingStrategy;
	}
	
	public void setBalancingStrategy(String balancingStrategy) {
		CheckUtils.checkNull(log, this, "balancingStrategy", balancingStrategy);
		this.balancingStrategy = balancingStrategy;
		configureStrategy();
	}

	public String getBalancingConfigFile() {
		CheckUtils.checkNull(log, this, "balancingConfigFile", balancingConfigFile);
		return balancingConfigFile;
	}
	
	public void setBalancingConfigFile(String balancingConfigFile) {
		CheckUtils.checkNull(log, this, "balancingConfigFile", balancingConfigFile);
		this.balancingConfigFile = balancingConfigFile;
		configureStrategy();
	}

	private void configureStrategy() {
		if (balancingStrategy != null) {
			strategy = BalancingStrategyFactory
					.getStrategy(balancingStrategy);
			log.debug("Balancing strategy created: " + strategy);
			
			// as default, add server configured (configured in application server)
			log.info("Setting a default server (configured in application server)");
			strategy.addServer(server);
		}

		if (strategy != null && balancingConfigFile != null) {
			log.debug("Configuring balancing strategy using file: " + balancingConfigFile);
			strategy.configure(balancingConfigFile);
		}
	}

	public BalancingStrategy getStrategy() {
		CheckUtils.checkNull(log, this, "strategy", strategy);
		return strategy;
	}
	
	public String getMonitoringDataSource() {
		return monitoringDataSource;
	}
	
	public void setMonitoringDataSource(String monitoringDataSource) {
		this.monitoringDataSource = monitoringDataSource;
	}
	
	public String getCacheConfigFile() {
		return cacheConfigFile;
	}
	
	public void setCacheConfigFile(String cacheConfigFile) {
		this.cacheConfigFile = cacheConfigFile;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((balancingConfigFile == null) ? 0 : balancingConfigFile
						.hashCode());
		result = prime
				* result
				+ ((balancingStrategy == null) ? 0 : balancingStrategy
						.hashCode());
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
		EisManagedConnectionFactory other = (EisManagedConnectionFactory) obj;
		if (balancingConfigFile == null) {
			if (other.balancingConfigFile != null)
				return false;
		} else if (!balancingConfigFile.equals(other.balancingConfigFile))
			return false;
		if (balancingStrategy == null) {
			if (other.balancingStrategy != null)
				return false;
		} else if (!balancingStrategy.equals(other.balancingStrategy))
			return false;
		if (server == null) {
			if (other.server != null)
				return false;
		} else if (!server.equals(other.server))
			return false;
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		log.info("Garbage Collecting: " + this.getClass().getName()
				+ "Managed Host: " + getHostname());
		super.finalize();
	}	
}
