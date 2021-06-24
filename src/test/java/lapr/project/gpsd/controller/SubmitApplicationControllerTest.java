/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.autorization.AuthorizationFacade;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.records.CategoryRecords;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class SubmitApplicationControllerTest {

    public SubmitApplicationControllerTest() {
    }
    
//        @BeforeAll
//    public void dologin() {
//        String postAd = "Porto";
//        String s_postCode = "4000-9";
//        String local = "Paredes";
//        PostalCode pc = new PostalCode(s_postCode);
//        PostalAddress pa = new PostalAddress(postAd,pc,local);
//        Client client = new Client("Name","strTIN", "strPhone","strEmail",pa);
//        AuthorizationFacade m_oAutorization = new AuthorizationFacade();
//        m_oAutorization.registerUser("Name", "Email", "pass");
//        m_oAutorization.doLogin("Email", "pass");
//        System.out.print("Olá");
//    }

    

    /**
     * Test of newApplication method, of class SubmitApplicationController.
     */
    @Test
    public void testNewApplication() {
        System.out.println("newApplication");
        String name = "Alfredo";
        int tin = 123456789;
        int tel = 987654321;
        String email = "1180717@isep.ipp.pt";
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        SubmitApplicationController instance = new SubmitApplicationController();
        boolean expResult = true;
        boolean result = instance.newApplication(name, tin, tel, email, postAd, s_postCode, local);
        assertEquals(expResult, result);
    }
    /**
     * Test of addAcadHabilitation method, of class SubmitApplicationController.
     */
    @Test
    public void testAddAcadHabilitation() {
        System.out.println("addAcadHabilitation");
        String name = "Alfredo";
        int tin = 123456789;
        int tel = 987654321;
        String email = "1180717@isep.ipp.pt";
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        String description = "HighSchool";
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newApplication(name, tin, tel, email, postAd, s_postCode, local);
        boolean expResult = true;
        boolean result = instance.addAcadHabilitation(description);
        assertEquals(expResult, result);

    }

    /**
     * Test of addProfHabilitation method, of class SubmitApplicationController.
     */
    @Test
    public void testAddProfHabilitation() {
        System.out.println("addProfHabilitation");
        String name = "Alfredo";
        int tin = 123456789;
        int tel = 987654321;
        String email = "1180717@isep.ipp.pt";
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        String designation = "TestDesignation";
        int degree = 4;
        String classification = "TestClassification";
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newApplication(name, tin, tel, email, postAd, s_postCode, local);
        boolean expResult = true;
        boolean result = instance.addProfHabilitation(designation, degree, classification);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSupportingDoc method, of class SubmitApplicationController.
     */
    @Test
    public void testAddSupportingDoc() {
        System.out.println("addSupportingDoc");
        String name = "Alfredo";
        int tin = 123456789;
        int tel = 987654321;
        String email = "1180717@isep.ipp.pt";
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        String doc = "docTest";
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newApplication(name, tin, tel, email, postAd, s_postCode, local);
        boolean expResult = true;
        boolean result = instance.addSupportingDoc(doc);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class SubmitApplicationController.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        String name = "Alfredo";
        int tin = 123456789;
        int tel = 987654321;
        String email = "1180717@isep.ipp.pt";
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        Category cat = new Category("100", "clean");
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newApplication(name, tin, tel, email, postAd, s_postCode, local);
        boolean expResult = true;
        boolean result = instance.addCategory(cat);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateApplication method, of class SubmitApplicationController.
     */
    @Test
    public void testValidateApplication() {
        System.out.println("validateApplication");
        String name = "Alfredo";
        int tin = 123456789;
        int tel = 987654321;
        String email = "1180717@isep.ipp.pt";
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newApplication(name, tin, tel, email, postAd, s_postCode, local);
        boolean expResult = true;
        boolean result = instance.validateApplication();
        assertEquals(expResult, result);
    }

    /**
     * Test of registerApplication method, of class SubmitApplicationController.
     */
    @Test
    public void testRegisterApplication() {
        System.out.println("registerApplication");
        String name = "Alfredo";
        int tin = 123456789;
        int tel = 987654321;
        String email = "1180717@isep.ipp.pt";
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newApplication(name, tin, tel, email, postAd, s_postCode, local);
        boolean expResult = true;
        boolean result = instance.registerApplication();
        assertEquals(expResult, result);
    }



}
