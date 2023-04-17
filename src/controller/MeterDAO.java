package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Meter;

public class MeterDAO extends DAO {

    public MeterDAO() {

    }

    public Meter meterInfo(int customer_id) {
        Meter meter = null;

        try {
            String query = "select * from meter where user_id = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, customer_id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int meter_id = rs.getInt("meter_id");
                int user_id = rs.getInt("user_id");
                String serial_number = rs.getString("serial_number");
                boolean status = rs.getBoolean("status");
                meter = new Meter(meter_id, user_id, serial_number, status);
                return meter;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return meter;
    }

    public List<Meter> getAllMeter() {
        List<Meter> list = new ArrayList();
        String sql = "select * from meter";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Meter meter = new Meter();
                meter.setMeter_id(rs.getInt("meter_id"));
                meter.setSerial_number(rs.getString("serial_number"));
                meter.setCustomer_id(rs.getInt("user_id"));
                list.add(meter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
