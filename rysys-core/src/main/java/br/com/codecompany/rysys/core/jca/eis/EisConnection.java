package br.com.codecompany.rysys.core.jca.eis;

import java.io.Serializable;
import java.util.UUID;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.Record;
import javax.resource.cci.ResultSetInfo;
import javax.resource.spi.ManagedConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.driver.ConnectionException;

public class EisConnection implements IEisConnection {
	
	private static final Logger log = LoggerFactory.getLogger(EisConnection.class);

	private UUID uuid = UUID.randomUUID();
	
	EisManagedConnection managedConnection = null;

	public EisConnection(ManagedConnection mc) {
		managedConnection = (EisManagedConnection) mc;
	}

	/**
	 * @return the managedConnection
	 */
	public EisManagedConnection getManagedConnection() {
		return managedConnection;
	}

	/**
	 * @param managedConnection
	 *            the managedConnection to set
	 */
	public void setManagedConnection(EisManagedConnection managedConnection) {
		this.managedConnection = managedConnection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Connection#close()
	 */
	public void close() throws ResourceException {
		this.managedConnection.close(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Connection#createInteraction()
	 */
	public Interaction createInteraction() throws ResourceException {
		EisInteraction inter = new EisInteraction(this);
		return inter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Connection#getLocalTransaction()
	 */
	public LocalTransaction getLocalTransaction() throws ResourceException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Connection#getMetaData()
	 */
	public ConnectionMetaData getMetaData() throws ResourceException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Connection#getResultSetInfo()
	 */
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		return null;
	}

	public Record execute(Record input) throws ResourceException {
		log.info("Record execute (Record)");
		return managedConnection.execute(input);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.codecompany.rysys.core.jca.eis.IEisConnection#execute(java.lang.String)
	 */
	public Serializable execute(Serializable command) throws ConnectionException {
		return managedConnection.execute(command);
	}
	
	public String toString() {
		return "[" + uuid.toString() + "]";
	}
}
