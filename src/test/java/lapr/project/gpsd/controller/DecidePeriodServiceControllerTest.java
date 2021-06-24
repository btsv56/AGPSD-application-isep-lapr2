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
import lapr.project.gpsd.model.AssociationSPtoRequest;
import lapr.project.gpsd.model.Availability;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ExpandableService;
import lapr.project.gpsd.model.ExternalService;
import lapr.project.gpsd.model.FixedService;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.ProviderAssociation;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequest;
import lapr.project.gpsd.model.ServiceProvidingRequestDescription;
import lapr.project.gpsd.model.ServiceSchedule;
import lapr.project.gpsd.model.Time;
import lapr.project.records.AssociationProviderRequestRecords;
import lapr.project.records.AvailabilityList;
import lapr.project.records.CategoryRecords;
import lapr.project.records.ClientRecords;
import lapr.project.records.ServiceProviderRecords;
import lapr.project.records.ServiceProvidingRequestRecords;
import lapr.project.records.ServiceRecords;
import lapr.project.records.ServiceScheduleRecords;
import lapr.project.timer.AssociationProviderServiceAlgorithm;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Andre
 */
public class DecidePeriodServiceControllerTest {

    public DecidePeriodServiceControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @BeforeAll
    public static void doLogin() {
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
    }

    @After
    public void tearDown() {
    }

    @Before
    public void setUp() throws UnsupportedEncodingException, FileNotFoundException {

    }

    /**
     * Test of getListAssociatedClient method, of class
     * DecidePeriodServiceController.
     */
    @Test
    public void testGetListAssociatedClient() throws FileNotFoundException {
        System.out.println("getListAssociatedClient");
        DecidePeriodServiceController instance = new DecidePeriodServiceController();
        AssociationProviderRequestRecords rapr = AppGPSD.getInstance().getCompany().getAssociationRecords();
        List<AssociationSPtoRequest> AssoList = rapr.getAssociationsList();
        ServiceProvider sp = new ServiceProvider("andre Nuno", "andre", 123456789, 919999999, "andrenuno@gmail.com");
        PostalCode pc = new PostalCode("4000-9");
        PostalAddress pa = new PostalAddress("Porto", pc, "Paredes");
        Client cli = new Client("Name", "123456789", "987654321", "Email", pa);
        ServiceProvidingRequest request = new ServiceProvidingRequest(cli, pa);
        ServiceProvidingRequestRecords m_servProvRequest = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        ServiceProvidingRequest requestTest = m_servProvRequest.newRequest(cli, pa);
        List<ServiceProvidingRequestDescription> requestDesc = new ArrayList<>();
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        Category cat1 = cr.getCategoryById("1");
        FixedService serv1 = new FixedService("1", "Light Plumbing", "Install water tap", 100, cat1);
        ServiceRecords sr = AppGPSD.getInstance().getCompany().getServiceRecords();
        sr.registersService(serv1);
        ServiceProvidingRequestDescription desc = new ServiceProvidingRequestDescription(serv1, "ola", 30);
        requestDesc.add(desc);
        rapr.addAssociation(sp, request);

        instance.getListAssociatedClient();
    }

