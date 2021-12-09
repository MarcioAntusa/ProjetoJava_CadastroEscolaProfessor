/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Iterator;
import modelos.entidades.Professor;
import modelos.interfaces.IProfessorDao;
import persistencia.ProfessorJDBCDao;

/**
 *
 * @author M
 */
public class ProfessorControle implements IProfessorDao {

    //Atributo
    ProfessorJDBCDao professorPersistenciaBD = null;

    public ProfessorControle() throws Exception {
        try {
            professorPersistenciaBD = new ProfessorJDBCDao();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void incluir(Professor prof) throws Exception {
        professorPersistenciaBD.incluir(prof);
    }

    @Override
    public void alterar(Professor prof) throws Exception {
        professorPersistenciaBD.alterar(prof);
    }

    @Override
    public void excluirPorID(int id) throws Exception {
        professorPersistenciaBD.excluirPorID(id);
    }

    @Override
    public Professor consultarPorID(int id) throws Exception {
        return professorPersistenciaBD.consultarPorID(id);
    }

    @Override
    public Iterator listagem(String criterio) throws Exception {
        return professorPersistenciaBD.listagem(criterio);
    }

    @Override
    public String[] listaDeColunas() throws Exception {
        return professorPersistenciaBD.listaDeColunas();
    }
}
