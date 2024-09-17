package br.com.codecompany.rysys.jmx.client.graph;

import static br.com.codecompany.rysys.jmx.client.Constants.BACKGROUD_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_LEGEND_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_NO_DATA_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_TICK_LABEL_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.ERROR_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.SUCCESS_COLOR;

import java.awt.BorderLayout;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import br.com.codecompany.rysys.jmx.client.JmxProxy;
import br.com.codecompany.rysys.jmx.client.Monitor;
import br.com.codecompany.rysys.jmx.client.util.I18N;

public class TopActivePanel extends JPanel implements UpdateListener {

	private static final long serialVersionUID = -3526042873834836421L;
	
	private static final int MAX_FUNCTIONS = 5;
	
	private Monitor monitor;
	private static I18N i18n = I18N.getInstance();

	public TopActivePanel(Monitor monitor) {
		super(new BorderLayout());
		this.monitor = monitor;
	}
	
	@SuppressWarnings("unchecked")
	private DefaultCategoryDataset createDataset() {
		Object data = monitor.getProxy().successErrosPerFunction(MAX_FUNCTIONS);
		Map<String, Long[]> map = (Map<String, Long[]>) data;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Entry<String, Long[]> entry : map.entrySet()) {
			dataset.addValue(entry.getValue()[0], JmxProxy.SUCCESS, entry.getKey());
			dataset.addValue(entry.getValue()[1], JmxProxy.ERRORS, entry.getKey());
		}
		
		return dataset;
	}
	
	protected ChartPanel createPanel() {
	    SpiderWebPlot plot = new SpiderWebPlot(createDataset());
	    plot.setStartAngle(54.0D);
	    plot.setInteriorGap(0.4D);
	    plot.setToolTipGenerator(new StandardCategoryToolTipGenerator());
	    plot.setSeriesPaint(0, SUCCESS_COLOR);
	    plot.setSeriesPaint(1, ERROR_COLOR);
		plot.setBackgroundPaint(BACKGROUD_COLOR);
		plot.setLabelFont(CHART_TICK_LABEL_FONT);
		plot.setOutlineVisible(false);
		plot.setNoDataMessage(i18n.getValue("monitoring.label.noData"));
		plot.setNoDataMessageFont(CHART_NO_DATA_FONT);
		
	    JFreeChart chart = new JFreeChart(plot);
		chart.getLegend().setItemFont(CHART_LEGEND_FONT);
		chart.getLegend().setBackgroundPaint(BACKGROUD_COLOR);
		chart.getLegend().setFrame(BlockBorder.NONE);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setDisplayToolTips(true);
		chartPanel.setBorder(BorderFactory.createCompoundBorder(								
				new EmptyBorder(5,5,5,5),
				new TitledBorder(MAX_FUNCTIONS + " " +
						i18n.getValue("monitoring.label.distributionMoreExecuted"))));	
		
		return chartPanel;
	}	
	
	public void update() {
		if (isVisible()) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					removeAll();
					add(createPanel(), BorderLayout.CENTER);
					validate();
				}
			});
		}
	}
}
