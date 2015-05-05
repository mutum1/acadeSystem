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
    private String departamento;
    private List<Disciplina> discliplinas;
   
    public Professor(String nome, String cpf, String departamento) {
        super(nome, cpf);
        this.discliplinas = new ArrayList<>();
        this.departamento=departamento;
    } 
    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        this.departamento=departamento;
    }
    public void addDiscilina(Disciplina diciplina){
        this.discliplinas.add(diciplina);
    }
}
