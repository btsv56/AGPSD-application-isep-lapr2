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
 * @author Asus
 */
public class ServiceScheduleTest {
    
    public ServiceScheduleTest() {
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
     * Test of getDate method, of class ServiceSchedule.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Time time = new Time(10,0);
        ServiceSchedule instance =new ServiceSchedule("Accepted", LocalDate.of(2020, Month.MARCH, 2), time);
        LocalDate expResult = LocalDate.of(2020, Month.MARCH, 2);
        LocalDate result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHour method, of class ServiceSchedule.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        Time time = new Time(10,0);
        ServiceSchedule instance = new ServiceSchedule("Accepted", LocalDate.of(2020, Month.MARCH, 2), time);
        Time expResult = time;
        Time result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ServiceSchedule.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Time time = new Time(10,0);
        ServiceSchedule instance = new ServiceSchedule("Accepted", LocalDate.of(2020, Month.MARCH, 2), time);
        String expResult = "State: Accepted Date: 2020-03-02 Hour: 10:00";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of setStateSchedule method, of class ServiceSchedule.
//     */
//    @org.junit.Test
//    public void testSetStateSchedule() {
//        System.out.println("setStateSchedule");
//        String stateImp = "Accepted";
//        Time time = new Time(10,0);
//        ServiceSchedule instance = new ServiceSchedule(null, LocalDate.of(2020, Month.MARCH, 2), time);
//        instance.setStateSchedule(stateImp);
//        String expResult = "Accepted";
//    }

    
}
