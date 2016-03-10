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
public class CropTypeTest {
    
    public CropTypeTest() {
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
     * Test of getCropName method, of class CropType.
     * CropType (String theCropType, float theAverageYield, int averageGrowTime)
     */
    @Test
    public void testGetCropName() {
        System.out.println("getCropName");
        CropType instance = new CropType("Moistness", 12.6f, 4);
        String expResult = "Moistness";
        String result = instance.getCropName();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of getAverageYield method, of class CropType.
     */
    @Test
    public void testGetAverageYield() {
        System.out.println("getAverageYield");
        CropType instance = new CropType("Moistness", 12.6f, 4);
        float expResult = 12.6F;
        float result = instance.getAverageYield();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAverageYield method, of class CropType.
     */
    @Test
    public void testSetAverageYield() {
        System.out.println("setAverageYield");
        float theEstimatedYield = 12.6F;
        CropType instance = new CropType("Moistness", 12.6f, 4);
        instance.setAverageYield(theEstimatedYield);
    }

    /**
     * Test of getAverageGrowTime method, of class CropType.
     */
    @Test
    public void testGetAverageGrowTime() {
        System.out.println("getAverageGrowTime");
        CropType instance = new CropType("Moistness", 12.6f, 4);
        int expResult = 4;
        int result = instance.getAverageGrowTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAverageGrowTime method, of class CropType.
     */
    @Test
    public void testSetAverageGrowTime() {
        System.out.println("setAverageGrowTime");
        int theExpectedHarvest = 4;
        CropType instance = new CropType("Moistness", 12.6f, 4);
        instance.setAverageGrowTime(theExpectedHarvest);
    }
    
}
