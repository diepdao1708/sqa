/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqa.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    public static Connection con;

    public DAO() {
        if(con == null){
            try {
                // url - username - password of mySQL
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqa?useSSL=false", "root", "password");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex);
            } 
        }
    }
}
