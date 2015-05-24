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
    private int faltas;
    private Aluno aluno;
    
    private List<Atividade> atividade;
    private Turma turma;
    private int id;

    // Construtor com lista de atividades, o aluno e suas presencas
    public SituacaoAluno(Aluno aluno, Turma turma, int id) {
        this.aluno = aluno;
        this.turma = turma;
        this.atividade = new ArrayList<>();
        this.id = id;
    }
    
    
    // Retorna a taxa de presenca do aluno
    public float getPresenca() {
        return faltas;
    }

    // Modifica a taxa de presenta do aluno
    public void setPresenca(float presenca) {
        this.faltas = faltas;
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
    
        // Retorna o ID da Situação Aluno
    public int getId() {
        return id;
    }

    public Turma getTurma() {
        return turma;
    }
   
}
