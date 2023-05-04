/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
public class ReadingDAOTest {
    
    ReadingDAO readingDAO;
    private Connection connection;
    
    public ReadingDAOTest() {
    }
    
    @Before
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqa", "root", "123456");
        connection.setAutoCommit(false);
        readingDAO = new ReadingDAO(connection);
    }
    
    @After
    public void tearDown() throws SQLException {
        connection.rollback();
        connection.close();
    }

    /**
     * Test of readingInfo method, of class ReadingDAO.
     */

    /**
     * Test of getReadingByMeterId method, of class ReadingDAO.
     */
    @Test
    public void testGetReadingByMeterId() {
        List<Reading> list = readingDAO.getReadingByMeterId(3);
        assertNotNull(list);
        assertEquals(8, list.size());
    }

    /**
     * Test of getNearestReading method, of class ReadingDAO.
     */
    @Test
    public void testGetNearestReading() {
        Reading reading = readingDAO.getNearestReading(3);
        assertNotNull(reading);
        SimpleDateFormat formanter = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(10, reading.getReading_id());
        assertEquals(6, reading.getMonth());
        assertEquals(2023, reading.getYear());
        assertEquals(700, reading.getReading());
        assertEquals("2023-06-23", formanter.format(reading.getCreated_date()));
        assertEquals(3, reading.getMeter_id());
    }

    /**
     * Test of insertReading method, of class ReadingDAO.
     */
    @Test
    public void testInsertReading() throws SQLException {
        Reading reading = new Reading();
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        Date create_day = new Date();
        reading.setMonth(month);
        reading.setYear(year);
        reading.setCreated_date(create_day);
        reading.setMeter_id(3);
        reading.setReading(100);
        int i = readingDAO.insertReading(reading);
        assertEquals(1, i);
    }
    
}
