/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorization.model;

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
public class UserPapersRecordsTest {

    public UserPapersRecordsTest() {
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
     * Test of newUserPaper method, of class UserPapersRecords.
     */
    @Test
    public void testNewUserPaper_String() {
        System.out.println("newUserPaper");
        String strPaper = "Client";
        UserPapersRecords instance = new UserPapersRecords();
        UsersPaper expResult = new UsersPaper(strPaper);
        UsersPaper result = instance.newUserPaper(strPaper);
        assertEquals(expResult, result);
    }

    /**
     * Test of newUserPaper method, of class UserPapersRecords.
     */
    @Test
    public void testNewUserPaper_String_String() {
        System.out.println("newUserPaper");
        String strPaper = "Client";
        String strDescricao = "new client";
        UserPapersRecords instance = new UserPapersRecords();
        UsersPaper expResult = new UsersPaper(strPaper, strDescricao);
        UsersPaper result = instance.newUserPaper(strPaper, strDescricao);
        assertEquals(expResult, result);
    }

    /**
     * Test of addPaper method, of class UserPapersRecords.
     */
    @Test
    public void testAddPaper() {
        System.out.println("addPaper");
        UsersPaper papel = new UsersPaper("Client");
        UserPapersRecords instance = new UserPapersRecords();
        boolean expResult = true;
        boolean result = instance.addPaper(papel);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddPaper2() {
        System.out.println("addPaper");
        UsersPaper papel = null;
        UserPapersRecords instance = new UserPapersRecords();
        boolean expResult = false;
        boolean result = instance.addPaper(papel);
        assertEquals(expResult, result);
    }

    /**
     * Test of removePaper method, of class UserPapersRecords.
     */
    @Test
    public void testRemovePaper() {
        System.out.println("removePaper");
        UsersPaper papel = new UsersPaper("Client");
        UserPapersRecords instance = new UserPapersRecords();
        instance.addPaper(papel);
        boolean expResult = true;
        boolean result = instance.removePaper(papel);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemovePaper2() {
        System.out.println("removePaper");
        UsersPaper papel = new UsersPaper("Client");
        UserPapersRecords instance = new UserPapersRecords();
        boolean expResult = false;
        boolean result = instance.removePaper(papel);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchPaper method, of class UserPapersRecords.
     */
    @Test
    public void testSearchPaper() {
        System.out.println("searchPaper");
        String strPaper = "Client";
        UserPapersRecords instance = new UserPapersRecords();
        UsersPaper paper = new UsersPaper(strPaper);
        instance.addPaper(paper);
        UsersPaper expResult = new UsersPaper("Client");
        UsersPaper result = instance.searchPaper(strPaper);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasPaper method, of class UserPapersRecords.
     */
    @Test
    public void testHasPaper_String() {
        System.out.println("hasPaper");
        String strPaper = "Client";
        UsersPaper paper = new UsersPaper(strPaper);
        UserPapersRecords instance = new UserPapersRecords();
        instance.addPaper(paper);
        boolean expResult = true;
        boolean result = instance.hasPaper(strPaper);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHasPaper_String2() {
        System.out.println("hasPaper");
        String strPaper = "Client";
        UsersPaper paper = new UsersPaper(strPaper);
        UserPapersRecords instance = new UserPapersRecords();
        boolean expResult = false;
        boolean result = instance.hasPaper(strPaper);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasPaper method, of class UserPapersRecords.
     */
    @Test
    public void testHasPaper_UsersPaper() {
        System.out.println("hasPaper");
        UsersPaper paper = new UsersPaper("Client");
        UserPapersRecords instance = new UserPapersRecords();
        instance.addPaper(paper);
        boolean expResult = true;
        boolean result = instance.hasPaper(paper);
        assertEquals(expResult, result);
    }

}
