package br.com.codecompany.rysys.jmx.client;

import static br.com.codecompany.rysys.jmx.client.Constants.NORMAL_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.SMALL_FONT;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner.DateEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.jmx.client.graph.DailyActivityPanel;
import br.com.codecompany.rysys.jmx.client.graph.DataUpdater;
import br.com.codecompany.rysys.jmx.client.graph.DistributionPanel;
import br.com.codecompany.rysys.jmx.client.graph.ResponseTimePanel;
import br.com.codecompany.rysys.jmx.client.graph.SnapshotPanel;
import br.com.codecompany.rysys.jmx.client.graph.SuccessErrorsPanel;
import br.com.codecompany.rysys.jmx.client.graph.SummaryPanel;
import br.com.codecompany.rysys.jmx.client.graph.SummaryPiePanel;
import br.com.codecompany.rysys.jmx.client.graph.TopActivePanel;
import br.com.codecompany.rysys.jmx.client.util.I18N;
import br.com.codecompany.rysys.jmx.client.util.Utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Container;

public class Monitor {

	private static final Logger log = LoggerFactory.getLogger(Monitor.class);

	private static I18N i18n = I18N.getInstance();
	private JmxProxy proxy;
	private JFrame frame;
	private JSpinner timeSpinner;
	private JDateChooser dateChooser;
	private int updateFrequency = 30000;
	private DataUpdater updater = new DataUpdater(updateFrequency);
	private Date beginingTime = new Date();
	private SnapshotPanel snapshot;
	private SummaryPanel summary;
	private ResponseTimePanel responseTime;
	private SuccessErrorsPanel successErrors;
	private DistributionPanel distributionPanel;
	private SummaryPiePanel summaryPie;
	private TopActivePanel topActive;
	private DailyActivityPanel dailyActivity;
	private Container appletContainer;

	public Monitor(JmxProxy proxy) {
		this(proxy, null);
	}

	Monitor(JmxProxy proxy, Container container) {
		this.proxy = proxy;
		appletContainer = container;
	}

	public int getUpdateFrequency() {
		return updateFrequency;
	}
	
	public Date getBeginingTime() {
		return beginingTime;
	}
	
	public JmxProxy getProxy() {
		return proxy;
	}
	
	public void startApplet() {
		log.debug("Creating main frame...");

		JPanel controlPanel = createControls();
		JTabbedPane tabbedPane = createGraphs();
		appletContainer.removeAll();
		appletContainer.add(controlPanel,BorderLayout.NORTH);
		appletContainer.add(tabbedPane,BorderLayout.CENTER);
		
		log.debug("Created!");

		// hora inicial
		updateHistoryBeginingTime();

		log.debug("Starting listener...");
		// atualização de tempos em tempos
		updater.start();
		log.debug("Started!");
	}

