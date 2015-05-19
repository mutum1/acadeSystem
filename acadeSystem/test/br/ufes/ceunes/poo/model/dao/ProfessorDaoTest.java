/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Professor;
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
public class ProfessorDaoTest {
    
    public ProfessorDaoTest() {
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
     * Test of getAll method, of class ProfessorDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ProfessorDao instance = new ProfessorDaoImpl();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregar method, of class ProfessorDao.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        ProfessorDao instance = new ProfessorDaoImpl();
        instance.carregar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class ProfessorDao.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Professor professor = null;
        ProfessorDao instance = new ProfessorDaoImpl();
        instance.salvar(professor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaCpf method, of class ProfessorDao.
     */
    @Test
    public void testBuscaCpf() {
        System.out.println("buscaCpf");
        Professor professor = null;
        ProfessorDao instance = new ProfessorDaoImpl();
        Professor expResult = null;
        Professor result = instance.buscaCpf(professor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaId method, of class ProfessorDao.
     */
    @Test
    public void testBuscaId() {
        System.out.println("buscaId");
        Professor professor = null;
        ProfessorDao instance = new ProfessorDaoImpl();
        Professor expResult = null;
        Professor result = instance.buscaId(professor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ProfessorDaoImpl implements ProfessorDao {

        public List getAll() {
            return null;
        }

        public void carregar() {
        }

        public void salvar(Professor professor) {
        }

        public Professor buscaCpf(Professor professor) {
            return null;
        }

        public Professor buscaId(Professor professor) {
            return null;
        }
    }
    
}
