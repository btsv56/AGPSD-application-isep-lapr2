/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.records.CategoryRecords;
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
public class GeographicalAreaTest {

    public GeographicalAreaTest() {
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
     * Test of getDesignation method, of class GeographicalArea.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetDesignation() throws FileNotFoundException {
        try {
            System.out.println("getDesignation");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 1000, api);
            String expResult = "area";
            String result = instance.getDesignation();
            assertEquals(expResult, result);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getRadiusAct method, of class GeographicalArea.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetRadiusAct() throws FileNotFoundException {
        try {
            System.out.println("getRadiusAct");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 1000, api);
            float expResult = 1000.0F;
            float result = instance.getRadiusAct();
            assertEquals(expResult, result, 0.0);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getDislocationCost method, of class GeographicalArea.
     */
    @Test
    public void testGetDislocationCost() throws FileNotFoundException {
        try {
            System.out.println("getDislocationCost");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 1000, api);
            double expResult = 12.0;
            double result = instance.getDislocationCost();
            assertEquals(expResult, result, 0.0);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getPostalCode method, of class GeographicalArea.
     */
    @Test
    public void testGetPostalCode() throws FileNotFoundException {
        try {
            System.out.println("getPostalCode");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 1000, api);
            PostalCode expResult = new PostalCode("4000-7");
            PostalCode result = instance.getPostalCode();
            assertEquals(expResult, result);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// Precisa se ser posto a funcionar
//    /**
//     * Test of getAct method, of class GeographicalArea.
//     */
//    @Test
//    public void testGetAct() throws FileNotFoundException {
//        try {
//            System.out.println("getAct");
//            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
//            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 200, api);
//            PostalCode pc = new PostalCode("4000-7");
//            List<ActsIn> expResult = api.obtainActing(pc, 200);
//            List<ActsIn> result = instance.getAct();
//            assertEquals(expResult, result);
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
//            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    /**
     * Test of setDesignation method, of class GeographicalArea.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testSetDesignation() throws FileNotFoundException {
        try {
            System.out.println("setDesignation");
            String designation = "x";
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 200, api);
            instance.setDesignation(designation);
            String result = instance.getDesignation();
            assertEquals(result, designation);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of setDislocationCost method, of class GeographicalArea.
     */
    @Test
    public void testSetDislocationCost() throws FileNotFoundException {
        try {
            System.out.println("setDislocationCost");
            double dislocationCost = 24.0;
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 200, api);
            instance.setDislocationCost(dislocationCost);
            double result = instance.getDislocationCost();
            assertEquals(result, dislocationCost, 0.0);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of setRadiusAct method, of class GeographicalArea.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testSetRadiusAct() throws FileNotFoundException {
        try {
            System.out.println("setRadiusAct");
            float radiusAct = 1000.0F;
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 200, api);
            instance.setRadiusAct(radiusAct);
            float result = instance.getRadiusAct();
            assertEquals(result, radiusAct, 0.0);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of setPostalCode method, of class GeographicalArea.
     */
    @Test
    public void testSetPostalCode() throws Exception {
        System.out.println("setPostalCode");
        String postalCode = "4000-9";
        ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
        GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 200, api);
        instance.setPostalCode(postalCode);
        PostalCode expResult = new PostalCode("4000-9");
        PostalCode result = instance.getPostalCode();
        assertEquals(result, expResult);
    }

    /**
     * Test of setAct method, of class GeographicalArea.
     */
    @Test
    public void testSetAct() throws FileNotFoundException {
        try {
            System.out.println("setAct");
            PostalCode pc = new PostalCode("4000-7");
            ActsIn x = new ActsIn(pc, 123);
            List<ActsIn> act = new ArrayList<>();
            act.add(x);
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-9", 200, api);
            instance.setAct(act);
            List<ActsIn> result = instance.getAct();
            assertEquals(result, act);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of hasDesignation method, of class GeographicalArea.
     */
    @Test
    public void testHasDesignation() throws FileNotFoundException {
        try {
            System.out.println("hasDesignation");
            String designation = "area";
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 200, api);
            boolean expResult = true;
            boolean result = instance.hasDesignation(designation);
            assertEquals(expResult, result);

            String designation2 = "sdfaf";
            boolean expResult2 = false;
            boolean result2 = instance.hasDesignation(designation2);
            assertEquals(expResult2, result2);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of toString method, of class GeographicalArea.
     */
    @Test
    public void testToString() throws FileNotFoundException {
        try {
            System.out.println("toString");
            String designation = "area";
            double dislocationCost = 12;
            PostalCode postalCode = new PostalCode("4000-7");
            float radiusAct = 200;
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 200, api);
            String expResult = String.format("Geographical Area: %s%n Dislocation Cost: %.2f%n "
                    + "Postal Code: %s%n Radius: %.2f%n List of Postal Codes: %s%n",
                    designation, dislocationCost,
                    postalCode, radiusAct, instance.getAct());
            String result = instance.toString();
            assertEquals(expResult, result);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of hashCode method, of class GeographicalArea.
     */
    @Test
    public void testHashCode() throws FileNotFoundException {
        try {
            System.out.println("hashCode");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 200, api);
            int expResult = 3002670;
            int result = instance.hashCode();
            assertEquals(expResult, result);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of equals method, of class GeographicalArea.
     */
    @Test
    public void testEquals() throws FileNotFoundException {
        try {
            System.out.println("equals");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            Object o = new GeographicalArea("area", 12, "4000-7", 200, api);
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 1000, api);
            boolean expResult = false;
            boolean result = instance.equals(o);
            assertEquals(expResult, result);   
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testEquals2() throws FileNotFoundException {
        try {
            System.out.println("equals2");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            Object o = null;
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 1000, api);
            boolean expResult = false;
            boolean result = instance.equals(o);
            assertEquals(expResult, result);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testEquals3() throws FileNotFoundException {
        try {
            System.out.println("equals3");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            Object o = new CategoryRecords();
            GeographicalArea instance = new GeographicalArea("area", 12, "4000-7", 1000, api);
            boolean expResult = false;
            boolean result = instance.equals(o);
            assertEquals(expResult, result);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
