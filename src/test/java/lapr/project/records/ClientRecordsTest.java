/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import lapr.project.autorization.AuthorizationFacade;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
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
public class ClientRecordsTest {
    
    public ClientRecordsTest() {
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
     * Test of getClientByEmail method, of class ClientRecords.
     */
    @Test
    public void testGetClientByEmail() {
        System.out.println("getClientByEmail");
        String strEMail = "ola@email.pt";
        ClientRecords instance = new ClientRecords();
        PostalCode pc = new PostalCode("4100-050", 0, 0);
        PostalAddress pa = new PostalAddress("Porto", pc, "Porto");
        Client expResult = new Client("Andre", "1234", "919999999", "ola@email.pt", pa);
        instance.getClientList().add(expResult);
        Client result = instance.getClientByEmail(strEMail);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetClientByEmail2() {
        System.out.println("getClientByEmail");
        String strEMail = "ol@email.pt";
        ClientRecords instance = new ClientRecords();
        PostalCode pc = new PostalCode("4100-050", 0, 0);
        PostalAddress pa = new PostalAddress("Porto", pc, "Porto");
        Client expResult = null;
        Client result = instance.getClientByEmail(strEMail);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetClientByEmail3() {
        System.out.println("getClientByEmail");
        String strEMail = "ola@email.pt";
        ClientRecords instance = new ClientRecords();
        PostalCode pc = new PostalCode("4100-050", 0, 0);
        PostalAddress pa = new PostalAddress("Porto", pc, "Porto");
        Client expResult = null;
        Client result = instance.getClientByEmail(strEMail);
        assertEquals(expResult, result);
    }

    /**
     * Test of newClient method, of class ClientRecords.
     */
    @Test
    public void testNewClient_5args() {
        System.out.println("newClient");
        String strName = "Andre";
        String strTIN = "1234";
        String strPhone = "919999999";
        String strEmail = "ola@email.pt";
        PostalCode pc = new PostalCode("4100-050", 0, 0);
        PostalAddress address = new PostalAddress("Porto", pc, "Porto");
        ClientRecords instance = new ClientRecords();
        Client expResult = new Client("Andre", "1234", "919999999", "ola@email.pt", address);
        Client result = instance.newClient(strName, strTIN, strPhone, strEmail, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of newClient method, of class ClientRecords.
     */
    @Test
    public void testNewClient_4args() {
        System.out.println("newClient");
        String strName = "Andre";
        String strTIN = "1234";
        String strPhone = "919999999";
        String strEmail = "ola@email.pt";
        ClientRecords instance = new ClientRecords();
        Client expResult = new Client("Andre", "1234", "919999999", "ola@email.pt");
        Client result = instance.newClient(strName, strTIN, strPhone, strEmail);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerClient method, of class ClientRecords.
     */
    @Test
    public void testRegisterClient() {
        System.out.println("registerClient");
        Client client = new Client("Andre", "1234", "919999999", "ola@email.pt");
        String strPwd = "1234";
        ClientRecords instance = new ClientRecords();
        boolean expResult = true;
        boolean result = instance.registerClient(client, strPwd);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateClient method, of class ClientRecords.
     */
    @Test
    public void testValidateClient() {
        System.out.println("validateClient");
        Client client = new Client("Andre", "1234", "919999999", "ola@email.pt");
        String strPwd = "1234";
        ClientRecords instance = new ClientRecords();
        boolean expResult = true;
        boolean result = instance.validateClient(client, strPwd);
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientList method, of class ClientRecords.
     */
    @Test
    public void testGetClientList() {
        System.out.println("getClientList");
        ClientRecords instance = new ClientRecords();
        Client client1 = new Client("Andre", "1234", "919999999", "ola@email.pt");
        Client client2 = new Client("Pedro", "12345", "919999991", "ola2@email.pt");
        List<Client> expResult = new ArrayList<>();
        expResult.add(client1);
        expResult.add(client2);
        instance.registerClient(client1, "1234");
        instance.registerClient(client2, "12345");
        List<Client> result = instance.getClientList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAutorizacaoFacade method, of class ClientRecords.
     */
    @Test
    public void testGetAutorizacaoFacade() {
        System.out.println("getAutorizacaoFacade");
        ClientRecords instance = new ClientRecords();
        AuthorizationFacade expResult = instance.getAutorizacaoFacade();
        AuthorizationFacade result = instance.getAutorizacaoFacade();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ClientRecords.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new ClientRecords();
        ClientRecords instance = new ClientRecords();
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object obj = new ClientRecords();
        ClientRecords instance = (ClientRecords) obj;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object obj = new CategoryRecords();
        ClientRecords instance = new ClientRecords();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
