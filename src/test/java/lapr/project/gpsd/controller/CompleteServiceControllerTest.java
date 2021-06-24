/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Issue;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequestDescription;
import lapr.project.gpsd.model.ServiceSchedule;
import lapr.project.gpsd.model.ServiceType;
import lapr.project.gpsd.model.Time;
import lapr.project.records.ServiceOrderRecords;
import lapr.project.records.ServiceProviderRecords;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marta
 */
public class CompleteServiceControllerTest {

    public CompleteServiceControllerTest() {
    }

    /**
     * Test of getServiceOrderByNum method, of class CompleteServiceController.
     */
    @Test
    public void testGetServiceOrderByNum() throws FileNotFoundException, UnsupportedEncodingException {
        try {
            System.out.println("getServiceOrderByNum");
            AppGPSD m_oApp = AppGPSD.getInstance();
            Company m_oCompany = m_oApp.getCompany();
            ServiceProviderRecords servProvRecords = m_oCompany.getServiceProviderRecords();
            ServiceProvider sp = servProvRecords.newServiceProvider("Patricia Pinto", "PP", 237022486, 917979870, "email@esoft");
            servProvRecords.registerServiceProvider(sp);
            m_oApp.doLogin(sp.getEmail(), sp.getPWD());
            PostalAddress oAddress = new PostalAddress("Rua", new PostalCode("4000-7"), "Penafiel");
            Client cli = new Client("X", "123456789", "123456789", "esoft@email", oAddress);
            ServiceSchedule ss = new ServiceSchedule("Not Executed", LocalDate.MAX, new Time("12:30"));
            ServiceType servtype = new ServiceType("lapr.project.gpsd.model.LimitedService", "Limited");
            Category cat = new Category("cat1", "limpeza");
            Service serv = servtype.newService("lim1", "giygig", "rfgergergeg", 10, cat);
            ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "X", 10);
            ServiceOrder so = new ServiceOrder(2, sp, descServ, ss, oAddress, cli);
            ServiceOrderRecords sor = m_oCompany.getServiceOrderRecords();
            sor.addServiceOrder(so);
            int num = 2;
            CompleteServiceController instance = new CompleteServiceController();
            instance.newCompleteService();
            ServiceOrder expResult = so;
            ServiceOrder result = instance.getServiceOrderByNum(num);
            assertEquals(expResult, result);
        } catch (Exception ex) {
            Logger.getLogger(CompleteServiceControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of setServiceOrderStatus method, of class CompleteServiceController.
     */
    @Test
    public void testSetServiceOrderStatus() throws FileNotFoundException, UnsupportedEncodingException {
        try {
            System.out.println("setServiceOrderStatus");
            AppGPSD m_oApp = AppGPSD.getInstance();
            Company m_oCompany = m_oApp.getCompany();
            ServiceProviderRecords servProvRecords = m_oCompany.getServiceProviderRecords();
            ServiceProvider sp = servProvRecords.newServiceProvider("Patricia Pinto", "PP", 237022486, 917979870, "email@esoft");
            servProvRecords.registerServiceProvider(sp);
            m_oApp.doLogin(sp.getEmail(), sp.getPWD());
            PostalAddress oAddress = new PostalAddress("Rua", new PostalCode("4000-7"), "Penafiel");
            Client cli = new Client("X", "123456789", "123456789", "esoft@email", oAddress);
            ServiceSchedule ss = new ServiceSchedule("Not Executed", LocalDate.MAX, new Time("12:30"));
            ServiceType servtype = new ServiceType("lapr.project.gpsd.model.LimitedService", "Limited");
            Category cat = new Category("cat1", "limpeza");
            Service serv = servtype.newService("lim1", "giygig", "rfgergergeg", 10, cat);
            ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "X", 10);
            ServiceOrder so = new ServiceOrder(1, sp, descServ, ss, oAddress, cli);
            ServiceOrderRecords sor = m_oCompany.getServiceOrderRecords();
            sor.addServiceOrder(so);
            ServiceOrder order = so;
            String status = "Executed";
            CompleteServiceController instance = new CompleteServiceController();
            instance.setServiceOrderStatus(order, status);
            String result = so.getExecutionState();
            assertEquals(result, status);
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(CompleteServiceControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of newIssue method, of class CompleteServiceController.
     */
    @Test
    public void testNewIssue() throws FileNotFoundException, UnsupportedEncodingException {
        try {
            System.out.println("newIssue");
            AppGPSD m_oApp = AppGPSD.getInstance();
            Company m_oCompany = m_oApp.getCompany();
            ServiceProviderRecords servProvRecords = m_oCompany.getServiceProviderRecords();
            ServiceProvider sp = servProvRecords.newServiceProvider("Patricia Pinto", "PP", 237022486, 917979870, "email@esoft");
            servProvRecords.registerServiceProvider(sp);
            m_oApp.doLogin(sp.getEmail(), sp.getPWD());
            PostalAddress oAddress = new PostalAddress("Rua", new PostalCode("4000-7"), "Penafiel");
            Client cli = new Client("X", "123456789", "123456789", "esoft@email", oAddress);
            ServiceSchedule ss = new ServiceSchedule("Not Executed", LocalDate.MAX, new Time("12:30"));
            ServiceType servtype = new ServiceType("lapr.project.gpsd.model.LimitedService", "Limited");
            Category cat = new Category("cat1", "limpeza");
            Service serv = servtype.newService("lim1", "giygig", "rfgergergeg", 10, cat);
            ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "X", 10);
            ServiceOrder so = new ServiceOrder(1, sp, descServ, ss, oAddress, cli);
            ServiceOrderRecords sor = m_oCompany.getServiceOrderRecords();
            sor.addServiceOrder(so);
            ServiceOrder order = so;
            String desc = "yufih";
            String troublest = "ygiuou";
            CompleteServiceController instance = new CompleteServiceController();
            Issue expResult = new Issue(so, desc, troublest);
            Issue result = instance.newIssue(order, desc, troublest);
            assertEquals(expResult, result);
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(CompleteServiceControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of registersIssue method, of class CompleteServiceController.
     */
    @Test
    public void testRegistersIssue() throws FileNotFoundException, UnsupportedEncodingException {
        try {
            System.out.println("registersIssue");
            AppGPSD m_oApp = AppGPSD.getInstance();
            Company m_oCompany = m_oApp.getCompany();
            ServiceProviderRecords servProvRecords = m_oCompany.getServiceProviderRecords();
            ServiceProvider sp = servProvRecords.newServiceProvider("Patricia Pinto", "PP", 237022486, 917979870, "email@esoft");
            servProvRecords.registerServiceProvider(sp);
            m_oApp.doLogin(sp.getEmail(), sp.getPWD());
            PostalAddress oAddress = new PostalAddress("Rua", new PostalCode("4000-7"), "Penafiel");
            Client cli = new Client("X", "123456789", "123456789", "esoft@email", oAddress);
            ServiceSchedule ss = new ServiceSchedule("Not Executed", LocalDate.MAX, new Time("12:30"));
            ServiceType servtype = new ServiceType("lapr.project.gpsd.model.LimitedService", "Limited");
            Category cat = new Category("cat1", "limpeza");
            Service serv = servtype.newService("lim1", "giygig", "rfgergergeg", 10, cat);
            ServiceProvidingRequestDescription descServ = new ServiceProvidingRequestDescription(serv, "X", 10);
            ServiceOrder so = new ServiceOrder(1, sp, descServ, ss, oAddress, cli);
            ServiceOrderRecords sor = m_oCompany.getServiceOrderRecords();
            sor.addServiceOrder(so);
            Issue issue = new Issue(so, "gsrgs", "sefwg");
            CompleteServiceController instance = new CompleteServiceController();
            instance.newCompleteService();
            instance.getServiceOrderByNum(0);
            instance.setServiceOrderStatus(so, "Completed");
            instance.newIssue(so, "desc", "desc");
            boolean expResult = true;
            boolean result = instance.registersIssue(issue);
            assertEquals(expResult, result);
            
        } catch (Exception ex) {
            Logger.getLogger(CompleteServiceControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
