/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rhaister
 */
public class DisciplinaView {
    
    DisciplinaDao disciplinaDao;
    ProfessorDao professorDao;
    
    public DisciplinaView(DisciplinaDao disciplina,ProfessorDao professorDao){
        this.disciplinaDao = disciplina;
        this.professorDao = professorDao;
    }
    
    /**
     * Método responsavel por cadastrar uma disciplina em uma lista
     * sem duplicatas.
     */
    public void cadastrar(){        
        Disciplina disciplina = getInfo();
        if(!existe(disciplina)){
            disciplinaDao.salvar(disciplina);
        }
    }
    
    /**
     * Método responsavel por preencher todos os dados da Disciplina
     * nome,ementa,cargaHoraria e codigo já preenchidos.
     * @return disciplina com dados já cadastrados
     */
  
    public Disciplina getInfo(){
        Scanner input = new Scanner(System.in);
        String nome;
        String codigo;
        String ementa;
        String cargaHoraria;
        
        System.out.println("Digite o nome da disciplina");
        nome = input.nextLine();
        
        System.out.println("Digite a ementa");
        ementa = input.nextLine();
        
        System.out.println("Digite a carga horaria");
        cargaHoraria = input.nextLine();
      
        
        
        return new Disciplina(nome,ementa,cargaHoraria,disciplinaDao.gerarProximoId());
    }    
    
    /**
     * Métodos responsavel por não permitir duplicatas de disciplina na lista.
     * @param disciplina disciplina ao quer se quer saber se já existe na lista.
     * @return True se existe na alista/ False caso não exista.
     */
    
    public boolean existe(Disciplina disciplina){
        Disciplina disciplinaTemp = disciplinaDao.buscarPorNome(new Disciplina(disciplina.getNome(),null,null,-1));
        if(disciplinaTemp.getId() == -1){
            return false;
        }
        return true;
    }
    
    
    public void Listar(){
        List<Disciplina> listaDisciplina = disciplinaDao.getAll();
         for(Disciplina disciplina : listaDisciplina){
             System.out.println(disciplina);
             System.out.println();
        }
    
    }
    
    
}
