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
    public static final int flagCpfVerify = 0; // 1 ativa verificação de cpfSS
    
    public static void main(String[] args){
        
        //Criando e instanciando os Objetos Daos e as Views, para mandar como parametro
        AlunoDao alunoDao = new AlunoDaoImpl(); // Objeto Aluno Criado
        AlunoView alunoView = new AlunoView(alunoDao); // Enviado um alunoDoa para um alunoView

        ProfessorDao professorDao = new ProfessorDaoImpl(); // Objeto Professor Criado
        ProfessorView professorView = new ProfessorView(professorDao); // Enviado um professorDao para professorView

        DisciplinaDao disciplinaDao = new DisciplinaDaoImpl(professorDao); // Objeto Disciplina Criado
        DisciplinaView disciplinaView = new DisciplinaView(disciplinaDao); // Enviado uma disciplinaDao para disciplinaView

        TurmaDao turmaDao = new TurmaDaoImpl(professorDao, disciplinaDao, alunoDao, null); // Objeto Turma Criado
        TurmaView turmaView = new TurmaView(turmaDao,professorDao,disciplinaDao); // Enviado uma turmaDao para uma turmaView

        //AtividadeDao atividadeDao = new AtividadeDaoImpl();
        //AtividadeView atividadeView = new AtividadeView();
        
        Menu menuPrincipal = new Menu();        
        int opcao = 0;
        
       // Carregado lista de turmas do arquivo
        
        menuPrincipal.setTitle("ACADEsYSTEM - Menu principal");
        menuPrincipal.addOption("Cadastros");//adiciona opçoes no menu
        menuPrincipal.addOption("Listagens");
        //colocar aqui outras opcoes
        menuPrincipal.addOption("Sair");  
        
        menuPrincipal.showOptions();
        
        opcao = menuPrincipal.getOption();//retorna a opçao digitada pelo usuario
        while(opcao != menuPrincipal.getSize()){
          
            switch(opcao){
                case 1:
                    (new CadastroView(alunoView,professorView,disciplinaView,turmaView)).abrir();
                    break;  
                case 2:
                    (new ListagemView(alunoView,professorView,disciplinaView,turmaView)).abrir();
                    break;
            }
            menuPrincipal.showOptions();
            opcao = menuPrincipal.getOption();//retorna a opçao digitada pelo usuario
            
        }
        
    }
}
