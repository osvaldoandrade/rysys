package br.com.codecompany.rysys.core.jca.eis;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EisConnectionFactory implements ConnectionFactory {

	private static final long serialVersionUID = -3962458836419210312L;

	private static final Logger log = LoggerFactory.getLogger(EisConnectionFactory.class);

	private EisManagedConnectionFactory eisManagedCF = null;

	// transient por compatibilidade SJSAS
	private ConnectionManager connectionManager = null;

	private EisConnection eisConnection = null;

	public EisConnectionFactory() {
		
	}
			
	public EisConnectionFactory(
			EisManagedConnectionFactory eisManagedConnectionFactory,
			ConnectionManager connectionManager) {
		log.info("Creating EisConnectionFactory");
		this.eisManagedCF = eisManagedConnectionFactory;
		this.connectionManager = connectionManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.ConnectionFactory#getConnection()
	 */
	public Connection getConnection() throws ResourceException {
		try {
			log.info("Getting EIS Connection...");
			this.eisConnection = (EisConnection) this.connectionManager
					.allocateConnection(eisManagedCF, getConnectionInfo());
		} catch (Exception e) {
			log.error("Problem while getting a connection", e);
		}
		return this.eisConnection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.cci.ConnectionFactory#getConnection(javax.resource.cci
	 * .ConnectionSpec)
	 */
	public Connection getConnection(ConnectionSpec spec)
			throws ResourceException {
		return getConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.ConnectionFactory#getMetaData()
	 */
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.ConnectionFactory#getRecordFactory()
	 */
	public RecordFactory getRecordFactory() throws ResourceException {
		return new EisRecordFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.Referenceable#setReference(javax.naming.Reference)
	 */
	public void setReference(Reference reference) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.naming.Referenceable#getReference()
	 */
	public Reference getReference() throws NamingException {
		return null;
	}

	private ConnectionRequestInfo getConnectionInfo() {
		EisRequestInfo info = new EisRequestInfo();

		info.setDriver(eisManagedCF.getDriver());
		info.setStrategy(eisManagedCF.getStrategy());
		log.info(EisRequestInfo.class.getSimpleName() + " created and populated");

		return info;
	}

}
