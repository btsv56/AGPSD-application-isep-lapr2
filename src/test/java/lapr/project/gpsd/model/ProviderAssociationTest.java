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
 * @author lulu
 */
public class ProviderAssociationTest {
    
    public ProviderAssociationTest() {
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
     * Test of getPSId method, of class ProviderAssociation.
     */
    @Test
    public void testGetPSId() {
        System.out.println("getPSId");
        ProviderAssociation instance = new ProviderAssociation(new ServiceProvider("123", "123", 123123123, 123123123, "123"), new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123")));
        String expResult = "123, 0";
        String result = instance.getPSId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProvider method, of class ProviderAssociation.
     */
    @Test
    public void testGetProvider() {
        System.out.println("getProvider");
        ProviderAssociation instance = new ProviderAssociation(new ServiceProvider("123", "123", 123123123, 123123123, "123"), new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123")));
        ServiceProvider expResult = new ServiceProvider("123", "123", 123123123, 123123123, "123");
        ServiceProvider result = instance.getProvider();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequest method, of class ProviderAssociation.
     */
    @Test
    public void testGetRequest() {
        System.out.println("getRequest");
        ProviderAssociation instance = new ProviderAssociation(new ServiceProvider("123", "123", 123123123, 123123123, "123"), new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123")));
        ServiceProvidingRequest expResult = new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123"));
        ServiceProvidingRequest result = instance.getRequest();
        assertEquals(expResult, result);
    }
    
}
