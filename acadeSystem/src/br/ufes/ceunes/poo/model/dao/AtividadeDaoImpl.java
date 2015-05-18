/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Atividade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulo
 */
public class AtividadeDaoImpl implements AtividadeDao {
    List<Atividade> listAtividades;
    int id;

    public AtividadeDaoImpl() {
        listAtividades = new ArrayList<>();
        id=0;
    }
    
    
    @Override
    public List getAll() {
        return listAtividades;
    }

    @Override
    public void carregar() {
        
    }

    @Override
    public void salvar(Atividade atividade) {
        
    }
    
}
