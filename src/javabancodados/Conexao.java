package javabancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConexao() {
        Connection con = null;
        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/aulajavabancodados", "root", "");
            System.out.println("Conectado!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.\n" + ex);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return con;
    }

    public static void closeConexao(Connection con) {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void closeConexao(Connection con, PreparedStatement stnt) {
        closeConexao(con);
        try {
            if (stnt != null)
                stnt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void closeConexao(Connection con, PreparedStatement stnt, ResultSet rs) {
        closeConexao(con, stnt);
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}