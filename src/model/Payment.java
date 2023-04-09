package model;

public class Payment {

    String id;
    String name;
    String email;
    String tongTien;

    public Payment() {
    }

    public Payment(String id, String name, String email, String tongTien) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tongTien = tongTien;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Payment(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

}
