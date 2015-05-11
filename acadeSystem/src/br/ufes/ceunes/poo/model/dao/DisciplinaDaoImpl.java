/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
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
    

    public DisciplinaDaoImpl() {
        this.listaDisciplina = new ArrayList<>();
    }
    
    @Override
    public void adicionar(Disciplina disciplina){
        listaDisciplina.add(disciplina);
    }
    
    @Override
    public List getAll(){//retorna a lista de disciplina
        if(listaDisciplina == null){
            carregar();
        }
        return listaDisciplina;   
    }
    
    @Override
    public void carregar(){
        String nomeArquivo = "Disciplinas.txt";//nome do arquivo
        FileReader file;
        try {
            file = new FileReader(nomeArquivo); //abre o arquivo
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                String nome = ler.readLine();//Pega nome
                String ementa = ler.readLine();//Pega cpf
                String cargaHoraria = ler.readLine(); 
                String codigo = ler.readLine(); 
                Integer ncpf;
                String ncpfTemp = ler.readLine();
                ncpf = Integer.parseInt(ncpfTemp);
                Disciplina novo = new Disciplina(nome,ementa,cargaHoraria,codigo);
                int i;
                for(i=0;i<ncpf;i++){
                    String cpf= ler.readLine();
                    Professor professor=new Professor(null,cpf,null);
                    
                    novo.addProfessor(professor);
                }
                
                adicionar(novo);//Adiciona na lista
            }
            file.close();//Fecho o arquivo
            ler.close();           
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(DisciplinaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(DisciplinaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @Override
    public void salvar(){
        String nomeArquivo = "Disciplinas.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            for(Disciplina disciplina : listaDisciplina){//percorre a lista
                salvar.write(disciplina.getNome());//salva nome
                salvar.newLine();
                salvar.write(disciplina.getEmenta());//salva a ementa
                salvar.newLine();
                salvar.write(disciplina.getCargaHoraria());//salva carga horaria
                salvar.newLine();
                salvar.write(disciplina.getCodigo());//salva carga horaria
                salvar.newLine();
                String numerosDeCpdfs=""+disciplina.listaProfessor().size();
                
                salvar.write(numerosDeCpdfs);//quantos cpfs tem na lista de cpfs
                salvar.newLine();
                for(Professor professor : disciplina.listaProfessor() ){ 
                    salvar.write(professor.getCpf());//salva um por um o q esta na lista de cpfs
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
    }
    @Override
    public Disciplina buscaDisciplina(Disciplina disciplina) {
        for(Disciplina diciplinaTemp : listaDisciplina){
            if(disciplina.getCodigo().equals(diciplinaTemp.getCodigo())){
                return disciplina;
            }
        }
        return disciplina;
    }

}

