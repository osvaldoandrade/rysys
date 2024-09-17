package br.com.codecompany.rysys.core.jmx;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jmanage.easymbean.annotations.ManagedConstructor;
import org.jmanage.easymbean.annotations.ManagedOperation;
import org.jmanage.easymbean.annotations.ManagedResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedResource(name="AdapterMBeanProxy", displayName="Rysys Adapter Manager")
public class AdapterMBeanProxy implements MonitoringProvider {
	
	private static final Logger log = LoggerFactory.getLogger(AdapterMBeanProxy.class);
	
	private MonitoringProvider provider;
	
	// singleton
	private static AdapterMBeanProxy INSTANCE = null;
	
	public static AdapterMBeanProxy getInstance() {
		return getInstance(null);
	}
	
	public synchronized static AdapterMBeanProxy getInstance(MonitoringProvider provider) {
		if (INSTANCE == null) {
			INSTANCE = new AdapterMBeanProxy();
			INSTANCE.provider = new NullProvider();
		}
		
		if (provider != null) {			
			INSTANCE.provider = provider;			
		}
		
		log.info("MBean provider is " + INSTANCE.provider.getClass().getName());
		
		return INSTANCE;
	}	
	
	@ManagedConstructor(name = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy",
			description = "No argument constructor")
	private AdapterMBeanProxy() {
		
	}
	
	@ManagedOperation(name = "errorsPerFunction", 
			displayName = "Errors per function", 
			presentationString = "Errors per function", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Errors per function",
            currencyTimeLimit= "-1")
	public Map<String, Long> errorsPerFunction(int limit) {
        log.debug("errorsPerFunction invoked");
		return provider.errorsPerFunction(limit);
	}
	
	@ManagedOperation(name = "successPerFunction", 
			displayName = "Success per function", 
			presentationString = "Success per function", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Success per function",
            currencyTimeLimit="-1")
	public Map<String, Long> successPerFunction(int limit) {
        log.debug("successPerFunction invoked");
		return provider.successPerFunction(limit);
	}	
	
	@ManagedOperation(name = "avgResponseTimePerFunction", 
			displayName = "Average response time per function", 
			presentationString = "Average response time per function", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Average response time per function",
            currencyTimeLimit="-1")
	public Map<String, Double> avgResponseTimePerFunction() {
		return provider.avgResponseTimePerFunction();
	}

	@ManagedOperation(name = "functionNames", 
			displayName = "Functions' names", 
			presentationString = "Functions' names", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Functions' names",
            currencyTimeLimit="-1")	
	public String[] functionNames() {
		return provider.functionNames();
	}
		
	@ManagedOperation(name = "responseTimeHistory", 
			displayName = "Response time history of a function", 
			presentationString = "Response time history of a function", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Response time history of a function",
            currencyTimeLimit="-1")	
	public Map<Date, Double> responseTimeHistory(String functionName) {
		return provider.responseTimeHistory(functionName);
	}
	
	@ManagedOperation(name = "totalErrors", 
			displayName = "Total errors", 
			presentationString = "Total errors", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Total errors",
            currencyTimeLimit="-1")
	public long totalErrors() {
		return provider.totalErrors();
	}
	
	@ManagedOperation(name = "totalSuccess", 
			displayName = "Total success", 
			presentationString = "Total success", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Total success",
            currencyTimeLimit="-1")
	public long totalSuccess() {
		return provider.totalSuccess();
	}	
	
	@ManagedOperation(name = "avgResponseTime", 
			displayName = "Average response time", 
			presentationString = "Average response time", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Average response time",
            currencyTimeLimit="-1")
	public double avgResponseTime() {
		return provider.avgResponseTime();
	}

	@ManagedOperation(name = "reset", 
			displayName = "Reset adapter history", 
			presentationString = "Reset adapter history", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Reset adapter history",
            currencyTimeLimit="-1")
	public void reset() {
		provider.reset();
		log.info("Adapter history reset!");
	}
	
	@ManagedOperation(name = "summary", 
			displayName = "Execution summary", 
			presentationString = "Execution summary", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Execution summary",
            currencyTimeLimit="-1")
	public Map<String, Serializable> summary() {
		return provider.summary();
	}
	
	@ManagedOperation(name = "getDailyActivity", 
			displayName = "Daily activity of a function", 
			presentationString = "Daily activity of a function", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Daily activity of a function",
            currencyTimeLimit="-1")	
	public Map<Date, List<Double>> getDailyActivity(String functionName, Date day) {
		return provider.getDailyActivity(functionName, day);
	}
	
	@ManagedOperation(name = "getDailyErrors", 
			displayName = "Daily errors of a function", 
			presentationString = "Daily errors of a function", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Daily errors of a function",
            currencyTimeLimit="-1")		
	public List<Date> getDailyErrors(String functionName, Date day) {
		return provider.getDailyErrors(functionName, day);
	}	

	@ManagedOperation(name = "getHistoryBeginingTime", 
			displayName = "Get current history size", 
			presentationString = "Get current history begining time", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Get current history begining time",
            currencyTimeLimit="-1")	
	public Date getHistoryBeginingTime() {
		return provider.getHistoryBeginingTime();
	}
	
	@ManagedOperation(name = "setHistoryBeginingTime", 
			displayName = "Set current history size", 
			presentationString = "Set current history begining time", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Set current history begining time",
            currencyTimeLimit="-1")		
	public void setHistoryBeginingTime(Date historyBeginingTime) {
		provider.setHistoryBeginingTime(historyBeginingTime);
	}	
	
	@ManagedOperation(name = "insertError", 
			displayName = "Insert function execution error data", 
			presentationString = "Insert function execution error data", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Insert function execution error data",			
            currencyTimeLimit="-1")
	public void insertError(String sourceHost, String targetHost, 
			String functionName, String request) {
		provider.insertError(sourceHost, targetHost, functionName, request);
	}

	@ManagedOperation(name = "insertSuccess", 
			displayName = "Insert function execution success data", 
			presentationString = "Insert function execution success data", 
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy", 
			description = "Insert function execution success data",			
            currencyTimeLimit="-1")	
	public void insertSuccess(String sourceHost, String targetHost, 
			String functionName, float processingTime, String request, String response) {
		provider.insertSuccess(sourceHost, targetHost, functionName, 
				processingTime, request, response);
	}

	@ManagedOperation(name = "latestByFunction",
			displayName = "Retrieve latest 50 transaction per function name",
			presentationString = "Retrieve latest 50 transaction per function name",
			targetClass = "br.com.codecompany.rysys.core.jmx.AdapterMBeanProxy",
			description = "Retrieve latest 50 transaction per function name",
            currencyTimeLimit="-1")	
	public List<Map<String, Object>> latestByFunction(String functionName) {
		return provider.latestByFunction(functionName);
	}
}
