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
public class SituacaoAluno {
    // ATRIBUTOS
    private float presenca;
    private Aluno aluno;
    private List<Atividade> atividade;
    private int id;

    // Construtor com lista de atividades, o aluno e suas presencas
    public SituacaoAluno(float presenca, Aluno aluno, int id) {
        this.presenca = presenca;
        this.aluno = aluno;
        this.atividade = new ArrayList<>();
        this.id = id;
    }
    
    
    // Retorna a taxa de presenca do aluno
    public float getPresenca() {
        return presenca;
    }

    // Modifica a taxa de presenta do aluno
    public void setPresenca(float presenca) {
        this.presenca = presenca;
    }

    // Retorna todas as caracteristicas do aluno
    public Aluno getAluno() {
        return aluno;
    }

    // Retorna lista de atividades
    public List<Atividade> getAtividade() {
        return atividade;
    }

    // Adiciona uma atividade na listad e atividades
    public void addAtividade (Atividade atividade) {
        this.atividade.add(atividade);
        
    }
    
    
}
