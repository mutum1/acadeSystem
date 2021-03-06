/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Atividade;
import br.ufes.ceunes.poo.model.pojo.Turma;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulo
 */
public class AtividadeDaoImpl implements AtividadeDao {
    List<Atividade> listaAtividades;
    private TurmaDao turmaAcoes;
    private AlunoDao alunoAcoes;
    int id;

    public AtividadeDaoImpl(TurmaDao turmaAcoes, AlunoDao alunoAcoes) {
        listaAtividades = new ArrayList<>();
        this.alunoAcoes = alunoAcoes;
        this.turmaAcoes = turmaAcoes;
        id=0;
        carregar();
    }

    /**
     * Carrega todos as atividades do arquivo na lista de atividades
     * os dados são pegos no arquivo "Atividades.txt".
     * Ativa as exceções FileNotFoundException, IOException, NumberFormatException.
     */
    public void carregar() {
        listaAtividades = new ArrayList<>();
        String nomeArquivo = "Atividades.txt";//nome do arquivo
        FileReader file;
        
        try {
            file = new FileReader(nomeArquivo); //abre o arquivo
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
                        
            String idTemp = ler.readLine();
            id = Integer.parseInt(idTemp)+1;
            
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                idTemp = ler.readLine(); 
                int idInt = Integer.parseInt(idTemp);
                
                String nome = ler.readLine();//Pega nome
                String tipo = ler.readLine();//Pega tipo
                String data = ler.readLine(); //data
              
                String valor = ler.readLine(); //valor 
                String nota = ler.readLine(); //nota
                
                String idBusca = ler.readLine(); //pega id da turma
                int idBusc = Integer.parseInt(idBusca);
                
                Turma turma = turmaAcoes.buscar(new Turma(null,null,null,null,0,null,null,idBusc));
                
                idBusca =ler.readLine();
                idBusc = Integer.parseInt(idBusca);
                
                Aluno aluno = alunoAcoes.buscar(new Aluno(null,null,idBusc));
                
                Atividade novaAtividade = new Atividade(nome, tipo, data, turma,aluno, Float.parseFloat(valor),Float.parseFloat(nota), Integer.parseInt(idTemp));      
                
                listaAtividades.add(novaAtividade);
                
            }
            
            file.close();//Fecho o arquivo
            ler.close();           
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            id=1;          
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(ProfessorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex){
            id=1;
            return;
        } 
        
    }
    /**
     * Pegar todas as atividades na lista e salva dentro de um arquivo 
     * "Atividades.txt".
     * @param atividadeTemp.
     * Ativa as exceções FileNotFoundException, IOException.
     */
    
    void aplicaAtividade(Atividade atividade){
        List<Aluno> alunos = atividade.getTurma().getListaAlunos();
        
        for(Aluno aluno : alunos){
            Atividade newAtividade = new Atividade(atividade.getNome(), atividade.getTipo(),atividade.getData(), atividade.getTurma(), aluno, atividade.getValor(), id);
            listaAtividades.add(newAtividade);
            id++;
        }
        
    }
    
    @Override
    public void salvar(Atividade atividadeTemp) {
        
        
        aplicaAtividade(atividadeTemp);
        
        String nomeArquivo = "Atividades.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            
            salvar.write(Integer.toString(id));
            salvar.newLine();
            
            for(Atividade atividade : listaAtividades){//percorre a lista
                
                salvar.write(Integer.toString(atividade.getId()));//id
                salvar.newLine();
                salvar.write(atividade.getNome());//salva nome
                salvar.newLine();
                salvar.write(atividade.getTipo());//salva a tipo
                salvar.newLine();
                salvar.write(atividade.getData());//salva data
                salvar.newLine();
                salvar.write(Float.toString(atividade.getValor()));//valor
                salvar.newLine();
                salvar.write(Float.toString(atividade.getNota()));//nota
                salvar.newLine();
                salvar.write(Integer.toString(atividade.getTurma().getId()));//salva id da turma
                salvar.newLine();
                salvar.write(Integer.toString(atividade.getAluno().getId()));//salva id do aluno
                salvar.newLine();

            }
            salvar.close();
            file.close();            
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(AtividadeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(AtividadeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        carregar();
    }
    
    /**
     * Busca a atividade utilizando como chave o id.
     * @param atividade Uma cópia da atividade apenas com o id.
     * @return a atividade de interesse, ou um atividade com campos vazios
     */
    @Override
    public Atividade buscar(Atividade atividade) {
        for(Atividade atividadeTemp : listaAtividades){
            if(atividade.getId() == atividadeTemp.getId()){
                return atividadeTemp;
            }
        }
        return atividade;
    }

    /**
     * @return retorna a lista de todas as atividades.
     */
    @Override
    public List getAll() {
        return listaAtividades;
    }
 

      
}
