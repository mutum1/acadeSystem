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
    public List getAll();
    public void carregar();
    public void salvar(Professor professor);
    public Professor buscaCpf(Professor professor);
    public Professor buscaId(Professor professor);
    
}
