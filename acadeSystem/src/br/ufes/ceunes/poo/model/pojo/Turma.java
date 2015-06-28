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

    
    /**
     * Construtor com 7 parametros exceto lista de alunos
     * @param ano ano da turma.
     * @param periodo periodo da turma.
     * @param local local da turma.
     * @param horario horario da aula.
     * @param nVagas numero de vagas da turma.
     * @param professor obejo professor com os dados dele.
     * @param disciplina objeto disciplina, com todos os dados.
     * @param id id da turma.
     */
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
    /**
     * Pega o nome da turma
     * @return nome da disciplina o ano e o periodo.
     */
    public String getNomeTurma(){
        return disciplina.getNome()+" "+this.ano+"/"+this.periodo;
    }
    /**
     * Pegao ano da turma
     * @return o ano da turma
     */
    public String getAno() {
        return ano;
    }

    /**
     * Modifica o ano da turma
     * @param ano novo ano.
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * Pega o periodo da turma
     * retorna o periodo da turma.
     */
    
    public void setListAlunos(List<Aluno> listAlunos) {
        this.listAlunos = listAlunos;
    }
    // Retorna o periodo da turma
    public String getPeriodo() {
        return periodo;
    }
    
    /**
     * Modifica o periodo da turma.
     * @param periodo novo periodo.
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    /**
     * Pega o local
     * @return o local da turma.
     */
    public String getLocal() {
        return local;
    }

    /**
     * Modifica o local da turma.
     * @param local novo local.
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * Pega o horario da turma.
     * @return o horario.
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Modifica o horario da turma.
     * @param horario novo horario.
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Pega numero de vagas.
     * @return o numero de vagas da turma.
     */
    public int getnVagas() {
        return nVagas;
    }

    /**
     * Modofica o numero de vagas.
     * @param nVagas numero de vagas
     */
    public void setnVagas(int nVagas) {
        this.nVagas = nVagas;
    }

    /**
     * Pega os dados do professor da turma
     * @return o professor da turma.
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * Pega a disciplina da turma.
     * @return disciplina da turma.
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    /**
     * Pega a lista de alunos da turma
     * @return lista de alunos da turma.
     */
    public List<Aluno> getListaAlunos(){
        return listAlunos;
    }


    /**
     * Pega a lista de atividades da turma.
     * @return a lista de atividades.
     */
    public List<Atividade> getListAtividades() {
        return listAtividades;
    }
    
    
     /**
     * Pega o ID da Turma
     * @return o id da turma.
     */
    public int getId() {
        return id;
    }
    /**
     * Adiciona uma atividade na turma.
     * @param atividade nova atividade a ser inserida.
     */
    public void addAtividade(Atividade atividade){      
        this.listAtividades.add(atividade);
    }
    /**
     * Converte todos os dados da turma para string.
     * @return todos os dados concatenados de turma.
     */
    @Override
    public String toString(){
        return "Turma de : "+disciplina.getNome()+
               "\nProfessor: "+ professor.getNome()+
               "\nPeríodo:   "+ano+"/"+periodo+
               "\nHorário:   "+horario+
               "\nLocal:     "+local+
               "\nID:        "+id+
               "\nQuantidade de vagas: "+nVagas;        
    }

}
