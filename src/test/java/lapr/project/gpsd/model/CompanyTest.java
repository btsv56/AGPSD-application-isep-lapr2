/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.records.ApplicationRecords;
import lapr.project.records.AssociationProviderRequestRecords;
import lapr.project.records.CategoryRecords;
import lapr.project.records.ClientRecords;
import lapr.project.records.FormatTypeRecords;
import lapr.project.records.ServiceOrderRecords;
import lapr.project.records.GeographicalAreaRecords;
import lapr.project.records.IssueRecords;
import lapr.project.records.PostalCodeRecords;
import lapr.project.records.ServiceProviderRecords;
import lapr.project.records.ServiceProvidingRequestRecords;
import lapr.project.records.ServiceRecords;
import lapr.project.records.ServiceScheduleRecords;
import lapr.project.records.ServiceTypesRecords;
import lapr.project.timer.AssociateSPtoRequestTimer;
import org.apache.commons.lang3.builder.EqualsBuilder;
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
public class CompanyTest {

    private ExternalService extService;

    public CompanyTest() {
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
     * Test of getClientRecords method, of class Company.
     */
    @Test
    public void testGetClientRecords() throws FileNotFoundException {
        System.out.println("getClientRecords");
        Company instance = new Company("LAPR Limitada", "123123123");
        ClientRecords expResult = new ClientRecords();
        ClientRecords result = instance.getClientRecords();
        assertTrue(result instanceof ClientRecords);
    }

    /**
     * Test of getGeographicalAreaRecords method, of class Company.
     */
    @Test
    public void testGetGeographicalAreaRecords() throws FileNotFoundException {
        System.out.println("getGeographicalAreaRecords");
        Company instance;
        instance = new Company("LAPR Limitada", "123123123");
        GeographicalAreaRecords expResult = new GeographicalAreaRecords();
        GeographicalAreaRecords result = instance.getGeographicalAreaRecords();
        assertTrue(EqualsBuilder.reflectionEquals(expResult, result, true));
    }

    /**
     * Test of getCategoryRecords method, of class Company.
     */
    @Test
    public void testGetCategoryRecords() throws FileNotFoundException {
        System.out.println("getCategoryRecords");
        Company instance = new Company("LAPR Limitada", "123123123");
        CategoryRecords expResult = new CategoryRecords();
        CategoryRecords result = instance.getCategoryRecords();
        assertTrue(EqualsBuilder.reflectionEquals(expResult, result, true));
    }

    /**
     * Test of getServiceRecords method, of class Company.
     */
    @Test
    public void testGetServiceRecords() throws FileNotFoundException {
        System.out.println("getServiceRecords");
        Company instance = new Company("LAPR Limitada", "123123123");
        ServiceRecords expResult = new ServiceRecords();
        ServiceRecords result = instance.getServiceRecords();
        assertTrue(EqualsBuilder.reflectionEquals(expResult, result, true));
    }

    /**
     * Test of getServiceTypesRecords method, of class Company.
     */
    @Test
    public void testGetServiceTypesRecords() throws FileNotFoundException {
        System.out.println("getServiceTypesRecords");
        Company instance = new Company("LAPR Limitada", "123123123");
        ServiceTypesRecords expResult = new ServiceTypesRecords();
        ServiceTypesRecords result = instance.getServiceTypesRecords();
        assertTrue(EqualsBuilder.reflectionEquals(expResult, result, true));
    }

    /**
     * Test of getServiceProviderRecords method, of class Company.
     */
    @Test
    public void testGetServiceProviderRecords() throws FileNotFoundException {
        System.out.println("getServiceProviderRecords");
        Company instance = new Company("LAPR Limitada", "123123123");
        ServiceProviderRecords expResult = new ServiceProviderRecords();
        ServiceProviderRecords result = instance.getServiceProviderRecords();
        assertTrue(EqualsBuilder.reflectionEquals(expResult, result, true));
    }

    /**
     * Test of getApplicationRecords method, of class Company.
     */
    @Test
    public void testGetApplicationRecords() throws FileNotFoundException {
        System.out.println("getApplicationRecords");
        Company instance = new Company("LAPR Limitada", "123123123");
        ApplicationRecords expResult = new ApplicationRecords();
        ApplicationRecords result = instance.getApplicationRecords();
        assertTrue(result instanceof ApplicationRecords);

    }

    /**
     * Test of getPostalCodeRecords method, of class Company.
     */
    @Test
    public void testGetPostalCodeRecords() throws FileNotFoundException {
        System.out.println("getPostalCodeRecords");
        Company instance = new Company("Lapr Limitada", "123123123");
        PostalCodeRecords expResult = new PostalCodeRecords();
        PostalCodeRecords result = instance.getPostalCodeRecords();
        assertTrue(result instanceof PostalCodeRecords);

    }

    /**
     * Test of getExecutionOrderRecords method, of class Company.
     */
    @Test
    public void testGetServiceOrderRecords() throws FileNotFoundException {
        System.out.println("getExecutionOrderRecords");
        Company instance = new Company("Lapr Limitada", "123123123");
        ServiceOrderRecords expResult = new ServiceOrderRecords();
        ServiceOrderRecords result = instance.getServiceOrderRecords();
        assertTrue(EqualsBuilder.reflectionEquals(expResult, result, true));
    }

    /**
     * Test of getExternalService method, of class Company.
     */
    @Test
    public void testGetExternalService() throws Exception {
        System.out.println("getExternalService");
        Company instance = new Company("Lapr Limitada", "123123123");
        Class<?> oClass = Class.forName("lapr.project.gpsd.adapters.ExternalService1Adapter");
        this.extService = (ExternalService) oClass.newInstance();
        boolean expResult = true;
        assertTrue(instance.getExternalService() instanceof ExternalService);
    }

    /**
     * Test of getDesignation method, of class Company.
     */
    @Test
    public void testGetDesignation() throws FileNotFoundException {
        System.out.println("getDesignation");
        Company instance = new Company("Lapr Limitada", "123123123");
        String expResult = "Lapr Limitada";
        String result = instance.getDesignation();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Company.
     */
    @Test
    public void testEquals() throws FileNotFoundException {
        System.out.println("equals");
        Object o = new Company("Lapr Limitada", "123123123");
        Company instance = new Company("Lapr Limitada", "123123123");
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Company.
     */
    @Test
    public void testEqualsFalse() throws FileNotFoundException {
        System.out.println("equalsfalse");
        Object o = new Company("Lapr Limitada", "123123123");
        Company instance = new Company("Lapr Ilimitada", "123123123");
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Company.
     */
    @Test
    public void testEqualsFalseNull() throws FileNotFoundException {
        System.out.println("equalsfalse");
        Object o = null;
        Company instance = new Company("Lapr Ilimitada", "123123123");
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);

    }

    /**
     * Test of getAssociationRecords method, of class Company.
     */
    @Test
    public void testGetAssociationRecords() throws FileNotFoundException {
        System.out.println("getAssociationRecords");
        Company instance = new Company("Lapr Ilimitada", "123123123");
        AssociationProviderRequestRecords expResult = new AssociationProviderRequestRecords();
        AssociationProviderRequestRecords result = instance.getAssociationRecords();
        assertTrue(EqualsBuilder.reflectionEquals(expResult, result, true));
    }

    /**
     * Test of getFormatTypeRecords method, of class Company.
     */
    @Test
    public void testGetFormatTypeRecords() throws FileNotFoundException {
        System.out.println("getFormatTypeRecords");
        Company instance = new Company("Lapr Ilimitada", "123123123");
        FormatTypeRecords result = instance.getFormatTypeRecords();
        assertTrue(result instanceof FormatTypeRecords);
    }

    /**
     * Test of getIssueRecords method, of class Company.
     */
    @Test
    public void testGetIssueRecords() throws FileNotFoundException {
        System.out.println("getIssueRecords");
        Company instance = new Company("Lapr Ilimitada", "123123123");
        IssueRecords result = instance.getIssueRecords();
        assertTrue(result instanceof IssueRecords);
    }

    /**
     * Test of getServiceProvidingRequestRecords method, of class Company.
     */
    @Test
    public void testGetServiceProvidingRequestRecords() throws FileNotFoundException {
        System.out.println("getServiceProvidingRequestRecords");
        Company instance = new Company("Lapr Ilimitada", "123123123");
        ServiceProvidingRequestRecords result = instance.getServiceProvidingRequestRecords();
        assertTrue(result instanceof ServiceProvidingRequestRecords);
    }

    /**
     * Test of startTimerTask method, of class Company.
     */
    @Test
    public void testStartTimerTask() throws FileNotFoundException {
        System.out.println("startTimerTask");
        Company instance = new Company("Lapr Ilimitada", "123123123");
        AssociateSPtoRequestTimer result = instance.startTimerTask(Constants.ASS_TASK_TIMER_MINUTES, Constants.ASS_TASK_METHOD_FCFS);
        assertTrue(result instanceof AssociateSPtoRequestTimer);
    }

    /**
     * Test of getServiceScheduleRecords method, of class Company.
     */
    @Test
    public void testGetServiceScheduleRecords() throws FileNotFoundException {
        System.out.println("getServiceScheduleRecords");
        Company instance = new Company("Lapr Ilimitada", "123123123");
        ServiceScheduleRecords result = instance.getServiceScheduleRecords();
        assertTrue(result instanceof ServiceScheduleRecords);
    }
}
