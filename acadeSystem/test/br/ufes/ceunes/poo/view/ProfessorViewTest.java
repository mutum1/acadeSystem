/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.pojo.Professor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class ProfessorViewTest {
    
    public ProfessorViewTest() {
    }

    /**
     * Test of cadastrar method, of class ProfessorView.
     */
    @Test
    public void testCadastrar() {
        System.out.println("cadastrar");
        ProfessorView instance = null;
        instance.cadastrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfo method, of class ProfessorView.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        ProfessorView instance = null;
        Professor expResult = null;
        Professor result = instance.getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existe method, of class ProfessorView.
     */
    @Test
    public void testExiste() {
        System.out.println("existe");
        Professor professor = null;
        ProfessorView instance = null;
        boolean expResult = false;
        boolean result = instance.existe(professor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class ProfessorView.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        ProfessorView instance = null;
        instance.listar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
