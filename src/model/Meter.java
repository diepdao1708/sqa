package model;

public class Meter {

    private int meter_id;
    private int customer_id;
    private String serial_number;
    private boolean status;

    public Meter() {

    }

    public Meter(int meter_id, int customer_id, String serial_number, boolean status) {
        this.meter_id = meter_id;
        this.customer_id = customer_id;
        this.serial_number = serial_number;
        this.status = status;
    }

    public int getMeter_id() {
        return meter_id;
    }

    public void setMeter_id(int meter_id) {
        this.meter_id = meter_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
