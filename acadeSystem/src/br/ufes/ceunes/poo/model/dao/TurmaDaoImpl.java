/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Disciplina;
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
public class TurmaDaoImpl implements TurmaDao {
    
    private List<Turma> listaTurma;

    public TurmaDaoImpl() {
        this.listaTurma = new ArrayList<>();
    }
    
    @Override
    public void adicionar(Turma Turma){
        listaTurma.add(Turma);
    }
    
    @Override
    public List getAll(){//retorna a lista de Turma
        if(listaTurma == null){
            carregar();
        }
        return listaTurma;   
    }
    
    @Override
    public void carregar(){
        String nomeArquivo = "Turmas.txt";//nome do arquivo
        FileReader file;
        try {
            file = new FileReader(nomeArquivo); //abre o arquivo
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                String nome = ler.readLine();//Pega nome
                String ementa = ler.readLine();//Pega cpf
                String cargaHoraria = ler.readLine(); 
                String codigo = ler.readLine(); 
                int ncpf; 
                ncpf = Integer.parseInt(ler.readLine());
                Turma novo = new Turma(nome,ementa,cargaHoraria,codigo);
                int i;
                for(i=0;i<=ncpf;i++){
                    String cpf= ler.readLine();
                    novo.addDiscilina(cpf);
                }
                
                adicionar(novo);//Adiciona na lista
            }
            file.close();//Fecho o arquivo
            ler.close();           
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(TurmaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(TurmaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @Override
    public void salvar(){
        String nomeArquivo = "Turmas.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            for(Turma Turma : listaTurma){//percorre a lista
                salvar.write(Turma.getAno());//salva ano
                salvar.newLine();
                salvar.write(Turma.getHorario());//salva horario
                salvar.newLine();
                salvar.write(Turma.getLocal());//salva local
                salvar.newLine();
                salvar.write(Turma.getnVagas());//salva nº de vagas
                salvar.newLine();
                salvar.write(Turma.professor.getCpf());//salva o cpf do professor q da aula naquela turma
                salvar.newLine();
                salvar.write(Turma.disciplina.getCodigo());//salva o codigo da disciplina naquela turma
                
            }
            salvar.close();
            file.close();            
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(TurmaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(TurmaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
    

