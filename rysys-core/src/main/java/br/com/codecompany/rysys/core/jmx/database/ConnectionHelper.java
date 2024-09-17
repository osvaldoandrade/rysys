package br.com.codecompany.rysys.core.jmx.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ConnectionHelper {

	private static final Logger log = LoggerFactory.getLogger(ConnectionHelper.class);
	
	private static ConnectionHelper helper = new ConnectionHelper();
	
	private DataSource datasource;
	
	public static synchronized Connection getConnection(String jndi) {
		Connection conn = null;
		try {
			// JNDI datasource not configured yet
			if (helper.datasource == null) {
				log.debug("Retrieving JNDI datasource...");
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup(jndi);
				helper.datasource = ds;
				conn = helper.datasource.getConnection();
				log.debug("Done!");
			}
			// JNDI datasource already configured
			else {
				log.debug("Using an existing JNDI datasource");
				conn = helper.datasource.getConnection(); 
			}
		} catch (NamingException e) {
			log.error("Error looking up context", e);
		} catch (SQLException e) {
			log.error("Error configuring datasource", e);
		}
		return conn;
	}
}
