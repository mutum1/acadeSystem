/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.dao.TurmaDao;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.pojo.Turma;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rhaister
 */
class TurmaView {
    
    TurmaDao turmaDao;
    ProfessorDao professorDao;
    DisciplinaDao disciplinaDao;
    
    public TurmaView(TurmaDao turma,ProfessorDao professor,DisciplinaDao disciplina){
        this.turmaDao = turma;
        this.professorDao = professor;
        this.disciplinaDao = disciplina;
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
    
    public void salvar(Turma turma){
        turmaDao.adicionar(turma);
        turmaDao.salvar();
    }
    
    public void listar(){
        List<Turma> listaTurma = turmaDao.getAll();
         for(Turma turma : listaTurma){
             System.out.println(turma);
             System.out.println();
        }
    
    
    }
}
