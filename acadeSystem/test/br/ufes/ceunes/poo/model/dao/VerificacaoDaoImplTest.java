/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class VerificacaoDaoImplTest {
    
    public VerificacaoDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of verificaData method, of class VerificacaoDaoImpl.
     */
    @Test
    public void testVerificaData() {
        System.out.println("verificaData");
        String data = "";
        VerificacaoDaoImpl instance = new VerificacaoDaoImpl();
        boolean expResult = false;
        boolean result = instance.verificaData(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidCpf method, of class VerificacaoDaoImpl.
     */
    @Test
    public void testIsValidCpf() {
        System.out.println("isValidCpf");
        String cpf = "";
        VerificacaoDaoImpl instance = new VerificacaoDaoImpl();
        boolean expResult = false;
        boolean result = instance.isValidCpf(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeInvalidsCharacters method, of class VerificacaoDaoImpl.
     */
    @Test
    public void testRemoveInvalidsCharacters() {
        System.out.println("removeInvalidsCharacters");
        String cpf = "";
        VerificacaoDaoImpl instance = new VerificacaoDaoImpl();
        String expResult = "";
        String result = instance.removeInvalidsCharacters(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidSize method, of class VerificacaoDaoImpl.
     */
    @Test
    public void testIsValidSize() {
        System.out.println("isValidSize");
        String cpf = "";
        VerificacaoDaoImpl instance = new VerificacaoDaoImpl();
        boolean expResult = false;
        boolean result = instance.isValidSize(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDigits method, of class VerificacaoDaoImpl.
     */
    @Test
    public void testIsValidDigits() {
        System.out.println("isValidDigits");
        String cpf = "";
        VerificacaoDaoImpl instance = new VerificacaoDaoImpl();
        boolean expResult = false;
        boolean result = instance.isValidDigits(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculoComCpf method, of class VerificacaoDaoImpl.
     */
    @Test
    public void testCalculoComCpf() {
        System.out.println("calculoComCpf");
        String cpf = "";
        VerificacaoDaoImpl instance = new VerificacaoDaoImpl();
        String expResult = "";
        String result = instance.calculoComCpf(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
