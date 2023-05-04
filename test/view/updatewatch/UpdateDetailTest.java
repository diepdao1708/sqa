/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package view.updatewatch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Reading;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class UpdateDetailTest {
    
    public UpdateDetailTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void checkTestReturnZero() throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Reading reading = new Reading();
        Reading nearestReading = new Reading();
        reading.setReading_id(1);
        reading.setMeter_id(1);
        reading.setMonth(1);
        reading.setYear(2022);
        reading.setCreated_date(simpleDateFormat.parse("2022-02-01"));
        reading.setReading(200);
        nearestReading.setReading_id(2);
        nearestReading.setMeter_id(1);
        nearestReading.setMonth(2);
        nearestReading.setYear(2022);
        nearestReading.setCreated_date(simpleDateFormat.parse("2022-01-01"));
        nearestReading.setReading(100);
        UpdateDetail u = new UpdateDetail();
        int i = u.check(nearestReading, reading);
        assertEquals(0, i);
    }
    
    @Test
    public void checkTestNearestReadingNull() throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Reading reading = new Reading();
        Reading nearestReading = new Reading();
        reading.setReading_id(1);
        reading.setMeter_id(1);
        reading.setMonth(1);
        reading.setYear(2022);
        reading.setCreated_date(simpleDateFormat.parse("2022-02-01"));
        reading.setReading(200);
        nearestReading = null;
        UpdateDetail u = new UpdateDetail();
        int i = u.check(nearestReading, reading);
        assertEquals(0, i);
    }
    
    @Test
    public void checkTestReturnOne() throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Reading reading = new Reading();
        Reading nearestReading = new Reading();
        reading.setReading_id(1);
        reading.setMeter_id(1);
        reading.setMonth(1);
        reading.setYear(2022);
        reading.setCreated_date(simpleDateFormat.parse("2022-01-15"));
        reading.setReading(200);
        nearestReading.setReading_id(2);
        nearestReading.setMeter_id(1);
        nearestReading.setMonth(2);
        nearestReading.setYear(2022);
        nearestReading.setCreated_date(simpleDateFormat.parse("2022-01-01"));
        nearestReading.setReading(100);
        UpdateDetail u = new UpdateDetail();
        int i = u.check(nearestReading, reading);
        assertEquals(1, i);
    }
    
     @Test
    public void checkTestReturnTwo() throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Reading reading = new Reading();
        Reading nearestReading = new Reading();
        reading.setReading_id(1);
        reading.setMeter_id(1);
        reading.setMonth(1);
        reading.setYear(2022);
        reading.setCreated_date(simpleDateFormat.parse("2022-02-01"));
        reading.setReading(100);
        nearestReading.setReading_id(2);
        nearestReading.setMeter_id(1);
        nearestReading.setMonth(2);
        nearestReading.setYear(2022);
        nearestReading.setCreated_date(simpleDateFormat.parse("2022-01-01"));
        nearestReading.setReading(100);
        UpdateDetail u = new UpdateDetail();
        int i = u.check(nearestReading, reading);
        assertEquals(2, i);
    }
}
