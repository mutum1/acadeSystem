/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.pojo.Turma;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class TurmaViewTest {
    
    public TurmaViewTest() {
    }

    /**
     * Test of cadastrar method, of class TurmaView.
     */
    @Test
    public void testCadastrar() {
        System.out.println("cadastrar");
        TurmaView instance = null;
        instance.cadastrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfo method, of class TurmaView.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        TurmaView instance = null;
        Turma expResult = null;
        Turma result = instance.getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of localDisponivel method, of class TurmaView.
     */
    @Test
    public void testLocalDisponivel() {
        System.out.println("localDisponivel");
        Turma turma = null;
        TurmaView instance = null;
        boolean expResult = false;
        boolean result = instance.localDisponivel(turma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class TurmaView.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        TurmaView instance = null;
        instance.listar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
