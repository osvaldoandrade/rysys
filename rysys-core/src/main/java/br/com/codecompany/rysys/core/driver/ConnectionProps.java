package br.com.codecompany.rysys.core.driver;

public interface ConnectionProps {
	/**
	 * @return the hostname
	 */
	public String getHostname();

	/**
	 * @param hostname
	 *            the hostname to set
	 */
	public void setHostname(String hostname);

	/**
	 * @return the password
	 */
	public String getPassword();

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password);

	/**
	 * @return the port
	 */
	public Integer getPort();

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(Integer port);

	/**
	 * @return the username
	 */
	public String getUsername();

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username);

	/**
	 * @return the timeout
	 */
	public Integer getTimeout();

	/**
	 * @param timeout
	 *            the timeout to set
	 */
	public void setTimeout(Integer timeout);

	/**
	 * @return the frequency of ping
	 */
	public Integer getPingFrequency();

	/**
	 * @param pingFrequency
	 *            the frequency of ping to set
	 */	
	public void setPingFrequency(Integer pingFrequency);
}
