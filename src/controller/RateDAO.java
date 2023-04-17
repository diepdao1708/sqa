package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Rate;

public class RateDAO extends DAO {

    public RateDAO() {

    }

    public Rate rateInfo(int rate_id) {
        Rate rate = null;

        try {
            String query = "select * from rate where rate_id = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, rate_id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("rate_id");
                Date start_date = rs.getDate("start_date");
                int price_first = rs.getInt("price_first");
                int price_second = rs.getInt("price_second");
                int price_third = rs.getInt("price_third");
                int price_fourth = rs.getInt("price_fourth");

                rate = new Rate(id, start_date, price_first, price_second, price_third, price_fourth);
                return rate;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return rate;
    }
}
