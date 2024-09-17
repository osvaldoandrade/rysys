package br.com.codecompany.rysys.core.test.jce;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.codecompany.rysys.core.balancing.Server;import br.com.codecompany.rysys.core.jce.InvalidEncrypterStrategyException;import br.com.codecompany.rysys.core.jce.InvalidPasswordFormatException;



public class TestEncrypterHelper {
	
	private Server server;
	
	@Before
	public void setUp() {
		server = new Server();
	}
	
	@Test
	public void decryptUsingDES() {
		server.setPassword("{DES}ReYiutX2drQ=");
		Assert.assertEquals("rysys", server.getPassword());
	}
	
	@Test
	public void decryptUsingPLAIN() {
		server.setPassword("{PLAIN}rysys");
		Assert.assertEquals("rysys", server.getPassword());
	}
	
	@Test
	public void decryptUsingNoStrategy() {
		server.setPassword("rysys");
		Assert.assertEquals("rysys", server.getPassword());
	}
	
	@Test
	public void decryptUsingSpaceAsStrategy() {
		server.setPassword("{ }rysys");
		Assert.assertEquals("rysys", server.getPassword());
	}	
	
	@Test(expected=InvalidPasswordFormatException.class)
	public void decryptUsingEmptyStrategy() {
		server.setPassword("{}rysys");
	}
	
	@Test(expected=InvalidEncrypterStrategyException.class)
	public void decryptUsingInvalidStrategy() {
		server.setPassword("{ABC}rysys");
	}	
}
