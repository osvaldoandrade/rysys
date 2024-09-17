package br.com.codecompany.rysys.iso8583.test.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.driver.ConnectionException;
import br.com.codecompany.rysys.iso8583.annotation.helper.BitMapHelper;
import br.com.codecompany.rysys.iso8583.driver.Iso8583Adapter;
import br.com.codecompany.rysys.iso8583.test.to.CadastroCedenteFiltroTO;
import br.com.codecompany.rysys.iso8583.test.to.CadastroCedenteTO;
import br.com.codecompany.rysys.iso8583.test.to.ConsultaCateiraCobrancaListaTO;
import br.com.codecompany.rysys.iso8583.test.to.ConsultaCateiraCobrancaTO;
import br.com.codecompany.rysys.iso8583.test.to.GuiaDebCredListaTO;
import br.com.codecompany.rysys.iso8583.test.to.GuiaDebCredTO;
import br.com.codecompany.rysys.iso8583.test.to.RamoAtividadeListaTO;
import br.com.codecompany.rysys.iso8583.test.to.RamoAtividadeTO;
import br.com.codecompany.rysys.iso8583.test.to.SetorListaTO;
import br.com.codecompany.rysys.iso8583.test.to.SetorTO;
import br.com.codecompany.rysys.iso8583.test.to.TipoJurosListaTO;
import br.com.codecompany.rysys.iso8583.test.to.TipoJurosTO;

/**
 * DAO utilizado para Gerencia o cadastramento do Cedente na base do GCB
 *
 */
public class CedenteDAO extends TransacaoDAO {

	private static final Logger log = LoggerFactory.getLogger(CedenteDAO.class);
	
	private Iso8583Adapter adapter;
	
	public CedenteDAO(Iso8583Adapter adapter) {
		this.adapter = adapter;
	}
	
	
	/**
	 * Processamento : 640191<br>
	 * Descricao     : Consulta se o Usuario informado possui privilegio de Gestor e o PV de Vinculacao
	 * @param cadastroCedenteFiltroTO Dados a serem submetidos ao mainframe
	 * @return TO com dados lidos do Mainframe
	 * @throws SigcbException
	 *
	 */
	public RamoAtividadeListaTO consultarRamosDeAtividade(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		StringBuffer dadosIda = new StringBuffer();

//		preencherDadosPadrao(dadosIda,cadastroCedenteFiltroTO);
//
//		dadosIda.append(Formatador.formatarNumeroCobol(cadastroCedenteFiltroTO.getNatureza(),2,0));
//		dadosIda.append(Formatador.formatarTextoCobol(cadastroCedenteFiltroTO.getUsuario(),8));

//		Iso8583Adapter acessoIso8583 = new Iso8583Adapter();
		adapter.setTimeout(30000);

		// TODO retirar
		dadosIda = new StringBuffer("00010000                  000000000000P525195 ");
		
		log.debug("Raw data to mainframe, without transaction code (" + dadosIda.toString().length() +
				" bytes): [" + dadosIda.toString() + "]");		
		
		BitMap bitMap = new BitMap("640191", dadosIda.toString());
		
		
		Map<Integer, String> map = BitMapHelper.extractBitMap(bitMap);
		List<Map<Integer, String>> response = null;
		try {
			response = (List<Map<Integer, String>>) adapter.execute((Serializable) map);
		} catch (ConnectionException e) {
			throw new RuntimeException(e);
		}		
		DadosResposta dados = new DadosResposta(response.get(0).get(62));
		
		
		log.debug("Raw data from mainframe (" + dados.getDados().toString().length() +
				" bytes): [" + dados.getDados() + "]");		

		RamoAtividadeListaTO resultado = new RamoAtividadeListaTO();

		int tamanho = dados.getInt(2);

		for( int n = 0; n < tamanho; n++ ) {
			RamoAtividadeTO item = new RamoAtividadeTO();
			item.setCodNatureza(dados.getInt(2));
			item.setCodRamo(dados.getString(4));
			item.setNomeRamo(dados.getString(40));
			resultado.getListaRamoAtividade().add(item);
		}
		return resultado;
	}
	
