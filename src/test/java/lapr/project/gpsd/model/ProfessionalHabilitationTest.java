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
public class ProfessionalHabilitationTest {
    
    public ProfessionalHabilitationTest() {
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
     * Test of getDesignation method, of class ProfessionalHabilitation.
     */
    @Test
    public void testGetDesignation() {
        System.out.println("getDesignation");
        ProfessionalHabilitation instance = new ProfessionalHabilitation("3 years experience", 3, "18");
        String expResult = "3 years experience";
        String result = instance.getDesignation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDegree method, of class ProfessionalHabilitation.
     */
    @Test
    public void testGetDegree() {
        System.out.println("getDegree");
        ProfessionalHabilitation instance = new ProfessionalHabilitation("3 years experience", 3, "18");;
        int expResult = 3;
        int result = instance.getDegree();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClassification method, of class ProfessionalHabilitation.
     */
    @Test
    public void testGetClassification() {
        System.out.println("getClassification");
        ProfessionalHabilitation instance = new ProfessionalHabilitation("3 years experience", 3, "18");;
        String expResult = "18";
        String result = instance.getClassification();
        assertEquals(expResult, result);
    }
    
}
