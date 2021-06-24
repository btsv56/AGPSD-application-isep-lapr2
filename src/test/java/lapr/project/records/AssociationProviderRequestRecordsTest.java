/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.AssociationSPtoRequest;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lulu
 */
public class AssociationProviderRequestRecordsTest {
    
    public AssociationProviderRequestRecordsTest() {
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
     * Test of addAssociation method, of class AssociationProviderRequestRecords.
     */
    @Test
    public void testAddAssociation() {
        System.out.println("addAssociation");
        ServiceProvider sp = new ServiceProvider("123", "123", 123123123, 123123123, "123");
        ServiceProvidingRequest request = new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123"));
        AssociationProviderRequestRecords instance = new AssociationProviderRequestRecords();
        boolean expResult = true;
        boolean result = instance.addAssociation(sp, request);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAssociationsList method, of class AssociationProviderRequestRecords.
     */
    @Test
    public void testGetAssociationsList() {
        System.out.println("getAssociationsList");
        AssociationProviderRequestRecords instance = new AssociationProviderRequestRecords();
        List<AssociationSPtoRequest> expResult = new ArrayList<>();
        List<AssociationSPtoRequest> result = instance.getAssociationsList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnassociatedRequests method, of class AssociationProviderRequestRecords.
     */
    @Test
    public void testGetUnassociatedRequests() {
        System.out.println("getUnassociatedRequests");
        List<ServiceProvidingRequest> expResult = new ArrayList<>();
        AssociationProviderRequestRecords instance = new AssociationProviderRequestRecords();
        List<ServiceProvidingRequest> result = instance.getUnassociatedRequests();
        assertEquals(expResult, result);
    }
    
}
