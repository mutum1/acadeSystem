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
public class Faltas {
    int id;
    float faltas;
    Aluno aluno;
    Turma turma;

    public int getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public float getFaltas() {
        return faltas;
    }

    public void setFaltas(float faltas) {
        this.faltas = faltas;
    }

    public Faltas(int id, Aluno aluno, Turma turma) {
        this.id = id;
        this.aluno = aluno;
        this.turma = turma;
    }
}
