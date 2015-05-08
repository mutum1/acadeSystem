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
    public static void main(String[] args){
        
        AlunoDao alunoDao = new AlunoDaoImpl(); // Objeto Aluno Criado
        AlunoView alunoView = new AlunoView(alunoDao); // Enviado um alunoDoa para um alunoView
        
        ProfessorDao professorDao = new ProfessorDaoImpl(); // Objeto Professor Criado
        ProfessorView professorView = new ProfessorView(professorDao); // Enviado um professorDao para professorView
        
        DisciplinaDao disciplinaDao = new DisciplinaDaoImpl(); // Objeto Disciplina Criado
        DisciplinaView disciplinaView = new DisciplinaView(disciplinaDao); // Enviado uma disciplinaDao para disciplinaView
        
        TurmaDao turmaDao = new TurmaDaoImpl(); // Objeto Turma Criado
        TurmaView turmaView = new TurmaView(turmaDao); // Enviado uma turmaDao para uma turmaView
        
        alunoDao.carregar(); // Carregado lista de alunos do arquivo
        professorDao.carregar(); // Carregado lista de professores do arquivo
        disciplinaDao.carregar(); // Carregado lista de disciplinas do arquivo
        turmaDao.carregar();    // Carregado lista de turmas do arquivo
    
        Menu menuPrincipal = new Menu();
        menuPrincipal.adicionarItem("Cadastros");
        
        Menu menuCadastros = new Menu();
        menuCadastros.adicionarItem("Cadastrar Aluno");
        menuCadastros.adicionarItem("Cadastrar Profesor");
        menuCadastros.adicionarItem("Cadastrar Disciplina");
        menuCadastros.adicionarItem("Cadastrar Turma");
        menuCadastros.adicionarItem("Cadastrar Aluno");
        
        
        
        
        menuPrincipal.MostrarItens();
        int opcao = menuPrincipal.getOption();
        

        
        
        
    }
}
