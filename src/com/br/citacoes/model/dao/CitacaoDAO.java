/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.citacoes.model.dao;

import com.br.citacoes.controller.Controller;
import com.br.citacoes.model.Autor;
import com.br.citacoes.model.Citacao;
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
public class CitacaoDAO implements GenericDAO<Citacao> {

    private Connection conn;

    public CitacaoDAO() {
        conn = ConnectionDB.getInstance();
    }

    @Override
    public List<Citacao> read() {

        List<Citacao> citacao = new ArrayList<>();

        String sql = "SELECT * FROM Citacao";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idCitacao = rs.getInt("id_citacao");
                int idAutor = rs.getInt("id_autor");
                String texto = rs.getString("texto");
                Citacao c = new Citacao(idCitacao, idAutor, texto);
                citacao.add(c);
            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return citacao;
    }

    @Override
    public boolean insert(Citacao citacao) {

        boolean resp = false;
        String sql = "INSERT INTO autor(id_autor, texto) VALUES(?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(2, citacao.getId_autor());
            ps.setString(1, citacao.getTexto());
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
    public boolean update(Citacao citacao) {

        boolean resp = false;
        String sql = "UPDATE citacao SET texto=? WHERE id_citacao=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, citacao.getTexto());
            ps.setInt(2, citacao.getId_citacao());
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
    public boolean delete(Citacao citacao) {

        boolean resp = false;
        String sql = "DELETE FROM citacao WHERE id_citacao=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, citacao.getId_citacao());

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
