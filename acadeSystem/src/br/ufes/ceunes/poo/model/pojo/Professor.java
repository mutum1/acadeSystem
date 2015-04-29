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
public class Professor extends Pessoa {
    private String departamento;
   
    public Professor(String nome, String cpf, String departamento) {
        super(nome, cpf);
        this.departamento=departamento;
    }
    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        this.departamento=departamento;
    }
}
