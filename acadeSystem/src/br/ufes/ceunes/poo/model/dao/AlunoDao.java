/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import java.util.List;

/**
 *
 * @author paulo
 */
public interface AlunoDao {

    List getAll();
    void carregar();
    void salvar(Aluno aluno);
    Aluno buscar(Aluno aluno);
    Aluno buscarPorNome(Aluno aluno);
    Aluno buscarPorCpf(Aluno aluno);
   
}
