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
 * @author cameron
 */
public class CreateSensorGUITest {
    
    public CreateSensorGUITest() {
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
     * Test of setGlobalVars method, of class CreateSensorGUI.
     */
    @Test
    public void testSetGlobalVars() {
        System.out.println("setGlobalVars");
        GlobalVariables usingVar = null;
        CreateSensorGUI instance = new CreateSensorGUI();
        instance.setGlobalVars(usingVar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CreateSensorGUI.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CreateSensorGUI.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
