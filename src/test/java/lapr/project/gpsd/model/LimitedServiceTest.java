/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import lapr.project.records.CategoryRecords;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marta
 */
public class LimitedServiceTest {

    public LimitedServiceTest() {
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
     * Test of getId method, of class LimitedService.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        String expResult = "lim1";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBriefDesc method, of class LimitedService.
     */
    @Test
    public void testGetBriefDesc() {
        System.out.println("getBriefDesc");
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        String expResult = "limpeza";
        String result = instance.getBriefDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompDesc method, of class LimitedService.
     */
    @Test
    public void testGetCompDesc() {
        System.out.println("getCompDesc");
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        String expResult = "limpar imenso";
        String result = instance.getCompDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCostHour method, of class LimitedService.
     */
    @Test
    public void testGetCostHour() {
        System.out.println("getCostHour");
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        double expResult = 8.0;
        double result = instance.getCostHour();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getCat method, of class LimitedService.
     */
    @Test
    public void testGetCat() {
        System.out.println("getCat");
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        Category expResult = cat;
        Category result = instance.getCat();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class LimitedService.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "lim3";
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        instance.setId(id);
        String result = instance.getId();
        assertEquals(result, id);
    }

    /**
     * Test of setBriefDesc method, of class LimitedService.
     */
    @Test
    public void testSetBriefDesc() {
        System.out.println("setBriefDesc");
        String briefDesc = "clean";
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        instance.setBriefDesc(briefDesc);
        String result = instance.getBriefDesc();
        assertEquals(result, briefDesc);

    }

    /**
     * Test of setCompDesc method, of class LimitedService.
     */
    @Test
    public void testSetCompDesc() {
        System.out.println("setCompDesc");
        String compDesc = "clean a lot";
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        instance.setCompDesc(compDesc);
        String result = instance.getCompDesc();
        assertEquals(result, compDesc);
    }

    /**
     * Test of setCostHour method, of class LimitedService.
     */
    @Test
    public void testSetCostHour() {
        System.out.println("setCostHour");
        double costHour = 5.0;
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        instance.setCostHour(costHour);
        double result = instance.getCostHour();
        assertEquals(result, costHour, 0.0);
    }

    /**
     * Test of setCat method, of class LimitedService.
     */
    @Test
    public void testSetCat() {
        System.out.println("setCat");
        Category cat = null;
        Category x = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                x);
        instance.setCat(cat);
        Category result = instance.getCat();
        assertEquals(result, cat);
    }

    /**
     * Test of hasOtherAttributes method, of class LimitedService.
     */
    @Test
    public void testHasOtherAttributes() {
        System.out.println("hasOtherAttributes");
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        boolean expResult = false;
        boolean result = instance.hasOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOtherAttributes method, of class LimitedService.
     */
    @Test
    public void testGetOtherAttributes() {
        System.out.println("getOtherAttributes");
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        String expResult = null;
        String result = instance.getOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategory method, of class LimitedService.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        Category expResult = cat;
        Category result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of validates method, of class LimitedService.
     */
    @Test
    public void testValidates() {
        System.out.println("validates");
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService(null, "limpeza", "limpar imenso", 8,
                cat);
        boolean expResult = false;
        boolean result = instance.validates();
        assertEquals(expResult, result);
    }

    /**
     * Test of validates method, of class LimitedService.
     */
    @Test
    public void testValidates2() {
        System.out.println("validates2");
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("asdfgh", null, "limpar imenso", 8,
                cat);
        boolean expResult = false;
        boolean result = instance.validates();
        assertEquals(expResult, result);
    }

    /**
     * Test of validates method, of class LimitedService.
     */
    @Test
    public void testValidates3() {
        System.out.println("validates3");
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("sdfer", "limpeza", null, 8,
                cat);
        boolean expResult = false;
        boolean result = instance.validates();
        assertEquals(expResult, result);
    }

    /**
     * Test of validates method, of class LimitedService.
     */
    @Test
    public void testValidates4() {
        System.out.println("validates4");
        LimitedService instance = new LimitedService("sdfer", "limpeza", "wefrg", 8,
                null);
        boolean expResult = false;
        boolean result = instance.validates();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCostForDuration method, of class LimitedService.
     */
    @Test
    public void testGetCostForDuration() {
        System.out.println("getCostForDuration");
        int dur = 60;
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        double expResult = 8.0;
        double result = instance.getCostForDuration(dur);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class LimitedService.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        String expResult = String.format("Limited Service: %n Id: %s%n Brief Description: %s%n Complete "
                + "Description: %s%n Category: %s%n", instance.getId(), instance.getBriefDesc(),
                instance.getCompDesc(), instance.getCat().toString());
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdditionalData method, of class LimitedService.
     */
    @Test
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        int data = 2;
        Category cat = new Category("cat2", "reparações");
        LimitedService instance = new LimitedService("lim1", "limpeza", "limpar imenso", 8,
                cat);
        instance.setAdditionalData(data);
    }

    /**
     * Test of equals method, of class LimitedService.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new LimitedService("id", "desc", "desc", 1, new Category("id", "desc"));
        LimitedService instance = new LimitedService("id", "desc", "desc", 1, new Category("id", "desc"));
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new LimitedService("id", "desc", "desc", 1, new Category("id", "desc"));
        LimitedService instance = (LimitedService) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = new LimitedService("id", "desc", "desc", 1, new Category("id", "desc"));
        LimitedService instance = new LimitedService("id1", "desc1", "desc1", 2, new Category("id1", "desc1"));
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals4() {
        System.out.println("equals");
        Object o = new CategoryRecords();
        LimitedService instance = new LimitedService("id", "desc", "desc", 1, new Category("id", "desc"));
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals5() {
        System.out.println("equals5");
        Object o = null;
        LimitedService instance = new LimitedService("id", "desc", "desc", 1, new Category("id", "desc"));
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class LimitedService.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        LimitedService instance = new LimitedService("id", "desc", "desc", 1, new Category("id", "desc"));
        int expResult = 3516;
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUniqueID method, of class LimitedService.
     */
    @Test
    public void testGetUniqueID() {
        System.out.println("getUniqueID");
        Category cat = new Category("sef", "drgdrg");
        LimitedService instance = new LimitedService("lim1", "drdrg", "srfrg", 12, cat);
        String expResult = "lim1";
        String result = instance.getUniqueID();
        assertEquals(expResult, result);
    }

}
