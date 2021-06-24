/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.records.CategoryRecords;
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
public class ServiceProvidingRequestTest {

    public ServiceProvidingRequestTest() {
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
     * Test of getDescriptionList method, of class ServiceProvidingRequest.
     */
    @Test
    public void testGetDescriptionList() {
        System.out.println("getDescriptionList");
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        ServiceProvidingRequestDescription sprd= new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30);
        ArrayList<ServiceProvidingRequestDescription> expResult = new ArrayList<>();
        expResult.add(sprd);
        instance.addServiceProvidingRequest(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30);
        ArrayList<ServiceProvidingRequestDescription> result = instance.getDescriptionList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTimePreferenceList method, of class ServiceProvidingRequest.
     */
    @Test
    public void testGetTimePreferenceList() {
        System.out.println("getTimePreferenceList");
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        TimePreference tm= new TimePreference(1, LocalDate.of(2020, Month.MARCH, 2), new Time("12:00"));
        ArrayList<TimePreference> expResult = new ArrayList<>();
        expResult.add(tm);
        instance.addTime(tm);
        ArrayList<TimePreference> result = instance.getTimePreferenceList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxDuration method, of class ServiceProvidingRequest.
     */
    @Test
    public void testGetMaxDuration() {
        System.out.println("getMaxDuration");
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        int expResult = 0;
        int result = instance.getMaxDuration();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMaxDuration2() {
        System.out.println("getMaxDuration");
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        instance.addServiceProvidingRequest(new LimitedService("as", "desc", "des", 1, new Category("code", "desc")), "desc", 30);
        instance.addServiceProvidingRequest(new LimitedService("as", "desc", "des", 1, new Category("code", "desc")), "desc", 60);
        int expResult = 60;
        int result = instance.getMaxDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClient method, of class ServiceProvidingRequest.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        Client expResult = client;
        Client result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumber method, of class ServiceProvidingRequest.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        int number = 1;
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        instance.setNumber(number);
    }

    /**
     * Test of addServiceProvidingRequest method, of class
     * ServiceProvidingRequest.
     */
    @Test
    public void testAddServiceProvidingRequest() {
        System.out.println("addServiceProvidingRequest");
        Service serv = new LimitedService("id", "desc", "desc", 30, new Category("code", "desc"));
        String desc = "desc";
        int dur = 30;
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        boolean expResult = true;
        boolean result = instance.addServiceProvidingRequest(serv, desc, dur);
        assertEquals(expResult, result);
    }

    /**
     * Test of addTime method, of class ServiceProvidingRequest.
     */
    @Test
    public void testAddTime_LocalDate_String() {
        System.out.println("addTime");
        LocalDate date = LocalDate.of(2020, Month.MARCH, 2);
        String hour = "12:00";
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        boolean expResult = true;
        boolean result = instance.addTime(date, hour);
        assertEquals(expResult, result);
    }

    /**
     * Test of addTime method, of class ServiceProvidingRequest.
     */
    @Test
    public void testAddTime_TimePreference() {
        System.out.println("addTime");
        TimePreference h = new TimePreference(1, LocalDate.of(2020, Month.MARCH, 2), new Time("12:00"));
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        boolean expResult = true;
        boolean result = instance.addTime(h);
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class ServiceProvidingRequest.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        Object o = new ServiceProvidingRequest(client, postalAddress);
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals4() {
        System.out.println("equals");
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        Object o = new ServiceProvidingRequest(client, postalAddress);
        ServiceProvidingRequest instance = new ServiceProvidingRequest(new Client("asd", "987654321", "987654321", "fa"), new PostalAddress("as", new PostalCode("4000-7"), "da"));
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals2() {
        System.out.println("equals");
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        Object o = new ServiceProvidingRequest(client, postalAddress);
        ServiceProvidingRequest instance = (ServiceProvidingRequest) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals3() {
        System.out.println("equals");
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        Object o = new CategoryRecords();
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ServiceProvidingRequest.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        String expResult = "Client: Veiga | Postal Code: 4000-9 | Services: ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostalAddress method, of class ServiceProvidingRequest.
     */
    @Test
    public void testGetPostalAddress() {
        System.out.println("getPostalAddress");
        Client client = new Client("Veiga", "123456789", "124567890", "dsa");
        PostalAddress postalAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        ServiceProvidingRequest instance = new ServiceProvidingRequest(client, postalAddress);
        PostalAddress expResult = postalAddress;
        PostalAddress result = instance.getPostalAddress();
        assertEquals(expResult, result);
    }

}