	/**
	 * Processamento : 640192<br>
	 * Descricao     : Lista os tipos de juros
	 * @param cadastroCedenteFiltroTO Dados a serem submetidos ao mainframe
	 * @return TO com dados lidos do Mainframe
	 * @throws SigcbException
	 *
	 */	
	public TipoJurosListaTO listarRamosDeAtividade(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		StringBuffer dadosIda = new StringBuffer();

//		preencherDadosPadrao(dadosIda,cadastroCedenteFiltroTO);
//
//		dadosIda.append(Formatador.formatarTextoCobol(cadastroCedenteFiltroTO.getUsuario(),8));
		
		adapter.setTimeout(30000);
		
		// TODO retirar
		dadosIda = new StringBuffer("00010000                  0000000000P525195 ");
		
		log.debug("Raw data to mainframe, without transaction code (" + dadosIda.toString().length() +
				" bytes): [" + dadosIda.toString() + "]");
		
		BitMap bitMap = new BitMap("640192", dadosIda.toString());
		
		
		Map<Integer, String> map = BitMapHelper.extractBitMap(bitMap);
		List<Map<Integer, String>> response = null;
		try {
			response = (List<Map<Integer, String>>) adapter.execute((Serializable) map);
		} catch (ConnectionException e) {
			throw new RuntimeException(e);
		}		
		DadosResposta dados = new DadosResposta(response.get(0).get(62));
		
		
		
		log.debug("Raw data from mainframe (" + dados.getDados().toString().length() +
				" bytes): [" + dados.getDados() + "]");
		
		TipoJurosListaTO resultado = new TipoJurosListaTO();

		int tamanho = dados.getInt(2);

		for( int n = 0; n < tamanho; n++ ) {
			TipoJurosTO item = new TipoJurosTO();
			item.setTpJuros(dados.getInt(1));
			item.setDescricaoTpJuros(dados.getString(40));
			resultado.getListaTpJuros().add(item);
		}
		return resultado;
	}	
	
	/**
	 * Processamento : 640193<br>
	 * Descricao     : Lista os setores
	 * @param cadastroCedenteFiltroTO Dados a serem submetidos ao mainframe
	 * @return TO com dados lidos do Mainframe
	 * @throws SigcbException
	 *
	 */
	public SetorListaTO listarSetores(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		StringBuffer dadosIda = new StringBuffer();

//		preencherDadosPadrao(dadosIda,cadastroCedenteFiltroTO);
//
//		dadosIda.append(Formatador.formatarTextoCobol(cadastroCedenteFiltroTO.getUsuario(),8));

//		Iso8583Adapter acessoIso8583 = new Iso8583Adapter();
		adapter.setTimeout(30000);

		// TODO retirar
		dadosIda = new StringBuffer("00010000                  0000000000P525195 ");
		
		log.debug("Raw data to mainframe, without transaction code (" + dadosIda.toString().length() +
				" bytes): [" + dadosIda.toString() + "]");		
		
		BitMap bitMap = new BitMap("640193", dadosIda.toString());
		
		
		Map<Integer, String> map = BitMapHelper.extractBitMap(bitMap);
		List<Map<Integer, String>> response = null;
		try {
			response = (List<Map<Integer, String>>) adapter.execute((Serializable) map);
		} catch (ConnectionException e) {
			throw new RuntimeException(e);
		}		
		DadosResposta dados = new DadosResposta(response.get(0).get(62));
		
		
		
		log.debug("Raw data from mainframe (" + dados.getDados().toString().length() +
				" bytes): [" + dados.getDados() + "]");		

		SetorListaTO resultado = new SetorListaTO();

		int tamanho = dados.getInt(2);

		for( int n = 0; n < tamanho; n++ ) {
			SetorTO item = new SetorTO();
			item.setCodSetor(dados.getInt(2));
			item.setDescricaoSetor(dados.getString(40));
			resultado.getListaSetor().add(item);
		}
		return resultado;
	}	
	
