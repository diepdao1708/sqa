package controller;

import java.sql.*;
import model.User;

public class UserDAO extends DAO {

    private Connection connection;
    
    public UserDAO(Connection connection){
        this.connection = connection;
    }
    
    public User getUserById(int id) {
        String sql = "select * from user where user_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUser_id(id);
                user.setAccount_code(rs.getString("account_code"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setCccd(rs.getString("cccd"));
                user.setPhone_number(rs.getString("phone_number"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setAddress(rs.getString("address"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
