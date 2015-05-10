/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rui
 */
public class Menu {
    private List<String> optionsList;
    private String title;
    private int size;
    
    public Menu(){
        this(new ArrayList<String>());
    }
    
    public Menu(List<String> optionsList){
        this.optionsList = optionsList;
        this.title = "AcadeSystem";
        this.size = 0;
    }
    
    public Menu(List<String> optionsList, String title){
        this(optionsList);
        this.title = title;
    }
    public void addOption(String item){
        optionsList.add(item);
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void showOptions(){
        for(int i =0;i<optionsList.size();i++){
            System.out.println(i+1 +" - " + optionsList.get(i));
        }
    }
    
    public int getOption(){//pega opçao do usuario e verifica se a opçao é valida
         Scanner input = new Scanner(System.in);
         int opcao = 0;
         
         while (opcao < 1 || opcao > optionsList.size()){
            opcao =  input.nextInt();
                
            if(opcao < 1 || opcao > optionsList.size())
                System.out.println("Opcao invalida");
         }
         return opcao;
    }
    
}
