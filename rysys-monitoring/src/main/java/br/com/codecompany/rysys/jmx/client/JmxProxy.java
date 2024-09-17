package br.com.codecompany.rysys.jmx.client;

import static br.com.codecompany.rysys.jmx.client.Constants.JMX_BEAN;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.jmx.MonitoringProvider;

// JMX configuration on server:
// -Dcom.sun.management.jmxremote 
// -Dcom.sun.management.jmxremote.port=8686 
// -Dcom.sun.management.jmxremote.ssl=false 
// -Dcom.sun.management.jmxremote.authenticate=false 
// -Djava.rmi.server.hostname=localhost
public class JmxProxy implements MonitoringProvider, Serializable {

	public static final String ERRORS = "Erros";
	public static final String SUCCESS = "Sucessos";
	private static final long serialVersionUID = 5843688848471828015L;
	private static final Logger log = LoggerFactory.getLogger(JmxProxy.class);
	private static JmxProxy INSTANCE = null;
	private JMXConnector jmxc;
	private MBeanServerConnection mbsc;
	private ObjectName mbeanName;

	public static JmxProxy getInstance(String jmxUrl, Map<String, ?> env) throws Exception {
		if (INSTANCE == null) {
			INSTANCE = new JmxProxy(jmxUrl, env);
		}
		return INSTANCE;
	}

	private JmxProxy(String jmxUrl, Map<String, ?> env) throws Exception {
		JMXServiceURL url = new JMXServiceURL(jmxUrl);
		jmxc = JMXConnectorFactory.connect(url, env);
		mbsc = jmxc.getMBeanServerConnection();
		mbeanName = new ObjectName(JMX_BEAN);
	}

	public Map<String, Long[]> successErrosPerFunction(int limit) {
		log.debug("Invoking 'successErrosPerFunction'...");

		Map<String, Long> successPerFunction = successPerFunction(limit);
		Map<String, Long> errosPerFunction = errorsPerFunction(limit);

		// <funcao, [sucessos,erros]>
		Map<String, Long[]> resultData = new HashMap<String, Long[]>();

		// percorre as execucoes com sucesso
		for (Entry<String, Long> entry : successPerFunction.entrySet()) {
			String function = entry.getKey();
			Long success = entry.getValue();

			// total de erros dessa funcao
			Long errors = errosPerFunction.get(function);

			// essa funcao so teve sucessos
			if (errors == null) {
				errors = new Long(0);
			}

			// remove para nao processar novamente quando
			// o mapa de erros for iterado
			errosPerFunction.remove(function);
			resultData.put(function, new Long[]{success, errors});
		}

		// percorre os erros, pois pode existir uma funcao na qual
		// todas as execucoes deram erro
		for (Entry<String, Long> entry : errosPerFunction.entrySet()) {
			String function = entry.getKey();
			Long errors = entry.getValue();
			resultData.put(function, new Long[]{0L, errors});
		}

		log.debug("Done!");

		return topActive(resultData, limit);
	}

	// retorna as X funcoes mais ativas (limite == 0 significa sem limite)
	private Map<String, Long[]> topActive(Map<String, Long[]> map, int limit) {
		Map<String, Long[]> top = new HashMap<String, Long[]>();
		// nao existe limite ou existem poucas funcoes
		if (limit <= 0 || map.size() <= limit) {
			top = map;
		} else {
			for (Entry<String, Long[]> entry : map.entrySet()) {
				// se o mapa ja foi totalmente populado				
				if (top.size() >= limit) {
					// execucoes dessa funcao
					Long[] current = entry.getValue();
					long total = current[0] + current[1];

					// seleciona a funcao com menos execucoes
					String leastKey = null;
					long leastValue = Long.MAX_VALUE;
					for (Entry<String, Long[]> entry2 : top.entrySet()) {
						Long[] array = entry2.getValue();
						long executions = array[0] + array[1];
						if (executions < leastValue) {
							leastKey = entry2.getKey();
							leastValue = executions;
						}
					}
					// substitui?
					if (total > leastValue) {
						// remove do mapa
						top.remove(leastKey);
						// adiciona a nova
						top.put(entry.getKey(), entry.getValue());
					} else {
						log.debug("Function {} not added to {} top list. "
								+ "The list already contains function {} with {} executions",
								new Object[]{entry.getKey(), limit, leastKey, leastValue});
					}
				} else {
					// adiciona
					top.put(entry.getKey(), entry.getValue());
				}
			}
		}
		return top;
	}

