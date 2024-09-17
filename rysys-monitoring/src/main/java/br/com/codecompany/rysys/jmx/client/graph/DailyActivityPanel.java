package br.com.codecompany.rysys.jmx.client.graph;

import static br.com.codecompany.rysys.jmx.client.Constants.BACKGROUD_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_AXIS_LABEL_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_LEGEND_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_NO_DATA_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_TICK_LABEL_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.ERROR_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.NORMAL_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.SUCCESS_COLOR;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYBoxAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

import br.com.codecompany.rysys.jmx.client.Monitor;
import br.com.codecompany.rysys.jmx.client.util.I18N;
import br.com.codecompany.rysys.util.DateUtils;

public class DailyActivityPanel extends JPanel implements UpdateListener {

	private static final long serialVersionUID = -3594020623107917317L;

	private Monitor monitor;
	private String functionName = null;
	private static I18N i18n = I18N.getInstance();
	private JComboBox functionCombo;
	// execucoes em cada hora
	private Map<Integer, Long> execPerHour;
	// erros em cada hora
	private Map<Integer, Long> errorsPerHour;

	private Date day;

	public DailyActivityPanel(Monitor monitor) {
		super(new BorderLayout());
		this.monitor = monitor;
	}

	private JPanel createInfoPanel() {
		String[] functionList = monitor.getProxy().functionNames();
		
		JPanel comboPanel = new JPanel();
		comboPanel.add(new JLabel(i18n.getValue(
				"monitoring.label.function")));
		functionCombo = new JComboBox();
		functionCombo.setFont(NORMAL_FONT);
		if (functionList != null) {
			for (String name : functionList) {
				functionCombo.addItem(name);
			}
			if (functionName == null) {
				ComboBoxModel model = functionCombo.getModel();
				if (model != null && model.getSize() > 0) {
					functionName = model.getElementAt(0).toString();
				}
			}
		}
		
		// antes do listener
		functionCombo.setSelectedItem(functionName);	
		
		functionCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				functionName = String.valueOf(functionCombo.getSelectedItem()); 
				update();
			}
		});
		comboPanel.add(functionCombo);
		
		JPanel info = new JPanel(new BorderLayout());
		info.add(comboPanel, BorderLayout.WEST);
		info.setBorder(BorderFactory.createCompoundBorder(								
				new EmptyBorder(5,5,5,5),
				new TitledBorder(i18n.getValue("monitoring.label.filter"))));	
	
		return info;
	}

	private ChartPanel createChart() {
		day = monitor.getBeginingTime();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(day);
		
		XYSeriesCollection dataset1 = new XYSeriesCollection();
		dataset1.addSeries(createSuccessSeries(day));
		
		XYSeriesCollection dataset2 = new XYSeriesCollection();
		dataset2.addSeries(createErrorsSeries(day));
		
		JFreeChart chart = ChartFactory.createTimeSeriesChart("",
				i18n.getValue("monitoring.label.executionsHour"), 
				i18n.getValue("monitoring.label.responseTime"),
				dataset1, 
				true, 
				true,
				false);
		chart.getLegend().setItemFont(CHART_LEGEND_FONT);
		chart.getLegend().setItemFont(CHART_LEGEND_FONT);
		chart.getLegend().setBackgroundPaint(BACKGROUD_COLOR);
		chart.getLegend().setFrame(BlockBorder.NONE);
				
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setNoDataMessage(i18n.getValue("monitoring.label.noData"));
		plot.setNoDataMessageFont(CHART_NO_DATA_FONT);

		NumberAxis executionTimeAxis = (NumberAxis) plot.getRangeAxis();
		executionTimeAxis.setAutoRange(true);
		executionTimeAxis.setLabelFont(CHART_AXIS_LABEL_FONT);
		executionTimeAxis.setTickLabelFont(CHART_TICK_LABEL_FONT);
		executionTimeAxis.setLabelPaint(SUCCESS_COLOR);
		executionTimeAxis.setTickLabelPaint(SUCCESS_COLOR);
		
		NumberAxis errorsAxis = new NumberAxis(i18n.getValue("monitoring.label.errors"));
		errorsAxis.setAutoRange(true);
		errorsAxis.setMinorTickCount(5);
		errorsAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		errorsAxis.setLabelFont(CHART_AXIS_LABEL_FONT);
		errorsAxis.setTickLabelFont(CHART_TICK_LABEL_FONT);
		errorsAxis.setLabelPaint(ERROR_COLOR);
		errorsAxis.setTickLabelPaint(ERROR_COLOR);
		
		plot.setRangeAxis(1, errorsAxis);
		plot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
		plot.setDataset(1, dataset2);
		plot.mapDatasetToRangeAxis(1, 1);
		
		DateAxis dateAxis = (DateAxis) plot.getDomainAxis();
		dateAxis.setTickUnit(new DateTickUnit(DateTickUnitType.HOUR, 1));
		dateAxis.setDateFormatOverride(new SimpleDateFormat("HH"));
		dateAxis.setMinimumDate(DateUtils.firstTimeOfDay(calendar));
		dateAxis.setMaximumDate(DateUtils.lastTimeOfDay(calendar));
		dateAxis.setAutoRange(false);
		dateAxis.setLabelFont(CHART_AXIS_LABEL_FONT);
		dateAxis.setTickLabelFont(CHART_TICK_LABEL_FONT);

		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot
				.getRenderer(0);
		renderer.setSeriesShape(0, new Rectangle(2, 2));
		renderer.setBaseLinesVisible(false);
		renderer.setBaseShapesFilled(true);
		renderer.setBaseShapesVisible(true);
		renderer.setSeriesPaint(0, SUCCESS_COLOR);
		
		XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer();
		plot.setRenderer(1, renderer2);
		renderer2.setSeriesShape(0, new Rectangle(2, 2));
		renderer2.setBaseLinesVisible(false);
		renderer2.setBaseShapesFilled(true);
		renderer2.setBaseShapesVisible(true);
		renderer2.setSeriesPaint(0, ERROR_COLOR);		
		
		DateFormat dateFormat = new SimpleDateFormat(i18n.getValue("monitoring.label.date.mask1"));
		String date = dateFormat.format(day);
		String title = i18n.getValue("monitoring.label.executionDaily") + " (" + date + ")";
		chart.setBackgroundPaint(BACKGROUD_COLOR);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createCompoundBorder(
								new EmptyBorder(5, 5, 5, 5),
								new TitledBorder(title)));

		// anota o grafico
		drawAnnotations(renderer);
		
		return chartPanel;
	}

	private XYSeries createSuccessSeries(Date day) {
		Map<Date, List<Double>> successData = 
			monitor.getProxy().getDailyActivity(functionName, day);

		XYSeries success = new XYSeries(i18n
				.getValue("monitoring.label.success"), false, true);

		execPerHour = new HashMap<Integer, Long>();
		
		// popula a serie de sucessos
		for (Entry<Date, List<Double>> entry : successData.entrySet()) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(entry.getKey());
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			long total = 0;
			
			List<Double> times = entry.getValue();
			for (Double executionTime : times) {
				long funtionTime = entry.getKey().getTime();
				success.add(funtionTime, executionTime);
				total++;
			}
			// total de execucoes dessa hora
			Long aux = execPerHour.get(hour);
			if (aux != null) {
				total += aux;
			}
			execPerHour.put(hour, total);
		}
		
		return success;
	}
	
	private XYSeries createErrorsSeries(Date day) {
		List<Date> errorsData = 
			monitor.getProxy().getDailyErrors(functionName, day);
		
		XYSeries errors = new XYSeries(
				i18n.getValue("monitoring.label.errors"), false, true);
		
		errorsPerHour = new HashMap<Integer, Long>();
		
		for (Date date : errorsData) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			// total de erros dessa hora
			Long total = errorsPerHour.get(hour);
			total = (total == null)? 1 : total + 1;
			errorsPerHour.put(hour, total);
		}
		
		for (Entry<Integer, Long> entry : errorsPerHour.entrySet()) {
			errors.add(new Hour(entry.getKey(), new Day(day)).getMiddleMillisecond(), 
					entry.getValue());
		}
		
		return errors;
	}
	
	private void drawAnnotations(XYLineAndShapeRenderer renderer) {
		int maxKey = -1;
		long maxValue = -1;
		for (Entry<Integer,Long> entry : execPerHour.entrySet()) {
			if (entry.getValue() > maxValue) {
				maxKey = entry.getKey();
				maxValue = entry.getValue();
			}
		}
		if (maxKey > -1 && maxValue > -1) {
			Color outline = new Color(255, 0, 0, 60);
			Color fill = new Color(0, 255, 0, 60);
			Hour hour = new Hour(maxKey, new Day(day));
			XYBoxAnnotation best = new XYBoxAnnotation(hour.getFirstMillisecond(), 0.0D, 
					hour.getLastMillisecond(), renderer.getPlot().getRangeAxis().getUpperBound(),
					new BasicStroke(0.0F),
					outline, fill);
			best.setToolTipText(maxValue + " " + i18n.getValue("monitoring.label.success"));
			renderer.addAnnotation(best);
		}
	}
	
	public void update() {
		if (isVisible()) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					removeAll();
					add(createInfoPanel(), BorderLayout.NORTH);
					add(createChart(), BorderLayout.CENTER);
					validate();
				}
			});
		}
	}
}
