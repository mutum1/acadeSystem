/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.model.pojo;

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
@Table(name = "Aluno")
public class Aluno extends Pessoa {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Aluno() {
    }
    /**
     * Contrutor que usa o contrutor da classe Pessoa.(super)
     * instancia a situação do aluno como uma nova lista.
     * @param nome nome do aluno.
     * @param cpf cpf do aluno.
     * @param id id do aluno.
     */
   
    public Aluno(String nome, String cpf, long id) { // Chama o construtor da classe de cima.
        super(nome, cpf);
        this.id = id;
        
    }
    public long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
