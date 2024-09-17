package br.com.codecompany.rysys.jmx.client.graph.treemap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Enumeration;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.sf.jtreemap.swing.ColorProvider;
import net.sf.jtreemap.swing.DefaultValue;
import net.sf.jtreemap.swing.JTreeMap;
import net.sf.jtreemap.swing.TreeMapNode;
import net.sf.jtreemap.swing.Value;
import br.com.codecompany.rysys.jmx.client.util.I18N;
import br.com.codecompany.rysys.jmx.client.util.Utils;

import static br.com.codecompany.rysys.jmx.client.Constants.SMALL_FONT;

public class DistributionColorProvider extends ColorProvider {

	private static final int HSBVAL_SIZE = 3;

	/**
     * 
     */
	private static final long serialVersionUID = 5009655580804320847L;

	private JTreeMap jTreeMap;

	private JPanel legend;

	private Value maxValue;

	private Value minValue;

	private float positiveHue;

	private float positiveSaturation = 1f;

	/**
	 * @author Andy Adamczak
	 */
	public enum ColorDistributionTypes {
		Linear, Log, Exp, SquareRoot, CubicRoot
	}

	/**
	 * @param treeMap
	 * @param color
	 */
	public DistributionColorProvider(final JTreeMap treeMap, final Color color) {
		super();
		jTreeMap = treeMap;
		adjustColor(color);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.jtreemap.swing.ColorProvider#getLegendPanel()
	 */
	@Override
	public JPanel getLegendPanel() {
		if (legend == null) {
			legend = new Legend();
		}

		return legend;
	}

	/**
	 * @param positiveColor
	 * @param negativeColor
	 */
	public void adjustColor(final Color positiveColor) {
		// Figure out the hue of the passed in colors. Note, greys will map to
		// reds in this color space, so use the
		// hue/saturation
		// constructions for grey scales.
		float[] hsbvals = new float[HSBVAL_SIZE];

		hsbvals = Color.RGBtoHSB(positiveColor.getRed(), positiveColor
				.getGreen(), positiveColor.getBlue(), hsbvals);
		positiveHue = hsbvals[0];
		positiveSaturation = 1f;
	}

	/**
	 * @param hue
	 * @param saturation
	 */
	public void adjustColor(final float hue, final float saturation) {
		adjustColor(hue, saturation, hue, saturation);
	}

	/**
	 * @param posHue
	 * @param posSaturation
	 * @param negHue
	 * @param negSaturation
	 */
	public void adjustColor(final float posHue, final float posSaturation,
			final float negHue, final float negSaturation) {
		this.positiveHue = posHue;
		this.positiveSaturation = posSaturation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.sf.jtreemap.swing.ColorProvider#getColor(net.sf.jtreemap.swing.Value)
	 */
	@Override
	public Color getColor(final Value value) {
		// Figure out the current range of colors, map that range into a scale
		// from 0 to 1,
		// using the specified distribution type
		if (maxValue == null || minValue == null) {
			setValues(jTreeMap.getRoot());
		}
		final double max = this.maxValue.getValue();
		final double min = this.minValue.getValue();
		double val = (value != null ? value.getValue() : 0.00);

		if (val >= 0) {
			double range = max - Math.max(0, min);
			val -= Math.max(0, min);
			float brightness = 1 - (float) ((val / range) * 0.8);

			Color color = Color.getHSBColor(positiveHue, positiveSaturation,
					brightness);

			return color;
		} else {
			throw new IllegalArgumentException("Value must be >= 0");
		}
	}

	/**
	 * Set the max and the min values in the tree map
	 * 
	 * @param root
	 *            root of the JTreeMap
	 */
	private void setValues(final TreeMapNode root) {
		if (root.isLeaf()) {
			final Value value = root.getValue();

			if (value == null) {
				return;
			}

			if (maxValue == null || value.getValue() >= maxValue.getValue()) {
				try {
					final Class<?> c = value.getClass();
					if (maxValue == null) {
						maxValue = (Value) (c.newInstance());
					}
					maxValue.setValue(value.getValue());
				} catch (final IllegalAccessException iae) {
					// ignore
				} catch (final InstantiationException ie) {
					// Ignore
					ie.printStackTrace();
				}
			}

			if (minValue == null || value.getValue() <= minValue.getValue()) {
				try {
					final Class<?> c = value.getClass();
					if (minValue == null) {
						minValue = (Value) (c.newInstance());
					}
					minValue.setValue(value.getValue());
				} catch (final IllegalAccessException iae) {
					// ignore
				} catch (final InstantiationException ie) {
					// Ignore
					ie.printStackTrace();
				}
			}
		} else {
			for (final Enumeration<?> e = root.children(); e.hasMoreElements();) {
				final TreeMapNode node = (TreeMapNode) e.nextElement();
				setValues(node);
			}
		}
	}

	/**
	 * Panel with the legend
	 * 
	 * @author Laurent Dutheil
	 */
	private class Legend extends JPanel {

		private static final long serialVersionUID = 6371342387871103592L;

		private static final int HEIGHT = 20;

		private static final int WIDTH = 120;

		private static final int X = 20;

		private static final int Y = 25;

		private static final int X_INSET = 2 * X;

		private static final int Y_INSET = 2 * Y;

		/**
		 * Constructor of Legend
		 */
		public Legend() {
			this.setSize(new Dimension(X_INSET + Legend.WIDTH, Y_INSET
					+ Legend.HEIGHT));
			this.setPreferredSize(new Dimension(X_INSET + Legend.WIDTH, Y_INSET
					+ Legend.HEIGHT));
			this.setBorder(new TitledBorder(I18N.getInstance().getValue(
					"monitoring.label.distributionLegend")));
		}

		@Override
		public void paintComponent(final Graphics g) {
			super.paintComponent(g);
			if (DistributionColorProvider.this.minValue == null
					|| DistributionColorProvider.this.maxValue == null) {
				setValues(DistributionColorProvider.this.jTreeMap.getRoot());
			}
			final Value min = DistributionColorProvider.this.minValue;
			final Value max = DistributionColorProvider.this.maxValue;

			Font font = SMALL_FONT;
			g.setFont(font);
			g.setColor(Color.black);
			
			if (min != null && max != null) {
				int fontHeight = getFontMetrics(font).getHeight();
				int textY = Y + HEIGHT + (fontHeight * 5 / 6);
				
				// start
				String minText = Utils.toString(min);
				int minTextWidth = getFontMetrics(font).stringWidth(minText) / 2;
				g.drawString(minText, X - minTextWidth, textY);

				// end
				String maxText = Utils.toString(max);
				int maxTextWidth = getFontMetrics(font).stringWidth(maxText) / 2;
				g.drawString(maxText, X + WIDTH
						- maxTextWidth, textY);

				final double step = (max.getValue() - min.getValue())
						/ WIDTH;
				final Value value = new DefaultValue(min.getValue());
				for (int i = 0; i < WIDTH; i++) {
					g.setColor(DistributionColorProvider.this.getColor(value));
					g.fillRect(X + i, Y, 1, HEIGHT);
					value.setValue(value.getValue() + step);
				}
			}
		}
	}
}
