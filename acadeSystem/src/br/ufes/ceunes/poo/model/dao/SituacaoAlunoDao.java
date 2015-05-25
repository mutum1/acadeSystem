/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Atividade;
import br.ufes.ceunes.poo.model.pojo.SituacaoAluno;
import br.ufes.ceunes.poo.model.pojo.Turma;

/**
 *
 * @author paulo
 */
public interface SituacaoAlunoDao {
    
    void carregar();
    void salvar(SituacaoAluno situacao);
    int gerarProximoId();
    void salvar();
    
}
