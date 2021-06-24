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
public class ExpandableServiceTest {

    public ExpandableServiceTest() {
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
     * Test of getId method, of class ExpandableService.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        String expResult = "1111";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBriefDesc method, of class ExpandableService.
     */
    @Test
    public void testGetBriefDesc() {
        System.out.println("getBriefDesc");
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        String expResult = "limpeza";
        String result = instance.getBriefDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompDesc method, of class ExpandableService.
     */
    @Test
    public void testGetCompDesc() {
        System.out.println("getCompDesc");
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        String expResult = "aspirar e limpar o pó";
        String result = instance.getCompDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCostHour method, of class ExpandableService.
     */
    @Test
    public void testGetCostHour() {
        System.out.println("getCostHour");
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        double expResult = 5.0;
        double result = instance.getCostHour();
        assertEquals(expResult, result, 0.0);
    }


    /**
     * Test of getCat method, of class ExpandableService.
     */
    @Test
    public void testGetCat() {
        System.out.println("getCat");
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        Category expResult = cat;
        Category result = instance.getCat();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class ExpandableService.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "2222";
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        instance.setId(id);
        assertEquals(instance.getId(), id);
    }

    /**
     * Test of setBriefDesc method, of class ExpandableService.
     */
    @Test
    public void testSetBriefDesc() {
        System.out.println("setBriefDesc");
        String briefDesc = "cozinhar";
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        instance.setBriefDesc(briefDesc);
        String result = instance.getBriefDesc();
        assertEquals(result, briefDesc);
    }

    /**
     * Test of setCompDesc method, of class ExpandableService.
     */
    @Test
    public void testSetCompDesc() {
        System.out.println("setCompDesc");
        String compDesc = "aspirar pouco";
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        instance.setCompDesc(compDesc);
        String result = instance.getCompDesc();
        assertEquals(result, compDesc);

    }

    /**
     * Test of setCostHour method, of class ExpandableService.
     */
    @Test
    public void testSetCostHour() {
        System.out.println("setCostHour");
        double costHour = 13.0;
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        instance.setCostHour(costHour);
        double result = instance.getCostHour();
        assertEquals(result, costHour, 0.0);
    }


    /**
     * Test of setCat method, of class ExpandableService.
     */
    @Test
    public void testSetCat() {
        System.out.println("setCat");
        Category cat = new Category("cat2", "instalar eletrodomesticos");
        Category x = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                x);
        instance.setCat(cat);
        Category result = instance.getCat();
        assertEquals(result, cat);
    }

    /**
     * Test of hasOtherAttributes method, of class ExpandableService.
     */
    @Test
    public void testHasOtherAttributes() {
        System.out.println("hasOtherAttributes");
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        boolean expResult = false;
        boolean result = instance.hasOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOtherAttributes method, of class ExpandableService.
     */
    @Test
    public void testGetOtherAttributes() {
        System.out.println("getOtherAttributes");
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        String expResult = null;
        String result = instance.getOtherAttributes();
        assertEquals(expResult, result);
    }


    /**
     * Test of getCategory method, of class ExpandableService.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        Category expResult = cat;
        Category result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of validates method, of class ExpandableService.
     */
    @Test
    public void testValidates() {
        System.out.println("validates");
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService(null, "limpeza", "aspirar e limpar o pó", 5,
                cat);
        boolean expResult = false;
        boolean result = instance.validates();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCostForDuration method, of class ExpandableService.
     */
    @Test
    public void testGetCostForDuration() {
        System.out.println("getCostForDuration");
        int dur = 60;
        Category cat = new Category("cat1", "limpar");
        ExpandableService instance = new ExpandableService("1111", "limpeza", "aspirar e limpar o pó", 5,
                cat);
        double expResult = 5.0;
        double result = instance.getCostForDuration(dur);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class ExpandableService.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Category cat = new Category("cat2", "reparações");
        ExpandableService instance = new ExpandableService("exp1", "limpeza", "limpar imenso", 8,
                cat);
        String expResult = String.format("Expandable Service: %n Id: %s%n Brief Description: %s%n Complete "
                + "Description: %s%n Category: %s%n", instance.getId(), instance.getBriefDesc(),
                instance.getCompDesc(), instance.getCat().toString());
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdditionalData method, of class ExpandableService.
     */
    @Test
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        int data = 0;
       Category cat = new Category("cat2", "reparações");
        ExpandableService instance = new ExpandableService("exp1", "limpeza", "limpar imenso", 8,
                cat);
        instance.setAdditionalData(data);
    }

    /**
     * Test of equals method, of class ExpandableService.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
       Category cat = new Category("cat2", "reparações");
       Object o = new ExpandableService("exp1", "limpeza", "limpar imenso", 8,
                cat);
        ExpandableService instance = (ExpandableService) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals2() {
        System.out.println("equals");
       Category cat = new Category("cat2", "reparações");
       Object o =new CategoryRecords();
        ExpandableService instance = new ExpandableService("exp1", "limpeza", "limpar imenso", 8,
                cat);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Category cat = new Category("cat2", "reparações");
        Object o = null;
        ExpandableService instance = new ExpandableService("exp1", "limpeza", "limpar imenso", 8,
                cat);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class ExpandableService.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Category cat = new Category("cat1", "limpeza");
        ExpandableService instance = new ExpandableService("exp1", "limpeza", "limpar imenso", 8,
                cat);
        int expResult = 3127893;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUniqueID method, of class ExpandableService.
     */
    @Test
    public void testGetUniqueID() {
        System.out.println("getUniqueID");
        ExpandableService instance = new ExpandableService("exp1", "drgdrg", "ergdrg", 12, new Category("fowerjf", "driughg"));
        String expResult = "exp1";
        String result = instance.getUniqueID();
        assertEquals(expResult, result);
    }


}
