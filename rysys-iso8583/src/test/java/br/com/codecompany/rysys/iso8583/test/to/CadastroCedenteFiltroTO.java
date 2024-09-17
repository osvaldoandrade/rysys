package br.com.codecompany.rysys.iso8583.test.to;

import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import br.com.codecompany.rysys.api.annotation.core.TextField;

@DataDescriptor
public class CadastroCedenteFiltroTO extends PaginacaoTO {
	
	private static final long serialVersionUID = 5697026443173043795L;
	
	public static final String TIPO_CONSULTA_INCLUSAO = "I";
	public static final String TIPO_CONSULTA_ALTERACAO = "A";
	public static final String TIPO_CONSULTA_DETALHE = "C";
	
	public static final String TIPO_ACAO_INCLUSAO_EM_CADASTRAMENTO = "I";
	public static final String TIPO_ACAO_INCLUSAO_CADASTRADO = "S";
	public static final String TIPO_ACAO_ALTERACAO = "A";
	
   	public static final int TIPO_CONCLUSAO_GUIA_MSG_BLOQUETOS = 2;
	
	public static final String TIPO_ENTREGA_RELATORIO = "1";
	public static final String TIPO_ENTREGA_EXTRATO = "2";
	public static final String TIPO_ENTREGA_BLOQUETO = "3";
	
	private long cocli;
	private String codUnidadePV;
	private UsuarioTO usuarioTO;
		
	@IntegerField(index=6, length=6)
	private int codCedente;
	
	private String tpConsulta;
	private String tpAcao;
	private int origemConsulta;
	private int natureza;
	private String numSequencia;
	private String tpEntrega;
	private String guiaAberta;
	private String message;
	
	@TextField(index=7, length=8)
	private String usuario;
	
	private int tpPesquisa;
	private int tpPessoa;
	private long cpfCnpj;
	private String cpfCnpjFormatado;
	private String tpUnidade;
	private String cabecalhoSucesso;
	private String mensagem;
	private String nomeFantasia;
	private int idtEndereco;
	private int codUnidadeSR;
	private int tpBloquetoLocalImpressao;
	private int numTotalPacotes;
	private int tpConclusao;
	
	private String nomeCedente;
	private String nomeLogradouro;
	private String numeroCedente;
	private String complemento;
	private String bairro;
	private String municipio;
	private String cepFormatado;
	private String uf;
	private String situacao;
	
