/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.pojo.Professor;
import java.util.List;

/**
 *
 * @author Rhaister
 */
class ProfessorView {
    
    private final ProfessorDao professor;//Extanciei o objeto da classe "main" para usar os metodos do impl
    private List<Professor> listaProfessor;
               
    ProfessorView(ProfessorDao professorDao) {
        this.professor = professorDao;
    }
    
}
