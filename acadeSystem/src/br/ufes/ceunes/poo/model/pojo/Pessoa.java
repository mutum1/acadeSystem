/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.pojo;

/**
 *
 * @author paulo
 */
public class Pessoa  implements java.io.Serializable {

    //ATRIBUTOS
     private String nome;
     private String cpf;
     
     
    // Construtor com os dados
    public Pessoa(String nome, String cpf) {
       this.nome = nome;
       this.cpf = cpf;

    }
   
    // Retorna o nome da pessoa
    public String getNome() {
        return this.nome;
    }
    
    // Retorna o cpf da pessoa
    public String getCpf() {
        return this.cpf;
    }

    // Modifica o nome da pessoa
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Modifica o cpf da pessoa
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
 

}