/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.con;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Reading;

/**
 *
 * @author Admin
 */
public class ReadingDAO {
    public ReadingDAO() {
        
    }
    
    public Reading readingInfo(int meter_id, int month, int year) {
        Reading water_reading = null;
        
        try {
            String query = "select * from reading where meter_id = ? and month = ? and year = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, meter_id);
            statement.setInt(2, month);
            statement.setInt(3, year);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int reading_id = rs.getInt("reading_id");
                int reading = rs.getInt("reading");
                Date created_date = rs.getDate("created_date");
                water_reading = new Reading(reading_id, meter_id, month, year, reading, created_date);
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        
        return water_reading;
    }
}
