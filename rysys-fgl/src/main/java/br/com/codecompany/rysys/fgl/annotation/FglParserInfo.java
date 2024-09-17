package br.com.codecompany.rysys.fgl.annotation;

import br.com.codecompany.rysys.api.annotation.FieldParser;
import br.com.codecompany.rysys.api.annotation.GenericParserInfo;
import br.com.codecompany.rysys.api.annotation.core.DateField;
import br.com.codecompany.rysys.api.annotation.core.FloatField;
import br.com.codecompany.rysys.api.annotation.core.LongField;
import br.com.codecompany.rysys.api.annotation.core.TextField;
import br.com.codecompany.rysys.api.annotation.parser.DateFieldParser;
import br.com.codecompany.rysys.api.annotation.parser.FloatFieldParser;
import br.com.codecompany.rysys.api.annotation.parser.LongFieldParser;
import br.com.codecompany.rysys.api.annotation.parser.TextFieldParser;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class FglParserInfo extends GenericParserInfo {

	@Override
	protected Map<Class<? extends Annotation>, Class<? extends FieldParser>> setUpMap() {
		Map<Class<? extends Annotation>, Class<? extends FieldParser>> genericMap =
				new HashMap<Class<? extends Annotation>, Class<? extends FieldParser>>();

		genericMap.put(DateField.class, DateFieldParser.class);
		genericMap.put(FloatField.class, FloatFieldParser.class);
		genericMap.put(LongField.class, LongFieldParser.class);
		genericMap.put(TextField.class, TextFieldParser.class);

		return genericMap;
	}
	
}
