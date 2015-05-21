/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Professor;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class ProfessorDaoImplTest {
    
    public ProfessorDaoImplTest() {
    }

    /**
     * Test of getAll method, of class ProfessorDaoImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregar method, of class ProfessorDaoImpl.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        instance.carregar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class ProfessorDaoImpl.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Professor professorTemp = null;
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        instance.salvar(professorTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorCpf method, of class ProfessorDaoImpl.
     */
    @Test
    public void testBuscarPorCpf() {
        System.out.println("buscarPorCpf");
        Professor professor = null;
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        Professor expResult = null;
        Professor result = instance.buscarPorCpf(professor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class ProfessorDaoImpl.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Professor professor = null;
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        Professor expResult = null;
        Professor result = instance.buscar(professor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorNome method, of class ProfessorDaoImpl.
     */
    @Test
    public void testBuscarPorNome() {
        System.out.println("buscarPorNome");
        Professor professor = null;
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        List expResult = null;
        List result = instance.buscarPorNome(professor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
