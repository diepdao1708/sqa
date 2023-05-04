/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.User;
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
public class UserDAOTest {
    
    UserDAO userDAO;
    private Connection connection;
    public UserDAOTest() {
    }
    
    @Before
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqa", "root", "123456");
        connection.setAutoCommit(false);
        userDAO = new UserDAO(connection);
    }
    
    @After
    public void tearDown() throws SQLException {
        connection.rollback();
        connection.close();
    }

    /**
     * Test of getUserById method, of class UserDAO.
     */
    @Test
    public void testGetUserById() {
        User user = userDAO.getUserById(1);
        assertNotNull(user);
        assertEquals(1, user.getUser_id());
        assertEquals("KH01", user.getAccount_code());
        assertEquals("Dd123456", user.getPassword());
        assertEquals("kh", user.getRole());
        assertEquals("Dao Bich Diep", user.getName());
        assertEquals("036301001234", user.getCccd());
        assertEquals("Ha Noi", user.getAddress());
        assertEquals("0353331234", user.getPhone_number());
        assertEquals("diep@gmail.com", user.getEmail());
    }
    
}
