/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.view;

import br.ufes.ceunes.poo.model.dao.AlunoDao;
import br.ufes.ceunes.poo.model.dao.AlunoDaoImpl;
import br.ufes.ceunes.poo.model.dao.DisciplinaDao;
import br.ufes.ceunes.poo.model.dao.DisciplinaDaoImpl;
import br.ufes.ceunes.poo.model.dao.ProfessorDao;
import br.ufes.ceunes.poo.model.dao.ProfessorDaoImpl;
import br.ufes.ceunes.poo.model.dao.TurmaDao;
import br.ufes.ceunes.poo.model.dao.TurmaDaoImpl;

/**
 *
 * @author paulo
 */
public class AcadeSystemExe {
    public static void main(String[] args){
        
        AlunoDao alunoDao = new AlunoDaoImpl(); // Objeto Aluno Criado
        AlunoView alunoView = new AlunoView(alunoDao); // Enviado um alunoDoa para um alunoView
        
        ProfessorDao professorDao = new ProfessorDaoImpl(); // Objeto Professor Criado
        ProfessorView professorView = new ProfessorView(professorDao); // Enviado um professorDao para professorView
        
        DisciplinaDao disciplinaDao = new DisciplinaDaoImpl();
        DisciplinaView disciplinaView = new DisciplinaView(disciplinaDao);
        
        TurmaDao turmaDao = new TurmaDaoImpl();
        TurmaView turmaView = new TurmaView(turmaDao);
        
        
    }
}
