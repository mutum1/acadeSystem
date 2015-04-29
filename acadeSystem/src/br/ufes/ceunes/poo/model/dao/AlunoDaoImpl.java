/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;
import br.ufes.ceunes.poo.model.pojo.Aluno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulo
 */

public class AlunoDaoImpl implements AlunoDao {
    
    private List<Aluno> listaAlunos;
    
    public AlunoDaoImpl(){
        this.listaAlunos =new ArrayList<>();
    }
    
    @Override
    public void adicionar(Aluno aluno){
        listaAlunos.add(aluno);
    }

}
