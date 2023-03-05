/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqa.model;

/**
 *
 * @author Admin
 */
public class TaiKhoan {

    private int id;
    private int idKhachHang;
    private String maKhachHang;
    private String matkhau;

    public TaiKhoan() {
    }

    public TaiKhoan(int idKhachHang, String maKhachHang, String matkhau) {
        this.idKhachHang = idKhachHang;
        this.maKhachHang = maKhachHang;
        this.matkhau = matkhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

}
