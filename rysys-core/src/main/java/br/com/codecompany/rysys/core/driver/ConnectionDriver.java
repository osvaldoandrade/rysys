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

package br.com.codecompany.rysys.core.driver;

import java.io.Serializable;

public interface ConnectionDriver extends ConnectionProps {

    public static final String NO_BEGIN_TRANSACTION_COMMAND = null;
    public static final String NO_COMMIT_COMMAND = null;
    public static final String NO_ROLLBACK_COMMAND = null;

	/**
	 * This method executes a command on remote EIS system and return a result
	 * of the execution.
	 * 
	 * @param command
	 * @return String
	 */
	public Serializable execute(Serializable command) throws ConnectionException;

	/**
	 * This method connect to EIS
	 * 
	 */
	public void connect() throws ConnectionException;
	
	/**
	 * This method disconnect to EIS
	 */
	public void disconnect();

    public String getBeginTransactionCommand();

    public String getCommitCommand();

	public String getRollbackCommand(); 
}
