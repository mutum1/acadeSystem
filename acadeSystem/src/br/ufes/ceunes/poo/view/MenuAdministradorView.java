/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.SituacaoAlunoDao;

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
    private SituacaoAlunoDao situacaoAlunoDao;
    private Menu menu;
    
    /**
     * Contrutor do Menu do administrador, com os dados para serem utilizados.
     * @param alunoView dados dos alunos.
     * @param professorView dados dos professores.
     * @param disciplinaView dados das disciplinas.
     * @param turmaView dados das turmas.
     * @param situacaoAlunoDao dados da situação dos alunos.
     * @param atividadeView dados das atividades.
     */
    public MenuAdministradorView(AlunoView alunoView,ProfessorView professorView,DisciplinaView disciplinaView,TurmaView turmaView,AtividadeView atividadeView,SituacaoAlunoDao situacaoAlunoDao){
        this.alunoView = alunoView;
        this.professorView = professorView;
        this.disciplinaView = disciplinaView;
        this.turmaView = turmaView;
        this.situacaoAlunoDao = situacaoAlunoDao;
        this.atividadeView = atividadeView;
        this.menu = new Menu();
    }
    /**
     * Menu da administração.
     * Cadastros, Listagens e Consultas.
     */
    public void open(){
        menu.setTitle("ACADEsYSTEM - Menu principal (ADM)");
        menu.addOption("Cadastros");//adiciona opçoes no menu
        menu.addOption("Listagens");
        menu.addOption("Consultas");
        //colocar aqui outras opcoes
        menu.addOption("Sair");  
        
        menu.showOptions();
        int opcao = menu.getOption();//retorna a opçao digitada pelo usuario
        while(opcao != menu.getSize()){
          
            switch(opcao){
                case 1:
                    (new CadastroAdministradorView(alunoView,professorView,disciplinaView,turmaView,atividadeView,situacaoAlunoDao)).abrir();
                    break;  
                case 2:
                    (new ListagemView(alunoView,professorView,disciplinaView,turmaView,atividadeView)).abrir();
                    break;
                case 3:
                    (new ConsultaView(alunoView,professorView,disciplinaView,turmaView,atividadeView)).abrir();
                    break;
                    
            }
            menu.showOptions();
            opcao = menu.getOption();//retorna a opçao digitada pelo usuario
            
        }
    }
}
