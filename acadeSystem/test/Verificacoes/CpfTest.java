/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verificacoes;

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
public class CpfTest {
    
    public CpfTest() {
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
     * Test of isValidCpf method, of class Cpf.
     */
    @Test
    public void testIsValidCpf() {
        System.out.println("isValidCpf");
        String cpf = "";
        Cpf instance = new CpfImpl();
        boolean expResult = false;
        boolean result = instance.isValidCpf(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeInvalidsCharacters method, of class Cpf.
     */
    @Test
    public void testRemoveInvalidsCharacters() {
        System.out.println("removeInvalidsCharacters");
        String cpf = "";
        Cpf instance = new CpfImpl();
        String expResult = "";
        String result = instance.removeInvalidsCharacters(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidSize method, of class Cpf.
     */
    @Test
    public void testIsValidSize() {
        System.out.println("isValidSize");
        String cpf = "";
        Cpf instance = new CpfImpl();
        boolean expResult = false;
        boolean result = instance.isValidSize(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDigits method, of class Cpf.
     */
    @Test
    public void testIsValidDigits() {
        System.out.println("isValidDigits");
        String cpf = "";
        Cpf instance = new CpfImpl();
        boolean expResult = false;
        boolean result = instance.isValidDigits(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculoComCpf method, of class Cpf.
     */
    @Test
    public void testCalculoComCpf() {
        System.out.println("calculoComCpf");
        String cpf = "";
        Cpf instance = new CpfImpl();
        String expResult = "";
        String result = instance.calculoComCpf(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class CpfImpl implements Cpf {

        public boolean isValidCpf(String cpf) {
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
