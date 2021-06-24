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
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.PostalAddress;
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
public class ApplicationRecordsTest {

    public ApplicationRecordsTest() {
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
     * Test of getApplicationList method, of class ApplicationRecords.
     */
    @Test
    public void testGetApplicationList() {
        System.out.println("getApplicationList");
        ApplicationRecords instance = new ApplicationRecords();
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application app1 = new Application("Veiga", 123456789, 123456789, "sp", new PostalAddress("Porto", company.getPostalCodeRecords().getPostalCodeByPos(0), "Porto"));
        List<Application> expResult = new ArrayList<>();
        expResult.add(app1);
        List<Application> result = instance.getApplicationList();
        result.add(app1);
        assertEquals(expResult, result);
    }

    /**
     * Test of newApplication method, of class ApplicationRecords.
     */
    @Test
    public void testNewApplication() throws FileNotFoundException {
        System.out.println("newApplication");
        String name = "Veiga";
        int tin = 123456789;
        int tel = 123456789;
        String email = "abc@abs.pt";
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        PostalAddress postAd = new PostalAddress("Porto", company.getPostalCodeRecords().getPostalCodeByPos(0), "Porto");
        ApplicationRecords instance = new ApplicationRecords();
        Application expResult = new Application(name, tin, tel, email, postAd);
        Application result = instance.newApplication(name, tin, tel, email, postAd);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateAplication method, of class ApplicationRecords.
     */
    @Test
    public void testValidateAplication() throws FileNotFoundException {
        System.out.println("validateAplication");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application appl = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        ApplicationRecords instance = new ApplicationRecords();
        boolean expResult = true;
        boolean result = instance.validateAplication(appl);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateAplication2() throws FileNotFoundException {
        System.out.println("validateAplication");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application appl = new Application("", 123456789, 123456789, "", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        ApplicationRecords instance = new ApplicationRecords();
        boolean expResult = false;
        boolean result = instance.validateAplication(appl);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateAplication3() throws FileNotFoundException {
        System.out.println("validateAplication");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application appl = new Application("Veiga", 1, 1, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        ApplicationRecords instance = new ApplicationRecords();
        boolean expResult = false;
        boolean result = instance.validateAplication(appl);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerApplication method, of class ApplicationRecords.
     */
    @Test
    public void testRegisterApplication() {
        System.out.println("registerApplication");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application appl = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        ApplicationRecords instance = new ApplicationRecords();
        boolean expResult = true;
        boolean result = instance.registerApplication(appl);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterApplication2() throws FileNotFoundException {
        System.out.println("registerApplication");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application appl = new Application("", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        ApplicationRecords instance = new ApplicationRecords();
        boolean expResult = false;
        boolean result = instance.registerApplication(appl);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAplication method, of class ApplicationRecords.
     */
    @Test
    public void testAddAplication() throws FileNotFoundException {
        System.out.println("addAplication");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application appl = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        ApplicationRecords instance = new ApplicationRecords();
        boolean expResult = true;
        boolean result = instance.addAplication(appl);
        assertEquals(expResult, result);
    }

    /**
     * Test of getApplicationByTIN method, of class ApplicationRecords.
     */
    @Test
    public void testGetApplicationByTIN() {
        System.out.println("getApplicationByTIN");
        int tin = 123456789;
        ApplicationRecords instance = new ApplicationRecords();
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application expResult = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        instance.addAplication(expResult);
        Application result = instance.getApplicationByTIN(tin);
        assertEquals(expResult, result);
    }

}
