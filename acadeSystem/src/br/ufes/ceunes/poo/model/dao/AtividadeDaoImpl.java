/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

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
    int id;

    public AtividadeDaoImpl(TurmaDao turmaAcoes) {
        listaAtividades = new ArrayList<>();
        this.turmaAcoes = turmaAcoes;
        id=0;
    }

    @Override
    public void carregar() {
        String nomeArquivo = "Atividades.txt";//nome do arquivo
        FileReader file;
        try {
            file = new FileReader(nomeArquivo); //abre o arquivo
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                String nome = ler.readLine();//Pega nome
                String tipo = ler.readLine();//Pega ementa
                String data = ler.readLine(); //cargaHoraria
                String idTemp = ler.readLine(); 
                int idInt = Integer.parseInt(idTemp);
                Turma turma = turmaAcoes.buscar(new Turma(null,null,null,null,0,null,null,idInt));
                String valor = ler.readLine(); 
                String nota = ler.readLine(); 
                idTemp = ler.readLine(); 
                
                Atividade novaAtividade = new Atividade(nome, tipo, data, turma, Integer.parseInt(valor), Integer.parseInt(nota), Integer.parseInt(idTemp));  
                listaAtividades.add(novaAtividade);
            }
            
            file.close();//Fecho o arquivo
            ler.close();           
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(AtividadeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(AtividadeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    @Override
    public void salvar(Atividade atividadeTemp) {
        
        listaAtividades.add(atividadeTemp);
        id++;
        String nomeArquivo = "Atividades.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            for(Atividade atividade : listaAtividades){//percorre a lista
                salvar.write(atividade.getNome());//salva nome
                salvar.newLine();
                salvar.write(atividade.getTipo());//salva a ementa
                salvar.newLine();
                salvar.write(atividade.getData());//salva carga horaria
                salvar.newLine();
                salvar.write(atividade.getTurma().getId());//salva id da turma
                salvar.newLine();
                salvar.write(atividade.getValor());//valor
                salvar.newLine();
                salvar.write(atividade.getNota());//nota
                salvar.newLine();
                salvar.write(atividade.getId());//id
                salvar.newLine();
            }
            salvar.close();
            file.close();            
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(AtividadeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(AtividadeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public Atividade buscar(Atividade atividade) {
        for(Atividade atividadeTemp : listaAtividades){
            if(atividade.getId() == atividadeTemp.getId()){
                return atividadeTemp;
            }
        }
        return atividade;
    }
 

      
}