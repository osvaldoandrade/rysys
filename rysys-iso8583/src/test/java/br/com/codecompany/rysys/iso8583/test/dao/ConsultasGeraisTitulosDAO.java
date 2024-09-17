package br.com.codecompany.rysys.iso8583.test.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.driver.ConnectionException;
import br.com.codecompany.rysys.iso8583.annotation.helper.BitMapHelper;
import br.com.codecompany.rysys.iso8583.driver.Iso8583Adapter;
import br.com.codecompany.rysys.iso8583.test.to.Formatador;
import br.com.codecompany.rysys.iso8583.test.to.ProtestoTitulosFiltroTO;
import br.com.codecompany.rysys.iso8583.test.to.ProtestoTitulosListaTO;
import br.com.codecompany.rysys.iso8583.test.to.ProtestoTitulosTO;
import br.com.codecompany.rysys.iso8583.test.to.TitulosAlteradosFiltroTO;
import br.com.codecompany.rysys.iso8583.test.to.TitulosAlteradosListaTO;
import br.com.codecompany.rysys.iso8583.test.to.TitulosAlteradosTO;
import br.com.codecompany.rysys.iso8583.test.to.TitulosLiquidadosFiltroTO;
import br.com.codecompany.rysys.iso8583.test.to.TitulosLiquidadosListaTO;
import br.com.codecompany.rysys.iso8583.test.to.TitulosLiquidadosTO;

/**
 * DAO utilizado para Obter informacoes referentes a titulos
 *
 */
public class ConsultasGeraisTitulosDAO extends TransacaoDAO {
	
	private static final Logger log = LoggerFactory.getLogger(ConsultasGeraisTitulosDAO.class);
	
	private Iso8583Adapter adapter;
	
	public ConsultasGeraisTitulosDAO(Iso8583Adapter adapter) {
		this.adapter = adapter;
	}
	
	/**
	 * Processamento : 640092<br>
	 * Descricao     : Informar protesto de titulos
	 * @param protestoTitulosFiltroTO Dados a serem submetidos ao mainframe
	 * @return TO com dados lidos do Mainframe
	 * @throws SigcbException
	 *
	 */
	public ProtestoTitulosListaTO obterProtestoTitulos(ProtestoTitulosFiltroTO protestoTitulosFiltroTO) {
		StringBuffer dadosIda = new StringBuffer();

		preencherDadosPadrao(dadosIda,protestoTitulosFiltroTO);

		dadosIda.append(Formatador.formatarNumeroCobol(protestoTitulosFiltroTO.getTpConsulta(),1,0));
		dadosIda.append(Formatador.formatarNumeroCobol(protestoTitulosFiltroTO.getPvCobrador(),4,0));
		dadosIda.append(Formatador.formatarNumeroCobol(protestoTitulosFiltroTO.getDiasProtesto(),3,0));
		dadosIda.append(Formatador.formatarTextoCobol(protestoTitulosFiltroTO.getUsuario(),8));
		dadosIda.append(Formatador.formatarTextoCobol(protestoTitulosFiltroTO.getNomeTabelaTemp(),16));
		dadosIda.append(Formatador.formatarNumeroCobol(protestoTitulosFiltroTO.getQtdPaginas(),3,0));
		dadosIda.append(Formatador.formatarNumeroCobol(protestoTitulosFiltroTO.getPagAtual(),3,0));

//		Iso8583Adapter acessoIso8583 = new Iso8583Adapter();
		adapter.setTimeout(30000);

		BitMap bitMap = new BitMap("640092", dadosIda.toString());
		
		
		Map<Integer, String> map = BitMapHelper.extractBitMap(bitMap);
		List<Map<Integer, String>> response = null;
		try {
			response = (List<Map<Integer, String>>) adapter.execute((Serializable) map);
		} catch (ConnectionException e) {
			throw new RuntimeException(e);
		}		
		DadosResposta dados = new DadosResposta(response.get(0).get(62));
		
		

		ProtestoTitulosListaTO resultado = new ProtestoTitulosListaTO();
		resultado.setNomeTabelaTemp(dados.getString(16));
		resultado.setQtdPaginas(dados.getInt(3));
		resultado.setNomeUnidade(dados.getString(40));
		resultado.setTotalTitulos(dados.getLong(10));
		resultado.setVlrTotalTitulos(dados.getBigDecimal(16,2));

		int tamanho = dados.getInt(2);

		for( int n = 0; n < tamanho; n++ ) {
			ProtestoTitulosTO item = new ProtestoTitulosTO();
			item.setNossoNumero(dados.getLong(17));
			item.setCodCedente(dados.getString(6));
			item.setNomeDevedor(dados.getString(40));
			item.setTpPessoa(dados.getInt(1));
			item.setCpfCnpj(dados.getBigDecimal(14,0));
			item.setSeuNumero(dados.getString(15));
			item.setDtGenerica(dados.getData(10));
			item.setModalidade(dados.getString(2));
			item.setEspTitulo(dados.getString(3));
			item.setVlrTitulo(dados.getBigDecimal(13,2));
			item.setNumCartorio(dados.getInt(2));
			item.setProtocolo(dados.getLong(10));
			item.setDtProtocolo(dados.getData(10));
			item.setDtEnvioProtesto(dados.getData(10));
			resultado.getListaProtestoTitulos().add(item);
		}
		return resultado;
	}

