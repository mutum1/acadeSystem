/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.model.pojo;

import java.util.List;

/**
 *
 * @author paulo
 */
public class Atividade {
    // ATRIBUTOS
    private String nome;
    private String tipo;
    private String data;
    private Turma turma;
    private float valor;
    private float nota;
    private int id;
      
    /**
     * Converte todos os valores da turma para string.
     * @return string concatenada
     */
    @Override
    public String toString(){
        return "Atividade "+nome+":"+
               "\nTurma: "+this.turma.getNomeTurma()+
               "\nTipo:  "+this.tipo+
               "\nData:  "+this.data+
               "\nValor  "+this.valor+
               "\nID:    "+this.id; 
               
    }
    /**
     * Contrutor de atividade, que instancia a atividade e atribui a nota.
     * @param nota nota da atividade.
     * @return a atividade com a nota.
     */
    public Atividade copiaComNota(float nota){
        Atividade atividade = new Atividade(this.nome, this.tipo, this.data, this.turma, this.valor, this.id);
        atividade.nota=nota;
        return atividade;
    }
    /**
     * Construtor da atividade, inicializa todos os valores.
     * @param nome nome da atividade.
     * @param tipo tipo da atividade.
     * @param data a data que foi passada.
     * @param turma turma ao qual se refere.
     * @param valor o quanto vale a atividade.
     * @param id o id da atividade.
     */
    public Atividade(String nome, String tipo, String data,Turma turma ,float valor, int id) {
        this.turma =turma;
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.nota = 0;
        this.id = id;
    }
    /**
     * Pega o nome da atividade.
     * @return o nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Pega o tipo da atividade.
     * @return o tipo da turma.
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * pega a data da atividade.
     * @return a data.
     */
    public String getData() {
        return data;
    }
    /**
     * pega a nota refirida a atividade.
     * @return a nota.
     */
    public float getNota() {
        return nota;
    }
    
    /**
     * pega o valor da atividade.
     * @return o valor.
     */
    public float getValor() {
        return valor;
    }

    /**
     * Altera o valor da atividade.
     * @param valor nota posterior.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
    /**
     * pega a turma.
     * @return a turma inteira.
     */
    public Turma getTurma() {
        return turma;
    }

    
    /**
     * Retorna o ID da Atividade
     * @return o id.
     */
    public int getId() {
        return id;
    } 
    /**
     *muda a nota da atividade. 
     * @param nota nota da atividade.
     */
    public void setNota(float nota) {
        this.nota = nota;
    }
    public void aplicarAosAlunos(){
        List<Aluno> alunos = turma.getListaAlunos();
        for(Aluno aluno : alunos){
            SituacaoAluno situacaoAluno = aluno.getSituacaoAluno(turma);
            situacaoAluno.addAtividade(this.copiaComNota(0));
        }
    }
        
}
