package br.com.codecompany.rysys.iso8583.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.driver.ConnectionException;
import br.com.codecompany.rysys.iso8583.driver.Iso8583Adapter;
import br.com.codecompany.rysys.iso8583.sirot.SirotAdapter;
import br.com.codecompany.rysys.iso8583.test.dao.CedenteDAO;
import br.com.codecompany.rysys.iso8583.test.dao.ConsultasGeraisTitulosDAO;
import br.com.codecompany.rysys.iso8583.test.to.CadastroCedenteFiltroTO;
import br.com.codecompany.rysys.iso8583.test.to.CadastroCedenteTO;
import br.com.codecompany.rysys.iso8583.test.to.ConsultaCateiraCobrancaListaTO;
import br.com.codecompany.rysys.iso8583.test.to.GuiaDebCredListaTO;
import br.com.codecompany.rysys.iso8583.test.to.RamoAtividadeListaTO;
import br.com.codecompany.rysys.iso8583.test.to.SetorListaTO;
import br.com.codecompany.rysys.iso8583.test.to.TipoJurosListaTO;
import br.com.codecompany.rysys.iso8583.test.to.TitulosAlteradosFiltroTO;
import br.com.codecompany.rysys.iso8583.test.to.TitulosAlteradosListaTO;
import br.com.codecompany.rysys.util.ToStringUtils;

public class Client {

	private static final Logger log = LoggerFactory.getLogger(Client.class);
	
	private String host;
	private int port;
	
	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	private Iso8583Adapter createAdapter() {
		Iso8583Adapter adapter = new SirotAdapter();
		adapter.setHostname(host);
		adapter.setPort(port);
		adapter.setTimeout(3000);
		try {
			adapter.connect();
		} catch (ConnectionException e) {
			throw new RuntimeException("Could not connect");
		}
		return adapter;
	}
	
	public void executeTest() {		
		CadastroCedenteFiltroTO cadastroCedenteFiltroTO = new CadastroCedenteFiltroTO();		
		consultarRamosDeAtividade(cadastroCedenteFiltroTO);
		listarRamosDeAtividade(cadastroCedenteFiltroTO);
		listarSetores(cadastroCedenteFiltroTO);	
		listarCarteiraCobranca(cadastroCedenteFiltroTO);
		obterDadosPreInclusaoCedente(cadastroCedenteFiltroTO);
		consultaDadosCedenteSicli(cadastroCedenteFiltroTO);
		consultarContasDebCredRateio(cadastroCedenteFiltroTO);	
		obterTitulosAlterados();	
	}

