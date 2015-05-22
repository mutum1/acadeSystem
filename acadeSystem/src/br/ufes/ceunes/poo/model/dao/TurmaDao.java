/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Turma;
import java.util.List;

/**
 *
 * @author paulo
 */
public interface TurmaDao {
    List getAll();
    void carregar();
    public int gerarProximoId();
    void adicionar(Turma turma);
    void salvar();
    Turma disponibilidadeLocal(Turma turma);
    Turma buscar(Turma turma);
}
