package lapr.project.gpsd.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author André
 */
public class CategoryTest {
    
    public CategoryTest() {
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
     * Test of hasId method, of class Category.
     */
    @Test
    public void testHasId() {
        System.out.println("hasId");
        String strId = "100";
        Category instance = new Category("100", "descricao");
        boolean expResult = true;
        boolean result = instance.hasId(strId);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of hasId method, of class Category.
     */
    @Test
    public void testHasId2() {
        System.out.println("hasId");
        String strId = null;
        Category instance = new Category("100", "descricao");
        boolean expResult = false;
        boolean result = instance.hasId(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCode method, of class Category.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        Category instance = new Category("100", "descricao");
        String expResult = "100";
        String result = instance.getCode();
        assertEquals(expResult, result);
    }
    
        /**
     * Test of hashCode method, of class Category.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Category instance = new Category("100", "descricao");
        int expResult = 48786;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Category.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Category("100", "descricao");
        Category instance = new Category("100", "descricao");
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Category.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object o = new Category("100", "descricao");
        Category instance = (Category) o;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Category.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Category instance = new Category("100", "descricao");
        String expResult = "100 - descricao ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_strID method, of class Category.
     */
    @org.junit.Test
    public void testGetM_strID() {
        System.out.println("getM_strID");
        Category instance = new Category("cat1", "limpeza geral");
        String expResult = "cat1";
        String result = instance.getM_strID();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getM_strID method, of class Category.
     */
    @org.junit.Test
    public void testGetM_strID2() {
        System.out.println("getM_strID");
        Category instance = new Category(null, "limpeza geral");
        String expResult = null;
        String result = instance.getM_strID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_strDescription method, of class Category.
     */
    @org.junit.Test
    public void testGetM_strDescription() {
        System.out.println("getM_strDescription");
        Category instance = new Category("cat1", "limpeza geral");
        String expResult = "limpeza geral";
        String result = instance.getM_strDescription();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getM_strDescription method, of class Category.
     */
    @org.junit.Test
    public void testGetM_strDescription2() {
        System.out.println("getM_strDescription");
        Category instance = new Category("cat1", null);
        String expResult = null;
        String result = instance.getM_strDescription();
        assertEquals(expResult, result);
    }
    
}
