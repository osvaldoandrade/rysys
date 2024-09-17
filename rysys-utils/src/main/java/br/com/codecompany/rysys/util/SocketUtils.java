/**
 * Utiliza API para JVM 1.2.X/1.3.X
 */

package br.com.codecompany.rysys.util;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *<code>Classe com metodos estaticos de uso geral.</code>
 */
public final class SocketUtils {
	
	private static final Logger log = LoggerFactory.getLogger(SocketUtils.class);
	/**
	 * Obtem detalhes do socket informado.
	 */
	public static final String getSocketDetails(Socket socket, String hostname,	int port) {
		Map<String, String> map = new LinkedHashMap<String, String>();

		if (!isConnected(socket)) {
			map.put("target.host", hostname + ":" + port);
			map.put("source.host", "unknown");
			map.put("tcp.is.connected", "false");
		} else {
			String localhost = "";
			int localport = socket.getLocalPort();

			InetAddress inet = socket.getLocalAddress();
			if (inet != null) {
				localhost = inet.getHostAddress();
			}

			String sTimeout = "";
			try {
				sTimeout = "" + socket.getSoTimeout();
			} catch (Exception e) {
			}

			String sLinger = "" + getTcpSoLinger(socket);
			
			String sSendBufferSize = "";
			try {
				sSendBufferSize = "" + socket.getSendBufferSize();
			} catch (Exception e) {
				
			}

			String sReceiveBufferSize = "";
			try {
				sReceiveBufferSize = "" + socket.getReceiveBufferSize();
			} catch (Exception e) {
				
			}

			map.put("target.host", hostname + ":" + port);
			map.put("source.host", localhost + ":" + localport);
			map.put("tcp.delay", "" + getTcpDelay(socket));
			map.put("tcp.socket.timeout", sTimeout);
			map.put("tcp.socket.linger", "" + sLinger);
			map.put("tcp.socket.send.buffer.size", "" + sSendBufferSize);
			map.put("tcp.socket.receive.buffer.size", "" + sReceiveBufferSize);
			map.put("tcp.is.connected", "true");
		}
		return ToStringUtils.toString(map);
	}

	/**
	 * Exibe os detalhes do socket a ser fechado.
	 */
	public static final boolean getTcpDelay(Socket socket) {
		if (isConnected(socket) == false)
			return false;
		//
		boolean bTcpDelay = false;
		//            
		try {
			bTcpDelay = socket.getTcpNoDelay();
		} catch (Exception e) {
		}
		//
		return bTcpDelay;
	}

	/**
	 * Obtem parametro linger do socket.
	 */
	public static final int getTcpSoLinger(Socket socket) {
		int iLinger = -1;
		if (isConnected(socket) == false)
			return iLinger;
		//
		try {
			iLinger = socket.getSoLinger();
		} catch (Exception e) {
			iLinger = -1;
		}
		//            
		return iLinger;
	}

	/**
	 * Verifica se o Socket informado está conectado (JVM 1.4.X).
	 */
	public static final boolean isConnected(Socket socket) {
		return (socket != null && socket.getInetAddress() != null);
	}
	
	public static final String getHostName() {
		String hostName = "localhost";
		
		try {
	        InetAddress addr = InetAddress.getLocalHost();    
	        hostName = addr.getHostName();
	    } catch (UnknownHostException e) {
	    	log.error("Error getting host name");
	    }
		
		return hostName;
	}
}
