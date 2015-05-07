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
    public void adicionar(Turma turma);
    public List getAll();
    public void carregar();
    public void salvar();
}
