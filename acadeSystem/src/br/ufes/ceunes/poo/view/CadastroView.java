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

public class CadastroView {

    private AlunoView alunoView;
    private ProfessorView professorView;
    private DisciplinaView disciplinaView;
    private TurmaView turmaView;
    private Menu menu;
    
    
    
    public CadastroView(AlunoView alunoView,ProfessorView professorView,DisciplinaView disciplinaView,TurmaView turmaView){
        this.alunoView = alunoView;
        this.professorView = professorView;
        this.disciplinaView = disciplinaView;
        this.turmaView = turmaView;
        this.menu = new Menu();
    }
    
    public void abrir(){
        
        this.menu.setTitle("Menu Cadastros");
        this.menu.addOption("Cadastrar Aluno");
        this.menu.addOption("Cadastrar Profesor");
        this.menu.addOption("Cadastrar Disciplina");
        this.menu.addOption("Cadastrar Turma");
        this.menu.addOption("Cadastrar Aluno");
        this.menu.addOption("Voltar");
        
        this.menu.showOptions();
        
        int opcao = menu.getOption();
        switch(opcao){
            case 1:
                cadastrarAluno();
                break;
            case 2:
                cadastrarProfessor();
                break;
            case 3:
                cadastrarDisciplina();
            case 4:
                cadastrarTurma();
        }
    }
    /**
     * Método responsavel por cadastrar um aluno em uma lista
     * sem duplicatas.
     * @param alunoDao 
     */
    private void cadastrarAluno(){    
        Aluno aluno = alunoView.getInfo();
        if(!alunoView.existe(aluno)){
            alunoView.salvar(aluno);
        }
    }
    /**
     * Método responsavel por cadastrar um professor em uma lista
     * sem duplicatas.
     * @param professorDao 
     */
    
    private void cadastrarProfessor(){    
        Professor professor = professorView.getInfo();
        if(!professorView.existe(professor)){
            professorView.salvar(professor);
        }
    }
    
    /**
     * Método responsavel por cadastrar uma disciplina em uma lista
     * sem duplicatas.
     * @param disciplinaDao 
     */
    
    public void cadastrarDisciplina(){        
        Disciplina disciplina = disciplinaView.getInfo();
        if(!disciplinaView.existe(disciplina)){
            disciplinaView.salvar(disciplina);
        }
    }
    
    /**
     * Método responsavel por cadastrar uma turma em uma lista
     * sem duplicatas.
     * @param turmaDao
     * @param disciplinaDao
     * @param professorDao 
     */
    
    public void cadastrarTurma(){    
        Turma turma = turmaView.getInfo();
        if(!turmaView.existe(turma)){
            turmaView.salvar(turma);
        }
    }    
}


