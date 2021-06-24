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
public class AcademicHabilitationTest {

    public AcademicHabilitationTest() {
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
     * Test of getDescription method, of class AcademicHabilitation.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        AcademicHabilitation instance = new AcademicHabilitation("Midle School");
        String expResult = "Midle School";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

}
