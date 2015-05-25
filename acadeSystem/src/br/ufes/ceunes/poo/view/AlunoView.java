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
public class AlunoView {
    
    AlunoDao alunoDao;
    
    public AlunoView(AlunoDao aluno){
        this.alunoDao = aluno;
    }
    
    /**
     * Método responsavel por cadastrar um aluno em uma lista
     * sem duplicatas.
     */
    public void cadastrar(){    
        Aluno aluno = getInfo();
        if(!existe(aluno)){
            this.alunoDao.salvar(aluno);
        }
    }
    
    /**
     * Método para preencher as informações dos alunos (nome,cpf,id)
     * @return Aluno com cpf, nome e id 
     */
    public Aluno getInfo(){
        Scanner input = new Scanner(System.in);
        String nome = "";
        String cpf = "";
        System.out.println("Digite o nome do aluno");
        nome = input.nextLine();
        
        System.out.println("Digite o cpf do aluno");
        cpf = input.nextLine();
        if(!Cpf.isValidCpf(cpf) && AcadeSystem.flagCpfVerify == 1){
            System.out.println("CPF inválido, digite novamente");
            cpf = input.nextLine();   
        }
        return new Aluno(nome,cpf,alunoDao.gerarProximoId());
    }    
    
    /**
     * Método que verifica se um aluno com determinado id existe.
     * @param aluno o aluno ao qual quer saber se
     * @return True/False
     */
    public boolean existe(Aluno aluno){
        Aluno alunoTemp = alunoDao.buscarPorCpf(new Aluno(null,aluno.getCpf(),0));
        if(alunoTemp.getNome() == null){
            return false;
        }
        return true;
    }  
        
    /**
     * Imprime todos os alunos por nome e cpf.
     */
    public void listar(){
        List<Aluno> listaAlunos = alunoDao.getAll();
         for(Aluno aluno : listaAlunos){
             System.out.println(aluno);
             System.out.println();
        }
    }
    /**
     * Procura o aluno na lista.
     * @param nome nome do aluno.
     */
        public void consultarPorNome(String nome){
        Aluno aluno = new Aluno(nome, null,0);
        List<Aluno> listaAluno = alunoDao.buscarPorNome(aluno);
        for(Aluno alunoTemp : listaAluno){
             System.out.println(alunoTemp);
             System.out.println();
        }
    }
 
}
    
    
