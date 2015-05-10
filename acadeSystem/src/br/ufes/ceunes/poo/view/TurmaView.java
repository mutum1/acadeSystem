/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.dao.TurmaDao;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.pojo.Turma;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rhaister
 */
class TurmaView {
    
    public Turma getInfo(DisciplinaDao disciplinaDao, ProfessorDao professorDao){
        
        Scanner input = new Scanner(System.in);
        String ano = "";
        String periodo = "";
        String local = "";
        String horario="";
        int numeroVagas = 0;
        String cpfProfessor = "";
        String codigoDisciplina = "";
        
        System.out.println("Digite o ano da turma");
        ano = input.nextLine();
        
        System.out.println("Digite o periodo da turma");
        periodo = input.nextLine();
        
        System.out.println("Digite a ementa");
        local = input.nextLine();
        
        System.out.println("Digite a caraca horaria");
        horario = input.nextLine();
      
        System.out.println("Digite o número de vagas");
        numeroVagas = input.nextInt();
        
        System.out.println("Digite o CPF do professor (Somente numeros)");
        cpfProfessor = input.nextLine();
        Professor professor = new Professor(null,cpfProfessor,null);
        
        professor = professorDao.buscaProfessor(professor);
        
        System.out.println("Digite o codigo da disciplina");
        codigoDisciplina = input.nextLine();
        
        
        
        return new Turma(ano,periodo,local,horario,numeroVagas,professor,codigoDisciplina);
    }    
    
    public boolean existeTurma(Turma turma, TurmaDao turmaDao){
        Turma turmaTemp = turmaDao.buscaTurma(new Turma(null,null,null,turma.getCodigo()));
        if(turmaTemp.getLocal() == null){
            return false;
        }
        else if (turmaTemp.getHorario() == null){
            return false;
        }
        return true;
    }
}
