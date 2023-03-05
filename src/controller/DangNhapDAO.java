/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqa.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DangNhapDAO extends DAO {

    public DangNhapDAO() {
    }
    
    public boolean dangNhap(String maKH, String matkhau) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM taikhoan WHERE makhachhang = ? AND matkhau = ?");
            ps.setString(1, maKH);
            ps.setString(2, matkhau);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("dangNhap -> true");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
