/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Meter;
import model.Reading;

/**
 *
 * @author HP
 */
public class ReadingDAO extends DAO{
    public List<Reading> getAllReadingByMeterId(int meterId){
        String sql = "select * from reading where meter_id = ?";
        List<Reading> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, meterId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Reading r = new Reading();
                r.setMeter_id(rs.getInt("meter_id"));
                Date date = rs.getDate("created_date");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String day = sdf.format(date);
                r.setCreated_date(day);
                r.setReading(rs.getInt("reading"));
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int insertReading(Reading reading){
        String sql = "insert into reading(month, year, reading, created_date, meter_id) values(?, ?, ?, ?, ?);";
        int row = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, reading.getMonth());
            ps.setInt(2, reading.getYear());
            ps.setInt(3, reading.getReading());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(reading.getCreated_date());
            java.sql.Date dateSql = new java.sql.Date(date.getTime());
            ps.setDate(4, dateSql);
            ps.setInt(5, reading.getMeter_id());
            row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return row;
    }
    
    public Reading getNearestReading(int meter_id){
        String sql = "select * from reading where meter_id = ? order by created_date desc limit 1";
        Reading read = new Reading();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, meter_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                read.setMeter_id(rs.getInt("meter_id"));
                Date date = rs.getDate("created_date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String d = sdf.format(date);
                read.setCreated_date(d);
                read.setReading(rs.getInt("reading"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return read;
    }
    
    public static void main(String[] args) {
        System.out.println(new ReadingDAO().getNearestReading(2).getMeter_id());
    }
}
