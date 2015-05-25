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
public class ListagemView {
    private AlunoView alunoView;
    private ProfessorView professorView;
    private DisciplinaView disciplinaView;
    private TurmaView turmaView;
    private AtividadeView atividadeView;
    private Menu menu;
    
    /**
     * Contrutor da Listagem, com todos os dados necessarios para listar.
     * @param alunoView dados dos alunos.
     * @param professorView dados dos professores.
     * @param disciplinaView dados das disciplinas.
     * @param turmaView dados das turmas.
     * @param atividadeView dados das atividades.
     */
    public ListagemView(AlunoView alunoView,ProfessorView professorView,DisciplinaView disciplinaView,TurmaView turmaView,AtividadeView atividadeView){
        this.alunoView = alunoView;
        this.professorView = professorView;
        this.disciplinaView = disciplinaView;
        this.turmaView = turmaView;
        this.atividadeView = atividadeView;
        this.menu = new Menu();
    
    }
    /**
     * Menu das listagens.
     * Aluno, professor, disciplinas, turmas, atividades.
     */
    public void abrir(){
        this.menu.setTitle("Menu Listagens");
        this.menu.addOption("Listar alunos");
        this.menu.addOption("Listar professores");
        this.menu.addOption("Listar disciplinas");
        this.menu.addOption("Listar turmas");
        this.menu.addOption("Listar Atividades");
        this.menu.addOption("Voltar");
        
        this.menu.showOptions();
        
        int opcao = menu.getOption();
        switch(opcao){
            case 1:
                alunoView.listar();
                break;
            case 2:
                professorView.listar();
                break;
            case 3:
                disciplinaView.Listar();
                break;
            case 4:
                turmaView.listar();
                break;
            case 5:
                atividadeView.listar();
                System.out.println("___________");
                atividadeView.listarDeTurma();
                break;
        }
    }
}
