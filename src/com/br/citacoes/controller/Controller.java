/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.citacoes.controller;

/**
 *
 * @author 31338283
 */
public class Controller {
    
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private String db = "";
    private String user = "";
    private String pwd = "arthur121";
    
    public Controller() {
        connectDB();
    }

    public void connectDB() {

    }

}
