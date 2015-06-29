/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Professor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
public class ProfessorDaoImpl implements ProfessorDao {
    
    private List<Professor> listaProfessor;
    int id;
    
    public ProfessorDaoImpl(){
        this.listaProfessor =new ArrayList<>();
        id=1;
        carregar();
    }
    /**
     * Adiciona um professor na lista de professores.
     * @param professor 
     */

    /**
     * Método responsavel por gerar o proximo id do professor.
     * @return retorna o id do respectivo professor que chamou.
     */
    @Override
    public int gerarProximoId(){
        return this.id;
    }
    /**
     * retorna a lista com todos os professores.
     * @return lista.
     */
    @Override
    public List getAll(){//retorna a lista de professor
        if(listaProfessor == null){
        }
        return listaProfessor;   
    }
    /**
     * Carrega todos os professores do arquivo (Professores.txt) em uma lista.
     * Ativda exceções FileNotFoundException, IOException, NumberFormatException.
     *
     */
    @Override
    public void carregar(){
        listaProfessor = new ArrayList<>();
        String nomeArquivo = "Professores.txt";//nome do arquivo
        FileReader file;
        try {
            file = new FileReader(nomeArquivo); //abre o arquivo
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            
            int idUser=0;
            String idTemp = ler.readLine();
            this.id = Integer.parseInt(idTemp)+1;
            
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                String nome = ler.readLine();//Pega nome
                String cpf = ler.readLine();//Pega cpf
                String departamento = ler.readLine();    
                idTemp = ler.readLine();
                idUser = Integer.parseInt(idTemp);
                
                Professor novo = new Professor(nome,cpf,departamento,idUser);
                listaProfessor.add(novo);//Adiciona na lista
            }
           
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
     * Pega todos os professores na lista e salva em um arquivo.
     * @param professorAdd lista de professores.
     * 
     */
    @Override
    public void salvar(Professor professorAdd){
        
        professorAdd.setId(id);
        
        listaProfessor.add(professorAdd);
        
        String nomeArquivo = "Professores.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            salvar.write(Integer.toString(this.id));
            salvar.newLine();
            for(Professor professor : listaProfessor){//percorre a lista
                salvar.write(professor.getNome());//salva nome
                salvar.newLine();
                salvar.write(professor.getCpf());//salva cpf
                salvar.newLine();
                salvar.write(professor.getDepartamento());//salva departamento
                salvar.newLine();
                salvar.write(Integer.toString(professor.getId()));//salva id
                salvar.newLine();
            }
            salvar.close();
            file.close();            
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(ProfessorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(ProfessorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        carregar();
    }
    
    
    
    /**
     * Busca na lista professores, utilizando como chave o cpf
     * @param professor Uma cópia de professor apenas com o cpf.
     * @return professor com seus dados preenchidos caso ele exista, caso contrário
     * retorna o professor com dados pendentes, sendo assim possivel indentificar
     * se ele existe ou não.
     */
    @Override
    public Professor buscarPorCpf(Professor professor) {
        for(Professor prof : listaProfessor){
            if(prof.getCpf().equals(professor.getCpf())){
                return prof;
            }
        }
        return professor;
    }
    /**
     * Busca na lista professores, utilizando como chave o id
     * @param professor Uma cópia de professor apenas com o id.
     * @return professor com seus dados preenchidos caso ele exista, caso contrário
     * retorna o professor com dados pendentes, sendo assim possivel indentificar
     * se ele existe ou não.
     */
    @Override
    public Professor buscar(Professor professor) {
        for(Professor prof : listaProfessor){
            if(prof.getId() == professor.getId()){
                return prof;
            }
        }
        return professor;
        
    }
    /**
     * Busca na lista professores, utilizando como chave o nome
     * @param professor Uma cópia de professor apenas com o nome.
     * @return professor com seus dados preenchidos caso ele exista, caso contrário
     * retorna o professor com dados pendentes, sendo assim possivel indentificar
     * se ele existe ou não.
     */
   @Override
   
    public List buscarPorNome(Professor professor) {
        List<Professor> tempList = new ArrayList<>();
        for(Professor prof : listaProfessor){
            if(prof.getNome().contains(professor.getNome())){
                tempList.add(prof);
            }
        }
        return tempList;
        
    }
    
}