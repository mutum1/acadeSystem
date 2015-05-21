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
    
    
    public static void main(String[] args){
        
        //Criando e instanciando os Objetos Daos e as Views, para mandar como parametro
        AlunoDao alunoDao = new AlunoDaoImpl(); // Objeto Aluno Criado
        AlunoView alunoView = new AlunoView(alunoDao); // Enviado um alunoDoa para um alunoView

        ProfessorDao professorDao = new ProfessorDaoImpl(); // Objeto Professor Criado
        ProfessorView professorView = new ProfessorView(professorDao); // Enviado um professorDao para professorView

        DisciplinaDao disciplinaDao = new DisciplinaDaoImpl(professorDao); // Objeto Disciplina Criado
        DisciplinaView disciplinaView = new DisciplinaView(disciplinaDao); // Enviado uma disciplinaDao para disciplinaView

        TurmaDao turmaDao = new TurmaDaoImpl(); // Objeto Turma Criado
        TurmaView turmaView = new TurmaView(turmaDao); // Enviado uma turmaDao para uma turmaView

        //AtividadeDao atividadeDao = new AtividadeDaoImpl();
        //AtividadeView atividadeView = new AtividadeView();
        
        Menu menuPrincipal = new Menu();
        Menu menuCadastros = new Menu();
        Menu menuListagens = new Menu();
        int flagCpfVerify = 0; // 1 ativa verificação de cpfSS
        int opcao = 0;
        
        
        alunoDao.carregar(); // Carregado lista de alunos do arquivo
        professorDao.carregar(); // Carregado lista de professores do arquivo
        disciplinaDao.carregar(); // Carregado lista de disciplinas do arquivo
        turmaDao.carregar();    // Carregado lista de turmas do arquivo
    
        menuPrincipal.setTitle("ACADEsYSTEM - Menu principal");
        menuPrincipal.addOption("Cadastros");//adiciona opçoes no menu
        menuPrincipal.addOption("Listagens");
        //outras opcoes
        menuPrincipal.addOption("Sair");
        
        menuCadastros.setTitle("Menu Cadastros");
        menuCadastros.addOption("Cadastrar Aluno");
        menuCadastros.addOption("Cadastrar Profesor");
        menuCadastros.addOption("Cadastrar Disciplina");
        menuCadastros.addOption("Cadastrar Turma");
        menuCadastros.addOption("Cadastrar Aluno");
        menuCadastros.addOption("Voltar");
        
        menuListagens.setTitle("Menu Listagens");
        menuListagens.addOption("Listar alunos");
        menuListagens.addOption("Listar professores");
        menuListagens.addOption("Listar disciplinas");
        menuListagens.addOption("Listar turmas");
        menuListagens.addOption("Voltar");
        
        
        menuPrincipal.showOptions();
        opcao = menuPrincipal.getOption();//retorna a opçao digitada pelo usuario
        while(opcao != menuPrincipal.getSize()){
          
            switch(opcao){
                case 1:
                    cadastrar(alunoView,professorView,disciplinaView,turmaView,menuCadastros);
                    break;  
                case 2:
                    
                    listagens(alunoView,professorView,disciplinaView,turmaView,menuListagens);
                    break;
            }
            menuPrincipal.showOptions();
            opcao = menuPrincipal.getOption();//retorna a opçao digitada pelo usuario
            
        }
        
    }

    
    public static void cadastrar(AlunoView alunoView,ProfessorView professorView,DisciplinaView disciplinaView,TurmaView turmaView,Menu menuCadastros){
        menuCadastros.showOptions();
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
    
    public static void listagens(AlunoView alunoView,ProfessorView professorView,DisciplinaView disciplinaView,TurmaView turmaView,Menu menuListagens){
        menuListagens.showOptions();
        int opcao = menuListagens.getOption();
        switch(opcao){
            case 1:
                alunoView.listarAlunos();
                break;
            case 2:
                //professorView.listarProfessores(professorDao)
                break;
            case 3:
               
                break;
            case 4:
                
                break;
        }
        
    }
}