	/**
	 * Processamento : 640108<br>
	 * Descricao     : Informar Titulos Alterados
	 * @param titulosAlteradosFiltroTO Dados a serem submetidos ao mainframe
	 * @return TO com dados lidos do Mainframe
	 * @throws SigcbException
	 *
	 */
	public TitulosAlteradosListaTO obterTitulosAlterados(TitulosAlteradosFiltroTO titulosAlteradosFiltroTO) {
		StringBuffer dadosIda = new StringBuffer();

//		preencherDadosPadrao(dadosIda,titulosAlteradosFiltroTO);
//
//		dadosIda.append(Formatador.formatarNumeroCobol(titulosAlteradosFiltroTO.getCodUnidadePv(),4,0));
//		dadosIda.append(Formatador.formatarDataCobol(titulosAlteradosFiltroTO.getDtComandada(),10));
//		dadosIda.append(Formatador.formatarTextoCobol(titulosAlteradosFiltroTO.getUsuario(),8));
//		dadosIda.append(Formatador.formatarTextoCobol(titulosAlteradosFiltroTO.getNomeTabelaTemp(),16));
//		dadosIda.append(Formatador.formatarNumeroCobol(titulosAlteradosFiltroTO.getQtdPaginas(),3,0));
//		dadosIda.append(Formatador.formatarNumeroCobol(titulosAlteradosFiltroTO.getPagAtual(),3,0));

//		Iso8583Adapter acessoIso8583 = new Iso8583Adapter();
		adapter.setTimeout(30000);
		
		dadosIda = new StringBuffer("00010000                  0000000000100909.01.2009P525195                 001001");
		
		log.debug("Raw data to mainframe, without transaction code (" + dadosIda.toString().length() +
				" bytes): [" + dadosIda.toString() + "]");

		BitMap bitMap = new BitMap("640108", dadosIda.toString());
		
		
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

		TitulosAlteradosListaTO resultado = new TitulosAlteradosListaTO();
		resultado.setNomeTabelaTemp(dados.getString(16));
		resultado.setQtdPaginas(dados.getInt(3));
		resultado.setNomeUnidadePv(dados.getString(40));

		int tamanho = dados.getInt(2);

		for( int n = 0; n < tamanho; n++ ) {
			TitulosAlteradosTO item = new TitulosAlteradosTO();
			item.setComando(dados.getString(40));
			item.setDtAlteracao(dados.getData(10));
			item.setNossoNumero(dados.getLong(17));
			item.setCodCedente(dados.getInt(6));
			item.setNomeCedente(dados.getString(40));
			resultado.getListaTitulosAlterados().add(item);
		}
		return resultado;
	}

