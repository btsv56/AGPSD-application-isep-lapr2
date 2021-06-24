/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorization.model;

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
public class UsersPaperTest {
    
    public UsersPaperTest() {
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
     * Test of getPaper method, of class UsersPaper.
     */
    @Test
    public void testGetPaper() {
        System.out.println("getPaper");
        UsersPaper instance = new UsersPaper("Client");
        String expResult = "Client";
        String result = instance.getPaper();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class UsersPaper.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        UsersPaper instance = new UsersPaper("Client", "new Client");
        String expResult = "new Client";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasId method, of class UsersPaper.
     */
    @Test
    public void testHasId() {
        System.out.println("hasId");
        String strId = "Client";
        UsersPaper instance = new UsersPaper(strId);
        boolean expResult = true;
        boolean result = instance.hasId(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class UsersPaper.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new UsersPaper("Client");
        UsersPaper instance = (UsersPaper) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new UsersPaper("Client");
        UsersPaper instance = new UsersPaper("Client");
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = new CategoryRecords();
        UsersPaper instance = new UsersPaper("Client");
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class UsersPaper.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UsersPaper instance = new UsersPaper("Client");
        String expResult = "Client - Client";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
