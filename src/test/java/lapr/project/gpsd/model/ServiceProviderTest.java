/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.records.AvailabilityList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class ServiceProviderTest {

    public ServiceProviderTest() {
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
     * Test of getFullName method, of class ServiceProvider.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        String expResult = "Pedro Brandao";
        String result = instance.getFullName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAbrevName method, of class ServiceProvider.
     */
    @Test
    public void testGetAbrevName() {
        System.out.println("getAbrevName");
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        String expResult = "PB";
        String result = instance.getAbrevName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTinNumber method, of class ServiceProvider.
     */
    @Test
    public void testGetTinNumber() {
        System.out.println("getTinNumber");
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        int expResult = 151805228;
        int result = instance.getTinNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhoneNumber method, of class ServiceProvider.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        int expResult = 932412321;
        int result = instance.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class ServiceProvider.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        String expResult = "joaoratao@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of getAvailabilityList method, of class ServiceProvider.
//     */
//    @Test
//    public void testGetAvailabilityList() {
//        System.out.println("getAvailabilityList");
//        Availability availability1 = new Availability(LocalDate.of(2019, Month.MARCH, 23), new Time(12, 00), LocalDate.of(2020, Month.MARCH, 1), new Time(13, 00), "");
//        Availability availability2 = new Availability(LocalDate.of(2019, Month.MARCH, 23), new Time(12, 00), LocalDate.of(2020, Month.MARCH, 1), new Time(13, 00), "");
//        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
//        AvailabilityList result = instance.getAvailabilityList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of setFullName method, of class ServiceProvider.
     */
    @Test
    public void testSetFullName() {
        System.out.println("setFullName");
        String fullName = "Joao Ratao";
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        instance.setFullName(fullName);
        assertTrue("Joao Ratao".equals(instance.getFullName()));
    }

    /**
     * Test of setAbrevName method, of class ServiceProvider.
     */
    @Test
    public void testSetAbrevName() {
        System.out.println("setAbrevName");
        String abrevName = "JR";
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        instance.setAbrevName(abrevName);
        assertTrue("JR".equals(instance.getAbrevName()));
    }

    /**
     * Test of setTinNumber method, of class ServiceProvider.
     */
    @Test
    public void testSetTinNumber() {
        System.out.println("setTinNumber");
        int tinNumber = 12111;
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        instance.setTinNumber(tinNumber);
        assertTrue(12111 == instance.getTinNumber());
    }

    /**
     * Test of setPhoneNumber method, of class ServiceProvider.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        int phoneNumber = 123412;
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        instance.setPhoneNumber(phoneNumber);
        assertTrue(123412 == instance.getPhoneNumber());
    }

    /**
     * Test of setMechaNumber method, of class ServiceProvider.
     */
    @Test
    public void testSetMechaNumber() {
        System.out.println("setMechaNumber");
        int mechaNumber = 123;
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        instance.setMechaNumber(mechaNumber);
        assertTrue(123 == instance.getMechaNumber());
    }

    /**
     * Test of setEmail method, of class ServiceProvider.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "joaoratao@gmail.com";
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        instance.setEmail(email);
        assertTrue("joaoratao@gmail.com".equals(instance.getEmail()));
    }

    /**
     * Test of addCategory method, of class ServiceProvider.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        Category cat = new Category("111", "limpar o chao");
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        boolean expResult = true;
        boolean result = instance.addCategory(cat);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of addGeographicalArea method, of class ServiceProvider.
//     */
//    @Test
//    public void testAddGeographicalArea() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        System.out.println("addGeographicalArea");
//        AppGPSD app = AppGPSD.getInstance();
//        Company company = app.getCompany();
//        ExternalService api = company.getExternalService();
//        GeographicalArea area = new GeographicalArea("Porto", 3, "4000-09", 2, api);
//        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
//        boolean expResult = true;
//        boolean result = instance.addGeographicalArea(area);
//        assertEquals(expResult, result);
//    }
    /**
     * Test of hasEmail method, of class ServiceProvider.
     */
    @Test
    public void testHasEmail() {
        System.out.println("hasEmail");
        String email = "joaoratao@gmail.com";
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        boolean expResult = true;
        boolean result = instance.hasEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ServiceProvider.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        ServiceProvider instance = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

}
