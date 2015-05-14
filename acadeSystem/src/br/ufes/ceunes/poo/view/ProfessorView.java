/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.pojo.Professor;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rhaister
 */
class ProfessorView {
    
    ProfessorDao professorDao;
    
    public ProfessorView(ProfessorDao professor){
        this.professorDao = professor;
    }
    
    
  
    public Professor getInfo(){
        Scanner input = new Scanner(System.in);
        String nome = "";
        String cpf = "";
        String departamento = "";
        System.out.println("Digite o nome do professor");
        nome = input.nextLine();
        
        System.out.println("Digite o departamento do professor");
        departamento = input.nextLine();
        
        System.out.println("Digite o cpf do professor");
        cpf = input.nextLine();
        
        if(!Cpf.isValidCpf(cpf)){
            System.out.println("CPF inválido, digite novamente");
            cpf = input.nextLine();   
        }
        
        
        return new Professor(nome,cpf,departamento);
    }    
    
    public boolean existeProfessor(Professor professor, ProfessorDao professorDao){
        Professor professorTemp = professorDao.buscaProfessor(new Professor(null,professor.getCpf(),null));
        if(professorTemp.getNome() == null){
            return false;
        }
        return true;
    }
    
    
}
