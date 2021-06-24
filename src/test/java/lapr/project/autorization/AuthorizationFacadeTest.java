/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorization;

import lapr.project.autorization.model.User;
import lapr.project.autorization.model.UserRecords;
import lapr.project.autorization.model.UserSession;
import lapr.project.records.CategoryRecords;
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
public class AuthorizationFacadeTest {

    public AuthorizationFacadeTest() {
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
     * Test of registerUserPaper method, of class AuthorizationFacade.
     */
    @Test
    public void testRegisterUserPaper_String() {
        System.out.println("registerUserPaper");
        String strPaper = "Client";
        AuthorizationFacade instance = new AuthorizationFacade();
        boolean expResult = true;
        boolean result = instance.registerUserPaper(strPaper);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUserPaper method, of class AuthorizationFacade.
     */
    @Test
    public void testRegisterUserPaper_String_String() {
        System.out.println("registerUserPaper");
        String strPaper = "Client";
        String strDescription = "new client";
        AuthorizationFacade instance = new AuthorizationFacade();
        boolean expResult = true;
        boolean result = instance.registerUserPaper(strPaper, strDescription);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class AuthorizationFacade.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String strName = "Bruno Veiga";
        String strEmail = "abc@abs.pt";
        String strPassword = "123456";
        AuthorizationFacade instance = new AuthorizationFacade();
        boolean expResult = true;
        boolean result = instance.registerUser(strName, strEmail, strPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUserWithPaper method, of class AuthorizationFacade.
     */
    @Test
    public void testRegisterUserWithPaper() {
        System.out.println("registerUserWithPaper");
        String strName = "Bruno Veiga";
        String strEmail = "abc@abc.pt";
        String strPassword = "123456";
        String strPaper = "Client";
        AuthorizationFacade instance = new AuthorizationFacade();
        boolean expResult = true;
        boolean result = instance.registerUserWithPaper(strName, strEmail, strPassword, strPaper);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUserWithPapers method, of class AuthorizationFacade.
     */
    @Test
    public void testRegisterUserWithPapers() {
        System.out.println("registerUserWithPapers");
        String strName = "Bruno Veiga";
        String strEmail = "abc@abc.pt";
        String strPassword = "123456";
        String[] papers = {"Client", "SP"};
        AuthorizationFacade instance = new AuthorizationFacade();
        boolean expResult = true;
        boolean result = instance.registerUserWithPapers(strName, strEmail, strPassword, papers);
        assertEquals(expResult, result);
    }

    /**
     * Test of existUser method, of class AuthorizationFacade.
     */
    @Test
    public void testExistUser() {
        System.out.println("existUser");
        String strId = "1";
        AuthorizationFacade instance = new AuthorizationFacade();
        boolean expResult = false;
        boolean result = instance.existUser(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of doLogin method, of class AuthorizationFacade.
     */
    @Test
    public void testDoLogin() {
        System.out.println("doLogin");
        String strId = "abc@abs.pt";
        String strPwd = "123";
        AuthorizationFacade instance = new AuthorizationFacade();
        instance.registerUser("Veiga", strId, strPwd);
        UserSession result = instance.doLogin(strId, strPwd);
        UserSession expResult = instance.getCurrentSession();
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testDoLogin2() {
        System.out.println("doLogin");
        String strId = "abc@abs.pt";
        String strPwd = "123";
        AuthorizationFacade instance = new AuthorizationFacade();
        instance.registerUser("Veiga", strId, "12");
        UserSession result = instance.doLogin(strId, strPwd);
        UserSession expResult = instance.getCurrentSession();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentSession method, of class AuthorizationFacade.
     */
    @Test
    public void testGetCurrentSession() {
        System.out.println("getCurrentSession");
        AuthorizationFacade instance = new AuthorizationFacade();
        UserSession expResult = null;
        UserSession result = instance.getCurrentSession();
        assertEquals(expResult, result);
    }

    /**
     * Test of doLogout method, of class AuthorizationFacade.
     */
    @Test
    public void testDoLogout() {
        System.out.println("doLogout");
        AuthorizationFacade instance = new AuthorizationFacade();
        String strId = "abc@abs.pt";
        String strPwd = "123";
        UserRecords ur = new UserRecords();
        User oUser = new User("Veiga", strId, strPwd);
        ur.addUser(oUser);
        instance.doLogin(strId, strPwd);
        instance.doLogout();
    }

    /**
     * Test of getUserRecords method, of class AuthorizationFacade.
     */
    @Test
    public void testGetUserRecords() {
        System.out.println("getUserRecords");
        AuthorizationFacade instance = new AuthorizationFacade();
        UserRecords expResult = new UserRecords();
        UserRecords result = instance.getUserRecords();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class AuthorizationFacade.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new AuthorizationFacade();
        AuthorizationFacade instance = new AuthorizationFacade();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new AuthorizationFacade();
        AuthorizationFacade instance = (AuthorizationFacade) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = new CategoryRecords();
        AuthorizationFacade instance = new AuthorizationFacade();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

}
