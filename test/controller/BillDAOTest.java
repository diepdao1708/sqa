/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static junit.framework.TestCase.assertEquals;
import model.Bill;
import model.Rate;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class BillDAOTest {
    
    BillDAO billDAO = new BillDAO();
    
    public BillDAOTest() {
    }

    /**
     * Test of calculateBill method, of class BillDAO.
     */
    @Test
    public void testReading() {
        // Sử dụng bảng giá hộ giá đình 5973, 7052, 8669, 15929
        System.out.println("* UnitTest: testReading()");
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
    
    @Test
    public void billInfoTest() {
        Bill bill = billDAO.billInfo(1, 4, 2023);
        assertNotNull(bill);
        assertEquals(4, bill.getBill_id());
        assertEquals(4, bill.getMonth());
        assertEquals(2023, bill.getYear());
        assertEquals(1, bill.getCustomer_id());
    }
    
    @Test
    public void saveBillTest() {
        
    }
    
    @Test
    public void numbersBillTest() {
        int num = billDAO.numbersBill(1);
        assertEquals(4, num);
    }
}
