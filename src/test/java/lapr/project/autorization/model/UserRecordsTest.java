/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorization.model;

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
public class UserRecordsTest {
    
    public UserRecordsTest() {
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
     * Test of newUser method, of class UserRecords.
     */
    @Test
    public void testNewUser() {
        System.out.println("newUser");
        String strName = "Veiga";
        String strEmail = "abc@abs.pt";
        String strPassword = "123456";
        UserRecords instance = new UserRecords();
        User expResult = new User(strName, strEmail, strPassword);
        User result = instance.newUser(strName, strEmail, strPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of addUser method, of class UserRecords.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User utlz = new User("Bruno", "abc@abs.pt", "123456");
        UserRecords instance = new UserRecords();
        boolean expResult = true;
        boolean result = instance.addUser(utlz);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddUser2() {
        System.out.println("addUser");
        User utlz = null;
        UserRecords instance = new UserRecords();
        boolean expResult = false;
        boolean result = instance.addUser(utlz);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeUser method, of class UserRecords.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        User utlz = null;
        UserRecords instance = new UserRecords();
        boolean expResult = false;
        boolean result = instance.removeUser(utlz);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemoveUser2() {
        System.out.println("removeUser");
        User utlz = new User("Veiga", "veiga", "123");
        UserRecords instance = new UserRecords();
        boolean expResult = true;
        instance.addUser(utlz);
        boolean result = instance.removeUser(utlz);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchUser method, of class UserRecords.
     */
    @Test
    public void testSearchUser() {
        System.out.println("searchUser");
        String strId = "abc@abs.pt";
        User utlz = new User("Veiga", "abc@abs.pt", "123456");
        UserRecords instance = new UserRecords();
        instance.addUser(utlz);
        User expResult = utlz;
        User result = instance.searchUser(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasUser method, of class UserRecords.
     */
    @Test
    public void testHasUser_String() {
        System.out.println("hasUser");
        String strId = "abc@abs.pt";
        UserRecords instance = new UserRecords();
        User utlz= new User("Veiga", strId, "123456");
        instance.addUser(utlz);
        boolean expResult = true;
        boolean result = instance.hasUser(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasUser method, of class UserRecords.
     */
    @Test
    public void testHasUser_User() {
        System.out.println("hasUser");
        User utlz = new User("Bruno", "abc@abs.pt", "123456");
        UserRecords instance = new UserRecords();
        instance.addUser(utlz);
        boolean expResult = true;
        boolean result = instance.hasUser(utlz);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class UserRecords.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new UserRecords();
        UserRecords instance = new UserRecords();
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new UserRecords();
        UserRecords instance = (UserRecords) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = new CategoryRecords();
        UserRecords instance = new UserRecords();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
}
