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
    
    private String nome;
    private String ementa;
    private String cargaHoraria;
    private String codigo;
    private List<String> listaCpf;

    public Disciplina(String nome, String ementa, String cargaHoraria,String codigo ) {
        this.listaCpf = new ArrayList<>();
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
    }
    
    
    public String getNome() {
        return nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }
    
    public void addDiscilina(String cpf){
        this.listaCpf.add(cpf);
    }

    public String getCodigo() {
        return codigo;
    }

    public List<String> listaCpf() {
        return listaCpf;
    }
    

}
