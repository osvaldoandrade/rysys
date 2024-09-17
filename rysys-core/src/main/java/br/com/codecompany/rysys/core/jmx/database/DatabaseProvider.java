package br.com.codecompany.rysys.core.jmx.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.jmx.MonitoringProvider;
import br.com.codecompany.rysys.util.DateUtils;

public class DatabaseProvider implements MonitoringProvider {

	private static final Logger log = LoggerFactory.getLogger(DatabaseProvider.class);
	public static final int ERROR_STATUS = 0;
	public static final int SUCCESS_STATUS = 1;
	public static final int ERROR_PROCESSING_TIME = -1;
	protected static final String DELETE_SQL = "DELETE FROM rysys_monitoring";
	protected static final String SUCCESS_ERROR_PER_FUNCTION_SQL = "SELECT function_name, "
			+ "COUNT(1) "
			+ "FROM rysys_monitoring "
			+ "WHERE status = ? "
			+ "AND insert_time >= ? "
			+ "GROUP BY function_name "
			+ "ORDER BY function_name";
	protected static final String TOTAL_ERROS_SQL = "SELECT COUNT(1) "
			+ "FROM rysys_monitoring "
			+ "WHERE status = " + ERROR_STATUS + " "
			+ "AND insert_time >= ?";
	// funcao menos executada (incluindo erros)
	protected static final String LESS_EXECUTED_FUNCTION_SQL = "SELECT function_name, "
			+ "COUNT(1) AS executions "
			+ "FROM rysys_monitoring "
			+ "WHERE insert_time >= ? "
			+ "GROUP BY function_name "
			+ "HAVING COUNT(1) = "
			+ "   (SELECT MIN(sub.executions) "
			+ "    FROM"
			+ "       (SELECT DISTINCT COUNT(1) AS executions "
			+ "        FROM rysys_monitoring "
			+ "		 WHERE insert_time >= ? "
			+ "        GROUP BY function_name) AS sub)";
	// funcao mais executada (incluindo erros)	
	protected static final String MORE_EXECUTED_FUNCTION_SQL = "SELECT function_name, "
			+ "COUNT(1) AS executions "
			+ "FROM rysys_monitoring "
			+ "WHERE insert_time >= ? "
			+ "GROUP BY function_name "
			+ "HAVING COUNT(1) = "
			+ "   (SELECT MAX(sub.executions) "
			+ "    FROM"
			+ "       (SELECT DISTINCT COUNT(1) AS executions "
			+ "        FROM rysys_monitoring "
			+ "	  	 WHERE insert_time >= ? "
			+ "        GROUP BY function_name) AS sub)";
	protected static final String FASTEST_EXECUTED_FUNCTION_SQL = "SELECT function_name, "
			+ "processing_time "
			+ "FROM rysys_monitoring "
			+ "WHERE processing_time = "
			+ "   (SELECT MIN(processing_time) "
			+ "    FROM rysys_monitoring "
			+ "    WHERE status = " + SUCCESS_STATUS + " "
			+ "    AND insert_time >= ?) "
			+ "ORDER BY function_name";
	protected static final String SLOWEST_EXECUTED_FUNCTION_SQL = "SELECT function_name, "
			+ "processing_time "
			+ "FROM rysys_monitoring "
			+ "WHERE processing_time = "
			+ "   (SELECT MAX(processing_time) "
			+ "    FROM rysys_monitoring "
			+ "    WHERE status = " + SUCCESS_STATUS + " "
			+ "    AND insert_time >= ?) "
			+ "ORDER BY function_name";
	protected static final String TOTAL_SUCCESS_SQL = "SELECT COUNT(1) "
			+ "FROM rysys_monitoring "
			+ "WHERE status = " + SUCCESS_STATUS + " "
			+ "AND insert_time >= ?";
	protected static final String AVG_RESPONSE_TIME_PER_FUNCTION_SQL = "SELECT function_name, "
			+ "AVG(processing_time) "
			+ "FROM rysys_monitoring "
			+ "WHERE status = " + SUCCESS_STATUS + " "
			+ "AND insert_time >= ? "
			+ "GROUP BY function_name "
			+ "ORDER BY function_name";
	protected static final String AVG_RESPONSE_TIME_SQL = "SELECT AVG(processing_time) "
			+ "FROM rysys_monitoring "
			+ "WHERE status = " + SUCCESS_STATUS + " "
			+ "AND insert_time >= ?";
	protected static final String INSERT_SQL = "INSERT "
			+ "INTO rysys_monitoring (insert_time, source_host, target_host, "
			+ "function_name, processing_time, status, request, response) "
			+ "VALUES (?,?,?,?,?,?,?,?)";
	protected static final String FUNCTION_HISTORY_SQL = "SELECT insert_time, "
			+ "processing_time "
			+ "FROM rysys_monitoring "
			+ "WHERE function_name = ? "
			+ "AND insert_time >= ? "
			+ "ORDER BY insert_time";
	protected static final String FUNCTION_NAMES_SQL = "SELECT DISTINCT function_name "
			+ "FROM rysys_monitoring "
			+ "WHERE insert_time >= ? "
			+ "ORDER BY function_name";
	protected static final String FUNCTION_DAILY_ACTIVITY_SQL = "SELECT insert_time, "
			+ "processing_time "
			+ "FROM rysys_monitoring "
			+ "WHERE function_name = ? "
			+ "AND insert_time BETWEEN ? AND ? "
			+ "AND status = " + SUCCESS_STATUS + " "
			+ "ORDER BY insert_time";
	protected static final String FUNCTION_DAILY_ERRORS_SQL = "SELECT insert_time "
			+ "FROM rysys_monitoring "
			+ "WHERE function_name = ? "
			+ "AND insert_time BETWEEN ? AND ? "
			+ "AND status = " + ERROR_STATUS + " "
			+ "ORDER BY insert_time";
	protected static final String LATEST_BY_FUNCTION_SQL = "SELECT status, "
			+ "request, "
			+ "response, "
			+ "processing_time, "
			+ "insert_time "
			+ "from rysys_monitoring "
			+ "where function_name = ? "
			+ "order by insert_time desc "
			+ "limit 50";
	private String datasource = null;
	// used to filter records by date
	private Date historyBeginingTime = null;
	// history start time
	private Timestamp historyBeginingTimeStamp = new Timestamp(System.currentTimeMillis());

