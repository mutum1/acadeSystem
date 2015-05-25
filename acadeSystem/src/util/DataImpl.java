/*m
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Diego
 */
public class DataImpl implements Data {
    
    /**
     * Método para verificar se a data esta no formato correto para ser gravada
     * @param data copia da data, para saber se a data é válida.
     * @return True para data válida /False para data inválida.
     */
    @Override
    public boolean verificaData(String data) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);  
        String dataHoje = data; // 02/12/2013;

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
