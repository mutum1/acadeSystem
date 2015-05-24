/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class AlunoViewTest {
    
    public AlunoViewTest() {
    }

    /**
     * Test of cadastrar method, of class AlunoView.
     */
    @Test
    public void testCadastrar() {
        System.out.println("cadastrar");
        AlunoView instance = null;
        instance.cadastrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfo method, of class AlunoView.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        AlunoView instance = null;
        Aluno expResult = null;
        Aluno result = instance.getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existe method, of class AlunoView.
     */
    @Test
    public void testExiste() {
        System.out.println("existe");
        Aluno aluno = null;
        AlunoView instance = null;
        boolean expResult = false;
        boolean result = instance.existe(aluno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class AlunoView.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        AlunoView instance = null;
        instance.listar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
