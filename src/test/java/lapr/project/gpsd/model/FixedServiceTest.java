/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import lapr.project.records.CategoryRecords;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Categories;

/**
 *
 * @author marta
 */
public class FixedServiceTest {

    public FixedServiceTest() {
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

    /**
     * Test of getId method, of class FixedService.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Category cat = new Category("cat1", "limpar");
        FixedService instance = new FixedService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        String expResult = "1111";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBriefDesc method, of class FixedService.
     */
    @Test
    public void testGetBriefDesc() {
        System.out.println("getBriefDesc");
        Category cat = new Category("cat1", "limpar");
        FixedService instance = new FixedService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        String expResult = "limpeza";
        String result = instance.getBriefDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompDesc method, of class FixedService.
     */
    @Test
    public void testGetCompDesc() {
        System.out.println("getCompDesc");
        Category cat = new Category("cat1", "limpar");
        FixedService instance = new FixedService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        String expResult = "aspirar e limpar o pó";
        String result = instance.getCompDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCostHour method, of class FixedService.
     */
    @Test
    public void testGetCostHour() {
        System.out.println("getCostHour");
        Category cat = new Category("cat1", "limpar");
        FixedService instance = new FixedService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        double expResult = 5.0;
        double result = instance.getCostHour();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCat method, of class FixedService.
     */
    @Test
    public void testGetCat() {
        System.out.println("getCat");
        Category cat = new Category("cat1", "limpar");
        FixedService instance = new FixedService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        Category expResult = cat;
        Category result = instance.getCat();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasOtherAttributes method, of class FixedService.
     */
    @Test
    public void testHasOtherAttributes() {
        System.out.println("hasOtherAttributes");
        Category cat = new Category("cat1", "limpar");
        FixedService instance = new FixedService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        boolean expResult = true;
        boolean result = instance.hasOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOtherAttributes method, of class FixedService.
     */
    @Test
    public void testGetOtherAttributes() {
        System.out.println("getOtherAttributes");
        Category cat = new Category("cat1", "limpar");
        FixedService instance = new FixedService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        String expResult = "Pre-Determined Duration";
        String result = instance.getOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdditionalData method, of class FixedService.
     */
    @Test
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        int data = 30;
        Category cat = new Category("cat1", "limpar");
        FixedService instance = new FixedService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        instance.setAdditionalData(data);
        int result = instance.getPreDeterminedDuration();
        int expResult = 30;
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategory method, of class FixedService.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Category cat = new Category("cat1", "limpar");
        FixedService instance = new FixedService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        Category expResult = cat;
        Category result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of validates method, of class FixedService.
     */
    @Test
    public void testValidates() {
        System.out.println("validates");
        Category cat = new Category("cat1", "limpar");
        FixedService instance = new FixedService(null, "limpeza", "aspirar e limpar o pó", 5,
                cat);
        boolean expResult = false;
        boolean result = instance.validates();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCostForDuration method, of class FixedService.
     */
    @Test
    public void testGetCostForDuration() {
        System.out.println("getCostForDuration");
        int dur = 60;
        Category cat = new Category("cat1", "limpar");
        FixedService instance = new FixedService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        double expResult = 5.0;
        double result = instance.getCostForDuration(dur);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class FixedService.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Category cat = new Category("cat2", "reparações");
        FixedService instance = new FixedService("fix1", "limpeza", "limpar imenso", 8,
                cat);
        String expResult = String.format("Fixed Service: %n Id: %s%n Brief Description: %s%n Complete "
                + "Description: %s%n Category: %s%n Pre-Determined Duration: %d%n", instance.getId(), instance.getBriefDesc(),
                instance.getCompDesc(), instance.getCat().toString(), instance.getPreDeterminedDuration());
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPreDeterminedDuration method, of class FixedService.
     */
    @org.junit.Test
    public void testGetPreDeterminedDuration() {
        System.out.println("getPreDeterminedDuration");
        FixedService instance = null;
        int expResult = 0;
        int result = instance.getPreDeterminedDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class FixedService.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        FixedService instance = new FixedService("id", "desc", "desc", 1, new Category("id", "desc"));
        int expResult = 3516;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class FixedService.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new FixedService("id", "desc", "desc", 1, new Category("id", "desc"));
        FixedService instance = new FixedService("id", "desc", "desc", 1, new Category("id", "desc"));
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new FixedService("id", "desc", "desc", 1, new Category("id", "desc"));
        FixedService instance = (FixedService) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = new FixedService("id", "desc", "desc", 1, new Category("id", "desc"));
        FixedService instance = new FixedService("id1", "desc1", "desc1", 2, new Category("id1", "desc1"));
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals4() {
        System.out.println("equals");
        Object o = new CategoryRecords();
        FixedService instance = new FixedService("id", "desc", "desc", 1, new Category("id", "desc"));
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals5() {
        System.out.println("equals5");
        Object o = null;
        FixedService instance = new FixedService("id", "desc", "desc", 1, new Category("id", "desc"));
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUniqueID method, of class FixedService.
     */
    @Test
    public void testGetUniqueID() {
        System.out.println("getUniqueID");
        FixedService instance = new FixedService("fix1", "rfrg", "ergrg", 12, new Category("ergerg", "ergrg"));
        String expResult = "fix1";
        String result = instance.getUniqueID();
        assertEquals(expResult, result);
    }

}
