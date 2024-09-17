package br.com.codecompany.rysys.api.annotation;

import java.lang.annotation.Annotation;

import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;

public class GenericResponsePopulator extends ResponsePopulator {

	public GenericResponsePopulator() {
		super(new GenericParserInfo());
	}

	public GenericResponsePopulator(ParserInfo info) {
		super(info);
	}

	@Override
	protected Class<? extends Annotation> annotationToCheck() {
		return DataDescriptor.class;
	}

	@Override
	protected String unwrapData(String stringToParse) {
		return stringToParse;
	}
}
