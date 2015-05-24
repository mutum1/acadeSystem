/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.dao.SituacaoAlunoDao;
import br.ufes.ceunes.poo.model.dao.TurmaDao;
import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.pojo.Turma;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rhaister
 */
public class TurmaView {
    
    TurmaDao turmaDao;
    ProfessorDao professorDao;
    DisciplinaDao disciplinaDao;
    AlunoDao alunoDao;
    
    public TurmaView(TurmaDao turma,AlunoDao alunoDao,ProfessorDao professor,DisciplinaDao disciplina){
        this.turmaDao = turma;
        this.alunoDao = alunoDao;
        this.professorDao = professor;
        this.disciplinaDao = disciplina;
    }
    
    /**
     * Método responsavel por cadastrar uma turma em uma lista
     * sem duplicatas.
     * @param turmaDao
     * @param disciplinaDao
     * @param professorDao 
     */
    public void cadastrar(){    
        Turma turma = getInfo();
        if(localDisponivel(turma)){
            turmaDao.salvar(turma);
        }
    } 
    
    
    
    public Turma getInfo(){
        
        Scanner input = new Scanner(System.in);
        String ano;
        String periodo;
        String local;
        String horario;
        String numeroVagas;
        String cpfProfessor;
        String codigoDisciplina;
        
        System.out.println("Digite o ano da turma");
        ano = input.nextLine();
        
        System.out.println("Digite o periodo da turma");
        periodo = input.nextLine();
        
        System.out.println("Digite o local"); 
        local = input.nextLine();
        
        System.out.println("Digite o horário");
        horario = input.nextLine();
      
        System.out.println("Digite o número de vagas");
        numeroVagas = input.nextLine();
        
        System.out.println("Digite o CPF do professor (Somente numeros)");
        cpfProfessor = input.nextLine();
        Professor professor = new Professor(null,cpfProfessor,null,0);
        professor = professorDao.buscarPorCpf(professor);
        System.out.println(professor);
        
        System.out.println("Digite o codigo da disciplina");
        codigoDisciplina = input.nextLine();
        Disciplina disciplina = new Disciplina(null,null,null,Integer.parseInt(codigoDisciplina));
        disciplina = disciplinaDao.buscar(disciplina);
        System.out.println(disciplina);
        
        return new Turma(ano,periodo,local,horario,Integer.parseInt(numeroVagas),professor,disciplina,turmaDao.gerarProximoId());
    }    
    
    public boolean localDisponivel(Turma turma){
        Turma turmaTemp = new Turma(null,null,turma.getLocal(),turma.getHorario(),0,null,null,0);
        turmaTemp = turmaDao.disponibilidadeLocal(turmaTemp);
        if(turmaTemp.getAno() == null){
            return true;
        }

        return false;
    }

    public void listar(){
        List<Turma> listaTurma = turmaDao.getAll();
         for(Turma turma : listaTurma){
             System.out.println(turma);
             System.out.println();
        }
    }
    
    
    public void cadastrarAlunos(Turma turma){
        Scanner input = new Scanner(System.in);
        String cpf;
        Aluno aluno;
        System.out.println("Cadastros de alunos na turma "+
                            turma.getDisciplina().getNome()+
                            " "+turma.getAno()+"/"+turma.getPeriodo());
        System.out.println("Digite o cpf do aluno,(Digite '0' para sair)");
        cpf = input.nextLine();
        aluno = alunoDao.buscarPorCpf(new Aluno(null, cpf, 0));
        if(aluno.getNome() == null) System.out.println("Não existe aluno");
        while(!cpf.equals("0") && aluno.getNome() != null){
            turma.addAluno(aluno,SituacaoAlunoDao.gerarProximoId());
            
        System.out.println("Digite o cpf do aluno,(Digite '0' para sair)");
        cpf = input.nextLine();
        aluno = alunoDao.buscarPorCpf(new Aluno(null, cpf, 0));
                
        }
    
    }
    
    
}
