/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.model.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulo
 */
public class Aluno extends Pessoa {
    List<SituacaoAluno> situacao;
    
    public Aluno(String nome, String cpf, int id) { // Chama o construtor da classe de cima.
        super(nome, cpf, id);
        situacao = new ArrayList<>();
    }
    
}
