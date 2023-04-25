/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controller;

import model.Rate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Admin
 */
public class BillDAOTest {
    
    public BillDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calculateBill method, of class BillDAO.
     */
    @Test
    public void testReading() {
        // Sử dụng bảng giá hộ giá đình 5973, 7052, 8669, 15929
        System.out.println("* UnitTest: testReading()");
        BillDAO billDAO = new BillDAO();
        RateDAO rateDAO = new RateDAO();
        Rate rate = rateDAO.rateInfo(2);
        
        // Test với 1 giá trị đầu vào
        assertEquals(-1, billDAO.calculateBill("normal", -1, rate));
        assertEquals(0, billDAO.calculateBill("normal", 0, rate));
        assertEquals(5973, billDAO.calculateBill("normal", 1, rate));
        assertEquals(66782, billDAO.calculateBill("normal", 11, rate));
        assertEquals(138919, billDAO.calculateBill("normal", 21, rate));
        assertEquals(232869, billDAO.calculateBill("normal", 31, rate));
        
        // Test với 2 giá trị đầu vào
        assertEquals(-1, billDAO.calculateBill("normal", 1, 0, rate));
        assertEquals(0, billDAO.calculateBill("normal", 0, 0, rate));
        assertEquals(5973, billDAO.calculateBill("normal", 0, 1, rate));
        assertEquals(66782, billDAO.calculateBill("normal", 0, 11, rate));
        assertEquals(138919, billDAO.calculateBill("normal", 0, 21, rate));
        assertEquals(232869, billDAO.calculateBill("normal", 0, 31, rate));
    }
    
}