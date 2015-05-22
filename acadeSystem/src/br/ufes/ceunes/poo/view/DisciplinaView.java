/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rhaister
 */
class DisciplinaView {
    
    DisciplinaDao disciplinaDao;
   /**
    * Construtor da Disciplina.
    * @param disciplina 
    */
    
    public DisciplinaView(DisciplinaDao disciplina){
        this.disciplinaDao = disciplina;
    }
    
    /**
     * Método responsavel por preencher todos os dados da Disciplina
     * nome,ementa,cargaHoraria e codigo já preenchidos.
     * @return disciplina com dados já cadastrados
     */
  
    public Disciplina getInfo(){
        Scanner input = new Scanner(System.in);
        String nome = "";
        String codigo = "";
        String ementa = "";
        String cargaHoraria="";
        
        System.out.println("Digite o nome da disciplina");
        nome = input.nextLine();
        
        System.out.println("Digite o codigo da disciplina");
        codigo = input.nextLine();
        
        System.out.println("Digite a ementa");
        ementa = input.nextLine();
        
        System.out.println("Digite a carga horaria");
        cargaHoraria = input.nextLine();
      
        
        
        return new Disciplina(nome,ementa,cargaHoraria,codigo);
    }    
    
    /**
     * Métodos responsavel por não permitir duplicatas de disciplina na lista.
     * @param disciplina
     * @param disciplinaDao
     * @return True se existe na alista/ False caso não exista.
     */
    
    public boolean existeDisciplina(Disciplina disciplina, DisciplinaDao disciplinaDao){
        Disciplina disciplinaTemp = disciplinaDao.buscaDisciplina(new Disciplina(null,null,null,disciplina.getCodigo()));
        if(disciplinaTemp.getNome() == null){
            return false;
        }
        return true;
    }
    
    
}
