/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.dao.AlunoDaoImpl;
import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.dao.DisciplinaDaoImpl;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.dao.ProfessorDaoImpl;
import br.ufes.ceunes.poo.model.dao.TurmaDao;
import br.ufes.ceunes.poo.model.dao.TurmaDaoImpl;

/**
 *
 * @author paulo
 */
public class AcadeSystem {
    
    private static AlunoDao alunoDao = new AlunoDaoImpl(); // Objeto Aluno Criado
    private static AlunoView alunoView = new AlunoView(alunoDao); // Enviado um alunoDoa para um alunoView
        
    private static ProfessorDao professorDao = new ProfessorDaoImpl(); // Objeto Professor Criado
    private static ProfessorView professorView = new ProfessorView(professorDao); // Enviado um professorDao para professorView
        
    private static DisciplinaDao disciplinaDao = new DisciplinaDaoImpl(); // Objeto Disciplina Criado
    private static DisciplinaView disciplinaView = new DisciplinaView(disciplinaDao); // Enviado uma disciplinaDao para disciplinaView
        
    private static TurmaDao turmaDao = new TurmaDaoImpl(); // Objeto Turma Criado
    private static TurmaView turmaView = new TurmaView(turmaDao); // Enviado uma turmaDao para uma turmaView
       
    private static Menu menuPrincipal = new Menu();
    private static Menu menuCadastros = new Menu();
    
    public static void main(String[] args){
        
        alunoDao.carregar(); // Carregado lista de alunos do arquivo
        professorDao.carregar(); // Carregado lista de professores do arquivo
        disciplinaDao.carregar(); // Carregado lista de disciplinas do arquivo
        turmaDao.carregar();    // Carregado lista de turmas do arquivo
    
        menuPrincipal.addOption("Cadastros");
        
        menuCadastros.addOption("Cadastrar Aluno");
        menuCadastros.addOption("Cadastrar Profesor");
        menuCadastros.addOption("Cadastrar Disciplina");
        menuCadastros.addOption("Cadastrar Turma");
        menuCadastros.addOption("Cadastrar Aluno");
        
        
        menuPrincipal.showOptions();
        int opcao = menuPrincipal.getOption();
        switch(opcao){
            case 1: cadastrar();
            break;  
    
        }
        
        return;
        
    }
    
    public static void cadastrar(){
        menuCadastros.showOptions();
        int opcao = menuCadastros.getOption();
        
        switch(opcao){
            case 1:
                //cadastra aluno
                break;
            case 2:
                //cadastro professor
                break;
            case 3:
                //cadastro disciplina
                break;
            case 4:
                //cadastro turma
                break;
        }
    }
}
