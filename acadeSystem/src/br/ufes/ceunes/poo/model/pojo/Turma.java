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
    // ATRIBUTOS
    private String ano;
    private String periodo;
    private String local;
    private String horario;
    private int nVagas;
    private Professor professor;
    private Disciplina disciplina;
    private List<Aluno> listAlunos;
    private List<Atividade> listAtividades;
    private int id;

    
    // Construtor com 7 parametros exceto lista de alunos
    public Turma(String ano, String periodo, String local, String horario, int nVagas, Professor professor, Disciplina disciplina, int id) {
        this.ano = ano;
        this.periodo = periodo;
        this.local = local;
        this.horario = horario;
        this.nVagas = nVagas;
        this.professor = professor;
        this.disciplina = disciplina;
        this.listAlunos = new ArrayList<>();
        this.listAtividades = new ArrayList<>();
        this.id = id;
    }
    
    public String getNomeTurma(){
        return disciplina.getNome()+" "+this.ano+"/"+this.periodo;
    }
    // Retorna o ano da turma
    public String getAno() {
        return ano;
    }

    // Modifica o ano da turma
    public void setAno(String ano) {
        this.ano = ano;
    }

    // Retorna o periodo da turma
    public String getPeriodo() {
        return periodo;
    }
    
    // Modifica o periodo da turma
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    // Retorna o local
    public String getLocal() {
        return local;
    }

    // Modifica o local da turma
    public void setLocal(String local) {
        this.local = local;
    }

    // Retorna o horario da turma
    public String getHorario() {
        return horario;
    }

    // Modifica o horario da turma
    public void setHorario(String horario) {
        this.horario = horario;
    }

    // Retorna numero de vagas
    public int getnVagas() {
        return nVagas;
    }

    // Modofica o numero de vagas
    public void setnVagas(int nVagas) {
        this.nVagas = nVagas;
    }

    // Retorna os dados do professor da turma
    public Professor getProfessor() {
        return professor;
    }

    // Retorna a disciplina da turma
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    // retorna a lista de alunos da turma
    public List<Aluno> getListaAlunos(){
        return listAlunos;
    }
    
    // Adiciona um aluno na turma
    public void addAluno(SituacaoAluno situacaoAluno){ 
        situacaoAluno.getAluno().addSituacao(situacaoAluno);
        listAlunos.add(situacaoAluno.getAluno());
        
    }

    public List<Atividade> getListAtividades() {
        return listAtividades;
    }
    
    
        // Retorna o ID da Turma
    public int getId() {
        return id;
    }
    public void addAtividade(Atividade atividade){
        this.listAtividades.add(atividade);
    }
    
    @Override
    public String toString(){
        return "Turma de : "+disciplina.getNome()+
               "\nProfessor: "+ professor.getNome()+
               "\nPeríodo:   "+ano+"/"+periodo+
               "\nHorário:   "+horario+
               "\nLocal:     "+local+
               "\nQuantidade de vagas: "+nVagas;        
    }

    public void aplicarAtividade(Atividade novaAtividade) {
        for(Aluno aluno : listAlunos){
        
        }
    }
    
    
}
