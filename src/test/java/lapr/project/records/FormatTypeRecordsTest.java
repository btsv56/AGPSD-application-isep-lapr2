/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.FormatType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class FormatTypeRecordsTest {

    public FormatTypeRecordsTest() {
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
     * Test of getFormatTypes method, of class FormatTypeRecords.
     */
    @Test
    public void testGetFormatTypes() {
        System.out.println("getFormatTypes");
        FormatTypeRecords instance = new FormatTypeRecords();
        AppGPSD app = AppGPSD.getInstance();
        Properties props = app.getProperties();
        instance.createsFormatTypesSupported(props);
        FormatType format1 = new FormatType("lapr.project.gpsd.model.FileFormatterCSV", "CSV");
        FormatType format2 = new FormatType("lapr.project.gpsd.model.FileFormatterXML", "XML");
        FormatType format3 = new FormatType("lapr.project.gpsd.model.FileFormatterXLS", "XLS");
        List<FormatType> expResult = new ArrayList<>();
        expResult.add(format2);
        expResult.add(format1);
        expResult.add(format3);
        List<FormatType> result = instance.getFormatTypes();
        assertEquals(expResult, result);
    }

    /**
     * Test of createsFormatTypesSupported method, of class FormatTypeRecords.
     */
    @Test
    public void testCreatesFormatTypesSupported() {
        System.out.println("createsFormatTypesSupported");
        AppGPSD app = AppGPSD.getInstance();
        Properties props = app.getProperties();
        FormatTypeRecords instance = new FormatTypeRecords();
        boolean expResult = true;
        boolean result = instance.createsFormatTypesSupported(props);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatTypeByDesignation method, of class FormatTypeRecords.
     */
    @Test
    public void testGetFormatTypeByDesignation() {
        System.out.println("getFormatTypeByDesignation");
        String designation = "lapr.project.gpsd.model.FileFormatterCSV";
        FormatTypeRecords instance = new FormatTypeRecords();
        AppGPSD app = AppGPSD.getInstance();
        Properties props = app.getProperties();
        instance.createsFormatTypesSupported(props);
        FormatType expResult = new FormatType("lapr.project.gpsd.model.FileFormatterCSV", "CSV");
        FormatType result = instance.getFormatTypeByDesignation(designation);
        assertEquals(expResult, result);
    }
}
