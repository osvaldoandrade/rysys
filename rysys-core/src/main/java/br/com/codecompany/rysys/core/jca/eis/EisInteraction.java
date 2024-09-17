/*
 * Copyright 2006-2007 the original author or authors.
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
import javax.resource.cci.Connection;
import javax.resource.cci.Interaction;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qsadmel
 * 
 */
public class EisInteraction implements Interaction {
	private static final Logger log = LoggerFactory.getLogger(EisInteraction.class);

	EisConnection connection = null;

	public EisInteraction(Connection connection) {
		this.connection = (EisConnection) connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Interaction#clearWarnings()
	 */
	public void clearWarnings() throws ResourceException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Interaction#close()
	 */
	public void close() throws ResourceException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.cci.Interaction#execute(javax.resource.cci.InteractionSpec
	 * , javax.resource.cci.Record)
	 */
	public Record execute(InteractionSpec interactionSpec, Record record)
			throws ResourceException {
		log.info("Record execute(InteractionSpec, Record)");
		log.info("executing: " + record.getRecordName());
		return connection.execute(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.cci.Interaction#execute(javax.resource.cci.InteractionSpec
	 * , javax.resource.cci.Record, javax.resource.cci.Record)
	 */
	public boolean execute(InteractionSpec interactionSpec, Record record1,
			Record record2) throws ResourceException {

		EisRecord eisRecord = new EisRecord();
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Interaction#getConnection()
	 */
	public Connection getConnection() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Interaction#getWarnings()
	 */
	public ResourceWarning getWarnings() throws ResourceException {
		return null;
	}

}
