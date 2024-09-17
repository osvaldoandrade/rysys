package br.com.codecompany.rysys.iso8583.test.dao;

import br.com.codecompany.rysys.iso8583.test.to.Formatador;
import br.com.codecompany.rysys.iso8583.test.to.TransacaoTO;
/**
 * DAO utilizado para transmitir dados comuns de acesso a transacao
 *
 */
public class TransacaoDAO {

	protected void preencherDadosPadrao(StringBuffer dadosIda, TransacaoTO transacaoTO) {
		dadosIda.append(Formatador.formatarNumeroCobol(transacaoTO.getAtendimento(),1,0));
		dadosIda.append(Formatador.formatarNumeroCobol(transacaoTO.getVersao(),3,0));
		dadosIda.append(Formatador.formatarNumeroCobol(transacaoTO.getCodResp(),4,0));
		dadosIda.append(Formatador.formatarTextoCobol(transacaoTO.getControleCEF(),18));
		dadosIda.append(Formatador.formatarNumeroCobol(transacaoTO.getControleCEF2(),10,0));
	}
}
