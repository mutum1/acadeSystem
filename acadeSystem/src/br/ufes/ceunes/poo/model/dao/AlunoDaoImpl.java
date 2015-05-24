/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;
import br.ufes.ceunes.poo.model.pojo.Aluno;
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
    private Integer id;
    
    public AlunoDaoImpl(){
        this.listaAlunos =new ArrayList<>();
        id=1;
        carregar();
    }
    /**
     * Adiciona um aluno na lista de alunos.
     * @param aluno 
     */
    
    private void adicionar(Aluno aluno){
        listaAlunos.add(aluno);
    }
    /**
     * retorna a lista dos alunos
     * @return uma lista de alunos.
     */
    @Override
    public List getAll(){
         return listaAlunos;   
    }
    /**
     * Método responsavel por gerar o proximo id.
     * @return um id.
     */
    @Override
    public int gerarProximoId(){
        return this.id;
    }
    /**
     * Métodos responsavel por carregar o arquivo para as listas.
     * Os dados estão salvos em um arquivo "Alunos.txt", percorrendo o arquivo
     * @throws Ativa exeções quando o arquivo não é encontrado, e quando o
     * id está fora do formato.
     */
    @Override
    public void carregar(){
        String nomeArquivo = "Alunos.txt";//nome do arquivo
        FileReader file;
        listaAlunos = new ArrayList<>();
        
        try {
            file = new FileReader(nomeArquivo); //abre o arquivo
            BufferedReader ler = new BufferedReader(file);//Estancio o arquivo para leitura
            
            int idUser=0;
            String idTemp = ler.readLine();
            id = Integer.parseInt(idTemp)+1;
            
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                String nome = ler.readLine();//Pega nome
                String cpf = ler.readLine();//Pega cpf
                idTemp = ler.readLine();
                idUser = Integer.parseInt(idTemp);
                
                Aluno novo = new Aluno(nome,cpf,idUser);
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
            id=1;          
            
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(ProfessorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex){
            id=1;
            return;
        }    
    }
    /**
     * Salva a lista de alunos em um arquivo.
     * @param alunoTemp 
     * Os dados são salvos em um arquivo "Alunos.txt", percorrendo a lista
     * @throws Ativa as exeções FileNotFoundException e IOException.
     */
    
    @Override
    public void salvar(Aluno alunoAdd){
        
        adicionar(alunoAdd);
        
        String nomeArquivo = "Alunos.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            salvar.write(id.toString());
            salvar.newLine();
            for(Aluno aluno : listaAlunos){//percorre a lista
                salvar.write(aluno.getNome());//salva nome
                salvar.newLine();
                salvar.write(aluno.getCpf());//salva cpf
                salvar.newLine();
                Integer idTemp = aluno.getId();
                salvar.write(idTemp.toString());//salva id
                salvar.newLine();
            }
            salvar.close();
            file.close();            
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
        carregar();
    }
    /**
     * Procura um aluno na lista, utilizando CPF como chave.
     * @param alunoTemp
     * @return aluno se encontrar, ou retorna um aluno com campos vazios
     */
    @Override
    public Aluno buscarPorCpf(Aluno alunoTemp) {
        
        for(Aluno aluno : listaAlunos){
            if(alunoTemp.getCpf().equals(aluno.getCpf())){
                return aluno;
            }
        }
        return alunoTemp;
    }

    /**
     * Busca aluno na lista, utilizando como chave o id
     * @param alunoTemp
     * @return aluno se existe ... aluno com cambos vazios caso contrario.
     */
    @Override
    public Aluno buscar(Aluno alunoTemp) {
        
        for(Aluno aluno : listaAlunos){
            if(alunoTemp.getId() == aluno.getId()){
                return aluno;
            }
        }
        return alunoTemp;
    }
    /**
     * Método que busca os aluno por nome na lista.
     * @param aluno
     * @return aluno com seus dados preenchidos caso ele exista, caso contrário
     * retorna o aluno com dados pendentes, sendo assim possivel indentificar
     * se ele existe ou não.
     */


    @Override
    public List buscarPorNome(Aluno aluno) {
        List<Aluno> tempList = new ArrayList<>();
        for(Aluno alunoTemp : listaAlunos){
            if(alunoTemp.getNome().contains(aluno.getNome())){
                tempList.add(alunoTemp);
            }
        }
        return tempList;
        
    }
}
