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
    
    /**
     * Captura tudo.
     */
    @Test
    public void testGetAll() {
        System.out.println("get All");
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        ProfessorDaoImpl compara = instance;
        List expResult = compara.getAll();
        List result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Carrega do Arquivo.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        instance.carregar();
    }

    /**
     * Salva no Arquivo.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Professor professorTemp = new Professor("Joel", "123.321.231-34", "NASUS", 242);
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        instance.salvar(professorTemp);
    }

    /**
     * Realiza a busca pelo CPF, instancia o professor, pois não pode ser NULL.
     */
    @Test
    public void testBuscarPorCpf() {
        System.out.println("buscar Por Cpf");
        Professor professor = new Professor("Jesus", "777.777.777-77", "HEAVEN", 777);
        ProfessorDaoImpl instance = new ProfessorDaoImpl();
        ProfessorDaoImpl compara = instance;
        Professor expResult = compara.buscarPorCpf(professor);
        Professor result = instance.buscarPorCpf(professor);
        assertEquals(expResult, result);
    }

    /**
     * Realiza a busca.
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
     * Realiza a busca pelo nome, instancia o professor, pois não pode ser NULL.
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
