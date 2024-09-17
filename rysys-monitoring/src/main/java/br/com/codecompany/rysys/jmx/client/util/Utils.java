package br.com.codecompany.rysys.jmx.client.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;

import net.sf.jtreemap.swing.Value;

public final class Utils {

	// creates a field accepting only integers
	public static final JFormattedTextField createIntegerField(String decimalMask) {
		DecimalFormat df = new DecimalFormat(decimalMask);
		NumberFormatter nf = new NumberFormatter(df) {
			private static final long serialVersionUID = 1L;
            @Override
			public String valueToString(Object iv) throws ParseException {
		        if ((iv == null) || (((Integer)iv).intValue() == -1)) {
		            return "";
		        }
		        else {
		            return super.valueToString(iv);
		        }
		    }
            @Override
		    public Object stringToValue(String text) throws ParseException {
		        if ("".equals(text)) {
		            return null;
		        }
		        return super.stringToValue(text);
		    }
		};
		nf.setMinimum(0);
		nf.setMaximum(65534);
		nf.setValueClass(Integer.class);
		JFormattedTextField field = new JFormattedTextField(nf);
		field.setColumns(5);
		
		return field;
	}
	
	public static final void centerWindow(Window window) {
		// Get the screen size
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		// Calculate the frame location
		int x = (screenSize.width - window.getWidth()) / 2;
		int y = (screenSize.height - window.getHeight()) / 2;

		// Set the new frame location
		window.setLocation(x, y);
	}

	/**
	 * Calculates the standard deviation of an array of numbers. see Knuth's The
	 * Art Of Computer Programming Volume II: Seminumerical Algorithms This
	 * algorithm is slower, but more resistant to error propagation.
	 * 
	 * @param data
	 *            Numbers to compute the standard deviation of. Array must
	 *            contain two or more numbers.
	 * @return standard deviation estimate of population ( to get estimate of
	 *         sample, use n instead of n-1 in last line )
	 *         
	 * http://mindprod.com/jgloss/sd.html
	 */
	public static final double sd(double[] data) {
		final int n = data.length;
		if (n < 2) {
			return Double.NaN;
		}
		double avg = data[0];
		double sum = 0;
		for (int i = 1; i < data.length; i++) {
			double newavg = avg + (data[i] - avg) / (i + 1);
			sum += (data[i] - avg) * (data[i] - newavg);
			avg = newavg;
		}
		return Math.sqrt(sum / (n - 1));
	}
	
	public static final String toString(Value value) {
		return String.valueOf((int) value.getValue());
	}
}
