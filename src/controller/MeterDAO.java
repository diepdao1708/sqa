/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Meter;
import java.sql.*;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author HP
 */
public class MeterDAO extends DAO{
    public List<Meter> getAllMeter(){
        String sql = "select * from meter";
        List<Meter> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Meter meter = new Meter();
                meter.setMeter_id(rs.getInt("meter_id"));
                UserDAO userDAO = new UserDAO();
                User user = userDAO.getUserById(rs.getInt("user_id"));
                meter.setUser(user);
                meter.setSerial_number(rs.getString("serial_number"));
                meter.setStatus(rs.getInt("status"));
                list.add(meter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
//    public List<Meter> findMeterByCustomerId(String id){
//        String sql = "select * from meter where customerId like ?";
//        List<Meter> list = new ArrayList<>();
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, "%"+id+"%");
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                Meter meter = new Meter();
//                meter.setMeterId(rs.getString("meterId"));
//                UserDAO customerDAO = new UserDAO();
//                Customer customer = customerDAO.getCutomerById(rs.getString("customerId"));
//                meter.setCustomer(customer);
//                meter.setSeri(rs.getString("seri"));
//                meter.setStat(rs.getInt("stat"));
//                list.add(meter);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//    
    public Meter findMeterById(int id){
        String sql = "select * from meter where meter_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Meter meter = new Meter();
                meter.setMeter_id(rs.getInt("meter_id"));
                UserDAO userDAO = new UserDAO();
                User user = userDAO.getUserById(rs.getInt("user_id"));
                meter.setUser(user);
                meter.setSerial_number(rs.getString("serial_number"));
                meter.setStatus(rs.getInt("status"));
                return meter;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
