package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends DAO {
    
    public LoginDAO() {
    }
    
    public String login(String accountCode, String password) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE account_code = ? AND password = ?");
            ps.setString(1, accountCode);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("role");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return "";
    }
}
