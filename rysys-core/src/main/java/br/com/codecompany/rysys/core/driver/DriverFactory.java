package br.com.codecompany.rysys.core.driver;

public class DriverFactory {
	
	public static final String INFORMIX_FGL = "INFORMIX_FGL";
	public static final String MF_COBOL = "MF_COBOL";
	public static final String ISO_8583 = "ISO-8583";

	public static final String getStrategy(String name) {
		String strategy = null;
		
		if (name != null) {
			if (INFORMIX_FGL.equalsIgnoreCase(name)) {
				strategy = "br.com.codecompany.rysys.fgl.driver.FglAdapter";
			} 
			else if (ISO_8583.equalsIgnoreCase(name)) {
				strategy = "br.com.codecompany.rysys.iso8583.driver.Iso8583Adapter";
			}
			else if (MF_COBOL.equalsIgnoreCase(name)) {
				strategy = "br.com.codecompany.rysys.cobol.driver.CobolAdapter";
			}
			else if (!"".equals(name.trim())) {
				strategy = name;
			}
		}
		
		if (strategy == null) {
			throw new InvalidDriverException("'" + name
					+ "' is not a valid driver type");
		}
		
		return strategy;
	}
}
