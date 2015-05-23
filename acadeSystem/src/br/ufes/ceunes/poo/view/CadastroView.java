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
        this.menu.addOption("Voltar");
        
        this.menu.showOptions();
        int opcao = menu.getOption();
        while(opcao != menu.getSize()){
            switch(opcao){
                case 1:
                    alunoView.cadastrarAluno();
                    break;
                case 2:
                    professorView.cadastrarProfessor();
                    break;
                case 3:
                    disciplinaView.cadastrarDisciplina();
                    break;
                case 4:
                    turmaView.cadastrarTurma();
                    break;
            }
            this.menu.showOptions();
            opcao = menu.getOption();
        }
    }   
}