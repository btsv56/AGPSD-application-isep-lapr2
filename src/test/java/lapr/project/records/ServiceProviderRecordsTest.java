/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.ServiceProvider;
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
public class ServiceProviderRecordsTest {

    public ServiceProviderRecordsTest() {
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
     * Test of getServiceProvider method, of class ServiceProviderRecords.
     */
    @Test
    public void testGetServiceProvider() {
        System.out.println("getServiceProvider");
        String email = "joaoratao@gmail.com";
        ServiceProviderRecords instance = new ServiceProviderRecords();
        ServiceProvider expResult = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        instance.getServiceProviderList().add(expResult);
        ServiceProvider result = instance.getServiceProvider(email);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetServiceProvider2() {
        System.out.println("getServiceProvider");
        String email = "joaoratao@gmail.com";
        ServiceProviderRecords instance = new ServiceProviderRecords();
        ServiceProvider expResult = null;
        ServiceProvider result = instance.getServiceProvider(email);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetServiceProvider3() {
        System.out.println("getServiceProvider");
        String email = "joaoaratao@gmail.com";
        ServiceProviderRecords instance = new ServiceProviderRecords();
        ServiceProvider expResult = null;
        instance.getServiceProviderList().add(new ServiceProvider("d", "f", 123456789, 123456789, "a"));
        ServiceProvider result = instance.getServiceProvider(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of newServiceProvider method, of class ServiceProviderRecords.
     */
    @Test
    public void testNewServiceProvider() {
        System.out.println("newServiceProvider");
        String fullName = "Pedro Brandao";
        String abrevName = "PB";
        int tinNumber = 151805228;
        int phoneNumber = 932412321;
        String email = "joaoratao@gmail.com";
        ServiceProviderRecords instance = new ServiceProviderRecords();
        ServiceProvider expResult = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        ServiceProvider result = instance.newServiceProvider(fullName, abrevName, tinNumber, phoneNumber, email);
        assertEquals(expResult, result);

    }

    /**
     * Test of getServiceProviderList method, of class ServiceProviderRecords.
     */
    @Test
    public void testGetServiceProviderList() {
        System.out.println("getServiceProviderList");
        ServiceProviderRecords instance = new ServiceProviderRecords();
        ServiceProvider servProv1 = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        ServiceProvider servProv2 = new ServiceProvider("Joao Ratao", "JR", 151812328, 943212321, "pedrobrandao@gmail.com");
        List<ServiceProvider> expResult = new ArrayList<>();
        List<ServiceProvider> result = instance.getServiceProviderList();
        assertEquals(expResult, result);
    }

    /**
     * Test of registerServiceProvider method, of class ServiceProviderRecords.
     */
    @Test
    public void testRegisterServiceProvider() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("registerServiceProvider");
        ServiceProvider servProv = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");
        ServiceProviderRecords instance = new ServiceProviderRecords();
        boolean expResult = true;
        boolean result = instance.registerServiceProvider(servProv);
        assertEquals(expResult, result);
    }

    @Test
    public void testRegisterServiceProvider2() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("registerServiceProvider");
        ServiceProvider servProv = new ServiceProvider("", "PB", 1, 1, "");
        ServiceProviderRecords instance = new ServiceProviderRecords();
        boolean expResult = false;
        boolean result = instance.registerServiceProvider(servProv);
        assertEquals(expResult, result);
    }

    /**
     * Test of addServiceProvider method, of class ServiceProviderRecords.
     */
    @Test
    public void testAddServiceProvider() {
        System.out.println("addServiceProvider");
        ServiceProvider servProv = new ServiceProvider("Pedro Brandao", "PB", 151805228, 932412321, "joaoratao@gmail.com");;
        ServiceProviderRecords instance = new ServiceProviderRecords();
        boolean expResult = true;
        boolean result = instance.addServiceProvider(servProv);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateServiceProvider method, of class ServiceProviderRecords.
     */
    @Test
    public void testValidateServiceProvider() {
        System.out.println("validateServiceProvider");
        ServiceProvider servProv = new ServiceProvider("Pedro Brandao", "PB", 123456789, 123456789, "joaoratao@gmail.com");
        ServiceProviderRecords instance = new ServiceProviderRecords();
        boolean expResult = true;
        boolean result = instance.validateServiceProvider(servProv);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of validateServiceProvider method, of class ServiceProviderRecords.
//     */
//    @Test
//    public void testValidateServiceProvider2() {
//        System.out.println("validateServiceProvider");
//        ServiceProvider servProv = new ServiceProvider(null, "PB", 123456789, 123456789, "joaoratao@gmail.com");
//        ServiceProviderRecords instance = new ServiceProviderRecords();
//        boolean expResult = false;
//        boolean result = instance.validateServiceProvider(servProv);
//        assertEquals(result, expResult);
//    }
//
//    /**
//     * Test of validateServiceProvider method, of class ServiceProviderRecords.
//     */
//    @Test
//    public void testValidateServiceProvider3() {
//        System.out.println("validateServiceProvider");
//        ServiceProvider servProv = new ServiceProvider("Pedro Brandao", "", 123456789, 123456789, "joaoratao@gmail.com");
//        ServiceProviderRecords instance = new ServiceProviderRecords();
//        boolean expResult = true;
//        boolean result = instance.validateServiceProvider(servProv);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of validateServiceProvider method, of class ServiceProviderRecords.
//     */
//    @Test
//    public void testValidateServiceProvider4() {
//        System.out.println("validateServiceProvider");
//        ServiceProvider servProv = new ServiceProvider("Pedro Brandao", null, 123456789, 123456789, "joaoratao@gmail.com");
//        ServiceProviderRecords instance = new ServiceProviderRecords();
//        boolean expResult = false;
//        boolean result = instance.validateServiceProvider(servProv);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of validateServiceProvider method, of class ServiceProviderRecords.
//     */
//    @Test
//    public void testValidateServiceProvider5() {
//        System.out.println("validateServiceProvider");
//        ServiceProvider servProv = new ServiceProvider("Pedro Brandao", "PB", 123456789, 123456789, null);
//        ServiceProviderRecords instance = new ServiceProviderRecords();
//        boolean expResult = false;
//        boolean result = instance.validateServiceProvider(servProv);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of validateServiceProvider method, of class ServiceProviderRecords.
//     */
//    @Test
//    public void testValidateServiceProvider6() {
//        System.out.println("validateServiceProvider");
//        ServiceProvider servProv = new ServiceProvider("Pedro Brandao", "PB", 1232456789, 123456789, "joaoratao@gmail.com");
//        ServiceProviderRecords instance = new ServiceProviderRecords();
//        boolean expResult = false;
//        boolean result = instance.validateServiceProvider(servProv);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of validateServiceProvider method, of class ServiceProviderRecords.
//     */
//    @Test
//    public void testValidateServiceProvider7() {
//        System.out.println("validateServiceProvider");
//        ServiceProvider servProv = new ServiceProvider("Pedro Brandao", "PB", 123456789, 1234536789, "joaoratao@gmail.com");
//        ServiceProviderRecords instance = new ServiceProviderRecords();
//        boolean expResult = false;
//        boolean result = instance.validateServiceProvider(servProv);
//        assertEquals(expResult, result);
//    }
    /**
     * Test of generatePWD method, of class ServiceProviderRecords.
     */
    @Test
    public void testGeneratePWD() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("generatePWD");
        ServiceProviderRecords instance = new ServiceProviderRecords();
        int expResult = Constants.PASSWORD_LENGTH;
        int result = instance.generatePWD().length();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ServiceProviderRecords.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Object();
        ServiceProviderRecords instance = new ServiceProviderRecords();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ServiceProviderRecords.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        ServiceProviderRecords obj = new ServiceProviderRecords();
        ServiceProvider servProv = new ServiceProvider("Pedro Brandao", "PB", 123456789, 1234536789, "joaoratao@gmail.com");
        obj.addServiceProvider(servProv);
        ServiceProviderRecords instance = new ServiceProviderRecords();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ServiceProviderRecords.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals");
        ServiceProviderRecords obj = new ServiceProviderRecords();
        ServiceProvider servProv = new ServiceProvider("Pedro Brandao", "PB", 123456789, 1234536789, "joaoratao@gmail.com");
        obj.addServiceProvider(servProv);
        ServiceProviderRecords instance = new ServiceProviderRecords();
        instance.addServiceProvider(servProv);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals4() {
        System.out.println("equals");
        Object obj = new ServiceProviderRecords();
        ServiceProviderRecords instance = (ServiceProviderRecords) obj;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

}
