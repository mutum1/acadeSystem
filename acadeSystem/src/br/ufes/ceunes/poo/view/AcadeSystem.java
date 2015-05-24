/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.dao.AlunoDaoImpl;
import br.ufes.ceunes.poo.model.dao.AtividadeDao;
import br.ufes.ceunes.poo.model.dao.AtividadeDaoImpl;
import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.dao.DisciplinaDaoImpl;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.dao.ProfessorDaoImpl;
import br.ufes.ceunes.poo.model.dao.SituacaoAlunoDao;
import br.ufes.ceunes.poo.model.dao.SituacaoAlunoDaoImpl;
import br.ufes.ceunes.poo.model.dao.TurmaDao;
import br.ufes.ceunes.poo.model.dao.TurmaDaoImpl;
import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.pojo.SituacaoAluno;
import br.ufes.ceunes.poo.model.pojo.Turma;
import com.sun.org.apache.bcel.internal.generic.SIPUSH;
import java.util.Scanner;

/**
 *
 * @author paulo
 */

public class AcadeSystem {
    public static final int flagCpfVerify = 0; // 1 ativa verificação de cpfSS
    
    public static void main(String[] args){
        
        //Criando e instanciando os Objetos Daos e as Views, para mandar como parametro
        AlunoDao alunoDao = new AlunoDaoImpl(); // Objeto Aluno Criado
        ProfessorDao professorDao = new ProfessorDaoImpl(); // Objeto Professor Criado
        DisciplinaDao disciplinaDao = new DisciplinaDaoImpl(professorDao); // Objeto Disciplina Criado
        TurmaDao turmaDao = new TurmaDaoImpl(professorDao, disciplinaDao, alunoDao); // Objeto Turma Criado
        AtividadeDao atividadeDao = new AtividadeDaoImpl(turmaDao);
        SituacaoAlunoDao situacaoAlunoDao = new SituacaoAlunoDaoImpl(alunoDao, atividadeDao, turmaDao);
        
        AlunoView alunoView = new AlunoView(alunoDao); // Enviado um alunoDoa para um alunoView
        ProfessorView professorView = new ProfessorView(professorDao); // Enviado um professorDao para professorView
        DisciplinaView disciplinaView = new DisciplinaView(disciplinaDao); // Enviado uma disciplinaDao para disciplinaView
        TurmaView turmaView = new TurmaView(turmaDao, alunoDao, professorDao, disciplinaDao, situacaoAlunoDao);// Enviado uma turmaDao para uma turmaView
        AtividadeView atividadeView = new AtividadeView(atividadeDao, turmaDao);
  
        Menu menuPrincipal = new Menu();
        menuPrincipal.setTitle("ACADEsYSTEM\n\nVocê é uma administrador ou um professor?");
        menuPrincipal.addOption("Professor");
        menuPrincipal.addOption("Administrador");
        menuPrincipal.addOption("Fechar");
        
        
        MenuAdministradorView menuAdministrador = new MenuAdministradorView(alunoView, professorView, disciplinaView, turmaView, atividadeView);     
        MenuProfessorView menuProfessor = new MenuProfessorView(alunoView, professorView, disciplinaView, turmaView, atividadeView);     
        
        
        menuPrincipal.showOptions();
        int opcao = menuPrincipal.getOption();
        while(opcao != menuPrincipal.getSize()){
            switch(opcao){
                case 1:
                    menuProfessor.open();
                    return;
                case 2:
                    
                    System.out.println("Digite a senha");
                    String senha = "admin";
                    if(senha.equals(( new Scanner(System.in)).nextLine())){
                        menuAdministrador.open();
                    }
                    break;                    
            }
            menuPrincipal.showOptions();
            opcao = menuPrincipal.getOption();
        }
        
    }
}
