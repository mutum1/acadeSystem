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
public class Turma {
    private String ano;
    private String periodo;
    private String local;
    private String horario;
    private int nVagas;
    private Professor professor;
    private Disciplina disciplina;
    private List<String> listAlunos;

    public Turma(String ano, String periodo, String local, String horario, int nVagas, Professor professor, Disciplina disciplina) {
        this.listAlunos = new ArrayList<>();
        this.ano = ano;
        this.periodo = periodo;
        this.local = local;
        this.horario = horario;
        this.nVagas = nVagas;
        this.professor = professor;
        this.disciplina = disciplina;
    }
    

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

    public Professor getProfessor() {
        return professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public List<String> getListaAlunos(){
        return listAlunos;
    }
    
    public void addAluno(Aluno aluno){
        listAlunos.add(aluno.getCpf());
    }
}
