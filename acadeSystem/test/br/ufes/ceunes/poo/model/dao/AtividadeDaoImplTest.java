/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Atividade;
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
public class AtividadeDaoImplTest {
    
    public AtividadeDaoImplTest() {
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
     * Test of getAll method, of class AtividadeDaoImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        AtividadeDaoImpl instance = new AtividadeDaoImpl();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregar method, of class AtividadeDaoImpl.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        AtividadeDaoImpl instance = new AtividadeDaoImpl();
        instance.carregar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class AtividadeDaoImpl.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Atividade atividade = null;
        AtividadeDaoImpl instance = new AtividadeDaoImpl();
        instance.salvar(atividade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
