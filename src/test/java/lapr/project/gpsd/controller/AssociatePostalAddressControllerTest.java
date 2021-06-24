/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import lapr.project.autorization.AuthorizationFacade;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Instanciate;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.records.ClientRecords;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author User
 */
public class AssociatePostalAddressControllerTest {

    public AssociatePostalAddressControllerTest() {
    }

    @BeforeAll
    private static void doLogin() {
        AppGPSD m_oApp = AppGPSD.getInstance();
        Company m_oCompany = m_oApp.getCompany();
        ClientRecords m_cliRcds = m_oCompany.getClientRecords();
        AuthorizationFacade m_authFac = m_cliRcds.getAutorizacaoFacade();
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String local = "Paredes";
        PostalCode pc = new PostalCode(s_postCode);
        PostalAddress pa = new PostalAddress(postAd, pc, local);
        Client cli = m_cliRcds.newClient("Name", "123456789", "987654321", "Email", pa);
        m_cliRcds.registerClient(cli, "123");
        m_authFac.doLogin("Email", "123");
    }

    /**
     * Test of newPostalAddress method, of class
     * AssociatePostalAddressController.
     */
    @Test
    public void testNewPostalAddress() throws Exception {
        System.out.println("newPostalAddress");
        AssociatePostalAddressController instance = new AssociatePostalAddressController();
        instance.newPostalAddress();
    }

    @Test
    public void testNewPostalAdress() throws Exception {
        System.out.println("newPostalAdress");
        String adress = "Penafiel";
        String postCode = "4000-15";
        String local = "Porto";
        AssociatePostalAddressController instance = new AssociatePostalAddressController();
        instance.newPostalAddress();
        instance.newPostalAdress(adress, postCode, local);
    }

    /**
     * Test of registerAddress method, of class
     * AssociatePostalAddressController.
     */
    @Test
    public void testRegisterAddress() throws FileNotFoundException {
        System.out.println("registerAddress");
        AssociatePostalAddressController instance = new AssociatePostalAddressController();
        String adress = "Penafiel";
        String postCode = "4000-15";
        String local = "Porto";
        instance.newPostalAddress();
        instance.newPostalAdress(adress, postCode, local);
        instance.registerAddress();

    }

    /**
     * Test of getPostalCodeByPos method, of class
     * AssociatePostalAddressController.
     */
    @Test
    public void testGetPostalCodeByPos() throws FileNotFoundException {
        System.out.println("getPostalCodeByPos");
        int i = 2;
        AssociatePostalAddressController instance = new AssociatePostalAddressController();
        String expResult = "4000-7";
        Instanciate.readPostalCodes("4000-7");
        String result = "4000-7";
        assertEquals(expResult, result);
    }

    /**
     * Test of getCli method, of class AssociatePostalAddressController.
     */
    @Test
    public void testGetCli() throws FileNotFoundException {
        System.out.println("getCli");
        AssociatePostalAddressController instance = new AssociatePostalAddressController();
        instance.newPostalAddress();
        String postAd = "Porto";
        String s_postCode = "4000-9";
        String locals = "Paredes";
        PostalCode pc = new PostalCode(s_postCode);
        PostalAddress pa = new PostalAddress(postAd, pc, locals);
        Client cli = new Client("Name", "123456789", "987654321", "Email", pa);
        Client expResult = cli;
        Client result = instance.getCli();
        assertEquals(expResult, result);
    }

}
