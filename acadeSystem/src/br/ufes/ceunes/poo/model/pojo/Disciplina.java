/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rhaister
 */
public class Disciplina {
    // ATRIBUTOS
    private String nome;
    private String ementa;
    private String cargaHoraria;
    private List<Professor> listaProfessor;
    private int id;

    
    @Override
    public String toString(){
        return "Nome:          "+this.nome+
               "\nEmenta:        "+this.ementa+
               "\nCarga Horária: "+this.cargaHoraria+
               "\nID:            "+this.id;
    }
    
    // Construtor (4 parametros)
    public Disciplina(String nome, String ementa, String cargaHoraria, int id) {
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.listaProfessor = new ArrayList<>();
        this.id= id;
    }
    
    
    // Retorna nome da disciplina
    public String getNome() {
        return nome;
    }

    // Retorna a ementa da disciplina
    public String getEmenta() {
        return ementa;
    }

    // Retorna a cargahoraria da disciplina
    public String getCargaHoraria() {
        return cargaHoraria;
    }
    
    // Adiciona uma disciplina 
    public void addProfessor(Professor professor){
        this.listaProfessor.add(professor);

    }
    
    // Retorna a lista de professores
    public List<Professor> listaProfessor() {
        return listaProfessor;
    }
    
        // Retorna o ID da Disciplina
    public int getId() {
        return id;
    }

}
