/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verificacoes;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class DataImplTest {
    
  
    /**
     * Verifica se a data é valida dentro co contexto real.
     */
    @Test
    public void testVerificaData() {
        System.out.println("verificaData");
        String data = "29/02/2015";
        DataImpl instance = new DataImpl();
        boolean expResult = false;
        boolean result = instance.verificaData(data);
        assertEquals(expResult, result);
    }
    
}
