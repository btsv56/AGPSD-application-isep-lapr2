/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.Month;
import lapr.project.records.CategoryRecords;
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
public class TimePreferenceTest {
    
    public TimePreferenceTest() {
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
     * Test of getDate method, of class TimePreference.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        TimePreference instance = new TimePreference(0, LocalDate.of(2020, Month.MARCH, 21), new Time("12:00"));
        LocalDate expResult = LocalDate.of(2020, Month.MARCH, 21);
        LocalDate result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHour method, of class TimePreference.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        TimePreference instance =  new TimePreference(0, LocalDate.of(2020, Month.MARCH, 21), new Time("12:00"));
        Time expResult = new Time("12:00");
        Time result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class TimePreference.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new TimePreference(0, LocalDate.of(2020, Month.MARCH, 21), new Time("12:00"));
        TimePreference instance = new TimePreference(0, LocalDate.of(2020, Month.MARCH, 21), new Time("12:00"));
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new TimePreference(0, LocalDate.of(2020, Month.MARCH, 21), new Time("12:00"));
        TimePreference instance =(TimePreference) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = new CategoryRecords();
        TimePreference instance = new TimePreference(0, LocalDate.of(2020, Month.MARCH, 21), new Time("12:00"));
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals4() {
        System.out.println("equals");
        Object o = new TimePreference(0, LocalDate.of(2020, Month.MARCH, 21), new Time("12:00"));
        TimePreference instance = new TimePreference(1, LocalDate.of(2021, Month.MARCH, 22), new Time("13:00"));
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class TimePreference.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TimePreference instance = new TimePreference(0, LocalDate.of(2020, Month.MARCH, 21), new Time("12:00"));
        String expResult = "0 - 2020-03-21 - 12:00";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class TimePreference.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Availability avail = new Availability(LocalDate.of(2020, Month.MARCH, 2), new Time("12:00"), LocalDate.of(2021, Month.MARCH, 3), new Time("13:00"), "Monday");
        TimePreference instance = new TimePreference(0, LocalDate.of(2020, Month.MARCH, 2), new Time("12:30"));;
        int expResult = 1;
        int result = instance.compareTo(avail);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCompareTo2() {
        System.out.println("compareTo");
        Availability avail = new Availability(LocalDate.of(2020, Month.MARCH, 2), new Time("12:00"), LocalDate.of(2021, Month.MARCH, 3), new Time("13:00"), "Monday");
        TimePreference instance = new TimePreference(0, LocalDate.of(2022, Month.MARCH, 2), new Time("12:30"));;
        int expResult = 0;
        int result = instance.compareTo(avail);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCompareTo3() {
        System.out.println("compareTo");
        Availability avail = new Availability(LocalDate.of(2020, Month.MARCH, 2), new Time("12:00"), LocalDate.of(2020, Month.MARCH, 3), new Time("13:00"), "Monday");
        TimePreference instance = new TimePreference(0, LocalDate.of(2020, Month.MARCH, 4), new Time("13:30"));;
        int expResult = 0;
        int result = instance.compareTo(avail);
        assertEquals(expResult, result);
    }
    
}
