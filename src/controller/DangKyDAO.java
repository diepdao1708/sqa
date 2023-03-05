/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqa.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sqa.model.KhachHang;
import sqa.model.TaiKhoan;

/**
 *
 * @author Admin
 */
public class DangKyDAO extends DAO {

    public DangKyDAO() {
    }

    public boolean dangKy(TaiKhoan taiKhoan) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO taikhoan(idkhachhang,makhachhang,matkhau) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, taiKhoan.getIdKhachHang());
            ps.setString(2, taiKhoan.getMaKhachHang());
            ps.setString(3, taiKhoan.getMatkhau());

            ps.executeUpdate();
            System.out.println("dangKy -> true");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public KhachHang checkKhachHang(String maKhachHang, String cccd) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM khachhang WHERE makhachhang = ? AND cccd = ?");
            ps.setString(1, maKhachHang);
            ps.setString(2, cccd);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                KhachHang kh = new KhachHang(
                        rs.getInt("id"),
                        rs.getString("ten"),
                        rs.getString("cccd"),
                        rs.getString("sdt"),
                        rs.getString("diachi"),
                        rs.getString("makhachhang")
                );
                System.out.println("checkKhachHang -> true");
                return kh;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean checkMatKhau(String matKhau) {
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}";
        return matKhau.matches(regex);
    }

    public boolean tonTaiTaiKhoan(String maKhachHang) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM taikhoan WHERE makhachhang = ?");
            ps.setString(1, maKhachHang);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("tonTaiTaiKhoan -> true");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
