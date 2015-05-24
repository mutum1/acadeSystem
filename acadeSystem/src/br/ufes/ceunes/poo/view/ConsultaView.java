/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.view;

/**
 *
 * @author paulo
 */
public class ConsultaView {
    private AlunoView alunoView;
    private ProfessorView professorView;
    private DisciplinaView disciplinaView;
    private TurmaView turmaView;
    private AtividadeView atividadeView;
    private Menu menu;

    public ConsultaView(AlunoView alunoView,ProfessorView professorView,DisciplinaView disciplinaView,TurmaView turmaView,AtividadeView atividadeView){
        this.alunoView = alunoView;
        this.professorView = professorView;
        this.disciplinaView = disciplinaView;
        this.turmaView = turmaView;
        this.atividadeView = atividadeView;
        this.menu = new Menu();
    }
    
    public void abrir(){
        
        this.menu.setTitle("Menu Cadastros");
        this.menu.addOption("Cadastrar Aluno");
        this.menu.addOption("Cadastrar Profesor");
        this.menu.addOption("Cadastrar Disciplina");
        this.menu.addOption("Cadastrar Turma");
        this.menu.addOption("Cadastrar Atividade");
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
                    atividadeView.cadastrar();
                    break;
                    
            }
            this.menu.showOptions();
            opcao = menu.getOption();
        }
    }   
}
