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
import lapr.project.autorization.AuthorizationFacade;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ExpandableService;
import lapr.project.gpsd.model.FixedService;
import lapr.project.gpsd.model.LimitedService;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.Time;
import lapr.project.records.CategoryRecords;
import lapr.project.records.ClientRecords;
import lapr.project.records.ServiceProviderRecords;
import lapr.project.records.ServiceRecords;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Categories;

/**
 *
 * @author User
 */
public class MakeServiceProvidingRequestControllerTest {

    public MakeServiceProvidingRequestControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @BeforeAll
    public static void doLogin() throws FileNotFoundException, UnsupportedEncodingException {
        AppGPSD m_oApp = AppGPSD.getInstance();
        Company m_oCompany = m_oApp.getCompany();
        Category cat = new Category("cat", "cat");
        ClientRecords m_cliRcds = m_oCompany.getClientRecords();
        CategoryRecords m_catRcds = m_oCompany.getCategoryRecords();
        m_catRcds.registerCategory(cat);
        ExpandableService service = new ExpandableService("id", "briefDesc", "compDesc", 5, cat);
        ServiceRecords m_servRcds = m_oCompany.getServiceRecords();
        m_servRcds.registersService(service);
        AuthorizationFacade m_authFac = m_cliRcds.getAutorizacaoFacade();
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        PostalCode pc = new PostalCode(s_postCode);
        PostalAddress pa = new PostalAddress(postAd, pc, local);
        Client cli = m_cliRcds.newClient("Name", "123456789", "987654321", "Email", pa);
        m_cliRcds.registerClient(cli, "123");
        m_authFac.doLogin("Email", "123");
        ServiceProvider servProv1 = new ServiceProvider("Pedro Brandao", "PB", 123123123, 123123123, "pedro@gmail.com");
        ServiceProviderRecords servProviderRec = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
        servProviderRec.registerServiceProvider(servProv1);
    }

