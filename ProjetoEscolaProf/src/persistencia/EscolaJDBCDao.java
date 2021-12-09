/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import bdconexao.ConexaoBD;
import modelos.entidades.Escola;
import modelos.interfaces.IEscolaDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author M
 */
public class EscolaJDBCDao implements IEscolaDao {

    //Conexao com o banco
    private Connection conexao = null;

    public EscolaJDBCDao() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    public void finalizarConexao() throws Exception {
        ConexaoBD.closeConexao();
    }

    @Override
    public void incluir(Escola escola) throws Exception {
        try {
            String sql;
            sql = "insert into escola(nome_escola, telefone_escola, "
                    + "email_escola, endereco_escola) values(?,?,?,?)";

            PreparedStatement preparedStamente = conexao.prepareStatement(sql);
            preparedStamente.setString(1, escola.getNome());
            preparedStamente.setString(2, escola.getTelefone());
            preparedStamente.setString(3, escola.getEmail());
            preparedStamente.setString(4, escola.getEndereco());
            preparedStamente.executeUpdate();

        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, ....
            throw new Exception("SQL ERRO: " + erro.getMessage());
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Escola escola) throws Exception {
        try {
            PreparedStatement preparedStamente = null;
            preparedStamente = conexao.prepareStatement("update escola set nome_escola = ?,"
                    + "telefone_escola = ?, email_escola = ?,"
                    + "endereco_escola = ?" + "where id_escola = ?");

            preparedStamente.setString(1, escola.getNome());
            preparedStamente.setString(2, escola.getTelefone());
            preparedStamente.setString(3, escola.getEmail());
            preparedStamente.setString(4, escola.getEndereco());
            preparedStamente.setInt(5, escola.getId());
            preparedStamente.executeUpdate();

        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, ....
            throw new Exception("SQL ERRO: " + erro.getMessage());
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void excluirPorID(int id) throws Exception {
        try {
            String sql;
            sql = "delete from escola where id_escola = ?";
            PreparedStatement preparedStamente = conexao.prepareStatement(sql);
            preparedStamente.setInt(1, id);
            preparedStamente.executeUpdate();

        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, ....
            throw new Exception("SQL ERRO: " + erro.getMessage());
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Escola consultarPorID(int id) throws Exception {
        try {

            PreparedStatement preparedStamente = null;
            preparedStamente = conexao.prepareStatement("select * from escola "
                    + "where id_escola = ?");
            preparedStamente.setInt(1, id);
            ResultSet rs = preparedStamente.executeQuery();

            Escola escola = null;

            if (rs.next()) {
                escola = new Escola();
                escola.setId(rs.getInt("id_escola"));
                escola.setNome(rs.getString("nome_escola"));
                escola.setTelefone(rs.getString("telefone_escola"));
                escola.setEmail(rs.getString("email_escola"));
                escola.setEndereco(rs.getString("endereco_escola"));
            }
            return escola;

        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, ....
            throw new Exception("SQL ERRO: " + erro.getMessage());
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Escola consultarPorNome(String nome) throws Exception {
        try {
            PreparedStatement preparedStamente = null;
            preparedStamente = conexao.prepareStatement("select * from escola "
                    + "where nome_escola = ?");
            preparedStamente.setString(1, nome);
            ResultSet rs = preparedStamente.executeQuery();
            Escola escola = new Escola();

            if (rs.next()) {
                escola.setId(rs.getInt("id_escola"));
                escola.setNome(rs.getString("nome_escola"));
                escola.setTelefone(rs.getString("telefone_escola"));
                escola.setEmail(rs.getString("email_escola"));
                escola.setEndereco(rs.getString("endereco_escola"));
            }
            return escola;

        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, ....
            throw new Exception("SQL ERRO: " + erro.getMessage());
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Iterator listagem(String criterio) throws Exception {
        try {
            List<Escola> listaDasEscolas = new LinkedList<Escola>();
            String sql = "select * from escola order by " + criterio;
            PreparedStatement preparedStamente = conexao.prepareStatement(sql);
            ResultSet rs = preparedStamente.executeQuery();

            while (rs.next()) {
                Escola escola = new Escola();
                escola.setId(rs.getInt("id_escola"));
                escola.setNome(rs.getString("nome_escola"));
                escola.setTelefone(rs.getString("telefone_escola"));
                escola.setEmail(rs.getString("email_escola"));
                escola.setEndereco(rs.getString("endereco_escola"));
                listaDasEscolas.add(escola);
            }
            return listaDasEscolas.iterator();

        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, ....
            throw new Exception("SQL ERRO: " + erro.getMessage());
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public String[] listaDeColunas() throws Exception {
        try {
            String sql = "select * from escola";
            PreparedStatement preparedStamente = conexao.prepareStatement(sql);
            ResultSet result = preparedStamente.executeQuery();
            ResultSetMetaData rs = result.getMetaData();
            
            int count = rs.getColumnCount();
            
            String[] ColName = new String[count];

            for (int pos = 1; pos <= count; pos++) {
                ColName[pos - 1] = rs.getColumnName(pos);
            }
            return ColName;

        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, ....
            throw new Exception("SQL ERRO: " + erro.getMessage());
        } catch (Exception erro) {
            throw erro;
        }
    }

}