	private void consultarRamosDeAtividade(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		try {
			log.debug("----------------------------------------------------------------------------");
			log.debug("Executing CedenteDAO.consultarRamosDeAtividade()");
			log.debug("----------------------------------------------------------------------------");		
			CedenteDAO cedenteDAO = new CedenteDAO(createAdapter());
			RamoAtividadeListaTO ramo = cedenteDAO.consultarRamosDeAtividade(cadastroCedenteFiltroTO);
			log.debug("Result:" + ToStringUtils.toString(ramo));
			log.debug("----------------------------------------------------------------------------");
			log.debug("End of execution of CedenteDAO.consultarRamosDeAtividade()");
			log.debug("----------------------------------------------------------------------------");
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
	}
	
	private void listarRamosDeAtividade(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		try {
			log.debug("Executing CedenteDAO.listarRamosDeAtividade()");
			log.debug("----------------------------------------------------------------------------");			
			CedenteDAO cedenteDAO = new CedenteDAO(createAdapter());			
			TipoJurosListaTO juros = cedenteDAO.listarRamosDeAtividade(cadastroCedenteFiltroTO);
			log.debug("Result:" + ToStringUtils.toString(juros));			
			log.debug("----------------------------------------------------------------------------");
			log.debug("End of execution of CedenteDAO.listarRamosDeAtividade()");
			log.debug("----------------------------------------------------------------------------");	
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
	}	
	
	private void listarSetores(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		try {				
			log.debug("Executing CedenteDAO.listarSetores()");
			log.debug("----------------------------------------------------------------------------");				
			CedenteDAO cedenteDAO = new CedenteDAO(createAdapter());			
			SetorListaTO setor = cedenteDAO.listarSetores(cadastroCedenteFiltroTO);
			log.debug("Result:" + ToStringUtils.toString(setor));			
			log.debug("----------------------------------------------------------------------------");
			log.debug("End of execution of CedenteDAO.listarSetores()");
			log.debug("----------------------------------------------------------------------------");			
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
	}
	
	private void listarCarteiraCobranca(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		try {		
			log.debug("Executing CedenteDAO.listarCarteiraCobranca()");
			log.debug("----------------------------------------------------------------------------");				
			CedenteDAO cedenteDAO = new CedenteDAO(createAdapter());			
			ConsultaCateiraCobrancaListaTO carteira = 
				cedenteDAO.listarCarteiraCobranca(cadastroCedenteFiltroTO);
			log.debug("Result:" + ToStringUtils.toString(carteira));			
			log.debug("----------------------------------------------------------------------------");
			log.debug("End of execution of CedenteDAO.listarCarteiraCobranca()");
			log.debug("----------------------------------------------------------------------------");	
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
	}
	
	private void obterDadosPreInclusaoCedente(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		try {		
			log.debug("Executing CedenteDAO.obterDadosPreInclusaoCedente()");
			log.debug("----------------------------------------------------------------------------");				
			CedenteDAO cedenteDAO = new CedenteDAO(createAdapter());			
			CadastroCedenteTO cedente = cedenteDAO.obterDadosPreInclusaoCedente(cadastroCedenteFiltroTO);
			log.debug("Result:" + ToStringUtils.toString(cedente));			
			log.debug("----------------------------------------------------------------------------");
			log.debug("End of execution of CedenteDAO.obterDadosPreInclusaoCedente()");
			log.debug("----------------------------------------------------------------------------");	
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
	}
	
	private void consultaDadosCedenteSicli(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		try {
			log.debug("Executing CedenteDAO.consultaDadosCedenteSicli()");
			log.debug("----------------------------------------------------------------------------");			
			CedenteDAO cedenteDAO = new CedenteDAO(createAdapter());			
			CadastroCedenteFiltroTO cedenteFiltro = 
				cedenteDAO.consultaDadosCedenteSicli(cadastroCedenteFiltroTO);
			log.debug("Result:" + ToStringUtils.toString(cedenteFiltro));
			log.debug("----------------------------------------------------------------------------");
			log.debug("End of execution of CedenteDAO.consultaDadosCedenteSicli()");
			log.debug("----------------------------------------------------------------------------");				
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
	}

	private void consultarContasDebCredRateio(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		try {
			log.debug("Executing CedenteDAO.consultarContasDebCredRateio()");
			log.debug("----------------------------------------------------------------------------");			
			CedenteDAO cedenteDAO = new CedenteDAO(createAdapter());			
			GuiaDebCredListaTO guia = cedenteDAO.consultarContasDebCredRateio(cadastroCedenteFiltroTO);
			log.debug("Result:" + ToStringUtils.toString(guia));
			log.debug("----------------------------------------------------------------------------");
			log.debug("End of execution of CedenteDAO.consultarContasDebCredRateio()");
			log.debug("----------------------------------------------------------------------------");			
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
	}
	
	private void obterTitulosAlterados() {
		try {				
			log.debug("Executing ConsultasGeraisTitulosDAO.obterTitulosAlterados()");
			log.debug("----------------------------------------------------------------------------");			
			ConsultasGeraisTitulosDAO consultasGeraisTitulosDAO = 
				new ConsultasGeraisTitulosDAO(createAdapter());
			TitulosAlteradosFiltroTO titulosAlteradosFiltroTO = 
				new TitulosAlteradosFiltroTO();			
			TitulosAlteradosListaTO lista = consultasGeraisTitulosDAO.obterTitulosAlterados(titulosAlteradosFiltroTO);
			log.debug("Result:" + ToStringUtils.toString(lista));
			log.debug("----------------------------------------------------------------------------");
			log.debug("End of execution of ConsultasGeraisTitulosDAO.obterTitulosAlterados()");
			log.debug("----------------------------------------------------------------------------");			
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
	}	

	// desenvolvimento: "10.192.230.43", 7999
	// desenvolvimento: "10.192.8.255 (acd1.coresp.caixa)", 7999
	public static void main(String[] args) {
		String host = "acd1.coresp.caixa";
		int port = 7999;

		if (args.length == 2) {
			host = args[0];
			port = Integer.valueOf(args[1]);
		} else if (args.length != 0) {
			System.err.println("Invalid parameters. Usage: "
					+ Client.class.getSimpleName() + " [host] [port]");
			System.exit(1);
		}
		new Client(host, port).executeTest();
	}
}
