/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;

import java.util.Iterator;
import modelos.entidades.Professor;

/**
 *
 * @author M
 */
//Interface do CRUD
public interface IProfessorDao {
    void incluir(Professor objeto) throws Exception;
    void alterar(Professor objeto) throws Exception;
    void excluirPorID(int id) throws Exception;
    Professor consultarPorID(int id) throws Exception;
    Iterator listagem(String criterio) throws Exception;
    String[] listaDeColunas() throws Exception;
}
