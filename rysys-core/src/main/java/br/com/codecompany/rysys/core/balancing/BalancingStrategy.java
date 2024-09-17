package br.com.codecompany.rysys.core.balancing;

import java.io.Serializable;


public interface BalancingStrategy extends Serializable {
	
	public static final String SINGLE_SERVER = "SINGLE_SERVER";
	public static final String ROUND_ROBIN = "ROUND_ROBIN";
	
	public Server currentServer();
	public Server serverInfo();
	public int serverCount();
	public void addServer(Server server);
	public void removeServer(Server server);
	public void configure(String file);
	public String getName();
}