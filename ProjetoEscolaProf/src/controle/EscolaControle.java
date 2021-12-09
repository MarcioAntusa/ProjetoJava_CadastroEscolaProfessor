/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Iterator;
import modelos.entidades.Escola;
import modelos.interfaces.IEscolaDao;
import persistencia.EscolaJDBCDao;

/**
 *
 * @author M
 */
public class EscolaControle implements IEscolaDao {

    //Atributo
    EscolaJDBCDao escolaPersistenciaBD = null;

    public EscolaControle() throws Exception {
        try {
            escolaPersistenciaBD = new EscolaJDBCDao();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void incluir(Escola escola) throws Exception {
        escolaPersistenciaBD.incluir(escola);
    }

    @Override
    public void alterar(Escola escola) throws Exception {
        escolaPersistenciaBD.alterar(escola);
    }

    @Override
    public void excluirPorID(int id) throws Exception {
        escolaPersistenciaBD.excluirPorID(id);
    }

    @Override
    public Escola consultarPorID(int id) throws Exception {
        return escolaPersistenciaBD.consultarPorID(id);
    }

    @Override
    public Escola consultarPorNome(String nome) throws Exception {
        return escolaPersistenciaBD.consultarPorNome(nome);
    }

    @Override
    public Iterator listagem(String criterio) throws Exception {
        return escolaPersistenciaBD.listagem(criterio);
    }

    @Override
    public String[] listaDeColunas() throws Exception {
        return escolaPersistenciaBD.listaDeColunas();
    }

}
