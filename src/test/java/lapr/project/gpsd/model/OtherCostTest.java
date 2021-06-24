/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

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
public class OtherCostTest {
    
    public OtherCostTest() {
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
     * Test of getDesclocationCost method, of class OtherCost.
     */
    @Test
    public void testGetDesclocationCost() {
        System.out.println("getDesclocationCost");
        OtherCost instance = new OtherCost("Deslocation", 2);
        double expResult = 2.0;
        double result = instance.getDesclocationCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of equals method, of class OtherCost.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new OtherCost("Deslocation", 0);
        OtherCost instance = new OtherCost("Deslocation",0);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new OtherCost("Deslocation", 0);
        OtherCost instance = (OtherCost) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    

    /**
     * Test of toString method, of class OtherCost.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        OtherCost instance = new OtherCost("Deslocation", 1);
        String expResult = "Deslocation - "+Double.toString(1.000000);
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
