/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Faltas;

/**
 *
 * @author Rhaister
 */
public interface FaltasDao {
    void carregar();
    void salvar(Faltas falta);
}
