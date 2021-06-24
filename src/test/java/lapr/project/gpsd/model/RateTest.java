/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

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
public class RateTest {
    
    public RateTest() {
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
     * Test of getRate method, of class Rate.
     */
    @Test
    public void testGetRate() {
        System.out.println("getRate");
        Rate instance = new Rate(0);
        int expResult = 0;
        int result = instance.getRate();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Rate.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Rate(0);
        Rate instance = new Rate(0);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new Rate(0);
        Rate instance = (Rate) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = new CategoryRecords();
        Rate instance = new Rate(0);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
}
