package model;

public class Payment {

    String account_code;
    String name;
    String email;
    String phone_number;
    int total;

    public Payment(String account_code, String name, String email, String phone_number, int total) {
        this.account_code = account_code;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.total = total;
    }

    public String getAccount_code() {
        return account_code;
    }

    public void setAccount_code(String account_code) {
        this.account_code = account_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
   
   
}