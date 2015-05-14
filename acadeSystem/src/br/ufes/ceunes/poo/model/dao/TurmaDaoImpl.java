/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.model.dao;

import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
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
 *
 * @author paulo
 */
public class TurmaDaoImpl implements TurmaDao {
    
    private List<Turma> listaTurma;
    private ProfessorDaoImpl professorAcoes;
    private DisciplinaDaoImpl disciplinaAcoes;
    private AlunoDaoImpl alunoAcoes;
            
    
    public TurmaDaoImpl() {
        this.disciplinaAcoes = new DisciplinaDaoImpl();
        this.professorAcoes = new ProfessorDaoImpl();
        this.alunoAcoes = new AlunoDaoImpl();
        this.listaTurma = new ArrayList<>();
    }
    
    @Override
    public void adicionar(Turma Turma){
        listaTurma.add(Turma);
    }
    
    @Override
    public List getAll(){//retorna a lista de Turma
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
                String ano = ler.readLine();//Pega nome
                String periodo = ler.readLine();//Pega periodo
                String local = ler.readLine(); //pega o local
                String horario = ler.readLine(); //pega o horario
                String SnVagas= ler.readLine(); //pega o numero de strig
                nVagas= Integer.parseInt(SnVagas); //converte a string para inteiro
                String cpfProfessor = ler.readLine(); //pega o cpf do professor
                String codigo = ler.readLine(); //pega pega o codigo daquela diciplina
                
                Professor professor = new Professor(null,cpfProfessor,null);//cria um objeto do tipo professor
                professor = professorAcoes.buscaProfessor(professor);//procura o professor na lista de professores e adiciona e ele na turma
                
                Disciplina disciplina = new Disciplina(null,null,null,codigo);// cria um objeto do tipo disciplina e coloca so o codigo no objeto
                disciplina = disciplinaAcoes.buscaDisciplina(disciplina);//busca a disciplina com aquele codigo e completa as informaçoes do objeto
                Turma novo = new Turma(ano, periodo, local, horario,nVagas,professor,disciplina);//cria a turma e salva as informaçoes no objeto
                
                nAlunos = Integer.parseInt(ler.readLine());// pega a quantidade de alunos naquela turma
                
                for(i=0; i<nAlunos; i++){//pega no arquivo os alunos daquela turma so o cpf busca as outras informaçoes completas elas e add na lista da turma
                    String cpf= ler.readLine();
                    Aluno aluno =new Aluno(null,cpf);
                    aluno = alunoAcoes.buscaAluno(aluno);
                    novo.addAluno(aluno);
                }
                adicionar(novo);//Adiciona na lista
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
    public void salvar(){
        String nomeArquivo = "Turmas.txt";//Nome do arquivo
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            int size;
            for(Turma Turma : listaTurma){//percorre a lista
                salvar.write(Turma.getAno());//salva ano
                salvar.newLine();
                salvar.write(Turma.getPeriodo());//salva perido
                salvar.newLine();
                salvar.write(Turma.getLocal());//salva local
                salvar.newLine();
                salvar.write(Turma.getHorario());//salva o local
                salvar.newLine();
                salvar.write(Turma.getnVagas());//salva nº de vagas
                salvar.newLine();
                salvar.write(Turma.getProfessor().getCpf());//salva o cpf do professor q da aula naquela turma
                salvar.newLine();
                salvar.write(Turma.getDisciplina().getCodigo());//salva o codigo da disciplina naquela turma
                salvar.newLine();
                size=Turma.getListaAlunos().size();
                salvar.write(size);//salva a quantidade de alunos na turma
                salvar.newLine();
                for(Aluno alunos : Turma.getListaAlunos()){
                    
                    salvar.write(alunos.getCpf());//salva um por um o q esta na lista de cpfs
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
    public Turma buscaTurma(Turma turma) {
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
    

