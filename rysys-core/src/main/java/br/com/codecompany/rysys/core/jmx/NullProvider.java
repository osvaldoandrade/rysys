package br.com.codecompany.rysys.core.jmx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// A provider that does nothing...
public class NullProvider implements MonitoringProvider {

	private Map<String, Long> successPerFunction = new HashMap<String, Long>();
	private Map<String, Serializable> summary = new HashMap<String, Serializable>();
	private Map<String, Double> avgResponseTimePerFunction = new HashMap<String, Double>();
	private Map<String, Long> errorsPerFunction = new HashMap<String, Long>();
	private String[] functionNames = new String[]{};
	private Map<Date, Double> responseTimeHistory = new HashMap<Date, Double>();
	private Date historyBeginingTime = new Date();
	private Map<Date, List<Double>> dailyActivity = new HashMap<Date, List<Double>>();
	private List<Date> dailyErrors = new ArrayList<Date>();
	private List<Map<String, Object>> latestByFunction = new ArrayList<Map<String, Object>>();
	
	public double avgResponseTime() {
		return 0;
	}

	public Map<String, Double> avgResponseTimePerFunction() {
		return avgResponseTimePerFunction;
	}

	public Map<String, Long> errorsPerFunction(int limit) {
		return errorsPerFunction;
	}

	public String[] functionNames() {
		return functionNames;
	}

	public Date getHistoryBeginingTime() {
		return historyBeginingTime;
	}

	public void insertError(String sourceHost, String targetHost,
			String functionName, String request) {

	}

	public void insertSuccess(String sourceHost, String targetHost,
			String functionName, float processingTime, String request, String response) {

	}

	public void reset() {

	}

	public Map<Date, Double> responseTimeHistory(String functionName) {
		return responseTimeHistory;
	}

	public void setHistoryBeginingTime(Date historyBeginingTime) {

	}

	public Map<String, Long> successPerFunction(int limit) {
		return successPerFunction; 
	}
	
	public Map<String, Serializable> summary() {
		return summary;
	}

	public long totalErrors() {
		return 0;
	}

	public long totalSuccess() {
		return 0;
	}

	public Map<Date, List<Double>> getDailyActivity(String functionName, Date day) {
		return dailyActivity;
	}
	
	public List<Date> getDailyErrors(String functionName, Date day) {
		return dailyErrors;
	}

	public List<Map<String, Object>> latestByFunction(String functionName) {
		return latestByFunction;
	}
}
