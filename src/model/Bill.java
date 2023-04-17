package model;

public class Bill {
    private int bill_id;
    private int month;
    private int year;
    private int previous_reading;
    private int current_reading;
    private double amount;
    private double total;
    private boolean status;
    private int customer_id;

    public Bill(int bill_id, int month, int year, int previous_reading, int current_reading, double amount, double total, boolean status, int customer_id) {
        this.bill_id = bill_id;
        this.month = month;
        this.year = year;
        this.previous_reading = previous_reading;
        this.current_reading = current_reading;
        this.amount = amount;
        this.total = total;
        this.status = status;
        this.customer_id = customer_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrevious_reading() {
        return previous_reading;
    }

    public void setPrevious_reading(int previous_reading) {
        this.previous_reading = previous_reading;
    }

    public int getCurrent_reading() {
        return current_reading;
    }

    public void setCurrent_reading(int current_reading) {
        this.current_reading = current_reading;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }    
}
