/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import DAO.DAOHibernateUtil;
import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.dao.AlunoDaoImpl;
import br.ufes.ceunes.poo.model.dao.AtividadeDao;
import br.ufes.ceunes.poo.model.dao.AtividadeDaoImpl;
import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.dao.DisciplinaDaoImpl;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.dao.ProfessorDaoImpl;
import br.ufes.ceunes.poo.model.dao.TurmaDao;
import br.ufes.ceunes.poo.model.dao.TurmaDaoImpl;
import br.ufes.ceunes.poo.model.pojo.Aluno;
import br.ufes.ceunes.poo.model.pojo.Disciplina;
import br.ufes.ceunes.poo.model.pojo.Professor;
import br.ufes.ceunes.poo.model.pojo.Turma;
import java.util.Scanner;
import org.hibernate.Session;


/**
 *
 * @author paulo
 */

public class AcadeSystem {
    public static final int flagCpfVerify = 0; // 1 ativa verificação de cpfSS
    
    public static void main(String[] args){
           

        
        /* eu consigo gerar as tabelas mas nao consigo acessar acess
        
        
        Aluno aluno= new Aluno("paulo", "123456", 1);
        
        Session session = DAOHibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(aluno);
        session.getTransaction().commit();
        */
        (new Pt2MenuPrincipalView()).setVisible(true);
    }
}