    /**
     * Test of getServiceSchedule method, of class
     * DecidePeriodServiceController.
     */
    @Test
    public void testGetServiceSchedule_int() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedEncodingException {
        System.out.println("getServiceSchedule");
        int numSer = 0;
        DecidePeriodServiceController instance = new DecidePeriodServiceController();
        ServiceProviderRecords spr = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
        ServiceProvidingRequestRecords sprr = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        AssociationProviderRequestRecords aprr = AppGPSD.getInstance().getCompany().getAssociationRecords();
        ServiceProvider sp = new ServiceProvider("andre Nuno", "andre", 123456789, 919999999, "andrenuno@gmail.com");
        spr.registerServiceProvider(sp);
        ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
        GeographicalArea area = new GeographicalArea("Rua x", 10.0, "4420-570", 1000, api);
        sp.addGeographicalArea(area);
        ServiceProvider sp1 = spr.getServiceProvider("andrenuno@gmail.com");
        AvailabilityList a1 = sp1.getAvailabilityList();
        Availability aval1 = a1.newAvailabilityTime(LocalDate.of(2019, 6, 3), "09:00", LocalDate.of(2020, 6, 5), "18:00", "Everyday");
        a1.addAvailabilityTime(aval1);
        PostalCode pc = new PostalCode("4000-9");
        PostalAddress pa = new PostalAddress("Porto", pc, "Paredes");
        Client cli = new Client("Name", "123456789", "987654321", "Email", pa);
        ServiceProvidingRequest request = new ServiceProvidingRequest(cli, pa);
        ServiceProvidingRequestRecords m_servProvRequest = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        ServiceProvidingRequest requestTest = m_servProvRequest.newRequest(cli, pa);
        requestTest.addTime(LocalDate.of(2019, 6, 26), "09:00");
        try {
            sprr.registerRequest(requestTest);
        } catch (NullPointerException npe) {

        }
        List<ServiceProvidingRequestDescription> requestDesc = new ArrayList<>();
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        Category cat = new Category("1", "Plumber");
        cr.addCategory(cat);
        Category cat1 = cr.getCategoryById("1");
        FixedService serv1 = new FixedService("1", "Light Plumbing", "Install water tap", 100, cat1);
        ServiceRecords sr = AppGPSD.getInstance().getCompany().getServiceRecords();
        sr.registersService(serv1);
        ServiceProvidingRequestDescription desc = new ServiceProvidingRequestDescription(serv1, "ola", 30);
        requestDesc.add(desc);
        aprr.addAssociation(sp, request);
        instance.getListAssociatedClient();
        List<AssociationSPtoRequest> AssoListRefCLie = instance.getAssoListRefCli();
        ServiceScheduleRecords ssr = AppGPSD.getInstance().getCompany().getServiceScheduleRecords();
        AssociationProviderServiceAlgorithm assAlg = new AssociationProviderServiceAlgorithm();
        assAlg.associate(request);
        ServiceSchedule ss= new ServiceSchedule("undefined", LocalDate.MAX, new Time("12:00"));
        AppGPSD.getInstance().getCompany().getServiceScheduleRecords().addSStolist(ss);
        ServiceSchedule result = instance.getServiceSchedule(numSer);
    }