	/**
	 * Processamento : 640211<br>
	 * Descricao     : Solicita Dados de Posição Consolidada da Carteira de Cobrança do Cedente para Ações/Favoritos
	 * @param cadastroCedenteFiltroTO Dados a serem submetidos ao mainframe
	 * @return TO com dados lidos do Mainframe
	 * @throws SigcbException
	 *
	 */	
	public ConsultaCateiraCobrancaListaTO listarCarteiraCobranca(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		StringBuffer dadosIda = new StringBuffer();

//		preencherDadosPadrao(dadosIda,cadastroCedenteFiltroTO);
//		
//		dadosIda.append(Formatador.formatarNumeroCobol(cadastroCedenteFiltroTO.getCodCedente(),6,0));
//		dadosIda.append(Formatador.formatarTextoCobol(cadastroCedenteFiltroTO.getUsuario(),8));
		
		adapter.setTimeout(30000);
		
		// TODO retirar
		dadosIda = new StringBuffer("00010000                  0000000000096059P525195 ");
		
		log.debug("Raw data to mainframe, without transaction code (" + dadosIda.toString().length() +
				" bytes): [" + dadosIda.toString() + "]");
		
		BitMap bitMap = new BitMap("640211", dadosIda.toString());
		
		
		Map<Integer, String> map = BitMapHelper.extractBitMap(bitMap);
		List<Map<Integer, String>> response = null;
		try {
			response = (List<Map<Integer, String>>) adapter.execute((Serializable) map);
		} catch (ConnectionException e) {
			throw new RuntimeException(e);
		}		
		DadosResposta dados = new DadosResposta(response.get(0).get(62));
		
		
		
		log.debug("Raw data from mainframe (" + dados.getDados().toString().length() +
				" bytes): [" + dados.getDados() + "]");
		
		ConsultaCateiraCobrancaListaTO resultado = new ConsultaCateiraCobrancaListaTO();
		resultado.setSituacao(dados.getString(1));
		resultado.setTotalVencidosQtde(dados.getInt(8));
		resultado.setTotalVencidosValor(dados.getBigDecimal(13,2));
		resultado.setTotalVencendoDiaQtde(dados.getInt(8));
		resultado.setTotalVencendoDiaValor(dados.getBigDecimal(13,2));
		resultado.setTotalVencerQtde(dados.getInt(8));
		resultado.setTotalVencerValor(dados.getBigDecimal(13,2));
		resultado.setTotalLiquidadosDiaQtde(dados.getInt(8));
		resultado.setTotalLiquidadosDiaValor(dados.getBigDecimal(13,2));

		int tamanho = dados.getInt(2);

		for( int n = 0; n < tamanho; n++ ) {
			ConsultaCateiraCobrancaTO item = new ConsultaCateiraCobrancaTO();
			item.setEspecieTitulo(dados.getString(40));
			item.setVencidosQtde(dados.getInt(8));
			item.setVencidosValor(dados.getBigDecimal(13,2));
			item.setVencendoDiaQtde(dados.getInt(8));
			item.setVencendoDiaValor(dados.getBigDecimal(13,2));
			item.setVencerQtde(dados.getInt(8));
			item.setVencerValor(dados.getBigDecimal(13,2));
			item.setLiquidadosDiaQtde(dados.getInt(8));
			item.setLiquidadosDiaValor(dados.getBigDecimal(13,2));
			item.setRegistrada(dados.getString(2));
			resultado.getListaCarteiraCobranca().add(item);
		}
		return resultado;
	}
	
