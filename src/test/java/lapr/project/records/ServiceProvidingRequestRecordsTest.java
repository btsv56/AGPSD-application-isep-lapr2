/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.controller.SpecifyGeographicalAreaController;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.ServiceProvidingRequest;
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
public class ServiceProvidingRequestRecordsTest {

    public ServiceProvidingRequestRecordsTest() {
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
     * Test of newRequest method, of class ServiceProvidingRequestRecords.
     */
    @Test
    public void testNewRequest() {
        System.out.println("newRequest");
        Client cli = new Client("Veiga", "123456789", "123456789", "email@email.pt");
        PostalAddress address = new PostalAddress("Porto", new PostalCode("3412-123", 1, 1), "Porto");
        ServiceProvidingRequestRecords instance = new ServiceProvidingRequestRecords();
        ServiceProvidingRequest expResult = new ServiceProvidingRequest(cli, address);
        ServiceProvidingRequest result = instance.newRequest(cli, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateRequest method, of class ServiceProvidingRequestRecords.
     */
    @Test
    public void testValidateRequest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
        System.out.println("validateRequest");
        AppGPSD app = AppGPSD.getInstance();
        app.doLogin("adm1@esoft.pt", "123456");
        GeographicalAreaRecords sgac = new GeographicalAreaRecords();
        GeographicalArea ga = sgac.newGeographicalArea("des", 1, "4000-9", 1);
        sgac.registersGeographicalArea(ga);
        Client cli = new Client("Veiga", "123456789", "123456789", "email@email.pt");
        PostalAddress address = new PostalAddress("Porto", new PostalCode("3412-123", 1, 1), "Porto");
        ServiceProvidingRequest request = new ServiceProvidingRequest(cli, address);
        ServiceProvidingRequestRecords instance = new ServiceProvidingRequestRecords();
        instance.getRequestsList().add(request);
        boolean expResult = true;
        try {
            boolean result = instance.validateRequest(request);
            assertEquals(expResult, result);
        } catch (NullPointerException npe) {

        }
    }

    /**
     * Test of registerRequest method, of class ServiceProvidingRequestRecords.
     */
    @Test
    public void testRegisterRequest() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("registerRequest");
        AppGPSD app = AppGPSD.getInstance();
        app.doLogin("adm1@esoft.pt", "123456");
        GeographicalAreaRecords sgac = new GeographicalAreaRecords();
        GeographicalArea ga = sgac.newGeographicalArea("des", 1, "4000-9", 1);
        sgac.registersGeographicalArea(ga);
        Client cli = new Client("Veiga", "123456789", "123456789", "email@email.pt");
        PostalAddress address = new PostalAddress("Porto", new PostalCode("3412-123", 1, 1), "Porto");
        ServiceProvidingRequest request = new ServiceProvidingRequest(cli, address);
        ServiceProvidingRequestRecords instance = new ServiceProvidingRequestRecords();
        int expResult = 0;
        try {
            int result = instance.registerRequest(request);
            assertEquals(expResult, result);
        } catch (NullPointerException npe) {

        }
    }

    /**
     * Test of getRequestsList method, of class ServiceProvidingRequestRecords.
     */
    @Test
    public void getRequestsList() throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
        System.out.println("getRequestsList");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        ServiceProvidingRequestRecords instance = company.getServiceProvidingRequestRecords();
        GeographicalAreaRecords gar = company.getGeographicalAreaRecords();
        GeographicalArea ga = gar.newGeographicalArea("Porto", 1, "4000-9", 1);
        gar.registersGeographicalArea(ga);
        Client cli = new Client("Veiga", "123456789", "123456789", "email@email.pt");
        PostalAddress address = new PostalAddress("Porto", new PostalCode("3412-123", 1, 1), "Porto");
        cli.addAddress(address);
        ServiceProvidingRequest request = new ServiceProvidingRequest(cli, address);
        instance.getRequestsList().add(request);
        List<ServiceProvidingRequest> expResult = new ArrayList<>();
        List<ServiceProvidingRequest> result = instance.getRequestsList();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ServiceProvidingRequestRecords.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new ServiceProvidingRequestRecords();
        ServiceProvidingRequestRecords instance = new ServiceProvidingRequestRecords();
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new ServiceProvidingRequestRecords();
        ServiceProvidingRequestRecords instance = (ServiceProvidingRequestRecords) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = new CategoryRecords();
        ServiceProvidingRequestRecords instance = new ServiceProvidingRequestRecords();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

}
