/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;
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
public class CategoryRecordsTest {
    
    public CategoryRecordsTest() {
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
     * Test of getCategoryList method, of class CategoryRecords.
     */
    @Test
    public void testGetCategoryList() {
        System.out.println("getCategoryList");
        CategoryRecords instance = new CategoryRecords();
        Category y = new Category("cat1", "limpeza");
        instance.addCategory(y);
        List<Category> expResult = new ArrayList<>();
        expResult.add(y);
        expResult.toString();
        List<Category> result = instance.getCategoryList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoryById method, of class CategoryRecords.
     */
    @Test
    public void testGetCategoryById() {
        System.out.println("getCategoryById");
        String strId = "cat1";
        CategoryRecords instance = new CategoryRecords();
        Category y = new Category("cat1", "limpeza");
        instance.addCategory(y);
        Category expected = new Category("cat1", "limpeza");
        Category expResult = expected;
        Category result = instance.getCategoryById(strId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCategoryById2() {
        System.out.println("getCategoryById");
        String strId = "cat1";
        CategoryRecords instance = new CategoryRecords();
        Category expResult = null;
        Category result = instance.getCategoryById(strId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCategoryById3() {
        System.out.println("getCategoryById");
        String strId = "cat2";
        CategoryRecords instance = new CategoryRecords();
        Category y = new Category("cat1", "limpeza");
        instance.addCategory(y);
        Category expected = new Category("cat1", "limpeza");
        Category expResult = null;
        Category result = instance.getCategoryById(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of newCategory method, of class CategoryRecords.
     */
    @Test
    public void testNewCategory() {
        System.out.println("newCategory");
        String strID = "cat2";
        String strDescription = "reparar";
        CategoryRecords instance = new CategoryRecords();
        Category expResult = new Category("cat2", "reparar");
        Category result = instance.newCategory(strID, strDescription);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerCategory method, of class CategoryRecords.
     */
    @Test
    public void testRegisterCategory() {
        System.out.println("registerCategory");
        Category category = new Category("cat1", "limpar");
        CategoryRecords instance = new CategoryRecords();
        boolean expResult = true;
        boolean result = instance.registerCategory(category);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterCategory2() {
        System.out.println("registerCategory");
        Category category = new Category("cat1", "limpar");
        CategoryRecords instance = new CategoryRecords();
        instance.addCategory(category);
        boolean expResult = false;
        boolean result = instance.registerCategory(category);
        assertEquals(expResult, result);
    }
    

    /**
     * Test of validateCategory method, of class CategoryRecords.
     */
    @Test
    public void testValidateCategory() {
        System.out.println("validateCategory");
        Category category = new Category("cat1", "limpeza");
        CategoryRecords instance = new CategoryRecords();
        boolean expResult = true;
        boolean result = instance.validateCategory(category);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategories method, of class CategoryRecords.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        CategoryRecords instance = new CategoryRecords();
        Category a = new Category("cat1", "limpeza");
        Category b = new Category("cat2", "limp");
        instance.addCategory(a);
        instance.addCategory(b);
        List<Category> expResult = new ArrayList <>();
        expResult.add(a);
        expResult.add(b);
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class CategoryRecords.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        Category category = null;
        CategoryRecords instance = new CategoryRecords();
        boolean expResult = true;
        boolean result = instance.addCategory(category);
        assertEquals(expResult, result);
    }
    
}
