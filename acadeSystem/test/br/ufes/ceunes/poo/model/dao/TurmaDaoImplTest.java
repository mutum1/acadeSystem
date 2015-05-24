/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

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
public class TurmaDaoImplTest {
   
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ProfessorDaoImpl professor = new ProfessorDaoImpl();
        DisciplinaDaoImpl disciplina = new DisciplinaDaoImpl(professor);
        AlunoDaoImpl aluno = new AlunoDaoImpl();
        TurmaDaoImpl instance = new TurmaDaoImpl(professor, disciplina, aluno);
        TurmaDaoImpl compara = instance;
        List expResult = compara.getAll();
        List result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of carregar method, of class TurmaDaoImpl.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        ProfessorDaoImpl professor = new ProfessorDaoImpl();
        DisciplinaDaoImpl disciplina = new DisciplinaDaoImpl(professor);
        AlunoDaoImpl aluno = new AlunoDaoImpl();
        TurmaDaoImpl instance = new TurmaDaoImpl(professor, disciplina, aluno);
        instance.carregar();
    }

    /**
     * Test of salvar method, of class TurmaDaoImpl.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Professor professorTemp = new Professor("Sand", "345.456.567.57", "Agua", 2);
        Disciplina disciplinaTemp = new Disciplina("asd", "qwe", "123as", 3);
        Turma turmaTemp = new Turma("2015", "1", "Sala 13", "integral", 50, professorTemp, disciplinaTemp, 1);
        ProfessorDaoImpl professor = new ProfessorDaoImpl();
        DisciplinaDaoImpl disciplina = new DisciplinaDaoImpl(professor);
        AlunoDaoImpl aluno = new AlunoDaoImpl();
        TurmaDaoImpl instance = new TurmaDaoImpl(professor, disciplina, aluno);
        instance.salvar(turmaTemp);
    }

    /**
     * Test of buscar method, of class TurmaDaoImpl.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Professor professorTemp = new Professor("Sand", "345.456.567.57", "Agua", 2);
        Disciplina disciplinaTemp = new Disciplina("asd", "qwe", "123as", 3);
        Turma turma = new Turma("2015", "1", "Sala 13", "integral", 50, professorTemp, disciplinaTemp, 1);
        ProfessorDaoImpl professor = new ProfessorDaoImpl();
        DisciplinaDaoImpl disciplina = new DisciplinaDaoImpl(professor);
        AlunoDaoImpl aluno = new AlunoDaoImpl();
        TurmaDaoImpl instance = new TurmaDaoImpl(professor, disciplina, aluno);
        TurmaDaoImpl compara = instance;
        Turma expResult = compara.buscar(turma);
        Turma result = instance.buscar(turma);
        assertEquals(expResult, result);
    }

    /**
     * Test of disponibilidadeLocal method, of class TurmaDaoImpl.
     */
    @Test
    public void testDisponibilidadeLocal() {
        System.out.println("disponibilidadeLocal");
        Professor professorTemp = new Professor("Sand", "345.456.567.57", "Agua", 2);
        Disciplina disciplinaTemp = new Disciplina("asd", "qwe", "123as", 3);
        Turma turma = new Turma("2015", "1", "Sala 13", "integral", 50, professorTemp, disciplinaTemp, 1);
        ProfessorDaoImpl professor = new ProfessorDaoImpl();
        DisciplinaDaoImpl disciplina = new DisciplinaDaoImpl(professor);
        AlunoDaoImpl aluno = new AlunoDaoImpl();
        TurmaDaoImpl instance = new TurmaDaoImpl(professor, disciplina, aluno);
        TurmaDaoImpl compara = instance;
        Turma expResult = compara.disponibilidadeLocal(turma);
        Turma result = instance.disponibilidadeLocal(turma);
        assertEquals(expResult, result);
    }
    
}
