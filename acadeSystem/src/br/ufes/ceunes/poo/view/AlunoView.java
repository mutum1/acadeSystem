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
    
    /**
     * Método para preencher as informações dos alunos (nome,cpf)
     * @return Aluno com cpf e nome 
     */
  
    public Aluno getInfo(){
        Scanner input = new Scanner(System.in);
        String nome = "";
        String cpf = "";
        System.out.println("Digite o nome do aluno");
        nome = input.nextLine();
        
        System.out.println("Digite o cpf do aluno");
        cpf = input.nextLine();
        if(!Cpf.isValidCpf(cpf)){
            System.out.println("CPF inválido, digite novamente");
            cpf = input.nextLine();   
        }
        return new Aluno(nome,cpf);
    }    
    
    /**
     * Método que verifica se um aluno com determinado cpf existe.
     * @param aluno
     * @return True/False
     */
    
    
    public boolean existeAluno(Aluno aluno){
        Aluno alunoTemp = alunoDao.buscaAluno(new Aluno(null,aluno.getCpf()));
        if(alunoTemp.getNome() == null){
            return false;
        }
        return true;
    }  
    
    /**
     * Imprime todos os alunos por nome e cpf.
     */
    
    
    public void listarAlunos(){
        List<Aluno> listaAlunos = alunoDao.getAll();
         for(Aluno aluno : listaAlunos){
             System.out.println(aluno.getNome());
             System.out.println(aluno.getCpf());
             System.out.println();
        }
    }
}
    
    
