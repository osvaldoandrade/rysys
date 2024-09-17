package br.com.codecompany.rysys.api.annotation;

import br.com.codecompany.rysys.api.annotation.core.AggregationField;
import br.com.codecompany.rysys.api.annotation.core.BigDecimalField;
import br.com.codecompany.rysys.api.annotation.core.CollectionField;
import br.com.codecompany.rysys.api.annotation.core.DateField;
import br.com.codecompany.rysys.api.annotation.core.DoubleField;
import br.com.codecompany.rysys.api.annotation.core.FloatField;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import br.com.codecompany.rysys.api.annotation.core.LongField;
import br.com.codecompany.rysys.api.annotation.core.TextField;
import br.com.codecompany.rysys.api.annotation.parser.AggregationFieldParser;
import br.com.codecompany.rysys.api.annotation.parser.BigDecimalFieldParser;
import br.com.codecompany.rysys.api.annotation.parser.CollectionFieldParser;
import br.com.codecompany.rysys.api.annotation.parser.DateFieldParser;
import br.com.codecompany.rysys.api.annotation.parser.DoubleFieldParser;
import br.com.codecompany.rysys.api.annotation.parser.FloatFieldParser;
import br.com.codecompany.rysys.api.annotation.parser.IntegerFieldParser;
import br.com.codecompany.rysys.api.annotation.parser.LongFieldParser;
import br.com.codecompany.rysys.api.annotation.parser.TextFieldParser;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GenericParserInfo implements ParserInfo {

	protected Map<Class<? extends Annotation>, Class<? extends FieldParser>> map;

	public GenericParserInfo() {
		map = setUpMap();
	}

	protected Map<Class<? extends Annotation>, Class<? extends FieldParser>> setUpMap() {
		Map<Class<? extends Annotation>, Class<? extends FieldParser>> genericMap =
				new HashMap<Class<? extends Annotation>, Class<? extends FieldParser>>();

		genericMap.put(AggregationField.class, AggregationFieldParser.class);
		genericMap.put(BigDecimalField.class, BigDecimalFieldParser.class);
		genericMap.put(CollectionField.class, CollectionFieldParser.class);
		genericMap.put(DateField.class, DateFieldParser.class);
		genericMap.put(DoubleField.class, DoubleFieldParser.class);
		genericMap.put(FloatField.class, FloatFieldParser.class);
		genericMap.put(IntegerField.class, IntegerFieldParser.class);
		genericMap.put(LongField.class, LongFieldParser.class);
		genericMap.put(TextField.class, TextFieldParser.class);

		return genericMap;
	}

	public Class<? extends FieldParser> getParser(Class<? extends Annotation> annotation) {
		Class<? extends FieldParser> parser = map.get(annotation);
		if (parser == null) {
			throw new IllegalArgumentException("Annotation '" + annotation.getSimpleName() +
					"' does not contain any parser associated");
		}
		return parser;
	}

	public boolean isValid(Class<? extends Annotation> annotation) {
		return map.containsKey(annotation);
	}

	public Set<Class<? extends Annotation>> validAnnotations() {
		return map.keySet();
	}
}
