/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.dao.SituacaoAlunoDao;
import br.ufes.ceunes.poo.model.dao.TurmaDao;
import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.pojo.SituacaoAluno;
import br.ufes.ceunes.poo.model.pojo.Turma;

/**
 *
 * @author paulo
 */

public class CadastroAdministradorView {

    private AlunoView alunoView;
    private ProfessorView professorView;
    private DisciplinaView disciplinaView;
    private TurmaView turmaView;
    private AtividadeView atividadeView;
    private SituacaoAlunoDao situacaoAlunoDao;
    private Menu menu;
    /**
     * Contrutor do cadastro de tudo feito pelo admin.
     * @param alunoView
     * @param professorView
     * @param disciplinaView
     * @param turmaView
     * @param atividadeView
     * @param situacaoAlunoDao 
     */
    public CadastroAdministradorView(AlunoView alunoView,ProfessorView professorView,DisciplinaView disciplinaView,TurmaView turmaView,AtividadeView atividadeView,SituacaoAlunoDao situacaoAlunoDao){
        this.alunoView = alunoView;
        this.professorView = professorView;
        this.disciplinaView = disciplinaView;
        this.turmaView = turmaView;
        this.atividadeView = atividadeView;
        this.situacaoAlunoDao = situacaoAlunoDao;
        this.menu = new Menu();
    }
    /**
     * Menu de cadastros do administrador.
     * Aluno, Professor, disciplina, tuma, alunos em uma turma.
     */
    public void abrir(){
        
        this.menu.setTitle("Menu Cadastros");
        this.menu.addOption("Cadastrar Aluno");
        this.menu.addOption("Cadastrar Profesor");
        this.menu.addOption("Cadastrar Disciplina");
        this.menu.addOption("Cadastrar Turma");
        this.menu.addOption("Cadastrar alunos em uma turma");
        this.menu.addOption("Voltar");
        
        this.menu.showOptions();
        int opcao = menu.getOption();
        while(opcao != menu.getSize()){
            switch(opcao){
                case 1:
                    alunoView.cadastrar();
                    break;
                case 2:
                    professorView.cadastrar();
                    break;
                case 3:
                    disciplinaView.cadastrar();
                    break;
                case 4:
                    turmaView.cadastrar();
                    break;
                case 5:
                    turmaView.cadastrarAlunos();
                    break;
            }
            this.menu.showOptions();
            opcao = menu.getOption();
        }
    }   
}