	/**
	 * Processamento : 640164<br>
	 * Descricao     : Obtem dados do Cedente de modo a validar o controle de inclusao
	 * @param cadastroCedenteFiltroTO Dados a serem submetidos ao mainframe
	 * @return TO com dados lidos do Mainframe
	 * @throws SigcbException
	 *
	 */
	public CadastroCedenteTO obterDadosPreInclusaoCedente(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		StringBuffer dadosIda = new StringBuffer();

//		preencherDadosPadrao(dadosIda,cadastroCedenteFiltroTO);
//
//		dadosIda.append(Formatador.formatarNumeroCobol(cadastroCedenteFiltroTO.getCocli(),13,0));
//		dadosIda.append(Formatador.formatarNumeroCobol(cadastroCedenteFiltroTO.getCodUnidadePV(),4,0));
//		dadosIda.append(Formatador.formatarTextoCobol(cadastroCedenteFiltroTO.getUsuario(),8));

//		Iso8583Adapter acessoIso8583 = new Iso8583Adapter();
		adapter.setTimeout(30000);

		// TODO retirar
		dadosIda = new StringBuffer("00010000                  000000000000000000000010002P525195");
		
		log.debug("Raw data to mainframe, without transaction code (" + dadosIda.toString().length() +
				" bytes): [" + dadosIda.toString() + "]");		
		
		BitMap bitMap = new BitMap("640164", dadosIda.toString());
		
		
		Map<Integer, String> map = BitMapHelper.extractBitMap(bitMap);
		List<Map<Integer, String>> response = null;
		try {
			response = (List<Map<Integer, String>>) adapter.execute((Serializable) map);
		} catch (ConnectionException e) {
			throw new RuntimeException(e);
		}		
		DadosResposta dados = new DadosResposta(response.get(0).get(62));
		
		
		
		log.debug("Raw data from mainframe (" + dados.getDados().toString().length() +
				" bytes): [" + dados.getDados() + "]");		

		CadastroCedenteTO resultado = new CadastroCedenteTO();
		resultado.setTpCedente(dados.getString(1));
		resultado.setSituacaoGuiaCedenteEletronico(dados.getString(1));
		resultado.setUltimaGuiaCadastrada(dados.getInt(2));
		resultado.setModalidadeTitulo(dados.getInt(1));
		resultado.setCodUnidadeSR(dados.getString(4));
		return resultado;
	}
	
	/**
	 * Processamento : 640232<br>
	 * Descricao     : Transação disponibilizada no sistema de cobrança (SIGCB), para consultar Endereço do Cedente  – Cadastro Cedente.
	 * @param cadastroCedenteFiltroTO Dados a serem submetidos ao mainframe
	 * @return TO com dados lidos do Mainframe
	 * @throws SigcbException
	 *
	 */
	public CadastroCedenteFiltroTO consultaDadosCedenteSicli(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		StringBuffer dadosIda = new StringBuffer();

//		preencherDadosPadrao(dadosIda,cadastroCedenteFiltroTO);
//
//		dadosIda.append(Formatador.formatarNumeroCobol(cadastroCedenteFiltroTO.getCodCedente(),6,0));
//		dadosIda.append(Formatador.formatarTextoCobol(cadastroCedenteFiltroTO.getUsuario(),8));

//		Iso8583Adapter acessoIso8583 = new Iso8583Adapter();
		adapter.setTimeout(30000);

		// TODO retirar
		dadosIda = new StringBuffer("0010000                  0000000000096059P525195 ");
		
		log.debug("Raw data to mainframe, without transaction code (" + dadosIda.toString().length() +
				" bytes): [" + dadosIda.toString() + "]");		
		
		BitMap bitMap = new BitMap("640232", dadosIda.toString());
		
		
		Map<Integer, String> map = BitMapHelper.extractBitMap(bitMap);
		List<Map<Integer, String>> response = null;
		try {
			response = (List<Map<Integer, String>>) adapter.execute((Serializable) map);
		} catch (ConnectionException e) {
			throw new RuntimeException(e);
		}		
		DadosResposta dados = new DadosResposta(response.get(0).get(62));
		
		
		
		log.debug("Raw data from mainframe (" + dados.getDados().toString().length() +
				" bytes): [" + dados.getDados() + "]");		

		CadastroCedenteFiltroTO resultado = new CadastroCedenteFiltroTO();
		resultado.setNomeCedente(dados.getString(40));
		resultado.setNomeLogradouro(dados.getString(50));
		resultado.setNumeroCedente(dados.getString(7));
		resultado.setComplemento(dados.getString(25));
		resultado.setBairro(dados.getString(40));
		resultado.setMunicipio(dados.getString(35));
		resultado.setCepFormatado(dados.getString(8));
		resultado.setUf(dados.getString(2));
		return resultado;
	}
	
