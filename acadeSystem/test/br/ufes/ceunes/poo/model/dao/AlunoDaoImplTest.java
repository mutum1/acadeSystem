/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import java.util.List;
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
public class AlunoDaoImplTest {
    
    public AlunoDaoImplTest() {
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
     * Test of getAll method, of class AlunoDaoImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        AlunoDaoImpl instance = new AlunoDaoImpl();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregar method, of class AlunoDaoImpl.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        AlunoDaoImpl instance = new AlunoDaoImpl();
        instance.carregar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class AlunoDaoImpl.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Aluno alunoTemp = null;
        AlunoDaoImpl instance = new AlunoDaoImpl();
        instance.salvar(alunoTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class AlunoDaoImpl.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Aluno alunoTemp = null;
        AlunoDaoImpl instance = new AlunoDaoImpl();
        Aluno expResult = null;
        Aluno result = instance.buscar(alunoTemp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
