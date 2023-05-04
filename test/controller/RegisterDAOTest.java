package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegisterDAOTest {

    RegisterDAO registerDAO;
    private Connection connection;

    public RegisterDAOTest() {
    }

    @Before
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqa", "root", "123456");
        connection.setAutoCommit(false);
        registerDAO = new RegisterDAO(connection);
        
    }

    @After
    public void tearDown() throws SQLException {
        connection.rollback();
        connection.close();
    }

    @Test
    public void checkAccountCodeEmpty() {
        String accountCode = "";
        String cccd = "036301001234";
        String password = "Dd123456";
        String confirmPassword = "Dd123456";
        RegisterData expResult = new RegisterData(500, Const.account_code_empty);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }

    @Test
    public void checkAccountCodeTrimspaceForDoubleEndedWhitespace() {
        String accountCode = "   KH01    ";
        String cccd = "036301001234";
        String password = "Dd123456";
        String confirmPassword = "Dd123456";
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);
        RegisterData expResult = new RegisterData(500, Const.exist_account);

        assertEquals(expResult, result);
    }

    @Test
    public void checkAccountCodeWhenEnteringAllSpaces() {
        String accountCode = "    ";
        String cccd = "036301001234";
        String password = "Dd123456";
        String confirmPassword = "Dd123456";
        RegisterData expResult = new RegisterData(500, Const.account_code_empty);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void checkPasswordEmpty() {
        String accountCode = "KH01";
        String cccd = "036301001234";
        String password = "";
        String confirmPassword = "";
        RegisterData expResult = new RegisterData(500, Const.password_empty);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void checkPasswordTrimspaceForDoubleEndedWhitespace() {
        String accountCode = "   KH01    ";
        String cccd = "036301001234";
        String password = " Dd123456 ";
        String confirmPassword = " Dd123456 ";
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);
        RegisterData expResult = new RegisterData(500, Const.exist_account);

        assertEquals(expResult, result);
    }

    @Test
    public void checkPasswordWhenEnteringAllSpaces() {
        String accountCode = "    KH01";
        String cccd = "036301001234";
        String password = "            ";
        String confirmPassword = "            ";
        RegisterData expResult = new RegisterData(500, Const.password_empty);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void checkPasswordEnter7characters() {
        String accountCode = "    KH01";
        String cccd = "036301001234";
        String password = "KH12345";
        String confirmPassword = "KH12345";
        RegisterData expResult = new RegisterData(500, Const.format_password);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void CheckPasswordLackOfUppercaseLettersAndEnoughLowercaseLettersAndEnoughNumbers() {
        String accountCode = "    KH01";
        String cccd = "036301001234";
        String password = "kh123456";
        String confirmPassword = "kh123456";
        RegisterData expResult = new RegisterData(500, Const.format_password);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void CheckPasswordLackOfLowercaseLettersAndEnoughUppercaseLettersAndEnoughNumbers() {
        String accountCode = "    KH01";
        String cccd = "036301001234";
        String password = "KH12345";
        String confirmPassword = "KH12345";
        RegisterData expResult = new RegisterData(500, Const.format_password);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void CheckPasswordLackOfNumbersLettersAndEnoughUppercaseLettersAndEnoughLowercase() {
        String accountCode = "    KH01";
        String cccd = "036301001234";
        String password = "KHabcdef";
        String confirmPassword = "KHabcdef";
        RegisterData expResult = new RegisterData(500, Const.format_password);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void checkConfirmPasswordEmpty() {
        String accountCode = "KH01";
        String cccd = "036301001234";
        String password = "Dd123456";
        String confirmPassword = "";
        RegisterData expResult = new RegisterData(500, Const.confirm_password_empty);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }

    @Test
    public void checkConfirmPasswordTrimspaceForDoubleEndedWhitespace() {
        String accountCode = "   KH01    ";
        String cccd = "036301001234";
        String password = "Dd123456";
        String confirmPassword = " Dd123456 ";
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);
        RegisterData expResult = new RegisterData(500, Const.exist_account);

        assertEquals(expResult, result);
    }

    @Test
    public void checkConfirmPasswordWhenEnteringAllSpaces() {
        String accountCode = "    KH01";
        String cccd = "036301001234";
        String password = "Dd123456";
        String confirmPassword = "  ";
        RegisterData expResult = new RegisterData(500, Const.confirm_password_empty);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void checkConfirmPasswordAnotherPassword () {
        String accountCode = "KH01";
        String cccd = "036301001234";
        String password = "Dd123456";
        String confirmPassword = "Dd1234567";
        RegisterData expResult = new RegisterData(500, Const.password_not_matching);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void checkCccdEmpty() {
        String accountCode = "KH01";
        String cccd = "";
        String password = "Dd123456";
        String confirmPassword = "Dd123456";
        RegisterData expResult = new RegisterData(500, Const.cccd_empty);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }

    @Test
    public void checkCccdTrimspaceForDoubleEndedWhitespace() {
        String accountCode = "   KH01    ";
        String cccd = " 036301001234 ";
        String password = "Dd123456";
        String confirmPassword = " Dd123456 ";
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);
        RegisterData expResult = new RegisterData(500, Const.exist_account);

        assertEquals(expResult, result);
    }

    @Test
    public void checkCccdWhenEnteringAllSpaces() {
        String accountCode = "    KH01";
        String cccd = "   ";
        String password = "Dd123456";
        String confirmPassword = "Dd123456";
        RegisterData expResult = new RegisterData(500, Const.cccd_empty);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void checkWhenEnteringCorrectCustomerCodeWrongCccd() {
        String accountCode = "    KH01";
        String cccd = "03630100123";
        String password = "Dd123456";
        String confirmPassword = "Dd123456";
        RegisterData expResult = new RegisterData(500, Const.not_exist_customer_code);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void checkWhenEnteringCorrectCccdWrongCustomerCode() {
        String accountCode = "    KH";
        String cccd = "036301001234";
        String password = "Dd123456";
        String confirmPassword = "Dd123456";
        RegisterData expResult = new RegisterData(500, Const.not_exist_customer_code);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void checkWhenEnteringCorrectCccdCorrectCustomerCode() {
        String accountCode = "    KH";
        String cccd = "03630100123";
        String password = "Dd123456";
        String confirmPassword = "Dd123456";
        RegisterData expResult = new RegisterData(500, Const.not_exist_customer_code);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void checkExistAccount() {
        String accountCode = "    KH01";
        String cccd = "036301001234";
        String password = "Dd123456";
        String confirmPassword = "Dd123456";
        RegisterData expResult = new RegisterData(500, Const.exist_account);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
    
    @Test
    public void registerSuccess() {
        String accountCode = "    KH02";
        String cccd = "036301001234";
        String password = "Dd123456";
        String confirmPassword = "Dd123456";
        RegisterData expResult = new RegisterData(200, Const.register_sussess);
        RegisterData result = registerDAO.register(accountCode, cccd, password, confirmPassword);

        assertEquals(expResult, result);
    }
}
