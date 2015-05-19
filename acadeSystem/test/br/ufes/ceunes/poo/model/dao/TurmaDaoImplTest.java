/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Turma;
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
public class TurmaDaoImplTest {
    
    public TurmaDaoImplTest() {
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
     * Test of getAll method, of class TurmaDaoImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        TurmaDaoImpl instance = null;
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregar method, of class TurmaDaoImpl.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        TurmaDaoImpl instance = null;
        instance.carregar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class TurmaDaoImpl.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Turma turmaTemp = null;
        TurmaDaoImpl instance = null;
        instance.salvar(turmaTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaTurma method, of class TurmaDaoImpl.
     */
    @Test
    public void testBuscaTurma() {
        System.out.println("buscaTurma");
        Turma turma = null;
        TurmaDaoImpl instance = null;
        Turma expResult = null;
        Turma result = instance.buscaTurma(turma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarAtividade method, of class TurmaDaoImpl.
     */
    @Test
    public void testAdicionarAtividade() {
        System.out.println("adicionarAtividade");
        TurmaDaoImpl instance = null;
        instance.adicionarAtividade();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