	/**
	 * Processamento : 640109<br>
	 * Descricao     : Listar os Titulos Liquidados associados a uma Unidade de Vinculação (PV) e Data de Pagamento
	 * @param titulosLiquidadosFiltroTO Dados a serem submetidos ao mainframe
	 * @return TO com dados lidos do Mainframe
	 * @throws SigcbException
	 *
	 */
	public TitulosLiquidadosListaTO listarTitulosLiquidadosPV(TitulosLiquidadosFiltroTO titulosLiquidadosFiltroTO) {
		StringBuffer dadosIda = new StringBuffer();

		preencherDadosPadrao(dadosIda,titulosLiquidadosFiltroTO);

		dadosIda.append(Formatador.formatarNumeroCobol(titulosLiquidadosFiltroTO.getTpConsulta(),1,0));
		dadosIda.append(Formatador.formatarNumeroCobol(titulosLiquidadosFiltroTO.getCodUnidadeVinculacao(),4,0));
		dadosIda.append(Formatador.formatarDataCobol(titulosLiquidadosFiltroTO.getDtPagamento(),10));
		dadosIda.append(Formatador.formatarTextoCobol(titulosLiquidadosFiltroTO.getUsuario(),8));
		dadosIda.append(Formatador.formatarTextoCobol(titulosLiquidadosFiltroTO.getNomeTabelaTemp(),16));
		dadosIda.append(Formatador.formatarNumeroCobol(titulosLiquidadosFiltroTO.getQtdPaginas(),3,0));
		dadosIda.append(Formatador.formatarNumeroCobol(titulosLiquidadosFiltroTO.getPagAtual(),3,0));

//		Iso8583Adapter acessoIso8583 = new Iso8583Adapter();
		adapter.setTimeout(30000);

		BitMap bitMap = new BitMap("640109", dadosIda.toString());
		
		
		Map<Integer, String> map = BitMapHelper.extractBitMap(bitMap);
		List<Map<Integer, String>> response = null;
		try {
			response = (List<Map<Integer, String>>) adapter.execute((Serializable) map);
		} catch (ConnectionException e) {
			throw new RuntimeException(e);
		}		
		DadosResposta dados = new DadosResposta(response.get(0).get(62));
		
		

		TitulosLiquidadosListaTO resultado = new TitulosLiquidadosListaTO();
		resultado.setNomeTabelaTemp(dados.getString(16));
		resultado.setQtdPaginas(dados.getInt(3));
		resultado.setNomeUnidadeVinculacao(dados.getString(40));

		int tamanho = dados.getInt(2);

		for( int n = 0; n < tamanho; n++ ) {
			TitulosLiquidadosTO item = new TitulosLiquidadosTO();
			item.setCodCedente(dados.getInt(6));
			item.setNomeCedente(dados.getString(40));
			item.setTpPessoa(dados.getInt(1));
			item.setCpfCnpj(dados.getString(14));
			resultado.getListaTitulosLiquidados().add(item);
		}
		return resultado;
	}

	/**
	 * Processamento : 640110<br>
	 * Descricao     : Listar Títulos Liquidados associados a um Cedente e Data de Pagamento
	 * @param titulosLiquidadosFiltroTO Dados a serem submetidos ao mainframe
	 * @return TO com dados lidos do Mainframe
	 * @throws SigcbException
	 *
	 */
	public TitulosLiquidadosListaTO listarTitulosLiquidadosCedente(TitulosLiquidadosFiltroTO titulosLiquidadosFiltroTO) {
		StringBuffer dadosIda = new StringBuffer();

		preencherDadosPadrao(dadosIda,titulosLiquidadosFiltroTO);

		dadosIda.append(Formatador.formatarNumeroCobol(titulosLiquidadosFiltroTO.getTpConsulta(),1,0));
		dadosIda.append(Formatador.formatarNumeroCobol(titulosLiquidadosFiltroTO.getCodCedente(),6,0));
		dadosIda.append(Formatador.formatarDataCobol(titulosLiquidadosFiltroTO.getDtPagamento(),10));
		dadosIda.append(Formatador.formatarTextoCobol(titulosLiquidadosFiltroTO.getUsuario(),8));
		dadosIda.append(Formatador.formatarTextoCobol(titulosLiquidadosFiltroTO.getNomeTabelaTemp(),16));
		dadosIda.append(Formatador.formatarNumeroCobol(titulosLiquidadosFiltroTO.getQtdPaginas(),3,0));
		dadosIda.append(Formatador.formatarNumeroCobol(titulosLiquidadosFiltroTO.getPagAtual(),3,0));

//		Iso8583Adapter acessoIso8583 = new Iso8583Adapter();
		adapter.setTimeout(30000);

		BitMap bitMap = new BitMap("640110", dadosIda.toString());
		
		
		Map<Integer, String> map = BitMapHelper.extractBitMap(bitMap);
		List<Map<Integer, String>> response = null;
		try {
			response = (List<Map<Integer, String>>) adapter.execute((Serializable) map);
		} catch (ConnectionException e) {
			throw new RuntimeException(e);
		}		
		DadosResposta dados = new DadosResposta(response.get(0).get(62));
		
		

		TitulosLiquidadosListaTO resultado = new TitulosLiquidadosListaTO();
		resultado.setNomeTabelaTemp(dados.getString(16));
		resultado.setQtdPaginas(dados.getInt(3));
		resultado.setDtPagamento(dados.getData(10));

		int tamanho = dados.getInt(2);

		for( int n = 0; n < tamanho; n++ ) {
			TitulosLiquidadosTO item = new TitulosLiquidadosTO();
			item.setNossoNumero(dados.getString(18));
			item.setVlrPagamento(dados.getBigDecimal(13,2));
			item.setMeioLiquidacao(dados.getString(40));
			item.setFormaLiquidacao(dados.getInt(1));
			item.setSequencial(dados.getString(9));
			resultado.getListaTitulosLiquidados().add(item);
		}
		return resultado;
	}

