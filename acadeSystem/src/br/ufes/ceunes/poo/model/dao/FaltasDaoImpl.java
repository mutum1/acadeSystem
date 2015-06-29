/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Faltas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rhaister
 */
public class FaltasDaoImpl implements FaltasDao{
    private List<Faltas> listaFaltas;
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
                String aluno = ler.readLine();//Pega nome
                String turma = ler.readLine();//Pega turma
               // String cargaHoraria = ler.readLine(); //cargaHoraria
                String id = ler.readLine(); 
                Integer nIds;
                String nIdTemp = ler.readLine();
                nIds = Integer.parseInt(nIdTemp);
                Faltas falta = new Faltas(Integer.parseInt(id), aluno, turma);
                int i;
                for(i=0;i<nIds;i++){
                    nIdTemp = ler.readLine();
                    int idsTemp= Integer.parseInt(nIdTemp);
                    Professor professor=new Professor(null,null,null,idsTemp);
                    professor = professorDao.buscar(professor);
                    novaDisciplina.addProfessor(professor);
                    professor.addDiscilina(novaDisciplina);
                }
                
                adicionar(novaDisciplina);//Adiciona na lista
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
     * Salva todas as disciplinas de uma lista em um arquivo Disciplina.txt.
     * @param disciplinaAdd lista de disciplinas.
     * Ativda exceções FileNotFoundException, IOException.
     */
    @Override
    public void salvar(Faltas falta){
        adicionar(disciplinaAdd);
        
        String nomeArquivo = "Disciplinas.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            salvar.write(Integer.toString(id));
            salvar.newLine();
            for(Disciplina disciplina : listaDisciplina){//percorre a lista
                salvar.write(disciplina.getNome());//salva nome
                salvar.newLine();
                salvar.write(disciplina.getEmenta());//salva a ementa
                salvar.newLine();
                salvar.write(disciplina.getCargaHoraria());//salva carga horaria
                salvar.newLine();
                salvar.write(Integer.toString(disciplina.getId()));//salva o id da disciplina
                salvar.newLine();
                String numerosDeCpdfs=""+disciplina.listaProfessor().size();
                
                salvar.write(numerosDeCpdfs);//quantos cpfs tem na lista de cpfs
                
                salvar.newLine();
                for(Professor professor : disciplina.listaProfessor() ){ 
                    salvar.write(professor.getId());//salva um por um o q esta na lista de professores
                    salvar.newLine();
                }
                
            }
            salvar.close();
            file.close();            
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(DisciplinaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(DisciplinaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
        carregar();
    }    
}
