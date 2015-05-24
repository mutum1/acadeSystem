/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.DisciplinaDaoImpl;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class DisciplinaViewTest {

    /**
     * Cadastra a disciplina.
     */
    @Test
    public void testCadastrar() {
        System.out.println("cadastrar");
        DisciplinaView instance = new DisciplinaView(null);
        instance.cadastrar();
    }

    /**
     * Captura informacao das disciplina.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        DisciplinaView instance = new DisciplinaView(null);
        Disciplina expResult = null;
        Disciplina result = instance.getInfo();
        assertEquals(expResult, result);
    }

    /**
     * Verifica se existe a dsciplina.
     */
    @Test
    public void testExiste() {
        System.out.println("existe");
        Disciplina disciplina = new Disciplina("Calculo", "Matematica Aplicada", "90hrs", 6);
        DisciplinaDaoImpl disciplinaTest = new DisciplinaDaoImpl(null);
        DisciplinaView instance = new DisciplinaView(disciplinaTest);
        boolean expResult = true;
        boolean result = instance.existe(disciplina);
        assertEquals(expResult, result);
    }

    /**
     * Lista as disciplinas.
     */
    @Test
    public void testListar() {
        System.out.println("Listar");
        DisciplinaDaoImpl disciplinaTest = new DisciplinaDaoImpl(null);
        DisciplinaView instance = new DisciplinaView(disciplinaTest);
        instance.Listar();
    }
    
}
