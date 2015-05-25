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

    /**
     * Construtor com lista de atividades, o aluno e suas presencas
     * @param aluno O objeto aluno.
     * @param turma O objeto turma.
     * @param id o id da situação do aluno.
     */
    public SituacaoAluno(Aluno aluno, Turma turma, int id) {
        this.aluno = aluno;
        this.turma = turma;
        this.atividade = new ArrayList<>();
        this.id = id;
    }
    /**
     * Pega a nota final
     * @return a nota final do aluno.
     */
    public float getNotaFinal() {
        float nota=0;
        int numeroAtividades=0;
        numeroAtividades=atividade.size();
        for(Atividade atividade : atividade){
            nota = nota+atividade.getNota();
        }
        nota=nota/numeroAtividades;
        return nota;
    }
    /**
     * Pega todas as caracteristicas do aluno
     * @return aluno.
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     *  Pega lista de atividades.
     * @return a lista de atividades
     */
    public List<Atividade> getAtividade() {
        return atividade;
    }

    /**
     * Adiciona uma atividade na listad e atividades
     * @param atividade atividade a ser adicionada na lista.
     */
    public void addAtividade (Atividade atividade) {
        this.atividade.add(atividade);
        
    }
    
    /**
     * Pegao ID da Situação Aluno.
     * @return o id da situação.
     */
    public int getId() {
        return id;
    }
    /**
     * Pega a turma.
     * @return a turma.
     */
    public Turma getTurma() {
        return turma;
    }
    /**
     * Pegas as faltas do aluno.
     * @return as faltas do aluno.
     */
    public int getFaltas() {
        return faltas;
    }
    /**
     * Modifica as faltas do aluno.
     * @param faltas numero de faltas do aluno.
     */
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
    /**
     * Verifica se o aluno esta aprovado.
     * @return uma string APROVADO OU REPROVADO.
     */
    public String status(){
        int cargaHoraria =Integer.parseInt(turma.getHorario());
        
        if((getNotaFinal()>=6) &&(this.faltas/cargaHoraria)<=0.25 )
            return "APROVADO";
        
        return "REPROVADO";
    }
    /**
     * Converte os dados da situação do aluno para string.
     * @return os dados concatenados da situação do aluno.
     */
    public String toString(){
        return "Nome do aluno: "+aluno.getNome()+"\nNota: "+getNotaFinal()+
                "   Faltas: "
                + this.faltas+" status:"+status();
        
    }
}
