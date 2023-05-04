/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import model.Meter;
import model.Payment;
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
public class MeterDAOTest {
    
    
    MeterDAO meterDAO;
    private Connection connection;
    public MeterDAOTest() {
        
    }
    
    @Before
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqa", "root", "123456");
        connection.setAutoCommit(false);
        meterDAO = new MeterDAO(connection);
    }
    
    @After
    public void tearDown() throws SQLException {
        connection.rollback();
        connection.close();
    }

    /**
     * Test of meterInfo method, of class MeterDAO.
     */
    @Test
    public void getAllMeterTest(){
        List<Meter> list = meterDAO.getAllMeter();
        assertNotNull(list);
        assertEquals(2, list.size());
    }
    
    @Test
    public void meterInfoTest(){
        Meter meter = meterDAO.meterInfo(1);
        assertNotNull(meter);
        assertEquals(1, meter.getCustomer_id());
        assertEquals(true, meter.isStatus());
        assertEquals("000001", meter.getSerial_number());
        assertEquals(3, meter.getMeter_id());
    }
   
}
