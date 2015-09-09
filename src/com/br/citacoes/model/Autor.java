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
public class Autor implements Serializable{

    private int id_autor;
    private String nome;

    public Autor() {
        this.id_autor = -1;
        this.nome = "anonimo";
    }

    public Autor(int id_autor, String nome) {
        this.id_autor = id_autor;
        this.nome = nome;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Autor{" + "id_autor=" + id_autor + ", nome=" + nome + '}';
    }

}
