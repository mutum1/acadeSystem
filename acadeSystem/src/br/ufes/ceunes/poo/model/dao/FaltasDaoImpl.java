/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Atividade;
import br.ufes.ceunes.poo.model.pojo.Faltas;
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
 * @author Rhaister
 */
public class FaltasDaoImpl implements FaltasDao{
    private List<Faltas> listaFaltas;
    private TurmaDao turmaAcoes;
    private AlunoDao alunoAcoes;
    int id;
    /**
     * Carrega do arquivo todas as faltas e coloca em uma lista 
     * "Disciplina.txt".
     * Ativas as exceções FileNotFoundException, IOException, NumberFormatException.
     */
    @Override
    public void carregar(){
        listaFaltas = new ArrayList<>();
        String nomeArquivo = "Faltas.txt";//nome do arquivo
        FileReader file;
        try {
            file = new FileReader(nomeArquivo); //abre o arquivo
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            
            String idTemp = ler.readLine();
            id = Integer.parseInt(idTemp)+1;
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                idTemp = ler.readLine(); 
                int idInt = Integer.parseInt(idTemp);
                            
                String idBusca = ler.readLine(); //pega id da turma
                int idBusc = Integer.parseInt(idBusca);
                
                Turma turma = turmaAcoes.buscar(new Turma(null,null,null,null,0,null,null,idBusc));
                
                idBusca =ler.readLine();
                idBusc = Integer.parseInt(idBusca);
                
                Aluno aluno = alunoAcoes.buscar(new Aluno(null,null,idBusc));
                
                Faltas novaFalta = new Faltas(idInt, aluno,turma);      
                
                listaFaltas.add(novaFalta);
            }    
            file.close();//Fecho o arquivo
            ler.close();           
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            id=1;          
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex){
            id=1;
            return;
        } 
    }
    /**
     * Salva todas as disciplinas de uma lista em um arquivo Disciplina.txt.
     * @param faltas
     * Ativda exceções FileNotFoundException, IOException.
     */
    @Override
    public void salvar(Faltas faltas) {
        
        listaFaltas.add(faltas);
        
        String nomeArquivo = "Faltas.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            
            salvar.write(Integer.toString(id));
            salvar.newLine();
            
            for(Faltas falta : listaFaltas){//percorre a lista
                
                salvar.write(Integer.toString(falta.getId()));//id
                salvar.newLine();
                salvar.write(Integer.toString(falta.getTurma().getId()));//salva id da turma
                salvar.newLine();
                salvar.write(Integer.toString(falta.getAluno().getId()));//salva id do aluno
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
}
    
