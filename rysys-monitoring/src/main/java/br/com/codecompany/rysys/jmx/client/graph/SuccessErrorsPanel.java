package br.com.codecompany.rysys.jmx.client.graph;

import static br.com.codecompany.rysys.jmx.client.Constants.BACKGROUD_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_AXIS_LABEL_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.CHART_BAR_ITEM_FONT;
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
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.SlidingCategoryDataset;
import org.jfree.ui.TextAnchor;

import br.com.codecompany.rysys.jmx.client.Monitor;
import br.com.codecompany.rysys.jmx.client.util.I18N;

public class SuccessErrorsPanel extends JPanel implements UpdateListener, ChangeListener {

	private static final long serialVersionUID = -2439508362914898255L;

	private Monitor monitor;
	private JScrollBar scroller;
	private SlidingCategoryDataset categoryDataset;
	private static I18N i18n = I18N.getInstance();

	public SuccessErrorsPanel(Monitor monitor) {
		super(new BorderLayout());
		this.monitor = monitor;
	}

	@SuppressWarnings("unchecked")
	private ChartPanel createChart() {
		Object dataSet = monitor.getProxy().successErrosPerFunction(0);

		Map<String, Long[]> map = (Map<String, Long[]>) dataSet;

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (Entry<String, Long[]> entry : map.entrySet()) {
			dataset.addValue(entry.getValue()[0], i18n.getValue(
					"monitoring.label.success"), entry.getKey());
			dataset.addValue(entry.getValue()[1], i18n.getValue(
					"monitoring.label.errors"), entry.getKey());
		}
		
		// scroll
		categoryDataset = new SlidingCategoryDataset(dataset, 0, 10);

		JFreeChart chart = ChartFactory.createStackedBarChart3D(
				"", // chart title
				i18n.getValue("monitoring.label.function"), // domain axis label
				i18n.getValue("monitoring.label.executions"), // range axis label
				categoryDataset, // data
				PlotOrientation.HORIZONTAL, // orientation
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
        categoryAxis.setLabelFont(CHART_AXIS_LABEL_FONT);
        categoryAxis.setTickLabelFont(CHART_TICK_LABEL_FONT);
		
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setSeriesPaint(0, SUCCESS_COLOR);
		renderer.setSeriesPaint(1, ERROR_COLOR);
		// prevent bar from fit whole graph
		renderer.setMaximumBarWidth(0.1D);

		// show value inside bar
		renderer.setDrawBarOutline(false);
		renderer.setItemMargin(0.1D);
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
	    ItemLabelPosition position = 
	    	new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, 
	    			TextAnchor.CENTER, 0);
	    renderer.setBasePositiveItemLabelPosition(position);
		renderer.setBaseItemLabelFont(CHART_BAR_ITEM_FONT);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createCompoundBorder(								
				new EmptyBorder(5,5,5,5),
				new TitledBorder(i18n.getValue("monitoring.label.executionsPerFunction"))));	

		return chartPanel;
	}

	public void update() {
		if (isVisible()) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					removeAll();
					ChartPanel chartPanel = createChart();
					add(chartPanel, BorderLayout.CENTER);
				    scroller = new JScrollBar(JScrollBar.VERTICAL, 0, 10, 0, 50);
				    scroller.getModel().addChangeListener(SuccessErrorsPanel.this);	
				    add(scroller, BorderLayout.EAST);				
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
    
    static class LabelGenerator extends StandardCategoryItemLabelGenerator {
		private static final long serialVersionUID = 1L;

		public String generateLabel(CategoryDataset paramCategoryDataset,
				int paramInt1, int paramInt2) {
			return paramCategoryDataset.getRowKey(paramInt1).toString();
		}
	}    
}