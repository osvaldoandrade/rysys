package br.com.codecompany.rysys.iso8583.test.dao;

import java.math.BigDecimal;

/**
 * Classe utilizada para dividir em campos os dados recebidos do mainframe
 * 
 * @author julio.alvarez
 *
 */
public class DadosResposta {
    private final String dados;
    private int pos;
     
    public DadosResposta(String dados) {
        this.dados = dados;    
    }
    
    /**
     * Retorna a posicao (indice) atual dentro dos dados recebidos
     * @return posicao
     */
    public int getPos() {
    	return pos;
    }
    
    /**
     * Retorna dos dados que serão divididos em campos
     * @return
     */
    public String getDados() {
    	return dados;
    }
    
    
    /**
     * Le uma quantidade de caracteres dos dados  movendo a posicao atual para o proximo campo 
     * @param size quantidade de caracteres a serem lidos
     * @return texto lido
     */
    public String getString(int size) {
        String ret = dados.substring(pos, pos+size);
        pos += size;
        return ret.trim();
    }

    /**
     * Le uma quantidade de caracteres e converte o resultado em inteiro 
     * @param size quantidade de caracteres a serem lidos
     * @return valor lido
     */
    public int getInt(int size){
    	try{
    		return Integer.valueOf(getString(size));
    	}catch(NumberFormatException e){
    		throw new RuntimeException("Dado Recebido não é numérico", e);
    	}
    }
    
    /**
     * Le uma quantidade de caracteres e converte o resultado em long 
     * @param size quantidade de caracteres a serem lidos
     * @return valor lido
     */
    public long getLong(int size) {
    	try{
    		return Long.valueOf(getString(size));
    	}catch(NumberFormatException e){
    		throw new RuntimeException("Dado Recebido não é numérico", e);
    	}
    }

    /**
     * Le uma quantidade de caracteres e converte a data do formato dd.mm.aaaa para dd/mm/aaaa 
     * @param size quantidade de caracteres a serem lidos
     * @return data lida
     */
    public String getData(int size) {
        return getString(size).replace('.', '/');
    }

    /**
     * Le uma quantidade de caracteres e converte o resultado em BigDecimal 
     * @param size quantidade de caracteres a serem lidos
     * @return valor lido
     */
    public BigDecimal getBigDecimal(int size, int decimal) {
        return new BigDecimal( getString(size) + "." + getString(decimal));
    }
}
