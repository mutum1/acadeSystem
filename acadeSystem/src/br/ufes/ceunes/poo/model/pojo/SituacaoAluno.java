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
    private Turma turma;
    private int id;
    private List<Atividade> atividade;

    // Construtor com lista de atividades, o aluno e suas presencas
    public SituacaoAluno(Aluno aluno, Turma turma, int id) {
        this.aluno = aluno;
        this.turma = turma;
        this.atividade = new ArrayList<>();
        this.id = id;
    }
    
    public float getNotaFinal() {
        float nota=0;
        for(Atividade atividade : atividade){
            nota = nota+atividade.getNota();
        }
        
        return nota;
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

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
    public String status(){
        int cargaHoraria =Integer.parseInt(turma.getDisciplina().getCargaHoraria());
        
        if((getNotaFinal()>=6) &&(this.faltas/cargaHoraria)<=0.25 )
            return "APROVADO";
        
        return "REPROVADO";
    }
    
    public String toString(){
        return "Nome do aluno: "+aluno.getNome()+"\nNota: "+getNotaFinal()+
                "   Faltas: "
                + this.faltas;
        
    }
}
