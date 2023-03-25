package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.User;

public class RegisterDAO extends DAO {

    public RegisterDAO() {
    }

    public boolean register(User user) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO user(account_code,password,role) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getAccountCode());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());

            ps.executeUpdate();
            System.out.println("register -> true");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean checkCustomer(String accountCode, String cccd) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE account_code = ? AND cccd = ?");
            ps.setString(1, accountCode);
            ps.setString(2, cccd);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("checkCustomer -> true");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean checkPassword(String password) {
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}";
        return password.matches(regex);
    }

    public boolean accountExist(String accountCode) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE account_code = ?");
            ps.setString(1, accountCode);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("accountExist -> true");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean confirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
