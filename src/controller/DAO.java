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
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqa", "root", "123456");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }
    }
}
