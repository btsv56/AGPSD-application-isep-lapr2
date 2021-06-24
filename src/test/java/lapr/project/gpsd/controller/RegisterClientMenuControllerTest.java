/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Instanciate;
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
public class RegisterClientMenuControllerTest {

    public RegisterClientMenuControllerTest() {
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
     * Test of newClient method, of class RegisterClientMenuController.
     */
    @Test
    public void testNewClient() {
        System.out.println("newClient");
        String strNome = "client";
        String strNIF = "123456789";
        String strTelefone = "123456789";
        String strEmail = "client";
        String strPwd = "123";
        String[][] adds = new String[1][3];
        adds[0][0] = "Porto";
        adds[0][1] = "4000-9";
        adds[0][2] = "Porto";
        RegisterClientMenuController instance = new RegisterClientMenuController();
        boolean expResult = true;
        boolean result = instance.newClient(strNome, strNIF, strTelefone, strEmail, strPwd, adds);
        assertEquals(expResult, result);
    }

    /**
     * Test of addPostalAddress method, of class RegisterClientMenuController.
     */
    @Test
    public void testAddPostalAddress() {
        System.out.println("addPostalAddress");
        String[][] adds = new String[1][3];
        adds[0][0] = "Porto";
        adds[0][1] = "4000-9";
        adds[0][2] = "Porto";
        RegisterClientMenuController instance = new RegisterClientMenuController();
        boolean expResult = false;
        boolean result = instance.addPostalAddress(adds);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerClient method, of class RegisterClientMenuController.
     */
    @Test
    public void testRegisterClient() {
        System.out.println("registerClient");
        RegisterClientMenuController instance = new RegisterClientMenuController();
        String strNome = "client";
        String strNIF = "123456789";
        String strTelefone = "123456789";
        String strEmail = "client";
        String strPwd = "123";
        String[][] adds = new String[1][3];
        adds[0][0] = "Porto";
        adds[0][1] = "4000-9";
        adds[0][2] = "Porto";
        instance.newClient(strNome, strNIF, strTelefone, strEmail, strPwd, adds);
        boolean expResult = true;
        boolean result = instance.registerClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientsString method, of class RegisterClientMenuController.
     */
    @Test
    public void testGetClientsString() {
        System.out.println("getClientsString");
        RegisterClientMenuController instance = new RegisterClientMenuController();
        String strNome = "client";
        String strNIF = "123456789";
        String strTelefone = "123456789";
        String strEmail = "client";
        String strPwd = "123";
        String[][] adds = new String[1][3];
        adds[0][0] = "Porto";
        adds[0][1] = "4000-9";
        adds[0][2] = "Porto";
        Instanciate.readPostalCodes("4000-9");
        instance.newClient(strNome, strNIF, strTelefone, strEmail, strPwd, adds);
        String expResult = "client - 123456789 - 123456789 - client\n"
                + "Address:\n"
                + "Porto \n"
                + " 4000-9, 41.1555392, -8.6061091 - Porto";
        String result = instance.getClientsString();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkEmail method, of class RegisterClientMenuController.
     */
    @Test
    public void testCheckEmail() {
        System.out.println("checkEmail");
        String strId = "Veiga";
        String strPwd = "123";
        AppGPSD app = AppGPSD.getInstance();
        app.getCompany().getClientRecords().registerClient(new Client("Veiga", "123456789", "123456789", "Veiga"), "123");
        app.doLogin(strId, strPwd);
        String email = "Veiga";
        RegisterClientMenuController instance = new RegisterClientMenuController();
        boolean expResult = true;
        boolean result = instance.checkEmail(email);
        assertEquals(expResult, result);
    }

}
