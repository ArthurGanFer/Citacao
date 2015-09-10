/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.citacoes.controller;

import com.br.citacoes.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31338283
 */
public class Controller {

    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private String protocolo = "jdbc:derby:";
    private String dominio = "//localhost:1527/";
    private String db = "citacaoDB";
    private String user = "arthurganfer";
    private String pwd = "arthur121";
    private Connection conn;

    public Controller() {

        Usuario u = new Usuario(2, "arthur", "arth123");
        updateSenha(u);
        System.out.println("----");
        searchUsers();
    }

    public void connectDB() {
        try {
            //criar instancia do driver
            Class.forName(driver).newInstance();

            //estabelece conexao
            conn = DriverManager.getConnection(protocolo + dominio + db, user, pwd);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchUsers() {
        connectDB();

        String sql = "SELECT * FROM Usuario";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                Usuario u = new Usuario(id, nome, senha);
                System.out.println(u);
            }

            ps.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertUser(Usuario usuario) {
        connectDB();

        String sql = "INSERT INTO usuario(nome, senha) VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("DEU RUIM na inserção");
            } else {
                System.out.println("usuario inserido com sucesso");
            }

            ps.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSenha(Usuario usuario) {
        connectDB();

        String sql = "UPDATE usuario SET nome=?, senha=? WHERE id_usuario=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setInt(3, usuario.getIdUsuario());
            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("DEU RUIM O UPDATE");
            } else {
                System.out.println("Senha modificada");
            }

            ps.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteUsuario(Usuario usuario) {
        connectDB();

        String sql = "DELETE FROM usuario WHERE id_usuario=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, usuario.getIdUsuario());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("DEU RUIM o delete");
            } else {
                System.out.println("Usuario deletado");
            }

            ps.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
