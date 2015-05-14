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
 * @author paulo
 */
public class Professor extends Pessoa {
    // ATRIBUTOS
    private String departamento;
    private List<Disciplina> discliplinas;
    private int id;
   
    // Construtor do professor sem disciplina
    public Professor(String departamento, List<Disciplina> discliplinas, int id, String nome, String cpf) {
        super(nome, cpf);
        this.departamento = departamento;
        this.discliplinas = discliplinas;
        this.id = id;
    }
    
    
    // Retorna o departamento do professor
    public String getDepartamento(){
        return departamento;
    }
    
    // Modifica o departamento do professor
    public void setDepartamento(String departamento){
        this.departamento=departamento;
    }
    
    // Adiciona uma disciplina ao professor.
    public void addDiscilina(Disciplina diciplina){
        this.discliplinas.add(diciplina);
    }
}
