/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.ServiceType;
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
public class ServiceTypesRecordsTest {
    
    public ServiceTypesRecordsTest() {
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
     * Test of getServiceTypes method, of class ServiceTypesRecords.
     */
    @Test
    public void testGetServiceTypes() throws FileNotFoundException {
        System.out.println("getServiceTypes");
        ServiceTypesRecords instance = new ServiceTypesRecords();
        AppGPSD app = AppGPSD.getInstance();
        Properties props = app.getProperties();
        instance.createsServiceTypesSupported(props);
        ServiceType a = new ServiceType("lapr.project.gpsd.model.FixedService", "Fixed");
        ServiceType b = new ServiceType("lapr.project.gpsd.model.LimitedService", "Limited");
        ServiceType c = new ServiceType("lapr.project.gpsd.model.ExpandableService", "Expandable");
        List<ServiceType> expResult = new ArrayList<>();
        expResult.add(a);
        expResult.add(b);
        expResult.add(c);
        List<ServiceType> result = instance.getServiceTypes();
        assertEquals(expResult, result);
    }

    /**
     * Test of createsServiceTypesSupported method, of class ServiceTypesRecords.
     */
    @Test
    public void testCreatesServiceTypesSupported() throws FileNotFoundException {
        System.out.println("createsServiceTypesSupported");
        AppGPSD app = AppGPSD.getInstance();
        Properties props = app.getProperties();
        ServiceTypesRecords instance = new ServiceTypesRecords();
        boolean expResult = true;
        boolean result = instance.createsServiceTypesSupported(props);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceTypeByID method, of class ServiceTypesRecords.
     */
    @Test
    public void testGetServiceTypeByID() throws FileNotFoundException {
        System.out.println("getServiceTypeByID");
        String idType = "Limited";
        ServiceTypesRecords instance = new ServiceTypesRecords();
        AppGPSD app = AppGPSD.getInstance();
        Properties props = app.getProperties();
        instance.createsServiceTypesSupported(props);
        ServiceType expResult = new ServiceType(props.getProperty(Constants.SERVICE_TYPE_2_DESIG), props.getProperty(Constants.SERVICE_TYPE_2_ID));
        ServiceType result = instance.getServiceTypeByID(idType);
        assertEquals(expResult, result);
    }
    
}
