package br.com.codecompany.rysys.api.function;

public enum EisType {
	FGL,
	COBOL,
	LINUX,
	ISO8583;
    
    /**
     * @return The class implementation name for this EIS type
     */
    public String getClassName() {
        String className = null;
        
        if (this.equals(EisType.FGL)) {
			className = "br.com.codecompany.rysys.cobol.function.FglFunction";
		}
		else if (this.equals(EisType.LINUX)) {
			className = "br.com.codecompany.rysys.linux.function.LinuxFunction";
		}
		else if (this.equals(EisType.ISO8583)) {
			className = "br.com.codecompany.rysys.iso8583.function.Iso8583Function";
		}  
		else if (this.equals(EisType.COBOL)) {
			className = "br.com.codecompany.rysys.cobol.function.CobolFunction";
		}        
        
        return className;
    }

	public int intValue() {
		int value = 0;
		
        if (this.equals(EisType.FGL)) {
			value = 1;
		}
		else if (this.equals(EisType.COBOL)) {
			value = 3;
		}

		return value;
	}
}
