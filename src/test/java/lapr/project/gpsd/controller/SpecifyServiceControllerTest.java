/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.ServiceType;
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
public class SpecifyServiceControllerTest {

    public SpecifyServiceControllerTest() {
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
     * Test of getServiceTypes method, of class SpecifyServiceController.
     */
    @Test
    public void testGetServiceTypes() {
        System.out.println("getServiceTypes");
        AppGPSD app = AppGPSD.getInstance();
        app.doLogin("adm1@esoft.pt", "123456");
        SpecifyServiceController instance = new SpecifyServiceController();
        List<ServiceType> expResult = new ArrayList<>();
        expResult.add(new ServiceType("lapr.project.gpsd.model.FixedService", "Fixed"));
        expResult.add(new ServiceType("lapr.project.gpsd.model.LimitedService", "Limited"));
        expResult.add(new ServiceType("lapr.project.gpsd.model.ExpandableService", "Expandable"));
        List<ServiceType> result = instance.getServiceTypes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setServiceType method, of class SpecifyServiceController.
     */
    @Test
    public void testSetServiceType() {
        System.out.println("setServiceType");
        AppGPSD app = AppGPSD.getInstance();
        app.doLogin("adm1@esoft.pt", "123456");
        String idType = "lapr.project.gpsd.model.FixedService";
        SpecifyServiceController instance = new SpecifyServiceController();
        instance.getServiceTypes();
        instance.setServiceType(idType);
    }

//    /**
//     * Test of getCategories method, of class SpecifyServiceController.
//     */
//    @Test
//    public void testGetCategories() {
//        System.out.println("getCategories");
//        AppGPSD app = AppGPSD.getInstance();
//        app.doLogin("adm1@esoft.pt", "123456");
//        SpecifyServiceController instance = new SpecifyServiceController();
//        List<Category> expResult = new ArrayList<>();
//        expResult.add(new Category("cat", "cat"));
//        List<Category> result = instance.getCategories();
//        assertEquals(expResult, result);
//
//    }

    /**
     * Test of newService method, of class SpecifyServiceController.
     */
    @Test
    public void testNewService() throws Exception {
        System.out.println("newService");
        AppGPSD app = AppGPSD.getInstance();
        app.doLogin("adm1@esoft.pt", "123456");
        String strId = "lapr.project.gpsd.model.LimitedService";
        String strBriefDescription = "serv";
        String strCompleteDescription = "serv";
        double costHour = 1.0;
        String categoriaId = "cat";
        app.getCompany().getCategoryRecords().registerCategory(new Category("cat", "cat"));
        SpecifyServiceController instance = new SpecifyServiceController();
        instance.getServiceTypes();
        instance.setServiceType("Fixed");
        instance.getCategories();
        boolean expResult = true;
        boolean result = instance.newService(strId, strBriefDescription, strCompleteDescription, costHour, categoriaId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getOtherAttributes method, of class SpecifyServiceController.
     */
    @Test
    public void testGetOtherAttributes() throws Exception {
        System.out.println("getOtherAttributes");
        AppGPSD app = AppGPSD.getInstance();
        app.doLogin("adm1@esoft.pt", "123456");
        String strId = "lapr.project.gpsd.model.LimitedService";
        String strBriefDescription = "serv";
        String strCompleteDescription = "serv";
        double costHour = 1.0;
        String categoriaId = "cat";
        app.getCompany().getCategoryRecords().registerCategory(new Category("cat", "cat"));
        SpecifyServiceController instance = new SpecifyServiceController();
        instance.getServiceTypes();
        instance.setServiceType("Fixed");
        instance.getCategories();
        instance.newService(strId, strBriefDescription, strCompleteDescription, costHour, categoriaId);
        String expResult = "Pre-Determined Duration";
        String result = instance.getOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdditionalData method, of class SpecifyServiceController.
     */
    @Test
    public void testSetAdditionalData() throws Exception {
        System.out.println("setAdditionalData");
        AppGPSD app = AppGPSD.getInstance();
        app.doLogin("adm1@esoft.pt", "123456");
        String strId = "lapr.project.gpsd.model.LimitedService";
        String strBriefDescription = "serv";
        String strCompleteDescription = "serv";
        double costHour = 1.0;
        String categoriaId = "cat";
        app.getCompany().getCategoryRecords().registerCategory(new Category("cat", "cat"));
        int data = 30;
        SpecifyServiceController instance = new SpecifyServiceController();
        instance.getServiceTypes();
        instance.setServiceType("Fixed");
        instance.getCategories();
        instance.newService(strId, strBriefDescription, strCompleteDescription, costHour, categoriaId);
        instance.getOtherAttributes();
        instance.setAdditionalData(data);
    }

    /**
     * Test of validates method, of class SpecifyServiceController.
     */
    @Test
    public void testValidates() throws Exception {
        System.out.println("validates");
        AppGPSD app = AppGPSD.getInstance();
        app.doLogin("adm1@esoft.pt", "123456");
        String strId = "lapr.project.gpsd.model.LimitedService";
        String strBriefDescription = "serv";
        String strCompleteDescription = "serv";
        double costHour = 1.0;
        String categoriaId = "cat";
        app.getCompany().getCategoryRecords().registerCategory(new Category("cat", "cat"));
        int data = 30;
        SpecifyServiceController instance = new SpecifyServiceController();
        instance.getServiceTypes();
        instance.setServiceType("Fixed");
        instance.getCategories();
        instance.newService(strId, strBriefDescription, strCompleteDescription, costHour, categoriaId);
        instance.getOtherAttributes();
        instance.setAdditionalData(data);
        instance.validates();
        instance.registersService();
        instance.newService(strId, strBriefDescription, strCompleteDescription, costHour, categoriaId);
        instance.getOtherAttributes();
        instance.setAdditionalData(data);
        String expResult = "Invalid service.";
        String result = instance.validates();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of registersService method, of class SpecifyServiceController.
//     */
//    @Test
//    public void testRegistersService() throws Exception {
//        System.out.println("registersService");
//          System.out.println("validates");
//        AppGPSD app = AppGPSD.getInstance();
//        app.doLogin("adm1@esoft.pt", "123456");
//        String strId = "lapr.project.gpsd.model.LimitedService";
//        String strBriefDescription = "serv";
//        String strCompleteDescription = "serv";
//        double costHour = 1.0;
//        String categoriaId = "cat";
//        app.getCompany().getCategoryRecords().registerCategory(new Category("cat", "cat"));
//        int data = 30;
//        SpecifyServiceController instance = new SpecifyServiceController();
//         instance.getServiceTypes();
//        instance.setServiceType("Fixed");
//        instance.getCategories();
//        instance.newService(strId, strBriefDescription, strCompleteDescription, costHour, categoriaId);
//        instance.getOtherAttributes();
//        instance.setAdditionalData(data);
//        instance.validates();
//        boolean expResult = false;
//        boolean result = instance.registersService();
//        assertEquals(expResult, result);
//    }

}
