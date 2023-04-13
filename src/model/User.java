package model;

public class User {

    private int user_id;
    private String account_code;
    private String password;
    private String role;
    private String name;
    private String cccd;
    private String address;
    private String phone_number;
    private String email;

    public User() {

    }

    public User(int user_id, String account_code, String password, String role, String name, String cccd, String address, String phone_number, String email) {
        this.user_id = user_id;
        this.account_code = account_code;
        this.password = password;
        this.role = role;
        this.name = name;
        this.cccd = cccd;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAccount_code() {
        return account_code;
    }

    public void setAccount_code(String account_code) {
        this.account_code = account_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
