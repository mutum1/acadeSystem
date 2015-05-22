/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

/**
 *
 * @author Ayer
 */
public abstract class Cpf {

    private static String tempCpf = "";
    
    /**
     * Método responsavel pela parte final da validação utilizando os outros
     * metodos da classe.
     * @param cpf
     * @return True /False
     */
    
    static boolean isValidCpf(String cpf){
        
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
     * Método utilizado para remover caracter que não são validos para um cpf
     * @param cpf
     * @return 
     */
    
    private static String removeInvalidsCharacters(String cpf){   
        return cpf.replaceAll( "\\D*", "" );
    } 
    
    /**
     * Método responsavel para verificar se o Cpf está com tamanho correto.
     * @param cpf
     * @return 
     */
    private static boolean isValidSize(String cpf){  
        if ( cpf.length() == 11 )
            return true;   
        return false;
    } 
    /**
     * Método que verifica se os digitos satisfazem a condição para que sejam
     * de fato um cpf.
     * @param cpf
     * @return 
     */
    private static boolean isValidDigits(String cpf){   
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
     * Método responsavel por fazer as demais verificações para que seja um cpf.
     * @param cpf
     * @return 
     */
    
    private static String calculoComCpf(String cpf){   
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
