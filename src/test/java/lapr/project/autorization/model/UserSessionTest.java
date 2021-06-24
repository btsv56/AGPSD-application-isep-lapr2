/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorization.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;
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
public class UserSessionTest {

    public UserSessionTest() {
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
     * Test of doLogout method, of class UserSession.
     */
    @Test
    public void testDoLogout() {
        System.out.println("doLogout");
        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        instance.doLogout();
    }

    /**
     * Test of isLoggedIn method, of class UserSession.
     */
    @Test
    public void testIsLoggedIn() {
        System.out.println("isLoggedIn");
        User oUser = new User("Veiga", "abc@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        boolean expResult = true;
        boolean result = instance.isLoggedIn();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsLoggedIn2() {
        System.out.println("isLoggedIn");
        User oUser = new User("Veiga", "abc@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        instance.doLogout();
        boolean expResult = false;
        boolean result = instance.isLoggedIn();
        assertEquals(expResult, result);
    }

    /**
     * Test of isLoggedInWithPaper method, of class UserSession.
     */
    @Test
    public void testIsLoggedInWithPaper() {
        System.out.println("isLoggedInWithPaper");
        String strPaper = "Client";
        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        boolean expResult = false;
        boolean result = instance.isLoggedInWithPaper(strPaper);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsLoggedInWithPaper2() {
        System.out.println("isLoggedInWithPaper");
        String strPaper = "Client";
        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        instance.doLogout();
        boolean expResult = false;
        boolean result = instance.isLoggedInWithPaper(strPaper);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserPapers method, of class UserSession.
     */
    @Test
    public void testGetUserPapers() {
        System.out.println("getUserPapers");
        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        List<UsersPaper> expResult = new ArrayList<>();
        List<UsersPaper> result = instance.getUserPapers();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserName method, of class UserSession.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        String expResult = "Veiga";
        String result = instance.getUserName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUserName2() {
        System.out.println("getUserName");
        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        instance.doLogout();
        String expResult = null;
        String result = instance.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdUser method, of class UserSession.
     */
    @Test
    public void testGetIdUser() {
        System.out.println("getIdUser");
        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        String expResult = "abs@abs.pt";
        String result = instance.getIdUser();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIdUser2() {
        System.out.println("getIdUser");
        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        instance.doLogout();
        String expResult = null;
        String result = instance.getIdUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmailUser method, of class UserSession.
     */
    @Test
    public void testGetEmailUser() {
        System.out.println("getEmailUser");
        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        String expResult = "abs@abs.pt";
        String result = instance.getEmailUser();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEmailUser2() {
        System.out.println("getEmailUser");
        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        instance.doLogout();
        String expResult = null;
        String result = instance.getEmailUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class UserSession.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        Object o = new UserSession(oUser);
        UserSession instance = new UserSession(oUser);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals2() {
        System.out.println("equals");

        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        Object o = new UserSession(oUser);
        UserSession instance = (UserSession) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals3() {
        System.out.println("equals");

        User oUser = new User("Veiga", "abs@abs.pt", "123456");
        Object o = new CategoryRecords();
        UserSession instance = new UserSession(oUser);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class UserSession.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
         User oUser = new User("Veiga", "abs@abs.pt", "123456");
        UserSession instance = new UserSession(oUser);
        String expResult = "Veiga, abs@abs.pt";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

}
