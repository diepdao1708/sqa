/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import java.sql.Connection;
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

    /**
     * Test of readingInfo method, of class ReadingDAO.
     */
    @Test
    public void testReadingInfo() {
        System.out.println("readingInfo");
        int meter_id = 0;
        int month = 0;
        int year = 0;
        ReadingDAO instance = new ReadingDAO();
        Reading expResult = null;
        Reading result = instance.readingInfo(meter_id, month, year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReadingByMeterId method, of class ReadingDAO.
     */
    @Test
    public void testGetReadingByMeterId() {
        System.out.println("getReadingByMeterId");
        int meter_id = 0;
        ReadingDAO instance = new ReadingDAO();
        List<Reading> expResult = null;
        List<Reading> result = instance.getReadingByMeterId(meter_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNearestReading method, of class ReadingDAO.
     */
    @Test
    public void testGetNearestReading() {
        System.out.println("getNearestReading");
        int meter_id = 0;
        ReadingDAO instance = new ReadingDAO();
        Reading expResult = null;
        Reading result = instance.getNearestReading(meter_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertReading method, of class ReadingDAO.
     */
    @Test
    public void testInsertReading() {
        System.out.println("insertReading");
        Reading reading = null;
        ReadingDAO instance = new ReadingDAO();
        int expResult = 0;
        int result = instance.insertReading(reading);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
