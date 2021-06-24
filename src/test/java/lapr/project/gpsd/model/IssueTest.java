package lapr.project.gpsd.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import lapr.project.records.CategoryRecords;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.jupiter.api.Assertions.*;

class IssueTest {

    private ServiceProvider sp = new ServiceProvider("12", "12", 123123123, 123123213, "12");
    private Category cat = new Category("12", "12");
    private FixedService serv = new FixedService("12", "12", "12", 1, cat);
    private ServiceProvidingRequestDescription reqDesc = new ServiceProvidingRequestDescription(serv, "12", 30);
    private ServiceSchedule ss = new ServiceSchedule("12", LocalDate.of(2020, 12, 12), new Time(13, 00));
    private PostalAddress pa = new PostalAddress("12", new PostalCode("12", 12, 12), "12");
    private Client cli = new Client("12", "123123123", "123123123", "12", pa);
    private ServiceOrder so = new ServiceOrder(1, sp, reqDesc, ss, pa, cli);
    Issue iss = new Issue(so, "12", "12");

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    void getOr() {
        ServiceOrder expResult = new ServiceOrder(1, sp, reqDesc, ss, pa, cli);
        ServiceOrder result = iss.getOr();
        assertEquals(expResult, result);
    }

    @Test
    void getDesc() {
        String expResult = "12";
        String result = iss.getDesc();
        assertEquals(expResult, result);
    }

    @Test
    void getTroublest() {
        String expResult = "12";
        String result = iss.getTroublest();
        assertEquals(expResult, result);
    }

    @Test
    void setOr() {
        iss.setOr(new ServiceOrder(13, sp, reqDesc, ss, pa, cli));
        ServiceOrder expResult = new ServiceOrder(13, sp, reqDesc, ss, pa, cli);
        ServiceOrder result = iss.getOr();
        assertEquals(expResult, result);
    }

    @Test
    void setDesc() {
        iss.setDesc("DESC");
        String expResult = "DESC";
        String result = iss.getDesc();
        assertEquals(expResult, result);
    }

    @Test
    void setTroublest() {
        iss.setTroublest("SET");
        String expResult = "SET";
        String result = iss.getTroublest();
        assertEquals(expResult, result);
    }

    @Test
    void equals1() {
        Issue iss2 = new Issue(so, "12", "12");
        boolean expResult = true;
        boolean result = iss.equals(iss2);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Issue.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Issue(so, "desc", "desc");
        Issue instance = new Issue(so, "desc", "desc");
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new Issue(so, "desc", "desc");
        Issue instance = (Issue) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object o = new CategoryRecords();
        Issue instance = new Issue(so, "desc", "desc");
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Issue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Issue instance = new Issue(so, "desc", "desc");
        String result = instance.toString();
    }
}
