/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.pojo;

/**
 *
 * @author Rhaister
 */
public class Turma {
    private String ano;
    private String periodo;
    private String local;
    private String horario;
    private int nVagas;
    private Professor professor;
    private Disciplina disciplina;

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getnVagas() {
        return nVagas;
    }

    public void setnVagas(int nVagas) {
        this.nVagas = nVagas;
    }
    
}
