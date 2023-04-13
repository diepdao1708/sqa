package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class LoginDAO extends DAO {
    
    public LoginDAO() {
    }
    
    public User login(String accountCode, String password) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE account_code = ? AND password = ?");
            ps.setString(1, accountCode);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("account_code"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("name"),
                        rs.getString("cccd"),
                        rs.getString("address"),
                        rs.getString("phone_number"),
                        rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
