/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import lapr.project.gpsd.model.Availability;
import lapr.project.gpsd.model.Time;
import lapr.project.gpsd.model.TimePreference;
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
public class AvailabilityListTest {
    
    public AvailabilityListTest() {
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
     * Test of newAvailabilityTime method, of class AvailabilityList.
     */
    @Test
    public void testNewAvailabilityTime() {
        System.out.println("newAvailabilityTime");
        LocalDate initialDate = LocalDate.of(2019, Month.MARCH, 1);
        String initialHour = "12:00";
        LocalDate finalDate = LocalDate.of(2020, Month.MARCH, 12);
        String finalHour = "13:00";
        String period = "Monday";
        Time hourI=new Time(initialHour);
        Time hourF=new Time(finalHour);
        AvailabilityList instance = new AvailabilityList();
        Availability expResult = new Availability(initialDate, hourI, finalDate, hourF, period);
        Availability result = instance.newAvailabilityTime(initialDate, initialHour, finalDate, finalHour, period);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerAvailabiityTime method, of class AvailabilityList.
     */
    @Test
    public void testRegisterAvailabiityTime() {
        System.out.println("registerAvailabiityTime");
        LocalDate initialDate = LocalDate.of(2020, Month.MARCH, 1);
        String initialHour = "12:00";
        LocalDate finalDate = LocalDate.of(2021, Month.MARCH, 12);
        String finalHour = "13:00";
        String period = "Monday";
        Time hourI=new Time(initialHour);
        Time hourF=new Time(finalHour);
        Availability aval = new Availability(initialDate, hourI, finalDate, hourF, period);
        AvailabilityList instance = new AvailabilityList();
        boolean expResult = true;
        boolean result = instance.registerAvailabiityTime(aval);
        assertEquals(expResult, result);
    }
    
    

    /**
     * Test of getAvailabilityList method, of class AvailabilityList.
     */
    @Test
    public void testGetAvailabilityList() {
        System.out.println("getAvailabilityList");
        LocalDate initialDate = LocalDate.of(2020, Month.MARCH, 1);
        String initialHour = "12:00";
        LocalDate finalDate = LocalDate.of(2021, Month.MARCH, 12);
        String finalHour = "13:00";
        String period = "Monday";
        Time hourI=new Time(initialHour);
        Time hourF=new Time(finalHour);
        AvailabilityList instance = new AvailabilityList();
        instance.registerAvailabiityTime(new Availability(initialDate, hourI, finalDate, hourF, period));
        ArrayList<Availability> avalList= new ArrayList<>();
        avalList.add(new Availability(initialDate, hourI, finalDate, hourF, period));
        ArrayList<Availability> expResult = avalList;
        ArrayList<Availability> result = instance.getAvailabilityList();
        assertEquals(expResult, result);
    }

    /**
     * Test of addAvailabilityTime method, of class AvailabilityList.
     */
    @Test
    public void testAddAvailabilityTime() {
        System.out.println("addAvailabilityTime");
        LocalDate initialDate = LocalDate.of(2019, Month.MARCH, 1);
        String initialHour = "12:00";
        LocalDate finalDate = LocalDate.of(2020, Month.MARCH, 12);
        String finalHour = "13:00";
        String period = "Monday";
        Time hourI=new Time(initialHour);
        Time hourF=new Time(finalHour);
        Availability aval = new Availability(initialDate, hourI, finalDate, hourF, period);
        AvailabilityList instance = new AvailabilityList();
        boolean expResult = true;
        boolean result = instance.addAvailabilityTime(aval);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeTimePeriod method, of class AvailabilityList.
     */
    @Test
    public void testRemoveTimePeriod() {
        System.out.println("removeTimePeriod");
        LocalDate initialDate = LocalDate.of(2019, Month.MARCH, 1);
        String initialHour = "12:00";
        LocalDate finalDate = LocalDate.of(2019, Month.MARCH, 12);
        String finalHour = "16:00";
        String period = "Monday";
        Time hourI=new Time(initialHour);
        Time hourF=new Time(finalHour);
        Availability avail = new Availability(initialDate, hourI, finalDate, hourF, period);
        TimePreference pref=new TimePreference(0, LocalDate.of(2019, Month.MARCH, 6), new Time("13:00"));
        AvailabilityList instance = new AvailabilityList();
        instance.addAvailabilityTime(avail);
        instance.removeTimePeriod(avail, pref, 30);
        ArrayList<Availability> expResult=new ArrayList<>();
        Availability avail1=new Availability(LocalDate.of(2019, Month.MARCH, 1), new Time("12:00"), LocalDate.of(2019, Month.MARCH, 5), new Time("16:00"), "Monday");
        Availability avail2=new Availability(LocalDate.of(2019, Month.MARCH, 6), new Time("12:00"), LocalDate.of(2019, Month.MARCH, 6), new Time("13:00"), String.valueOf(pref.getDate().getDayOfWeek()));
        Availability avail3=new Availability(LocalDate.of(2019, Month.MARCH, 6), new Time("13:30"), LocalDate.of(2019, Month.MARCH, 6), new Time("16:00"), String.valueOf(pref.getDate().getDayOfWeek()));
        Availability avail4=new Availability(LocalDate.of(2019, Month.MARCH, 7), new Time("12:00"), LocalDate.of(2019, Month.MARCH, 12), new Time("16:00"), "Monday");
        expResult.add(avail1);
        expResult.add(avail2);
        expResult.add(avail3);
        expResult.add(avail4);
        ArrayList<Availability> result = instance.getAvailabilityList();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class AvailabilityList.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new AvailabilityList();
        AvailabilityList instance = new AvailabilityList();
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new AvailabilityList();
        AvailabilityList instance = (AvailabilityList) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = null;
        AvailabilityList instance = new AvailabilityList();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testEquals4() {
        System.out.println("equals");
        Object o = new ClientRecords();
        AvailabilityList instance = new AvailabilityList();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class AvailabilityList.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AvailabilityList instance = new AvailabilityList();
        LocalDate initialDate = LocalDate.of(2020, Month.MARCH, 1);
        String initialHour = "12:00";
        LocalDate finalDate = LocalDate.of(2021, Month.MARCH, 12);
        String finalHour = "13:00";
        String period = "Monday";
        Time hourI=new Time(initialHour);
        Time hourF=new Time(finalHour);
        instance.registerAvailabiityTime(new Availability(initialDate, hourI, finalDate, hourF, period));
        System.out.print(instance);
        String expResult = "Availabilities: Date (initial/final): 2020-03-01 - 2021-03-12Time (initial/final):12:00-13:00 | ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
