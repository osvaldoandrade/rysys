package br.com.codecompany.rysys.jmx.client.graph.treemap;

import java.io.Serializable;

import javax.swing.JToolTip;

import net.sf.jtreemap.swing.IToolTipBuilder;
import net.sf.jtreemap.swing.JTreeMap;

/**
 * Default class to build the DistributionToolTip displayed by the JTreeMap.<BR>
 * 
 * @see net.sf.jtreemap.swing.DefaultToolTip
 * @author Laurent DUTHEIL
 * 
 */
public class DistributionToolTipBuilder implements IToolTipBuilder, Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = -1646772942428571187L;

	private JToolTip instance = null;

	private JTreeMap treeMap;

	/**
	 * Constructor.
	 * 
	 * @param treeMap
	 *            the linked JTreeMap
	 */
	public DistributionToolTipBuilder(final JTreeMap treeMap) {
		this.treeMap = treeMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.jtreemap.swing.IToolTipBuilder#getToolTip()
	 */
	public JToolTip getToolTip() {
		if (instance == null) {
			instance = new DistributionToolTip(this.treeMap);
		}
		return instance;
	}
}