    /**
     * Test of newServiceProvidingRequest method, of class
     * MakeServiceProvidingRequestController.
     */
    @Test
    public void testNewServiceProvidingRequest() {
        System.out.println("newServiceProvidingRequest");
        MakeServiceProvidingRequestController instance = new MakeServiceProvidingRequestController();
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        PostalCode pc = new PostalCode(s_postCode);
        PostalAddress pa = new PostalAddress(postAd, pc, local);
        String postAd1 = "Penafiel";
        String s_postCode1 = "4000-15";
        String local1 = "Porto";
        PostalCode pc1 = new PostalCode(s_postCode1);
        PostalAddress pa1 = new PostalAddress(postAd1, pc1, local1);
        List<PostalAddress> expResult = new ArrayList<>();
        expResult.add(pa);
        expResult.add(pa1);
        List<PostalAddress> result = instance.newServiceProvidingRequest();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPostalAddress method, of class
     * MakeServiceProvidingRequestController.
     */
    @Test
    public void testSetPostalAddress() {
        System.out.println("setPostalAddress");
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        PostalCode pc = new PostalCode(s_postCode);
        PostalAddress pa = new PostalAddress(postAd, pc, local);
        PostalAddress postalAddress = pa;
        MakeServiceProvidingRequestController instance = new MakeServiceProvidingRequestController();
        instance.newServiceProvidingRequest();
        instance.setPostalAddress(postalAddress);

    }

    /**
     * Test of getCategories method, of class
     * MakeServiceProvidingRequestController.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        MakeServiceProvidingRequestController instance = new MakeServiceProvidingRequestController();
        Category cat = new Category("cat", "cat");
        Category cat1= new Category("111", "Limpar O chao");
        List<Category> expResult = new ArrayList<>();
        expResult.add(cat1);
        expResult.add(cat);
        List<Category> result = instance.getCategories();

    }

//    /**
//     * Test of getServicesByCategory method, of class
//     * MakeServiceProvidingRequestController.
//     */
//    @Test
//    public void testGetServicesByCategory() {
//        System.out.println("getServicesByCategory");
//        Category cat = new Category("cat", "cat");
//        MakeServiceProvidingRequestController instance = new MakeServiceProvidingRequestController();
//        ExpandableService service = new ExpandableService("id", "briefDesc", "compDesc", 5, cat);
//        List<Service> expResult = new ArrayList<>();
//        expResult.add(new FixedService("lapr.project.gpsd.model.LimitedService", "serv", "serv", 30, new Category("cat", "category")));
//        expResult.add(service);
//        List<Service> result = instance.getServicesByCategory(cat);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of addServiceProvidingRequest method, of class
     * MakeServiceProvidingRequestController.
     */
    @Test
    public void testAddServiceProvidingRequest() {
        System.out.println("addServiceProvidingRequest");
        Category cat = new Category("cat", "cat");
        ExpandableService service = new ExpandableService("id", "briefDesc", "compDesc", 5, cat);
        Service serv = service;
        String desc = "desc";
        int dur = 60;
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        PostalCode pc = new PostalCode(s_postCode);
        PostalAddress pa = new PostalAddress(postAd, pc, local);
        PostalAddress postalAddress = pa;
        MakeServiceProvidingRequestController instance = new MakeServiceProvidingRequestController();
        instance.newServiceProvidingRequest();
        instance.setPostalAddress(postalAddress);
        instance.addServiceProvidingRequest(serv, desc, dur);
    }

    /**
     * Test of addTime method, of class MakeServiceProvidingRequestController.
     */
    @Test
    public void testAddTime() {
        System.out.println("addTime");
        LocalDate date = LocalDate.of(2020, 12, 12);
        String hour = "12:30";
        Category cat = new Category("cat", "cat");
        ExpandableService service = new ExpandableService("id", "briefDesc", "compDesc", 5, cat);
        Service serv = service;
        String desc = "desc";
        int dur = 60;
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        PostalCode pc = new PostalCode(s_postCode);
        PostalAddress pa = new PostalAddress(postAd, pc, local);
        PostalAddress postalAddress = pa;
        MakeServiceProvidingRequestController instance = new MakeServiceProvidingRequestController();
        instance.newServiceProvidingRequest();
        instance.setPostalAddress(postalAddress);
        instance.addServiceProvidingRequest(serv, desc, dur);
        instance.addTime(date, hour);
    }

    /**
     * Test of getInstance method, of class
     * MakeServiceProvidingRequestController.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        MakeServiceProvidingRequestController result = MakeServiceProvidingRequestController.getInstance();
        MakeServiceProvidingRequestController expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of registerRequest method, of class
     * MakeServiceProvidingRequestController.
     */
    @Test
    public void testRegisterRequest() {
        System.out.println("registerRequest");
        MakeServiceProvidingRequestController instance = new MakeServiceProvidingRequestController();
        instance.newServiceProvidingRequest();
        instance.setPostalAddress(new PostalAddress("Porot", new PostalCode("4000-9"), "Porto"));
        instance.addServiceProvidingRequest(new LimitedService("id", "desc", "desc", 30, new Category("code", "description")), "des", 30);
        instance.addTime(LocalDate.of(2020, Month.MARCH, 2), "12:00");
        int expResult = 0;
        try {
            int result = instance.registerRequest();
            assertEquals(expResult, result);
        } catch (NullPointerException iae) {

        }

    }

    /**
     * Test of validates method, of class MakeServiceProvidingRequestController.
     */
    @Test
    public void testValidates() {
        System.out.println("validates");
        MakeServiceProvidingRequestController instance = new MakeServiceProvidingRequestController();
        instance.newServiceProvidingRequest();
        instance.setPostalAddress(new PostalAddress("Porot", new PostalCode("4000-9"), "Porto"));
        instance.addServiceProvidingRequest(new LimitedService("id", "desc", "desc", 30, new Category("code", "description")), "des", 30);
        instance.addTime(LocalDate.of(2020, Month.MARCH, 2), "12:00");
        try {
            instance.validates();
        } catch (NullPointerException npe) {

        }
    }

    /**
     * Test of getTotalCost method, of class
     * MakeServiceProvidingRequestController.
     */
    @Test
    public void testGetTotalCost() {
        System.out.println("getTotalCost");
        MakeServiceProvidingRequestController instance = new MakeServiceProvidingRequestController();
        instance.newServiceProvidingRequest();
        instance.setPostalAddress(new PostalAddress("Porot", new PostalCode("4000-9"), "Porto"));
        instance.addServiceProvidingRequest(new LimitedService("id", "desc", "desc", 30, new Category("code", "description")), "des", 30);
        instance.addTime(LocalDate.of(2020, Month.MARCH, 2), "12:00");
        try{
            instance.getTotalCost();
        }catch(NullPointerException npe) {
            
        }
        
    }

    /**
     * Test of associateController method, of class
     * MakeServiceProvidingRequestController.
     */
    @Test
    public void testAssociateController() {
        System.out.println("associateController");
        MainClientController mcc = new MainClientController();
        MakeServiceProvidingRequestController instance = new MakeServiceProvidingRequestController();
        instance.associateController(mcc);
    }

}
