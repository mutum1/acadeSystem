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
public class Aluno extends Pessoa {
    List<SituacaoAluno> situacao;
    /**
     * Contrutor que usa o contrutor da classe Pessoa.(super)
     * instancia a situação do aluno como uma nova lista.
     * @param nome nome do aluno.
     * @param cpf cpf do aluno.
     * @param id id do aluno.
     */
    
    public Aluno(String nome, String cpf, int id) { // Chama o construtor da classe de cima.
        super(nome, cpf, id);
        situacao = new ArrayList<>();
    }
    /**
     * Adiciona uma situação ao aluno.
     * @param situacaoAluno lista da situação atual do aluno.
     */
    public void addSituacao (SituacaoAluno situacaoAluno){
        situacao.add(situacaoAluno);
    }
    public  SituacaoAluno getSituacaoAluno(Turma turma){
        for(SituacaoAluno situacaoAluno : situacao){
            if(situacaoAluno.getTurma().equals(turma))
                return situacaoAluno;
        }
        return null;
    }
}
