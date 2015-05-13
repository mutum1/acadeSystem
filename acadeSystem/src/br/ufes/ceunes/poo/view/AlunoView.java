/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.pojo.Aluno;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rhaister
 */
class AlunoView {
    
    AlunoDao alunoDao;
    
    public AlunoView(AlunoDao aluno){
        this.alunoDao = aluno;
    }
    
  
    public Aluno getInfo(){
        Scanner input = new Scanner(System.in);
        String nome = "";
        String cpf = "";
        System.out.println("Digite o nome do aluno");
        nome = input.nextLine();
        
        System.out.println("Digite o cpf do aluno");
        cpf = input.nextLine();
        if(!Cpf.isValidCpf(cpf) && AcadeSystem.flagCpfVerify ==1){
            System.out.println("CPF inválido, digite novamente");
            cpf = input.nextLine();   
        }
        return new Aluno(nome,cpf);
    }    
    
    public boolean existeAluno(Aluno aluno, AlunoDao alunoDao){
        Aluno alunoTemp = alunoDao.buscaAluno(new Aluno(null,aluno.getCpf()));
        if(alunoTemp.getNome() == null){
            return false;
        }
        return true;
    }  
    
    
    public void listarAlunos(AlunoDao alunoDao){
        List<Aluno> listaAlunos = alunoDao.getAll();
         for(Aluno aluno : listaAlunos){
             System.out.println(aluno.getNome());
             System.out.println(aluno.getCpf());
             System.out.println();
        }
    }
}
    
    
