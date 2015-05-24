/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.DisciplinaDaoImpl;
import br.ufes.ceunes.poo.model.dao.ProfessorDaoImpl;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class DisciplinaViewTest {

    /**
     * Verifica se existe a dsciplina.
     */
    @Test
    public void testExiste() {
        System.out.println("existe");
        //Disciplina disciplina1 = new Disciplina(null, null, null, 1);
        Disciplina disciplina = new Disciplina("Calculo", "Matematica Aplicada", "90hrs", 6);
        ProfessorDaoImpl professor = new ProfessorDaoImpl();
        DisciplinaDaoImpl disciplinaTest = new DisciplinaDaoImpl(professor);
        DisciplinaView instance = new DisciplinaView(disciplinaTest);
        boolean expResult = false;
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