    /**
     * Test of registerServiceOrdersIfAccept method, of class
     * DecidePeriodServiceController.
     */
    @Test
    public void testRegisterServiceOrdersIfAccept() throws FileNotFoundException, UnsupportedEncodingException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("registerServiceOrdersIfAccept");
        int numSer = 0;
        DecidePeriodServiceController instance = new DecidePeriodServiceController();
        ServiceProviderRecords spr = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
        ServiceProvidingRequestRecords sprr = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        AssociationProviderRequestRecords aprr = AppGPSD.getInstance().getCompany().getAssociationRecords();
        ServiceProvider sp = new ServiceProvider("andre Nuno", "andre", 123456789, 919999999, "andrenuno@gmail.com");
        spr.registerServiceProvider(sp);
        ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
        GeographicalArea area = new GeographicalArea("Rua x", 10.0, "4420-570", 1000, api);
        sp.addGeographicalArea(area);
        ServiceProvider sp1 = spr.getServiceProvider("andrenuno@gmail.com");
        AvailabilityList a1 = sp1.getAvailabilityList();
        Availability aval1 = a1.newAvailabilityTime(LocalDate.of(2019, 6, 3), "09:00", LocalDate.of(2020, 6, 5), "18:00", "Everyday");
        a1.addAvailabilityTime(aval1);
        PostalCode pc = new PostalCode("4000-9");
        PostalAddress pa = new PostalAddress("Porto", pc, "Paredes");
        Client cli = new Client("Name", "123456789", "987654321", "Email", pa);
        ServiceProvidingRequest request = new ServiceProvidingRequest(cli, pa);
        ServiceProvidingRequestRecords m_servProvRequest = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        ServiceProvidingRequest requestTest = m_servProvRequest.newRequest(cli, pa);
        requestTest.addTime(LocalDate.of(2019, 6, 26), "09:00");
        try {
            sprr.registerRequest(requestTest);
        } catch (NullPointerException npe) {

        }
        List<ServiceProvidingRequestDescription> requestDesc = new ArrayList<>();
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        Category cat = new Category("1", "Plumber");
        cr.addCategory(cat);
        Category cat1 = cr.getCategoryById("1");
        FixedService serv1 = new FixedService("1", "Light Plumbing", "Install water tap", 100, cat1);
        ServiceRecords sr = AppGPSD.getInstance().getCompany().getServiceRecords();
        sr.registersService(serv1);
        ServiceProvidingRequestDescription desc = new ServiceProvidingRequestDescription(serv1, "ola", 30);
        requestDesc.add(desc);
        aprr.addAssociation(sp, request);
        instance.getListAssociatedClient();
        List<AssociationSPtoRequest> AssoListRefCLie = instance.getAssoListRefCli();
        ServiceScheduleRecords ssr = AppGPSD.getInstance().getCompany().getServiceScheduleRecords();
        AssociationProviderServiceAlgorithm assAlg = new AssociationProviderServiceAlgorithm();
        assAlg.associate(request);
        ServiceSchedule ss= new ServiceSchedule("undefined", LocalDate.MAX, new Time("12:00"));
        AppGPSD.getInstance().getCompany().getServiceScheduleRecords().addSStolist(ss);
        instance.getServiceSchedule(numSer);
        instance.registerServiceOrdersIfAccept(ss);
    }

    /**
     * Test of getRatingProvider method, of class DecidePeriodServiceController.
     */
    @Test
    public void testGetRatingProvider() throws FileNotFoundException {
        System.out.println("getRatingProvider");
        DecidePeriodServiceController instance = new DecidePeriodServiceController();
        ServiceProvider prov = new ServiceProvider("andre Nuno", "andre", 123456789, 919999999, "andrenuno@gmail.com");
        double expResult = 3.0;
        double result = instance.getRatingProvider(prov);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getRatingProvider method, of class DecidePeriodServiceController.
     */
    @Test
    public void testGetRatingProvider2() throws FileNotFoundException {
        System.out.println("getRatingProvider");
        DecidePeriodServiceController instance = new DecidePeriodServiceController();
        ServiceProvider prov = new ServiceProvider("andre Nuno", "andre", 123456789, 919999999, "andrenuno@gmail.com");
        prov.getEvaluation().setMeanRating(5);
        double expResult = 5.0;
        double result = instance.getRatingProvider(prov);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of registerOrderService method, of class
     * DecidePeriodServiceController.
     */
    @Test
    public void testRegisterOrderService() throws Exception {
        System.out.println("registerOrderService");
        int numSer = 0;
        DecidePeriodServiceController instance = new DecidePeriodServiceController();
        ServiceProviderRecords spr = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
        ServiceProvidingRequestRecords sprr = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        AssociationProviderRequestRecords aprr = AppGPSD.getInstance().getCompany().getAssociationRecords();
        ServiceProvider sp = new ServiceProvider("andre Nuno", "andre", 123456789, 919999999, "andrenuno@gmail.com");
        spr.registerServiceProvider(sp);
        ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
        GeographicalArea area = new GeographicalArea("Rua x", 10.0, "4420-570", 1000, api);
        sp.addGeographicalArea(area);
        ServiceProvider sp1 = spr.getServiceProvider("andrenuno@gmail.com");
        AvailabilityList a1 = sp1.getAvailabilityList();
        Availability aval1 = a1.newAvailabilityTime(LocalDate.of(2019, 6, 3), "09:00", LocalDate.of(2020, 6, 5), "18:00", "Everyday");
        a1.addAvailabilityTime(aval1);
        PostalCode pc = new PostalCode("4000-9");
        PostalAddress pa = new PostalAddress("Porto", pc, "Paredes");
        Client cli = new Client("Name", "123456789", "987654321", "Email", pa);
        ServiceProvidingRequest request = new ServiceProvidingRequest(cli, pa);
        ServiceProvidingRequestRecords m_servProvRequest = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        ServiceProvidingRequest requestTest = m_servProvRequest.newRequest(cli, pa);
        requestTest.addTime(LocalDate.of(2019, 6, 26), "09:00");
        try {
            sprr.registerRequest(requestTest);
        } catch (NullPointerException npe) {

        }
        List<ServiceProvidingRequestDescription> requestDesc = new ArrayList<>();
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        Category cat = new Category("1", "Plumber");
        cr.addCategory(cat);
        Category cat1 = cr.getCategoryById("1");
        FixedService serv1 = new FixedService("1", "Light Plumbing", "Install water tap", 100, cat1);
        ServiceRecords sr = AppGPSD.getInstance().getCompany().getServiceRecords();
        sr.registersService(serv1);
        ServiceProvidingRequestDescription desc = new ServiceProvidingRequestDescription(serv1, "ola", 30);
        requestDesc.add(desc);
        aprr.addAssociation(sp, request);
        instance.getListAssociatedClient();
        List<AssociationSPtoRequest> AssoListRefCLie = instance.getAssoListRefCli();
        ServiceScheduleRecords ssr = AppGPSD.getInstance().getCompany().getServiceScheduleRecords();
        AssociationProviderServiceAlgorithm assAlg = new AssociationProviderServiceAlgorithm();
        assAlg.associate(request);
        ServiceSchedule ss= new ServiceSchedule("undefined", LocalDate.MAX, new Time("12:00"));
        AppGPSD.getInstance().getCompany().getServiceScheduleRecords().addSStolist(ss);
        instance.getServiceSchedule(numSer);
        ServiceOrder so = new ServiceOrder(1, sp, desc, ss, pa, cli);
        int expResult = 9;
        instance.registerServiceOrdersIfAccept(ss);
        int result = instance.registerOrderService(so);
    }

    /**
     * Test of getProviderNameFromAssociatedList method, of class
     * DecidePeriodServiceController.
     */
    @Test
    public void testGetProviderNameFromAssociatedList() throws FileNotFoundException {
        System.out.println("getProviderNameFromAssociatedList");
        int i = 0;
        DecidePeriodServiceController instance = new DecidePeriodServiceController();
        AssociationProviderRequestRecords aprr = AppGPSD.getInstance().getCompany().getAssociationRecords();
        ServiceProvider sp = new ServiceProvider("andre Nuno", "andre", 123456789, 919999999, "andrenuno@gmail.com");
        PostalCode pc = new PostalCode("4000-9");
        PostalAddress pa = new PostalAddress("Porto", pc, "Paredes");
        Client cli = new Client("Name", "123456789", "987654321", "Email", pa);
        ServiceProvidingRequest request = new ServiceProvidingRequest(cli, pa);
        ServiceProvidingRequestRecords m_servProvRequest = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        ServiceProvidingRequest requestTest = m_servProvRequest.newRequest(cli, pa);
        List<ServiceProvidingRequestDescription> requestDesc = new ArrayList<>();
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        Category cat = new Category("1", "Plumber");
        cr.addCategory(cat);
        Category cat1 = cr.getCategoryById("1");
        FixedService serv1 = new FixedService("1", "Light Plumbing", "Install water tap", 100, cat1);
        ServiceRecords sr = AppGPSD.getInstance().getCompany().getServiceRecords();
        sr.registersService(serv1);
        ServiceProvidingRequestDescription desc = new ServiceProvidingRequestDescription(serv1, "ola", 30);
        requestDesc.add(desc);
        aprr.addAssociation(sp, request);
        instance.getListAssociatedClient();
        String expResult = "andre";
        String result = instance.getProviderNameFromAssociatedList(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProviderFromAssociatedList method, of class
     * DecidePeriodServiceController.
     */
    @Test
    public void testGetProviderFromAssociatedList() throws FileNotFoundException {
        System.out.println("getProviderFromAssociatedList");
        int i = 0;
        DecidePeriodServiceController instance = new DecidePeriodServiceController();
        AssociationProviderRequestRecords aprr = AppGPSD.getInstance().getCompany().getAssociationRecords();
        ServiceProvider sp = new ServiceProvider("andre Nuno", "andre", 123456789, 919999999, "andrenuno@gmail.com");
        PostalCode pc = new PostalCode("4000-9");
        PostalAddress pa = new PostalAddress("Porto", pc, "Paredes");
        Client cli = new Client("Name", "123456789", "987654321", "Email", pa);
        ServiceProvidingRequest request = new ServiceProvidingRequest(cli, pa);
        ServiceProvidingRequestRecords m_servProvRequest = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        ServiceProvidingRequest requestTest = m_servProvRequest.newRequest(cli, pa);
        List<ServiceProvidingRequestDescription> requestDesc = new ArrayList<>();
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        Category cat1 = cr.getCategoryById("1");
        FixedService serv1 = new FixedService("1", "Light Plumbing", "Install water tap", 100, cat1);
        ServiceRecords sr = AppGPSD.getInstance().getCompany().getServiceRecords();
        sr.registersService(serv1);
        ServiceProvidingRequestDescription desc = new ServiceProvidingRequestDescription(serv1, "ola", 30);
        requestDesc.add(desc);
        aprr.addAssociation(sp, request);
        instance.getListAssociatedClient();

        ServiceProvider expResult = sp;
        ServiceProvider result = instance.getProviderFromAssociatedList(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescList method, of class DecidePeriodServiceController.
     */
    @Test
    public void testGetDescList() throws FileNotFoundException {
        System.out.println("getDescList");
        int i = 0;
        DecidePeriodServiceController instance = new DecidePeriodServiceController();
        AssociationProviderRequestRecords aprr = AppGPSD.getInstance().getCompany().getAssociationRecords();
        ServiceProvider sp = new ServiceProvider("andre Nuno", "andre", 123456789, 919999999, "andrenuno@gmail.com");
        PostalCode pc = new PostalCode("4000-9");
        PostalAddress pa = new PostalAddress("Porto", pc, "Paredes");
        Client cli = new Client("Name", "123456789", "987654321", "Email", pa);
        ServiceProvidingRequest request = new ServiceProvidingRequest(cli, pa);
        ServiceProvidingRequestRecords m_servProvRequest = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        ServiceProvidingRequest requestTest = m_servProvRequest.newRequest(cli, pa);
        List<ServiceProvidingRequestDescription> requestDesc = new ArrayList<>();
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        Category cat = new Category("1", "Plumber");
        cr.addCategory(cat);
        Category cat1 = cr.getCategoryById("1");
        FixedService serv1 = new FixedService("1", "Light Plumbing", "Install water tap", 100, cat1);
        ServiceRecords sr = AppGPSD.getInstance().getCompany().getServiceRecords();
        sr.registersService(serv1);
        ServiceProvidingRequestDescription desc = new ServiceProvidingRequestDescription(serv1, "ola", 30);
        requestDesc.add(desc);
        aprr.addAssociation(sp, request);
        instance.getListAssociatedClient();
        List<ServiceProvidingRequestDescription> expResult = new ArrayList<ServiceProvidingRequestDescription>();
        List<ServiceProvidingRequestDescription> result = instance.getDescList(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAssoListRefCliSize method, of class
     * DecidePeriodServiceController.
     */
    @Test
    public void testGetAssoListRefCliSize() throws FileNotFoundException {
        System.out.println("getAssoListRefCliSize");
        DecidePeriodServiceController instance = new DecidePeriodServiceController();
        AssociationProviderRequestRecords aprr = AppGPSD.getInstance().getCompany().getAssociationRecords();
        ServiceProvider sp = new ServiceProvider("andre Nuno", "andre", 123456789, 919999999, "andrenuno@gmail.com");
        PostalCode pc = new PostalCode("4000-9");
        PostalAddress pa = new PostalAddress("Porto", pc, "Paredes");
        Client cli = new Client("Name", "123456789", "987654321", "Email", pa);
        ServiceProvidingRequest request = new ServiceProvidingRequest(cli, pa);
        ServiceProvidingRequestRecords m_servProvRequest = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        ServiceProvidingRequest requestTest = m_servProvRequest.newRequest(cli, pa);
        List<ServiceProvidingRequestDescription> requestDesc = new ArrayList<>();
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        Category cat1 = cr.getCategoryById("1");
        FixedService serv1 = new FixedService("1", "Light Plumbing", "Install water tap", 100, cat1);
        ServiceRecords sr = AppGPSD.getInstance().getCompany().getServiceRecords();
        sr.registersService(serv1);
        ServiceProvidingRequestDescription desc = new ServiceProvidingRequestDescription(serv1, "ola", 30);
        requestDesc.add(desc);
        int expResult = 0;
        int result = instance.getAssoListRefCliSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceSchedule method, of class
     * DecidePeriodServiceController.
     */
    @Test
    public void testGetServiceSchedule_0args() throws Exception {
        System.out.println("getServiceSchedule");
        DecidePeriodServiceController instance = new DecidePeriodServiceController();
        ServiceSchedule ss = new ServiceSchedule("undefined", LocalDate.now(), new Time("12:00"));
        ServiceScheduleRecords ssr = AppGPSD.getInstance().getCompany().getServiceScheduleRecords();
        ssr.addSStolist(ss);
        ServiceSchedule expResult = null;
        ServiceSchedule result = instance.getServiceSchedule();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of removeAssoFromAssoList method, of class
     * DecidePeriodServiceController.
     */
    @Test
    public void testRemoveAssoFromAssoList() throws FileNotFoundException {
        System.out.println("removeAssoFromAssoList");
        int num = 0;
        DecidePeriodServiceController instance = new DecidePeriodServiceController();
        AssociationProviderRequestRecords aprr = AppGPSD.getInstance().getCompany().getAssociationRecords();
        ServiceProvider sp = new ServiceProvider("andre Nuno", "andre", 123456789, 919999999, "andrenuno@gmail.com");
        PostalCode pc = new PostalCode("4420-570", 1, 1);
        PostalAddress pa = new PostalAddress("Rua x", pc, "Porto");
        Client cli = new Client("Pedro", "123123123", "123123123", "pedro@gmail.com", pa);
        ServiceProvidingRequest request = new ServiceProvidingRequest(cli, pa);
        ServiceProvidingRequestRecords m_servProvRequest = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        ServiceProvidingRequest requestTest = m_servProvRequest.newRequest(cli, pa);
        List<ServiceProvidingRequestDescription> requestDesc = new ArrayList<>();
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        Category cat1 = cr.getCategoryById("1");
        FixedService serv1 = new FixedService("1", "Light Plumbing", "Install water tap", 100, cat1);
        ServiceRecords sr = AppGPSD.getInstance().getCompany().getServiceRecords();
        sr.registersService(serv1);
        ServiceProvidingRequestDescription desc = new ServiceProvidingRequestDescription(serv1, "ola", 30);
        requestDesc.add(desc);
        aprr.addAssociation(sp, request);

        instance.removeAssoFromAssoList(num);
    }

}
