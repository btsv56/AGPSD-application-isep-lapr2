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
 * @author marta
 */
public class ActsInTest {
    
    public ActsInTest() {
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
     * Test of toString method, of class ActsIn.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PostalCode pc = new PostalCode("4000-7");
        double distance = 100;
        ActsIn instance = new ActsIn(pc, 100);
        String expResult = String.format("Postal Code: %s%n Distance: %.2f%n", pc.toString(), 
                distance);
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        PostalCode pc = new PostalCode("4000-7");
        double distance = 100;
        ActsIn instance = new ActsIn(pc, 100);
        PostalCode expResult = new PostalCode("4000-7");
        PostalCode result = instance.getPostalCode();
        assertEquals(expResult, result);
    }
    
}
