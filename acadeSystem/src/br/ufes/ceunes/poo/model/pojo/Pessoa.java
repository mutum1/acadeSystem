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
    private int id;
    private String nome;
    private String cpf;
    
     
     
    /**
     * Contrutor para pessoas. (professores e alunos)
     * @param nome nome da pessoa.
     * @param cpf cpf da pessoa.
     * @param id id da pessoa.
     */
    public Pessoa(String nome, String cpf, int id) {
       this.nome = nome;
       this.cpf = cpf;
       this.id = id;

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
     * Pega o ID da Pessoa
     * @return id da pessoa.
     */
    public int getId() {
        return id;
    }
    /**
     * Converte os dados da pessoa para string.
     * @return uma string com todos os dados concatenados.
     */
    @Override
    public String toString(){
        return "Nome: "+this.nome+
               "\nCPF:  "+this.cpf+
               "\nID:   "+this.id;                
    }
  }