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
    private List<String> listaItens;
    
    public Menu(){
        this.listaItens = new ArrayList<>();
    }
    
    public void adicionarItem(String item){
        listaItens.add(item);
    }
    
    public void listarItens(){
        for(int i =0;i<listaItens.size();i++){
            System.out.println(i+1 +" - " + listaItens.get(i));
        }
    }
    
    public int getOption(){
         Scanner input = new Scanner(System.in);
         int opcao = 0;
         
         while (opcao < 1 || opcao >= listaItens.size()){
            opcao =  input.nextInt();
                
            if(opcao < 1 || opcao >= listaItens.size())
                System.out.println("Opcao invalida");
         }
         return opcao;
    }
}
