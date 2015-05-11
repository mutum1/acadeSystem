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
import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.pojo.Turma;

/**
 *
 * @author paulo
 */
public class AcadeSystem {
    //Criando e instanciando os Objetos Daos e as Views, para mandar como parametro
    private static AlunoDao alunoDao = new AlunoDaoImpl(); // Objeto Aluno Criado
    private static AlunoView alunoView = new AlunoView(); // Enviado um alunoDoa para um alunoView
        
    private static ProfessorDao professorDao = new ProfessorDaoImpl(); // Objeto Professor Criado
    private static ProfessorView professorView = new ProfessorView(); // Enviado um professorDao para professorView
        
    private static DisciplinaDao disciplinaDao = new DisciplinaDaoImpl(); // Objeto Disciplina Criado
    private static DisciplinaView disciplinaView = new DisciplinaView(); // Enviado uma disciplinaDao para disciplinaView
        
    private static TurmaDao turmaDao = new TurmaDaoImpl(); // Objeto Turma Criado
    private static TurmaView turmaView = new TurmaView(); // Enviado uma turmaDao para uma turmaView
       
    private static Menu menuPrincipal = new Menu();
    private static Menu menuCadastros = new Menu();
    static int flagCpfVerify = 0; // 1 ativa verificação de cpfSS
    
    public static void main(String[] args){
        int opcao = 0;
        alunoDao.carregar(); // Carregado lista de alunos do arquivo
        professorDao.carregar(); // Carregado lista de professores do arquivo
        disciplinaDao.carregar(); // Carregado lista de disciplinas do arquivo
        turmaDao.carregar();    // Carregado lista de turmas do arquivo
    
        menuPrincipal.setTitle("ACADEsYSTEM - Menu principal");
        menuPrincipal.addOption("Cadastros");//adiciona opçoes no menu
        //outras opcoes
        menuPrincipal.addOption("Sair");
        
        menuCadastros.setTitle("Menu Cadastros");
        menuCadastros.addOption("Cadastrar Aluno");
        menuCadastros.addOption("Cadastrar Profesor");
        menuCadastros.addOption("Cadastrar Disciplina");
        menuCadastros.addOption("Cadastrar Turma");
        menuCadastros.addOption("Cadastrar Aluno");
        menuCadastros.addOption("Voltar");
        
        
        menuPrincipal.showOptions();
        opcao = menuPrincipal.getOption();//retorna a opçao digitada pelo usuario
        while(opcao != menuPrincipal.getSize()){
          
            switch(opcao){
                case 1: 
                    menuCadastros.showOptions();
                    cadastrar(alunoDao,professorDao,disciplinaDao,turmaDao);
                    break;  
                case 2:
                    //opcao 2 do menu principal
                    break;
            }
            menuPrincipal.showOptions();
            opcao = menuPrincipal.getOption();//retorna a opçao digitada pelo usuario
            
        }
        
    }
    // Menu para cadastras TODO MUNDO.
    public static void cadastrar(AlunoDao alunoDao,ProfessorDao professorDao,DisciplinaDao disciplinaDao,TurmaDao turmaDao){
        int opcao = menuCadastros.getOption();
        /*
            Todos os casos pegam todas as informações digitadas pelo usuario e
            verificam se ela existe e esta correta, depois adiciona na lista o
            respectivo cadastro e no final salva no arquivo.
        */
        switch(opcao){
            case 1:
                Aluno aluno = alunoView.getInfo();
                if(!alunoView.existeAluno(aluno, alunoDao)){
                    alunoDao.adicionar(aluno);
                    alunoDao.salvar();
                }
                break;
            case 2:
                Professor professor = professorView.getInfo();
                if(!professorView.existeProfessor(professor, professorDao)){
                    professorDao.adicionar(professor);
                    professorDao.salvar();
                }
                break;
            case 3:
                Disciplina disciplina = disciplinaView.getInfo();
                if(!disciplinaView.existeDisciplina(disciplina, disciplinaDao)){
                    disciplinaDao.adicionar(disciplina);
                    disciplinaDao.salvar();
                }
                break;
            case 4:
                Turma turma = turmaView.getInfo(disciplinaDao,professorDao);
                if(!turmaView.existeTurma(turma, turmaDao)){
                    turmaDao.adicionar(turma);
                    turmaDao.salvar();                    
                }
                break;
        }
    }
}
