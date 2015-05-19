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
 * @author Usuario
 */
public class DataImpl implements Data {
    
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
    
}
