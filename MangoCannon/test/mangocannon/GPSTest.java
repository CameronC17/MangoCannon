/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacobburns
 */
public class GPSTest {
    
    public GPSTest() {
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
     * Test of getGlobalPosition method, of class GPS.
     */
    @Test
    public void testGetGlobalPosition() {
        System.out.println("getGlobalPosition");
        GPS instance = new GPS(10, 10);
        
        int[] expResult = {10, 10};
        int[] result = instance.getGlobalPosition();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setGlobalPosition method, of class GPS.
     */
    @Test
    public void testSetGlobalPosition() {
        System.out.println("setGlobalPosition");
        int theX = 10;
        int theY = 10;
        GPS instance = new GPS(10, 10);
        instance.setGlobalPosition(theX, theY);
    }
    
}
