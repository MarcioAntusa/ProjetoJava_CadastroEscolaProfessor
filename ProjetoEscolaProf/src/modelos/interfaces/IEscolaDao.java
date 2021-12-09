/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;

import java.util.Iterator;
import modelos.entidades.Escola;

/**
 *
 * @author M
 */
//Interface do CRUD
public interface IEscolaDao {
    void incluir(Escola objeto) throws Exception;
    void alterar(Escola objeto) throws Exception;
    void excluirPorID(int id) throws Exception;
    Escola consultarPorID(int id) throws Exception;
    Escola consultarPorNome(String nome) throws Exception;
    Iterator listagem(String criterio) throws Exception;
    String[] listaDeColunas() throws Exception;
}
