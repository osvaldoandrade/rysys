package br.com.codecompany.rysys.api.annotation.parser;

import java.math.BigDecimal;
import org.apache.commons.lang.StringUtils;
import br.com.codecompany.rysys.api.annotation.InvalidPrecisionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigDecimalFieldParser extends LongFieldParser {

	private static Logger log = LoggerFactory.getLogger(BigDecimalFieldParser.class);

	// um numero decimal sempre eh representado como uma sequencia de digitos.
	// A precisao especifica a quantidade de decimais.
	// Por exemplo, 12345 com duas decimais = 123.45
	@Override
	protected Number formatNumber(String numberAsString, int precision) {
		
		// formata o numero como um inteiro, considerando +/-
		String number = handleSignal(numberAsString);
		
		if (precision > number.length() && !"0".equals(number)) {
			throw new InvalidPrecisionException("Precision (" + precision + ") could " +
					"not be greater than number length (" + number.length() + ")");
		}
		
		// parte inteira do numero
		String integerPart = StringUtils.left(number, 
				number.length() - precision);
		
		// parte decimal
		String decimalPart = StringUtils.right(number, precision);
		
		return new BigDecimal(integerPart.trim() + '.' + decimalPart.trim());
	}

	@Override
	protected String formatNumber(Object value, int length, int precision,
			char filler) {

        String number = "";

        if (!"".equals(value)) {
            // arredonda para o numero de casas correspondente
            BigDecimal decimal = new BigDecimal(String.valueOf(value)).setScale(precision,
                    BigDecimal.ROUND_HALF_UP);
            number = String.valueOf(decimal);
        }

		int index = number.lastIndexOf('.');
		
		// numero inteiro
		if (index < 0) {
			// adiciona a precisao
			number += StringUtils.repeat("0", precision);
		}
		else {
			// diferenca entre a precisao atual e a esperada
			int gap = precision - (number.length() - index - 1);
			// complementa a precisao
			number += StringUtils.repeat("0", gap);
			number = number.replaceAll("\\.", "");
		}

		// caso o atributo 'length' nao seja informado (<=0),
		// usa o tamanho do valor da propriedade
		if (length <= 0) {
			length = number.length();
			log.debug("Length attribute ignored. " +
					"Using property value's length ({})", length);
		}

		// depois de tratado, formata o numero como um Long
		return super.formatNumber(number, length, precision, filler);
	}
}
