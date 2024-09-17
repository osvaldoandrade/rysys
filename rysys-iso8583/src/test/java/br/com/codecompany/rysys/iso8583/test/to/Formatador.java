package br.com.codecompany.rysys.iso8583.test.to;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;


/**
 * Classe responsável por realizar a formatação adequada dos atributos trafegados e exibidos pela aplicacao.
 * @version 1.0, 16/07/2007
 * @author talita.braga
 *
 */

public class Formatador {
	
	private static final Locale locale = new Locale("pt", "BR", "");
//	protected static DecimalFormatSymbols simbolos = new DecimalFormatSymbols(locale);
	public static String adicionarMascara(String mascara, String t) {
        String texto = t;
        
		if (t == null) {
			texto = "";
		} else if (t.length() > mascara.length()) {
			texto = t.substring(texto.length() - mascara.length());
		}
        
		StringBuffer result = new StringBuffer();

		int textPos = texto.length() - 1;

		for (int pos = mascara.length() - 1; pos >= 0; pos--) {
			if (mascara.charAt(pos) == '0') {
				if (textPos >= 0) {
					result.insert(0, texto.charAt(textPos--));
				} else {
					result.insert(0, mascara.charAt(pos));
				}
			} else if (mascara.charAt(pos) == '#') {
				if (textPos >= 0) {
					result.insert(0, texto.charAt(textPos--));
				}
			} else {
				result.insert(0, mascara.charAt(pos));
			}
		}
		return result.toString();
	}
    
	public static String removerMascara(String mascara, String texto ) {
		if( texto == null || texto.length() != mascara.length()) {
			return "";
		}
        StringBuffer ret = new StringBuffer();
        
        for (int pos = mascara.length() - 1; pos >= 0; pos--) {
            if (mascara.charAt(pos) == '0') {
                ret.insert(0,texto.charAt(pos));
            }
		}
		return ret.toString();
	}
    
    public static String formatarCep(int num) {
        return formatarCep(String.valueOf(num));
    }
    
    public static String formatarCep(String cep) {
		// condicao necessaria para as especificacoes que necessitam exibir brancos nos campos de cep quando o mesmo não estiver preenchido.
    	if (cep == null || "".equals(cep)){
    		return "";
    	}
        return adicionarMascara("00000-000", cep);
    }
        
    public static String desformatarCep(String cep){
    	if (cep == null){
    		return null;
    	}
    	return removerMascara("00000-000",cep);
    }
    
    public static String formatarTelefone(String tel) {
		// condicao necessaria para as especificacoes que necessitam exibir brancos nos campos de cep quando o mesmo não estiver preenchido.
    	if (tel == null || "".equals(tel)){
    		return "";
    	}
        return adicionarMascara("0000-0000", tel);
    }
        
    public static String desformatarTelefone(String tel){
    	if (tel == null){
    		return null;
    	}
    	return removerMascara("0000-0000",tel);
    }    
    
    public static String formatarCpf(String cpf) {
    	if (cpf == null){
    		return null;
    	}
        return adicionarMascara("000.000.000-00", cpf);
    }
    
    public static String formatarCnpj(String cnpj) {
    	if (cnpj == null){
    		return null;
    	}
        return adicionarMascara("00.000.000/0000-00", cnpj);
    }
    
    public static String formatarCpfCnpj(String cpfCnpj) {
    	if (cpfCnpj == null){
    		return null;
    	}
        if (cpfCnpj.length() >= 14) {
            return formatarCnpj(cpfCnpj);
        }
        return formatarCpf(cpfCnpj);
    }
    
    public String formatarNum(String cep) {
        return adicionarMascara("0000", cep);
    }
    
