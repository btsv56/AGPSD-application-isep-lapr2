/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

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
public class ServiceTypeTest {
    
    public ServiceTypeTest() {
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
     * NEEDS TO BE CORRECTED
     * 
     * Test of newService method, of class ServiceType.
     */
    @Test
    public void testNewService() throws Exception {
        System.out.println("newService");
        String id = "222";
        String briefDesc = "limpeza";
        String compDesc = "limpeza geral a uma casa";
        double cost = 5.0;
        Category cat = new Category("cat1", "limpar");
        ServiceType instance = new ServiceType("lapr.project.gpsd.model.ExpandableService", "Expandable");
        Service expResult = new ExpandableService("222","limpeza", "limpeza geral a uma casa", 5.0, cat);
        Service result = instance.newService(id, briefDesc, compDesc, cost, cat);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdType method, of class ServiceType.
     */
    @Test
    public void testGetIdType() {
        System.out.println("getIdType");
        ServiceType instance = new ServiceType("lapr.project.gpsd.model.ExpandableService", "Expandable");
        String expResult = "Expandable";
        String result = instance.getIdType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDesignation method, of class ServiceType.
     */
    @Test
    public void testGetDesignation() {
        System.out.println("getDesignation");
        ServiceType instance = new ServiceType("lapr.project.gpsd.model.ExpandableService", "Expandable");
        String expResult = "lapr.project.gpsd.model.ExpandableService";
        String result = instance.getDesignation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdType method, of class ServiceType.
     */
    @Test
    public void testSetIdType() {
        System.out.println("setIdType");
        String idType = "Fixed";
        ServiceType instance = new ServiceType("ExpandableService", "Expandable");;
        instance.setIdType(idType);
        String result = instance.getIdType();
        assertEquals(result, idType);
    }

    /**
     * Test of setDesignation method, of class ServiceType.
     */
    @Test
    public void testSetDesignation() {
        System.out.println("setDesignation");
        String designation = "FixedService";
        ServiceType instance = new ServiceType("ExpandableService", "Expandable");
        instance.setDesignation(designation);
        String result = instance.getDesignation();
        assertEquals(result, designation);

    }

    /**
     * Test of toString method, of class ServiceType.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ServiceType instance = new ServiceType("ExpandableService", "Expandable");
        String expResult = String.format(" %s - %s ", instance.getDesignation(), instance.getIdType());
        String result = instance.toString();
        assertEquals(expResult, result);

    }
    
}
