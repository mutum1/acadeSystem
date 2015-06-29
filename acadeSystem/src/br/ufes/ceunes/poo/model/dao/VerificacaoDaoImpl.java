/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Diego
 */
public class VerificacaoDaoImpl implements VerificacaoDao {

    private static String tempCpf = "";
    
    @Override
    // Função para verificar se a data esta no formato correto para ser gravada
    public boolean verificaData(String data) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);  
        String dataHoje = data; // 08/11/2014;

        try {
            Date dataAuxiliar = sdf.parse(dataHoje);
            System.out.println("A data é válida.");
            return true;
        } catch(ParseException e) {
            System.out.println("A data é inválida.");
            return false;
        }
    }
    
    @Override
    /**
     * Método principal para verificar se o cpf esta valido (faz a chamada das
     * outras funções)
     * @param cpf CPF digitado
     * @return true caso seja valido, false no caso contrario.
     */
    public boolean isValidCpf(String cpf){
        
        if(cpf == null) return false;
        else{
            cpf = removeInvalidsCharacters(cpf);//tira os caracteres q nao sao numeros   
            if ( !isValidSize(cpf) ) return false;
            if ( isValidDigits(cpf) )return false;  
            tempCpf = cpf.substring(0, 9);
            tempCpf = tempCpf.concat(calculoComCpf(tempCpf));
            tempCpf = tempCpf.concat(calculoComCpf(tempCpf));
            if ( !tempCpf.equals(cpf)) return false;
        } 
        return true;
    }
     /**
     * Remove os caracteres invalidos para que possa ser efetuado as operações com cpf.
     * @param cpf primeira chamada do cpf digitado para remover os char's invalidos.
     * @return o cpf sem os caracteres invalidos.
     */
    @Override
    // Remove os caracteres invalidos para que possa ser efetuado as operações com cpf
    public String removeInvalidsCharacters(String cpf){   
        return cpf.replaceAll( "\\D*", "" );
    } 
   
    /**
     * Verifica se o tamanho do cpf é valido (11).
     * @param cpf CPF sem os caracteres invalidos.
     * @return True se for valido/False em caso contrario.
     */
    @Override
    // Verifica se o tamanho do cpf é valido (11)
    public boolean isValidSize(String cpf){  
        if ( cpf.length() == 11 )
            return true;   
        return false;
    } 
    /**
     * Verifica se os digitos do cpf sao validos.
     * @param cpf cpf no formato correto, para que se verifique o digito verificador.
     * @return True caso os digitos satisfazem a condição de cpf/ False no caso
     * contrario.
     */
    @Override
    // Verifica se os digitos do cpf sao validos
    public boolean isValidDigits(String cpf){   
        char primDig = '0';
        char [] charCpf = cpf.toCharArray();  
            for( char c: charCpf  ){
                if ( c != primDig ){
                    return false;
                } 
            }    
        return true;
    } 
    /**
     * Faz o calculo efetivo do cpf (algoritmo).
     * @param cpf cpf para verificar o digito verificador.
     * @return digito verificador.
     */
    @Override
    // Faz o calculo efetivo do cpf (algoritmo)
    public String calculoComCpf(String cpf){   
        int digGerado = 0;
        int mult = cpf.length()+1;
        char [] charCpf = cpf.toCharArray();

        for ( int i = 0; i < cpf.length(); i++ )
            digGerado += (charCpf[i]-48)* mult--;

        if ( digGerado % 11 < 2)
            digGerado = 0;
        else
           digGerado = 11 - digGerado % 11;
        return  String.valueOf(digGerado); 
    }
    
}