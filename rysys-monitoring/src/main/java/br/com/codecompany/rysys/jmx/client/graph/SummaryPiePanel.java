package br.com.codecompany.rysys.jmx.client.graph;

import static br.com.codecompany.rysys.jmx.client.Constants.BACKGROUD_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_NO_DATA_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.ERROR_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.SUCCESS_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_LEGEND_FONT;

import java.awt.BorderLayout;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import br.com.codecompany.rysys.jmx.client.JmxProxy;
import br.com.codecompany.rysys.jmx.client.Monitor;
import br.com.codecompany.rysys.jmx.client.util.I18N;

public class SummaryPiePanel extends JPanel implements UpdateListener {

	private static final long serialVersionUID = -4241426721050619772L;

	private Monitor monitor;
	private static I18N i18n = I18N.getInstance();
	
	public SummaryPiePanel(Monitor monitor) {
		super(new BorderLayout());
		this.monitor = monitor;
		update();
	}
	
	private ChartPanel createChart() {
		DefaultPieDataset dataset = new DefaultPieDataset();

		Map<String, Long> map = monitor.getProxy().successErrosSummary();

		for (Entry<String, Long> entry : map.entrySet()) {
			dataset.setValue(entry.getKey(), entry.getValue());
		}

		JFreeChart chart = ChartFactory.createPieChart3D(
				"", // chart title
				dataset, // data
				true, // include legend
				true, false);
		chart.setBackgroundPaint(BACKGROUD_COLOR);
		chart.getLegend().setItemFont(CHART_LEGEND_FONT);
		chart.getLegend().setBackgroundPaint(BACKGROUD_COLOR);
		chart.getLegend().setFrame(BlockBorder.NONE);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setCircular(false);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		plot.setSectionPaint(JmxProxy.SUCCESS, SUCCESS_COLOR);
		plot.setSectionPaint(JmxProxy.ERRORS, ERROR_COLOR);
		plot.setBackgroundPaint(BACKGROUD_COLOR);
		plot.setOutlinePaint(BACKGROUD_COLOR);
		// show percentages only
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}"));
		plot.setNoDataMessage(i18n.getValue("monitoring.label.noData"));
		plot.setNoDataMessageFont(CHART_NO_DATA_FONT);

		// add the chart to a panel...
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createCompoundBorder(								
				new EmptyBorder(5,5,5,5),
				new TitledBorder(i18n.getValue("monitoring.label.executionsDistribution"))));	

		return chartPanel;
	}
	
	public void update() {
		if (isVisible()) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					removeAll();
					ChartPanel chartPanel = createChart();
					add(chartPanel, BorderLayout.CENTER);
					validate();
				}
			});
		}
	}	
}
