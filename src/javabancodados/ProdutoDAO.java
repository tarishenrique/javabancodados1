package javabancodados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    public void create(Produto p) {
        Connection con = new Conexao().getConexao();
        PreparedStatement stnt = null;

        try {
            stnt = con.prepareStatement("insert into produto (descricao, "
                    + "quantidade, preco) values (?,?,?)");
            stnt.setString(1, p.getDescricao());
            stnt.setInt(2, p.getQuantidade());
            stnt.setDouble(3, p.getPreco());

            stnt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + e);
        } finally {
            Conexao.closeConexao(con, stnt);
            System.out.println("Conexão encerrada!");
        }
    }// fim do create

    public List<Produto> read() {
        Connection con = new Conexao().getConexao();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<Produto>();

        try {
            stnt = con.prepareStatement("select * from produto");
            rs = stnt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));

                produtos.add(produto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler! " + e);
        } finally {
            Conexao.closeConexao(con, stnt, rs);
            System.out.println("Conexão encerrada!");
        }
        return produtos;
    }// fim do read

    public List<Produto> readOder() {
        Connection con = new Conexao().getConexao();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<Produto>();

        try {
            stnt = con.prepareStatement("select * from produto ORDER BY ?");
            rs = stnt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));

                produtos.add(produto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler! " + e);
        } finally {
            Conexao.closeConexao(con, stnt, rs);
            System.out.println("Conexão encerrada!");
        }
        return produtos;
    }// fim do read

    public void update(Produto p) {
        Connection con = new Conexao().getConexao();
        PreparedStatement stnt = null;

        try {
            stnt = con.prepareStatement("update produto set descricao=?, "
                    + "quantidade=?, preco=? where id=?");
            stnt.setString(1, p.getDescricao());
            stnt.setInt(2, p.getQuantidade());
            stnt.setDouble(3, p.getPreco());
            stnt.setInt(4, p.getId());

            stnt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! " + e);
        } finally {
            Conexao.closeConexao(con, stnt);
            System.out.println("Conexão encerrada!");
        }
    }// fim do update

    public void delete(Produto p) {
        Connection con = new Conexao().getConexao();
        PreparedStatement stnt = null;

        try {
            stnt = con.prepareStatement("delete from produto where id=?");
            stnt.setInt(1, p.getId());

            stnt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! " + e);
        } finally {
            Conexao.closeConexao(con, stnt);
            System.out.println("Conexão encerrada!");
        }
    }// fim do delete

}