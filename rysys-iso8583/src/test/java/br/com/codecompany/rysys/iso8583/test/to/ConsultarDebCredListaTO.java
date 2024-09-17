package br.com.codecompany.rysys.iso8583.test.to;

import java.util.ArrayList;
import java.util.List;


public class ConsultarDebCredListaTO extends PaginacaoTO{

	private static final long serialVersionUID = 7876361291094172150L;

	private List<ConsultarDebCredTO> listarContasDebCredRateio = new ArrayList<ConsultarDebCredTO>();

	public List<ConsultarDebCredTO> getListarContasDebCredRateio() {
		return listarContasDebCredRateio;
	}

	public void setListarContasDebCredRateio(
			List<ConsultarDebCredTO> consultarContasDebCredRateio) {
		this.listarContasDebCredRateio = consultarContasDebCredRateio;
	}
}
