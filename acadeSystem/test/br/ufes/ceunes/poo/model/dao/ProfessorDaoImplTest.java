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
        ProfessorDaoImpl compara = instance;
        List expResult = compara.getAll();
        List result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of carregar method, of class ProfessorDaoImpl.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        instance.carregar();
    }

    /**
     * Test of salvar method, of class ProfessorDaoImpl.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Professor professorTemp = new Professor("Joel", "123.321.231-34", "NASUS", 242);
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        instance.salvar(professorTemp);
    }

    /**
     * Test of buscarPorCpf method, of class ProfessorDaoImpl.
     */
    @Test
    public void testBuscarPorCpf() {
        System.out.println("buscarPorCpf");
        Professor professor = new Professor("Jesus", "777.777.777-77", "HEAVEN", 777);
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        ProfessorDaoImpl compara = instance;
        Professor expResult = compara.buscarPorCpf(professor);
        Professor result = instance.buscarPorCpf(professor);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscar method, of class ProfessorDaoImpl.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Professor professor = new Professor("Diego", "242.242.242.24", "DOTA2", 24);
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        ProfessorDaoImpl compara = instance;
        Professor expResult = compara.buscar(professor);
        Professor result = instance.buscar(professor);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarPorNome method, of class ProfessorDaoImpl.
     */
    @Test
    public void testBuscarPorNome() {
        System.out.println("buscarPorNome");
        Professor professor = new Professor("Juggernault", "145.234.543-32", "DotA", 66);
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        ProfessorDaoImpl compara = instance;
        List expResult = compara.buscarPorNome(professor);
        List result = instance.buscarPorNome(professor);
        assertEquals(expResult, result);
    }
    
}
