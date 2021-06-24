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
public class PostalAddressTest {

    public PostalAddressTest() {
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
     * Test of getM_address method, of class PostalAddress.
     */
    @Test
    public void testGetM_address() throws FileNotFoundException {
        System.out.println("getM_address");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        PostalAddress instance = new PostalAddress("Aliados", company.getPostalCodeRecords().getPostalCodeByPos(0), "Porto");
        String expResult = "Aliados";
        String result = instance.getM_address();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_local method, of class PostalAddress.
     */
    @Test
    public void testGetM_local() throws FileNotFoundException {
        System.out.println("getM_local");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        PostalAddress instance = new PostalAddress("Aliados", company.getPostalCodeRecords().getPostalCodeByPos(0), "Porto");
        String expResult = "Porto";
        String result = instance.getM_local();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostalCode method, of class PostalAddress.
     */
    @Test
    public void testGetPostalCode() throws FileNotFoundException {
        System.out.println("getPostalCode");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        PostalAddress instance = new PostalAddress("Aliados", company.getPostalCodeRecords().getPostalCodeByPos(0), "Porto");
        PostalCode expResult = company.getPostalCodeRecords().getPostalCodeByPos(0);
        PostalCode result = instance.getPostalCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class PostalAddress.
     */
    @Test
    public void testEquals() throws FileNotFoundException {
        System.out.println("equals");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Object o = new PostalAddress("Aliados", company.getPostalCodeRecords().getPostalCodeByPos(0), "Porto");
        PostalAddress instance = new PostalAddress("Aliados", company.getPostalCodeRecords().getPostalCodeByPos(0), "Porto");
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals2() throws FileNotFoundException {
        System.out.println("equals");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Object o = new PostalAddress("Aliados", company.getPostalCodeRecords().getPostalCodeByPos(0), "Porto");
        PostalAddress instance = (PostalAddress) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class PostalAddress.
     */
    @Test
    public void testToString() throws FileNotFoundException {
        System.out.println("toString");
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        Instanciate.readPostalCodes("4000-7");
        PostalAddress instance = new PostalAddress("Aliados", new PostalCode("4000-7"), "Porto");
        String expResult = "Aliados \n"
                + " 4000-7, 41.1469459, -8.6064074 - Porto";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
