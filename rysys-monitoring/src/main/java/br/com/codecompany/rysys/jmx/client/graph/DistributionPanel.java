package br.com.codecompany.rysys.jmx.client.graph;

import static br.com.codecompany.rysys.jmx.client.Constants.SUCCESS_COLOR;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.codecompany.rysys.jmx.client.Monitor;
import br.com.codecompany.rysys.jmx.client.graph.treemap.DistributionTreeMapPanel;
import br.com.codecompany.rysys.jmx.client.util.I18N;
import br.com.codecompany.rysys.jmx.client.util.Utils;

public class DistributionPanel extends JPanel implements UpdateListener {

	private static final long serialVersionUID = -2562628456284114847L;
	
	private static final int MAX_FUNCTIONS = 10;
	
	private Monitor monitor;
	private int maxFunctions = MAX_FUNCTIONS;
	private DistributionTreeMapPanel treePanel;
	private static I18N i18n = I18N.getInstance();
	private JFormattedTextField set;
	private JRadioButton more;
	private JRadioButton all;

	public DistributionPanel(Monitor monitor) {
		super(new BorderLayout());
		this.monitor = monitor;
	}

	@SuppressWarnings("unchecked")
	private void populateMaps() {
		Object dataSet = monitor.getProxy().successErrosPerFunction(maxFunctions);
		Map<String, Long[]> map = (Map<String, Long[]>) dataSet;
		treePanel = new DistributionTreeMapPanel(map, SUCCESS_COLOR);
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(treePanel, BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5,
				5, 5, 5), new TitledBorder(updateTitle())));

		return panel;
	}

	private String updateTitle() {
		StringBuilder title = new StringBuilder(
		 i18n.getValue("monitoring.label.distribution"));
		title.append(" (");
		if (maxFunctions > 0) {
			title.append(maxFunctions);
			title.append(" ");
			title.append(i18n.getValue("monitoring.label.distributionMoreExecuted"));
		}
		else {
			title.append(i18n.getValue("monitoring.label.distributionAll"));
		}
		title.append(")");
		
		return title.toString();
	}

	private JPanel createControls() {	
		all = new JRadioButton(i18n.getValue("monitoring.label.distributionShowAll"));
		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maxFunctions = 0;
				update();
				updateTitle();
			}
		});

		JPanel westPanel = new JPanel(new BorderLayout());
		westPanel.add(all, BorderLayout.WEST);
		
		more = new JRadioButton(i18n.getValue("monitoring.label.distributionShowMore"));
		more.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSet();
				set.setText("");
				set.requestFocus();
			}
		});
		
		set = Utils.createIntegerField("###");
		set.setPreferredSize(new Dimension(30, 20));
		set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSet();
				update();
				updateTitle();
			}
		});		
		
		JLabel label = new JLabel(i18n.getValue("monitoring.label.distributionMoreExecuted"));
		label.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(more, BorderLayout.WEST);
		centerPanel.add(set, BorderLayout.CENTER);
		centerPanel.add(label, BorderLayout.EAST);

		ButtonGroup group = new ButtonGroup();
		group.add(more);
		group.add(all);

		JPanel historyPanel = new JPanel(new BorderLayout());
		historyPanel.add(westPanel, BorderLayout.WEST);
		historyPanel.add(centerPanel, BorderLayout.CENTER);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createCompoundBorder(								
				new EmptyBorder(0,5,0,5),
				new TitledBorder(i18n.getValue("monitoring.label.distributionSet"))));		
		panel.add(historyPanel, BorderLayout.WEST);

		selectRadio();
		updateTitle();
		
		return panel;
	}

	private void selectRadio() {
		if (maxFunctions <= 0) {
			all.setSelected(true);
			set.setText("");
		}
		else {
			more.setSelected(true);
			set.setText(String.valueOf(maxFunctions));
		}
	}

	private void updateSet() {
		try {
			int value = (Integer) set.getValue();
			maxFunctions = value;
			selectRadio();
		} catch (Exception e) {
			set.setValue(0);
		}
	}

	public void update() {
		if (isVisible()) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					removeAll();
					populateMaps();
					add(createControls(), BorderLayout.NORTH);
					add(createPanel(), BorderLayout.CENTER);
					validate();
				}
			});
		}
	}
}
