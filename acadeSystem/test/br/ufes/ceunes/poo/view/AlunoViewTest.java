/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDaoImpl;
import br.ufes.ceunes.poo.model.pojo.Aluno;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class AlunoViewTest {

    /**
     * Verifica se o aluno existe.
     */
    @Test
    public void testExiste() {
        System.out.println("existe");
        Aluno aluno = new Aluno("Felipe", "024.024.024-24", 1);
        AlunoDaoImpl alunoTest = new AlunoDaoImpl();
        AlunoView instance = new AlunoView(alunoTest);
        boolean expResult = false;
        boolean result = instance.existe(aluno);
        assertEquals(expResult, result);
    }

    /**
     * lista todos os alunos
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        AlunoDaoImpl alunoTest = new AlunoDaoImpl();
        AlunoView instance = new AlunoView(alunoTest);
        instance.listar();
    }
    
}
