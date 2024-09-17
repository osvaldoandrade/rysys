package br.com.codecompany.rysys.core.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jmanage.easymbean.EasyMBean;

import br.com.codecompany.rysys.core.jmx.database.DatabaseProvider;

public class AdapterManagement {

	private static final Logger log = LoggerFactory.getLogger(AdapterManagement.class);
	private MonitoringProvider provider;
	
	public AdapterManagement(String monitoringDataSource) {
		if (monitoringDataSource == null || "".equals(monitoringDataSource.trim())) {
			provider = new NullProvider();
			log.warn("No JMX datasource informed, monitoring disabled");
		}
		else {
			provider = new DatabaseProvider(monitoringDataSource);
		}
	}

	/**
	 * Register the ModelMBean in the MBeanServer using the provided ObjectName
	 * String.
	 * 
	 * @param objectNameString
	 *            ObjectName of the registered ModelMBean.
	 */
	private void registerModelMBean(final String objectNameString) {
		final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		AdapterMBeanProxy mbean = AdapterMBeanProxy.getInstance(provider);
		try {
			final ObjectName objectName = new ObjectName(objectNameString);
			EasyMBean.getMBean(mbean, objectName, mbs);
		} catch (MalformedObjectNameException e) {
			log.error("Error trying to generate ObjectName based on "
					+ objectNameString, e);
		}
	}

	/**
	 * Create a ModelMBean in the raw and register it with the MBeanServer.
	 */
	public void createAndRegisterEasyMBean() {
		final String easyModelMBeanObjectNameString = "rysys:type=Adapter";
		registerModelMBean(easyModelMBeanObjectNameString);
	}
}
