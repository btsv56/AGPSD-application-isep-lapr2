/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.records.PostalCodeRecords;
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
public class ClientTest {
    
    public ClientTest() {
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
     * Test of getPostalAddresses method, of class Client.
     */
    @Test
    public void testGetPostalAddresses() {
        System.out.println("getPostalAddresses");
        Client instance = new Client("Veiga", "123456789", "123456789", "abc@abs.pt");
        List<PostalAddress> expResult = new ArrayList<>();
        List<PostalAddress> result = instance.getPostalAddresses();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Client.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Client instance = new Client("Veiga", "123456789", "123456789", "abc@abs.pt");
        String expResult = "Veiga";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Client.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Client instance = new Client("Veiga", "123456789", "123456789", "abc@abs.pt");
        String expResult = "abc@abs.pt";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasEmail method, of class Client.
     */
    @Test
    public void testHasEmail() {
        System.out.println("hasEmail");
        String strEmail = "abc@abs.pt";
        Client instance = new Client("Veiga", "123456789", "123456789", "abc@abs.pt");;
        boolean expResult = true;
        boolean result = instance.hasEmail(strEmail);
        assertEquals(expResult, result);
    }

    /**
     * Test of addPostalAddress method, of class Client.
     */
    @Test
    public void testAddPostalAddress() throws FileNotFoundException {
        System.out.println("addPostalAddress");
        AppGPSD app= AppGPSD.getInstance();
        Company company = app.getCompany();
        PostalAddress oAddress = new PostalAddress("Porto", company.getPostalCodeRecords().getPostalCodeByPos(0), "Porto");
        Client instance = new Client("Veiga", "123456789", "123456789", "abc@abs.pt");
        boolean expResult = true;
        boolean result = instance.addPostalAddress(oAddress);
        assertEquals(expResult, result);
    }

    /**
     * Test of removePostalAddress method, of class Client.
     */
    @Test
    public void testRemovePostalAddress() throws FileNotFoundException {
        System.out.println("removePostalAddress");
        AppGPSD app= AppGPSD.getInstance();
        Company company = app.getCompany();
        PostalAddress oAddress = new PostalAddress("Porto", company.getPostalCodeRecords().getPostalCodeByPos(0), "Porto");
        Client instance = new Client("Veiga", "123456789", "123456789", "abc@abs.pt");
        instance.addAddress(oAddress);
        boolean expResult = true;
        boolean result = instance.removePostalAddress(oAddress);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Client.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Client("Veiga", "123456789", "123456789", "abc@abs.pt");
        Client instance = new Client("Veiga", "123456789", "123456789", "abc@abs.pt");
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new Client("Veiga", "123456789", "123456789", "abc@abs.pt");
        Client instance = (Client) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Client.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Client instance = new Client("Veiga", "123456789", "123456789", "abc@abs.pt");
        String expResult = "Veiga - 123456789 - 123456789 - abc@abs.pt";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of newPostalAddress method, of class Client.
     */
    @Test
    public void testNewPostalAddress_3args_1() throws FileNotFoundException {
        System.out.println("newPostalAddress");
        String address = "Porto";
        AppGPSD app= AppGPSD.getInstance();
        Company company = app.getCompany();
        PostalCode strPostalCode =  company.getPostalCodeRecords().getPostalCodeByPos(0);
        String local = "Porto";
        PostalAddress expResult = new PostalAddress(address, strPostalCode, local);
        PostalAddress result = Client.newPostalAddress(address, strPostalCode, local);
        assertEquals(expResult, result);
    }

    /**
     * Test of newPostalAddress method, of class Client.
     */
    @Test
    public void testNewPostalAddress_3args_2() throws FileNotFoundException {
        System.out.println("newPostalAddress");
        String address = "Porto";
        String strPostalCode = "4000-9";
        String local = "Porto";
         AppGPSD app= AppGPSD.getInstance();
        Company company = app.getCompany();
        Instanciate.readPostalCodes("4000-9");
        Client instance = new Client("Veiga", "123456789", "123456789", "abc@abs.pt");
        PostalAddress expResult = new PostalAddress(address,new PostalCode(strPostalCode) , local);
        PostalAddress result = instance.newPostalAddress(address, strPostalCode, local);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAddress method, of class Client.
     */
    @Test
    public void testAddAddress() throws FileNotFoundException {
        System.out.println("addAddress");
        AppGPSD app=AppGPSD.getInstance();
        Company company= app.getCompany();
        PostalAddress ad1 = new PostalAddress("Porto", company.getPostalCodeRecords().getPostalCodeByPos(0), "Porto");
        Client instance = new Client("Veiga", "123456789", "123456789", "abc@abs.pt");
        boolean expResult = true;
        boolean result = instance.addAddress(ad1);
        assertEquals(expResult, result);
    }
    
}
