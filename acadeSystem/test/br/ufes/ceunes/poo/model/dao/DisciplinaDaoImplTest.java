/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Disciplina;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class DisciplinaDaoImplTest {

    /**
     * Pega todos os dados da Lista.
     */
    @Test
    public void testGetAll() {
        System.out.println("get All");
        DisciplinaDaoImpl instance = new DisciplinaDaoImpl(null);
        DisciplinaDaoImpl compara = instance;
        List expResult = compara.getAll();
        List result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Carrega do Arquivo.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        DisciplinaDaoImpl instance = new DisciplinaDaoImpl(null);
      //  instance.carregar();
    }

    /**
     * Salva no Arquivo.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Disciplina disciplinaTemp = new Disciplina("Prog III", "Programacao POO", "75hrs", 1);
        DisciplinaDaoImpl instance = new DisciplinaDaoImpl(null);
     //   instance.salvar(disciplinaTemp);
    }

    /**
     * Busca no arquivo.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Disciplina disciplina = new Disciplina("Calculo 3", "matematica aplicada", "90hrs", 4);
        DisciplinaDaoImpl instance = new DisciplinaDaoImpl(null);
        DisciplinaDaoImpl compara = instance;
        Disciplina expResult = compara.buscar(disciplina);
        Disciplina result = instance.buscar(disciplina);
        assertEquals(expResult, result);
    }
    
}
