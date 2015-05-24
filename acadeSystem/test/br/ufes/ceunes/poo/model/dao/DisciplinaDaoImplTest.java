/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Disciplina;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class DisciplinaDaoImplTest {
    
    public DisciplinaDaoImplTest() {
    }

    /**
     * Test of getAll method, of class DisciplinaDaoImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        DisciplinaDaoImpl instance = null;
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of carregar method, of class DisciplinaDaoImpl.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        DisciplinaDaoImpl instance = null;
        instance.carregar();
    }

    /**
     * Test of salvar method, of class DisciplinaDaoImpl.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Disciplina disciplinaTemp = null;
        DisciplinaDaoImpl instance = null;
        instance.salvar(disciplinaTemp);
    }

    /**
     * Test of buscar method, of class DisciplinaDaoImpl.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Disciplina disciplina = null;
        DisciplinaDaoImpl instance = null;
        Disciplina expResult = null;
        Disciplina result = instance.buscar(disciplina);
        assertEquals(expResult, result);
    }
    
}
