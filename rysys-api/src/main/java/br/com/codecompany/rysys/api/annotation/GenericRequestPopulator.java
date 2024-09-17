package br.com.codecompany.rysys.api.annotation;

import java.lang.annotation.Annotation;

import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;

public class GenericRequestPopulator extends RequestPopulator {

	public GenericRequestPopulator() {
		super(new GenericParserInfo());
	}

	public GenericRequestPopulator(ParserInfo info) {
		super(info);
	}

	@Override
	protected Class<? extends Annotation> annotationToCheck() {
		return DataDescriptor.class;
	}

	@Override
	protected String separatorToken() {
		return "";
	}

	@Override
	protected String wrapData(String result) {
		return result;
	}

}