    private static String formatarValor(String valor) {
    	int pos = valor.indexOf('.');
    	int grupo = 0;
		StringBuffer ret = new StringBuffer((pos == -1) ? ",00" : "," + valor.substring(pos+1));
	
		for( int n = ((pos == -1) ? valor.length()-1: pos - 1); n >= 0; n-- ) {
			if((grupo++ % 3) == 0 && grupo > 1) {
				ret.insert(0,'.');
			}
			ret.insert(0,valor.charAt(n));
		}
		return ret.toString();
    }
    
    
	public static String formatarValor(BigDecimal decimal) {
		if( decimal == null){
			return "";
		}
		String valor;
		if (decimal.toString().charAt(0) == '-'){
			valor = "-" + formatarValor(decimal.toString().substring(1));
		} else {
			valor = formatarValor(decimal.toString());
		}
		return valor;
	}
	
	public static String formatarValorEmReais(BigDecimal decimal, boolean isValorFormatadoBranco) {
		String valor = formatarValor(decimal);
		if ("".equals(valor)){
			return valor;
		}
		return "R$ " + valor;
	}
    
	public static String formatarValorEmReais(BigDecimal decimal) {
		String valor = formatarValor(decimal);
		if ("".equals(valor)){
			return "R$ 0,00";
		}
		return "R$ " + valor;
	}
	
	public static String formatarValorEmReaisComIdentificador(BigDecimal decimal, String identificador) {
		String valor = formatarValor(decimal);
		if ("".equals(valor)){
			return "R$ 0,00";
		}
		return "R$" + identificador + valor;	
	}
	
	public static String formatarValorPorcentagem(BigDecimal decimal) {
		String valor = formatarValor(decimal);
		if ("".equals(valor)){
			return "0,00 %";
		}
		return valor + " %";
	}
	
	
	public static String formatarValorPorcentagem(BigDecimal decimal, boolean isValorInicialBrancos) {
		String valor = formatarValor(decimal);
		if ("".equals(valor)){
			return valor;
		}
		return valor + " %";
	}
	
	public static BigDecimal desformatarValor( String s) {
		if( s == null ) {
			return null;
		}
		String t = removerCaracteres(s, "0123456789,").trim();
		
		if( t.length() == 0 ) {
			return BigDecimal.ZERO;
		}
		return new BigDecimal(t.replace(',','.'));
	}
	
	public static int retiraCaracteresAlfa( String s) {
		if( s == null ) {
			return 0;
		}
		String t = removerCaracteres(s, "0123456789").trim();
		
		return Integer.valueOf(t);
		
	}
    
    public static BigDecimal desformatarValorCobol( String s, int casasDecimais ) {
        if( s == null ) {
            return null;
        }
        return new BigDecimal(new BigInteger( s ), casasDecimais );
    }
    
