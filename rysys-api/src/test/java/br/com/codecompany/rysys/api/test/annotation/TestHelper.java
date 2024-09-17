package br.com.codecompany.rysys.api.test.annotation;

import org.junit.Before;

import br.com.codecompany.rysys.api.annotation.GenericRequestPopulator;
import br.com.codecompany.rysys.api.annotation.GenericResponsePopulator;
import br.com.codecompany.rysys.api.annotation.PopulatorHelper;

public abstract class TestHelper {
	
	protected PopulatorHelper helper;
	
	@Before
	public void setUp() {
		GenericRequestPopulator request = new GenericRequestPopulator();
		GenericResponsePopulator response = new GenericResponsePopulator();
		helper = new PopulatorHelper(request, response);		
	}
	
}
