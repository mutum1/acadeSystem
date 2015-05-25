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
import br.ufes.ceunes.poo.model.pojo.SituacaoAluno;
import br.ufes.ceunes.poo.model.pojo.Turma;
import java.util.ArrayList;
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
    SituacaoAlunoDao situacaoAlunoDao;
    
    
    public TurmaView(TurmaDao turma,AlunoDao alunoDao,ProfessorDao professor,DisciplinaDao disciplina,SituacaoAlunoDao situacaoAlunoDao){
        this.turmaDao = turma;
        this.alunoDao = alunoDao;
        this.professorDao = professor;
        this.disciplinaDao = disciplina;
        this.situacaoAlunoDao = situacaoAlunoDao;
    }
    
    /**
     * Método responsavel por cadastrar uma turma em uma lista
     * sem duplicatas.
     */
    public void cadastrar(){    
        Turma turma = getInfo();
        if(localDisponivel(turma)){
            turmaDao.salvar(turma);
        }
    } 
    
    /**
     * 
     * @return 
     */
    
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
        SituacaoAluno situacaoAluno;
        System.out.println("Cadastros de alunos na turma "+
                            turma.getDisciplina().getNome()+
                            " "+turma.getAno()+"/"+turma.getPeriodo());
        System.out.println("Digite o cpf do aluno,(Digite '0' para sair)");
        cpf = input.nextLine();
        aluno = alunoDao.buscarPorCpf(new Aluno(null, cpf, 0));
        if(aluno.getNome() == null) System.out.println("Não existe aluno");
        
        
        while(!cpf.equals("0") && aluno.getNome() != null){
            situacaoAluno = new SituacaoAluno(aluno, turma, situacaoAlunoDao.gerarProximoId());
            turma.addAluno(situacaoAluno);
            situacaoAlunoDao.salvar(situacaoAluno);
            System.out.println("Digite o cpf do aluno,(Digite '0' para sair)");
            cpf = input.nextLine();
            aluno = alunoDao.buscarPorCpf(new Aluno(null, cpf, 0));
        }
    
    }
    
    public void cadastrarAlunos(){
        Scanner input = new Scanner(System.in);
        String id;
        Turma turma;
        System.out.println("Cadastros de alunos na turma");
        System.out.println("Digite o ID da turma");
        id = input.nextLine();
        turma = turmaDao.buscar(new Turma(null, null, null, null, 0, null, null,Integer.parseInt(id)));
        
        if(turma.getHorario() != null)cadastrarAlunos(turma);
        
    }
    
    
    public void consultar(){
        Scanner input = new Scanner(System.in);
        String codigo;
        String ano;
        String periodo;
        Disciplina disciplina;
        Turma turma;
        List<Turma> listaTurmas;
        float nota;
        int faltas;
        SituacaoAluno situacaoAluno;
        
        System.out.println("Digite o codigo da disciplina");
        codigo = input.nextLine();
        disciplina = new Disciplina(null, null, null, Integer.parseInt(codigo));
        disciplina = disciplinaDao.buscar(disciplina);
        
        System.out.println("Digite o ano");
        ano = input.nextLine();
        System.out.println("Digite o periodo");
        periodo = input.nextLine();
        
        turma = new Turma(ano, periodo, null, null, 0, null, disciplinaDao.buscar(disciplina), 0);
        listaTurmas = turmaDao.buscarPorDisciplina(turma);
        
         for(Turma turmaTemp : listaTurmas){
             System.out.println(turmaTemp);

             for(Aluno alunoTemp : turmaTemp.getListaAlunos()){
                 situacaoAluno = alunoTemp.getSituacaoAluno(turmaTemp);
                 System.out.println(situacaoAluno);
                 
             }
        }
    }
    
    
    public void consultarUmAluno(){
        Scanner input = new Scanner(System.in);
        String codigo;
        String ano;
        String periodo;
        Disciplina disciplina;
        Turma turma;
        List<Turma> listaTurmas;
        float nota;
        int faltas;
        SituacaoAluno situacaoAluno;
        
        System.out.println("Digite o codigo da disciplina");
        codigo = input.nextLine();
        disciplina = new Disciplina(null, null, null, Integer.parseInt(codigo));
        disciplina = disciplinaDao.buscar(disciplina);
        
        System.out.println("Digite o ano");
        ano = input.nextLine();
        System.out.println("Digite o periodo");
        periodo = input.nextLine();
        
        turma = new Turma(ano, periodo, null, null, 0, null, disciplinaDao.buscar(disciplina), 0);
        listaTurmas = turmaDao.buscarPorDisciplina(turma);
        
        System.out.println("Digite o cpf do aluno");
        String cpf = input.nextLine();
        Aluno aluno = alunoDao.buscarPorCpf(new Aluno(null,cpf,0));
        System.out.println(aluno);
       
        
        for(Turma turmaTemp : listaTurmas){
            for(Aluno alunoTemp: turmaTemp.getListaAlunos()){
                if(aluno.equals(alunoTemp)){
                    situacaoAluno = aluno.getSituacaoAluno(turmaTemp);
                    System.out.println(situacaoAluno+" "+situacaoAluno.status());
                    return;
                }
            }        
        }
        
    
        System.out.println("Aluno não cadastrado na turma");
    }
    
    
    public void consultarUmaDisciplina(){
        Scanner input = new Scanner(System.in);
        String codigo;
        Disciplina disciplina;
        System.out.println("Digite o código da disciplina");
        codigo = input.nextLine();
        disciplina = disciplinaDao.buscar(new Disciplina(null, null, null, Integer.parseInt(codigo)));
        if(disciplina.getNome() == null){
            System.out.println("Disciplina não encontrada");
            return;
        }
        Turma turma = new Turma(null, null, null, null, 0, null, disciplina, 0);
        List <Turma> listaTurmas = turmaDao.buscarPorDisciplina(turma);
        for(Turma turmaTemp: listaTurmas){
            System.out.println(turmaTemp);
            System.out.println();
        }
        System.out.println("A quantidade de turmas é "+listaTurmas.size());
        
    
    }
    
    public void consultarPorProfessor(){
        Scanner input = new Scanner(System.in);
        String cpf;
        Professor professor;
        List<Disciplina> listaDisciplinas;
        listaDisciplinas = new ArrayList<>();
        
        
        
        System.out.println("Digite o cpf do professor");
        cpf = input.nextLine();
        professor = professorDao.buscarPorCpf(new Professor(null, cpf, null, 0));
        List<Turma> listaTurmas = turmaDao.getAll();
        for(Turma turma : listaTurmas){
            if(turma.getProfessor().equals(professor) && !listaDisciplinas.contains(turma.getDisciplina())){
                listaDisciplinas.add(turma.getDisciplina());
            }
        }
        
        for(Disciplina disciplinaTemp: listaDisciplinas){
            System.out.println(disciplinaTemp);
            System.out.println("");
        }
        
        System.out.println("A quantidade de disicplinas é "+listaDisciplinas.size());

    }
    
    
}
