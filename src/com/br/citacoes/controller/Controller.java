/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.citacoes.controller;

import com.br.citacoes.model.Usuario;
import com.br.citacoes.model.dao.UsuarioDAO;
import java.util.List;

/**
 *
 * @author 31338283
 */
public class Controller {

    public Controller() {

        UsuarioDAO usuariodao = new UsuarioDAO();

        Usuario usuario1 = new Usuario("admin", "admin");

        List<Usuario> lista = usuariodao.read();
        System.out.println("--- LEITURA ---");
        for (Usuario u : lista) {
            System.out.println(u);
        }

        Usuario usuario3 = lista.get(0);
        usuario3.setSenha("1234567");
        usuariodao.update(usuario3);


    }

}
