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
public class CadastroProfessorView{

    private AlunoView alunoView;
    private ProfessorView professorView;
    private DisciplinaView disciplinaView;
    private TurmaView turmaView;
    private AtividadeView atividadeView;
    private Menu menu;

    public CadastroProfessorView(AlunoView alunoView,ProfessorView professorView,DisciplinaView disciplinaView,TurmaView turmaView,AtividadeView atividadeView){
        this.alunoView = alunoView;
        this.professorView = professorView;
        this.disciplinaView = disciplinaView;
        this.turmaView = turmaView;
        this.atividadeView = atividadeView;
        this.menu = new Menu();
    }
    
    public void abrir(){
        
        this.menu.setTitle("Menu Cadastros");
        this.menu.addOption("Cadastrar Atividade");
        this.menu.addOption("Voltar");
        
        this.menu.showOptions();
        int opcao = menu.getOption();
        while(opcao != menu.getSize()){
            switch(opcao){
                case 1:
                    atividadeView.cadastrar();
                    break;
            }
            this.menu.showOptions();
            opcao = menu.getOption();
        }
    }   
}
