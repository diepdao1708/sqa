/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqa.model;

/**
 *
 * @author Admin
 */
public class KhachHang {

    private int id;
    private String ten;
    private String cccd;
    private String sdt;
    private String diaChi;
    private String maKhachHang;

    public KhachHang() {
    }

    public KhachHang(int id, String ten, String cccd, String sdt, String diaChi, String maKhachHang) {
        this.id = id;
        this.ten = ten;
        this.cccd = cccd;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.maKhachHang = maKhachHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

}
