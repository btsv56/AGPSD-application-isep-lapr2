/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.ExpandableService;
import lapr.project.gpsd.model.LimitedService;
import lapr.project.gpsd.model.Service;
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
public class ServiceRecordsTest {

    public ServiceRecordsTest() {
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
     * Test of registersService method, of class ServiceRecords.
     */
    @Test
    public void testRegistersService() {
        System.out.println("registersService");
        Category cat = new Category("cat1", "limpar");
        Service service = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        ServiceRecords instance = new ServiceRecords();
        boolean expResult = true;
        boolean result = instance.registersService(service);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegistersService2() {
        System.out.println("registersService");
        Service service = new ExpandableService(null, null, null, 0, null);
        ServiceRecords instance = new ServiceRecords();
        boolean expResult = false;
        boolean result = instance.registersService(service);
        assertEquals(expResult, result);
    }

    /**
     * Test of validatesService method, of class ServiceRecords.
     */
    @Test
    public void testValidatesService() {
        System.out.println("validatesService");
        Category cat = new Category("cat1", "limpar");
        Service service = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        ServiceRecords instance = new ServiceRecords();
        boolean expResult = true;
        boolean result = instance.validatesService(service);
        assertEquals(expResult, result);
    }

        @Test
    public void testValidatesService2() {
        System.out.println("validatesService");
        Category cat = new Category("cat1", "limpar");
        Service service = new ExpandableService(null, null, null, 0, cat);
        ServiceRecords instance = new ServiceRecords();
        boolean expResult = false;
        boolean result = instance.validatesService(service);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of verifyService method, of class ServiceRecords.
     */
    @Test
    public void testVerifyService() {
        System.out.println("verifyService");
        Category cat = new Category("cat1", "limpar");
        Service service = new LimitedService("lim1", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        ServiceRecords instance = new ServiceRecords();
        boolean expResult = true;
        boolean result = instance.verifyService(service);
        assertEquals(expResult, result);
    }

    public void testVerifyService2() {
        System.out.println("verifyService");
        Category cat = new Category("cat1", "limpar");
        Service service = new LimitedService("lim1", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        ServiceRecords instance = new ServiceRecords();
        instance.addService(service);
        boolean expResult = false;
        boolean result = instance.verifyService(service);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getServiceByCat method, of class ServiceRecords.
     */
    @Test
    public void testGetServiceByCat() {
        System.out.println("getServiceByCat");

        ServiceRecords instance = new ServiceRecords();

        Category cat = new Category("cat1", "limpar");
        Service service = new LimitedService("lim1", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        instance.addService(service);
        List<Service> expResult = new ArrayList<>();
        expResult.add(service);
        expResult.toString();
        List<Service> result = instance.getServiceByCat(cat);
        assertEquals(expResult, result);    
    }

    @Test
    public void testGetServiceByCat2() {
        System.out.println("getServiceByCat");
        ServiceRecords instance = new ServiceRecords();
        Category x = new Category("cat2", "clean");
        Category cat = new Category("Cat1", "limpeza");
        Service service = new LimitedService("lim1", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        instance.addService(service);
        List<Service> expResult2 = new ArrayList<>();
        List<Service> result2 = instance.getServiceByCat(x);
        assertEquals(expResult2, result2);
    }
}
