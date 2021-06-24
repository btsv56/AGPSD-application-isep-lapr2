/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.ServiceSchedule;
import lapr.project.gpsd.model.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class ServiceScheduleRecordsTest {
    
    public ServiceScheduleRecordsTest() {
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
     * Test of addSStolist method, of class ServiceScheduleRecords.
     */
    @Test
    public void testAddSStolist() {
        System.out.println("addSStolist");
        LocalDate date = LocalDate.now();
        Time hour = new Time(12, 00);
        ServiceSchedule ss = new ServiceSchedule("Accepted", date, hour);
        ServiceScheduleRecords instance = new ServiceScheduleRecords();
        boolean expResult = true;
        boolean result = instance.addSStolist(ss);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceScheduleList method, of class ServiceScheduleRecords.
     */
    @Test
    public void testGetServiceScheduleList() {
        System.out.println("getServiceScheduleList");
        LocalDate date = LocalDate.now();
        Time hour = new Time(12, 00);
        ServiceSchedule ss = new ServiceSchedule("Accepted", date, hour);
        LocalDate date2 = LocalDate.now();
        Time hour2 = new Time(22, 00);
        ServiceSchedule ss2 = new ServiceSchedule("Accepted", date2, hour2);
        ServiceScheduleRecords instance = new ServiceScheduleRecords();
        instance.addSStolist(ss);
        instance.addSStolist(ss2);
        List<ServiceSchedule> expResult = new ArrayList<>();
        expResult.add(ss);
        expResult.add(ss2);
        List<ServiceSchedule> result = instance.getServiceScheduleList();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getServiceScheduleList method, of class ServiceScheduleRecords.
     */
    @Test
    public void testGetServiceScheduleList2() {
        System.out.println("getServiceScheduleList");
        ServiceScheduleRecords instance = new ServiceScheduleRecords();
        List<ServiceSchedule> expResult = new ArrayList<>();
        List<ServiceSchedule> result = instance.getServiceScheduleList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSSfromServiceScheduleList method, of class ServiceScheduleRecords.
     */
    @Test
    public void testGetSSfromServiceScheduleList() {
        System.out.println("getSSfromServiceScheduleList");
        int num = 0;LocalDate date = LocalDate.now();
        Time hour = new Time(12, 00);
        ServiceSchedule ss = new ServiceSchedule("Accepted", date, hour);
        ServiceScheduleRecords instance = new ServiceScheduleRecords();
        instance.addSStolist(ss);
        ServiceSchedule expResult = ss;
        ServiceSchedule result = instance.getSSfromServiceScheduleList(num);
        assertEquals(expResult, result);
    }
        
}
