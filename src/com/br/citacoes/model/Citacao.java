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
public class Citacao implements Serializable{

    private int id_citacao, id_autor;
    private String texto;

    public Citacao() {
        this.id_autor = -1;
        this.id_citacao = -1;
        this.texto = "";
    }

    public Citacao(int id_citacao, int id_autor, String texto) {
        this.id_citacao = id_citacao;
        this.id_autor = id_autor;
        this.texto = texto;
    }

    public int getId_citacao() {
        return id_citacao;
    }

    public void setId_citacao(int id_citacao) {
        this.id_citacao = id_citacao;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Citacao{" + "id_citacao=" + id_citacao + ", id_autor=" + id_autor + ", texto=" + texto + '}';
    }

}
