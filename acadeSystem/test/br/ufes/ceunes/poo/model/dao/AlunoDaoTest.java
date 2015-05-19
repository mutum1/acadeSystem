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
public class AlunoDaoTest {
    
    public AlunoDaoTest() {
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
     * Test of getAll method, of class AlunoDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        AlunoDao instance = new AlunoDaoImpl();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregar method, of class AlunoDao.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        AlunoDao instance = new AlunoDaoImpl();
        instance.carregar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class AlunoDao.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Aluno aluno = null;
        AlunoDao instance = new AlunoDaoImpl();
        instance.salvar(aluno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class AlunoDao.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Aluno aluno = null;
        AlunoDao instance = new AlunoDaoImpl();
        Aluno expResult = null;
        Aluno result = instance.buscar(aluno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AlunoDaoImpl implements AlunoDao {

        public List getAll() {
            return null;
        }

        public void carregar() {
        }

        public void salvar(Aluno aluno) {
        }

        public Aluno buscar(Aluno aluno) {
            return null;
        }
    }
    
}
