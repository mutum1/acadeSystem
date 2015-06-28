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
    private int id;
    private String nome;
    private String ementa;
    private String cargaHoraria;
    private List<Professor> listaProfessor;


    /**
     * transforma os valores da disciplina em string.
     * @return uma string com todas as informações separadas.
     */
    @Override
    public String toString(){
        return "Nome:          "+this.nome+
               "\nEmenta:        "+this.ementa+
               "\nCarga Horária: "+this.cargaHoraria+
               "\nID:            "+this.id;
    }
    
    /**
     * Inicializa a disciplina com nome a ementa cargahoraria e o id.
     * @param nome nome da disciplina.
     * @param ementa ementa da disciplina.
     * @param cargaHoraria carga horaria da disciplina.
     * @param id id da disciplina.
     */
    public Disciplina(String nome, String ementa, String cargaHoraria, int id) {
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.listaProfessor = new ArrayList<>();
        this.id= id;
    }
    
    /**
     * pega o nome da disciplina
     * @return nome da disciplina.
     */
    public String getNome() {
        return nome;
    }

    /**
     * pega a ementa da disciplina
     * @return a ementa.
     */
    public String getEmenta() {
        return ementa;
    }

    /**
     * pega a carga horária da disciplina
     * @return a carga horária da disciplina.
     */
    public String getCargaHoraria() {
        return cargaHoraria;
    }
    
    /**
     * Adiciona um professor a uma disciplina.
     * @param professor professor que dará disciplina.
     */
    public void addProfessor(Professor professor){
        this.listaProfessor.add(professor);

    }
    
    /**
     * pega a lista de professores.
     * @return lista de professores que pode dar a disciplina.
     */
    public List<Professor> listaProfessor() {
        return listaProfessor;
    }
    
    /**
     * pega o ID da Disciplina
     * @return o id da disciplina.
     */
    public int getId() {
        return id;
    }

}
