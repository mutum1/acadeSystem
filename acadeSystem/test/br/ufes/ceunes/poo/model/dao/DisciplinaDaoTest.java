/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Disciplina;
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
public class DisciplinaDaoTest {
    
    public DisciplinaDaoTest() {
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
     * Test of getAll method, of class DisciplinaDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        DisciplinaDao instance = new DisciplinaDaoImpl();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregar method, of class DisciplinaDao.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        DisciplinaDao instance = new DisciplinaDaoImpl();
        instance.carregar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class DisciplinaDao.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Disciplina disciplina = null;
        DisciplinaDao instance = new DisciplinaDaoImpl();
        instance.salvar(disciplina);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaDisciplina method, of class DisciplinaDao.
     */
    @Test
    public void testBuscaDisciplina() {
        System.out.println("buscaDisciplina");
        Disciplina disciplina = null;
        DisciplinaDao instance = new DisciplinaDaoImpl();
        Disciplina expResult = null;
        Disciplina result = instance.buscaDisciplina(disciplina);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DisciplinaDaoImpl implements DisciplinaDao {

        public List getAll() {
            return null;
        }

        public void carregar() {
        }

        public void salvar(Disciplina disciplina) {
        }

        public Disciplina buscaDisciplina(Disciplina disciplina) {
            return null;
        }
    }
    
}
