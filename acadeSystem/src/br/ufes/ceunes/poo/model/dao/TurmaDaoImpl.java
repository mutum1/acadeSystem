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
    private int id;

    public TurmaDaoImpl(ProfessorDao professorAcoes, DisciplinaDao disciplinaAcoes, AlunoDao alunoAcoes) {
        this.listaTurma = new ArrayList<>();
        this.professorAcoes = professorAcoes;
        this.disciplinaAcoes = disciplinaAcoes;
        this.alunoAcoes = alunoAcoes;
        this.id = 1;
    }

    @Override
    public int gerarProximoId(){
        return this.id;
    }

    private void adicionar(Turma turma){
        listaTurma.add(turma);
    }
    /**
     * Retorna a lista de todas as turmas.
     * @return a lista de turmas.
     */
    @Override
    public List getAll(){//retorna a lista de turma
        return listaTurma;   
    }
    /**
     * Carrega todas as turmas que estão no arquivo em uma lista.
     
   
    @Override
    public void carregar(){
        listaTurma = new ArrayList<>();
        String nomeArquivo = "Turmas.txt";//nome do arquivo
        FileReader file;
        
        try {
                 
            file = new FileReader(nomeArquivo); //abre o arquivo
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            
            String idTemp = ler.readLine();
            id = Integer.parseInt(idTemp)+1;
            
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
                idTemp = ler.readLine(); //pega pega o codigo daquela diciplina
                
                Professor professor = new Professor(null,null,null,Integer.parseInt(idProfessor));//cria um objeto do tipo professor
                professor = professorAcoes.buscar(professor);//procura o professor na lista de professores e adiciona e ele na turma
                
                Disciplina disciplina = new Disciplina(null,null,null,Integer.parseInt(idDisciplina));// cria um objeto do tipo disciplina e coloca so o codigo no objeto
                disciplina = disciplinaAcoes.buscar(disciplina);//busca a disciplina com aquele codigo e completa as informaçoes do objeto
                Turma novaTurma = new Turma(ano, periodo, local, horario,nVagas,professor,disciplina,Integer.parseInt(idTemp));//cria a turma e salva as informaçoes no objeto
                
                adicionar(novaTurma);//Adiciona na lista
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
     * Salva todas as turmas que estão numa lista em um arquivo.
     * @param turmaAdd lista de turmas para que seja salva no arquivo.
     
    @Override
    public void salvar(Turma turmaAdd){
        
        adicionar(turmaAdd);
        String nomeArquivo = "Turmas.txt";//Nome do arquivo
        
        try {
            FileWriter file = new FileWriter(nomeArquivo,false);//Abro o arquivo para salvar
            BufferedWriter salvar = new BufferedWriter(file);//Estacio o arquivo para salvar
            salvar.write(Integer.toString(id));
            salvar.newLine();
            
            for(Turma turma : listaTurma){//percorre a lista
                salvar.write(turma.getAno());//salva ano
                salvar.newLine();
                salvar.write(turma.getPeriodo());//salva perido
                salvar.newLine();
                salvar.write(turma.getLocal());//salva local
                salvar.newLine();
                salvar.write(turma.getHorario());//salva o horario
                salvar.newLine();
                salvar.write(Integer.toString(turma.getnVagas()));//salva nº de vagas
                salvar.newLine();
                salvar.write(Integer.toString(turma.getProfessor().getId()));//salva o id do professor q da aula naquela turma
                salvar.newLine();
                salvar.write(Integer.toString(turma.getDisciplina().getId()));//salva o codigo da disciplina naquela turma
                salvar.newLine();
                salvar.write(Integer.toString(turma.getId()));//salva o codigo da disciplina naquela turma
                salvar.newLine();
                             
            }
            salvar.close();
            file.close();            
        } catch (FileNotFoundException ex) {//Coisa do NetBeans
            Logger.getLogger(TurmaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//Coisa do NetBeans
            Logger.getLogger(TurmaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        carregar();
    }*/
    
    
    /**
     * Busca na lista turmas, utilizando como chave o id
     * @param turma Uma cópia de turma apenas com o id.
     * @return uma turma, caso contrario retorna uma turma com campos vazios.
     */
    @Override
    public Turma buscar(Turma turma) {
        for(Turma turmaTemp : listaTurma){
            if(turmaTemp.getId() == turma.getId()){
                return turmaTemp;
            }
        }
        return turma;
    }

    /**
     * Verifica se há alguma outra turma no mesmo local e horario, para que não
     * de comflito na geração das turmas.
     * @param turma lista de turmas
     * @return turma se for disponivel o horario.
     */
    @Override
    public Turma disponibilidadeLocal(Turma turma) {
         for(Turma turmaTemp : listaTurma){
            if(turmaTemp.getHorario().equals(turma.getHorario()) && turmaTemp.getLocal().equals(turma.getLocal())){
                return turmaTemp;
            }
        }
        return turma;
    }
    /**
     * Busca turmas que tenham a disciplina.
     * @param turma lista de turma desejada.
     * @return lista de turmas.
     */
    @Override
    public List buscarPorDisciplina(Turma turma) {
        List<Turma> tempList = new ArrayList<>();
        for(Turma turmaTemp : listaTurma){
            if(turmaTemp.getDisciplina().equals(turma.getDisciplina())){
                tempList.add(turmaTemp);
            }
        }
        return tempList;
    }


        

    
}
    

