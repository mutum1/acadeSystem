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
public class TurmaDaoTest {
    
    public TurmaDaoTest() {
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
     * Test of getAll method, of class TurmaDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        TurmaDao instance = new TurmaDaoImpl();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregar method, of class TurmaDao.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        TurmaDao instance = new TurmaDaoImpl();
        instance.carregar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class TurmaDao.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Turma turma = null;
        TurmaDao instance = new TurmaDaoImpl();
        instance.salvar(turma);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaTurma method, of class TurmaDao.
     */
    @Test
    public void testBuscaTurma() {
        System.out.println("buscaTurma");
        Turma turma = null;
        TurmaDao instance = new TurmaDaoImpl();
        Turma expResult = null;
        Turma result = instance.buscaTurma(turma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarAtividade method, of class TurmaDao.
     */
    @Test
    public void testAdicionarAtividade() {
        System.out.println("adicionarAtividade");
        TurmaDao instance = new TurmaDaoImpl();
        instance.adicionarAtividade();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class TurmaDaoImpl implements TurmaDao {

        public List getAll() {
            return null;
        }

        public void carregar() {
        }

        public void salvar(Turma turma) {
        }

        public Turma buscaTurma(Turma turma) {
            return null;
        }

        public void adicionarAtividade() {
        }
    }

    public class TurmaDaoImpl implements TurmaDao {

        public List getAll() {
            return null;
        }

        public void carregar() {
        }

        public void salvar(Turma turma) {
        }

        public Turma buscaTurma(Turma turma) {
            return null;
        }

        public void adicionarAtividade() {
        }
    }
    
}
