package br.com.codecompany.rysys.api.test.annotation;

import org.junit.Test;

import br.com.codecompany.rysys.api.annotation.ClassNotAnnotatedException;
import br.com.codecompany.rysys.api.test.ExampleNoDataDescriptor;

public class TestDataDescriptorAnnotation extends TestHelper {

	@Test(expected = ClassNotAnnotatedException.class)
	public void nonAnnotatedClass() {
		ExampleNoDataDescriptor annotation = new ExampleNoDataDescriptor();
		helper.extractFieldsAsString(annotation);
	}
}
