/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import lapr.project.gpsd.model.Rate;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.records.RateList;
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
 * @author pedro
 */
public class EvaluateServiceProviderControllerTest {

    public EvaluateServiceProviderControllerTest() {
    }

    public static ServiceProvider servProv1;

    @BeforeAll
    public static void instanciateSP() throws UnsupportedEncodingException, FileNotFoundException {
        servProv1 = new ServiceProvider("Pedro Brandao", "PB", 123123123, 123123123, "pedro@gmail.com");
        ServiceProvider servProv2 = new ServiceProvider("jOAO ASD", "JA", 123323123, 123123123, "pedgfdh@gmail.com");
        ServiceProvider servProv3 = new ServiceProvider("sdfO ASD", "SA", 121123123, 121123123, "pedSDfdh@gmail.com");
        ServiceProviderRecords servProviderRec = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
        servProviderRec.registerServiceProvider(servProv1);
        servProviderRec.registerServiceProvider(servProv2);
        servProviderRec.registerServiceProvider(servProv3);
        RateList rateList = new RateList();
        Rate r1 = new Rate(1);
        Rate r2 = new Rate(2);
        Rate r3 = new Rate(3);
        Rate r4 = new Rate(4);
        Rate r5 = new Rate(5);
        rateList.registerRate(r1);
        rateList.registerRate(r2);
        rateList.registerRate(r3);
        rateList.registerRate(r4);
        rateList.registerRate(r5);
        RateList rateList1 = new RateList();
        rateList1.registerRate(r2);
        rateList1.registerRate(r2);
        rateList1.registerRate(r3);
        rateList1.registerRate(r3);
        rateList1.registerRate(r5);
        RateList rateList2 = new RateList();
        rateList2.registerRate(r4);
        rateList2.registerRate(r4);
        rateList2.registerRate(r4);
        rateList2.registerRate(r4);
        rateList2.registerRate(r2);
        servProv1.setRateList(rateList);
        servProv2.setRateList(rateList1);
        servProv3.setRateList(rateList2);
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
     * Test of getServiceProviders method, of class
     * EvaluateServiceProviderController.
     */
    @Test
    public void testGetServiceProviders() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("getServiceProviders");
        EvaluateServiceProviderController instance = new EvaluateServiceProviderController();
        ServiceProviderRecords servProviderRec = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
        List<ServiceProvider> expResult = servProviderRec.getServiceProviderList();
        List<ServiceProvider> result = instance.getServiceProviders();
        assertEquals(expResult, result);

    }

    /**
     * Test of setServProv method, of class EvaluateServiceProviderController.
     */
    @Test
    public void testSetServProv() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("setServProv");
        ServiceProvider servProv3 = new ServiceProvider("sdfO ASD", "SA", 121123123, 121123123, "pedSDfdh@gmail.com");
        EvaluateServiceProviderController instance = new EvaluateServiceProviderController();
        RateList rateList = new RateList();
        Rate r1 = new Rate(1);
        Rate r2 = new Rate(2);
        Rate r3 = new Rate(3);
        Rate r4 = new Rate(4);
        Rate r5 = new Rate(5);
        rateList.registerRate(r1);
        rateList.registerRate(r2);
        rateList.registerRate(r3);
        rateList.registerRate(r4);
        rateList.registerRate(r5);
        servProv3.setRateList(rateList);
        boolean result = instance.setServProv(servProv3);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateMeanRate method, of class
     * EvaluateServiceProviderController.
     */
    @Test
    public void testCalculateMeanRate() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("calculateMeanRate");
        EvaluateServiceProviderController instance = new EvaluateServiceProviderController();
        instance.getServiceProviders();
        double expResult = 3.2;
        double result = instance.calculateMeanRate();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of calculateStandardDeviationAll method, of class
     * EvaluateServiceProviderController.
     */
    @Test
    public void testCalculateStandardDeviationAll() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("calculateStandardDeviationAll");
        EvaluateServiceProviderController instance = new EvaluateServiceProviderController();
        instance.getServiceProviders();
        instance.calculateMeanRate();
        double expResult = 0.28;
        double result = instance.calculateStandardDeviationAll();
        assertEquals(expResult, result, 0.05);
    }

    /**
     * Test of calculateStandardDeviationSP method, of class
     * EvaluateServiceProviderController.
     */
    @Test
    public void testCalculateStandardDeviationSP() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("calculateStandardDeviationSP");
        EvaluateServiceProviderController instance = new EvaluateServiceProviderController();
        instance.setServProv(servProv1);
        instance.getServiceProviders();
        instance.calculateMeanRate();
        instance.calculateStandardDeviationAll();
        double expResult = 0.2;
        double result = instance.calculateStandardDeviationSP();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of labelSP method, of class EvaluateServiceProviderController.
     */
    @Test
    public void testLabelSP() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("labelSP");
        EvaluateServiceProviderController instance = new EvaluateServiceProviderController();
        instance.setServProv(servProv1);
        instance.getServiceProviders();
        instance.calculateMeanRate();
        instance.calculateStandardDeviationAll();
        String expResult = "Regular";
        String result = instance.labelSP();
        assertEquals(expResult, result);
    }

    /**
     * Test of registerEvaluation method, of class
     * EvaluateServiceProviderController.
     */
    @Test
    public void testRegisterEvaluation() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("registerEvaluation");
        String evaluation = "Worst";
        double providerMeanRating = 2;
        EvaluateServiceProviderController instance = new EvaluateServiceProviderController();
        instance.setServProv(servProv1);
        boolean expResult = true;
        boolean result = instance.registerEvaluation(evaluation, providerMeanRating);
        assertEquals(expResult, result);
    }

}
