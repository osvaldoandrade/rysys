package br.com.codecompany.rysys.jmx.client.graph;

import br.com.codecompany.rysys.jmx.client.Constants;
import java.awt.BorderLayout;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.codecompany.rysys.jmx.client.Monitor;
import br.com.codecompany.rysys.jmx.client.util.I18N;
import java.awt.Component;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

import static br.com.codecompany.rysys.jmx.client.Constants.SUCCESS_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.ERROR_COLOR;
import static br.com.codecompany.rysys.jmx.client.Constants.IS_SYMBOLS_SUPPORTED;
import static br.com.codecompany.rysys.jmx.client.Constants.SYMBOLS_FONT;

public class SummaryPanel extends JPanel implements UpdateListener {

	private static final long serialVersionUID = -671027914082162988L;
	private Monitor monitor;
	private static I18N i18n = I18N.getInstance();

	public SummaryPanel(Monitor monitor) {
		super(new BorderLayout());
		this.monitor = monitor;
		update();
	}

	private JComponent createTable() {
		Map<String, Serializable> map = monitor.getProxy().summary();
		String[][] data = new String[map.size()][map.size()];
		int i = 0;
		for (Entry<String, Serializable> entry : map.entrySet()) {
			data[i][0] = i18n.getValue(entry.getKey());
			data[i++][1] = String.valueOf(entry.getValue());
		}

		// cria a tabela com as linha coloridas
		JTable table = new JTable(data, new String[]{
					i18n.getValue("monitoring.label.item"),
					i18n.getValue("monitoring.label.value")}) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				final String success = i18n.getValue("monitoring.summary.totalSuccess");
				final String errors = i18n.getValue("monitoring.summary.totalErrors");
				String first = String.valueOf(getValueAt(row, 0));
				Component component = (Component) super.prepareRenderer(renderer, row, column);

				if (first.equals(success)) {
					component.setForeground(SUCCESS_COLOR);
				} else if (first.equals(errors)) {
					component.setForeground(ERROR_COLOR);
				} else {
					component.setForeground(UIManager.getColor("TextField.foreground"));
				}

                if (IS_SYMBOLS_SUPPORTED) {
                    float size = component.getFont().getSize();
                    int style = component.getFont().getStyle();
                    component.setFont(SYMBOLS_FONT.deriveFont(style, size));
                    String fastest = i18n.getValue("monitoring.summary.fastestExecutedTime");
                    String slowest = i18n.getValue("monitoring.summary.slowestExecutedTime");
                    String more = i18n.getValue("monitoring.summary.moreExecutedTimes");
                    String less = i18n.getValue("monitoring.summary.lessExecutedTimes");
                    if (first.equals(fastest) || first.equals(slowest) ||
                        first.equals(more) || first.equals(less)) {
                        setValueAt(" \u2514\u2500\u2574" + first, row, 0);
                    }
                }

				return component;
			}
		};

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createCompoundBorder(
				new EmptyBorder(5, 5, 5, 5),
				new TitledBorder(i18n.getValue("monitoring.summary.title"))));

		return scrollPane;
	}

	public void update() {
		if (isVisible()) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					removeAll();
					JComponent table = createTable();
					add(table, BorderLayout.CENTER);
					validate();
				}
			});
		}
	}
}
