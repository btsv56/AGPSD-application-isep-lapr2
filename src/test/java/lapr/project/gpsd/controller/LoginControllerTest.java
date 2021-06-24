/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.autorization.model.UserSession;
import lapr.project.autorization.model.UsersPaper;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Constants;
import org.apache.bcel.classfile.Constant;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Utilizador
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
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
     * Test of login method, of class LoginController.
     */
    @Test
    public void testLogin() throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException, UnsupportedEncodingException {
        System.out.println("login");
        String strId = "Veiga";
        String strPwd = "123";
        AppGPSD app = AppGPSD.getInstance();
        app.getCompany().getClientRecords().registerClient(new Client("Veiga", "123456789", "123456789", "Veiga"), "123");
        LoginController instance = new LoginController();
        boolean expResult = true;
        app.doLogout();
        boolean result = instance.login(strId, strPwd);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserSession method, of class LoginController.
     */
    @Test
    public void testGetUserSession() throws Exception {
        System.out.println("getUserSession");
        String strId = "Veiga";
        String strPwd = "123";
        AppGPSD app = AppGPSD.getInstance();
        app.getCompany().getClientRecords().registerClient(new Client("Veiga", "123456789", "123456789", "Veiga"), "123");
        LoginController instance = new LoginController();
        instance.login(strId, strPwd);
        UserSession expResult = AppGPSD.getInstance().getCurrentSession();
        UserSession result = instance.getUserSession();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompany method, of class LoginController.
     */
    @Test
    public void testGetCompany() throws Exception{
        System.out.println("getCompany");
        Company company = AppGPSD.getInstance().getCompany();
        LoginController instance = new LoginController();
        Company expResult = company;
        Company result = instance.getCompany();
        assertEquals(expResult, result);
    }
    
}
