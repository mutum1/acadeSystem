/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.ProfessorDaoImpl;
import br.ufes.ceunes.poo.model.pojo.Professor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class ProfessorViewTest {

    /**
     * Verifica se exite tal professor.
     */
    @Test
    public void testExiste() {
        System.out.println("existe");
        Professor professor = new Professor("Jesus", "132.323.342-12", "Heaven", 34);
        ProfessorDaoImpl professorTemp = new ProfessorDaoImpl();
        ProfessorView instance = new ProfessorView(professorTemp);
        boolean expResult = false;
        boolean result = instance.existe(professor);
        assertEquals(expResult, result);
    }

    /**
     * Lista os professores cadastrados.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        ProfessorDaoImpl professor = new ProfessorDaoImpl();
        ProfessorView instance = new ProfessorView(professor);
        instance.listar();
     }
    
}
