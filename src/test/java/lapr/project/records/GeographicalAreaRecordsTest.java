/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.ExternalService;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.Instanciate;
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
public class GeographicalAreaRecordsTest {

    public GeographicalAreaRecordsTest() {
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
     * Test of newGeographicalArea method, of class GeographicalAreaRecords.
     */
    @Test
    public void testNewGeographicalArea() throws Exception {
        System.out.println("newGeographicalArea");
        String desig = "Area1";
        double cost = 12.0;
        String postalCod = "4000-7";
        float radius = 100;
        Instanciate.readPostalCodes(postalCod);
        GeographicalAreaRecords instance = new GeographicalAreaRecords();
        GeographicalArea expResult = new GeographicalArea(desig, cost, postalCod, radius, AppGPSD.getInstance().getCompany().getExternalService());
        GeographicalArea result = instance.newGeographicalArea(desig, cost, postalCod, radius);
        assertEquals(expResult, result);
    }

    /**
     * Test of getClosestGeographicalArea method, of class
     * GeographicalAreaRecords.
     */
    @Test
    public void testGetClosestGeographicalArea() throws FileNotFoundException {
        try {
            System.out.println("getClosestGeographicalArea");
            PostalCode pc = new PostalCode("4000-7");
            GeographicalAreaRecords instance = new GeographicalAreaRecords();
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea example = new GeographicalArea("area", 12, "4000-7", 1000, api);
            instance.addGeographicalArea(example);
            GeographicalArea expResult = example;
            GeographicalArea result = instance.getClosestGeographicalArea(pc);
            assertEquals(expResult, result);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaRecordsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of calculateDistance method, of class GeographicalAreaRecords.
     */
    @Test
    public void testCalculateDistance() {
        System.out.println("calculateDistance");
        double lat1 = 41.1469459;
        double lon1 = -8.6064074;
        double lat2 = 41.348127;
        double lon2 = -8.3961664;
        GeographicalAreaRecords instance = new GeographicalAreaRecords();
        double expResult = 28449.602;
        double result = instance.calculateDistance(lat1, lon1, lat2, lon2);
        assertEquals(expResult, result, 0.5);
    }

    /**
     * Test of getGeoAreasList method, of class GeographicalAreaRecords.
     *
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetGeoAreasList() throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
        try {
            System.out.println("getGeoAreasList");
            GeographicalAreaRecords instance = new GeographicalAreaRecords();
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea example = new GeographicalArea("area", 12, "4000-7", 1000, api);
            instance.addGeographicalArea(example);
            List<GeographicalArea> expResult = new ArrayList<>();
            expResult.add(example);
            List<GeographicalArea> result = instance.getGeoAreasList();
            assertEquals(expResult, result);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaRecordsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getGeoAreaByDesignation method, of class GeographicalAreaRecords.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetGeoAreaByDesignation() throws FileNotFoundException {
        try {
            System.out.println("getGeoAreaByDesignation");
            String designation = "area";
            GeographicalAreaRecords instance = new GeographicalAreaRecords();
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea example = new GeographicalArea("area", 12, "4000-7", 1000, api);
            instance.addGeographicalArea(example);
            GeographicalArea expResult = example;
            GeographicalArea result = instance.getGeoAreaByDesignation(designation);
            assertEquals(expResult, result);         
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaRecordsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testGetGeoAreaByDesignation2() throws FileNotFoundException {
        try {
            System.out.println("getGeoAreaByDesignation2");
            GeographicalAreaRecords instance = new GeographicalAreaRecords();
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea example = new GeographicalArea("area", 12, "4000-7", 1000, api);
            instance.addGeographicalArea(example);
            String designation2 = "nothing";
            GeographicalArea expResult2 = null;
            GeographicalArea result2 = instance.getGeoAreaByDesignation(designation2);
            assertEquals(expResult2, result2);         
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaRecordsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Test of registersGeographicalArea method, of class
     * GeographicalAreaRecords.
     */
    @Test
    public void testRegistersGeographicalArea() throws FileNotFoundException {
        try {
            System.out.println("registersGeographicalArea");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea ga = new GeographicalArea("area", 12, "4000-7", 1000, api);
            Instanciate.readPostalCodes("4000-7");
            GeographicalAreaRecords instance = new GeographicalAreaRecords();
            boolean expResult = true;
            boolean result = instance.registersGeographicalArea(ga);
            assertEquals(expResult, result);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaRecordsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of validatesGeographicalArea method, of class
     * GeographicalAreaRecords.
     */
    @Test
    public void testValidatesGeographicalArea() throws FileNotFoundException {
        try {
            System.out.println("validatesGeographicalArea");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea ga = new GeographicalArea("area", 12, "4000-7", 1000, api);
            Instanciate.readPostalCodes("4000-7");
            GeographicalAreaRecords instance = new GeographicalAreaRecords();
            boolean expResult = true;
            boolean result = instance.validatesGeographicalArea(ga);
            assertEquals(expResult, result);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaRecordsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testValidatesGeographicalArea2() throws FileNotFoundException {
        try {
            System.out.println("validatesGeographicalArea2");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea ga = new GeographicalArea("ar", 12, "4560-133", 1000, api);
            GeographicalAreaRecords instance = new GeographicalAreaRecords();
            boolean expResult2 = false;
            boolean result2 = instance.validatesGeographicalArea(ga);
            assertEquals(expResult2, result2);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaRecordsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        @Test
    public void testValidatesGeographicalArea3() throws FileNotFoundException {
        try {
            System.out.println("validatesGeographicalArea3");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea ga = new GeographicalArea("ar", 12, "4000-9", 1000, api);
            GeographicalAreaRecords instance = new GeographicalAreaRecords();
            instance.addGeographicalArea(new GeographicalArea("ar", 13, "4000-7",1000, api));
            boolean expResult2 = false;
            boolean result2 = instance.validatesGeographicalArea(ga);
            assertEquals(expResult2, result2);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaRecordsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Test of addGeographicalArea method, of class GeographicalAreaRecords.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testAddGeographicalArea() throws FileNotFoundException {
        try {
            System.out.println("addGeographicalArea");
            ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
            GeographicalArea ga = new GeographicalArea("area", 12, "4000-7", 1000, api);
            GeographicalAreaRecords instance = new GeographicalAreaRecords();
            boolean expResult = true;
            boolean result = instance.addGeographicalArea(ga);
            assertEquals(expResult, result);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GeographicalAreaRecordsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
