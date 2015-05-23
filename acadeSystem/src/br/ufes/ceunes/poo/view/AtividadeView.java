/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AtividadeDao;
import br.ufes.ceunes.poo.model.dao.TurmaDao;
import br.ufes.ceunes.poo.model.pojo.Atividade;
import br.ufes.ceunes.poo.model.pojo.Turma;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author paulo
 */
public class AtividadeView {
    
    AtividadeDao atividadeDao;
    TurmaDao turmaDao;
    
    public AtividadeView(AtividadeDao atividade,TurmaDao turmaDao){
        this.atividadeDao = atividadeDao;
        this.turmaDao = turmaDao;
    }
    
    public Atividade getInfo(){
        Scanner input = new Scanner(System.in);
        String nome;
        String codigoTurma;
        String tipo;
        String valor;
        String data;
        
        System.out.println("Digite o nome do atividade");
        nome = input.nextLine();
        
        System.out.println("Digite o codigo(ID) da turma");
        codigoTurma = input.nextLine();
        Turma turma = new Turma(null, null, null,null, 0, null, null, Integer.parseInt(codigoTurma));
        turma = turmaDao.buscar(turma);
        
        System.out.println("Digite o tipo da atividade");
        tipo = input.nextLine();
        
        System.out.println("Digite o valor da atividade");
        valor = input.nextLine();
        
        System.out.println("Digite a data da atividade");
        data = input.nextLine();

        return new Atividade(nome,tipo,data,atividadeDao.gerarProximoId());
    }    
    
    
    /**
     * Método que verifica se um atividade com determinado id existe.
     * @param atividade
     * @return True/False
     */
    public boolean existe(Atividade atividade){
        Atividade atividadeTemp = atividadeDao.buscar(new Atividade(null,null,atividade.getId()));
        if(atividadeTemp.getNome() == null){
            return false;
        }
        return true;
    }  
    
    /**
     * Imprime todos os atividades por nome e cpf.
     */
    
    
    public void listar(){
        List<Atividade> listaAtividades = atividadeDao.getAll();
         for(Atividade atividade : listaAtividades){
             System.out.println(atividade);
             System.out.println();
        }
    }
    
}
