package model;

import java.util.Date;

public class Reading {

    private int reading_id;
    private int meter_id;
    private int month;
    private int year;
    private int reading;
    private Date created_date;

    public Reading() {
    }

    public Reading(int reading_id, int meter_id, int month, int year, int reading, Date created_date) {
        this.reading_id = reading_id;
        this.meter_id = meter_id;
        this.month = month;
        this.year = year;
        this.reading = reading;
        this.created_date = created_date;
    }

    public int getReading_id() {
        return reading_id;
    }

    public void setReading_id(int reading_id) {
        this.reading_id = reading_id;
    }

    public int getMeter_id() {
        return meter_id;
    }

    public void setMeter_id(int meter_id) {
        this.meter_id = meter_id;
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

    public int getReading() {
        return reading;
    }

    public void setReading(int reading) {
        this.reading = reading;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
}
