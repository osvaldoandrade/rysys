package br.com.codecompany.rysys.api.annotation;

public enum Direction {
	FROM_EIS,
	TO_EIS,
	FROM_TO_EIS;
	
	public boolean isFROM() {
		return this.equals(FROM_EIS) || this.equals(FROM_TO_EIS);
	}
	
	public boolean isTO() {
		return this.equals(TO_EIS) || this.equals(FROM_TO_EIS);
	}
}
