package br.com.codecompany.rysys.core.jca.eis;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.InvalidPropertyException;
import javax.resource.spi.ResourceAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EisActivationSpec implements ActivationSpec {
	
	private static final Logger log = LoggerFactory.getLogger(EisActivationSpec.class);

	private ResourceAdapter resourceAdapter = null;

	public EisActivationSpec() {
		log.info("EisActivationSpec: Activating a Connection");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.spi.ActivationSpec#validate()
	 */
	public void validate() throws InvalidPropertyException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.resource.spi.ResourceAdapterAssociation#getResourceAdapter()
	 */
	public ResourceAdapter getResourceAdapter() {
		return resourceAdapter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.resource.spi.ResourceAdapterAssociation#setResourceAdapter(javax
	 * .resource.spi.ResourceAdapter)
	 */
	public void setResourceAdapter(ResourceAdapter resourceAdapter)
			throws ResourceException {
		this.resourceAdapter = resourceAdapter;
	}

	public class MessageListener extends Thread {
		public MessageListener() {
			start();
		}

		/**
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			try {
				EisXAResource eisXAResource = ((EisResourceAdapter) resourceAdapter)
						.getEisXAResource();
				System.out
						.println("MessageListenerThread/run " + eisXAResource);

				// String message = sshClient.receive();

				// eisXAResource.sendReceivedMessageToMDB(message);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
