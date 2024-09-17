package br.com.codecompany.rysys.core.jca.eis;

import java.io.Serializable;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpoint;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.cache.Cache;
import br.com.codecompany.rysys.core.driver.ConnectionProps;
import br.com.codecompany.rysys.core.jmx.AdapterManagement;
import br.com.codecompany.rysys.util.CheckUtils;

/**
 * @author Sadi Melbouci
 * 
 */
public class EisResourceAdapter implements ResourceAdapter, ConnectionProps, Serializable {

	private static final long serialVersionUID = 5005858474945538623L;

	private static final Logger log = LoggerFactory.getLogger(EisResourceAdapter.class);

	// transient por compatibilidade SJSAS
	//private BootstrapContext bootstrapContext = null;
	
	private String hostname;
	private String password;	
	private Integer port;
	private Integer timeout;
	private String username;
	private Integer pingFrequency;
	
	private String driver = null;
	private String balancingStrategy;
	private String balancingConfigFile;
	
	// monitoring datasource
	private String monitoringDataSource;
	
	// cache configuration
	private String cacheConfigFile;
	
	private EisActivationSpec eisActivationSpec = null;
	private EisXAResource eisXAResource = null;	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.spi.ResourceAdapter#endpointActivation(javax.resource.
	 * spi.endpoint.MessageEndpointFactory, javax.resource.spi.ActivationSpec)
	 */
	public void endpointActivation(
			MessageEndpointFactory messageEndpointFactory,
			ActivationSpec activationSpec) throws ResourceException {
		this.eisActivationSpec = (EisActivationSpec) activationSpec;
		log.info("EISResourceAdapter endpointActivation: "
				+ messageEndpointFactory + ", " + activationSpec);

		this.eisXAResource = new EisXAResource();
		MessageEndpoint messageEndpoint = messageEndpointFactory
				.createEndpoint(this.eisXAResource);
		// this.eisXAResource.setEndpoint(messageEndpoint);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.spi.ResourceAdapter#endpointDeactivation(javax.resource
	 * .spi.endpoint.MessageEndpointFactory, javax.resource.spi.ActivationSpec)
	 */
	public void endpointDeactivation(MessageEndpointFactory arg0,
			ActivationSpec activationSpec) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.spi.ResourceAdapter#start(javax.resource.spi.BootstrapContext
	 * )
	 */
	public void start(BootstrapContext bootstrapContext)
			throws ResourceAdapterInternalException {
		log.info("Starting JCA Connector: " + this.getClass().getName());
		//this.bootstrapContext = bootstrapContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.spi.ResourceAdapter#stop()
	 */
	public void stop() {
		log.info("Stopping EisResourceAdapter");
	}

	/**
	 * @return the eisActivationSpec
	 */
	public EisActivationSpec getEisActivationSpec() {
		return eisActivationSpec;
	}

	/**
	 * @param eisActivationSpec
	 *            the eisActivationSpec to set
	 */
	public void setEisActivationSpec(EisActivationSpec eisActivationSpec) {
		this.eisActivationSpec = eisActivationSpec;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.spi.ResourceAdapter#getXAResources(javax.resource.spi.
	 * ActivationSpec[])
	 */
	public XAResource[] getXAResources(ActivationSpec[] arg0)
			throws ResourceException {
		return null;
	}

	/**
	 * @return the eisXAResource
	 */
	public EisXAResource getEisXAResource() {
		return eisXAResource;
	}

	/**
	 * @param eisXAResource
	 *            the eisXAResource to set
	 */
	public void setEisXAResource(EisXAResource eisXAResource) {
		this.eisXAResource = eisXAResource;
	}


	public String getBalancingConfigFile() {
		CheckUtils.checkNull(log, this, "balancingConfigFile", balancingConfigFile);
		return balancingConfigFile;
	}
	
	public void setBalancingConfigFile(String balancingConfigFile) {
		CheckUtils.checkNull(log, this, "balancingConfigFile", balancingConfigFile);
		this.balancingConfigFile = balancingConfigFile;
	}
	
	public String getBalancingStrategy() {
		CheckUtils.checkNull(log, this, "balancingStrategy", balancingStrategy);
		return balancingStrategy;
	}
	
	public void setBalancingStrategy(String balancingStrategy) {
		CheckUtils.checkNull(log, this, "balancingStrategy", balancingStrategy);
		this.balancingStrategy = balancingStrategy;
	}
		
	public String getDriver() {
		CheckUtils.checkNull(log, this, "driver", driver);
		return driver;
	}
	
	public void setDriver(String driver) {
		CheckUtils.checkNull(log, this, "driver", driver);
		this.driver = driver;
	}

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
	
	public String getMonitoringDataSource() {
		return monitoringDataSource;
	}
	
	public void setMonitoringDataSource(String monitoringDataSource) {
		this.monitoringDataSource = monitoringDataSource;
		// creates JMX monitor
		AdapterManagement me = new AdapterManagement(monitoringDataSource);
		me.createAndRegisterEasyMBean();
		log.info("Adapter management successfully started");
	}
	
	public String getCacheConfigFile() {
		return cacheConfigFile;
	}
	
	public void setCacheConfigFile(String cacheConfigFile) {
		this.cacheConfigFile = cacheConfigFile;
		if (cacheConfigFile == null || "".equals(cacheConfigFile.trim())) {
			log.warn("No cache configuration informed, disabling cache");
		}
		// start cache configuration
		Cache.getInstance(cacheConfigFile);
	}
}
