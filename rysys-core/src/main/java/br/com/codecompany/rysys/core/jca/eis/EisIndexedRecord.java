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

import java.util.Vector;

import javax.resource.cci.IndexedRecord;

/**
 * @author Sadi Melbouci
 * 
 */
public class EisIndexedRecord extends Vector implements IndexedRecord {

	String recordName = null;
	private String recordShortDescription;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Record#getRecordName()
	 */
	public String getRecordName() {
		return recordName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Record#getRecordShortDescription()
	 */
	public String getRecordShortDescription() {
		return recordShortDescription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Record#setRecordName(java.lang.String)
	 */
	public void setRecordName(String arg0) {
		recordName = arg0;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.cci.Record#setRecordShortDescription(java.lang.String)
	 */
	public void setRecordShortDescription(String arg0) {
		recordShortDescription = arg0;

	}

}