	public DatabaseProvider(String datasource) {
		this.datasource = datasource;
		ConnectionHelper.getConnection(datasource);
	}

	public void insertError(String sourceHost, String targetHost,
			String functionName, String request) {
		insert(sourceHost, targetHost,
				functionName, ERROR_PROCESSING_TIME, ERROR_STATUS, request, null);
	}

	public void insertSuccess(String sourceHost, String targetHost,
			String functionName, float processingTime, String request, String response) {
		insert(sourceHost, targetHost,
				functionName, processingTime, SUCCESS_STATUS, request.trim(), response.trim());
	}

	private void insert(String sourceHost, String targetHost,
			String functionName, float processingTime, int status,
			String request, String response) {
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + INSERT_SQL);
			PreparedStatement insert = conn.prepareStatement(INSERT_SQL);
			insert.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			insert.setString(2, sourceHost);
			insert.setString(3, targetHost);
			insert.setString(4, functionName);
			insert.setFloat(5, processingTime);
			insert.setInt(6, status);
			insert.setString(7, request);
			insert.setString(8, response);
			insert.execute();
			insert.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error inserting record", e);
		}
	}

	public double avgResponseTime() {
		double avg = -1;
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + AVG_RESPONSE_TIME_SQL);
			PreparedStatement avgResponseTime = conn.prepareStatement(
					AVG_RESPONSE_TIME_SQL);
			avgResponseTime.setTimestamp(1, historyBeginingTimeStamp);
			ResultSet rs = avgResponseTime.executeQuery();
			if (rs.next()) {
				avg = rs.getDouble(1);
			}
			avgResponseTime.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
		return avg;
	}

	public String[] functionNames() {
		List<String> list = new ArrayList<String>();
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + FUNCTION_NAMES_SQL);
			PreparedStatement functionNames = conn.prepareStatement(
					FUNCTION_NAMES_SQL);
			functionNames.setTimestamp(1, historyBeginingTimeStamp);
			ResultSet rs = functionNames.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			functionNames.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
		return list.toArray(new String[list.size()]);
	}

	public Map<Date, Double> responseTimeHistory(String functionName) {
		Map<Date, Double> map = new LinkedHashMap<Date, Double>();
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + FUNCTION_HISTORY_SQL);
			PreparedStatement responseTimeHistory = conn.prepareStatement(
					FUNCTION_HISTORY_SQL);
			responseTimeHistory.setString(1, functionName);
			responseTimeHistory.setTimestamp(2, historyBeginingTimeStamp);
			ResultSet rs = responseTimeHistory.executeQuery();
			while (rs.next()) {
				map.put(rs.getTimestamp(1),
						new Double(rs.getFloat(2)));
			}
			responseTimeHistory.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
		return map;
	}

	public Map<String, Double> avgResponseTimePerFunction() {
		Map<String, Double> map = new LinkedHashMap<String, Double>();
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + AVG_RESPONSE_TIME_PER_FUNCTION_SQL);
			PreparedStatement avgResponseTimePerFunction = conn.prepareStatement(
					AVG_RESPONSE_TIME_PER_FUNCTION_SQL);
			avgResponseTimePerFunction.setTimestamp(1, historyBeginingTimeStamp);
			ResultSet rs = avgResponseTimePerFunction.executeQuery();
			while (rs.next()) {
				map.put(rs.getString(1),
						new Double(rs.getFloat(2)));
			}
			avgResponseTimePerFunction.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
		return map;
	}

	private Map<String, Long> successOrErrorPerFunction(int type, int limit) {
		Map<String, Long> map = new LinkedHashMap<String, Long>();
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + SUCCESS_ERROR_PER_FUNCTION_SQL);
			PreparedStatement successOrErrorPerFunction = conn.prepareStatement(
					SUCCESS_ERROR_PER_FUNCTION_SQL);
			successOrErrorPerFunction.setInt(1, type);
			successOrErrorPerFunction.setTimestamp(2, historyBeginingTimeStamp);
			ResultSet rs = successOrErrorPerFunction.executeQuery();

			// sets the maximum of records to be proccessed
			if (limit <= 0) {
				limit = Integer.MAX_VALUE;
			}
			// proccess the first 'limit' records only
			int totalRecords = 0;
			while (rs.next() && totalRecords++ < limit) {
				map.put(rs.getString(1),
						new Long(rs.getInt(2)));
			}

			successOrErrorPerFunction.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
		return map;
	}

	public Map<String, Long> errorsPerFunction(int limit) {
		return successOrErrorPerFunction(ERROR_STATUS, limit);
	}

	public Map<String, Long> successPerFunction(int limit) {
		return successOrErrorPerFunction(SUCCESS_STATUS, limit);
	}

	public long totalErrors() {
		int total = -1;
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + TOTAL_ERROS_SQL);
			PreparedStatement totalErrors = conn.prepareStatement(
					TOTAL_ERROS_SQL);
			totalErrors.setTimestamp(1, historyBeginingTimeStamp);
			ResultSet rs = totalErrors.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
			totalErrors.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
		return total;
	}

	public long totalSuccess() {
		int total = -1;
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + TOTAL_SUCCESS_SQL);
			PreparedStatement totalSuccess = conn.prepareStatement(
					TOTAL_SUCCESS_SQL);
			totalSuccess.setTimestamp(1, historyBeginingTimeStamp);
			ResultSet rs = totalSuccess.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
			totalSuccess.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
		return total;
	}

	public Map<String, Serializable> summary() {

		log.debug("Executing summary...");
		long current = System.currentTimeMillis();

		Map<String, Serializable> map = new LinkedHashMap<String, Serializable>();

		map.put(SUMMARY_TOTAL_ERRORS, totalErrors());
		log.debug("totalErrors execution took "
				+ (System.currentTimeMillis() - current) / 1000 + "s");
		current = System.currentTimeMillis();

		map.put(SUMMARY_TOTAL_SUCCESS, totalSuccess());
		log.debug("totalSuccess execution took "
				+ (System.currentTimeMillis() - current) / 1000 + "s");
		current = System.currentTimeMillis();

		map.put(SUMMARY_AVG_RESPONSE_TIME, avgResponseTime());
		log.debug("avgResponseTime execution took "
				+ (System.currentTimeMillis() - current) / 1000 + "s");
		current = System.currentTimeMillis();

		lessExecutedFunctionInfo(map);
		log.debug("lessExecutedFunctionInfo execution took "
				+ (System.currentTimeMillis() - current) / 1000 + "s");
		current = System.currentTimeMillis();

		moreExecutedFunctionInfo(map);
		log.debug("moreExecutedFunctionInfo execution took "
				+ (System.currentTimeMillis() - current) / 1000 + "s");
		current = System.currentTimeMillis();

		fastestExecutedFunctionInfo(map);
		log.debug("fastestExecutedFunctionInfo execution took "
				+ (System.currentTimeMillis() - current) / 1000 + "s");
		current = System.currentTimeMillis();

		slowestExecutedFunctionInfo(map);
		log.debug("slowestExecutedFunctionInfo execution took "
				+ (System.currentTimeMillis() - current) / 1000 + "s");
		current = System.currentTimeMillis();

		return map;
	}

	private void fastestExecutedFunctionInfo(Map<String, Serializable> map) {
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + FASTEST_EXECUTED_FUNCTION_SQL);
			// could return many records
			PreparedStatement fasterExecutedFunction = conn.prepareStatement(
					FASTEST_EXECUTED_FUNCTION_SQL);
			double fastestTime = 0;
			Map<String, Number> min = executeStatement(fasterExecutedFunction, Double.class);
			if (min.size() > 0) {
				fastestTime = min.entrySet().iterator().next().getValue().doubleValue();
			}
			fasterExecutedFunction.close();
			conn.close();
			map.put(SUMMARY_FASTEST_EXECUTED_FUNCTION, new ArrayList<String>(min.keySet()));
			map.put(SUMMARY_FASTEST_EXECUTED_TIME, fastestTime);
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
	}

	private void slowestExecutedFunctionInfo(Map<String, Serializable> map) {
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + SLOWEST_EXECUTED_FUNCTION_SQL);
			// could return many records
			PreparedStatement slowerExecutedFunction = conn.prepareStatement(
					SLOWEST_EXECUTED_FUNCTION_SQL);
			double slowestTime = 0;
			Map<String, Number> min = executeStatement(slowerExecutedFunction, Double.class);
			if (min.size() > 0) {
				slowestTime = min.entrySet().iterator().next().getValue().doubleValue();
			}
			slowerExecutedFunction.close();
			conn.close();
			map.put(SUMMARY_SLOWEST_EXECUTED_FUNCTION, new ArrayList<String>(min.keySet()));
			map.put(SUMMARY_SLOWEST_EXECUTED_TIME, slowestTime);
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
	}

	private void moreExecutedFunctionInfo(Map<String, Serializable> map) {
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + MORE_EXECUTED_FUNCTION_SQL);
			// could return many records
			PreparedStatement moreExecutedFunction = conn.prepareStatement(
					MORE_EXECUTED_FUNCTION_SQL);
			long moreTimes = 0;
			Map<String, Number> more = executeStatement(moreExecutedFunction, Long.class);
			if (more.size() > 0) {
				moreTimes = more.entrySet().iterator().next().getValue().longValue();
			}
			moreExecutedFunction.close();
			conn.close();
			map.put(SUMMARY_MORE_EXECUTED_FUNCTION, new ArrayList<String>(more.keySet()));
			map.put(SUMMARY_MORE_EXECUTED_TIMES, moreTimes);
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
	}

	private void lessExecutedFunctionInfo(Map<String, Serializable> map) {
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + LESS_EXECUTED_FUNCTION_SQL);
			// could return many records
			PreparedStatement lessExecutedFunction = conn.prepareStatement(
					LESS_EXECUTED_FUNCTION_SQL);
			long lessTimes = 0;
			Map<String, Number> less = executeStatement(lessExecutedFunction, Long.class);
			if (less.size() > 0) {
				lessTimes = less.entrySet().iterator().next().getValue().longValue();
			}
			lessExecutedFunction.close();
			conn.close();
			map.put(SUMMARY_LESS_EXECUTED_FUNCTION, new ArrayList<String>(less.keySet()));
			map.put(SUMMARY_LESS_EXECUTED_TIMES, lessTimes);
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
	}

	private Map<String, Number> executeStatement(PreparedStatement statement,
			Class<? extends Number> type) {
		Map<String, Number> map = new HashMap<String, Number>();
		try {
			int params = statement.getParameterMetaData().getParameterCount();
			for (int i = 1; i <= params; i++) {
				statement.setTimestamp(i, historyBeginingTimeStamp);
			}
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Number number;
				if (Long.class.isAssignableFrom(type)) {
					number = new Long(rs.getInt(2));
				} else {
					number = new Double(rs.getFloat(2));
				}
				map.put(rs.getString(1), number);
			}
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
		return map;
	}

	public void reset() {
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: " + DELETE_SQL);
			PreparedStatement reset = conn.prepareStatement(DELETE_SQL);
			reset.executeUpdate();
			reset.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}
	}

	public synchronized void setHistoryBeginingTime(Date historyBeginingTime) {
		this.historyBeginingTime = historyBeginingTime;
		this.historyBeginingTimeStamp = new Timestamp(historyBeginingTime.getTime());
		if (log.isInfoEnabled()) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			log.info("Filtering records with date >= "
					+ dateFormat.format(historyBeginingTimeStamp));
		}
	}

	public Date getHistoryBeginingTime() {
		return historyBeginingTime;
	}

	public Map<Date, List<Double>> getDailyActivity(String functionName, Date day) {
		Map<Date, List<Double>> map = new HashMap<Date, List<Double>>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(day);
		Timestamp start = new Timestamp(DateUtils.firstTimeOfDay(calendar).getTime());
		Timestamp end = new Timestamp(DateUtils.lastTimeOfDay(calendar).getTime());
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: {}", FUNCTION_DAILY_ACTIVITY_SQL);
			PreparedStatement dailyActivity = conn.prepareStatement(
					FUNCTION_DAILY_ACTIVITY_SQL);
			dailyActivity.setString(1, functionName);
			dailyActivity.setTimestamp(2, start);
			dailyActivity.setTimestamp(3, end);
			ResultSet rs = dailyActivity.executeQuery();
			while (rs.next()) {
				Date date = rs.getTimestamp(1);
				double time = rs.getDouble(2);
				List<Double> times = map.get(date);
				// nenhum tempo ainda
				if (times == null) {
					times = new ArrayList<Double>();
				}
				times.add(time);
				map.put(date, times);
			}
			dailyActivity.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}

		return map;
	}

	public List<Date> getDailyErrors(String functionName, Date day) {
		List<Date> list = new ArrayList<Date>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(day);
		Timestamp start = new Timestamp(DateUtils.firstTimeOfDay(calendar).getTime());
		Timestamp end = new Timestamp(DateUtils.lastTimeOfDay(calendar).getTime());
		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: {}", FUNCTION_DAILY_ERRORS_SQL);
			PreparedStatement dailyErrors = conn.prepareStatement(
					FUNCTION_DAILY_ERRORS_SQL);
			dailyErrors.setString(1, functionName);
			dailyErrors.setTimestamp(2, start);
			dailyErrors.setTimestamp(3, end);
			ResultSet rs = dailyErrors.executeQuery();
			while (rs.next()) {
				list.add(rs.getTimestamp(1));
			}
			dailyErrors.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}

		return list;
	}

	public List<Map<String, Object>> latestByFunction(String functionName) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		try {
			Connection conn = ConnectionHelper.getConnection(datasource);
			log.debug("Executing statement: {}", LATEST_BY_FUNCTION_SQL);
			PreparedStatement latestByFunction = conn.prepareStatement(LATEST_BY_FUNCTION_SQL);
			latestByFunction.setString(1, functionName);
			ResultSet rs = latestByFunction.executeQuery();
			while (rs.next()) {
				Map<String, Object> transaction = new HashMap<String, Object>();
				transaction.put(TRANSACTION_STATUS, rs.getString(1));
				transaction.put(TRANSACTION_REQUEST, rs.getString(2));
				transaction.put(TRANSACTION_RESPONSE, rs.getString(3));
				transaction.put(TRANSACATION_PROCESSING_TIME, rs.getString(4));
				transaction.put(TRANSACTION_INSERT_TIME, rs.getTimestamp(5));
				result.add(transaction);
			}
			latestByFunction.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error selecting records", e);
		}

		return result;
	}
}
