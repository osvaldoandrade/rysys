package br.com.codecompany.rysys.api.annotation.parser;

import br.com.codecompany.rysys.util.FormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongFieldParser extends NumberFieldParser {

	private static Logger log = LoggerFactory.getLogger(LongFieldParser.class);
	
	@Override
	protected Number formatNumber(String numberAsString, int precision) {
        return Long.valueOf(handleSignal(numberAsString));
	}

    protected String handleSignal(String numberAsString) {
        String number = numberAsString.trim();

        // possui sinal negativo?
        boolean negative = containsNegativeSign(number);

        // remove +/-
        number = removeSignChars(number);

        // o numero possui sinal
        if (negative) {
            number = "-" + number;
        }
        return number;
    }

    @Override
    protected String formatNumber(Object value, int length, int precision, char filler) {
    	String number = String.valueOf(value);
    	
    	// possui sinal negativo?
    	boolean negative = containsNegativeSign(number);
		
		// remove +/-
		number = removeSignChars(number);

		// caso o atributo 'length' nao seja informado (<=0),
		// usa o tamanho do valor da propriedade
		if (length <= 0) {
			length = number.length();
			log.debug("Length attribute ignored. " +
					"Using property value's length ({})", length);
		}

        String result =  FormatUtils.fillLeft(number, filler, length);
        
        if (negative) {
        	result = "-" + result.substring(1);
        }
        
        return result;
    }
	
	protected boolean containsNegativeSign(String number) {
		number = number.trim();
		return number.startsWith("-") ||  number.endsWith("-");
	}
	
	protected String removeSignChars(String number) {
		return number.replaceAll("[\\-\\+]", "");
	}
}
