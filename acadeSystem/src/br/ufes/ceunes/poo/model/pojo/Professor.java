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
   
    // Construtor do professor sem disciplina
    public Professor(String nome, String cpf, String departamento, int id) {
        super(nome, cpf, id);
        this.departamento = departamento;
        this.discliplinas = new ArrayList<>();
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
    
    @Override
    public String toString(){
        return "\nNome:         "+super.getNome()+
               "\nCPF:          "+super.getCpf()+
               "\nDepartamento: "+this.departamento+
               "\nID:           "+super.getId();                
    }
    
}
