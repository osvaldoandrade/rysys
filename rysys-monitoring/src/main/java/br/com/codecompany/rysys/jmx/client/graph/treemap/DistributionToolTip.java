package br.com.codecompany.rysys.jmx.client.graph.treemap;

import static br.com.codecompany.rysys.jmx.client.Constants.TOOLTIP_LABEL_FONT;
import static br.com.codecompany.rysys.jmx.client.Constants.TOOLTIP_VALUE_FONT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JToolTip;

import net.sf.jtreemap.swing.JTreeMap;
import net.sf.jtreemap.swing.TreeMapNode;
import br.com.codecompany.rysys.jmx.client.util.I18N;
import br.com.codecompany.rysys.jmx.client.util.Utils;

public class DistributionToolTip extends JToolTip {

	private static final int TOOLTIP_OFFSET = 5;

	private static final long serialVersionUID = -2492627777999093973L;

	private JTreeMap jTreeMap;

	private String errorSuffix;

	private String totalSuffix;

	private Font labelFont;

	private Font valueFont;

	/**
	 * Constructor.
	 * 
	 * @param jTreeMap
	 *            the jTreeMap who display the tooltip
	 */
	public DistributionToolTip(final JTreeMap jTreeMap) {
		this.jTreeMap = jTreeMap;
		this.errorSuffix = I18N.getInstance().getValue(
				"monitoring.label.distributionErrorsSuffix");
		this.totalSuffix = I18N.getInstance().getValue(
				"monitoring.label.distributionTotalSuffix");
		this.labelFont = TOOLTIP_LABEL_FONT;
		this.valueFont = TOOLTIP_VALUE_FONT;

		final int width = 160;
		final int height = getFontMetrics(this.labelFont).getHeight()
				+ getFontMetrics(this.valueFont).getHeight() * 2;

		final Dimension size = new Dimension(width, height);
		this.setSize(size);
		this.setPreferredSize(size);
	}

	@Override
	public void paint(final Graphics g) {
		if (this.jTreeMap.getActiveLeaf() != null) {
			Graphics g2D = (Graphics) g;
			g2D.setColor(Color.LIGHT_GRAY);
			g2D.fill3DRect(0, 0, this.getWidth(), this.getHeight(), true);
			g2D.setColor(Color.black);

			g2D.setFont(this.labelFont);
			g2D.drawString(this.jTreeMap.getActiveLeaf().getLabel(),
					TOOLTIP_OFFSET, g2D.getFontMetrics(this.labelFont)
							.getAscent());

			g2D.setFont(this.valueFont);
			TreeMapNode node = this.jTreeMap.getActiveLeaf();

			String total = ((long) node.getWeight()) + " " + totalSuffix;
			g2D.drawString(total, TOOLTIP_OFFSET, this.getHeight()
					- getFontMetrics(this.labelFont).getHeight());

			String errors = Utils.toString(node.getValue()) + " " + errorSuffix;
			g2D.drawString(errors, TOOLTIP_OFFSET, this.getHeight()
					- TOOLTIP_OFFSET);
		}
	}
}
