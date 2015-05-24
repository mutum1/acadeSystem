/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Turma;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class TurmaDaoImplTest {
    
    public TurmaDaoImplTest() {
    }

    /**
     * Test of getAll method, of class TurmaDaoImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        TurmaDaoImpl instance = null;
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of carregar method, of class TurmaDaoImpl.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        TurmaDaoImpl instance = null;
        instance.carregar();
    }

    /**
     * Test of salvar method, of class TurmaDaoImpl.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Turma turmaTemp = null;
        TurmaDaoImpl instance = null;
        instance.salvar(turmaTemp);
    }

    /**
     * Test of buscar method, of class TurmaDaoImpl.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Turma turma = null;
        TurmaDaoImpl instance = null;
        Turma expResult = null;
        Turma result = instance.buscar(turma);
        assertEquals(expResult, result);
    }

    /**
     * Test of disponibilidadeLocal method, of class TurmaDaoImpl.
     */
    @Test
    public void testDisponibilidadeLocal() {
        System.out.println("disponibilidadeLocal");
        Turma turma = null;
        TurmaDaoImpl instance = null;
        Turma expResult = null;
        Turma result = instance.disponibilidadeLocal(turma);
        assertEquals(expResult, result);
    }
    
}
