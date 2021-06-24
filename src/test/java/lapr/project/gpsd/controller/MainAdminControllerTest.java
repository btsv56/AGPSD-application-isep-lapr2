/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.autorization.model.User;
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
public class MainAdminControllerTest {
    
    public MainAdminControllerTest() {
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

//    /**
//     * Test of getCurrentSession method, of class MainAdminController.
//     */
//    @Test
//    public void testGetCurrentSession() {
//        System.out.println("getCurrentSession");
//        String strId = "Veiga";
//        String strPwd = "Veiga";
//        AppGPSD app = AppGPSD.getInstance();
//        app.getCompany().getClientRecords().registerClient(new Client("Veiga", "123456789", "123456789", "Veiga"), "123");
//        app.doLogin(strId, strPwd);
//        MainAdminController instance = new MainAdminController();
//        UserSession expResult = new UserSession(new User("Veiga", strId, strPwd));
//        UserSession result = instance.getCurrentSession();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getCompany method, of class MainAdminController.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        MainAdminController instance = new MainAdminController();
        Company expResult = instance.getCompany();
        Company result = instance.getCompany();
        assertEquals(expResult, result);
    }
    
}