	/**
	 * Processamento : 640111<br>
	 * Descricao     : Obter a consulta analitica do Titulo Liquidado
	 * @param titulosLiquidadosFiltroTO Dados a serem submetidos ao mainframe
	 * @return TO com dados lidos do Mainframe
	 * @throws SigcbException
	 *
	 */
	public TitulosLiquidadosTO obterTitulosLiquidadosDetalhe(TitulosLiquidadosFiltroTO titulosLiquidadosFiltroTO) {
		StringBuffer dadosIda = new StringBuffer();

		preencherDadosPadrao(dadosIda,titulosLiquidadosFiltroTO);

		dadosIda.append(Formatador.formatarNumeroCobol(titulosLiquidadosFiltroTO.getTpConsulta(),1,0));
		dadosIda.append(Formatador.formatarNumeroCobol(titulosLiquidadosFiltroTO.getCodCedente(),6,0));
		dadosIda.append(Formatador.formatarNumeroCobol(titulosLiquidadosFiltroTO.getNossoNumero(),18,0));
		dadosIda.append(Formatador.formatarDataCobol(titulosLiquidadosFiltroTO.getDtSolicitacao(),10));
		dadosIda.append(Formatador.formatarNumeroCobol(titulosLiquidadosFiltroTO.getSequencial(),9,0));

//		Iso8583Adapter acessoIso8583 = new Iso8583Adapter();
		adapter.setTimeout(30000);

		BitMap bitMap = new BitMap("640111", dadosIda.toString());
		
		
		Map<Integer, String> map = BitMapHelper.extractBitMap(bitMap);
		List<Map<Integer, String>> response = null;
		try {
			response = (List<Map<Integer, String>>) adapter.execute((Serializable) map);
		} catch (ConnectionException e) {
			throw new RuntimeException(e);
		}		
		DadosResposta dados = new DadosResposta(response.get(0).get(62));
		
		

		TitulosLiquidadosTO resultado = new TitulosLiquidadosTO();
		resultado.setVlrOriginalTitulo(dados.getBigDecimal(13,2));
		resultado.setNossoNumero(dados.getString(18));
		resultado.setSituacaoTitulo(dados.getString(40));
		resultado.setDtSituacao(dados.getData(10));
		resultado.setDtVencimentoTitulo(dados.getData(10));
		resultado.setModalidadeTitulo(dados.getInt(3));
		resultado.setDtCredito(dados.getData(10));
		resultado.setMeioLiquidacao(dados.getString(40));
		resultado.setDescMoeda(dados.getString(15));
		resultado.setCodUnidadeRecebedora(dados.getInt(4));
		resultado.setCodUnidadeCobradora(dados.getInt(4));
		resultado.setEspecieTitulo(dados.getString(3));
		resultado.setDescAceite(dados.getString(40));
		resultado.setQtdMoeda(dados.getInt(8));
		resultado.setVlrAbatimento(dados.getBigDecimal(13,2));
		resultado.setVlrJuros(dados.getBigDecimal(13,2));
		resultado.setPercentJurosMes(dados.getBigDecimal(3,2));
		resultado.setVlrMulta(dados.getBigDecimal(13,2));
		resultado.setPercentMulta(dados.getBigDecimal(3,2));
		resultado.setDtMulta(dados.getString(10));
		resultado.setPrazoMulta(dados.getInt(2));
		resultado.setVlrDesconto1(dados.getBigDecimal(13,2));
		resultado.setPercentDesconto1(dados.getBigDecimal(3,2));
		resultado.setDtDesconto1(dados.getData(10));
		resultado.setPrazoDesconto1(dados.getInt(2));
		resultado.setVlrDesconto2(dados.getBigDecimal(13,2));
		resultado.setPercentDesconto2(dados.getBigDecimal(3,2));
		resultado.setDtDesconto2(dados.getData(10));
		resultado.setPrazoDesconto2(dados.getInt(2));
		resultado.setVlrDesconto3(dados.getBigDecimal(13,2));
		resultado.setPercentDesconto3(dados.getBigDecimal(3,2));
		resultado.setDtDesconto3(dados.getData(10));
		resultado.setPrazoDesconto3(dados.getInt(2));
		resultado.setDtEntrada(dados.getData(10));
		resultado.setVlrPagamento(dados.getBigDecimal(13,2));
		resultado.setDtEmissao(dados.getData(10));
		resultado.setDtProtesto(dados.getData(10));
		resultado.setPrazoProtesto(dados.getInt(2));
		resultado.setNumLote(dados.getInt(9));
		resultado.setNumDocumento(dados.getString(18));
		resultado.setNomeSacado(dados.getString(40));
		resultado.setDescCarteira(dados.getString(40));
		return resultado;
	}

}
