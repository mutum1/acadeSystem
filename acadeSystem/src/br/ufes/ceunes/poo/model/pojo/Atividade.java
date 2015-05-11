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
    private int valor;
    private int nota;

    // Construtor de atividades (4 parametros)
    public Atividade(String nome, String tipo, String data, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
    }

    // Retorna valor
    public int getValor() {
        return valor;
    }

    // Altera valor
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
