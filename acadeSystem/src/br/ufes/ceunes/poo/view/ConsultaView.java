/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.view;

import java.util.Scanner;

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
        
        this.menu.addOption("Consultar Aluno"); //1
        this.menu.addOption("Consultar Profesor"); //2
        this.menu.addOption("Consultar Disciplina"); //3
        this.menu.addOption("Consultar Turma"); //4
        this.menu.addOption("Consultar Situação de um aluno"); //6
        this.menu.addOption("Consultar número de turmas de uma disicplina");//7
        this.menu.addOption("Consultar número de disciplinas já lecionadas de um professor"); //8
        this.menu.addOption("Voltar"); 
        
        this.menu.showOptions();
        int opcao = menu.getOption();
        String temp;
        
        while(opcao != menu.getSize()){
            switch(opcao){
                case 1:
                    System.out.println("Digite o nome para a consulta");
                    temp = (new Scanner(System.in)).nextLine();
                    alunoView.consultarPorNome(temp);
                    break;
                case 2:
                    System.out.println("Digite o nome para a consulta");
                    temp = (new Scanner(System.in)).nextLine();
                    professorView.consultarPorNome(temp);
                    break;
                case 3:
                   // disciplinaView.consultar();
                    break;
                case 4:
                    turmaView.consultar();
                    break;
                case 5:
                    turmaView.consultarUmAluno();
                    break;
                case 6:
                    turmaView.consultarUmaDisciplina();
                    break;
                case 7:
                    turmaView.consultarPorProfessor();
                    break;
                    
                    
            }
            this.menu.showOptions();
            opcao = menu.getOption();
        }
    }   
}
