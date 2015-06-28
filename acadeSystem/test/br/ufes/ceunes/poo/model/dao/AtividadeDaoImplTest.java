/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Atividade;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.pojo.Turma;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class AtividadeDaoImplTest {

    /**
     * Test of carregar method, of class AtividadeDaoImpl.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        ProfessorDaoImpl professor = new ProfessorDaoImpl();
        AlunoDaoImpl aluno = new AlunoDaoImpl();
        DisciplinaDaoImpl disciplina = new DisciplinaDaoImpl(professor);
        TurmaDaoImpl turma = new TurmaDaoImpl(professor, disciplina, aluno);
        AtividadeDaoImpl instance = new AtividadeDaoImpl(turma);
      //  instance.carregar();
    }

    /**
     * Test of salvar method, of class AtividadeDaoImpl.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Professor professor = new Professor("dudu", "142.234.534-23", "DCEL", 4);
        Disciplina disciplina = new Disciplina("Algebra", "Matrizes", "75hrs", 5);
        Turma turma = new Turma("2015", "1", "sala 2", "3hrs", 36, professor, disciplina, 66);
        Atividade atividadeTemp = new Atividade("nome", "tipo", "data", turma, 10, 1);
        ProfessorDaoImpl professorTest = new ProfessorDaoImpl();
        AlunoDaoImpl aluno = new AlunoDaoImpl();
        DisciplinaDaoImpl disciplinaTest = new DisciplinaDaoImpl(professorTest);
        TurmaDaoImpl turmaTest = new TurmaDaoImpl(professorTest, disciplinaTest, aluno);
        AtividadeDaoImpl instance = new AtividadeDaoImpl(turmaTest);
     //   instance.salvar(atividadeTemp);
    }

    /**
     * Test of buscar method, of class AtividadeDaoImpl.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Professor professor = new Professor("dudu", "142.234.534-23", "DCEL", 4);
        Disciplina disciplina = new Disciplina("Algebra", "Matrizes", "75hrs", 5);
        Turma turma = new Turma("2015", "1", "sala 2", "3hrs", 36, professor, disciplina, 66);
        Atividade atividade = new Atividade("nome", "tipo", "data", turma, 10, 1);
        ProfessorDaoImpl professorTest = new ProfessorDaoImpl();
        AlunoDaoImpl aluno = new AlunoDaoImpl();
        DisciplinaDaoImpl disciplinaTest = new DisciplinaDaoImpl(professorTest);
        TurmaDaoImpl turmaTest = new TurmaDaoImpl(professorTest, disciplinaTest, aluno);
        AtividadeDaoImpl instance = new AtividadeDaoImpl(turmaTest);
        AtividadeDaoImpl compara = instance;
        Atividade expResult = compara.buscar(atividade);
        Atividade result = instance.buscar(atividade);
        assertEquals(expResult, result);
    }

    /**
     * Test of gerarProximoId method, of class AtividadeDaoImpl.
     */
    @Test
    public void testGerarProximoId() {
        System.out.println("gerarProximoId");   
        ProfessorDaoImpl professorTest = new ProfessorDaoImpl();
        AlunoDaoImpl aluno = new AlunoDaoImpl();
        DisciplinaDaoImpl disciplinaTest = new DisciplinaDaoImpl(professorTest);
        TurmaDaoImpl turmaTest = new TurmaDaoImpl(professorTest, disciplinaTest, aluno);
        AtividadeDaoImpl instance = new AtividadeDaoImpl(turmaTest);
        int expResult = 14;
        int result = instance.gerarProximoId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAll method, of class AtividadeDaoImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ProfessorDaoImpl professorTest = new ProfessorDaoImpl();
        AlunoDaoImpl aluno = new AlunoDaoImpl();
        DisciplinaDaoImpl disciplinaTest = new DisciplinaDaoImpl(professorTest);
        TurmaDaoImpl turmaTest = new TurmaDaoImpl(professorTest, disciplinaTest, aluno);
        AtividadeDaoImpl instance = new AtividadeDaoImpl(turmaTest);
        AtividadeDaoImpl compara = instance;
        List expResult = compara.getAll();
        List result = instance.getAll();
        assertEquals(expResult, result);
    }
    
}
