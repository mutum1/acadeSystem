/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Professor;
import java.util.List;

/**
 *
 * @author paulo
 */
public interface ProfessorDao {
    List getAll();
    void carregar();
    void salvar(Professor professor);
    Professor buscarPorCpf(Professor professor);
    Professor buscar(Professor professor);
    List buscarPorNome(Professor professor);
}
