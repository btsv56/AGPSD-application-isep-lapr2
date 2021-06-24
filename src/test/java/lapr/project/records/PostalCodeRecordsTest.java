/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Instanciate;
import lapr.project.gpsd.model.PostalCode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class PostalCodeRecordsTest {

    public PostalCodeRecordsTest() {
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
     * Test of searchPositionPostalCode method, of class PostalCodeRecords.
     */
    @Test
    public void testSearchPositionPostalCode() {
        System.out.println("searchPositionPostalCode");
        String postalCode = "4000-9";
        PostalCodeRecords instance = new PostalCodeRecords();
        int expResult = -1;
        int result = instance.searchPositionPostalCode(postalCode);
        System.out.println(result);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSearchPositionPostalCode2() {
        System.out.println("searchPositionPostalCode");
        String postalCode = "4000-9";
        List<PostalCode> pc = new ArrayList<>();
        pc.add(new PostalCode("4000-9"));
        PostalCodeRecords instance = new PostalCodeRecords(pc);
        int expResult = 0;
        int result = instance.searchPositionPostalCode(postalCode);
        System.out.println(result);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getLatitudeByID method, of class PostalCodeRecords.
     */
    @Test
    public void testGetLatitudeByID() {
        System.out.println("getLatitudeByID");
        String postalCode = "4000-9";
        Instanciate.readPostalCodes(postalCode);
        List<PostalCode> pc = new ArrayList<>();
        pc.add(new PostalCode("4000-9"));
        PostalCodeRecords instance = new PostalCodeRecords(pc);
        double expResult = 41.1555392;
        double result = instance.getLatitudeByID(postalCode);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetLatitudeByID2() {
        System.out.println("getLatitudeByID");
        String postalCode = "4000 008";
        PostalCodeRecords instance = new PostalCodeRecords();
        double expResult = 91.0;
        double result = instance.getLatitudeByID(postalCode);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getLongitudeByID method, of class PostalCodeRecords.
     */
    @Test
    public void testGetLongitudeByID() {
        System.out.println("getLongitudeByID");
        String postalCode = "4000-9";
        Instanciate.readPostalCodes(postalCode);
        List<PostalCode> pc = new ArrayList<>();
        pc.add(new PostalCode("4000-9"));
        PostalCodeRecords instance = new PostalCodeRecords(pc);
        double expResult = -8.6061091;
        double result = instance.getLongitudeByID(postalCode);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetLongitudeByID2() {
        System.out.println("getLongitudeByID");
        String postalCode = "4000 009";
        PostalCodeRecords instance = new PostalCodeRecords();
        double expResult = 181;
        double result = instance.getLongitudeByID(postalCode);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getListSize method, of class PostalCodeRecords.
     */
    @Test
    public void testGetListSize2() {
        System.out.println("getListSize");
        PostalCodeRecords instance = new PostalCodeRecords();
        int expResult = 0;
        int result = instance.getListSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostalCodeByPos method, of class PostalCodeRecords.
     */
    @Test
    public void testGetPostalCodeByPos() {
        System.out.println("getPostalCodeByPos");
        int i = 0;
        List<PostalCode> pc = new ArrayList<>();
        PostalCode expResult = new PostalCode("4000-9");
        pc.add(expResult);
        PostalCodeRecords instance = new PostalCodeRecords(pc);

        PostalCode result = instance.getPostalCodeByPos(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLst method, of class PostalCodeRecords.
     */
    @Test
    public void testGetLst() {
        System.out.println("getLst");
        PostalCodeRecords instance = new PostalCodeRecords();
        List<PostalCode> expResult = new ArrayList<>();
        List<PostalCode> result = instance.getLst();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class PostalCodeRecords.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new PostalCodeRecords();
        PostalCodeRecords instance = new PostalCodeRecords();
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object obj = new PostalCodeRecords();
        PostalCodeRecords instance = (PostalCodeRecords) obj;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object obj = new CategoryRecords();
        PostalCodeRecords instance = new PostalCodeRecords();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

}
