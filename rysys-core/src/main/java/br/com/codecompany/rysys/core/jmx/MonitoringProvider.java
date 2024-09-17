package br.com.codecompany.rysys.core.jmx;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MonitoringProvider {

	public static final String SUMMARY_LESS_EXECUTED_TIMES = "monitoring.summary.lessExecutedTimes";

	public static final String SUMMARY_LESS_EXECUTED_FUNCTION = "monitoring.summary.lessExecutedFunction";

	public static final String SUMMARY_MORE_EXECUTED_TIMES = "monitoring.summary.moreExecutedTimes";

	public static final String SUMMARY_MORE_EXECUTED_FUNCTION = "monitoring.summary.moreExecutedFunction";

	public static final String SUMMARY_SLOWEST_EXECUTED_TIME = "monitoring.summary.slowestExecutedTime";

	public static final String SUMMARY_SLOWEST_EXECUTED_FUNCTION = "monitoring.summary.slowestExecutedFunction";

	public static final String SUMMARY_FASTEST_EXECUTED_TIME = "monitoring.summary.fastestExecutedTime";

	public static final String SUMMARY_FASTEST_EXECUTED_FUNCTION = "monitoring.summary.fastestExecutedFunction";

	public static final String SUMMARY_AVG_RESPONSE_TIME = "monitoring.summary.avgResponseTime";

	public static final String SUMMARY_TOTAL_SUCCESS = "monitoring.summary.totalSuccess";

	public static final String SUMMARY_TOTAL_ERRORS = "monitoring.summary.totalErrors";

	public static final String TRANSACTION_STATUS = "monitoring.transaction.status";

	public static final String TRANSACTION_REQUEST = "monitoring.transaction.request";

	public static final String TRANSACTION_RESPONSE = "monitoring.transaction.response";

	public static final String TRANSACATION_PROCESSING_TIME = "monitoring.transaction.processing_time";

	public static final String TRANSACTION_INSERT_TIME = "monitoring.transaction.insert_time";

	public void insertSuccess(String sourceHost, String targetHost,
			String functionName, float processingTime, String request, String response);

	public void insertError(String sourceHost, String targetHost,
			String functionName, String request);

	public Map<String, Long> errorsPerFunction(int limit);

	public Map<String, Long> successPerFunction(int limit);

	public Map<String, Double> avgResponseTimePerFunction();

	public String[] functionNames();

	public Map<Date, Double> responseTimeHistory(String functionName);

	public long totalErrors();

	public long totalSuccess();

	public double avgResponseTime();

	public void reset();

	public Map<String, Serializable> summary();

	public void setHistoryBeginingTime(Date historyBeginingTime);

	public Date getHistoryBeginingTime();
	
	// date, execution times
	public Map<Date, List<Double>> getDailyActivity(String functionName, Date day);
	
	// datas dos erros
	public List<Date> getDailyErrors(String functionName, Date day);

	public List<Map<String, Object>> latestByFunction(String functionName);
}
