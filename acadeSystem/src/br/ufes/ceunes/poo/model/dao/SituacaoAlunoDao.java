/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.SituacaoAluno;

/**
 *
 * @author paulo
 */
public interface SituacaoAlunoDao {
    
    void carregar();
    void salvar(SituacaoAluno situacao);
    void addNota(int idTruma, int idAtividade,int idAluno,int nota);
    void addPresenca(int idTruma,int idAluno,Float presenca);
    float getNotaFinal(int idTruma,int idAluno);
    float getPresenca(int idTruma,int idAluno);
    int gerarProximoId();
    
}
