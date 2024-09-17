/*
 ** Copyright 2006-2007 the original author or authors.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *	
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA. 
 */
package br.com.codecompany.rysys.core.jca.eis;

import javax.resource.ResourceException;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.LocalTransactionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.driver.ConnectionDriver;
import br.com.codecompany.rysys.core.jca.eis.transaction.BeginTransaction;
import br.com.codecompany.rysys.core.jca.eis.transaction.CommitTransaction;
import br.com.codecompany.rysys.core.jca.eis.transaction.RollbackTransaction;

public class EisLocalTransaction implements LocalTransaction {

	private static final Logger log = LoggerFactory.getLogger(EisLocalTransaction.class);
    private EisManagedConnection managedConnection = null;
    private ConnectionDriver conClient = null;

    public EisLocalTransaction() {
    }

    public EisLocalTransaction(EisManagedConnection mc) {
        managedConnection = mc;
        conClient = mc.getAdapter();
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.resource.spi.LocalTransaction#begin()
     */
    public void begin() throws ResourceException {
        log.debug("Starting the local transaction");
        try {
            new BeginTransaction().execute(conClient);
            managedConnection.sendTxStartedEvent(managedConnection.getConnection());

        } catch (Exception ex) {
            log.error("Error starting the local transaction", ex);
            throw new LocalTransactionException(ex);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.resource.spi.LocalTransaction#commit()
     */
    public void commit() throws ResourceException {
        log.debug("Committing the local transaction");
        try {
            new CommitTransaction().execute(conClient);
            managedConnection.sendTxCommittedEvent(managedConnection.getConnection());

        } catch (Exception ex) {
            log.error("Error committing the local transaction", ex);
            throw new LocalTransactionException(ex);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.resource.spi.LocalTransaction#rollback()
     */
    public void rollback() throws ResourceException {

        log.debug("Rolling back the local transaction");
        try {
            new RollbackTransaction().execute(conClient);
            managedConnection.sendTxRolledbackEvent(managedConnection.getConnection());

        } catch (Exception ex) {
            log.error("Error rolling back the local transaction", ex);
            throw new LocalTransactionException(ex);
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
