package model;

public class Customer {
    private String type;
    private int customer_id;
    private int rate_id;

    public Customer(String type, int customer_id, int rate_id) {
        this.type = type;
        this.customer_id = customer_id;
        this.rate_id = rate_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getRate_id() {
        return rate_id;
    }

    public void setRate_id(int rate_id) {
        this.rate_id = rate_id;
    }
}
