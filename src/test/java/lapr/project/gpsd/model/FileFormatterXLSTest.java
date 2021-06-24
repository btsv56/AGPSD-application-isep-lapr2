/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.AppGPSD;
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
public class FileFormatterXLSTest {

    public FileFormatterXLSTest() {
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
     * Test of export method, of class FileFormatterXLS.
     */
    @Test
    public void testExport() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("export");
        Client cli = new Client("Veiga", "123456789", "123456789", "as");
        PostalCode pCode = new PostalCode("4000-10");
        PostalAddress oAddress = new PostalAddress("rua", pCode, "d");
        cli.addPostalAddress(oAddress);
        Time hour = new Time(14, 30);
        ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
        GeographicalArea geoArea = new GeographicalArea("lousada", 3, "4000-10", 3, api);
        ServiceProvider servProv1 = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        servProv1.addPostalAddress(oAddress);
        ServiceProvider servProv2 = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        servProv2.addPostalAddress(oAddress);
        ServiceOrder so = (new ServiceOrder(12, servProv1, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("1111", "Plubming")), "rebentar um cano", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Rua Kali", new PostalCode("4420-10", 41.1252877, -8.5266659), "Porto"), cli));
        ServiceOrder so2 = (new ServiceOrder(12, servProv1, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("1111", "Plubming")), "rebentar um cano", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Rua Kali", new PostalCode("4420-10", 41.1252877, -8.5266659), "Porto"), cli));
        ServiceOrder so3 = (new ServiceOrder(12, servProv1, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("1111", "Plubming")), "rebentar um cano", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Rua Kali", new PostalCode("4420-10", 41.1252877, -8.5266659), "Porto"), cli));
        ServiceOrder so4 = (new ServiceOrder(12, servProv1, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("1111", "Plubming")), "rebentar um cano", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Rua Kali", new PostalCode("4420-10", 41.1252877, -8.5266659), "Porto"), cli));
        List<ServiceOrder> servOrder = new ArrayList<>();
        servOrder.add(so);
        servOrder.add(so2);
        servOrder.add(so3);
        servOrder.add(so4);
        FileFormatterXLS instance = new FileFormatterXLS("XLS");
        boolean expResult = true;
        instance.export(servOrder);
        boolean result = instance.export(servOrder);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormat method, of class FileFormatterXLS.
     */
    @Test
    public void testGetFormat() {
        System.out.println("getFormat");
        FileFormatterXLS instance = new FileFormatterXLS("XLS");
        String expResult = "XLS";
        String result = instance.getFormat();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class FileFormatterXLS.
     */
    @Test
    public void testEquals() throws IOException {
        System.out.println("equals");
        Object obj = new Object();
        FileFormatterXLS instance = new FileFormatterXLS("CSV");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class FileFormatterXLS.
     */
    @Test
    public void testEquals2() throws IOException {
        System.out.println("equals");
        FileFormatterXLS obj = new FileFormatterXLS("XLS");
        FileFormatterXLS instance = new FileFormatterXLS("CSV");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class FileFormatterXLS.
     */
    @Test
    public void testEquals3() throws IOException {
        System.out.println("equals");
        FileFormatterXLS obj = new FileFormatterXLS("XLS");
        FileFormatterXLS instance = new FileFormatterXLS("XLS");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class FileFormatterXLS.
     */
    @Test
    public void testEquals4() throws IOException {
        System.out.println("equals");
        FileFormatterXLS obj = new FileFormatterXLS("XLS");
        FileFormatterXLS instance = new FileFormatterXLS("CSV");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals5() throws IOException {
        System.out.println("equals");
        FileFormatterXLS obj = new FileFormatterXLS("XLS");
        FileFormatterXLS instance = (FileFormatterXLS) obj;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals6() throws IOException {
        System.out.println("equals");
        FileFormatterXLS obj = new FileFormatterXLS("XLS");
        FileFormatterXLS instance = new FileFormatterXLS("CSV");
        ArrayList<ServiceOrder> serviceOrder = new ArrayList<>();
        Client cli = new Client("Veiga", "123456789", "123456789", "as");
        Time hour = new Time(14, 30);
        ServiceProvider servProv1 = new ServiceProvider("Veiga", "Veiga", 1, 1, "email");
        serviceOrder.add(new ServiceOrder(12, servProv1, new ServiceProvidingRequestDescription(new LimitedService("id", "desc", "desc", 1, new Category("4000-10", "Paços")), "desc", 1), new ServiceSchedule("accepted", LocalDate.of(2020, Month.MARCH, 2), hour), new PostalAddress("Porto", new PostalCode("4000-10", 43.3213, 23.32), "Porto"), cli));
        instance.setServiceExecutionOrder(serviceOrder);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

}