	public static Date desformatarData( String s ) {
		if( s == null ) {
			return null;
		}
		try {
            return new SimpleDateFormat("dd/MM/yyyy", locale).parse(s);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

    public static String formatarPeriodo(String data) {
        if( data == null) {
            return "";
        }
        return new SimpleDateFormat("MM/yyyy", locale).format(data);
    }
    
    public static String desformatarPeriodo( String s ) {
        if( s == null ) {
            return null;
        }
        return removerMascara("00/0000",s);
    }
    
	public static String formatarHora(Date data) {
		if( data == null) {
			return "";
		}
		return new SimpleDateFormat("HH:mm",locale).format(data);
	}
    
	public static String desformatarHoraCobol(String hora) {
		if( hora == null) {
			return "";
		}
		StringTokenizer token = new StringTokenizer(hora, ".");
		String horaDesformatada = "";
		while (token.hasMoreTokens()){
			horaDesformatada = horaDesformatada + token.nextToken();
		}
		if ("".equals(horaDesformatada)){
			return hora;  
		}
		return horaDesformatada;
	}
	
	public static Date desformatarHora( String s ) {
		if( s == null ) {
			return null;
		}
		try {
			return new SimpleDateFormat("HH:mm",locale).parse(s);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
    
    public static String formatarDataHora(Date data) {
    	if( data == null) {
    		return "";
    	}
		return new SimpleDateFormat("dd/MM/yyyy HH:mm",locale).format(data);
	}
    
	public static Date desformatarDataHora( String s ) {
		if( s == null ) {
			return null;
		}
		try {
			return  new SimpleDateFormat("dd/MM/yyyy HH:mm",locale).parse(s);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
    
	public static String formatarStringSQL(String s) {
		if( s == null) {
			return "null";
		}
		return "'" + s + "'";
	}
    
    public static String removerCaracteres(String texto, String charsValidos ) {
        if( texto == null) {
            return "";
        }
        StringBuffer ret = new StringBuffer();
        
        for( int n = 0; n < texto.length(); n++) {
            if( charsValidos.indexOf(texto.charAt(n)) != -1 ) {
                    ret.append(texto.charAt(n));
            }
        }
        return ret.toString();
    }
    
	public static String replace(String s, String find, String replace) {
		int pos = s.indexOf(find);
        String temp = s;

		while (pos >= 0) {
            temp = temp.substring(0, pos) + replace + temp.substring(pos + find.length());
			pos = temp.indexOf(find);
		}
		return s;
	}

    public static String formatarNumeroCobol(BigDecimal valor, int tamanho, int casasDecimais) {
    	if( valor == null ) {
    		return formatarNumeroCobol("", tamanho, casasDecimais);
    	}
		String valorSemPontos = "";
		StringTokenizer token = new StringTokenizer(valor.toString(), ".");
		while (token.hasMoreTokens()){
			valorSemPontos = valorSemPontos + token.nextToken();
		}
		return formatarNumeroCobol(String.valueOf(valorSemPontos), tamanho, casasDecimais);
    }
    
    public static String formatarNumeroCobol(long valor, int tamanho, int casasDecimais) {
        return formatarNumeroCobol(String.valueOf(valor), tamanho, casasDecimais);
    }
    
    public static String formatarNumeroCobol(int valor, int tamanho, int casasDecimais) {
        return formatarNumeroCobol(String.valueOf(valor), tamanho, casasDecimais);
    }
    
    public static String formatarNumeroCobol(String valor, int tamanho, int casasDecimais) {
        int tamTotal = tamanho + casasDecimais;
        StringBuffer ret = new StringBuffer(valor == null ? "" : valor );
        
        if (ret.length() > tamTotal) {
            return valor.substring(0, tamTotal);
        }
        if (ret.length() < tamTotal) {
            int n1 = ret.length();

            while (n1++ < tamTotal) {
                ret.insert(0, '0' );
            }
            return ret.toString();
        }
        return valor;
    }
    
    public static String formatarTextoCobol(String valor, int tamanho) {
        StringBuffer ret = new StringBuffer(valor == null ? "" : valor );
        
        if (ret.length() > tamanho) {
            return ret.substring(0, tamanho);
        }
        if (ret.length() < tamanho) {
            int n1 = ret.length();

            while (n1++ < tamanho) {
                ret.append( ' ' );
            }
            return ret.toString();
        }
        return valor;
    }
    
    public static Locale getLocale(){
    	return locale;
    }
    
    public static String formatarData(Date date){
    	if (date == null){
    		return "";
    	}
    	DateFormat df = DateFormat.getDateInstance(DateFormat.DATE_FIELD, locale);
    	return df.format(date);
    }
    
    
    public static Date formatarData(String date) throws ParseException{
    	if (date == null){
    		return null;
    	}
    	return DateFormat.getDateInstance(DateFormat.DATE_FIELD).parse(date);
    }
    
    public static String formatarDataCobol(String valor, int tamanho) {
        return formatarTextoCobol(valor,tamanho).replace('/', '.');
    }
    public static String toUpperCase(String valor){
    	if (valor == null){
    		return null;
    	}
    	return valor.toUpperCase(locale);
    }
    public static String toLowerCase(String valor){
    	if (valor == null){
    		return null;
    	}
    	return valor.toLowerCase(locale);
    }
}
