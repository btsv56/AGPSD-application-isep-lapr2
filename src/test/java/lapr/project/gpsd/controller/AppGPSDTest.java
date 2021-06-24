/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.Properties;
import lapr.project.autorization.model.UserSession;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
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
public class AppGPSDTest {
    
    public AppGPSDTest() {
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
     * Test of doLogin method, of class AppGPSD.
     */
    @Test
    public void testDoLogin() {
        System.out.println("doLogin");
        String strId = "Veiga";
        String strPwd = "123";
        AppGPSD instance = AppGPSD.getInstance();
        instance.getCompany().getClientRecords().registerClient(new Client("Veiga", "123456789", "123456789", "Veiga"), "123");
        boolean expResult = true;
        boolean result = instance.doLogin(strId, strPwd);
        assertEquals(expResult, result);
    }

    /**
     * Test of doLogout method, of class AppGPSD.
     */
    @Test
    public void testDoLogout() {
        System.out.println("doLogout");
         String strId = "Veiga";
        String strPwd = "123";
        AppGPSD instance = AppGPSD.getInstance();
        instance.getCompany().getClientRecords().registerClient(new Client("Veiga", "123456789", "123456789", "Veiga"), "123");
        boolean result = instance.doLogin(strId, strPwd);
        instance.doLogout();
    }

    /**
     * Test of getProperties method, of class AppGPSD.
     */
    @Test
    public void testGetProperties() {
        System.out.println("getProperties");
        AppGPSD instance = AppGPSD.getInstance();
        Properties result = instance.getProperties();
    }
}
