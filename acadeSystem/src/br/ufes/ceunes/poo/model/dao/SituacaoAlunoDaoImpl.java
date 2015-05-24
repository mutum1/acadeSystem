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
import java.io.FileNotFoundException;
import java.io.FileReader;
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
     * @throws Operação não suportada ao carregar o arquivo.
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
                
                sId = ler.readLine();//Pega o aluno
                idUser = Integer.parseInt(sId);
                
                Turma turma = turmaAcoes.buscar(new Turma(null, null, null, null, 0, null, null, idUser));
                
                Integer nIds;
                String nIdTemp = ler.readLine();
                nIds = Integer.parseInt(nIdTemp);
               
                SituacaoAluno situacaoAluno = new SituacaoAluno(aluno, turma, id);
                
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
            Logger.getLogger(ProfessorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex){
            id=1;
            return;
        }  
    }
    /**
     * @throws Operação não suportada ao salvar o arquivo.
     */
    @Override
    public void salvar(SituacaoAluno situacao) {
      
        
    }
    /**
     * @throws Operação não suportada ao adicionar uma nota.
     */
    @Override
    public void addNota(int idTruma, int idAtividade, int idAluno, int nota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @throws Operação não suportada ao adicionar uma presença ao aluno.
     */
    @Override
    public void addPresenca(int idTruma, int idAluno, Float presenca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @throws Operação não suportada ao solicitar a nota final do aluno.
     */
    @Override
    public float getNotaFinal(int idTruma, int idAluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @throws Operação não suportada ao solicitar as presenças do aluno.
     */
    @Override
    public float getPresenca(int idTruma, int idAluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int gerarProximoId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
