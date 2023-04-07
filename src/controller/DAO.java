package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    public static Connection con;

    public DAO() {
        if (con == null) {
            try {
                // url - username - password of mySQL
//                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_main", "root", "123456");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
}
