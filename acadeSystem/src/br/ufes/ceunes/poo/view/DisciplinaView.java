/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import java.util.List;

/**
 *
 * @author Rhaister
 */
class DisciplinaView {
    
   private final DisciplinaDao disciplina;
   private List<Disciplina> listaDisciplina;
    
    DisciplinaView(DisciplinaDao disciplinaDao) {
        this.disciplina = disciplinaDao;
    }
    
}