	public int getTpConclusao() {
		return tpConclusao;
	}
	public void setTpConclusao(int tpConclusao) {
		this.tpConclusao = tpConclusao;
	}
	public int getNumTotalPacotes() {
		return numTotalPacotes;
	}
	public void setNumTotalPacotes(int numTotalPacotes) {
		this.numTotalPacotes = numTotalPacotes;
	}
	public int getTpBloquetoLocalImpressao() {
		return tpBloquetoLocalImpressao;
	}
	public void setTpBloquetoLocalImpressao(int tpBloquetoLocalImpressao) {
		this.tpBloquetoLocalImpressao = tpBloquetoLocalImpressao;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTpEntrega() {
		return tpEntrega;
	}
	public void setTpEntrega(String tpEntrega) {
		this.tpEntrega = tpEntrega;
	}
	public String getNumSequencia() {
		return numSequencia;
	}
	public void setNumSequencia(String numSequencia) {
		this.numSequencia = numSequencia;
	}
	
	public String getCodCedenteFormatado() {
		return Formatador.formatarNumeroCobol(codCedente, 6, 0);
	}
	
	public int getCodCedente() {
		return codCedente;
	}
	public void setCodCedente(int codCedente) {
		this.codCedente = codCedente;
	}
	public UsuarioTO getUsuarioTO() {
		return usuarioTO;
	}
	public void setUsuarioTO(UsuarioTO usuarioTO) {
		this.usuarioTO = usuarioTO;
	}
	public String getCocliFormatado() {
		return Formatador.formatarNumeroCobol(cocli, 13, 0);
	}
	public long getCocli() {
		return cocli;
	}
	public void setCocli(long cocli) {
		this.cocli = cocli;
	}
	public String getCodUnidadePVFormatado(){
		return Formatador.formatarNumeroCobol(codUnidadePV, 4, 0);
	}
	public String getCodUnidadePV() {
		return codUnidadePV;
	}
	public void setCodUnidadePV(String codUnidadePV) {
		this.codUnidadePV = codUnidadePV;
	}
	public int getOrigemConsulta() {
		return origemConsulta;
	}
	public void setOrigemConsulta(int origemConsulta) {
		this.origemConsulta = origemConsulta;
	}
	public String getTpConsulta() {
		return tpConsulta;
	}
	public void setTpConsulta(String tpConsulta) {
		this.tpConsulta = tpConsulta;
	}
	public int getNatureza() {
		return natureza;
	}
	public void setNatureza(int natureza) {
		this.natureza = natureza;
	}
	public String getGuiaAberta() {
		return guiaAberta;
	}
	public void setGuiaAberta(String guiaAberta) {
		this.guiaAberta = guiaAberta;
	}
	public String getTpAcao() {
		return tpAcao;
	}
	public void setTpAcao(String tpAcao) {
		this.tpAcao = tpAcao;
	}
	public int getTpPesquisa() {
		return tpPesquisa;
	}
	public void setTpPesquisa(int tpPesquisa) {
		this.tpPesquisa = tpPesquisa;
	}
	public int getTpPessoa() {
		return tpPessoa;
	}
    public String getDescricaoTpPessoa() {
        if (this.tpPessoa == 1){
            return "FÍSICA";
        }else if (this.tpPessoa == 2 ) {
            return "JURÍDICA";
        }
        return "";
    }		
	public void setTpPessoa(int tpPessoa) {
		this.tpPessoa = tpPessoa;
	}
	public long getCpfCnpj() {
		if (this.cpfCnpjFormatado != null && !"".equals(this.cpfCnpjFormatado)){
			if (this.tpPessoa == 1){
				return Long.valueOf(Formatador.removerMascara("000.000.000-00", this.cpfCnpjFormatado));
			}
			else{
				return Long.valueOf(Formatador.removerMascara("00.000.000/0000-00", this.cpfCnpjFormatado));
			}
		}
		return cpfCnpj;
	}
	public void setCpfCnpj(long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getTpUnidade() {
		return tpUnidade;
	}
	public void setTpUnidade(String tpUnidade) {
		this.tpUnidade = tpUnidade;
	}
	public String getCpfCnpjFormatado() {
		return cpfCnpjFormatado;
	}
	public void setCpfCnpjFormatado(String cpfCnpjFormatado) {
		this.cpfCnpjFormatado = cpfCnpjFormatado;
	}
	public String getCabecalhoSucesso() {
		return cabecalhoSucesso;
	}
	public void setCabecalhoSucesso(String cabecalhoSucesso) {
		this.cabecalhoSucesso = cabecalhoSucesso;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public int getIdtEndereco() {
		return idtEndereco;
	}
	public void setIdtEndereco(int idtEndereco) {
		this.idtEndereco = idtEndereco;
	}
	public int getCodUnidadeSR() {
		return codUnidadeSR;
	}
	public String getCodUnidadeSRFormatado() {
		return Formatador.formatarNumeroCobol(codUnidadeSR, 4, 0);
	}		
	public void setCodUnidadeSR(int codUnidadeSR) {
		this.codUnidadeSR = codUnidadeSR;
	}
	public String getNomeCedente() {
		return Formatador.toUpperCase(nomeCedente);
	}
	public void setNomeCedente(String nomeCedente) {
		this.nomeCedente = nomeCedente;
	}
	public String getNomeLogradouro() {
		return Formatador.toUpperCase(nomeLogradouro);
	}
	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}
	public String getNumeroCedente() {
		return numeroCedente;
	}
	public void setNumeroCedente(String numeroCedente) {
		this.numeroCedente = numeroCedente;
	}
	public String getComplemento() {
		return Formatador.toUpperCase(complemento);
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return Formatador.toUpperCase(bairro);
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getMunicipio() {
		return Formatador.toUpperCase(municipio);
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCep() {
		if (this.cepFormatado != null && !"".equals(this.cepFormatado)){
			return Formatador.removerMascara("00000-000", this.cepFormatado);			
		}
		return cepFormatado;
	}
	public String getCepFormatado() {
		return this.cepFormatado;
	}
	public void setCepFormatado(String cepFormatado) {
		this.cepFormatado = Formatador.formatarCep(cepFormatado);
	}
	public String getUf() {
		return Formatador.toUpperCase(uf);
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}	
}
