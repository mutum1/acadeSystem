/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verificacoes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Diego
 */
public class CpfImpl implements Cpf {

    private static String tempCpf = "";
    
    /**
     * Método principal para verificar se o cpf esta valido (faz a chamada das
     * outras funções)
     * @param cpf
     * @return true caso seja valido, false no caso contrario.
     */
    @Override
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
     * @param cpf
     * @return o cpf sem os caracteres invalidos.
     */
    @Override
    public String removeInvalidsCharacters(String cpf){   
        return cpf.replaceAll( "\\D*", "" );
    } 
    
    /**
     * Verifica se o tamanho do cpf é valido (11).
     * @param cpf
     * @return True se for valido/False em caso contrario.
     */
    @Override
    public boolean isValidSize(String cpf){  
        if ( cpf.length() == 11 )
            return true;   
        return false;
    } 
    /**
     * Verifica se os digitos do cpf sao validos.
     * @param cpf
     * @return True caso os digitos satisfazem a condição de cpf/ False no caso
     * contrario.
     */
    @Override
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
     * @param cpf
     * @return digito verificador.
     */
    @Override
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
