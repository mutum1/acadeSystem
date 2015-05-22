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
public class CpfImplTest {
    
    public CpfImplTest() {
    }

    /**
     * Verifica se o CPF é valido.
     */
    @Test
    public void testIsValidCpf() {
        System.out.println("Testando o CPF");
        String cpf = "131.700.947-93";
        CpfImpl instance = new CpfImpl();
        boolean expResult = true;
        boolean result = instance.isValidCpf(cpf);
        assertEquals(expResult, result);
    }

    /**
     *Remove os caracteres invalidos que não seja numeros.
     */
    @Test
    public void testRemoveInvalidsCharacters() {
        System.out.println("131.700.947-93");
        String cpf = "13170094793";
        CpfImpl instance = new CpfImpl();
        String expResult = "13170094793";
        String result = instance.removeInvalidsCharacters(cpf);
        assertEquals(expResult, result);
    }

    /**
     * Verifica se o tamanho é valido.
     */
    @Test
    public void testIsValidSize() {
        System.out.println("Verifica o Tamanho");
        String cpf = "OnzeNumeros";
        CpfImpl instance = new CpfImpl();
        boolean expResult = true;
        boolean result = instance.isValidSize(cpf);
        assertEquals(expResult, result);
    }

    /**
     * Verifica se o usuario nao digitou tudo zero.
     */
    @Test
    public void testIsValidDigits() {
        System.out.println("Verifica se a entrada n e Zero");
        String cpf = "00000000000";
        CpfImpl instance = new CpfImpl();
        boolean expResult = true;
        boolean result = instance.isValidDigits(cpf);
        assertEquals(expResult, result);
    }

    /**
     * Realiza io calculo do Cpf.
     */
    @Test
    public void testCalculoComCpf() {
        System.out.println("calculoComCpf");
        String cpf = "782.249.187-34";
        CpfImpl instance = new CpfImpl();
        String expResult = "0";
        String result = instance.calculoComCpf(cpf);
        assertEquals(expResult, result);
    }
    
}