	public Map<String, Long> successErrosSummary() {
		log.debug("Invoking 'successErrosSummary'...");

		Map<String, Long> resultData = new HashMap<String, Long>();

		Long totalErrors = totalErrors();
		Long totalSuccess = totalSuccess();

		resultData.put(SUCCESS, totalSuccess);
		resultData.put(ERRORS, totalErrors);

		log.debug("Done!");

		return resultData;
	}

	public double avgResponseTime() {
		log.debug("Invoking 'avgResponseTime'...");

		double time = -1;
		try {
			time = (Double) mbsc.invoke(mbeanName, "avgResponseTime",
					null, null);
		} catch (Exception e) {
			log.error("Error invoking 'avgResponseTime' operation", e);
		}

		log.debug("Done!");

		return time;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Double> avgResponseTimePerFunction() {
		log.debug("Invoking 'avgResponseTimePerFunction'...");

		Map<String, Double> map = new HashMap<String, Double>();
		try {
			map = (Map<String, Double>) mbsc.invoke(mbeanName, "avgResponseTimePerFunction",
					null, null);
		} catch (Exception e) {
			log.error("Error invoking 'avgResponseTimePerFunction' operation", e);
		}

		log.debug("Done!");

		return map;
	}

	public Date getHistoryBeginingTime() {
		log.debug("Invoking 'getHistoryBeginingTime'...");

		Date history = new Date(0);
		try {
			history = (Date) mbsc.invoke(mbeanName, "getHistoryBeginingTime",
					null, null);
		} catch (Exception e) {
			log.error("Error invoking 'getHistoryBeginingTime' operation", e);
		}

		log.debug("Done!");

		return history;
	}

	public void setHistoryBeginingTime(Date historyBeginingTime) {
		log.debug("Invoking 'setHistoryBeginingTime'...");

		try {
			String[] signature = {Date.class.getName()};
			mbsc.invoke(mbeanName, "setHistoryBeginingTime",
					new Object[]{historyBeginingTime}, signature);
		} catch (Exception e) {
			log.error("Error invoking 'setHistoryBeginingTime' operation", e);
		}

		log.debug("Done!");
	}

	public void insertError(String sourceHost, String targetHost,
			String functionName, String request) {
		log.debug("Invoking 'insertError'...");
		try {
			String[] signature = {String.class.getName(),
				String.class.getName(), String.class.getName()};
			mbsc.invoke(mbeanName, "insertError",
					new Object[]{sourceHost, targetHost,
						functionName, request}, signature);
		} catch (Exception e) {
			log.error("Error invoking 'insertSuccess' operation", e);
		}
		log.debug("Done!");
	}

	public void insertSuccess(String sourceHost, String targetHost,
			String functionName, float processingTime, String request, String response) {
		log.debug("Invoking 'insertSuccess'...");
		try {
			String[] signature = {String.class.getName(),
				String.class.getName(), String.class.getName(),
				float.class.getName()};
			mbsc.invoke(mbeanName, "insertSuccess",
					new Object[]{sourceHost, targetHost, functionName,
						processingTime, request, response}, signature);
		} catch (Exception e) {
			log.error("Error invoking 'insertSuccess' operation", e);
		}
		log.debug("Done!");
	}

	public void reset() {
		log.debug("Invoking 'reset'...");
		try {
			mbsc.invoke(mbeanName, "reset", null, null);
		} catch (Exception e) {
			log.error("Error invoking 'reset' operation", e);
		}
		log.debug("Done!");
	}

	public String[] functionNames() {
		log.debug("Invoking 'functionNames'...");
		String[] result = new String[]{};
		try {
			result = (String[]) mbsc.invoke(mbeanName, "functionNames",
					null, null);
		} catch (Exception e) {
			log.error("Error invoking 'functionNames' operation", e);
		}
		log.debug("Done!");

		return result;
	}

	@SuppressWarnings("unchecked")
	public Map<Date, Double> responseTimeHistory(String functionName) {
		log.debug("Invoking 'responseTimeHistory'...");
		Map<Date, Double> map = new LinkedHashMap<Date, Double>();
		try {
			String[] signature = {String.class.getName()};
			map = (Map<Date, Double>) mbsc.invoke(mbeanName, "responseTimeHistory",
					new Object[]{functionName}, signature);
		} catch (Exception e) {
			log.error("Error invoking 'responseTimeHistory' operation", e);
		}
		log.debug("Done!");

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Long> successPerFunction(int limit) {
		log.debug("Invoking 'successPerFunction'...");
		Map<String, Long> map = new HashMap<String, Long>();
		try {
			String[] signature = {int.class.getName()};
			map = (Map<String, Long>) mbsc.invoke(mbeanName, "successPerFunction",
					new Object[]{limit}, signature);
		} catch (Exception e) {
			log.error("Error invoking 'successPerFunction' operation", e);
		}
		log.debug("Done!");

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Long> errorsPerFunction(int limit) {
		log.debug("Invoking 'errorsPerFunction'...");
		Map<String, Long> map = new HashMap<String, Long>();
		try {
			String[] signature = {int.class.getName()};
			map = (Map<String, Long>) mbsc.invoke(mbeanName, "errorsPerFunction",
					new Object[]{limit}, signature);
		} catch (Exception e) {
			log.error("Error invoking 'errorsPerFunction' operation", e);
		}
		log.debug("Done!");

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Serializable> summary() {
		log.debug("Invoking 'summary'...");
		Map<String, Serializable> map = new HashMap<String, Serializable>();
		try {
			map = (Map<String, Serializable>) mbsc.invoke(mbeanName, "summary",
					null, null);
		} catch (Exception e) {
			log.error("Error invoking 'summary' operation", e);
		}
		log.debug("Done!");

		// if the entries contain a list with only one element,
		// covert the list to Serializable
		if (map != null) {
			for (Entry<String, Serializable> entry : map.entrySet()) {
				Serializable s = entry.getValue();
				if (s instanceof Collection) {
					Collection c = (Collection) s;
					if (c.size() == 1) {
						map.put(entry.getKey(),
								(Serializable) c.iterator().next());
					}
				}
			}
		}

		return map;
	}

	public long totalErrors() {
		log.debug("Invoking 'totalErrors'...");
		long errors = -1;
		try {
			errors = (Long) mbsc.invoke(mbeanName, "totalErrors",
					null, null);
		} catch (Exception e) {
			log.error("Error invoking 'totalErrors' operation", e);
		}
		log.debug("Done!");

		return errors;
	}

	public long totalSuccess() {
		log.debug("Invoking 'totalSuccess'...");
		long success = -1;
		try {
			success = (Long) mbsc.invoke(mbeanName, "totalSuccess",
					null, null);
		} catch (Exception e) {
			log.error("Error invoking 'totalSuccess' operation", e);
		}
		log.debug("Done!");

		return success;
	}

	public void close() {
		try {
			if (jmxc != null) {
				jmxc.close();
			}
		} catch (IOException e) {
			log.error("Error closing JMX connector", e);
		}
	}

	@SuppressWarnings("unchecked")
	public Map<Date, List<Double>> getDailyActivity(String functionName, Date day) {
		log.debug("Invoking 'getDailyActivity'...");
		Map<Date, List<Double>> map = new HashMap<Date, List<Double>>();
		try {
			String[] signature = {String.class.getName(), Date.class.getName()};
			map = (Map<Date, List<Double>>) mbsc.invoke(mbeanName, "getDailyActivity",
					new Object[]{functionName, day}, signature);
		} catch (Exception e) {
			log.error("Error invoking 'getDailyActivity' operation", e);
		}
		log.debug("Done!");

		return map;
	}

	@SuppressWarnings("unchecked")
	public List<Date> getDailyErrors(String functionName, Date day) {
		log.debug("Invoking 'getDailyErrors'...");
		List<Date> list = new ArrayList<Date>();
		try {
			String[] signature = {String.class.getName(), Date.class.getName()};
			list = (List<Date>) mbsc.invoke(mbeanName, "getDailyErrors",
					new Object[]{functionName, day}, signature);
		} catch (Exception e) {
			log.error("Error invoking 'getDailyErrors' operation", e);
		}
		log.debug("Done!");

		return list;
	}

	public List<Map<String, Object>> latestByFunction(String functionName) {
		log.debug("Invoking 'latestByFunction'...");
		List<Map<String, Object>> result = null;

		try {
			String[] signature = {String.class.getName()};
			result = (List<Map<String, Object>>) mbsc.invoke(mbeanName, "latestByFunction", new Object[]{functionName}, signature);
		} catch (Exception e) {
			log.error("Error invoking 'latestByFunction' operation", e);
		}
		log.debug("Done!");

		return result;
	}
}
