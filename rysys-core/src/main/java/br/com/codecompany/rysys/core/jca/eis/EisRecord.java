/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the DSoft Technologies, LLC License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.dsofttechnologies.com/licenses/LICENSE-1.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.codecompany.rysys.core.jca.eis;

import javax.resource.cci.Record;

/**
 * @author Sadi Melbouci
 * 
 */
public class EisRecord implements Record {
	String recordName;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

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
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.cci.Record#setRecordName(java.lang.String)
	 */
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.cci.Record#setRecordShortDescription(java.lang.String)
	 */
	public void setRecordShortDescription(String arg0) {

	}

}
