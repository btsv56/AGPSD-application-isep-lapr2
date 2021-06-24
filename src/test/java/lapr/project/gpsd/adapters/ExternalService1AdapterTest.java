/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.adapters;

import java.util.Collections;
import java.util.List;
import lapr.project.gpsd.model.ActsIn;
import lapr.project.gpsd.model.PostalCode;
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
public class ExternalService1AdapterTest {
    
    public ExternalService1AdapterTest() {
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
     * Test of obtainActing method, of class ExternalService1Adapter.
     */
    @Test
    public void testObtainActing() {
        System.out.println("obtainActing");
        PostalCode pc = new PostalCode("1214-234");
        float radius = 1000.0F;
        ExternalService1Adapter instance = new ExternalService1Adapter();
        List<ActsIn> expResult = Collections.emptyList();
        List<ActsIn> result = instance.obtainActing(pc, radius);
        assertEquals(expResult, result);
    }
    
}
