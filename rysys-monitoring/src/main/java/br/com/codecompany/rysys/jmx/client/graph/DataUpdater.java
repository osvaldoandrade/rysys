package br.com.codecompany.rysys.jmx.client.graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataUpdater extends Timer implements ActionListener {
	
	private static final long serialVersionUID = 2872152978757799523L;
	
	private static final Logger log = LoggerFactory.getLogger(DataUpdater.class);

	private int updateInterval = 0;
	
	private List<UpdateListener> listeners = new ArrayList<UpdateListener>();
	
	public DataUpdater(int updateInterval) {
		super(updateInterval, null);
		this.updateInterval = updateInterval;
		addActionListener(this);
	}
	
	public int getUpdateInterval() {
		return updateInterval;
	}
	
	public void setUpdateInterval(int updateInterval) {
		this.updateInterval = updateInterval;
	}
	
	public void addListener(UpdateListener listener) {
		listeners.add(listener);
	}

	public void actionPerformed(ActionEvent event) {
		updateAll();
	}

	public void updateAll() {
		log.debug("Update action executed");
		for (UpdateListener listener : listeners) {
			listener.update();
		}
	}
}
