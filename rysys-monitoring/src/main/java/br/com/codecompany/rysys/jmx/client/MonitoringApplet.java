/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codecompany.rysys.jmx.client;

import static br.com.codecompany.rysys.jmx.client.Constants.JMX_REMOTE_CREDENTIALS;

import br.com.codecompany.rysys.jmx.client.util.I18N;
import br.com.codecompany.rysys.jmx.client.util.PreferencesUtils;
import br.com.codecompany.rysys.jmx.client.util.Utils;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tsp0019
 */
public class MonitoringApplet extends JApplet {

	private static final Logger log = LoggerFactory.getLogger(JApplet.class);
	PreferencesUtils prefs = PreferencesUtils.getInstance();
	private JTextField user;
	private JTextField password;
	private JTextField host;
	private JFormattedTextField port;
	private JTextField url;
	private JDialog dialog;
	private boolean isApplet = false;
	private static I18N i18n = I18N.getInstance();
	private Container content;

	@Override
	public void init() {
		content = getContentPane();
		content.setLayout(new BorderLayout()); // Used to center the panel
		createApplet();
	}

	private void createApplet() {
		JPanel data = new JPanel(new GridLayout(4, 2, 5, 5));
		data.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		url = new JTextField("");
		url.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		url.setEditable(false);
		UrlUpater updater = new UrlUpater(url);

		user = new JTextField(prefs.getUser());
		password = new JPasswordField("");
		host = new JTextField(prefs.getHost());
		host.addKeyListener(updater);
		port = Utils.createIntegerField("#####");
		port.setValue(prefs.getPort());
		port.addKeyListener(updater);

		data.add(new JLabel(i18n.getValue("monitoring.login.user")));
		data.add(user);
		data.add(new JLabel(i18n.getValue("monitoring.login.password")));
		data.add(password);
		data.add(new JLabel(i18n.getValue("monitoring.login.host")));
		data.add(host);
		data.add(new JLabel(i18n.getValue("monitoring.login.port")));
		data.add(port);
		data.add(url);

		JPanel buttons = new JPanel();
		JButton ok = new JButton(i18n.getValue("monitoring.login.ok"));
		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				connectApplet();
			}
		});
		JButton cancel = new JButton(i18n.getValue("monitoring.login.cancel"));
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			}
		});
		buttons.add(ok);
		buttons.add(cancel);

		JPanel bottom = new JPanel(new BorderLayout());
		bottom.add(url, BorderLayout.NORTH);
		bottom.add(buttons, BorderLayout.CENTER);

		//dialog.add(data, BorderLayout.CENTER);
		//dialog.add(bottom, BorderLayout.SOUTH);
		content.add(data, BorderLayout.CENTER);
		content.add(bottom, BorderLayout.SOUTH);

		updater.update();
	}

	private void connectApplet() {
		log.debug("Connecting to remote host...");
		Map<String, String[]> env = new HashMap<String, String[]>();
		String[] credentials = new String[]{user.getText(),
			password.getText()};
		env.put(JMX_REMOTE_CREDENTIALS, credentials);
		try {
			if (!"".equals(concatenate(true))) {
				JmxProxy proxy = JmxProxy.getInstance(url.getText(), env);
				Monitor monitor = new Monitor(proxy, content);
				monitor.startApplet();
				savePrefs();
				dialog.dispose();
				log.debug("Connected!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(dialog, i18n.getValue("monitoring.error.connection.message"), i18n.getValue("monitoring.error.connection.title"),
					JOptionPane.ERROR_MESSAGE, null);
			log.error("Error creating JMX connection", e);
		}
	}

	private void savePrefs() {
		prefs.save(user.getText(), host.getText(), Integer.valueOf(port.getText()));
	}

	private String concatenate(boolean message) {
		String result = "";
		String _host = host.getText().trim();
		String _port = port.getText().trim();

		try {
			Integer.parseInt(_port);
			if ("".equals(_host) || "".equals(_port)) {
				if (message) {
					JOptionPane.showMessageDialog(dialog, i18n.getValue("monitoring.error.incomplete.message"),
							i18n.getValue("monitoring.error.incomplete.title"),
							JOptionPane.OK_OPTION);
				}
			} else {
				result = "service:jmx:rmi:///jndi/rmi://" + _host + ":" + _port
						+ "/jmxrmi";
			}
		} catch (Exception e) {
			if (message) {
				JOptionPane.showMessageDialog(dialog, i18n.getValue("monitoring.error.port.message"), i18n.getValue("monitoring.error.port.title"),
						JOptionPane.OK_OPTION);
			}
			log.error("Error starting monitoring", e);
		}

		return result;
	}

	private class UrlUpater implements KeyListener {

		private JTextField text;

		UrlUpater(JTextField text) {
			this.text = text;
		}

		public void keyPressed(KeyEvent keyEvent) {
			update();
		}

		public void keyReleased(KeyEvent keyEvent) {
			update();
		}

		public void keyTyped(KeyEvent keyEvent) {
			update();
		}

		void update() {
			text.setText(concatenate(false));
			SwingUtilities.updateComponentTreeUI(text);
		}
	}
}
