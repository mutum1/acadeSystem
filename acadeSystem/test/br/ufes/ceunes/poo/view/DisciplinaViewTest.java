/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.pojo.Disciplina;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class DisciplinaViewTest {
    
    public DisciplinaViewTest() {
    }

    /**
     * Test of cadastrar method, of class DisciplinaView.
     */
    @Test
    public void testCadastrar() {
        System.out.println("cadastrar");
        DisciplinaView instance = null;
        instance.cadastrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfo method, of class DisciplinaView.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        DisciplinaView instance = null;
        Disciplina expResult = null;
        Disciplina result = instance.getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existe method, of class DisciplinaView.
     */
    @Test
    public void testExiste() {
        System.out.println("existe");
        Disciplina disciplina = null;
        DisciplinaView instance = null;
        boolean expResult = false;
        boolean result = instance.existe(disciplina);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Listar method, of class DisciplinaView.
     */
    @Test
    public void testListar() {
        System.out.println("Listar");
        DisciplinaView instance = null;
        instance.Listar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
