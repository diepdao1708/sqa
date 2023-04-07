/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;

/**
 *
 * @author HP
 */
public class Reading {
    private int reading_id;
    private int month;
    private int year;
    private int reading;
    private String created_date;
    private int meter_id;

    public Reading() {
    }

    public Reading(int reading_id, int month, int year, int reading, String created_date, int meter_id) {
        this.reading_id = reading_id;
        this.month = month;
        this.year = year;
        this.reading = reading;
        this.created_date = created_date;
        this.meter_id = meter_id;
    }
    
    public Reading(int month, int year, int reading, String created_date, int meter_id) {
        this.month = month;
        this.year = year;
        this.reading = reading;
        this.created_date = created_date;
        this.meter_id = meter_id;
    }

    public int getReading_id() {
        return reading_id;
    }

    public void setReading_id(int reading_id) {
        this.reading_id = reading_id;
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

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public int getMeter_id() {
        return meter_id;
    }

    public void setMeter_id(int meter_id) {
        this.meter_id = meter_id;
    }
}
