package controller;

import static controller.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Payment;


public class PaymentDAO extends DAO{
    public PaymentDAO(){

    }
    public Payment paymentInfo(String account_code) {
        Payment payment = null;
        String test;
        try{
            String query = "SELECT * FROM user INNER JOIN bill on bill.customer_id = user.user_id where user.account_code = ?;";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, account_code);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
//                int id = rs.getInt("user_id");
                String account_code1 = rs.getString("account_code");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");
                int total = rs.getInt("total");

                payment = new Payment(account_code1, name, email, phone_number, total);

                return payment;
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }

        return payment;
    }

}