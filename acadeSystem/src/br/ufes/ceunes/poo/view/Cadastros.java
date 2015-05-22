/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.dao.TurmaDao;
import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.pojo.Turma;

/**
 *
 * @author paulo
 */

public class Cadastros {

    /**
     * Método responsavel por cadastrar um aluno em uma lista
     * sem duplicatas.
     * @param alunoDao 
     */
    public void cadastrarAluno(AlunoDao alunoDao){
        AlunoView alunoView = new AlunoView(alunoDao);
        
        Aluno aluno = alunoView.getInfo();
        if(!alunoView.existe(aluno)){
            alunoDao.adicionar(aluno);
        }
    }
    /**
     * Método responsavel por cadastrar um professor em uma lista
     * sem duplicatas.
     * @param professorDao 
     */
    
    public void cadastrarProfessor(ProfessorDao professorDao){
        ProfessorView professorView = new ProfessorView(professorDao);
        
        Professor professor = professorView.getInfo();
        if(!professorView.existe(professor)){
            professorDao.adicionar(professor);
        }
    }
    
    /**
     * Método responsavel por cadastrar uma disciplina em uma lista
     * sem duplicatas.
     * @param disciplinaDao 
     */
    
    public void cadastrarDisciplina(DisciplinaDao disciplinaDao){
        DisciplinaView disciplinaView = new DisciplinaView(disciplinaDao);
        
        Disciplina disciplina = disciplinaView.getInfo();
        if(!disciplinaView.existe(disciplina)){
            disciplinaDao.adicionar(disciplina);
        }
    }
    
    /**
     * Método responsavel por cadastrar uma turma em uma lista
     * sem duplicatas.
     * @param turmaDao
     * @param disciplinaDao
     * @param professorDao 
     */
    
    public void cadastrarTurma(TurmaDao turmaDao, DisciplinaDao disciplinaDao,ProfessorDao professorDao){
        TurmaView turmaView = new TurmaView(turmaDao, professorDao, disciplinaDao);
        
        Turma turma = turmaView.getInfo();
        if(!turmaView.existe(turma)){
            turmaDao.adicionar(turma);
        }
    }    
}


