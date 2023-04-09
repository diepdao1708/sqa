package model;


public class Meter {
    private int meter_id;
    private String customer_id;
    private String serial_number;
    private boolean status;

    public Meter(int meter_id, String customer_id, String serial_number, boolean status) {
        this.meter_id = meter_id;
        this.customer_id = customer_id;
        this.serial_number = serial_number;
        this.status = status;
    }

    public int getMeter_id() {
        return meter_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public boolean isStatus() {
        return status;
    }
    
}
