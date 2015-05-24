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
    private float valor;
    private float nota;
    private int id;
      
    @Override
    public String toString(){
        return "Atividade "+nome+":"+
               "\nTurma: "+this.turma.getNomeTurma()+
               "\nTipo:  "+this.tipo+
               "\nData:  "+this.data+
               "\nValor  "+this.valor+
               "\nID:    "+this.id; 
               
    }
    
    public Atividade copiaComNota(float nota){
        Atividade atividade = new Atividade(this.nome, this.tipo, this.data, this.turma, this.valor, this.id);
        atividade.nota=nota;
        return atividade;
    }
    // Construtor de atividades (6 parametros)
    public Atividade(String nome, String tipo, String data,Turma turma ,float valor, int id) {
        this.turma =turma;
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.nota = 0;
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

    public float getNota() {
        return nota;
    }

    // Retorna valor
    public float getValor() {
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

    public void setNota(float nota) {
        this.nota = nota;
    }
    
}
