/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

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
public class SupportingDocumentTest {
    
    public SupportingDocumentTest() {
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
     * Test of getDoc method, of class SupportingDocument.
     */
    @Test
    public void testGetDoc() {
        System.out.println("getDoc");
        SupportingDocument instance = new SupportingDocument("Doc");
        String expResult = "Doc";
        String result = instance.getDoc();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDoc method, of class SupportingDocument.
     */
    @Test
    public void testSetDoc() {
        System.out.println("setDoc");
        String doc = "doc";
        SupportingDocument instance = new SupportingDocument(doc);
        instance.setDoc(doc);
    }
    
}
