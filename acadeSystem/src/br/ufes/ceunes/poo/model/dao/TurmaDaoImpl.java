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
import br.ufes.ceunes.poo.model.pojo.Turma;
import com.sun.javafx.scene.control.skin.VirtualFlow;
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
    private ProfessorDao professorAcoes;
    private DisciplinaDao disciplinaAcoes;
    private AlunoDao alunoAcoes;
    private AtividadeDao atividadeAcoes;

    public TurmaDaoImpl(ProfessorDao professorAcoes, DisciplinaDao disciplinaAcoes, AlunoDao alunoAcoes,AtividadeDao atividadeAcoes) {
        this.listaTurma = new ArrayList<>();
        this.professorAcoes = professorAcoes;
        this.disciplinaAcoes = disciplinaAcoes;
        this.alunoAcoes = alunoAcoes;
        this.atividadeAcoes =atividadeAcoes;
    }

         
    

    private void adicionar(Turma turma){
        listaTurma.add(turma);
    }
    
    @Override
    public List getAll(){//retorna a lista de turma
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
            int i;
            int nVagas;
            int nAlunos;
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                String ano = ler.readLine();//Pega ano
                String periodo = ler.readLine();//Pega periodo
                String local = ler.readLine(); //pega o local
                String horario = ler.readLine(); //pega o horario
                String SnVagas= ler.readLine(); //pega o numero de vagas
                nVagas= Integer.parseInt(SnVagas); //converte a string para inteiro
                String idProfessor = ler.readLine(); //pega o cpf do professor
                String idDisciplina = ler.readLine(); //pega pega o codigo daquela diciplina
                String idTemp = ler.readLine(); //pega pega o codigo daquela diciplina
                
                Professor professor = new Professor(null,null,null,Integer.parseInt(idProfessor));//cria um objeto do tipo professor
                professor = professorAcoes.buscar(professor);//procura o professor na lista de professores e adiciona e ele na turma
                
                Disciplina disciplina = new Disciplina(null,null,null,Integer.parseInt(idDisciplina));// cria um objeto do tipo disciplina e coloca so o codigo no objeto
                disciplina = disciplinaAcoes.buscar(disciplina);//busca a disciplina com aquele codigo e completa as informaçoes do objeto
                Turma novaTurma = new Turma(ano, periodo, local, horario,nVagas,professor,disciplina,Integer.parseInt(idTemp));//cria a turma e salva as informaçoes no objeto
                
                nAlunos = Integer.parseInt(ler.readLine());// pega a quantidade de alunos naquela turma
                
                for(i=0; i<nAlunos; i++){//pega no arquivo os alunos daquela turma so o cpf busca as outras informaçoes completas elas e add na lista da turma
                    idTemp= ler.readLine();
                    Aluno aluno =new Aluno(null,null,Integer.parseInt(idTemp));
                    aluno = alunoAcoes.buscar(aluno);
                    novaTurma.addAluno(aluno);
                }
                adicionar(novaTurma);//Adiciona na lista
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
    public void salvar(Turma turmaTemp){
        
        
        String nomeArquivo = "Turmas.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            int size;
            for(Turma turma : listaTurma){//percorre a lista
                salvar.write(turma.getAno());//salva ano
                salvar.newLine();
                salvar.write(turma.getPeriodo());//salva perido
                salvar.newLine();
                salvar.write(turma.getLocal());//salva local
                salvar.newLine();
                salvar.write(turma.getHorario());//salva o horario
                salvar.newLine();
                salvar.write(turma.getnVagas());//salva nº de vagas
                salvar.newLine();
                salvar.write(turma.getProfessor().getId());//salva o id do professor q da aula naquela turma
                salvar.newLine();
                salvar.write(turma.getDisciplina().getId());//salva o codigo da disciplina naquela turma
                salvar.newLine();
                size=turma.getListaAlunos().size();
                salvar.write(size);//salva a quantidade de alunos na turma
                salvar.newLine();
                salvar.write(turma.getId());//salva o codigo da disciplina naquela turma
                salvar.newLine();
                
                for(Aluno alunos : turma.getListaAlunos()){
                    
                    salvar.write(alunos.getId());//salva um por um o q esta na lista de cpfs
                    salvar.newLine();
                }
                
                size=turma.getListAtividades().size();
                salvar.write(size);//salva a quantidade de alunos na turma
                salvar.newLine();
                
                for(Atividade atividade : turma.getListAtividades()){
                    
                    salvar.write(atividade.getId());//salva um por um o q esta na lista de atividades
                    salvar.newLine();
                }
                
            }
            salvar.close();
            file.close();            
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(TurmaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(TurmaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public Turma buscar(Turma turma) {
        for(Turma turmaTemp : listaTurma){
            if(turmaTemp.getHorario().equals(turma.getLocal()) && turmaTemp.getHorario().equals(turma.getLocal())){
                return turmaTemp;
            }
        }
        return turma;
    }

    @Override
    public void adicionarAtividade() {
       }
    
}
    

