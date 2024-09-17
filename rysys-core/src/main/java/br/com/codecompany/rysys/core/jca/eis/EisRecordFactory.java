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
import javax.resource.cci.IndexedRecord;
import javax.resource.cci.MappedRecord;
import javax.resource.cci.RecordFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sadi Melbouci
 * 
 */
public class EisRecordFactory implements RecordFactory {
	private static final Logger log = LoggerFactory.getLogger(EisRecordFactory.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.cci.RecordFactory#createIndexedRecord(java.lang.String)
	 */
	public IndexedRecord createIndexedRecord(String recordName)
			throws ResourceException {
		IndexedRecord ir = new EisIndexedRecord();
		ir.setRecordName(recordName);
		return ir;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.cci.RecordFactory#createMappedRecord(java.lang.String)
	 */
	public MappedRecord createMappedRecord(String recordName)
			throws ResourceException {
		log.info("Creating Mapped Record with: " + recordName);
		EisMappedRecord mr = new EisMappedRecord();
		mr.setRecordName(recordName);
		return mr;
	}

}
