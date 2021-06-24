/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import lapr.project.gpsd.controller.AppGPSD;
import static lapr.project.gpsd.model.Instanciate.readPostalCodes;
import lapr.project.records.CategoryRecords;
import lapr.project.records.GeographicalAreaRecords;
import lapr.project.records.ServiceProviderRecords;
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
public class InstanciateTest {

    public InstanciateTest() {
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
     * Test of readPostalCodes method, of class Instanciate.
     */
    @Test
    public void testReadPostalCodes() {
        System.out.println("readPostalCodes");
        String code = "4000-9";
        boolean expResult = true;
        boolean result = Instanciate.readPostalCodes(code);
        assertEquals(expResult, result);
    }

    /**
     * Test of createRate method, of class Instanciate.
     */
    @Test
    public void testCreateRate() throws Exception {
        AppGPSD app = AppGPSD.getInstance();
        System.out.println("createRate");
        Instanciate.createClients();
        Instanciate.createCategories();
        Instanciate.createGeographicalAreas();
        Instanciate.createService();
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        GeographicalAreaRecords gar = AppGPSD.getInstance().getCompany().getGeographicalAreaRecords();
        readPostalCodes("4415-995");
        readPostalCodes("4420-2");
        readPostalCodes("4470-526");
        readPostalCodes("4430-601");
        ServiceProviderRecords spr = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
        ServiceProvider sp = new ServiceProvider("António Padrão", "António Dos Santos Padrão", 500324896, 123456789, "aPadrao@gmail.com");
        sp.addCategory(cr.getCategoryById("1"));
        sp.addCategory(cr.getCategoryById("3"));
        sp.addPostalAddress(new PostalAddress("Rua do outeiro, 197", new PostalCode("4415-995"), "Paredes"));
        spr.registerServiceProviderWithPass(sp, "1234");
        ServiceProvider sp1 = new ServiceProvider("Maria Silva", "Maria Das Neves Silva", 510324896, 123123123, "mSilva@hotmail.com");
        sp1.addCategory(cr.getCategoryById("2"));
        sp1.addCategory(cr.getCategoryById("4"));
        sp1.addPostalAddress(new PostalAddress("Rua de Miragaia, 261", new PostalCode("4420-002"), "Paredes"));
        spr.registerServiceProviderWithPass(sp1, "1234");
        ServiceProvider sp2 = new ServiceProvider("Joaquina Dos Santos", "Joaquina Dos Santos", 510324877, 456456456, "jaquina@hotmail.com");
        sp2.addCategory(cr.getCategoryById("1"));
        sp2.addCategory(cr.getCategoryById("2"));
        sp2.addCategory(cr.getCategoryById("3"));
        sp2.addPostalAddress(new PostalAddress("Rua Afonso Paço, 12", new PostalCode("4470-526"), "Paços de Ferreira"));
        spr.registerServiceProviderWithPass(sp2, "1234");
        ServiceProvider sp3 = new ServiceProvider("Serafim Santos", "Serafim Santos", 230324822, 897897897, "sSantos@gmail.com");
        sp3.addCategory(cr.getCategoryById("5"));
        sp3.addCategory(cr.getCategoryById("1"));
        sp3.addPostalAddress(new PostalAddress("Rua Afonso Paço, 12", new PostalCode("4430-601"), "Paços de Ferreira"));
        spr.registerServiceProviderWithPass(sp3, "1234");
        Instanciate.createApplication();
        Instanciate.createDisponibilities();
        try {
            Instanciate.createServiceProvidingRequest();
        } catch (Exception e) {

        }
        Instanciate.createServiceOrders();
        Instanciate.createRate();

    }

}
