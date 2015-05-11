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

public class AlunoDaoImpl implements AlunoDao {
    
    private List<Aluno> listaAlunos;
    
    public AlunoDaoImpl(){
        this.listaAlunos =new ArrayList<>();
    }
    
    @Override
    public void adicionar(Aluno aluno){
        listaAlunos.add(aluno);
    }
    @Override
    public List getAll(){//retorna a lista de alunos
        if(listaAlunos == null){
            carregar();
        }
        return listaAlunos;   
    }
    
    @Override
    public void carregar(){
        String nomeArquivo = "Alunos.txt";//nome do arquivox    
        FileReader file;
        
        try {
            file = new FileReader(nomeArquivo); //abre o arquivo
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                String nome = ler.readLine();//Pega nome
                String cpf = ler.readLine();//Pega cpf
            
                Aluno novo = new Aluno(nome,cpf);
                adicionar(novo);//Adiciona na lista
            }
            file.close();//Fecho o arquivo
            ler.close();           
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @Override
    public void salvar(){
        String nomeArquivo = "Alunos.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            for(Aluno aluno : listaAlunos){//percorre a lista
                salvar.write(aluno.getNome());//salva nome
                salvar.newLine();
                salvar.write(aluno.getCpf());//salva cpf
                salvar.newLine();
            }
            salvar.close();
            file.close();            
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public Aluno buscaAluno(Aluno alunoTemp) {
        
        for(Aluno aluno : listaAlunos){
            if(alunoTemp.getCpf().equals(aluno.getCpf())){
                return aluno;
            }
        }
        return alunoTemp;
        //confere isso aqui MUTUM
    }
}
