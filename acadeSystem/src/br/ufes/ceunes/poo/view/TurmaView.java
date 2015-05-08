/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.dao.TurmaDao;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.pojo.Turma;
import java.util.List;

/**
 *
 * @author Rhaister
 */
class TurmaView {

    private final TurmaDao turma;//Extanciei o objeto da classe "main" para usar os metodos do impl
    private List<Turma> listaTurma;
               
    TurmaView(TurmaDao turmaDao) {
        this.turma = turmaDao;
    }
}
