/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.time.LocalTime;
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
public class TimeTest {
    
    public TimeTest() {
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
     * Test of setTime method, of class Time.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        int hour = 0;
        int minutes = 0;
        Time instance = new Time(0,0);
        instance.setTime(hour, minutes);
    }

    /**
     * Test of toString method, of class Time.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Time instance = new Time(0,0);
        String expResult = "00:00";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Time otherTime = new Time(0,0);
        Time instance = new Time(0,0);
        int expResult = 0;
        int result = instance.compareTo(otherTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of isAfter method, of class Time.
     */
    @Test
    public void testIsAfter() {
        System.out.println("isAfter");
        Time otherTime = new Time(1,0);
        Time instance = new Time(0,0);
        boolean expResult = false;
        boolean result = instance.isAfter(otherTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of toSeconds method, of class Time.
     */
    @Test
    public void testToSeconds() {
        System.out.println("toSeconds");
        Time instance = new Time(1,0);
        int expResult = 3600;
        int result = instance.toSeconds();
        assertEquals(expResult, result);
    }

    /**
     * Test of fromSecondsToTime method, of class Time.
     */
    @Test
    public void testFromSecondsToTime() {
        System.out.println("fromSecondsToTime");
        int seconds = 60;
        Time expResult = new Time(0,1);
        Time result = Time.fromSecondsToTime(seconds);
        assertEquals(expResult, result);
    }

    /**
     * Test of currentTime method, of class Time.
     */
    @Test
    public void testCurrentTime() {
        System.out.println("currentTime");
        String[] temp= LocalTime.now().toString().split(":");
        String expResult=temp[0]+":"+temp[1];     
        String result = Time.currentTime().toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddTime() {
        System.out.println("addTime");
        Time time=new Time("12:00");
        Time result=time.addTime(30);
        Time expResult=new Time("12:30");
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddTime2() {
        System.out.println("addTime");
        Time time=new Time("12:00");
        Time result=time.addTime(100);
        Time expResult=new Time("13:40");
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Time.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Time(0,0);
        Time instance = new Time(0,0);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new Time(0,0);
        Time instance = (Time) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = new CategoryRecords();
        Time instance = new Time(0,0);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    
}
