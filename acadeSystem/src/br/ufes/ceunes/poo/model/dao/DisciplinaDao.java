/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import java.util.List;

/**
 *
 * @author paulo
 */
public interface DisciplinaDao {
    List getAll();
    int gerarProximoId();
    void adicionar(Disciplina disciplina);
    void carregar();
    void salvar();
    Disciplina buscar(Disciplina disciplina);
}
