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
    // Função principal para verificar se o cpf esta valido (faz a chama das outras funções)
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

    @Override
    // Remove os caracteres invalidos para que possa ser efetuado as operações com cpf
    public String removeInvalidsCharacters(String cpf){   
        return cpf.replaceAll( "\\D*", "" );
    } 
    
    @Override
    // Verifica se o tamanho do cpf é valido (11)
    public boolean isValidSize(String cpf){  
        if ( cpf.length() == 11 )
            return true;   
        return false;
    } 
    
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
