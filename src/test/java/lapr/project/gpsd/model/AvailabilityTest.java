/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.Month;
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
public class AvailabilityTest {
    
    public AvailabilityTest() {
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
     * Test of getInitialDate method, of class Availability.
     */
    @Test
    public void testGetInitialDate() {
        System.out.println("getInitialDate");
        Availability instance = new Availability(LocalDate.of(2019, Month.MARCH, 23),new Time(12,00),LocalDate.of(2020, Month.MARCH, 1),new Time(13,00),"");
        LocalDate expResult =LocalDate.of(2019, Month.MARCH, 23) ;
        LocalDate result = instance.getInitialDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInitialHour method, of class Availability.
     */
    @Test
    public void testGetInitialHour() {
        System.out.println("getInitialHour");
        Availability instance = new Availability(LocalDate.of(2019, Month.MARCH, 23),new Time(12,00),LocalDate.of(2020, Month.MARCH, 1),new Time(13,00),"");
        Time expResult = new Time(12,00);
        Time result = instance.getInitialHour();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFinalDate method, of class Availability.
     */
    @Test
    public void testGetFinalDate() {
        System.out.println("getFinalDate");
        Availability instance = new Availability(LocalDate.of(2019, Month.MARCH, 23),new Time(12,00),LocalDate.of(2020, Month.MARCH, 1),new Time(13,00),"");
        LocalDate expResult =LocalDate.of(2020, Month.MARCH, 1) ;
        LocalDate result = instance.getFinalDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFinalHour method, of class Availability.
     */
    @Test
    public void testGetFinalHour() {
        System.out.println("getFinalHour");
        Availability instance = new Availability(LocalDate.of(2019, Month.MARCH, 23),new Time(12,00),LocalDate.of(2020, Month.MARCH, 1),new Time(13,00),"");
        Time expResult = new Time(13,00);
        Time result = instance.getFinalHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPeriod method, of class Availability.
     */
    @Test
    public void testGetPeriod() {
        System.out.println("getPeriod");
        Availability instance = new Availability(LocalDate.of(2019, Month.MARCH, 23),new Time(12,00),LocalDate.of(2020, Month.MARCH, 1),new Time(13,00),"Everyday");
        String expResult = "Everyday";
        String result = instance.getPeriod();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Availability.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Availability(LocalDate.of(2019, Month.MARCH, 23),new Time(12,00),LocalDate.of(2020, Month.MARCH, 1),new Time(13,00),"");
        Availability instance = new Availability(LocalDate.of(2019, Month.MARCH, 23),new Time(12,00),LocalDate.of(2020, Month.MARCH, 1),new Time(13,00),"");
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class Availability.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Availability instance = new Availability(LocalDate.of(2019, Month.MARCH, 23),new Time(12,00),LocalDate.of(2020, Month.MARCH, 1),new Time(13,00),"");
        String expResult = "Date (initial/final): 2019-03-23 - 2020-03-01Time (initial/final):12:00-13:00";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
