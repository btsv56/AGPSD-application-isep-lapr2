/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.Month;
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
public class ServiceOrderTest {

    public ServiceOrderTest() {
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
     * Test of getProvider method, of class ServiceOrder.
     */
    @Test
    public void testGetProvider() {
        System.out.println("getProvider");
        Time time = new Time(10,0);
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        ServiceProvider expResult = new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos");
        ServiceProvider result = instance.getProvider();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescServ method, of class ServiceOrder.
     */
    @Test
    public void testGetDescServ() {
        System.out.println("getDescServ");
        Time time = new Time(10,0);
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        ServiceProvidingRequestDescription expResult = new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30);
        ServiceProvidingRequestDescription result = instance.getDescServ();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServSchedule method, of class ServiceOrder.
     */
    @Test
    public void testGetServSchedule() {
        System.out.println("getServSchedule");
        Time time = new Time(10,0);
        ServiceSchedule expResult = new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time);
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), expResult, new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));

        ServiceSchedule result = instance.getServSchedule();
        assertEquals(expResult, result);
    }

    /**
     * Test of getpAddress method, of class ServiceOrder.
     */
    @Test
    public void testGetpAddress() {
        System.out.println("getpAddress");
        Time time = new Time(10,0);
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        PostalAddress expResult = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        PostalAddress result = instance.getpAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCli method, of class ServiceOrder.
     */
    @Test
    public void testGetCli() {
        System.out.println("getCli");
        Time time = new Time(10,0);
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        Client expResult = new Client("Joao", "123456789", "123456789", "Joao");
        Client result = instance.getCli();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmissionDate method, of class ServiceOrder.
     */
    @Test
    public void testGetEmissionDate() {
        System.out.println("getEmissionDate");
        Time time = new Time(10,0);
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        LocalDate expResult = null;
        LocalDate result = instance.getEmissionDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRateState method, of class ServiceOrder.
     */
    @Test
    public void testGetRateState() {
        System.out.println("getRateState");
        Time time = new Time(10,0);
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        String expResult = "Not Rated";
        String result = instance.getRateState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getExecutionState method, of class ServiceOrder.
     */
    @Test
    public void testGetExecutionState() {
        System.out.println("getExecutionState");
        Time time = new Time(10,0);
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        String expResult = "Not Executed";
        String result = instance.getExecutionState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class ServiceOrder.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        Time time = new Time(10,0);
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        int expResult = 1;
        int result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProvider method, of class ServiceOrder.
     */
    @Test
    public void testSetProvider() {
        System.out.println("setProvider");
        Time time = new Time(10,0);
        ServiceProvider provider = new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos");
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        instance.setProvider(provider);
    }

    /**
     * Test of setDescServ method, of class ServiceOrder.
     */
    @Test
    public void testSetDescServ() {
        System.out.println("setDescServ");
        Time time = new Time(10,0);
        ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30);
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        instance.setDescServ(descServ);
    }

    /**
     * Test of setServSchedule method, of class ServiceOrder.
     */
    @Test
    public void testSetServSchedule() {
        System.out.println("setServSchedule");
        Time time = new Time(10,0);
        ServiceSchedule servSchedule = new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time);
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        instance.setServSchedule(servSchedule);
    }

    /**
     * Test of setpAddress method, of class ServiceOrder.
     */
    @Test
    public void testSetpAddress() {
        System.out.println("setpAddress");
        Time time = new Time(10,0);
        PostalAddress pAddress = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        instance.setpAddress(pAddress);
    }

    /**
     * Test of setCli method, of class ServiceOrder.
     */
    @Test
    public void testSetCli() {
        System.out.println("setCli");
        Time time = new Time(10,0);
        Client cli = new Client("Albert", "123456789", "123456789", "Albert");
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        instance.setCli(cli);
    }

    /**
     * Test of setEmissionDate method, of class ServiceOrder.
     */
    @Test
    public void testSetEmissionDate() {
        System.out.println("setEmissionDate");
        Time time = new Time(10,0);
        LocalDate emissionDate = LocalDate.of(2020, Month.MARCH, 2);
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        instance.setEmissionDate(emissionDate);
    }

    /**
     * Test of setNumber method, of class ServiceOrder.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        Time time = new Time(10,0);
        int number = 0;
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        instance.setNumber(number);
    }

    /**
     * Test of setExecutionState method, of class ServiceOrder.
     */
    @Test
    public void testSetExecutionState() {
        System.out.println("setExecutionState");
        Time time = new Time(10,0);
        String executionState = "";
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        instance.setExecutionState(executionState);
    }

    /**
     * Test of setRateState method, of class ServiceOrder.
     */
    @Test
    public void testSetRateState() {
        System.out.println("setRateState");
        Time time = new Time(10,0);
        String rateState = "Executed";
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        instance.setRateState(rateState);
    }

    /**
     * Test of hasServProv method, of class ServiceOrder.
     */
    @Test
    public void testHasServProv() {
        System.out.println("hasServProv");
        Time time = new Time(10,0);
        ServiceProvider servProv = new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos");
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        boolean expResult = true;
        boolean result = instance.hasServProv(servProv);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasClient method, of class ServiceOrder.
     */
    @Test
    public void testHasClient() {
        System.out.println("hasClient");
        Client cli = new Client("Joao", "123456789", "123456789", "Joao");
        Time time = new Time(10,0);
        ServiceProvider servProv = new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos");
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), cli);
        boolean expResult = true;
        boolean result = instance.hasClient(cli);
        assertEquals(expResult, result);
    }

    /**
     * Test of isExecuted method, of class ServiceOrder.
     */
    @Test
    public void testIsExecuted() {
        System.out.println("isExecuted");
        Client cli = new Client("Joao", "123456789", "123456789", "Joao");
        Time time = new Time(10,0);
        ServiceProvider servProv = new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos");
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), cli);
        boolean expResult = false;
        boolean result = instance.isExecuted();
        assertEquals(expResult, result);
    }

    /**
     * Test of isNotRated method, of class ServiceOrder.
     */
    @Test
    public void testIsNotRated() {
        System.out.println("isNotRated");
        Client cli = new Client("Joao", "123456789", "123456789", "Joao");
        Time time = new Time(10,0);
        ServiceProvider servProv = new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos");
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), cli);
        boolean expResult = true;
        boolean result = instance.isNotRated();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ServiceOrder.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Client cli = new Client("Joao", "123456789", "123456789", "Joao");
        Time time = new Time(10,0);
        ServiceProvider servProv = new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos");
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), cli);
        String result = instance.toString();
    }

    /**
     * Test of equals method, of class ServiceOrder.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new CategoryRecords();
        Client cli = new Client("Joao", "123456789", "123456789", "Joao");
        Time time = new Time(10,0);
        ServiceProvider servProv = new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos");
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), cli);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new ServiceOrder(2, new ServiceProvider("Joao", "Joao", 1, 1, "Joao"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "des", 1, new Category("code", "dec")), "desc", 30), new ServiceSchedule("acceped", LocalDate.of(2020, Month.MARCH, 2), new Time("18:00")), new PostalAddress("Lisboa", new PostalCode("4000-9"), "Porto"), new Client("cli", "987654321", "987654321", "email"));
        Client cli = new Client("Joao", "123456789", "123456789", "Joao");
        Time time = new Time(10,0);
        ServiceProvider servProv = new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos");
        ServiceOrder instance = new ServiceOrder(1, new ServiceProvider("Carlos", "Carlos", 1, 1, "Carlos"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), cli);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

}
