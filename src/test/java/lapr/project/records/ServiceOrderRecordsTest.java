/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.ExpandableService;
import lapr.project.gpsd.model.LimitedService;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequestDescription;
import lapr.project.gpsd.model.ServiceSchedule;
import lapr.project.gpsd.model.Time;
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
public class ServiceOrderRecordsTest {

    public ServiceOrderRecordsTest() {
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
     * Test of getOrdersList method, of class ServiceOrderRecords.
     */
    @Test
    public void testGetOrdersList() {
        System.out.println("getOrdersList");
        ServiceOrderRecords instance = new ServiceOrderRecords();
        List<ServiceOrder> expResult = new ArrayList<>();
        List<ServiceOrder> result = instance.getOrdersList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServOrderListByDate method, of class ServiceOrderRecords.
     */
    @Test
    public void testGetServOrderListByDate() {
        System.out.println("getServOrderListByDate");
        ServiceProvider servProv = new ServiceProvider("Pedro", "Pedro", 1, 1, "Pedro");
        LocalDate dateB = LocalDate.of(2020, Month.FEBRUARY, 2);
        LocalDate dateE = LocalDate.of(2022, Month.MARCH, 3);
        ServiceOrderRecords instance = new ServiceOrderRecords();
        ServiceOrder so= new ServiceOrder(1, servProv, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 30), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), new Time("12:00")), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), new Client("Joao", "123456789", "123456789", "Joao"));
        instance.registerServiceOrder(so);
        List<ServiceOrder> expResult = new ArrayList<>();
        expResult.add(so);
        List<ServiceOrder> result = instance.getServOrderListByDate(servProv, dateB, dateE);
        assertEquals(expResult, result);
    }

    /**
     * Test of generateOrderServiceExecution method, of class ServiceOrderRecords.
     */
    @Test
    public void testGenerateOrderServiceExecution() {
        System.out.println("generateOrderServiceExecution");
        ServiceProvider prov = new ServiceProvider("Pedro", "Pedro", 987654321, 987654321, "Pedro");
        ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 30, new Category("code", "desc")), "desc", 30);
        ServiceSchedule ss = new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), new Time("12:00"));
        PostalAddress end = new PostalAddress("Porto", new PostalCode("4000-9"), "Porto");
        int j=0;
        Client cli = new Client("Joao", "123456789", "123456789", "Joao");
        ServiceOrderRecords instance = new ServiceOrderRecords();
        ServiceOrder expResult = new ServiceOrder(0, prov, descServ, ss, end, cli);
        ServiceOrder result = instance.generateOrderServiceExecution(j, prov, descServ, ss, end, cli);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnfinishedServiceOrdersBySP method, of class ServiceOrderRecords.
     */
    @Test
    public void testGetUnfinishedServiceOrdersBySP() {
        System.out.println("getUnfinishedServiceOrdersBySP");
        ServiceProvider prov = new ServiceProvider("x", "x", 123456789, 123456789, "esoft");
        Category cat = new Category("cat1", "limpeza");
        Service serv = new ExpandableService("exp1", "sdf", "sdf", 12, cat);
        ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "fjfj", 30);
        ServiceSchedule ss = new ServiceSchedule("Not accepted", LocalDate.MAX, new Time("12:30"));
        PostalAddress end = new PostalAddress("s", new PostalCode("4000-7"),"s");
        Client cli = new Client("x", "123456789", "123456789", "email");
        ServiceOrder so = new ServiceOrder(0, prov, descServ, ss, end, cli);
        ServiceOrderRecords instance = new ServiceOrderRecords();
        instance.addServiceOrder(so);
        List<ServiceOrder> expResult = new ArrayList<>();
        expResult.add(so);
        List<ServiceOrder> result = instance.getUnfinishedServiceOrdersBySP(prov);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getUnfinishedServiceOrdersBySP method, of class ServiceOrderRecords.
     */
    @Test
    public void testGetUnfinishedServiceOrdersBySP2() {
        System.out.println("getUnfinishedServiceOrdersBySP2");
        ServiceProvider prov = new ServiceProvider("x", "x", 123456789, 123456789, "esoft");
        Category cat = new Category("cat1", "limpeza");
        Service serv = new ExpandableService("exp1", "sdf", "sdf", 12, cat);
        ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "fjfj", 30);
        ServiceSchedule ss = new ServiceSchedule("Not accepted", LocalDate.MAX, new Time("12:30"));
        PostalAddress end = new PostalAddress("s", new PostalCode("4000-7"),"s");
        Client cli = new Client("x", "123456789", "123456789", "email");
        ServiceOrder so = new ServiceOrder(0, prov, descServ, ss, end, cli);
        so.setExecutionState("Executed");
        ServiceOrderRecords instance = new ServiceOrderRecords();
        instance.addServiceOrder(so);
        List<ServiceOrder> expResult = new ArrayList<>();
        List<ServiceOrder> result = instance.getUnfinishedServiceOrdersBySP(prov);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerServiceOrder method, of class ServiceOrderRecords.
     */
    @Test
    public void testRegisterServiceOrder() {
        System.out.println("registerServiceOrder");
        ServiceProvider prov = new ServiceProvider("x", "x", 123456789, 123456789, "esoft");
        Category cat = new Category("cat1", "limpeza");
        Service serv = new ExpandableService("exp1", "sdf", "sdf", 12, cat);
        ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "fjfj", 30);
        ServiceSchedule ss = new ServiceSchedule("Not accepted", LocalDate.MAX, new Time("12:30"));
        PostalAddress end = new PostalAddress("s", new PostalCode("4000-7"),"s");
        Client cli = new Client("x", "123456789", "123456789", "email");
        ServiceOrder so = new ServiceOrder(0, prov, descServ, ss, end, cli);
        ServiceOrderRecords instance = new ServiceOrderRecords();
        int expResult = 1;
        int result = instance.registerServiceOrder(so);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerServiceOrder method, of class ServiceOrderRecords.
     */
    @Test
    public void testRegisterServiceOrder2() {
        System.out.println("registerServiceOrder2");
        ServiceProvider prov = new ServiceProvider("x", "x", 123456789, 123456789, "esoft");
        Category cat = new Category("cat1", "limpeza");
        Service serv = new ExpandableService("exp1", "sdf", "sdf", 12, cat);
        ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "fjfj", 30);
        ServiceSchedule ss = new ServiceSchedule("Not accepted", LocalDate.MAX, new Time("12:30"));
        PostalAddress end = new PostalAddress("s", new PostalCode("4000-7"),"s");
        Client cli = new Client("x", "123456789", "123456789", "email");
        ServiceOrder so = new ServiceOrder(0, prov, descServ, ss, end, cli);
        ServiceOrderRecords instance = new ServiceOrderRecords();
        instance.addServiceOrder(so);
        int expResult = -1;
        int result = instance.registerServiceOrder(so);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getServiceOrderByServProv method, of class ServiceOrderRecords.
     */
    @Test
    public void testGetServiceOrderByServProv() {
        System.out.println("getServiceOrderByServProv");
        ServiceProvider prov = new ServiceProvider("x", "x", 123456789, 123456789, "esoft");
        Category cat = new Category("cat1", "limpeza");
        Service serv = new ExpandableService("exp1", "sdf", "sdf", 12, cat);
        ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "fjfj", 30);
        ServiceSchedule ss = new ServiceSchedule("Not accepted", LocalDate.MAX, new Time("12:30"));
        PostalAddress end = new PostalAddress("s", new PostalCode("4000-7"),"s");
        Client cli = new Client("x", "123456789", "123456789", "email");
        ServiceOrder so = new ServiceOrder(0, prov, descServ, ss, end, cli);
        ServiceOrderRecords instance = new ServiceOrderRecords();
        instance.addServiceOrder(so);
        List<ServiceOrder> expResult = new ArrayList<>();
        expResult.add(so);
        List<ServiceOrder> result = instance.getServiceOrderByServProv(prov);
        assertEquals(expResult, result);

    }

    /**
     * Test of validateServiceOrder method, of class ServiceOrderRecords.
     */
    @Test
    public void testValidateServiceOrder() {
        System.out.println("validateServiceOrder");
        ServiceProvider prov = new ServiceProvider("x", "x", 123456789, 123456789, "esoft");
        Category cat = new Category("cat1", "limpeza");
        Service serv = new ExpandableService("exp1", "sdf", "sdf", 12, cat);
        ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "fjfj", 30);
        ServiceSchedule ss = new ServiceSchedule("Not accepted", LocalDate.MAX, new Time("12:30"));
        PostalAddress end = new PostalAddress("s", new PostalCode("4000-7"),"s");
        Client cli = new Client("x", "123456789", "123456789", "email");
        ServiceOrder so = new ServiceOrder(0, prov, descServ, ss, end, cli);
        ServiceOrderRecords instance = new ServiceOrderRecords();
        instance.addServiceOrder(so);
        boolean expResult = false;
        boolean result = instance.validateServiceOrder(so);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of validateServiceOrder method, of class ServiceOrderRecords.
     */
    @Test
    public void testValidateServiceOrder2() {
        System.out.println("validateServiceOrder2");
        ServiceProvider prov = new ServiceProvider("x", "x", 123456789, 123456789, "esoft");
        Category cat = new Category("cat1", "limpeza");
        Service serv = new ExpandableService("exp1", "sdf", "sdf", 12, cat);
        ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "fjfj", 30);
        ServiceSchedule ss = new ServiceSchedule("Not accepted", LocalDate.MAX, new Time("12:30"));
        PostalAddress end = new PostalAddress("s", new PostalCode("4000-7"),"s");
        Client cli = new Client("x", "123456789", "123456789", "email");
        ServiceOrder so = new ServiceOrder(0, prov, descServ, ss, end, cli);
        ServiceOrderRecords instance = new ServiceOrderRecords();
        boolean expResult = true;
        boolean result = instance.validateServiceOrder(so);
        assertEquals(expResult, result);
    }

    /**
     * Test of addServiceOrder method, of class ServiceOrderRecords.
     */
    @Test
    public void testAddServiceOrder() {
        System.out.println("addServiceOrder");
        ServiceProvider prov = new ServiceProvider("x", "x", 123456789, 123456789, "esoft");
        Category cat = new Category("cat1", "limpeza");
        Service serv = new ExpandableService("exp1", "sdf", "sdf", 12, cat);
        ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "fjfj", 30);
        ServiceSchedule ss = new ServiceSchedule("Not accepted", LocalDate.MAX, new Time("12:30"));
        PostalAddress end = new PostalAddress("s", new PostalCode("4000-7"),"s");
        Client cli = new Client("x", "123456789", "123456789", "email");
        ServiceOrder so = new ServiceOrder(0, prov, descServ, ss, end, cli);
        ServiceOrderRecords instance = new ServiceOrderRecords();
        boolean expResult = true;
        boolean result = instance.addServiceOrder(so);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceOrdersByClient method, of class ServiceOrderRecords.
     */
    @Test
    public void testGetServiceOrdersByClient() {
        System.out.println("getServiceOrdersByClient");
        ServiceProvider prov = new ServiceProvider("p", "x", 123456789, 123456789, "esoft");
        Category cat = new Category("cat1", "limpeza");
        Service serv = new ExpandableService("exp1", "sdf", "sdf", 12, cat);
        ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "fjfj", 30);
        ServiceSchedule ss = new ServiceSchedule("Not accepted", LocalDate.MAX, new Time("12:30"));
        PostalAddress end = new PostalAddress("s", new PostalCode("4000-7"),"s");
        Client cli = new Client("x", "123456789", "123456789", "email");
        ServiceOrder so = new ServiceOrder(0, prov, descServ, ss, end, cli);
        so.setExecutionState("Executed");
        ServiceOrderRecords instance = new ServiceOrderRecords();
        instance.addServiceOrder(so);
        List<ServiceOrder> expResult = new ArrayList<>();
        expResult.add(so);
        List<ServiceOrder> result = instance.getServiceOrdersByClient(cli);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceOrderByNum method, of class ServiceOrderRecords.
     */
    @Test
    public void testGetServiceOrderByNum() {
        System.out.println("getServiceOrderByNum");
        int num = 0;
        ServiceProvider prov = new ServiceProvider("x", "x", 123456789, 123456789, "esoft");
        Category cat = new Category("cat1", "limpeza");
        Service serv = new ExpandableService("exp1", "sdf", "sdf", 12, cat);
        ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "fjfj", 30);
        ServiceSchedule ss = new ServiceSchedule("Not accepted", LocalDate.MAX, new Time("12:30"));
        PostalAddress end = new PostalAddress("s", new PostalCode("4000-7"),"s");
        Client cli = new Client("x", "123456789", "123456789", "email");
        ServiceOrder so = new ServiceOrder(0, prov, descServ, ss, end, cli);
        ServiceOrderRecords instance = new ServiceOrderRecords();
        instance.addServiceOrder(so);
        ServiceOrder expResult = so;
        ServiceOrder result = instance.getServiceOrderByNum(num);
        assertEquals(expResult, result);
    }

}
