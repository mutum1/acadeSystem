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
    
    public void cadastrarAluno(AlunoDao alunoDao){
        AlunoView alunoView = new AlunoView();
        
        Aluno aluno = alunoView.getInfo();
        if(!alunoView.existeAluno(aluno, alunoDao)){
            alunoDao.adicionar(aluno);
        }
    }
    
    public void cadastrarProfessor(ProfessorDao professorDao){
        ProfessorView professorView = new ProfessorView();
        
        Professor professor = professorView.getInfo();
        if(!professorView.existeProfessor(professor, professorDao)){
            professorDao.adicionar(professor);
        }
    }
    public void cadastrarDisciplina(DisciplinaDao disciplinaDao){
        DisciplinaView disciplinaView = new DisciplinaView();
        
        Disciplina disciplina = disciplinaView.getInfo();
        if(!disciplinaView.existeDisciplina(disciplina, disciplinaDao)){
            disciplinaDao.adicionar(disciplina);
        }
    }
    public void cadastrarTurma(TurmaDao turmaDao){
        TurmaView turmaView = new TurmaView();
        
        Turma turma = turmaView.getInfo();
        if(!turmaView.existeTurma(turma, turmaDao)){
            turmaDao.adicionar(turma);
        }
    }    
}


