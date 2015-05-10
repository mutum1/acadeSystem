/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.dao.AlunoDaoImpl;
import br.ufes.ceunes.poo.model.pojo.Aluno;
import java.util.Scanner;

/**
 *fgf
 * @author Rui
 */
public class CadastroAluno {
    
    
    //input.nextInt();
    Aluno aluno;
    
    public CadastroAluno(){
        aluno = new Aluno();
    }
    
    public CadastroAluno(Aluno Aluno){
        this.aluno = aluno;
    }
    
    public void getData(){
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
        aluno = new Aluno(nome,cpf);
    }
    
    public void endRegister(AlunoDao alunoDao){
        alunoDao.adicionar(aluno);
    }
    
    
    
}
