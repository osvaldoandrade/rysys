package br.com.codecompany.rysys.jmx.client.graph;

import static br.com.codecompany.rysys.jmx.client.Constants.BACKGROUD_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_AXIS_LABEL_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_BACKGROUND_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_BAR_ITEM_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_GRID_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_LEGEND_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_NO_DATA_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_TICK_LABEL_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.ERROR_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.MAXIMUM_ITEM_COUNT;
import static br.com.codecompany.rysys.jmx.client.Constants.SUCCESS_COLOR;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;

import br.com.codecompany.rysys.jmx.client.Monitor;
import br.com.codecompany.rysys.jmx.client.util.I18N;

public class SnapshotPanel extends JPanel implements UpdateListener {

	private static final long serialVersionUID = 77795583679866139L;

	protected Monitor monitor;
	private TimeSeries errors;
	private TimeSeries success;
	private long existingSuccess = 0;
	private long existingErrors = 0;
	private static I18N i18n = I18N.getInstance();

	protected JFreeChart chart;

	public SnapshotPanel(Monitor monitor) {
		super(new BorderLayout());
		this.monitor = monitor;
		ChartPanel chartPanel = createChart();
		add(chartPanel, BorderLayout.CENTER);
	}

	protected ChartPanel createChart() {
		TimeSeriesCollection dataset = createSeries();
		DateAxis dateAxis = configureXAxis();
		NumberAxis numberAxis = configureYAxis();
		numberAxis.setAutoRange(true);

		XYItemRenderer renderer = configureRenderer();
		XYPlot plot = configurePlot(dataset, dateAxis, numberAxis, renderer);

		chart = new JFreeChart(plot);
		chart.setBackgroundPaint(BACKGROUD_COLOR);
		chart.getLegend().setItemFont(CHART_LEGEND_FONT);
		chart.getLegend().setBackgroundPaint(BACKGROUD_COLOR);
		chart.getLegend().setFrame(BlockBorder.NONE);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createCompoundBorder(								
				new EmptyBorder(5,5,5,5),
				new TitledBorder(i18n.getValue("monitoring.label.functionExecutionSummary"))));	

		return chartPanel;
	}

	private XYPlot configurePlot(TimeSeriesCollection dataset,
			DateAxis dateAxis, NumberAxis numberAxis, XYItemRenderer renderer) {
		XYPlot plot = new XYPlot(dataset, dateAxis, numberAxis, renderer);
		plot.setBackgroundPaint(CHART_BACKGROUND_COLOR);
		plot.setDomainGridlinePaint(CHART_GRID_COLOR);
		plot.setRangeGridlinePaint(CHART_GRID_COLOR);
		plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setNoDataMessage(i18n.getValue("monitoring.label.noData"));
		plot.setNoDataMessageFont(CHART_NO_DATA_FONT);

		return plot;
	}

	private XYItemRenderer configureRenderer() {
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(false,
				true);
		Color[] colors = getRendererColors();
		Shape[] shapes = getRendererShapes();

		for (int i = 0; i < colors.length; i++) {
			renderer.setSeriesPaint(i, colors[i]);
			renderer.setSeriesShape(i, shapes[i]);
			renderer.setSeriesFillPaint(i, colors[i].darker());
			renderer.setSeriesLinesVisible(i, true);
		}

		renderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setUseFillPaint(true);
		renderer.setBaseItemLabelFont(CHART_BAR_ITEM_FONT);

		return renderer;
	}

	protected Color[] getRendererColors() {
		return new Color[] { SUCCESS_COLOR, ERROR_COLOR };
	}

	protected Shape[] getRendererShapes() {
		return new Shape[] { new Ellipse2D.Double(-3.0D, -3.0D, 6.0D, 6.0D),
				new Ellipse2D.Double(-3.0D, -3.0D, 6.0D, 6.0D) };
	}

	private NumberAxis configureYAxis() {
		NumberAxis numberAxis = new NumberAxis(getYAxisName());
		numberAxis.setTickLabelFont(CHART_TICK_LABEL_FONT);
		numberAxis.setLabelFont(CHART_AXIS_LABEL_FONT);
		numberAxis.setLowerMargin(0.5);
		numberAxis.setUpperMargin(0.5);
		if (isIntegerYAxis()) {
			numberAxis
					.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		}
		return numberAxis;
	}

	protected boolean isIntegerYAxis() {
		return true;
	}

	protected String getYAxisName() {
		return i18n.getValue("monitoring.label.executionsTotal");
	}

	private DateAxis configureXAxis() {
		DateAxis dateAxis = new DateAxis(getXAxisName());
		dateAxis.setTickLabelFont(CHART_TICK_LABEL_FONT);
		dateAxis.setLabelFont(CHART_AXIS_LABEL_FONT);
		dateAxis.setAutoRange(true);
		dateAxis.setLowerMargin(0.0);
		dateAxis.setUpperMargin(0.0);
		dateAxis.setTickLabelsVisible(true);
		return dateAxis;
	}

	protected String getXAxisName() {
		return i18n.getValue("monitoring.label.period");
	}

	protected TimeSeriesCollection createSeries() {		
		errors = new TimeSeries(i18n.getValue("monitoring.label.errors"));
		errors.setMaximumItemCount(MAXIMUM_ITEM_COUNT);

		success = new TimeSeries(i18n.getValue("monitoring.label.success"));
		success.setMaximumItemCount(MAXIMUM_ITEM_COUNT);

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(success);
		dataset.addSeries(errors);
		return dataset;
	}

	public void update() {
		if (isVisible()) {
			// success/errors accumulated
			long allSuccess = (Long) monitor.getProxy().totalSuccess();
			long allErrors = (Long) monitor.getProxy().totalErrors();

			// new success/errors
			long newErrors = allErrors - existingErrors;
			long newSuccess = allSuccess - existingSuccess;

			// there are new errors...
			if (newErrors > 0) {
				errors.addOrUpdate(new Millisecond(), newErrors);
			}

			// there are new success...
			if (newSuccess > 0) {
				success.addOrUpdate(new Millisecond(), newSuccess);
			}

			existingSuccess = allSuccess;
			existingErrors = allErrors;
		}
	}
}