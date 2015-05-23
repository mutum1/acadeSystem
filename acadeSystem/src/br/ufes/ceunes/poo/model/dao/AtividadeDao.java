/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Atividade;
import java.util.List;

/**
 *
 * @author paulo
 */
public interface AtividadeDao {
    
    void carregar();
    void salvar(Atividade atividade);
    Atividade buscar(Atividade atividade);
    int gerarProximoId();
    List getAll();
    
}
