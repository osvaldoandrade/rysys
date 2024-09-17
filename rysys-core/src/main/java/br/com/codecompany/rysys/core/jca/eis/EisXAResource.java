package br.com.codecompany.rysys.core.jca.eis;

import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.driver.ConnectionDriver;
import br.com.codecompany.rysys.core.driver.ConnectionException;
import br.com.codecompany.rysys.core.jca.eis.transaction.BeginTransaction;
import br.com.codecompany.rysys.core.jca.eis.transaction.CommitTransaction;
import br.com.codecompany.rysys.core.jca.eis.transaction.RollbackTransaction;

public class EisXAResource implements XAResource {

	private static final Logger log = LoggerFactory.getLogger(EisXAResource.class);

    private EisManagedConnection managedConnection = null;
    private int transactionTimeout = 0;
    private Xid txId = null;
    private ConnectionDriver conClient = null;

    public EisXAResource() {
    }

    public EisXAResource(EisManagedConnection cm) {
        managedConnection = cm;
        conClient = cm.getAdapter();
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.transaction.xa.XAResource#commit(javax.transaction.xa.Xid,
     * boolean)
     */
    public void commit(Xid xid, boolean onePhase) throws XAException {
        log.debug("Commiting EIS Transaction");
        if (onePhase) {
            log.debug("Performing One Phase Commit");
        } else {
            log.debug("Performing Two Phase Commit");
        }

        try {
            new CommitTransaction().execute(conClient);

            managedConnection.sendTxCommittedEvent(managedConnection.getConnection());

        } catch (ConnectionException ex) {
            log.error("Error commiting the XA transaction", ex);
            //TODO: Specialize the exception to be thrown. In other words it should handle the error and associate it according to the XAException constants.
            throw new XAException(XAException.XAER_RMFAIL);
        }


    }

    /*
     * (non-Javadoc)
     *
     * @see javax.transaction.xa.XAResource#end(javax.transaction.xa.Xid, int)
     */
    public void end(Xid xid, int flags) throws XAException {
        log.debug("Ending EIS Transaction");

        switch (flags) {
            case TMSUCCESS:
                log.debug("Transaction Ending Successfully");
                break;
            case TMFAIL:
                log.debug("Transaction Ending Failed");
                break;
            case TMSUSPEND:
                log.debug("Transaction is suspended");
                break;
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.transaction.xa.XAResource#forget(javax.transaction.xa.Xid)
     */
    public void forget(Xid arg0) throws XAException {
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.transaction.xa.XAResource#getTransactionTimeout()
     */
    public int getTransactionTimeout() throws XAException {
        return transactionTimeout;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.transaction.xa.XAResource#isSameRM(javax.transaction.xa.XAResource)
     */
    public boolean isSameRM(XAResource rm) throws XAException {
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.transaction.xa.XAResource#prepare(javax.transaction.xa.Xid)
     */
    public int prepare(Xid arg0) throws XAException {
        return XAResource.XA_OK;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.transaction.xa.XAResource#recover(int)
     */
    public Xid[] recover(int flag) throws XAException {
        return new Xid[]{txId};
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.transaction.xa.XAResource#rollback(javax.transaction.xa.Xid)
     */
    public void rollback(Xid xid) throws XAException {
        log.debug("Rolling back the XA transaction: " + xid);
        try {
            new RollbackTransaction().execute(conClient);

            managedConnection.sendTxRolledbackEvent(managedConnection.getConnection());

        } catch (ConnectionException ex) {
            log.error("Error rolling back the XA transaction", ex);
            //TODO: Specialize the exception to be thrown. In other words it should handle the error and associate it according to the XAException constants.
            throw new XAException(XAException.XAER_RMFAIL);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.transaction.xa.XAResource#setTransactionTimeout(int)
     */
    public boolean setTransactionTimeout(int seconds) throws XAException {
        transactionTimeout = seconds;
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.transaction.xa.XAResource#start(javax.transaction.xa.Xid, int)
     *
     */
    public void start(Xid xid, int flags) throws XAException {
        log.debug("Starting the XA transaction: " + xid);
        try {
            new BeginTransaction().execute(conClient);

            managedConnection.sendTxStartedEvent(managedConnection.getConnection());
            if (TMRESUME != flags) {
                txId = xid;
            }

        } catch (ConnectionException ex) {
            log.error("Error starting the XA transaction", ex);
            //TODO: Specialize the exception to be thrown. In other words it should handle the error and associate it according to the XAException constants.
            throw new XAException(XAException.XAER_RMFAIL);
        }

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
}
