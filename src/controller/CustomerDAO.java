/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Customer;

/**
 *
 * @author Admin
 */
public class CustomerDAO {
    public CustomerDAO() {
        
    }
    
    public Customer customerInfo(int customer_id) {
        Customer customer = null;
        
        try{
            String query = "select * from customer where user_id = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, customer_id);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                String type = rs.getString("type");
                int id = rs.getInt("user_id");
                int rate_id = rs.getInt("rate_id");
                
                customer = new Customer(type, id, rate_id);
                return customer;
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        
        return customer;
    }
}