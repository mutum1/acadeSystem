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
public class MenuProfessorView {
    private AlunoView alunoView;
    private ProfessorView professorView;
    private DisciplinaView disciplinaView;
    private TurmaView turmaView;
    private AtividadeView atividadeView;
    private SituacaoAlunoDao situacaoAlunoDao;
    private Menu menu;
    
    
    public MenuProfessorView(AlunoView alunoView,ProfessorView professorView,DisciplinaView disciplinaView,TurmaView turmaView,AtividadeView atividadeView,SituacaoAlunoDao situacaoAlunoDao){
        this.alunoView = alunoView;
        this.professorView = professorView;
        this.disciplinaView = disciplinaView;
        this.turmaView = turmaView;
        this.atividadeView = atividadeView;
        this.situacaoAlunoDao = situacaoAlunoDao;
        this.menu = new Menu();
    }
    public void open(){
        menu.setTitle("ACADEsYSTEM - Menu principal (PROF)");
        menu.addOption("Cadastros");//adiciona opçoes no menu
        menu.addOption("Listagens");
        menu.addOption("Consultas");
        menu.addOption("Lançar notas");
        menu.addOption("Lançar Faltas");
        //colocar aqui outras opcoes
        menu.addOption("Sair");  
        
        menu.showOptions();
        int opcao = menu.getOption();//retorna a opçao digitada pelo usuario
        while(opcao != menu.getSize()){
          
            switch(opcao){
                case 1:
                    (new CadastroProfessorView(alunoView,professorView,disciplinaView,turmaView,atividadeView,situacaoAlunoDao)).abrir();
                    break;  
                case 2:
                    (new ListagemView(alunoView,professorView,disciplinaView,turmaView,atividadeView)).abrir();
                    break;
                case 3:
                    (new ConsultaView(alunoView,professorView,disciplinaView,turmaView,atividadeView)).abrir();
                    break;
                case 4:
                    turmaView.lancarNotas();
                    situacaoAlunoDao.salvar();
                    break;
                case 5:
                    turmaView.lancarFaltas();
                    situacaoAlunoDao.salvar();
                    break;
            }
            menu.showOptions();
            opcao = menu.getOption();//retorna a opçao digitada pelo usuario
            
        }
    }
}
