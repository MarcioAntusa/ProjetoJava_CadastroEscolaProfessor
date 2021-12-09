/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import bdconexao.ConexaoBD;
import controle.EscolaControle;
import modelos.entidades.Professor;
import modelos.interfaces.IProfessorDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author M
 */
public class ProfessorJDBCDao implements IProfessorDao {

    //Conexao com o banco
    private Connection conexao = null;

    public ProfessorJDBCDao() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    public void finalizarConexao() throws Exception {
        ConexaoBD.closeConexao();
    }

    @Override
    public void incluir(Professor prof) throws Exception {
        try {
            String sql;
            sql = "insert into professor(mat_prof, nome_prof, telefone_prof, "
                    + "email_prof, endereco_prof, titulacao_prof, id_escola) values(?,?,?,?,?,?,?)";

            PreparedStatement preparedStamente = conexao.prepareStatement(sql);
            preparedStamente.setInt(1, prof.getMatricula());
            preparedStamente.setString(2, prof.getNome());
            preparedStamente.setString(3, prof.getTelefone());
            preparedStamente.setString(4, prof.getEmail());
            preparedStamente.setString(5, prof.getEndereco());
            preparedStamente.setString(6, prof.getTitulacao());
            preparedStamente.setInt(7, prof.getEscola().getId());
            preparedStamente.executeUpdate();

        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, ....
            throw new Exception("SQL ERRO: " + erro.getMessage());
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Professor prof) throws Exception {
        try {
            PreparedStatement preparedStamente = null;
            preparedStamente = conexao.prepareStatement("update professor set mat_prof = ?, "
                    + "nome_prof = ?, telefone_prof = ?, email_prof = ?,"
                    + "endereco_prof = ?, titulacao_prof = ?, id_escola = ?"
                    + "where id_prof = ?");

            preparedStamente.setInt(1, prof.getMatricula());
            preparedStamente.setString(2, prof.getNome());
            preparedStamente.setString(3, prof.getTelefone());
            preparedStamente.setString(4, prof.getEmail());
            preparedStamente.setString(5, prof.getEndereco());
            preparedStamente.setString(6, prof.getTitulacao());
            preparedStamente.setInt(7, prof.getEscola().getId());
            preparedStamente.setInt(8, prof.getId());
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
            sql = "delete from professor where id_prof = ?";
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
    public Professor consultarPorID(int id) throws Exception {
        try {
            PreparedStatement preparedStamente = null;
            preparedStamente = conexao.prepareStatement("select * from professor "
                    + "where id_prof = ?");
            preparedStamente.setInt(1, id);
            ResultSet rs = preparedStamente.executeQuery();

            Professor prof = null;
            EscolaControle controleEscola = null;

            if (rs.next()) {
                prof = new Professor();
                controleEscola = new EscolaControle();
                prof.setId(rs.getInt("id_prof"));
                prof.setMatricula(rs.getInt("mat_prof"));
                prof.setNome(rs.getString("nome_prof"));
                prof.setTelefone(rs.getString("telefone_prof"));
                prof.setEmail(rs.getString("email_prof"));
                prof.setEndereco(rs.getString("endereco_prof"));
                prof.setTitulacao(rs.getString("titulacao_prof"));
                prof.setEscola(controleEscola.consultarPorID((rs.getInt("id_escola"))));
            }
            return prof;

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
            List<Professor> listaDosProfessores = new LinkedList<Professor>();
            String sql = "select * from professor order by " + criterio;
            PreparedStatement preparedStamente = conexao.prepareStatement(sql);
            ResultSet rs = preparedStamente.executeQuery();

            EscolaControle controleEscola = new EscolaControle();

            while (rs.next()) {
                Professor prof = new Professor();
                prof.setId(rs.getInt("id_prof"));
                prof.setMatricula(rs.getInt("mat_prof"));
                prof.setNome(rs.getString("nome_prof"));
                prof.setTelefone(rs.getString("telefone_prof"));
                prof.setEmail(rs.getString("email_prof"));
                prof.setEndereco(rs.getString("endereco_prof"));
                prof.setTitulacao(rs.getString("titulacao_prof"));
                prof.setEscola(controleEscola.consultarPorID(rs.getInt("id_escola")));
                listaDosProfessores.add(prof);
            }
            return listaDosProfessores.iterator();

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
            String sql = "select * from professor";
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
