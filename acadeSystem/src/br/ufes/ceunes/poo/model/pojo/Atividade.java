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
public class Atividade {
    // ATRIBUTOS
    private String nome;
    private String tipo;
    private String data;
    private Turma turma;
    private int valor;
    private int nota;
    private int id;
    
    
    public Atividade(String nome, String tipo, String data,Turma turma ,int valor,int nota, int id) {
        this.turma =turma;
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.nota=nota;
        this.id = id;
    }
    // Construtor de atividades (6 parametros)
    public Atividade(String nome, String tipo, String data,Turma turma ,int valor, int id) {
        this.turma =turma;
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.nota=0;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getData() {
        return data;
    }

    public int getNota() {
        return nota;
    }

    // Retorna valor
    public int getValor() {
        return valor;
    }

    // Altera valor
    public void setValor(int valor) {
        this.valor = valor;
    }

    public Turma getTurma() {
        return turma;
    }

    
        // Retorna o ID da Atividade
    public int getId() {
        return id;
    } 

    public void setNota(int nota) {
        this.nota = nota;
    }
    
}
