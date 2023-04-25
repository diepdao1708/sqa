package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO extends DAO {

    private final Connection connection;

    public RegisterDAO(Connection connection) {
        this.connection = connection;
    }

    private RegisterData checkRegister(String password, String accountCode) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET password = ? where account_code = ?");
            ps.setString(1, password);
            ps.setString(2, accountCode);

            ps.executeUpdate();
            return new RegisterData(200, Const.register_sussess);
        } catch (SQLException e) {
            return new RegisterData(500, Const.register_failure);
        }
    }

    public RegisterData register(String accountCode, String cccd, String password, String confirmPassword) {
        accountCode = accountCode.trim();
        cccd = cccd.trim();
        password = password.trim();
        confirmPassword = confirmPassword.trim();
        if (accountCode.isEmpty()) {
            return new RegisterData(500, Const.account_code_empty);
        }
        if (password.isEmpty()) {
            return new RegisterData(500, Const.password_empty);
        }
        if (!checkPassword(password)) {
            return new RegisterData(500, Const.format_password);
        }
        if (confirmPassword.isEmpty()) {
            return new RegisterData(500, Const.confirm_password_empty);
        }
        if (!confirmPassword(password, confirmPassword)) {
            return new RegisterData(500, Const.password_not_matching);
        }
        if (cccd.isEmpty()) {
            return new RegisterData(500, Const.cccd_empty);
        }

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE account_code = ? AND cccd = ?");
            ps.setString(1, accountCode);
            ps.setString(2, cccd);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString("password") != null) {
                    return new RegisterData(500, Const.exist_account);
                }
                return checkRegister(password, accountCode);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return new RegisterData(500, Const.not_exist_customer_code);
    }

    private boolean confirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private boolean checkPassword(String password) {
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}";
        return password.matches(regex);
    }
}
