/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDaoImpl;
import br.ufes.ceunes.poo.model.dao.DisciplinaDaoImpl;
import br.ufes.ceunes.poo.model.dao.ProfessorDaoImpl;
import br.ufes.ceunes.poo.model.dao.TurmaDao;
import br.ufes.ceunes.poo.model.dao.TurmaDaoImpl;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.pojo.Turma;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class TurmaViewTest {
   
    /**
     * Testa a função que verifica se o local estava disponível.
     */
    @Test
    public void testLocalDisponivel() {
        System.out.println("localDisponivel");
        Professor professor = new Professor("Joao", "123.457.523-08", "DECOM", 1);
        Disciplina disciplina = new Disciplina("POO", "Prog Orientada a obj", "75hrs", 3);
        Turma turma = new Turma("2015", "1", "sala 07", "07:00 - 09:00", 50, professor, disciplina, 2);
        AlunoDaoImpl alunoTest = new AlunoDaoImpl();
        ProfessorDaoImpl professorTest = new ProfessorDaoImpl();
        DisciplinaDaoImpl disciplinaTest = new DisciplinaDaoImpl(professorTest);
        TurmaDaoImpl turmaTest = new TurmaDaoImpl(professorTest, disciplinaTest, alunoTest);
        TurmaView instance = new TurmaView(turmaTest, alunoTest, professorTest, disciplinaTest, null, null);
        boolean expResult = true;
        boolean result = instance.localDisponivel(turma);
        assertEquals(expResult, result);
    }

    /**
     * Testa a função que lista as turmas.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        AlunoDaoImpl aluno = new AlunoDaoImpl();
        ProfessorDaoImpl professor = new ProfessorDaoImpl();
        DisciplinaDaoImpl disciplina = new DisciplinaDaoImpl(professor);
        TurmaDaoImpl turma = new TurmaDaoImpl(professor, disciplina, aluno);
        TurmaView instance = new TurmaView(turma, aluno, professor, disciplina, null, null);
        instance.listar();
    }
    
}
