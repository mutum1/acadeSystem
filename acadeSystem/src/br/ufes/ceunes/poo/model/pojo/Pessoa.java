/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.pojo;

import javax.persistence.Column;

/**
 *
 * @author paulo
 */
public class Pessoa  implements java.io.Serializable {

    //ATRIBUTOS
    @Column
    private String nome;
    
    @Column
    private String cpf;
     
    /**
     * Contrutor para pessoas. (professores e alunos)
     * @para nome nome da pessoa.
     * @para cpf cpf da pessoa.
     */
    public Pessoa(){
        
    }
    public Pessoa(String nome, String cpf) {
       this.nome = nome;
       this.cpf = cpf;
      
    }
   
    /**
     * Pega o nome da pessoa
     * @return nome da pessoa.
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     * Pega o cpf da pessoa
     * @return o cpf da pessoa.
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * Modifica o nome da pessoa.
     * @param nome nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica o cpf da pessoa.
     * @param cpf cpf da pessoa.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    /**
     * Converte os dados da pessoa para string.
     * @return uma string com todos os dados concatenados.
     */
    @Override
    public String toString(){
        return "Nome: "+this.nome+
               "\nCPF:  "+this.cpf+
               "\nID:   ";                
    }
  }