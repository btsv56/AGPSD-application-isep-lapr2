/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
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
public class ExternalService1APITest {
    
    public ExternalService1APITest() {
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
// NNEDS TO BE CORRECTED
//    /**
//     * Test of obtainActing method, of class ExternalService1API.
//     */
//    @Test
//    public void testObtainActing() throws Exception {
//        System.out.println("obtainActing");
//        PostalCode pc = new PostalCode("4000-7");
//        float radius = 100.0F;
//        ExternalService1API instance = new ExternalService1API();
//        List<ActsIn> expResult = new ArrayList<>();
//        ActsIn e = new ActsIn(pc, 0);
//        expResult.add(e);
//        List<ActsIn> result = instance.obtainActing(pc, radius);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of calculateDistance method, of class ExternalService1API.
     */
    @Test
    public void testCalculateDistance() {
        System.out.println("calculateDistance");
        double lat1 = 41.1469459;
        double lon1 = -8.6064074;
        double lat2 = 41.348127;
        double lon2 = -8.3961664;
        ExternalService1API instance = new ExternalService1API();
        double expResult = 28449.602;
        double result = instance.calculateDistance(lat1, lon1, lat2, lon2);
        assertEquals(expResult, result, 0.5);
    }
    
}