	public void start() {
		log.debug("Creating main frame...");
		frame = new JFrame(i18n.getValue("monitoring.title"));

		JPanel controlPanel = createControls();
		JTabbedPane tabbedPane = createGraphs();

		frame.add(controlPanel, BorderLayout.NORTH);
		frame.add(tabbedPane, BorderLayout.CENTER);

		frame.setBounds(200, 120, 700, 580);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				proxy.close();
				System.exit(0);
			}
		});

		Utils.centerWindow(frame);
		frame.setVisible(true);
		log.debug("Created!");

		// hora inicial
		updateHistoryBeginingTime();

		log.debug("Starting listener...");
		// atualização de tempos em tempos
		updater.start();
		log.debug("Started!");
	}

	private JTabbedPane createGraphs() {
		log.debug("Creating {}...", SnapshotPanel.class.getSimpleName());
		snapshot = new SnapshotPanel(this);
		updater.addListener(snapshot);
		log.debug("Created!");

		log.debug("Creating {}...", SummaryPanel.class.getSimpleName());
		summary = new SummaryPanel(this);
		updater.addListener(summary);
		log.debug("Created!");

		log.debug("Creating {}...", ResponseTimePanel.class.getSimpleName());
		responseTime = new ResponseTimePanel(this);
		updater.addListener(responseTime);
		log.debug("Created!");

		log.debug("Creating {}...", SuccessErrorsPanel.class.getSimpleName());
		successErrors = new SuccessErrorsPanel(this);
		updater.addListener(successErrors);
		log.debug("Created!");

		log.debug("Creating {}...", DistributionPanel.class.getSimpleName());
		distributionPanel = new DistributionPanel(this);
		updater.addListener(distributionPanel);
		log.debug("Created!");

		log.debug("Creating {}...", DailyActivityPanel.class.getSimpleName());
		dailyActivity = new DailyActivityPanel(this);
		updater.addListener(dailyActivity);
		log.debug("Created!");

		log.debug("Creating {}...", SummaryPiePanel.class.getSimpleName());
		summaryPie = new SummaryPiePanel(this);
		updater.addListener(summaryPie);
		log.debug("Created!");

		log.debug("Creating {}...", TopActivePanel.class.getSimpleName());
		topActive = new TopActivePanel(this);
		updater.addListener(topActive);
		log.debug("Created!");
		
		// tab principal
		JPanel upPanel = new JPanel(new BorderLayout());
		upPanel.add(snapshot, BorderLayout.CENTER);
		
		JPanel downPanel = new JPanel(new GridLayout(1,3));
		downPanel.add(summary);
		downPanel.add(summaryPie);
		downPanel.add(topActive);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				upPanel, downPanel);
		
		splitPane.setResizeWeight(0.6);
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);

		// graficos
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
		tabbedPane.addTab(i18n.getValue("monitoring.tab.summary"), splitPane);
		tabbedPane.addTab(i18n.getValue("monitoring.tab.responseTime"),
				responseTime);
		tabbedPane.addTab(i18n.getValue("monitoring.tab.successErrors"),
				successErrors);
		tabbedPane.addTab(i18n.getValue("monitoring.tab.distribution"),
				distributionPanel);
		tabbedPane.addTab(i18n.getValue("monitoring.tab.functionDetail"),
				dailyActivity);

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				updater.updateAll();
			}
		});

		return tabbedPane;
	}

	private JPanel createControls() {
		log.debug("Creating controls...");
		SpinnerDateModel model = new SpinnerDateModel();
		timeSpinner = new JSpinner();
		timeSpinner.setModel(model);
		timeSpinner.setEditor(new DateEditor(timeSpinner, "HH:mm:ss"));
		timeSpinner.setValue(beginingTime);
		timeSpinner.setFont(NORMAL_FONT);
		timeSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				updateHistoryBeginingTime();
			}
		});
		
		JPanel historyPanel = new JPanel(new BorderLayout());
		historyPanel.add(new JLabel(i18n.getValue("monitoring.label.from")),
				BorderLayout.NORTH);
		dateChooser = new JDateChooser(i18n
				.getValue("monitoring.label.date.mask1"), i18n
				.getValue("monitoring.label.date.mask2"), '_');
		dateChooser.setDate(beginingTime);
		dateChooser.setPreferredSize(new Dimension(100, 15));
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("date")) {
					Object oldValue = evt.getOldValue();
					Object newValue = evt.getNewValue();
					if (!oldValue.equals(newValue)) {
						updateHistoryBeginingTime();
					}
				}
			}
		});

		historyPanel.add(dateChooser, BorderLayout.CENTER);
		historyPanel.add(timeSpinner, BorderLayout.EAST);
		historyPanel.setBorder(BorderFactory.createTitledBorder(I18N
				.getInstance().getValue("monitoring.label.period")));

		JSlider updateTimeSlider = new JSlider(JSlider.HORIZONTAL, 0, 300, 30);
		updateTimeSlider.setExtent(10);
		updateTimeSlider.setMinorTickSpacing(10);
		updateTimeSlider.setMajorTickSpacing(30);
		updateTimeSlider.setPaintTicks(true);
		updateTimeSlider.setPaintLabels(true);
		updateTimeSlider.setSnapToTicks(true);
		updateTimeSlider.setFont(SMALL_FONT);
		updateTimeSlider.setBorder(BorderFactory.createTitledBorder(I18N
				.getInstance().getValue("monitoring.label.refreshTime")));
		updateTimeSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					updateFrequency = source.getValue() * 1000;
					updater.setDelay(updateFrequency);
					updater.setInitialDelay(updateFrequency);
					updater.restart();
					log.info("New update interval is " + source.getValue()
							+ "s");
				}
			}
		});

		JButton resetButton = new JButton(i18n
				.getValue("monitoring.label.clearNow"));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frame, i18n
						.getValue("monitoring.confirmation.clear.message"),
						i18n.getValue("monitoring.confirmation.clear.title"),
						JOptionPane.OK_CANCEL_OPTION);
				if (choice == JOptionPane.OK_OPTION) {
					proxy.reset();
					updater.updateAll();
				}
			}
		});
		JPanel resetPanel = new JPanel();
		resetPanel.setBorder(BorderFactory.createTitledBorder(i18n
				.getValue("monitoring.label.history")));
		resetPanel.add(resetButton);

		JPanel controlPanel = new JPanel(new BorderLayout());
		controlPanel.add(historyPanel, BorderLayout.WEST);
		controlPanel.add(updateTimeSlider, BorderLayout.CENTER);
		controlPanel.add(resetPanel, BorderLayout.EAST);

		log.debug("Created!");
		
		return controlPanel;
	}

	private void updateHistoryBeginingTime() {
		beginingTime = new Date();
		try {
			Date date = dateChooser.getDate();
			Date time = (Date) timeSpinner.getValue();

			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTimeInMillis(date.getTime());

			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTimeInMillis(time.getTime());

			calendar2.set(Calendar.DAY_OF_MONTH, calendar1
					.get(Calendar.DAY_OF_MONTH));
			calendar2.set(Calendar.MONTH, calendar1.get(Calendar.MONTH));
			calendar2.set(Calendar.YEAR, calendar1.get(Calendar.YEAR));

			beginingTime = calendar2.getTime();

			long value = date.getTime();
			log.debug("Setting history begining time to " + value);
		} catch (Exception e) {
			beginingTime = new Date();
		}
		
		proxy.setHistoryBeginingTime(beginingTime);

		updater.updateAll();
	}
}
