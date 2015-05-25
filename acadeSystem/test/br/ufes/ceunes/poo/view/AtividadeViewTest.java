/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDaoImpl;
import br.ufes.ceunes.poo.model.dao.AtividadeDaoImpl;
import br.ufes.ceunes.poo.model.dao.DisciplinaDaoImpl;
import br.ufes.ceunes.poo.model.dao.ProfessorDaoImpl;
import br.ufes.ceunes.poo.model.dao.TurmaDaoImpl;
import br.ufes.ceunes.poo.model.pojo.Turma;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class AtividadeViewTest {

    /**
     * Test of listar method, of class AtividadeView.
     */
    @Test
    public void testListar_0args() {
        System.out.println("listar");
        ProfessorDaoImpl professor = new ProfessorDaoImpl();
        AlunoDaoImpl aluno = new AlunoDaoImpl();
        DisciplinaDaoImpl disciplina = new DisciplinaDaoImpl(professor);
        TurmaDaoImpl turma = new TurmaDaoImpl(professor, disciplina, aluno);
        AtividadeDaoImpl atividade = new AtividadeDaoImpl(turma);
        AtividadeView instance = new AtividadeView(atividade, turma)
;        instance.listar();
    }

    /**
     * Test of listar method, of class AtividadeView.
     */
    @Test
    public void testListar_Turma() {
        System.out.println("listar");
        Turma turma = new Turma(null, null, null, null, 50, null, null, 2);
        AtividadeView instance = new AtividadeView(null, null);
        instance.listar(turma);
    }
}
