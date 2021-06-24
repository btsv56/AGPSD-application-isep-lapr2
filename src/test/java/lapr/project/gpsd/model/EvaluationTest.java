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
 * @author pedro
 */
public class EvaluationTest {

    public EvaluationTest() {
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
     * Test of getMeanRating method, of class Evaluation.
     */
    @Test
    public void testGetMeanRating() {
        System.out.println("getMeanRating");
        Evaluation instance = new Evaluation("Worst", 4.2);
        double expResult = 4.2;
        double result = instance.getMeanRating();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getEvaluation method, of class Evaluation.
     */
    @Test
    public void testGetEvaluation() {
        System.out.println("getEvaluation");
        Evaluation instance = new Evaluation("Worst", 4.2);
        String expResult = "Worst";
        String result = instance.getEvaluation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEvaluation method, of class Evaluation.
     */
    @Test
    public void testSetEvaluation() {
        System.out.println("setEvaluation");
        String evaluation = "Outstanding";
        Evaluation instance = new Evaluation("Worst", 4.2);
        boolean result = instance.setEvaluation(evaluation);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of setMeanRating method, of class Evaluation.
     */
    @Test
    public void testSetMeanRating() {
        System.out.println("setMeanRating");
        double meanRating = 3.2;
        Evaluation instance = new Evaluation("Worst", 4.2);
        boolean result = instance.setMeanRating(meanRating);
        boolean expResult = true;
        assertEquals(expResult, result);

    }
}
