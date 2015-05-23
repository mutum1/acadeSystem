/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.SituacaoAluno;

/**
 * Classe responsavel pelas exceções dos processos padroes, como salvas, carregar
 * @author paulo
 */
public class SituacaoAlunoDaoImpl implements SituacaoAlunoDao {
    /**
     * @throws Operação não suportada ao carregar o arquivo.
     */
    @Override
    public void carregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @throws Operação não suportada ao salvar o arquivo.
     */
    @Override
    public void salvar(SituacaoAluno situacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @throws Operação não suportada ao adicionar uma nota.
     */
    @Override
    public void addNota(int idTruma, int idAtividade, int idAluno, int nota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @throws Operação não suportada ao adicionar uma presença ao aluno.
     */
    @Override
    public void addPresenca(int idTruma, int idAluno, Float presenca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @throws Operação não suportada ao solicitar a nota final do aluno.
     */
    @Override
    public float getNotaFinal(int idTruma, int idAluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @throws Operação não suportada ao solicitar as presenças do aluno.
     */
    @Override
    public float getPresenca(int idTruma, int idAluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
