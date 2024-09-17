package br.com.codecompany.rysys.jmx.client;

import br.com.codecompany.rysys.jmx.client.graph.SummaryPanel;
import java.awt.Color;
import java.awt.Font;

import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.UIManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

    private static Logger log = LoggerFactory.getLogger(Constants.class);

	public static final String JMX_BEAN = "rysys:type=Adapter";
	public static final String JMX_URL = "service:jmx:rmi:///jndi/rmi://localhost:8686/jmxrmi";
	public static final String JMX_REMOTE_CREDENTIALS = "jmx.remote.credentials";

	public static final Color BACKGROUD_COLOR = UIManager.getDefaults()
			.getColor("Panel.background");
	public static final Color SUCCESS_COLOR = Color.green.darker();
	public static final Color ERROR_COLOR = Color.red.darker();
	public static final Color WARNING_COLOR = Color.orange.darker();
	public static final Color NEUTRAL_COLOR = Color.blue;
	public static final Color RANGE_COLOR = Color.magenta;

	public static final Font NORMAL_FONT = UIManager.getDefaults().getFont(
			"Panel.font");
	public static final Font SMALL_FONT = new Font("Default", Font.PLAIN, 11);
	public static final Font BIG_FONT = new Font("Default", Font.PLAIN, 12);
	public static final Font HUGE_FONT = new Font("Default", Font.BOLD, 14);

	public static final Font CHART_TICK_LABEL_FONT = new Font("Default",
			Font.PLAIN, 11);
	public static final Font CHART_AXIS_LABEL_FONT = new Font("Default",
			Font.BOLD, 11);
	public static final Font CHART_LEGEND_FONT = new Font("Default",
			Font.PLAIN, 10);
	public static final Font CHART_BAR_ITEM_FONT = new Font("Default",
			Font.PLAIN, 11);
	public static final Font CHART_NO_DATA_FONT = new Font("Default",
			Font.PLAIN, 10);

    // http://dejavu-fonts.org/wiki/index.php?title=PDF_samples
    public static Font SYMBOLS_FONT = SMALL_FONT;
    public static boolean IS_SYMBOLS_SUPPORTED = false;
	static {
		try {
			InputStream stream = Constants.class.getResourceAsStream("/DejaVuSansCondensed.ttf");
			SYMBOLS_FONT = Font.createFont(Font.PLAIN, stream).deriveFont(Font.PLAIN, 10);
            IS_SYMBOLS_SUPPORTED = true;
            log.debug("Font DejaVuSansMono found, symbols rendering enabled");
		} catch (FontFormatException e) {
			log.warn("Error loading DejaVuSansMono font: {}", e.getMessage());
		} catch (IOException e) {
			log.warn("Error reading DejaVuSansMono font file: {}", e.getMessage());
		}
    }

	public static final Color CHART_BACKGROUND_COLOR = Color.lightGray;
	public static final Color CHART_GRID_COLOR = Color.white;

	public static final int MAX_AGE = 30000;
	public static final int MAXIMUM_ITEM_COUNT = 5;

	// treemap
	public static final Font TOOLTIP_LABEL_FONT = new Font("Default",
			Font.BOLD, 12);
	public static final Font TOOLTIP_VALUE_FONT = new Font("Default",
			Font.PLAIN, 10);
}
