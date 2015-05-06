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
    private float presenca;
    private Aluno aluno;
    private List<Atividade> atividade;

    public SituacaoAluno(Aluno aluno) {
        this.atividade=new ArrayList<>();
        this.aluno=aluno;
        presenca=0;
    }

    public float getPresenca() {
        return presenca;
    }

    public void setPresenca(float presenca) {
        this.presenca = presenca;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public List<Atividade> getAtividade() {
        return atividade;
    }

    public void addAtividade (Atividade atividade) {
        this.atividade.add(atividade);
        
    }
    
    
}
