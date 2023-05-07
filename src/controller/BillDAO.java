package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Bill;
import model.Rate;

public class BillDAO extends DAO {

    public BillDAO() {

    }

    public int calculateBill(String type, int current_reading, Rate rate) {
        int res;
        int change = current_reading;

        if (type.equals("normal")) {
            // Với 10m3 đầu
            if (change <= 10) {
                res = change * rate.getPrice_first();
                return res;
            } // Với từ 10m3 đến 20m3
            else if (change > 10 && change <= 20) {
                res = 10 * rate.getPrice_first() + (change - 10) * rate.getPrice_second();
                return res;
            } // Với từ 20m3 đến 30m3
            else if (change > 20 && change <= 30) {
                res = 10 * rate.getPrice_first() + 10 * rate.getPrice_second() + (change - 20) * rate.getPrice_third();
                return res;
            } // Với trên 30m3
            else {
                res = 10 * rate.getPrice_first() + 10 * rate.getPrice_second()
                        + 10 * rate.getPrice_third() + (change - 30) * rate.getPrice_fourth();
                return res;
            }
        } // Tính tiền nước cho các tổ chức kinh doanh, doanh nghiệp
        else {
            res = change * rate.getPrice_first();
            return res;
        }
    }

    public int calculateBill(String type, int previous_reading, int current_reading, Rate rate) {
        int res;
        int change = current_reading - previous_reading;

        if (type.equals("normal")) {
            // Với 10m3 đầu
            if (change <= 10) {
                res = change * rate.getPrice_first();
                return res;
            } // Với từ 10m3 đến 20m3
            else if (change > 10 && change <= 20) {
                res = 10 * rate.getPrice_first() + (change - 10) * rate.getPrice_second();
                return res;
            } // Với từ 20m3 đến 30m3
            else if (change > 20 && change <= 30) {
                res = 10 * rate.getPrice_first() + 10 * rate.getPrice_second() + (change - 20) * rate.getPrice_third();
                return res;
            } // Với trên 30m3
            else {
                res = 10 * rate.getPrice_first() + 10 * rate.getPrice_second()
                        + 10 * rate.getPrice_third() + (change - 30) * rate.getPrice_fourth();
                return res;
            }
        } // Tính tiền nước cho các tổ chức kinh doanh, doanh nghiệp
        else {
            res = change * rate.getPrice_first();
            return res;
        }
    }

    public Bill billInfo(int customer_id, int month, int year) {
        Bill bill = null;

        try {
            String query = "select * from bill where customer_id = ? and month = ? and year = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, customer_id);
            statement.setInt(2, month);
            statement.setInt(3, year);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int bill_id = rs.getInt("bill_id");
                int previous_reading = rs.getInt("previous_reading");
                int current_reading = rs.getInt("current_reading");
                int amount = rs.getInt("amount");
                int total = rs.getInt("total");
                boolean status = rs.getBoolean("status");

                bill = new Bill(bill_id, month, year, previous_reading, current_reading, amount, total, status, customer_id);
                return bill;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return bill;
    }

    public boolean saveBill(int customer_id, int month, int year, int current_reading, int previous_reading, String type, Rate rate) {
        BillDAO billDAO = new BillDAO();
        int amount = billDAO.calculateBill(type, previous_reading, current_reading, rate);
        int tax = (int) Math.round(amount * 0.08);
        int enviroment = (int) Math.round(amount * 0.1);
        int total = amount + tax + enviroment;
        try {
            String query = "insert into bill (month, year, previous_reading, current_reading, amount, total, status, customer_id)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, month);
            statement.setInt(2, year);
            statement.setInt(3, previous_reading);
            statement.setInt(4, current_reading);
            statement.setInt(5, amount);
            statement.setInt(6, total);
            statement.setBoolean(7, false);
            statement.setInt(8, customer_id);

            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public int numbersBill(int customer_id) {
        int count = 0;
        try {
            String query = "select count(*) from bill";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            rs.next();
            count = rs.getInt(1);
            return count;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return count;

    }
}
