/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorization.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.autorization.AuthorizationFacade;
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
public class UserTest {
    
    public UserTest() {
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
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        User instance = new User("Veiga", "abc@abs.pt", "123456");
        String expResult = "abc@abs.pt";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User("Veiga", "abc@abs.pt", "123456");
        String expResult = "Veiga";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User("Veiga", "abc@abs.pt", "123456");
        String expResult = "abc@abs.pt";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of hasId method, of class User.
     */
    @Test
    public void testHasId() {
        System.out.println("hasId");
        String strId = "abc@abs.pt";
        User instance = new User("Veiga", "abc@abs.pt", "123456");
        boolean expResult = true;
        boolean result = instance.hasId(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasPassword method, of class User.
     */
    @Test
    public void testHasPassword() {
        System.out.println("hasPassword");
        String strPwd = "123456";
        User instance = new User("Veiga", "abc@abs.pt", "123456");
        boolean expResult = true;
        boolean result = instance.hasPassword(strPwd);
        assertEquals(expResult, result);
    }

    /**
     * Test of addPaper method, of class User.
     */
    @Test
    public void testAddPaper() {
        System.out.println("addPaper");
        UsersPaper paper = new UsersPaper("Client");
        User instance = new User("Veiga", "abc@abs.pt", "123456");
        boolean expResult = true;
        boolean result = instance.addPaper(paper);
        assertEquals(expResult, result);
    }

    /**
     * Test of removePaper method, of class User.
     */
    @Test
    public void testRemovePaper() {
        System.out.println("removePaper");
        UsersPaper paper = new UsersPaper("Client");
        User instance =new User("Veiga", "abc@abs.pt", "123456");
        boolean expResult = true;
        instance.addPaper(paper);
        boolean result = instance.removePaper(paper);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemovePaper2() {
        System.out.println("removePaper");
        UsersPaper paper = new UsersPaper("Client");
        User instance =new User("Veiga", "abc@abs.pt", "123456");
        boolean expResult = false;
        boolean result = instance.removePaper(paper);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasPaper method, of class User.
     */
    @Test
    public void testHasPaper_UsersPaper() {
        System.out.println("hasPaper");
        UsersPaper paper = new UsersPaper("Client");
        User instance = new User("Veiga", "abc@abs.pt", "123456");
        boolean expResult = true;
        instance.addPaper(paper);
        boolean result = instance.hasPaper(paper);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasPaper method, of class User.
     */
    @Test
    public void testHasPaper_String() {
        System.out.println("hasPaper");
        String strPapel = "Clie";
        User instance = new User("Veiga", "abc@abs.pt", "123456");
        boolean expResult = false;
        UsersPaper paper= new UsersPaper("Client");
        instance.addPaper(paper);
        boolean result = instance.hasPaper(strPapel);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPapers method, of class User.
     */
    @Test
    public void testGetPapers() {
        System.out.println("getPapers");
        User instance = new User("Veiga", "abc@abs.pt", "123456");
        UsersPaper paper= new UsersPaper("Client");
        instance.addPaper(paper);
        List<UsersPaper> expResult = new ArrayList<>();
        expResult.add(paper);
        List<UsersPaper> result = instance.getPapers();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new User("Veiga","abs@abs.pt","123456");
        User instance = (User) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = new UserRecords();
        User instance = new User("Veiga","abs@abs.pt","123456");
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User("Veiga","abs@abs.pt","123456");
        String expResult = "Veiga - abs@abs.pt";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User("Veiga", "veiga", "veiga");
        String expResult = "veiga";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }
    
}
