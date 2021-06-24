/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
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
public class AssociationSPtoRequestTest {
    
    public AssociationSPtoRequestTest() {
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
     * Test of getRequestDescription method, of class AssociationSPtoRequest.
     */
    @Test
    public void testGetRequestDescription() {
        System.out.println("getRequestDescription");
        ServiceProvidingRequest request=new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123"));
        Category cat =new Category("123","123");
        ServiceProvidingRequestDescription desc = new ServiceProvidingRequestDescription(new FixedService("123","123","123",30.0,cat),"desc", 30);
        request.addServiceProvidingRequest(new FixedService("123","123","123",30.0,cat),"desc", 30);
        AssociationSPtoRequest instance = new AssociationSPtoRequest(new ServiceProvider("123", "123", 123123123, 123123123, "123"), request);
        List<ServiceProvidingRequestDescription> expResult = new ArrayList<>();
        expResult.add(desc);
        List<ServiceProvidingRequestDescription> result = instance.getRequestDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProviderAssociation method, of class AssociationSPtoRequest.
     */
    @Test
    public void testGetProviderAssociation() {
        System.out.println("getProviderAssociation");
        AssociationSPtoRequest instance = new AssociationSPtoRequest(new ServiceProvider("123", "123", 123123123, 123123123, "123"), new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123")));
        ProviderAssociation expResult = new ProviderAssociation(new ServiceProvider("123", "123", 123123123, 123123123, "123"), new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123")));
        ProviderAssociation result = instance.getProviderAssociation();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class AssociationSPtoRequest.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AssociationSPtoRequest instance = new AssociationSPtoRequest(new ServiceProvider("123", "123", 123123123, 123123123, "123"), new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123")));
        ProviderAssociation pAss = new ProviderAssociation(new ServiceProvider("123", "123", 123123123, 123123123, "123"), new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123")));
        String expResult = pAss.getPSId();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
