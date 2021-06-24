/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

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
public class SpecifyCategoryControllerTest {
    
    public SpecifyCategoryControllerTest() {
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

//    /**
//     * Test of newCategory method, of class SpecifyCategoryController.
//     */
//    @Test
//    public void testNewCategory() {
//        System.out.println("newCategory");
//        AppGPSD app= AppGPSD.getInstance();
//        app.doLogin("adm1@esoft.pt", "123456");
//        String strCodigo = "cat";
//        String strDescricao = "category";
//        SpecifyCategoryController instance = new SpecifyCategoryController();
//        boolean expResult = true;
//        boolean result = instance.newCategory(strCodigo, strDescricao);
//        assertEquals(expResult, result);
//        app.doLogout();
//    }

//    /**
//     * Test of registerCategory method, of class SpecifyCategoryController.
//     */
//    @Test
//    public void testRegisterCategory() {
//        System.out.println("registerCategory");
//        AppGPSD app= AppGPSD.getInstance();
//        app.doLogin("adm1@esoft.pt", "123456");
//        String strCodigo = "cat";
//        String strDescricao = "category";
//        SpecifyCategoryController instance = new SpecifyCategoryController();
//        instance.newCategory(strCodigo, strDescricao);
//        boolean expResult = true;
//        boolean result = instance.registerCategory();
//        assertEquals(expResult, result);
//    }
//
    /**
     * Test of getCategoryString method, of class SpecifyCategoryController.
     */
    @Test
    public void testGetCategoryString() {
        System.out.println("getCategoryString");
        AppGPSD app= AppGPSD.getInstance();
        app.doLogin("adm1@esoft.pt", "123456");
        String strCodigo = "cat";
        String strDescricao = "category";
        SpecifyCategoryController instance = new SpecifyCategoryController();
        instance.newCategory(strCodigo, strDescricao);
        String expResult = "cat - category ";
        String result = instance.getCategoryString();
        assertEquals(expResult, result);
    }
    
}
