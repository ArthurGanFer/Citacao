/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.citacoes.model.dao;

import com.br.citacoes.controller.Controller;
import com.br.citacoes.model.Autor;
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
public class AutorDAO implements GenericDAO<Autor> {

    private Connection conn;

    public AutorDAO() {
        conn = ConnectionDB.getInstance();
    }

    @Override
    public List<Autor> read() {

        List<Autor> autor = new ArrayList<>();

        String sql = "SELECT * FROM Autor";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_autor");
                String nome = rs.getString("nome");
                Autor a = new Autor(id, nome);
                autor.add(a);
            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autor;
    }

    @Override
    public boolean insert(Autor autor) {

        boolean resp = false;
        String sql = "INSERT INTO autor(nome) VALUES(?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, autor.getNome());
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
    public boolean update(Autor autor) {

        boolean resp = false;
        String sql = "UPDATE autor SET nome=? WHERE id_autor=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, autor.getNome());
            ps.setInt(2, autor.getId_autor());
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
    public boolean delete(Autor autor) {

        boolean resp = false;
        String sql = "DELETE FROM autor WHERE id_autor=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, autor.getId_autor());

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