	/**
	 * Processamento : 640170<br>
	 * Descricao     : Lista os dadosCadastrais de contas Deb/Cred e Rateio
	 * @param cadastroCedenteFiltroTO Dados a serem submetidos ao mainframe
	 * @return TO com dados lidos do Mainframe
	 * @throws SigcbException
	 *
	 */
	public GuiaDebCredListaTO consultarContasDebCredRateio(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {
		StringBuffer dadosIda = new StringBuffer();

//		preencherDadosPadrao(dadosIda,cadastroCedenteFiltroTO);
//
//		dadosIda.append(Formatador.formatarTextoCobol(cadastroCedenteFiltroTO.getTpConsulta(),1));
//		dadosIda.append(Formatador.formatarNumeroCobol(cadastroCedenteFiltroTO.getCodCedente(),6,0));
//		dadosIda.append(Formatador.formatarNumeroCobol(cadastroCedenteFiltroTO.getCocli(),13,0));
//		dadosIda.append(Formatador.formatarTextoCobol(cadastroCedenteFiltroTO.getNumSequencia(),48));
//		dadosIda.append(Formatador.formatarNumeroCobol(cadastroCedenteFiltroTO.getCodUnidadePV(),4,0));
//		dadosIda.append(Formatador.formatarTextoCobol(cadastroCedenteFiltroTO.getUsuario(),8));

//		Iso8583Adapter acessoIso8583 = new Iso8583Adapter();
		adapter.setTimeout(30000);

		// TODO retirar
		dadosIda = new StringBuffer("00010000                  0000000000I0000000000000000001                                                0002P525195 ");
		
		log.debug("Raw data to mainframe, without transaction code (" + dadosIda.toString().length() +
				" bytes): [" + dadosIda.toString() + "]");
		
		BitMap bitMap = new BitMap("640170", dadosIda.toString());
		
		
		Map<Integer, String> map = BitMapHelper.extractBitMap(bitMap);
		List<Map<Integer, String>> response = null;
		try {
			response = (List<Map<Integer, String>>) adapter.execute((Serializable) map);
		} catch (ConnectionException e) {
			throw new RuntimeException(e);
		}		
		DadosResposta dados = new DadosResposta(response.get(0).get(62));
		
		
		
		log.debug("Raw data from mainframe (" + dados.getDados().toString().length() +
				" bytes): [" + dados.getDados() + "]");		

		GuiaDebCredListaTO resultado = new GuiaDebCredListaTO();

		int tamanho = dados.getInt(2);

		for( int n = 0; n < tamanho; n++ ) {
			GuiaDebCredTO item = new GuiaDebCredTO();
			item.setTpConta(dados.getInt(1));
			item.setContaRateioUnidades(dados.getString(4));
			item.setContaRateioOperacao(dados.getString(3));
			item.setContaRateioConta(dados.getString(8));
			item.setContaRateioDV(dados.getString(1));
			item.setPercRateioCred(dados.getBigDecimal(3,2));
			item.setPercRateioDeb(dados.getBigDecimal(3,2));
			item.setValorRateio(dados.getBigDecimal(13,2));
			resultado.getListarContasDebCredRateio().add(item);
		}
		return resultado;
	}	
	
//	public TipoJurosListaTO listarRamosDeAtividade2(CadastroCedenteFiltroTO cadastroCedenteFiltroTO) {		
//		// requisição
//		GenericRequestPopulator requestPopulator = new GenericRequestPopulator();
//		String dadosIda = requestPopulator.extract(cadastroCedenteFiltroTO);
//
//		log.debug("Raw data to mainframe, without transaction code (" + dadosIda.toString().length() +
//				" bytes): [" + dadosIda.toString() + "]");
//		
//		acessoIso8583.setIso8583Timeout(30000);	
//	 	TransacionConfig param = getParameter("640192");
//		DadosResposta dados = new DadosResposta(acessoIso8583.processar(param, dadosIda));
//		
//		log.debug("Raw data from mainframe (" + dados.getDados().toString().length() +
//				" bytes): [" + dados.getDados() + "]");		
//		
//		// resposta	
//		TipoJurosListaTO resultado = new TipoJurosListaTO();		
//		GenericResponsePopulator responsePopulator = new GenericResponsePopulator();		
////		responsePopulator.populate(resultado, dados.getDados());
//		
//		
//		int tamanho = dados.getInt(2);
//
//		for( int n = 0; n < tamanho; n++ ) {
//			TipoJurosTO item = new TipoJurosTO();
//			item.setTpJuros(dados.getInt(1));
//			item.setDescricaoTpJuros(dados.getString(40));
//			resultado.getListaTpJuros().add(item);
//		}
//		
//		return resultado;
//	}
}
