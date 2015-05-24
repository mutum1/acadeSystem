/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Atividade;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.pojo.SituacaoAluno;
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
 * Classe responsavel pelas exceções dos processos padroes, como salvas, carregar
 * @author paulo
 */
public class SituacaoAlunoDaoImpl implements SituacaoAlunoDao {
    
    List<SituacaoAluno> listaSituacoes;
    AlunoDao alunoAcoes;
    AtividadeDao atividadeAcoes;
    TurmaDao turmaAcoes;
    int id;
    
    public SituacaoAlunoDaoImpl(AlunoDao alunoDao, AtividadeDao atividadeDao,TurmaDao turmaDao){
        listaSituacoes = new ArrayList<>();
        this.alunoAcoes = alunoDao;
        this.atividadeAcoes=atividadeDao;
        turmaAcoes=turmaDao;
        id=0;
    }
    /**
     * Método responsavel por carregar os dados do arquivo ("Situacoes.txt") para
     * a lista.
     * Ativa as exceções FileNotFoundException, IOException, NumberFormatException.
     */
    @Override
    public void carregar() {
        listaSituacoes = new ArrayList<>();
        String nomeArquivo = "Situacoes.txt";//nome do arquivo
        FileReader file;
        try {
            file = new FileReader(nomeArquivo); //abre o arquivo
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            
            int idUser=0;
            String idTemp = ler.readLine();
            this.id = Integer.parseInt(idTemp)+1;
            
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                
                String sFalta = ler.readLine();//Pega falta
                int falta = Integer.parseInt(sFalta);
               
                String sId = ler.readLine();//Pega o aluno
                idUser = Integer.parseInt(sId);
                Aluno aluno = alunoAcoes.buscar(new Aluno(null,null,idUser));
                
                sId = ler.readLine();//Pega a turma
                idUser = Integer.parseInt(sId);
                
                Turma turma = turmaAcoes.buscar(new Turma(null, null, null, null, 0, null, null, idUser));
                
                sId = ler.readLine();//Pega id da situação
                idUser = Integer.parseInt(sId);
                                            
                SituacaoAluno situacaoAluno = new SituacaoAluno(aluno, turma, idUser);
                
                Integer nIds;
                String nIdTemp = ler.readLine();
                nIds = Integer.parseInt(nIdTemp);
                
                int i;
                for(i=0;i<nIds;i++){
                    nIdTemp = ler.readLine();
                    int idsTemp= Integer.parseInt(nIdTemp);
                    Atividade atividade =atividadeAcoes.buscar(new Atividade(null, null, null, null, 0, idsTemp));
                    
                    String notaTemp = ler.readLine();
                    float nota= Float.parseFloat(notaTemp);
                    atividade = atividade.copiaComNota(nota);
                    situacaoAluno.addAtividade(atividade);
                }
                aluno.addSituacao(situacaoAluno);
                listaSituacoes.add(situacaoAluno);
                
            }
            
            file.close();//Fecho o arquivo
            ler.close();           
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            id=1;          
            
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(SituacaoAlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex){
            id=1;
            return;
        }  
    }
    
     public void salvar(SituacaoAluno situacao) {
        listaSituacoes.add(situacao);
        salvar();
     }
    /**
     * Método responsavel por salvar as situação do aluno em uma determinada turma.
     * Ativa as exceções UnsupportedOperationException, Operação não suportada ao salvar o arquivo.
     */
    @Override
    public void salvar() {
   
      
        String nomeArquivo = "Situacoes.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            
            salvar.write(Integer.toString(id));
            salvar.newLine();
            
            for(SituacaoAluno situacoes : listaSituacoes){//percorre a lista
                salvar.write(Integer.toString(situacoes.getFaltas()));//salva faltas
                salvar.newLine();
                salvar.write(Integer.toString(situacoes.getAluno().getId()));//salva id aluno
                salvar.newLine();
                salvar.write(Integer.toString(situacoes.getTurma().getId()));//salva carga horaria
                salvar.newLine();
                salvar.write(Integer.toString(situacoes.getId()));//salva o id da disciplina
                salvar.newLine();
                String numerosDeAtividades=""+situacoes.getAtividade().size();
                
                salvar.write(numerosDeAtividades);//quantos cpfs tem na lista de cpfs
                
                salvar.newLine();

                for(Atividade atividade : situacoes.getAtividade()){ 
                    salvar.write(Integer.toString(atividade.getId()));//salva um por um o q esta na lista de atividadees
                    salvar.newLine();
                    salvar.write(Float.toString(atividade.getNota()));//salva um por um o q esta na lista de atividadees
                    salvar.newLine();
                }
            }         
            salvar.close();
            file.close();            
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(SituacaoAlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex); 
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(SituacaoAlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
        carregar();
    }
    /**
     * Ativa as exceções Operação não suportada ao adicionar uma nota.
     */
    @Override
    public void addNota(Turma turma, Aluno aluno, Atividade atividade, int nota) {
        Atividade atividadeAdd = buscarAtividade(turma.getId(), aluno.getId(), atividade.getId());
        atividadeAdd.setNota(nota);
    }
    
    
    @Override
    public void addPresenca(Turma turma, Aluno aluno, int fatas) {
        SituacaoAluno situacaoAluno = buscarSituacaoAluno(turma.getId(),aluno.getId());
        situacaoAluno.setFaltas(fatas);
    }
    /**
     * exceção: Operação não suportada ao solicitar a nota final do aluno.
     */
    @Override
    public float getNotaFinal(Turma turma, Aluno aluno) {
        float nota=0;
        int numeroAtividades=0;
        SituacaoAluno situacaoAluno = buscarSituacaoAluno(turma.getId(),aluno.getId());
        numeroAtividades=situacaoAluno.getAtividade().size();
        for(Atividade atividade : situacaoAluno.getAtividade()){
            nota = nota+atividade.getNota();
        }
        nota=nota/numeroAtividades;
        return nota;
    }
    /**
     * procura nas situações do aluno a relação de presenta do mesmo.
     * Exceção Operação não suportada ao solicitar as presenças do aluno.
     */
    @Override
    public float getPresenca(Turma turma, Aluno aluno) {
        SituacaoAluno situacaoAluno = buscarSituacaoAluno(turma.getId(),aluno.getId());
        return situacaoAluno.getFaltas();
    }
    /**
     * Gera o proximo id da situação do aluno.
     * @return o id.
     */
    @Override
    public int gerarProximoId() {
        this.id++;
        return id-1;
    }
    /**
     * 
     * @param idTurma id da respectiva turma.
     * @param idAluno id do respectivo aluno.
     * @param idAtividade id da respectivda atividade.
     * @return atividade do aluno da turma.
     */
    public Atividade buscarAtividade(int idTurma, int idAluno, int idAtividade){
        for(SituacaoAluno situacaoAluno : listaSituacoes){
            if(idTurma==situacaoAluno.getTurma().getId() && idAluno==situacaoAluno.getAluno().getId()){
                for(Atividade atividade : situacaoAluno.getAtividade()){
                    if(atividade.getId()==idAtividade){
                        return atividade;
                    }
                }
            }
        }
        return null;
    }
    
    public SituacaoAluno buscarSituacaoAluno (int idTurma, int idAluno){
        for(SituacaoAluno situacaoAluno : listaSituacoes){
            if(idTurma==situacaoAluno.getTurma().getId() && idAluno==situacaoAluno.getAluno().getId()){
                return situacaoAluno;
            }
        }
        return null;
        
    }
}
