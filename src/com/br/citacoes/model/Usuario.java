/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.citacoes.model;

import java.io.Serializable;

/**
 *
 * @author 31338283
 */
public class Usuario implements Serializable {

    private int id_usuario;
    private String nome;
    private String senha;

    public Usuario() {
        this.id_usuario = -1;
        this.nome = "anonimo";
        this.senha = "1234567";
    }

    public Usuario(String nome, String senha) {
        this.id_usuario = -1;
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(int id, String nome, String senha) {
        this.id_usuario = id;
        this.nome = nome;
        this.senha = senha;
    }

    public int getIdUsuario() {
        return this.id_usuario;
    }

    public void setIdUsuario(int id) {
        this.id_usuario = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nome=" + nome + ", senha=" + senha + '}';
    }

}
