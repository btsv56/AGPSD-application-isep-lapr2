/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Rate;
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
public class RateListTest {

    public RateListTest() {
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
     * Test of addNewRate method, of class RateList.
     */
    @Test
    public void testAddNewRate() {
        System.out.println("addNewRate");
        int rate = 0;
        RateList instance = new RateList();
        Rate expResult = new Rate(0);
        Rate result = instance.addNewRate(rate);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerRate method, of class RateList.
     */
    @Test
    public void testRegisterRate() {
        System.out.println("registerRate");
        Rate r = new Rate(0);
        RateList instance = new RateList();
        boolean expResult = true;
        boolean result = instance.registerRate(r);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRateList method, of class RateList.
     */
    @Test
    public void testGetRateList() {
        System.out.println("getRateList");
        RateList instance = new RateList();
        List<Rate> expResult = new ArrayList<>();
        List<Rate> result = instance.getRateList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMeanRate method, of class RateList.
     */
    @Test
    public void testGetMeanRate() {
        System.out.println("getMeanRate");
        RateList instance = new RateList();
        Rate r2 = new Rate(4);
        Rate r3 = new Rate(3);
        Rate r4 = new Rate(5);
        instance.registerRate(r2);
        instance.registerRate(r3);
        instance.registerRate(r4);
        double expResult = 4.0;
        double result = instance.getMeanRate();
        assertEquals(expResult, result, 0.0);
    }

}
