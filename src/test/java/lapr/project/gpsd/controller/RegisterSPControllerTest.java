/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.ExternalService;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.records.ApplicationRecords;
import lapr.project.records.CategoryRecords;
import lapr.project.records.GeographicalAreaRecords;
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
public class RegisterSPControllerTest {

    public RegisterSPControllerTest() {
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
     * Test of getProviderInfo method, of class RegisterSPController.
     */
    @Test
    public void testGetProviderInfo() throws FileNotFoundException {
        System.out.println("getProviderInfo");
        int txtTinNumber = 123123123;
        PostalCode postalCode = new PostalCode("Paços", 23.32, 32.32);
        PostalAddress postalAddress = new PostalAddress("Rua", postalCode, "Paços");
        Application application = new Application("Pedro Brandao", 123123123, 123321123, "joao", postalAddress);
        ApplicationRecords appRec = AppGPSD.getInstance().getCompany().getApplicationRecords();
        appRec.addAplication(application);
        RegisterSPController instance = new RegisterSPController();
        Application applicationGotten = instance.getProviderInfo(txtTinNumber);
        String expResult = application.toString();
        String result = applicationGotten.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGeoAreas method, of class RegisterSPController.
     */
    @Test
    public void testGetGeoAreas() {
        System.out.println("getGeoAreas");
        RegisterSPController instance = new RegisterSPController();
        GeographicalArea geoArea = new GeographicalArea();
        GeographicalAreaRecords geoAreaRec = AppGPSD.getInstance().getCompany().getGeographicalAreaRecords();
        geoAreaRec.addGeographicalArea(geoArea);
        List<GeographicalArea> expResult = geoAreaRec.getGeoAreasList();
        List<GeographicalArea> result = instance.getGeoAreas();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCategories method, of class RegisterSPController.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        RegisterSPController instance = new RegisterSPController();
        Category cat = new Category("111", "Limpar O chao");
        CategoryRecords catRec = AppGPSD.getInstance().getCompany().getCategoryRecords();
        catRec.addCategory(cat);

        List<Category> expResult = catRec.getCategories();
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFullName method, of class RegisterSPController.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        RegisterSPController instance = new RegisterSPController();
        PostalCode postalCode = new PostalCode("paços", 42.3, 123.3);
        PostalAddress postalAddress = new PostalAddress("Rua", postalCode, "sad");
        Application appl = new Application("Pedro Brandao", 123, 123, "algumacena", postalAddress);
        ApplicationRecords applRec = AppGPSD.getInstance().getCompany().getApplicationRecords();
        applRec.addAplication(appl);
        String expResult = "Pedro Brandao";
        instance.getProviderInfo(123);
        String result = instance.getFullName();
        assertEquals(expResult, result);

    }

//    /**
//     * Test of getEmail method, of class RegisterSPController.
//     */
//    @Test
//    public void testGetEmail() {
//        System.out.println("getEmail");
//        RegisterSPController instance = new RegisterSPController();
//        PostalCode postalCode = new PostalCode("paços", 42.3, 123.3);
//        PostalAddress postalAddress = new PostalAddress("Rua", postalCode, "sad");
//        Application appl = new Application("Pedro Brandao", 123, 123, "pedro@gmail.com", postalAddress);
//        ApplicationRecords applRec = AppGPSD.getInstance().getCompany().getApplicationRecords();
//        applRec.addAplication(appl);
//        String expResult = "pedro@gmail.com";
//        instance.getProviderInfo(123);
//        String result = instance.getEmail();
//        assertEquals(expResult, result);
//    }
    /**
     * Test of getTelephoneNumber method, of class RegisterSPController.
     */
    @Test
    public void testGetTelephoneNumber() {
        System.out.println("getTelephoneNumber");
        RegisterSPController instance = new RegisterSPController();
        PostalCode postalCode = new PostalCode("paços", 42.3, 123.3);
        PostalAddress postalAddress = new PostalAddress("Rua", postalCode, "sad");
        Application appl = new Application("Pedro Brandao", 123, 123, "algumacena", postalAddress);
        ApplicationRecords applRec = AppGPSD.getInstance().getCompany().getApplicationRecords();
        applRec.addAplication(appl);
        String expResult = "123";
        instance.getProviderInfo(123);
        String result = instance.getTelephoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAbreviatedName method, of class RegisterSPController.
     */
    @Test
    public void testGetAbreviatedName() {
        System.out.println("getAbreviatedName");
        RegisterSPController instance = new RegisterSPController();
        PostalCode postalCode = new PostalCode("paços", 42.3, 123.3);
        PostalAddress postalAddress = new PostalAddress("Rua", postalCode, "sad");
        Application appl = new Application("Pedro Brandao", 123, 123, "algumacena", postalAddress);
        ApplicationRecords applRec = AppGPSD.getInstance().getCompany().getApplicationRecords();
        applRec.addAplication(appl);
        String expResult = "PB";
        instance.getProviderInfo(123);
        String result = instance.getAbreviatedName();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateProviderInfo method, of class RegisterSPController.
     */
    @Test
    public void testUpdateProviderInfo() {
        System.out.println("updateProviderInfo");
        String fullName = "Pedro Brandao";
        String abreviatedName = "PB";
        int tinNumber = 123123123;
        int telephoneNumber = 123123123;
        String email = "pedro@gmail.com";
        RegisterSPController instance = new RegisterSPController();
        boolean expResult = true;
        boolean result = instance.updateProviderInfo(fullName, abreviatedName, tinNumber, telephoneNumber, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerNewServiceProvider method, of class RegisterSPController.
     */
    @Test
    public void testRegisterNewServiceProvider() throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("registerNewServiceProvider");
        String fullName = "Pedro Brandao";
        String abreviatedName = "PB";
        int tinNumber = 123;
        int telephoneNumber = 123123123;
        String email = "pedro@gmail.com";
        PostalCode postalCode = new PostalCode("paços", 42.3, 123.3);
        PostalAddress postalAddress = new PostalAddress("Rua", postalCode, "sad");
        Application appl = new Application("Pedro Brandao", 123, 123, "algumacena", postalAddress);
        ApplicationRecords applRec = AppGPSD.getInstance().getCompany().getApplicationRecords();
        applRec.addAplication(appl);

        Category[] categories = new Category[3];
        ExternalService api = AppGPSD.getInstance().getCompany().getExternalService();
        GeographicalArea geoArea = new GeographicalArea("lousada", 3, "4000-10", 3, api);
        RegisterSPController instance = new RegisterSPController();
        instance.getProviderInfo(123);
        instance.updateProviderInfo(appl.getName(), "PB", appl.getTin(), appl.getTel(), appl.getEmail());
        boolean expResult = true;
        boolean result = instance.registerNewServiceProvider(fullName, abreviatedName, tinNumber, telephoneNumber, email, categories, geoArea);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class RegisterSPController.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        String fullName = "Pedro Brandao";
        String abreviatedName = "PB";
        int tinNumber = 123123123;
        int telephoneNumber = 123123123;
        String email = "pedro@gmail.com";
        Category cat = new Category("111", "Limpar O chao");
        RegisterSPController instance = new RegisterSPController();
        instance.updateProviderInfo(fullName, abreviatedName, tinNumber, telephoneNumber, email);
        boolean expResult = true;
        boolean result = instance.addCategory(cat);
        assertEquals(expResult, result);
    }

    /**
     * Test of addGeoArea method, of class RegisterSPController.
     */
    @Test
    public void testAddGeoArea() {
        System.out.println("addGeoArea");
        String fullName = "Pedro Brandao";
        String abreviatedName = "PB";
        int tinNumber = 123123123;
        int telephoneNumber = 123123123;
        String email = "pedro@gmail.com";
        GeographicalArea geoArea = new GeographicalArea();
        RegisterSPController instance = new RegisterSPController();
        instance.updateProviderInfo(fullName, abreviatedName, tinNumber, telephoneNumber, email);
        boolean expResult = true;
        boolean result = instance.addGeoArea(geoArea);
        assertEquals(expResult, result);
    }

}
