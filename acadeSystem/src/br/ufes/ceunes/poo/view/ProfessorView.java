/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Professor;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rhaister
 */
public class ProfessorView {
    
    ProfessorDao professorDao;
    
    public ProfessorView(ProfessorDao professor){
        this.professorDao = professor;
    }
    
    /**
     * Método responsavel por cadastrar um professor em uma lista
     * sem duplicatas.
     */
    public void cadastrar(){    
        Professor professor = getInfo();
        if(!existe(professor)){
            professorDao.salvar(professor);
        }
    }
    
    /**
     * Método responsavel por preencher todas as caracteristicas do professor
     * e chama o metodo para fazer a verificação do cpf.
     * @return professor preenchido.(nome cpf e departamento)
     */
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
        
        if(!Cpf.isValidCpf(cpf) && AcadeSystem.flagCpfVerify ==1){
            System.out.println("CPF inválido, digite novamente");
            cpf = input.nextLine();   
        }
        
        
        return new Professor(nome,cpf,departamento,professorDao.gerarProximoId());
    }    
    /**
     * Método responsavel por verifica se o professor já existe na lista.
     * @param professor
     * @return True se existe na lista/ False caso não exista.
     */
    
    public boolean existe(Professor professor){
        Professor professorTemp = professorDao.buscarPorCpf(new Professor(null,null,professor.getCpf(),0));
        if(professorTemp.getNome() == null){
            return false;
        }
        return true;
    }
    
    public void listar(){
        List<Professor> listaProfessor = professorDao.getAll();
        for(Professor professor : listaProfessor){
             System.out.println(professor);
             System.out.println();
        }
    }
    
    public void consultarPorNome(String nome){
        Professor professor = new Professor(nome, null, null,0);
        List<Professor> listaProfessor = professorDao.buscarPorNome(professor);
        for(Professor professorTemp : listaProfessor){
             System.out.println(professorTemp);
             System.out.println();
        }
    }
    
}
