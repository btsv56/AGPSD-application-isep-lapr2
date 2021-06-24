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
 * @author Asus
 */
public class PostalCodeTest {

    public PostalCodeTest() {
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
     * Test of getPostalCode method, of class PostalCode.
     */
    @Test
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        PostalCode instance = new PostalCode("4100-050", 10.0, 20.0);
        String expResult = "4100-050";
        String result = instance.getPostalCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLatitude method, of class PostalCode.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        PostalCode instance = new PostalCode("4100-050", 10.0, 20.0);
        double expResult = 10.0;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getLongitude method, of class PostalCode.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        PostalCode instance = new PostalCode("4100-050", 10.0, 20.0);
        double expResult = 20.0;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of equals method, of class PostalCode.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new PostalCode("4100-050", 10.0, 20.0);
        PostalCode instance = new PostalCode("4100-050", 10.0, 20.0);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class PostalCode.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals2");
        Object o = null;
        PostalCode instance = new PostalCode("4100-050", 10.0, 20.0);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class PostalCode.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = new CategoryRecords();
        PostalCode instance = new PostalCode("4100-050", 10.0, 20.0);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class PostalCode.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PostalCode instance = new PostalCode("4100-050", 10.0, 20.0);
        String expResult = "4100-050, 10.0, 20.0";
        String result = instance.toString();
        assertEquals(expResult, result);

    }
}
