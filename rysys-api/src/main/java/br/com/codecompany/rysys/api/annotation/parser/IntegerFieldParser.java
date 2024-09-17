package br.com.codecompany.rysys.api.annotation.parser;

public class IntegerFieldParser extends LongFieldParser {

	@Override
	protected Number formatNumber(String numberAsString, int precision) {
		return super.formatNumber(numberAsString, precision).intValue();
	}

}
