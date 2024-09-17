package br.com.codecompany.rysys.jmx.client.graph;

import static br.com.codecompany.rysys.jmx.client.Constants.BACKGROUD_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_AXIS_LABEL_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_BAR_ITEM_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_LEGEND_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_NO_DATA_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_TICK_LABEL_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.SUCCESS_COLOR;

import java.awt.BorderLayout;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.SlidingCategoryDataset;
import org.jfree.ui.TextAnchor;

import br.com.codecompany.rysys.jmx.client.Monitor;
import br.com.codecompany.rysys.jmx.client.util.I18N;

public class ResponseTimePanel extends JPanel implements UpdateListener, ChangeListener {

	private static final long serialVersionUID = -4057263005474778019L;

	private Monitor monitor;
	private JScrollBar scroller;
	private SlidingCategoryDataset categoryDataset;
	private static I18N i18n = I18N.getInstance();

	public ResponseTimePanel(Monitor monitor) {
		super(new BorderLayout());
		this.monitor = monitor;
	}

	@SuppressWarnings("unchecked")
	private ChartPanel createChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String label = i18n.getValue("monitoring.label.avgResponseTime");

		Object objectMap = monitor.getProxy().avgResponseTimePerFunction();

		Map<String, Double> map = (Map<String, Double>) objectMap;

		for (Entry<String, Double> entry : map.entrySet()) {
			dataset.addValue(entry.getValue(), label, entry.getKey());
		}

		// scroll
		categoryDataset = new SlidingCategoryDataset(dataset, 0, 10);
		
		JFreeChart chart = ChartFactory.createStackedBarChart3D(
				"", // chart title
				i18n.getValue("monitoring.label.function"), // domain axis label
				i18n.getValue("monitoring.label.responseTime"), // range axis label
				categoryDataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips?
				false // URLs?
				);
		chart.setBackgroundPaint(BACKGROUD_COLOR);
		chart.getLegend().setItemFont(CHART_LEGEND_FONT);
		chart.getLegend().setBackgroundPaint(BACKGROUD_COLOR);
		chart.getLegend().setFrame(BlockBorder.NONE);				

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setNoDataMessage(i18n.getValue("monitoring.label.noData"));
		plot.setNoDataMessageFont(CHART_NO_DATA_FONT);
		
		ValueAxis valueAxis = plot.getRangeAxis();
		valueAxis.setUpperMargin(0.1D);
		valueAxis.setLabelFont(CHART_AXIS_LABEL_FONT);
		valueAxis.setTickLabelFont(CHART_TICK_LABEL_FONT);
        
        CategoryAxis categoryAxis = plot.getDomainAxis();
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
        categoryAxis.setLabelFont(CHART_AXIS_LABEL_FONT);
        categoryAxis.setTickLabelFont(CHART_TICK_LABEL_FONT);
        
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		// prevent bar from fit whole graph
		renderer.setMaximumBarWidth(0.1D);
		renderer.setSeriesPaint(0, SUCCESS_COLOR);
		
		// show value above bar
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setItemLabelAnchorOffset(10.0D);
		renderer.setBasePositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, 
						TextAnchor.BASELINE_LEFT));
		renderer.setBaseItemLabelFont(CHART_BAR_ITEM_FONT);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createCompoundBorder(								
				new EmptyBorder(5,5,5,5),
				new TitledBorder(i18n.getValue("monitoring.label.avgResponseTimeForFunction"))));		

		return chartPanel;
	}

	public void update() {
		if (isVisible()) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					removeAll();
					ChartPanel chartPanel = createChart();
					add(chartPanel, BorderLayout.CENTER);
				    scroller = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 50);
				    scroller.getModel().addChangeListener(ResponseTimePanel.this);	
				    add(scroller, BorderLayout.SOUTH);
					validate();
				}
			});
		}
	}
	
    public void stateChanged(ChangeEvent paramChangeEvent) {
    	try {
        	categoryDataset.setFirstCategoryIndex(scroller.getValue());	
		} catch (Exception e) {

		}
    }	
}