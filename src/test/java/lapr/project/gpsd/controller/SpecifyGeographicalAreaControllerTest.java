/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.GeographicalArea;
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
public class SpecifyGeographicalAreaControllerTest {
    
    public SpecifyGeographicalAreaControllerTest() {
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
     * Test of newGeographicalArea method, of class SpecifyGeographicalAreaController.
     */
    @Test
    public void testNewGeographicalArea() throws Exception {
        System.out.println("newGeographicalArea");
         AppGPSD app= AppGPSD.getInstance();
        app.doLogin("adm1@esoft.pt", "123456");
        String desig = "Porto";
        double cost = 1.0;
        String postalCode = "4000-9";
        float radius = 1.0F;
        SpecifyGeographicalAreaController instance = new SpecifyGeographicalAreaController();
        GeographicalArea expResult = app.getCompany().getGeographicalAreaRecords().newGeographicalArea(desig, cost, postalCode, radius);
        GeographicalArea result = instance.newGeographicalArea(desig, cost, postalCode, radius);
        assertEquals(expResult, result);
    }

////    /**
////     * Test of registersGeographicalArea method, of class SpecifyGeographicalAreaController.
////     */
////    @Test
////    public void testRegistersGeographicalArea() throws Exception {
////        System.out.println("registersGeographicalArea");
////         AppGPSD app= AppGPSD.getInstance();
////        app.doLogin("adm1@esoft.pt", "123456");
////        SpecifyGeographicalAreaController instance = new SpecifyGeographicalAreaController();
////        String desig = "Porto";
////        double cost = 1.0;
////        String postalCode = "4000-9";
////        float radius = 1.0F;
////        instance.newGeographicalArea(desig, cost, postalCode, radius);
////        boolean expResult = false;
////        boolean result = instance.registersGeographicalArea();
////        assertEquals(expResult, result);
////    }
    
}
