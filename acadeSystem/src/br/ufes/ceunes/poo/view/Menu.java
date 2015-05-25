/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rui
 */
public class Menu {
    private List<String> optionsList;
    private String title;
    private int size;
    /**
     * instancia a lista de opções.
     */
    public Menu(){
        this(new ArrayList<String>());
    }
    /**
     * adiciona um opção na lista de opções.
     * @param optionsList lista de opções.
     */
    public Menu(List<String> optionsList){
        this.optionsList = optionsList;
        this.title = "AcadeSystem";
        this.size = 0;
    }
    
    public Menu(List<String> optionsList, String title){
        this(optionsList);
        this.title = title;
    }
    /**
     * adiciona um item a lista de opções
     * @param item novo item a ser adicionado.
     */
    public void addOption(String item){
        optionsList.add(item);
        this.size = optionsList.size();
    }
    /**
     * Modifica o titulo.
     * @param title novo titulo.
     */
    public void setTitle(String title){
        this.title = title;
    }
    /**
     * Pega o titulo.
     * @return retorna o titulo.
     */
    public String getTitle(){
        return this.title;
    }
    /**
     * Pega a quantidade de opções.
     * @return quantidade de opções.
     */
    public int getSize(){
        return this.size;
    }
    /**
     * Mostra as opções
     */
    public void showOptions(){

        System.out.println(this.title);
        System.out.println("");
        for(int i =0;i<optionsList.size();i++){
            System.out.println(i+1 +" - " + optionsList.get(i));
        }
    }
    /**
     * recebe as opção do usuario, e verifica se é valida.
     * @return a opção.
     */
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
