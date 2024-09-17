package br.com.codecompany.rysys.iso8583.test.to;

import java.util.HashMap;
import java.util.Map;

/**
 * Gerado conforme o Book de Consultas Gerenciais.
 */
public enum GuiaCadastroCedente {
	GUIA_GERAL(1, "Geral", "Geral"),
	GUIA_FLOAT(2, "Float", "Float"),
	GUIA_CONTAS_DEB_CRED_RATEIO(3, "Contas Déb. Créd. e Rateio", "DebCredRateio"),
	GUIA_CEDENTE_ELETRONICO(4, "Cedente Eletrônico", "CedenteElet"),
	GUIA_BLOQUETOS(5, "Bloquetos", "Bloquetos"),
	GUIA_MSG_BLOQUETOS(6, "Mensagens para Bloquetos", "MsgBloquetos"),
	GUIA_TARIFAS(7, "Tarifas", "Tarifas"),
	GUIA_CONCLUSAO(8, "Conclusão", "Conclusao");
	
	private final int numGuia;
	private final String descricaoGuia;
	private final String nomeConfirmacaoOK;
	
    public String getNomeConfirmacaoOK() {
		return nomeConfirmacaoOK;
	}
	private GuiaCadastroCedente(int numGuia, String descricaoGuia, String nomeConfirmacaoOK) {
        this.numGuia = numGuia;
        this.descricaoGuia = descricaoGuia;
        this.nomeConfirmacaoOK = nomeConfirmacaoOK;
    }
    public int getNumGuia() {
        return this.numGuia;
    }
    public String getDescricaoGuia() {
        return this.descricaoGuia;
    }
    // Workaround para o bug 6277781
    public Object readResolve() {
        return GuiaCadastroCedente.values()[ordinal()];
    }
    private static final Map<Integer, GuiaCadastroCedente> GUIA_CADASTRO_CEDENTES = initObjetos();
    
    private static Map<Integer, GuiaCadastroCedente> initObjetos() {
        final Map<Integer, GuiaCadastroCedente> result = new HashMap<Integer, GuiaCadastroCedente>();
        result.put(GUIA_GERAL.getNumGuia(), GUIA_GERAL);
        result.put(GUIA_FLOAT.getNumGuia(), GUIA_FLOAT);
        result.put(GUIA_CONTAS_DEB_CRED_RATEIO.getNumGuia(), GUIA_CONTAS_DEB_CRED_RATEIO);
        result.put(GUIA_CEDENTE_ELETRONICO.getNumGuia(), GUIA_CEDENTE_ELETRONICO);
        result.put(GUIA_BLOQUETOS.getNumGuia(), GUIA_BLOQUETOS);
        result.put(GUIA_MSG_BLOQUETOS.getNumGuia(), GUIA_MSG_BLOQUETOS);
        result.put(GUIA_TARIFAS.getNumGuia(), GUIA_TARIFAS);
        result.put(GUIA_CONCLUSAO.getNumGuia(), GUIA_CONCLUSAO);
        return result;
    }
    
    public static GuiaCadastroCedente getGuia(int numGuia){
    	return GUIA_CADASTRO_CEDENTES.get(numGuia);
    }
}
