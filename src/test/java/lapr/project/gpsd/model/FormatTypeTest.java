/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import lapr.project.records.CategoryRecords;
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
public class FormatTypeTest {

    public FormatTypeTest() {
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
     * Test of newFileFormatter method, of class FormatType.
     */
    @Test
    public void testNewFileFormatter() throws Exception {
        System.out.println("newFileFormatter");
        Time time = new Time(10,0);
        ServiceProvider prov = new ServiceProvider("Pedro Brandao", "PB", 262916339, 937413466, "SP");
        LocalDate execDate = LocalDate.of(2019, Month.JUNE, 16);
        ServiceSchedule sched = new ServiceSchedule("aproved", execDate, time);
        PostalCode postalCode = new PostalCode("Lousada", 40.0, 30.0);
        PostalAddress postalAddress = new PostalAddress("Rua", postalCode, "Lousada");
        Client client = new Client("sd", "sd", "sd", "sd", postalAddress);
        ServiceOrder servOrder1 = new ServiceOrder(12, prov, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "dec", 1, new Category("da", "da")), "das", 1), sched, postalAddress, client);
        List<ServiceOrder> serviceOrders = new ArrayList<>();
        serviceOrders.add(servOrder1);
        String format = "XML";
        FormatType instance = new FormatType("lapr.project.gpsd.model.FileFormatterCSV", "CSV");
        FileFormatter expResult = new FileFormatterCSV(format);
        FileFormatter result = instance.newFileFormatter(format);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDesignation method, of class FormatType.
     */
    @Test
    public void testGetDesignation() {
        System.out.println("getDesignation");
        FormatType instance = new FormatType("lapr.project.gpsd.model.FileFormatterXML", "XML");
        String expResult = "lapr.project.gpsd.model.FileFormatterXML";
        String result = instance.getDesignation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdType method, of class FormatType.
     */
    @Test
    public void testGetIdType() {
        System.out.println("getIdType");
        FormatType instance = new FormatType("lapr.project.gpsd.model.FileFormatterXML", "XML");
        String expResult = "XML";
        String result = instance.getIdType();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDesignation method, of class FormatType.
     */
    @Test
    public void testSetDesignation() {
        System.out.println("setDesignation");
        String designation = "lapr.project.gpsd.model.FileFormatterCSV";
        FormatType instance = new FormatType("lapr.project.gpsd.model.FileFormatterXML", "XML");
        boolean result = instance.setDesignation(designation);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdType method, of class FormatType.
     */
    @Test
    public void testSetIdType() {
        System.out.println("setIdType");
        String idType = "CSV";
        FormatType instance = new FormatType("lapr.project.gpsd.model.FileFormatterXML", "XML");
        boolean result = instance.setDesignation(idType);
        boolean expResult = true;
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class FormatType.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FormatType instance = new FormatType("lapr.project.gpsd.model.FileFormatterXML", "XML");
        String expResult = "FormatType{designation=lapr.project.gpsd.model.FileFormatterXML, idType=XML}";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class FormatType.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new FormatType("lapr.project.gpsd.model.FileFormatterXML", "XML");
       FormatType instance = new FormatType("lapr.project.gpsd.model.FileFormatterXML", "XML");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object obj = new FormatType("lapr.project.gpsd.model.FileFormatterXML", "XML");
       FormatType instance = (FormatType) obj;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object obj = new CategoryRecords();
       FormatType instance = new FormatType("lapr.project.gpsd.model.FileFormatterXML", "XML");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
}
