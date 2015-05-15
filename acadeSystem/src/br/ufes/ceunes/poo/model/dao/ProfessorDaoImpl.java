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
    
    private void adicionar(Professor professor){
        listaProfessor.add(professor);
    }
    
    @Override
    public List getAll(){//retorna a lista de professor
        if(listaProfessor == null){
            carregar();
        }
        return listaProfessor;   
    }
    
    @Override
    public void carregar(){
        String nomeArquivo = "Professores.txt";//nome do arquivo
        FileReader file;
        try {
            file = new FileReader(nomeArquivo); //abre o arquivo
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            
            int idUser=0;
            String idTemp = ler.readLine();
            id = Integer.parseInt(idTemp)+1;
            
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                String nome = ler.readLine();//Pega nome
                String cpf = ler.readLine();//Pega cpf
                String departamento = ler.readLine();    
                idTemp = ler.readLine();
                idUser = Integer.parseInt(idTemp);
                
                Professor novo = new Professor(nome,cpf,departamento,idUser);
                adicionar(novo);//Adiciona na lista
            }
            
            
            if((id-1)== (idUser)){//verifica se os ids estao certos
                System.out.println("\n ID'S CERTOS\n");
            }
            else
                System.out.println("\n ID'S errados\n id usuario:"+idUser+"\n id set:"+id);
            
            file.close();//Fecho o arquivo
            ler.close();           
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(ProfessorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(ProfessorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @Override
    public void salvar(Professor professorTemp){
        adicionar(professorTemp);
        id++;
        
        String nomeArquivo = "Professores.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            salvar.write(id);
            for(Professor professor : listaProfessor){//percorre a lista
                salvar.write(professor.getNome());//salva nome
                salvar.newLine();
                salvar.write(professor.getCpf());//salva cpf
                salvar.newLine();
                salvar.write(professor.getDepartamento());//salva departamento
                salvar.newLine();
                salvar.write(professor.getId());//salva id
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

    @Override
    public Professor buscaProfessor(Professor professor) {
        for(Professor prof : listaProfessor){
            if(prof.getCpf().equals(professor.getCpf())){
                return prof;
            }
        }
        return professor;
    }
    
}
