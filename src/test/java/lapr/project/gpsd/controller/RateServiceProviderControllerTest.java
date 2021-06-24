/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.LimitedService;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequestDescription;
import lapr.project.gpsd.model.ServiceSchedule;
import lapr.project.gpsd.model.Time;
import lapr.project.records.ClientRecords;
import lapr.project.records.ServiceOrderRecords;
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
public class RateServiceProviderControllerTest {

    public RateServiceProviderControllerTest() {
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
     * Test of newRateService method, of class RateServiceProviderController.
     */
    @Test
    public void testNewRateService() {
        System.out.println("newRateService");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        ClientRecords cr = company.getClientRecords();
        Client cli = new Client("Veiga", "123456789", "123456789", "as");
        String pwd = "123";
        cr.registerClient(cli, pwd);
        app.doLogin("as", pwd);
        RateServiceProviderController instance = new RateServiceProviderController();
        instance.newRateService();
    }

    /**
     * Test of getServiceOrdersExecutedByClient method, of class
     * RateServiceProviderController.
     */
    @Test
    public void testGetServiceOrdersExecutedByClient() {
        System.out.println("getServiceOrdersExecutedByClient");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        ClientRecords cr = company.getClientRecords();
        Time time = new Time(10,0);
        Client cli = new Client("Veiga", "123456789", "123456789", "as");
        String pwd = "123";
        cr.registerClient(cli, pwd);
        app.doLogin("as", pwd);
        ServiceOrderRecords sor = company.getServiceOrderRecords();
        ServiceOrder so = new ServiceOrder(12, new ServiceProvider("Veiga", "Veiga", 1, 1, "email"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), cli);
        sor.registerServiceOrder(so);
        so.setExecutionState("Executed");
        RateServiceProviderController instance = new RateServiceProviderController();
        List<ServiceOrder> expResult = new ArrayList<>();
        expResult.add(so);
        instance.newRateService();
        List<ServiceOrder> result = instance.getServiceOrdersExecutedByClient();
    }

    /**
     * Test of getServiceProviderByServiceOrder method, of class
     * RateServiceProviderController.
     */
    @Test
    public void testGetServiceProviderByServiceOrder() {
        System.out.println("getServiceProviderByServiceOrder");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        ClientRecords cr = company.getClientRecords();
        Time time = new Time(10,0);
        Client cli = new Client("Veiga", "123456789", "123456789", "as");
        String pwd = "123";
        cr.registerClient(cli, pwd);
        app.doLogin("as", pwd);
        ServiceOrderRecords sor = company.getServiceOrderRecords();
        ServiceOrder so = new ServiceOrder(12, new ServiceProvider("Veiga", "Veiga", 1, 1, "email"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), cli);
        sor.registerServiceOrder(so);
        RateServiceProviderController instance = new RateServiceProviderController();
        ServiceProvider expResult = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        ServiceProvider result = instance.getServiceProviderByServiceOrder(so);
        assertEquals(expResult, result);
    }

    /**
     * Test of rateServiceProvider method, of class
     * RateServiceProviderController.
     */
    @Test
    public void testRateServiceProvider() {
        System.out.println("rateServiceProvider");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        ClientRecords cr = company.getClientRecords();
        Time time = new Time(10,0);
        Client cli = new Client("Veiga", "123456789", "123456789", "as");
        String pwd = "123";
        cr.registerClient(cli, pwd);
        app.doLogin("as", pwd);
        ServiceOrderRecords sor = company.getServiceOrderRecords();
        ServiceOrder so = new ServiceOrder(12, new ServiceProvider("Veiga", "Veiga", 1, 1, "email"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), cli);
        sor.registerServiceOrder(so);
        RateServiceProviderController instance = new RateServiceProviderController();
        ServiceProvider expResult = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        ServiceProvider result = instance.getServiceProviderByServiceOrder(so);

    }

    /**
     * Test of registerRate method, of class RateServiceProviderController.
     */
    @Test
    public void testRegisterRate() {
        System.out.println("registerRate");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        ClientRecords cr = company.getClientRecords();
        Time time = new Time(10,0);
        Client cli = new Client("Veiga", "123456789", "123456789", "as");
        String pwd = "123";
        cr.registerClient(cli, pwd);
        app.doLogin("as", pwd);
        ServiceOrderRecords sor = company.getServiceOrderRecords();
        ServiceOrder so = new ServiceOrder(12, new ServiceProvider("Veiga", "Veiga", 1, 1, "email"), new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("code", "desc")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), time), new PostalAddress("Porto", new PostalCode("4000-9"), "Porto"), cli);
        sor.registerServiceOrder(so);
        RateServiceProviderController instance = new RateServiceProviderController();
        ServiceProvider expResult = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        ServiceProvider result = instance.getServiceProviderByServiceOrder(so);
        int rate = 5;
        instance.rateServiceProvider(rate);
        instance.registerRate();
    }

    /**
     * Test of isInteger method, of class RateServiceProviderController.
     */
    @Test
    public void testIsInteger() {
        System.out.println("isInteger");
        String str = "1";
        RateServiceProviderController instance = new RateServiceProviderController();
        boolean expResult = true;
        boolean result = instance.isInteger(str);
        assertEquals(expResult, result);
    }

}
