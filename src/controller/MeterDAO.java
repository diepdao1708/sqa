/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Meter;

/**
 *
 * @author Admin
 */
public class MeterDAO {
    public MeterDAO() {
        
    }
    
    public Meter meterInfo(int customer_id) {
        Meter meter = null;
        
        try {
            String query = "select * from meter where customer_id = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, customer_id);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int meter_id = rs.getInt("meter_id");
                String customer = rs.getString("customer_id");
                String serial_number = rs.getString("serial_number");
                boolean status = rs.getBoolean("status");
                meter = new Meter(meter_id, customer, serial_number, status);
                return meter;
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        return meter;
    }
}
