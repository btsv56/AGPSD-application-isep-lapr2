/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import lapr.project.gpsd.controller.AppGPSD;
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
public class ApplicationTest {

    public ApplicationTest() {
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
     * Test of getName method, of class Application.
     */
    @Test
    public void testGetName() throws FileNotFoundException {
        System.out.println("getName");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application instance = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        String expResult = "Veiga";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTin method, of class Application.
     */
    @Test
    public void testGetTin() throws FileNotFoundException {
        System.out.println("getTin");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application instance = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        int expResult = 123456789;
        int result = instance.getTin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTel method, of class Application.
     */
    @Test
    public void testGetTel() throws FileNotFoundException {
        System.out.println("getTel");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application instance = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        int expResult = 123456789;
        int result = instance.getTel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Application.
     */
    @Test
    public void testGetEmail() throws FileNotFoundException {
        System.out.println("getEmail");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application instance = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        String expResult = "abc@abs.pt";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of newPostalAddress method, of class Application.
     */
    @Test
    public void testNewPostalAddress() throws FileNotFoundException {
        System.out.println("newPostalAddress");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        String strAdress = "Rua do Porto";
        PostalCode strPostalCode = company.getPostalCodeRecords().getPostalCodeByPos(0);
        String strLocal = "Porto";
        Application instance = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        PostalAddress expResult = new PostalAddress(strAdress, strPostalCode, strLocal);
        PostalAddress result = instance.newPostalAddress(strAdress, strPostalCode, strLocal);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAcadHabilitation method, of class Application.
     */
    @Test
    public void testAddAcadHabilitation() throws FileNotFoundException {
        System.out.println("addAcadHabilitation");
        String description = "Middle school";
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application instance = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        boolean expResult = true;
        boolean result = instance.addAcadHabilitation(description);
        assertEquals(expResult, result);
    }

    /**
     * Test of addProfHabilitation method, of class Application.
     */
    @Test
    public void testAddProfHabilitation() throws FileNotFoundException {
        System.out.println("addProfHabilitation");
        String designation = "3 years experience";
        int degree = 18;
        String classification = "Very good";
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application instance = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        boolean expResult = true;
        boolean result = instance.addProfHabilitation(designation, degree, classification);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSupportingDoc method, of class Application.
     */
    @Test
    public void testAddSupportingDoc() throws FileNotFoundException {
        System.out.println("addSupportingDoc");
        String doc = "Doc";
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application instance = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        boolean expResult = true;
        boolean result = instance.addSupportingDoc(doc);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class Application.
     */
    @Test
    public void testAddCategory() throws FileNotFoundException {
        System.out.println("addCategory");
        Category cat = new Category("cat1", "limpeza");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application instance = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        boolean expResult = true;
        boolean result = instance.addCategory(cat);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasTIN method, of class Application.
     */
    @Test
    public void testHasTIN() throws FileNotFoundException {
        System.out.println("hasTIN");
        int otherTin = 123456789;
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Application instance = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        boolean expResult = true;
        boolean result = instance.hasTIN(otherTin);
        assertEquals(expResult, result);
    }

    /**
     * Test of addPostAdress method, of class Application.
     */
    @Test
    public void testAddPostAdress() throws FileNotFoundException {
        System.out.println("addPostAdress");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        PostalAddress pa = new PostalAddress("Porto", company.getPostalCodeRecords().getPostalCodeByPos(1), "Porto");
        Application instance = new Application("Veiga", 123456789, 123456789, "abc@abs.pt", new PostalAddress("dsads", company.getPostalCodeRecords().getPostalCodeByPos(0), "local"));
        boolean expResult = true;
        boolean result = instance.addPostAdress(pa);
        assertEquals(expResult, result);
    }

}
