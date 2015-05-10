/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rhaister
 */
class DisciplinaView {
    
    
    
    
  
    public Disciplina getInfo(){
        Scanner input = new Scanner(System.in);
        String nome = "";
        String codigo = "";
        String ementa = "";
        System.out.println("Digite o nome do disciplina");
        nome = input.nextLine();
        
        System.out.println("Digite o departamento do disciplina");
        departamento = input.nextLine();
        
        System.out.println("Digite o cpf do disciplina");
        cpf = input.nextLine();
        
        if(!Cpf.isValidCpf(cpf) && AcadeSystem.flagCpfVerify ==1){
            System.out.println("CPF inválido, digite novamente");
            cpf = input.nextLine();   
        }
        
        
        return new Disciplina(nome,cpf,departamento);
    }    
    
    public boolean existeDisciplina(Disciplina disciplina, DisciplinaDao disciplinaDao){
        Disciplina disciplinaTemp = disciplinaDao.buscaDisciplina(new Disciplina(null,disciplina.getCpf(),null));
        if(disciplinaTemp.getNome() == null){
            return false;
        }
        return true;
    }
    
    
}
