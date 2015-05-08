/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.pojo.Aluno;
import java.util.List;

/**
 *
 * @author Rhaister
 */
class AlunoView {
    
    private final AlunoDao aluno;
    private List<Aluno> listaAluno;

    AlunoView(AlunoDao alunoDao) {
        this.aluno = alunoDao;
       
    }
    
}
