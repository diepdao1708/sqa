/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Reading;

/**
 *
 * @author Admin
 */

public class ReadingDAO extends DAO {
    
    private Connection connection;
    
    
    public ReadingDAO(Connection connection){
        this.connection = connection;
    }
    
    public Reading readingInfo(int meter_id, int month, int year) {
        Reading water_reading = null;
        
        try {
            String query = "select * from reading where meter_id = ? and month = ? and year = ?";
            PreparedStatement statement = connection.prepareStatement(query);
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
    
    public List<Reading> getReadingByMeterId(int meter_id){
        List<Reading> list = new ArrayList<>();
        String sql = "select * from Reading where meter_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, meter_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Reading reading = new Reading();
                reading.setReading_id(rs.getInt("reading_id"));
                reading.setMonth(rs.getInt("month"));
                reading.setYear(rs.getInt("year"));
                reading.setReading(rs.getInt("reading"));
                reading.setCreated_date(rs.getDate("created_date"));
                reading.setMeter_id(rs.getInt("meter_id"));
                list.add(reading);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Reading getNearestReading(int meter_id){
        String sql = "select * from reading where meter_id = ? order by created_date desc limit 1";
        Reading read = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, meter_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                read = new Reading();
                read.setReading_id(rs.getInt("reading_id"));
                read.setMonth(rs.getInt("month"));
                read.setYear(rs.getInt("year"));
                read.setMeter_id(rs.getInt("meter_id"));
                read.setCreated_date(rs.getDate("created_date"));
                read.setReading(rs.getInt("reading"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return read;
    }
    
    public int insertReading(Reading reading){
        String sql = "insert into reading(month, year, reading, created_date, meter_id) values(?, ?, ?, ?, ?);";
        int row = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, reading.getMonth());
            ps.setInt(2, reading.getYear());
            ps.setInt(3, reading.getReading());
            java.sql.Date date = new java.sql.Date(reading.getCreated_date().getTime());
            ps.setDate(4, date);
            ps.setInt(5, reading.getMeter_id());
            row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
        
}
