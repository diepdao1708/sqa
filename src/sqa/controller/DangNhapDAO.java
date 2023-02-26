/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqa.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class DangNhapDAO extends DAO {

    public DangNhapDAO() {
    }
    
    public boolean dangNhap(String maKH, String password) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM taikhoan WHERE makh = ? AND password = ?");
            ps.setString(1, maKH);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("checkLogin -> true");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        
        return false;
    }
}
