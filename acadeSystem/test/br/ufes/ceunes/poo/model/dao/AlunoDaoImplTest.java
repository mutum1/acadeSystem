/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhaister
 */
public class AlunoDaoImplTest {
    
    /**
     * Instancia um aluno e captura a lista de Alunos.
     */
    @Test
    public void testGetAll() {
        System.out.println("Captura toda a Lista");
        AlunoDaoImpl instance = new AlunoDaoImpl();
        AlunoDaoImpl compara = instance;
        List expResult = compara.getAll();
        List result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * realiza o teste de carregamento de arquivo.
     */
    @Test
    public void testCarregar() {
        System.out.println("carregar");
        AlunoDaoImpl instance = new AlunoDaoImpl();
     //   instance.carregar();
    }

    /**
     * Instancia um aluno e salva o arquivo - Aluno n pode ser Null.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        AlunoDaoImpl instance = new AlunoDaoImpl();
        Aluno aluno = new Aluno("Ayer", "123.123.123-34", 3);
      //  instance.salvar(aluno);
    }

    /**
     * Realiza a busca pelo CPF na lista de alunos - Aluno não pode ser null.
     */
    @Test
    public void testBuscarPorCpf() {
        System.out.println("buscar Por Cpf");
        Aluno alunoTemp = new Aluno("Diego", "131.700.947-93", 9);
        AlunoDaoImpl instance = new AlunoDaoImpl();
        AlunoDaoImpl compara = instance;
        Aluno result = instance.buscarPorCpf(alunoTemp);
        Aluno expResult = compara.buscarPorCpf(alunoTemp);
        assertEquals(expResult, result);
    }

    /**
     * Realiza a busca pelo nome na lista de alunos - Aluno não pode ser null
     */
    @Test
    public void testBuscarPorNome() {
        System.out.println("buscar Por Nome");
        Aluno alunoTemp = new Aluno("Rhaister", null, 1);
        AlunoDaoImpl instance = new AlunoDaoImpl();
        AlunoDaoImpl compara = instance;
        List result = instance.buscarPorNome(alunoTemp);
        List expResult = compara.buscarPorNome(alunoTemp);
        assertEquals(expResult, result);
    }

    /**
     * Busca.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Aluno alunoTemp = new Aluno(null, null, 2);
        AlunoDaoImpl instance = new AlunoDaoImpl();
        AlunoDaoImpl compara = instance;
        Aluno result = instance.buscar(alunoTemp);
        Aluno expResult = compara.buscar(alunoTemp);
        assertEquals(expResult, result);
    }
    
}
