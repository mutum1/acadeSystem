/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
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
public class DisciplinaDaoImpl implements DisciplinaDao {
    private List<Disciplina> listaDisciplina;
    private ProfessorDao professorDao;
    int id;

    public DisciplinaDaoImpl(ProfessorDao professorDao) {
        id=0;
        this.listaDisciplina = new ArrayList<>();
        this.professorDao = professorDao;
        carregar();
    }
    /**
     * Adiciona uma disciplina a lista de disciplinas
     * @param disciplina 
     */ 
  
    private void adicionar(Disciplina disciplina){
        listaDisciplina.add(disciplina);
    }
    /*
    @return retorna a lista de disciplinas.
    */
    @Override
    public List getAll(){//retorna a lista de disciplina
        return listaDisciplina;   
    }
    @Override
    public int gerarProximoId(){
        return this.id;
    }
    /**
     * Carrega do arquivo todas as disciplinas e coloca em uma lista 
     * "Disciplina.txt".
     * Ativas as exceções FileNotFoundException, IOException, NumberFormatException.
     */
    @Override
    public void carregar(){
        listaDisciplina = new ArrayList<>();
        String nomeArquivo = "Disciplinas.txt";//nome do arquivo
        FileReader file;
        try {
            file = new FileReader(nomeArquivo); //abre o arquivo
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            
            String idTemp = ler.readLine();
            id = Integer.parseInt(idTemp)+1;
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                String nome = ler.readLine();//Pega nome
                String ementa = ler.readLine();//Pega ementa
                String cargaHoraria = ler.readLine(); //cargaHoraria
                String id = ler.readLine(); 
                Integer nIds;
                String nIdTemp = ler.readLine();
                nIds = Integer.parseInt(nIdTemp);
                Disciplina novaDisciplina = new Disciplina(nome,ementa,cargaHoraria,Integer.parseInt(id));
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
    public void salvar(Disciplina disciplinaAdd){
        
        disciplinaAdd.setId(id);
        
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
    
     
  
    /**
     * Busca uma disciplina na lista utilizando como chave o id.
     * @param disciplina Uma cópia de disciplina apenas com o id.
     * @return lista buscada, caso contrario lista com campos vazios.
     */
    @Override
    public Disciplina buscar(Disciplina disciplina) {
        for(Disciplina disciplinaTemp : listaDisciplina){
            if(disciplina.getId() == disciplinaTemp.getId()){
                return disciplinaTemp;
            }
        }
        return disciplina;
    }
    /**
     * Método que busca as disciplinas por nome na lista.
     * @param disciplinaTemp Uma cópia de disciplina apenas com o nome dela.
     * @return a disciplina com seus dados preenchidos caso ele exista, caso contrário
     * retorna a disciplina com dados pendentes, sendo assim possivel indentificar
     * se ele existe ou não.
     */
    @Override
    public Disciplina buscarPorNome(Disciplina disciplinaTemp) {
        
        for(Disciplina disciplina : listaDisciplina){
            if(disciplinaTemp.getNome().equals(disciplina.getNome())){
                return disciplina;
            }
        }
        return disciplinaTemp;
    }

}
