package br.com.codecompany.rysys.jmx.client.graph.treemap;

import static br.com.codecompany.rysys.jmx.client.Constants.TOOLTIP_LABEL_FONT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

import net.sf.jtreemap.swing.ColorProvider;
import net.sf.jtreemap.swing.DefaultValue;
import net.sf.jtreemap.swing.JTreeMap;
import net.sf.jtreemap.swing.SplitBySortedWeight;
import net.sf.jtreemap.swing.SplitStrategy;
import net.sf.jtreemap.swing.TreeMapNode;
import net.sf.jtreemap.swing.TreeMapNodeBuilder;
import net.sf.jtreemap.swing.Value;

public class DistributionTreeMapPanel extends JPanel {

	private static final long serialVersionUID = -4149419593702156498L;

	public DistributionTreeMapPanel(Map<String, Long[]> map, Color color) {
		super(new BorderLayout());
		JTreeMap treeMap = new JTreeMap(buildRoot(map));
		SplitStrategy strategy = new SplitBySortedWeight();

		ColorProvider colorProvider = new DistributionColorProvider(treeMap, color);

		treeMap.setFont(TOOLTIP_LABEL_FONT);
		treeMap.setToolTipBuilder(new DistributionToolTipBuilder(treeMap));
		treeMap.setStrategy(strategy);
		treeMap.setColorProvider(colorProvider);

		add(treeMap, BorderLayout.CENTER);
		add(colorProvider.getLegendPanel(), BorderLayout.SOUTH);
	}

	private TreeMapNode buildRoot(Map<String, Long[]> map) {
		final TreeMapNodeBuilder builder = new TreeMapNodeBuilder();
		final TreeMapNode rootNode = builder.buildBranch("Root", null);
		for (Entry<String, Long[]> entry : map.entrySet()) {
			long success = entry.getValue()[0];
			long errors = entry.getValue()[1];
			long total = success + errors;
			Value stability = new DefaultValue(errors);
			builder.buildLeaf(entry.getKey(), total, stability, rootNode);
		}
		return builder.getRoot();
	}
}
