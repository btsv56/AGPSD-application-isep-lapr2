/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.Month;
import lapr.project.gpsd.model.Availability;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.Time;
import lapr.project.records.ServiceProviderRecords;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Utilizador
 */
public class NewAvailabilityControllerTest {
    
    public NewAvailabilityControllerTest() {
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
     * Test of newAvailibilityTime method, of class NewAvailabilityController.
     */
    @Test
    public void testNewAvailibilityTime() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("newAvailibilityTime");
          AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        ServiceProviderRecords spr=company.getServiceProviderRecords();
        ServiceProvider servProv= new ServiceProvider("Veiga", "Veiga", 1, 1, "Veiga");
        spr.registerServiceProvider(servProv);
        app.doLogin("Veiga",  app.getCompany().getClientRecords().getAutorizacaoFacade().getUserRecords().searchUser("Veiga").getPassword());
        LocalDate dateI = LocalDate.of(2020, Month.MARCH, 2);
        LocalDate dateF = LocalDate.of(2021, Month.MARCH, 3);
        String hourI = "12:00";
        String hourF = "13:00";
        String period = "Monday";
        NewAvailabilityController instance = new NewAvailabilityController();
        instance.setServiceProvider(servProv);
        Availability expResult = instance.newAvailibilityTime(dateI, dateF, hourI, hourF, period);
        Availability result = instance.newAvailibilityTime(dateI, dateF, hourI, hourF, period);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerAvailabilityTime method, of class NewAvailabilityController.
     */
    @Test
    public void testRegisterAvailabilityTime() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("registerAvailabilityTime");
          AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        ServiceProviderRecords spr=company.getServiceProviderRecords();
        ServiceProvider servProv= new ServiceProvider("Veiga", "Veiga", 1, 1, "Veiga");
        spr.registerServiceProvider(servProv);
        app.doLogin("Veiga",  app.getCompany().getClientRecords().getAutorizacaoFacade().getUserRecords().searchUser("Veiga").getPassword());
        NewAvailabilityController instance = new NewAvailabilityController();
        LocalDate dateI = LocalDate.of(2020, Month.MARCH, 2);
        LocalDate dateF = LocalDate.of(2021, Month.MARCH, 3);
        String hourI = "12:00";
        String hourF = "13:00";
        String period = "Monday";
        instance.setServiceProvider(servProv);
        Availability aval= instance.newAvailibilityTime(dateI, dateF, hourI, hourF, period);
        instance.registerAvailabilityTime(aval);
    }
    
}
