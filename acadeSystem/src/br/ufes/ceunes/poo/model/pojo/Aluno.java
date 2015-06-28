/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author paulo
 */
@Entity
@Table(name="aluno")

public class Aluno{
   
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column
    private String nome;
    
    @Column
    private String cpf;

    public Aluno() {
    }

    public Aluno(String nome, String cpf, long id) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
    
    
    /**
     * Contrutor que usa o contrutor da classe Pessoa.(super)
     * instancia a situação do aluno como uma nova lista.
     * @param nome nome do aluno.
     * @param cpf cpf do aluno.
     * @param id id do aluno.
     */
   
    
    public long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    
    
}
