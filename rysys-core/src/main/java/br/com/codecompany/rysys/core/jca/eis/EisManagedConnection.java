package br.com.codecompany.rysys.core.jca.eis;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.balancing.NoServerConfiguredException;
import br.com.codecompany.rysys.core.balancing.Server;
import br.com.codecompany.rysys.core.driver.ConnectionDriver;
import br.com.codecompany.rysys.core.driver.ConnectionException;
import br.com.codecompany.rysys.util.ToStringUtils;

public class EisManagedConnection implements ManagedConnection {

	private static final Logger log = LoggerFactory.getLogger(EisManagedConnection.class);

    private PrintWriter writer;
    private Subject subject = null;
    private EisRequestInfo info;
    private EisConnection connection = null;
    private ConnectionDriver conClient = null;
    private EisLocalTransaction tx = null;
    private EisXAResource xa = null;
    private Collection<ConnectionEventListener> listeners;

    public EisManagedConnection(Subject subject, ConnectionRequestInfo cri)
            throws ResourceException {

        this.subject = subject;
        this.info = (EisRequestInfo) cri;

        if (info.getDriver() == null) {
            throw new ResourceException("Driver is null");
        }

        try {
            Class<?> clazz = Class.forName(info.getDriver());
            conClient = (ConnectionDriver) clazz.newInstance();

            Server server = null;
            log.info("Retrieving server using strategy " + info.getStrategy().getName());
            while (true) {
                server = info.getStrategy().currentServer();
                if (server != null) {
                    if (!server.isHealthy(conClient)) {
                        info.getStrategy().removeServer(server);
                        log.info("Server " + server + " is not available and " +
                                "has been removed from servers' list");
                    } else {
                        info.setServer(server);
                        log.info("Current server: " + server);
                        break;
                    }
                } else {
                    throw new NoServerConfiguredException("Invalid server " + server);
                }
            }

            conClient.setHostname(info.getServer().getHostname());
            conClient.setPort(info.getServer().getPort());
            conClient.setUsername(info.getServer().getUsername());
            conClient.setPassword(info.getServer().getPassword());
            conClient.setTimeout(info.getServer().getTimeout());
            conClient.setPingFrequency(info.getServer().getPingFrequency());

            log.info("Adapter configured: " +
                    ToStringUtils.toString(conClient));

            conClient.connect();

            listeners = new ArrayList<ConnectionEventListener>();
        } catch (Exception e) {
            log.error("Could not create client", e);
            throw new ResourceException(e);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.resource.spi.ManagedConnection#addConnectionEventListener(javax
     * .resource.spi.ConnectionEventListener)
     */
    public void addConnectionEventListener(ConnectionEventListener listener) {
        listeners.add(listener);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.resource.spi.ManagedConnection#associateConnection(java.lang.Object
     * )
     */
    public void associateConnection(Object con) throws ResourceException {
        log.debug("Associating connection " + con);
        EisConnection handle = (EisConnection) con;
        if (handle.getManagedConnection() != this) {
            close(handle);
            connection = handle;
            connection.getManagedConnection().connection = handle;
            connection.setManagedConnection(this);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.resource.spi.ManagedConnection#cleanup()
     */
    public void cleanup() throws ResourceException {
		log.debug("Connection to EIS cleaned up: {}", connection);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.resource.spi.ManagedConnection#destroy()
     */
    public void destroy() throws ResourceException {
        log.info("Destroying connection to EIS: " + connection);
        if (conClient != null) {
            conClient.disconnect();
        }
        log.info("Connection succefully destroyed");
        connection = null;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.resource.spi.ManagedConnection#getConnection(javax.security.auth
     * .Subject, javax.resource.spi.ConnectionRequestInfo)
     */
    public Object getConnection(Subject subject, ConnectionRequestInfo info)
            throws ResourceException {
        log.info("Getting connection. Subject={}, Request info={}", subject, info);
        if (connection == null) {
            connection = new EisConnection(this);
        }
        return connection;
    }

    /**
     * @return the connection
     */
    public EisConnection getConnection() {
        return connection;
    }

    /**
     * @param connection
     *            the connection to set
     */
    public void setConnection(EisConnection connection) {
        this.connection = connection;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.resource.spi.ManagedConnection#getLocalTransaction()
     */
    public LocalTransaction getLocalTransaction() throws ResourceException {
        log.info("Getting Local Transaction");
        tx = new EisLocalTransaction(this);
        return tx;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.resource.spi.ManagedConnection#getLogWriter()
     */
    public PrintWriter getLogWriter() throws ResourceException {
        return writer;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.resource.spi.ManagedConnection#getMetaData()
     */
    public ManagedConnectionMetaData getMetaData() throws ResourceException {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.resource.spi.ManagedConnection#getXAResource()
     */
    public XAResource getXAResource() throws ResourceException {
        log.info("Getting XA Transaction");
        if (xa == null) {
            xa = new EisXAResource(this);
        }
        return xa;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.resource.spi.ManagedConnection#removeConnectionEventListener(javax
     * .resource.spi.ConnectionEventListener)
     */
    public void removeConnectionEventListener(ConnectionEventListener listener) {
        listeners.remove(listener);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.resource.spi.ManagedConnection#setLogWriter(java.io.PrintWriter)
     */
    public void setLogWriter(PrintWriter writer) throws ResourceException {
        this.writer = writer;
    }

    public boolean match(Subject subject, ConnectionRequestInfo requestInfo) {
        EisRequestInfo crInfo = (EisRequestInfo) requestInfo;
        boolean same = info.equals(crInfo);
        log.info("Matching Connections: {} x {}: [{}]", 
        		new Object[]{info, crInfo, same});
        return same;
    }

    public Record execute(Record input) throws ResourceException {
        log.info("Executing record, input={}", input);
        if (conClient == null) {
            throw new ResourceException("ManagedConnection was destroyed.");
        }
        EisRecord rec = null;
        try {
            Object result = conClient.execute(input.getRecordName());
            log.info("Result from Host: " + result);
            rec = new EisRecord();
            rec.setRecordName(String.valueOf(result));
        } catch (Exception e) {
            throw new ResourceException(handleException(e));
        }

        return rec;
    }

    public Serializable execute(Serializable command) throws ConnectionException {
        try {
            return conClient.execute(command);
        } catch (Exception e) {
            throw handleException(e);
        }
    }

    private ConnectionException handleException(Exception e) {
        log.error("Error executing command. Closing connection...");
        if (conClient != null) {
            conClient.disconnect();
        }
        log.error("Connection closed!");
        return new ConnectionException(e);
    }

    /**
     * Event Management
     *
     * @param con
     */
    public void close(EisConnection con) {
        log.info("Trying to close the connection " + con);
        if (this.connection == con) {
            sendClosedEvent(con);
        }
        log.info("Connection closed");
    }

    /**
     * Send event.
     *
     * @param event
     */
    private void sendEvent(ConnectionEvent event) {
        Iterator<ConnectionEventListener> iter = listeners.iterator();
        while (iter.hasNext()) {
            ConnectionEventListener listener = iter.next();

            switch (event.getId()) {
                case ConnectionEvent.CONNECTION_CLOSED:
                    listener.connectionClosed(event);
                    break;
                case ConnectionEvent.CONNECTION_ERROR_OCCURRED:
                    listener.connectionErrorOccurred(event);
                    break;
                case ConnectionEvent.LOCAL_TRANSACTION_COMMITTED:
                    listener.localTransactionCommitted(event);
                    break;
                case ConnectionEvent.LOCAL_TRANSACTION_ROLLEDBACK:
                    listener.localTransactionRolledback(event);
                    break;
                case ConnectionEvent.LOCAL_TRANSACTION_STARTED:
                    listener.localTransactionStarted(event);
                    break;
            }
        }
    }

    /**
     * Send event.
     *
     * @param type
     * @param handle
     * @param cause
     */
    private void sendEvent(int type, Object handle) {
        ConnectionEvent event = new ConnectionEvent(this, type);
        if (handle != null) {
            event.setConnectionHandle(handle);
        }
        sendEvent(event);
    }

    /**
     * Send connection closed event.
     *
     * @param handle
     */
    public void sendClosedEvent(EisConnection handle) {
        log.debug("Sending close event to " + handle);
        sendEvent(ConnectionEvent.CONNECTION_CLOSED, handle);
    }

    /**
     * Send connection error event.
     *
     * @param handle
     * @param cause
     */
    public void sendErrorEvent(EisConnection handle, Exception cause) {
        log.debug("Sending error event to " + handle);
        sendEvent(ConnectionEvent.CONNECTION_ERROR_OCCURRED, handle);
    }

    /**
     * Send transaction committed event.
     *
     * @param handle
     */
    public void sendTxCommittedEvent(EisConnection handle) {
        log.debug("Sending commit event to " + handle);
        sendEvent(ConnectionEvent.LOCAL_TRANSACTION_COMMITTED, handle);
    }

    /**
     * Send transaction rolledback event.
     *
     * @param handle
     */
    public void sendTxRolledbackEvent(EisConnection handle) {
        log.debug("Sending rollback event to " + handle);
        sendEvent(ConnectionEvent.LOCAL_TRANSACTION_ROLLEDBACK, handle);
    }

    /**
     * Send transaction started event.
     *
     * @param handle
     */
    public void sendTxStartedEvent(EisConnection handle) {
        log.debug("Sending begin event to " + handle);
        sendEvent(ConnectionEvent.LOCAL_TRANSACTION_STARTED, handle);
    }

    public ConnectionDriver getAdapter() {
        return conClient;
    }
}
