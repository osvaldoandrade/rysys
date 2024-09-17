package br.com.codecompany.rysys.api.test.annotation;

import br.com.codecompany.rysys.api.test.ExampleCollection;
import br.com.codecompany.rysys.api.test.ExampleCollection2;
import junit.framework.Assert;

import org.junit.Test;

import br.com.codecompany.rysys.api.test.to.CadastroCedenteFiltroTO;
import br.com.codecompany.rysys.api.test.to.TipoJurosListaTO;
import br.com.codecompany.rysys.api.test.to.TipoJurosTO;
import java.math.BigDecimal;
import java.math.BigInteger;

public class TestCollectionFieldAnnotation2 extends TestHelper {
	
	@Test
	public void extractRequestData() {
		CadastroCedenteFiltroTO pojo = new CadastroCedenteFiltroTO();	
		pojo.setCodCedente(1);
		pojo.setUsuario("P525195");
		
		String expected = "00010000                  0000000000000001P525195 ";
		Assert.assertEquals(expected, helper.extractFieldsAsString(pojo));
	}
	
	@Test
	public void populateResponseData() {
		String response = 
			    "05" +
			    "0SEM JUROS                               " +
				"1JUROS DA CAIXA                          " +
				"2JUROS DO CEDENTE                        " +
				"8TESTE ALTERAR                           " +
				"9JUROS TESTE                             ";
		TipoJurosListaTO to = new TipoJurosListaTO();			
		helper.populateFields(to, response);	
		
		Assert.assertEquals(5, to.getListaTpJuros().size());
		
		TipoJurosTO juros0 = new TipoJurosTO();
		juros0 = to.getListaTpJuros().get(0);
		Assert.assertEquals(0, juros0.getTpJuros());
		Assert.assertEquals("SEM JUROS", juros0.getDescricaoTpJuros());
		
		TipoJurosTO juros1 = new TipoJurosTO();
		juros1 = to.getListaTpJuros().get(1);
		Assert.assertEquals(1, juros1.getTpJuros());
		Assert.assertEquals("JUROS DA CAIXA", juros1.getDescricaoTpJuros());
		
		TipoJurosTO juros2 = new TipoJurosTO();
		juros2 = to.getListaTpJuros().get(2);
		Assert.assertEquals(2, juros2.getTpJuros());
		Assert.assertEquals("JUROS DO CEDENTE", juros2.getDescricaoTpJuros());
		
		TipoJurosTO juros3 = new TipoJurosTO();
		juros3 = to.getListaTpJuros().get(3);
		Assert.assertEquals(8, juros3.getTpJuros());
		Assert.assertEquals("TESTE ALTERAR", juros3.getDescricaoTpJuros());		
		
		TipoJurosTO juros4 = new TipoJurosTO();
		juros4 = to.getListaTpJuros().get(4);
		Assert.assertEquals(9, juros4.getTpJuros());
		Assert.assertEquals("JUROS TESTE", juros4.getDescricaoTpJuros());			
	}

	@Test
	public void extractEmptyListWithTotal() {
		// exibe total de uma lista vazia
		ExampleCollection collection = new ExampleCollection();
		collection.getList().add(3);
		String request = helper.extractFieldsAsString(collection);
		Assert.assertEquals("130", request);
	}

	@Test
	public void extractEmptyListWithoutTotal() {
		ExampleCollection2 collection2 = new ExampleCollection2();
		collection2.getList2().add(new BigDecimal("12"));
		collection2.getList2().add(new BigDecimal("45"));
		String request2 = helper.extractFieldsAsString(collection2);
		Assert.assertEquals("200000000120000000045", request2);
	}
}
