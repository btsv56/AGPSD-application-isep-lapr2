/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import lapr.project.records.ServiceProviderRecords;
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
public class ServiceProvidingRequestDescriptionTest {

    public ServiceProvidingRequestDescriptionTest() {
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
     * Test of getService method, of class ServiceProvidingRequestDescription.
     */
    @Test
    public void testGetService() {
        System.out.println("getService");
        Service serv = new LimitedService("id", "desc", "desc", 1, new Category("code", "desc"));
        ServiceProvidingRequestDescription instance = new ServiceProvidingRequestDescription(serv, "desc", 1);
        Service expResult = serv;
        Service result = instance.getService();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDuration method, of class ServiceProvidingRequestDescription.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        Service serv = new LimitedService("id", "desc", "desc", 1, new Category("code", "desc"));
        ServiceProvidingRequestDescription instance = new ServiceProvidingRequestDescription(serv, "desc", 1);
        int expResult = 1;
        int result = instance.getDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCost method, of class ServiceProvidingRequestDescription.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        Service serv = new LimitedService("id", "desc", "desc", 1, new Category("code", "desc"));
        ServiceProvidingRequestDescription instance = new ServiceProvidingRequestDescription(serv, "desc", 1);
        double expResult = 0.016;
        double result = instance.getCost();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of equals method, of class ServiceProvidingRequestDescription.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Service serv = new LimitedService("id", "desc", "desc", 1, new Category("code", "desc"));
        Object o = new ServiceProvidingRequestDescription(serv, "desc", 1);
        ServiceProvidingRequestDescription instance = new ServiceProvidingRequestDescription(serv, "desc", 1);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals2() {
        System.out.println("equals");
        Service serv = new LimitedService("id", "desc", "desc", 1, new Category("code", "desc"));
        Object o = new ServiceProvidingRequestDescription(serv, "desc", 1);
        ServiceProvidingRequestDescription instance = (ServiceProvidingRequestDescription) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals3() {
        System.out.println("equals");
        Service serv = new LimitedService("id", "desc", "desc", 1, new Category("code", "desc"));
        Object o = new ServiceProviderRecords();
        ServiceProvidingRequestDescription instance = new ServiceProvidingRequestDescription(serv, "desc", 1);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

}
