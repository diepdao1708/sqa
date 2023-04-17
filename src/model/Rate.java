package model;

import java.util.Date;

public class Rate {

    private int rate_id;
    private Date start_date;
    private int price_first;
    private int price_second;
    private int price_third;
    private int price_fourth;

    public Rate(int rate_id, Date start_date, int price_first, int price_second, int price_third, int price_fourth) {
        this.rate_id = rate_id;
        this.start_date = start_date;
        this.price_first = price_first;
        this.price_second = price_second;
        this.price_third = price_third;
        this.price_fourth = price_fourth;
    }

    public int getRate_id() {
        return rate_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public int getPrice_first() {
        return price_first;
    }

    public int getPrice_second() {
        return price_second;
    }

    public int getPrice_third() {
        return price_third;
    }

    public int getPrice_fourth() {
        return price_fourth;
    }

    public void setRate_id(int rate_id) {
        this.rate_id = rate_id;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setPrice_first(int price_first) {
        this.price_first = price_first;
    }

    public void setPrice_second(int price_second) {
        this.price_second = price_second;
    }

    public void setPrice_third(int price_third) {
        this.price_third = price_third;
    }

    public void setPrice_fourth(int price_fourth) {
        this.price_fourth = price_fourth;
    }

}
