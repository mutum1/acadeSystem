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
public class MenuAdministradorView {
    private AlunoView alunoView;
    private ProfessorView professorView;
    private DisciplinaView disciplinaView;
    private TurmaView turmaView;
    private AtividadeView atividadeView;
    private Menu menu;
    
    
    public MenuAdministradorView(AlunoView alunoView,ProfessorView professorView,DisciplinaView disciplinaView,TurmaView turmaView,AtividadeView atividadeView){
        this.alunoView = alunoView;
        this.professorView = professorView;
        this.disciplinaView = disciplinaView;
        this.turmaView = turmaView;
        this.atividadeView = atividadeView;
        this.menu = new Menu();
    }
    public void open(){
        menu.setTitle("ACADEsYSTEM - Menu principal");
        menu.addOption("Cadastros");//adiciona opçoes no menu
        menu.addOption("Listagens");
        //colocar aqui outras opcoes
        menu.addOption("Sair");  
        
        menu.showOptions();
        int opcao = menu.getOption();//retorna a opçao digitada pelo usuario
        while(opcao != menu.getSize()){
          
            switch(opcao){
                case 1:
                    (new CadastroAdministradorView(alunoView,professorView,disciplinaView,turmaView,atividadeView)).abrir();
                    break;  
                case 2:
                    (new ListagemView(alunoView,professorView,disciplinaView,turmaView,atividadeView)).abrir();
                    break;
            }
            menu.showOptions();
            opcao = menu.getOption();//retorna a opçao digitada pelo usuario
            
        }
    }
}
