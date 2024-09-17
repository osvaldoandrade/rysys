package br.com.codecompany.rysys.api.annotation.parser;

public class DoubleFieldParser extends BigDecimalFieldParser {
	
	@Override
	protected Number formatNumber(String numberAsString, int precision) {
		return super.formatNumber(numberAsString, precision).doubleValue();
	}
	
}