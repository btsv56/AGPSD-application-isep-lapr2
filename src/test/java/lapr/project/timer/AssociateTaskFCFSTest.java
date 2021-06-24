/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.timer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.Availability;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.FixedService;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequest;
import lapr.project.gpsd.model.Time;
import lapr.project.records.AssociationProviderRequestRecords;
import lapr.project.records.ServiceProviderRecords;
import lapr.project.records.ServiceProvidingRequestRecords;
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
public class AssociateTaskFCFSTest {

    public AssociateTaskFCFSTest() {
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
     * Test of associateSPtoRequest method, of class AssociateTaskFCFS.
     */
    @Test
    public void testAssociateSPtoRequest() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("associateSPtoRequest");
        try {
            ServiceProvidingRequestRecords requestRcds = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
            ServiceProvidingRequest request = new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123"));
            Category cat = new Category("123", "123");
            request.addServiceProvidingRequest(new FixedService("123", "123", "123", 30, cat), "desc", 30);
            request.addTime(LocalDate.of(2020, 12, 12), "13:00");
            requestRcds.registerRequestTest(request);
            AssociationProviderRequestRecords assRcds = AppGPSD.getInstance().getCompany().getAssociationRecords();
            ServiceProviderRecords spRcds = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
            ServiceProvider sp = spRcds.newServiceProvider("123", "123", 123123123, 123123123, "123");
            spRcds.registerServiceProvider(sp);
            sp.addCategory(cat);
            sp.getAvailabilityList().addAvailabilityTime(new Availability(LocalDate.of(2020, 1, 1), new Time("12:00"), LocalDate.of(2020, 12, 29), new Time("17:00"), "Everyday"));
            boolean expResult = true;
            AssociateTaskFCFS instance = new AssociateTaskFCFS(1);
            boolean result = instance.associateSPtoRequestTest(requestRcds.getRequestsList());
            assertEquals(expResult, result);
        } catch (Exception ex) {

        }
    }

}
