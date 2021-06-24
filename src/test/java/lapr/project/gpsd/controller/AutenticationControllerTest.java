/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.autorization.model.UsersPaper;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Constants;
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
public class AutenticationControllerTest {
    
    public AutenticationControllerTest() {
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
     * Test of doLogin method, of class AutenticationController.
     */
    @Test
    public void testDoLogin() {
        System.out.println("doLogin");
         String strId = "Veiga";
        String strPwd = "123";
        AppGPSD app = AppGPSD.getInstance();
        app.getCompany().getClientRecords().registerClient(new Client("Veiga", "123456789", "123456789", "Veiga"), "123");
        app.doLogin(strId, strPwd);
        AutenticationController instance = new AutenticationController();
        boolean expResult = true;
        boolean result = instance.doLogin(strId, strPwd);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getUserPapers method, of class AutenticationController.
     */
    @Test
    public void testGetUserPapers() {
        System.out.println("getUserPapers");
        String strId = "Veiga";
        String strPwd = "123";
        AppGPSD app = AppGPSD.getInstance();
        app.getCompany().getClientRecords().registerClient(new Client("Veiga", "123456789", "123456789", "Veiga"), "123");
        app.doLogin(strId, strPwd);
        AutenticationController instance = new AutenticationController();
        List<UsersPaper> expResult = new ArrayList<>();
        expResult.add(new UsersPaper(Constants.PAPER_CLIENT));
        List<UsersPaper> result = instance.getUserPapers();
        assertEquals(expResult, result);
    }

    /**
     * Test of doLogout method, of class AutenticationController.
     */
    @Test
    public void testDoLogout() {
        System.out.println("doLogout");
        AutenticationController instance = new AutenticationController();
        instance.doLogout();
    }
    
}
