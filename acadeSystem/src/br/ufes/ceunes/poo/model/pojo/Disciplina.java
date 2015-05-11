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
    private String codigo;
    private List<String> listaCpf;

    // Construtor (4 parametros)
    public Disciplina(String nome, String ementa, String cargaHoraria,String codigo ) {
        this.listaCpf = new ArrayList<>();
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
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
    public void addDisciplina(String cpf){
        this.listaCpf.add(cpf);
    }

    public String getCodigo() {
        return codigo;
    }

    public List<String> listaCpf() {
        return listaCpf;
    }
    

}
