/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabancodados;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Kari
 */
public class TestaConexao {
    public static void main(String[] args) {

        try {
            Connection con = new Conexao().getConexao();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        System.out.println("Desconectado!");
    }
}