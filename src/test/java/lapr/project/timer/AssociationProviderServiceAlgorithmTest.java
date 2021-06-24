/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.timer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.Month;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.Availability;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.FixedService;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequest;
import lapr.project.gpsd.model.Time;
import lapr.project.records.ServiceProviderRecords;
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
public class AssociationProviderServiceAlgorithmTest {

    public AssociationProviderServiceAlgorithmTest() {
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
     * Test of associate method, of class AssociationProviderServiceAlgorithm.
     */
    @Test
    public void test1Associate() throws UnsupportedEncodingException, FileNotFoundException {
        try {
            System.out.println("associate1");
            ServiceProvidingRequest request = new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123"));
            Category cat = new Category("123", "123");
            request.addServiceProvidingRequest(new FixedService("123", "123", "123", 30.0, cat), "desc", 30);
            request.addTime(LocalDate.of(2020, 12, 12), "13:00");
            ServiceProviderRecords spRcds = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
            ServiceProvider sp1 = spRcds.newServiceProvider("1", "1", 111111111, 123123123, "1");
            sp1.addCategory(cat);
            sp1.getAvailabilityList().addAvailabilityTime(new Availability(LocalDate.of(2020, 1, 1), new Time("12:00"), LocalDate.of(2020, 12, 29), new Time("17:00"), "Everyday"));
            sp1.addPostalAddress(new PostalAddress("1", new PostalCode("1", 13, 12), "1"));
            spRcds.registerServiceProvider(sp1);
            AssociationProviderServiceAlgorithm instance = new AssociationProviderServiceAlgorithm();
            boolean expResult = true;
            boolean result = instance.associate(request);
            assertEquals(expResult, result);
        } catch (Exception ex) {

        }
    }

    /**
     * Test of associate method, of class AssociationProviderServiceAlgorithm.
     */
    @Test
    public void test2Associate() throws UnsupportedEncodingException, FileNotFoundException {
        try {
            System.out.println("associate2");
            ServiceProvidingRequest request = new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123"));
            Category cat = new Category("123", "123");
            request.addServiceProvidingRequest(new FixedService("123", "123", "123", 30.0, cat), "desc", 30);
            request.addTime(LocalDate.of(2020, 12, 12), "13:00");
            ServiceProviderRecords spRcds = AppGPSD.getInstance().getCompany().getServiceProviderRecords();

            ServiceProvider sp1 = spRcds.newServiceProvider("1", "1", 111111111, 123123123, "1");
            sp1.addCategory(cat);
            sp1.getAvailabilityList().addAvailabilityTime(new Availability(LocalDate.of(2020, 1, 1), new Time("12:00"), LocalDate.of(2020, 12, 29), new Time("17:00"), "Everyday"));
            sp1.addPostalAddress(new PostalAddress("1", new PostalCode("1", 13, 12), "1"));
            spRcds.registerServiceProvider(sp1);
            
            ServiceProvider sp2 = spRcds.newServiceProvider("2", "2", 222222222, 123123123, "2");
            sp2.addCategory(cat);
            sp2.getAvailabilityList().addAvailabilityTime(new Availability(LocalDate.of(2020, 1, 1), new Time("12:00"), LocalDate.of(2020, 12, 29), new Time("17:00"), "Everyday"));
            sp2.addPostalAddress(new PostalAddress("2", new PostalCode("2", 200, 200), "2"));
            spRcds.registerServiceProvider(sp2);
            
            ServiceProvider sp3 = spRcds.newServiceProvider("3", "3", 333333333, 123123123, "3");
            sp3.addCategory(cat);
            sp3.getAvailabilityList().addAvailabilityTime(new Availability(LocalDate.of(2020, 1, 1), new Time("12:00"), LocalDate.of(2020, 12, 29), new Time("17:00"), "Everyday"));
            sp3.addPostalAddress(new PostalAddress("3", new PostalCode("3", 123, 124), "3"));
            spRcds.registerServiceProvider(sp3);

            AssociationProviderServiceAlgorithm instance = new AssociationProviderServiceAlgorithm();
            boolean expResult = true;
            boolean result = instance.associate(request);
            assertEquals(expResult, result);
        } catch (Exception e) {
        }
    }

}
