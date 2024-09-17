package br.com.codecompany.rysys.api.test.to;

import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import br.com.codecompany.rysys.api.annotation.core.TextField;
import br.com.codecompany.rysys.api.test.to.PaginacaoTO;

@DataDescriptor
public class CadastroCedenteFiltroTO extends PaginacaoTO {

	private static final long serialVersionUID = 5697026443173043795L;

	@IntegerField(index = 6, length = 6)
	private int codCedente;

	@TextField(index = 7, length = 8)
	private String usuario;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getCodCedente() {
		return codCedente;
	}

	public void setCodCedente(int codCedente) {
		this.codCedente = codCedente;
	}
}
