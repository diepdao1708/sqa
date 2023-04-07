/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import model.User;

/**
 *
 * @author HP
 */
public class UserDAO extends DAO{
    public User getUserById(int id){
        String sql = "select * from user where user_id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setUser_id(id);
                user.setAccount_code(rs.getString("account_code"));
                user.setName(rs.getString("name"));
                user.setAddress(rs.getString("address"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }  
    public static void main(String[] args) {
        System.out.println(new UserDAO().getUserById(1).getName());
    }
}
