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
public class VerificacaoDaoTest {
    
    public VerificacaoDaoTest() {
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
     * Test of isValidCpf method, of class VerificacaoDao.
     */
    @Test
    public void testIsValidCpf() {
        System.out.println("isValidCpf");
        String cpf = "";
        VerificacaoDao instance = new VerificacaoDaoImpl();
        boolean expResult = false;
        boolean result = instance.isValidCpf(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaData method, of class VerificacaoDao.
     */
    @Test
    public void testVerificaData() {
        System.out.println("verificaData");
        String Data = "";
        VerificacaoDao instance = new VerificacaoDaoImpl();
        boolean expResult = false;
        boolean result = instance.verificaData(Data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeInvalidsCharacters method, of class VerificacaoDao.
     */
    @Test
    public void testRemoveInvalidsCharacters() {
        System.out.println("removeInvalidsCharacters");
        String cpf = "";
        VerificacaoDao instance = new VerificacaoDaoImpl();
        String expResult = "";
        String result = instance.removeInvalidsCharacters(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidSize method, of class VerificacaoDao.
     */
    @Test
    public void testIsValidSize() {
        System.out.println("isValidSize");
        String cpf = "";
        VerificacaoDao instance = new VerificacaoDaoImpl();
        boolean expResult = false;
        boolean result = instance.isValidSize(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDigits method, of class VerificacaoDao.
     */
    @Test
    public void testIsValidDigits() {
        System.out.println("isValidDigits");
        String cpf = "";
        VerificacaoDao instance = new VerificacaoDaoImpl();
        boolean expResult = false;
        boolean result = instance.isValidDigits(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculoComCpf method, of class VerificacaoDao.
     */
    @Test
    public void testCalculoComCpf() {
        System.out.println("calculoComCpf");
        String cpf = "";
        VerificacaoDao instance = new VerificacaoDaoImpl();
        String expResult = "";
        String result = instance.calculoComCpf(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class VerificacaoDaoImpl implements VerificacaoDao {

        public boolean isValidCpf(String cpf) {
            return false;
        }

        public boolean verificaData(String Data) {
            return false;
        }

        public String removeInvalidsCharacters(String cpf) {
            return "";
        }

        public boolean isValidSize(String cpf) {
            return false;
        }

        public boolean isValidDigits(String cpf) {
            return false;
        }

        public String calculoComCpf(String cpf) {
            return "";
        }
    }
    
}
