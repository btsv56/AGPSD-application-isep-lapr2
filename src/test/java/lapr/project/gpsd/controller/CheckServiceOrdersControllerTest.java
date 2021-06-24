/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ExternalService;
import lapr.project.gpsd.model.FormatType;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.LimitedService;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequestDescription;
import lapr.project.gpsd.model.ServiceSchedule;
import lapr.project.gpsd.model.Time;
import lapr.project.records.CategoryRecords;
import lapr.project.records.ClientRecords;
import lapr.project.records.FormatTypeRecords;
import lapr.project.records.ServiceOrderRecords;
import lapr.project.records.ServiceProviderRecords;
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
public class CheckServiceOrdersControllerTest {

    public CheckServiceOrdersControllerTest() {
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
     * Test of getServOrdersByProvider method, of class
     * CheckServiceOrdersController.
     */
    @Test
    public void testGetServOrdersByProvider() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("getServOrdersByProvider");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        LocalDate dateB = LocalDate.of(2020, Month.DECEMBER, 10);
        LocalDate dateE = LocalDate.of(2020, Month.DECEMBER, 20);
        ServiceProviderRecords spr = company.getServiceProviderRecords();
        ServiceProvider servProv = new ServiceProvider("Veiga", "Veiga", 1, 1, "Veiga");
        spr.registerServiceProvider(servProv);
        app.doLogin("Veiga", app.getCompany().getClientRecords().getAutorizacaoFacade().getUserRecords().searchUser("Veiga").getPassword());
        Client cli = new Client("Veiga", "123456789", "123456789", "as");
        PostalCode pCode = new PostalCode("4000-10");
        PostalAddress oAddress = new PostalAddress("rua", pCode, "d");
        cli.addPostalAddress(oAddress);
        Time hour = new Time(14, 30);
        ServiceProvider servProv1 = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        servProv1.addPostalAddress(oAddress);
        ServiceProvider servProv2 = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        servProv2.addPostalAddress(oAddress);
        ServiceOrder so = (new ServiceOrder(12, servProv1, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("1111", "Plubming")), "rebentar um cano", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Rua Kali", new PostalCode("4420-10", 41.1252877, -8.5266659), "Porto"), cli));
        ServiceOrder so2 = (new ServiceOrder(12, servProv1, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("1111", "Plubming")), "rebentar um cano", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Rua Kali", new PostalCode("4420-10", 41.1252877, -8.5266659), "Porto"), cli));
        ServiceOrder so3 = (new ServiceOrder(12, servProv1, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("1111", "Plubming")), "rebentar um cano", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Rua Kali", new PostalCode("4420-10", 41.1252877, -8.5266659), "Porto"), cli));
        ServiceOrder so4 = (new ServiceOrder(12, servProv1, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("1111", "Plubming")), "rebentar um cano", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Rua Kali", new PostalCode("4420-10", 41.1252877, -8.5266659), "Porto"), cli));
        List<ServiceOrder> servOrder = new ArrayList<>();
        CheckServiceOrdersController instance = new CheckServiceOrdersController();
        instance.initiateNewCheck();
        List<ServiceOrder> expResult = servOrder;
        List<ServiceOrder> result = instance.getServOrdersByProvider(dateB, dateE);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatTypes method, of class CheckServiceOrdersController.
     */
    @Test
    public void testGetFormatTypes() {
        System.out.println("getFormatTypes");
        CheckServiceOrdersController instance = new CheckServiceOrdersController();
        instance.initiateNewCheck();
        FormatTypeRecords typeRec = new FormatTypeRecords();
        AppGPSD app = AppGPSD.getInstance();
        Properties props = app.getProperties();
        typeRec.createsFormatTypesSupported(props);
        FormatType format1 = new FormatType("lapr.project.gpsd.model.FileFormatterCSV", "CSV");
        FormatType format2 = new FormatType("lapr.project.gpsd.model.FileFormatterXML", "XML");
        FormatType format3 = new FormatType("lapr.project.gpsd.model.FileFormatterXLS", "XLS");
        List<FormatType> expResult = new ArrayList<>();
        expResult.add(format2);
        expResult.add(format1);
        expResult.add(format3);
        List<FormatType> result = instance.getFormatTypes();
        assertEquals(expResult, result);
    }

    /**
     * Test of export method, of class CheckServiceOrdersController.
     */
    @Test
    public void testExportXML() throws Exception {
        System.out.println("export");
        CheckServiceOrdersController instance = new CheckServiceOrdersController();
        Client cli = new Client("Veiga", "123456789", "123456789", "as");
        PostalCode pCode = new PostalCode("4000-10");
        PostalAddress oAddress = new PostalAddress("rua", pCode, "d");
        cli.addPostalAddress(oAddress);
        Time hour = new Time(14, 30);
        ServiceProvider servProv1 = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        servProv1.addPostalAddress(oAddress);
        ServiceProvider servProv2 = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        servProv2.addPostalAddress(oAddress);
        ServiceOrder so = new ServiceOrder(12, servProv1, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli);
        ServiceOrder so2 = new ServiceOrder(12, servProv2, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli);
        ServiceOrder so3 = new ServiceOrder(12, servProv2, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli);
        ServiceOrder so4 = new ServiceOrder(12, servProv2, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli);
        List<ServiceOrder> servOrder = new ArrayList<>();
        servOrder.add(so);
        servOrder.add(so2);
        servOrder.add(so3);
        servOrder.add(so4);
        String format = "lapr.project.gpsd.model.FileFormatterXML";

        instance.initiateNewCheck();
        instance.getFormatTypes();
        boolean expResult = true;
        boolean result = instance.export(servOrder, format);
        assertEquals(expResult, result);
    }

    /**
     * Test of export method, of class CheckServiceOrdersController.
     */
    @Test
    public void testExportXLS() throws Exception {
        System.out.println("export");
        CheckServiceOrdersController instance = new CheckServiceOrdersController();
        Client cli = new Client("Veiga", "123456789", "123456789", "as");
        PostalCode pCode = new PostalCode("4000-10");
        PostalAddress oAddress = new PostalAddress("rua", pCode, "d");
        cli.addPostalAddress(oAddress);
        Time hour = new Time(14, 30);
        ServiceProvider servProv1 = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        servProv1.addPostalAddress(oAddress);
        ServiceProvider servProv2 = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        servProv2.addPostalAddress(oAddress);
        ServiceOrder so = new ServiceOrder(12, servProv1, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli);
        ServiceOrder so2 = new ServiceOrder(12, servProv2, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli);
        ServiceOrder so3 = new ServiceOrder(12, servProv2, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli);
        ServiceOrder so4 = new ServiceOrder(12, servProv2, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli);
        List<ServiceOrder> servOrder = new ArrayList<>();
        servOrder.add(so);
        servOrder.add(so2);
        servOrder.add(so3);
        servOrder.add(so4);
        String format = "lapr.project.gpsd.model.FileFormatterXLS";

        instance.initiateNewCheck();
        instance.getFormatTypes();
        boolean expResult = true;
        boolean result = instance.export(servOrder, format);
        assertEquals(expResult, result);
    }

    /**
     * Test of export method, of class CheckServiceOrdersController.
     */
    @Test
    public void testExportCSV() throws Exception {
        System.out.println("export");
        CheckServiceOrdersController instance = new CheckServiceOrdersController();
        Client cli = new Client("Veiga", "123456789", "123456789", "as");
        PostalCode pCode = new PostalCode("4000-10");
        PostalAddress oAddress = new PostalAddress("rua", pCode, "d");
        cli.addPostalAddress(oAddress);
        Time hour = new Time(14, 30);
        ServiceProvider servProv1 = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        servProv1.addPostalAddress(oAddress);
        ServiceProvider servProv2 = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        servProv2.addPostalAddress(oAddress);
        ServiceOrder so = new ServiceOrder(12, servProv1, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli);
        ServiceOrder so2 = new ServiceOrder(12, servProv2, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli);
        ServiceOrder so3 = new ServiceOrder(12, servProv2, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli);
        ServiceOrder so4 = new ServiceOrder(12, servProv2, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli);
        List<ServiceOrder> servOrder = new ArrayList<>();
        servOrder.add(so);
        servOrder.add(so2);
        servOrder.add(so3);
        servOrder.add(so4);
        String format = "lapr.project.gpsd.model.FileFormatterCSV";

        instance.initiateNewCheck();
        instance.getFormatTypes();
        boolean expResult = true;
        boolean result = instance.export(servOrder, format);
        assertEquals(expResult, result);
    }

}
