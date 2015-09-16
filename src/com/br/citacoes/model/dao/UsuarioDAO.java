/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.citacoes.model.dao;

import com.br.citacoes.controller.Controller;
import com.br.citacoes.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31338283
 */
public class UsuarioDAO implements GenericDAO<Usuario> {

    private Connection conn;

    public UsuarioDAO() {
        conn = ConnectionDB.getInstance();
    }

    @Override
    public List<Usuario> read() {

        List<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM Usuario";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                Usuario u = new Usuario(id, nome, senha);
                usuarios.add(u);
            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public boolean insert(Usuario usuario) {

        boolean resp = false;
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
                resp = true;
            }

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public boolean update(Usuario usuario) {

        boolean resp = false;
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
                resp = true;
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public boolean delete(Usuario usuario) {

        boolean resp = false;
        String sql = "DELETE FROM usuario WHERE id_usuario=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, usuario.getIdUsuario());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("DEU RUIM o delete");
            } else {
                System.out.println("Usuario deletado");
                resp = true;
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;

    }

}
