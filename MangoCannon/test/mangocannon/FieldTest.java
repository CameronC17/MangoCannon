/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
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
public class FieldTest {
    
   
     
    public FieldTest() {
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
     * Test of getFieldName method, of class Field.
     */
    @Test
    public void testGetFieldName() {
        System.out.println("getFieldName");
        
        GPS loc1 = new GPS(10, 10);
        GPS loc2 = new GPS(50, 10);
        GPS loc3 = new GPS(10, 50);
        GPS loc4 = new GPS(50, 50);
        GPSBoundary gpsB1 = new GPSBoundary();
        gpsB1.createBoundary(loc1, loc2, loc3, loc4);
        Field field1 = new Field("Field 1", gpsB1);
        float[] floats1 = {1.1f, 2.8f, 3.5f, 1.2f, 5.2f, 1.1f, 0.1f};
        float[] floats2 = {50.6f, 32.2f, 23.2f, 22.0f, 19.2f, 18.8f, 14.3f};
        float[] floats3 = {102.6f, 100.1f, 99.5f, 90.4f, 88.8f, 84.5f, 77.6f};
        float[] floats4 = {0.60f, 0.65f, 0.66f, 0.65f, 0.69f, 0.71f, 0.74f};
        SensorTypes rainFall = new SensorTypes("Rain Fall", "mm", 600);
        SensorTypes sunshine = new SensorTypes("Sunshine", "mm", 60);
        SensorTypes nutrientSaturation = new SensorTypes("Nutrient Saturation", "mm", 6000);
        SensorTypes temperature = new SensorTypes("Temperature", "f", 300);
        Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
        sensorTypes.add(sunshine);
        sensorTypes.add(rainFall);
        sensorTypes.add(nutrientSaturation);
        sensorTypes.add(temperature);
        DataReading readings1 = new DataReading(floats1);
        DataReading readings2 = new DataReading(floats2);
        DataReading readings3 = new DataReading(floats3);
        DataReading readings4 = new DataReading(floats4);
        Vector<Sensor> sensorList1 = new Vector<Sensor>();
        GPS loc5 = new GPS(870, 70);        
        GPS loc6 = new GPS(900, 70);
        GPS loc7 = new GPS(870, 100);
        GPS loc8 = new GPS(900, 100);
        Sensor rainFallSensor = new Sensor(rainFall, readings1, loc3);
        Sensor sunshineSensor = new Sensor(sunshine, readings2, loc5);
        Sensor nutrientSaturationSensor = new Sensor(nutrientSaturation, readings3, loc6);
        Sensor temperatureSensor = new Sensor(temperature, readings4, loc7);
        sensorList1.add(rainFallSensor);
        sensorList1.add(sunshineSensor);
        sensorList1.add(nutrientSaturationSensor);
        sensorList1.add(temperatureSensor);
        FieldStation fieldStation1 = new FieldStation(sensorList1, "Field Station 1", field1.getGPSBoundary().getCentre());
        
        Field instance = field1;
        String expResult = "Field 1";
        String result = instance.getFieldName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFieldName method, of class Field.
     */
    @Test
    public void testSetFieldName() {
        System.out.println("setFieldName");
        String theName = "Field 1";
        GPS loc1 = new GPS(10, 10);
        GPS loc2 = new GPS(50, 10);
        GPS loc3 = new GPS(10, 50);
        GPS loc4 = new GPS(50, 50);
        GPSBoundary gpsB1 = new GPSBoundary();
        gpsB1.createBoundary(loc1, loc2, loc3, loc4);
        Field field1 = new Field("Field 1", gpsB1);
        float[] floats1 = {1.1f, 2.8f, 3.5f, 1.2f, 5.2f, 1.1f, 0.1f};
        float[] floats2 = {50.6f, 32.2f, 23.2f, 22.0f, 19.2f, 18.8f, 14.3f};
        float[] floats3 = {102.6f, 100.1f, 99.5f, 90.4f, 88.8f, 84.5f, 77.6f};
        float[] floats4 = {0.60f, 0.65f, 0.66f, 0.65f, 0.69f, 0.71f, 0.74f};
        SensorTypes rainFall = new SensorTypes("Rain Fall", "mm", 600);
        SensorTypes sunshine = new SensorTypes("Sunshine", "mm", 60);
        SensorTypes nutrientSaturation = new SensorTypes("Nutrient Saturation", "mm", 6000);
        SensorTypes temperature = new SensorTypes("Temperature", "f", 300);
        Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
        sensorTypes.add(sunshine);
        sensorTypes.add(rainFall);
        sensorTypes.add(nutrientSaturation);
        sensorTypes.add(temperature);
        DataReading readings1 = new DataReading(floats1);
        DataReading readings2 = new DataReading(floats2);
        DataReading readings3 = new DataReading(floats3);
        DataReading readings4 = new DataReading(floats4);
        Vector<Sensor> sensorList1 = new Vector<Sensor>();
        GPS loc5 = new GPS(870, 70);        
        GPS loc6 = new GPS(900, 70);
        GPS loc7 = new GPS(870, 100);
        GPS loc8 = new GPS(900, 100);
        Sensor rainFallSensor = new Sensor(rainFall, readings1, loc3);
        Sensor sunshineSensor = new Sensor(sunshine, readings2, loc5);
        Sensor nutrientSaturationSensor = new Sensor(nutrientSaturation, readings3, loc6);
        Sensor temperatureSensor = new Sensor(temperature, readings4, loc7);
        sensorList1.add(rainFallSensor);
        sensorList1.add(sunshineSensor);
        sensorList1.add(nutrientSaturationSensor);
        sensorList1.add(temperatureSensor);
        FieldStation fieldStation1 = new FieldStation(sensorList1, "Field Station 1", field1.getGPSBoundary().getCentre());
        
        Field instance = field1;
        instance.setFieldName(theName);
    }

    /**
     * Test of newCrop method, of class Field.
     */
    @Test
    public void testNewCrop() {
        System.out.println("newCrop");
        GPS loc1 = new GPS(10, 10);
        GPS loc2 = new GPS(50, 10);
        GPS loc3 = new GPS(10, 50);
        GPS loc4 = new GPS(50, 50);
        GPSBoundary gpsB1 = new GPSBoundary();
        gpsB1.createBoundary(loc1, loc2, loc3, loc4);
        Field field1 = new Field("Field 1", gpsB1);
        float[] floats1 = {1.1f, 2.8f, 3.5f, 1.2f, 5.2f, 1.1f, 0.1f};
        float[] floats2 = {50.6f, 32.2f, 23.2f, 22.0f, 19.2f, 18.8f, 14.3f};
        float[] floats3 = {102.6f, 100.1f, 99.5f, 90.4f, 88.8f, 84.5f, 77.6f};
        float[] floats4 = {0.60f, 0.65f, 0.66f, 0.65f, 0.69f, 0.71f, 0.74f};
        SensorTypes rainFall = new SensorTypes("Rain Fall", "mm", 600);
        SensorTypes sunshine = new SensorTypes("Sunshine", "mm", 60);
        SensorTypes nutrientSaturation = new SensorTypes("Nutrient Saturation", "mm", 6000);
        SensorTypes temperature = new SensorTypes("Temperature", "f", 300);
        Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
        sensorTypes.add(sunshine);
        sensorTypes.add(rainFall);
        sensorTypes.add(nutrientSaturation);
        sensorTypes.add(temperature);
        DataReading readings1 = new DataReading(floats1);
        DataReading readings2 = new DataReading(floats2);
        DataReading readings3 = new DataReading(floats3);
        DataReading readings4 = new DataReading(floats4);
        Vector<Sensor> sensorList1 = new Vector<Sensor>();
        GPS loc5 = new GPS(870, 70);        
        GPS loc6 = new GPS(900, 70);
        GPS loc7 = new GPS(870, 100);
        GPS loc8 = new GPS(900, 100);
        Sensor rainFallSensor = new Sensor(rainFall, readings1, loc3);
        Sensor sunshineSensor = new Sensor(sunshine, readings2, loc5);
        Sensor nutrientSaturationSensor = new Sensor(nutrientSaturation, readings3, loc6);
        Sensor temperatureSensor = new Sensor(temperature, readings4, loc7);
        sensorList1.add(rainFallSensor);
        sensorList1.add(sunshineSensor);
        sensorList1.add(nutrientSaturationSensor);
        sensorList1.add(temperatureSensor);
        FieldStation fieldStation1 = new FieldStation(sensorList1, "Field Station 1", field1.getGPSBoundary().getCentre());

        CropType carrots = new CropType("Carrots", 10.5f, 40);
        
        LocalDate date1 = LocalDate.parse("2016-02-10");

        Crop crop1 = new Crop(carrots, date1, 54);
        field1.newCrop(crop1);
        Field instance = field1;
        Crop theCrop = crop1;
        instance.newCrop(theCrop);
    }

    /**
     * Test of getCrop method, of class Field.
     */
    @Test
    public void testGetCrop() {
        System.out.println("getCrop");
        GPS loc1 = new GPS(10, 10);
        GPS loc2 = new GPS(50, 10);
        GPS loc3 = new GPS(10, 50);
        GPS loc4 = new GPS(50, 50);
        GPSBoundary gpsB1 = new GPSBoundary();
        gpsB1.createBoundary(loc1, loc2, loc3, loc4);
        Field field1 = new Field("Field 1", gpsB1);
        float[] floats1 = {1.1f, 2.8f, 3.5f, 1.2f, 5.2f, 1.1f, 0.1f};
        float[] floats2 = {50.6f, 32.2f, 23.2f, 22.0f, 19.2f, 18.8f, 14.3f};
        float[] floats3 = {102.6f, 100.1f, 99.5f, 90.4f, 88.8f, 84.5f, 77.6f};
        float[] floats4 = {0.60f, 0.65f, 0.66f, 0.65f, 0.69f, 0.71f, 0.74f};
        SensorTypes rainFall = new SensorTypes("Rain Fall", "mm", 600);
        SensorTypes sunshine = new SensorTypes("Sunshine", "mm", 60);
        SensorTypes nutrientSaturation = new SensorTypes("Nutrient Saturation", "mm", 6000);
        SensorTypes temperature = new SensorTypes("Temperature", "f", 300);
        Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
        sensorTypes.add(sunshine);
        sensorTypes.add(rainFall);
        sensorTypes.add(nutrientSaturation);
        sensorTypes.add(temperature);
        DataReading readings1 = new DataReading(floats1);
        DataReading readings2 = new DataReading(floats2);
        DataReading readings3 = new DataReading(floats3);
        DataReading readings4 = new DataReading(floats4);
        Vector<Sensor> sensorList1 = new Vector<Sensor>();
        GPS loc5 = new GPS(870, 70);        
        GPS loc6 = new GPS(900, 70);
        GPS loc7 = new GPS(870, 100);
        GPS loc8 = new GPS(900, 100);
        Sensor rainFallSensor = new Sensor(rainFall, readings1, loc3);
        Sensor sunshineSensor = new Sensor(sunshine, readings2, loc5);
        Sensor nutrientSaturationSensor = new Sensor(nutrientSaturation, readings3, loc6);
        Sensor temperatureSensor = new Sensor(temperature, readings4, loc7);
        sensorList1.add(rainFallSensor);
        sensorList1.add(sunshineSensor);
        sensorList1.add(nutrientSaturationSensor);
        sensorList1.add(temperatureSensor);
        FieldStation fieldStation1 = new FieldStation(sensorList1, "Field Station 1", field1.getGPSBoundary().getCentre());

        CropType carrots = new CropType("Carrots", 10.5f, 40);
        
        LocalDate date1 = LocalDate.parse("2016-02-10");

        Crop crop1 = new Crop(carrots, date1, 54);
        field1.newCrop(crop1);
        Field instance = field1;
        Crop expResult = crop1;
        Crop result = instance.getCrop();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBoundaries method, of class Field.
     */
    @Test
    public void testGetBoundaries() {
        System.out.println("getBoundaries");
        GPS loc1 = new GPS(10, 10);
        GPS loc2 = new GPS(50, 10);
        GPS loc3 = new GPS(10, 50);
        GPS loc4 = new GPS(50, 50);
        GPSBoundary gpsB1 = new GPSBoundary();
        gpsB1.createBoundary(loc1, loc2, loc3, loc4);
        Field field1 = new Field("Field 1", gpsB1);
        float[] floats1 = {1.1f, 2.8f, 3.5f, 1.2f, 5.2f, 1.1f, 0.1f};
        float[] floats2 = {50.6f, 32.2f, 23.2f, 22.0f, 19.2f, 18.8f, 14.3f};
        float[] floats3 = {102.6f, 100.1f, 99.5f, 90.4f, 88.8f, 84.5f, 77.6f};
        float[] floats4 = {0.60f, 0.65f, 0.66f, 0.65f, 0.69f, 0.71f, 0.74f};
        SensorTypes rainFall = new SensorTypes("Rain Fall", "mm", 600);
        SensorTypes sunshine = new SensorTypes("Sunshine", "mm", 60);
        SensorTypes nutrientSaturation = new SensorTypes("Nutrient Saturation", "mm", 6000);
        SensorTypes temperature = new SensorTypes("Temperature", "f", 300);
        Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
        sensorTypes.add(sunshine);
        sensorTypes.add(rainFall);
        sensorTypes.add(nutrientSaturation);
        sensorTypes.add(temperature);
        DataReading readings1 = new DataReading(floats1);
        DataReading readings2 = new DataReading(floats2);
        DataReading readings3 = new DataReading(floats3);
        DataReading readings4 = new DataReading(floats4);
        Vector<Sensor> sensorList1 = new Vector<Sensor>();
        GPS loc5 = new GPS(870, 70);        
        GPS loc6 = new GPS(900, 70);
        GPS loc7 = new GPS(870, 100);
        GPS loc8 = new GPS(900, 100);
        Sensor rainFallSensor = new Sensor(rainFall, readings1, loc3);
        Sensor sunshineSensor = new Sensor(sunshine, readings2, loc5);
        Sensor nutrientSaturationSensor = new Sensor(nutrientSaturation, readings3, loc6);
        Sensor temperatureSensor = new Sensor(temperature, readings4, loc7);
        sensorList1.add(rainFallSensor);
        sensorList1.add(sunshineSensor);
        sensorList1.add(nutrientSaturationSensor);
        sensorList1.add(temperatureSensor);
        FieldStation fieldStation1 = new FieldStation(sensorList1, "Field Station 1", field1.getGPSBoundary().getCentre());

        CropType carrots = new CropType("Carrots", 10.5f, 40);
        
        LocalDate date1 = LocalDate.parse("2016-02-10");

        Crop crop1 = new Crop(carrots, date1, 54);
        field1.newCrop(crop1);
        Field instance = field1;
        List<GPS> gpsList = new ArrayList<GPS>();
        
        
        gpsList.add(new GPS(10, 10));
        gpsList.add(new GPS(50, 10));
        gpsList.add(new GPS(10, 50));
        gpsList.add(new GPS(50, 50));

        List<GPS> expResult = gpsB1.getBoundary();
        List<GPS> result = instance.getBoundaries();
        assertEquals(expResult, result);
    }


    /**
     * Test of size method, of class Field.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        GPS loc1 = new GPS(10, 10);
        GPS loc2 = new GPS(50, 10);
        GPS loc3 = new GPS(10, 50);
        GPS loc4 = new GPS(50, 50);
        GPSBoundary gpsB1 = new GPSBoundary();
        gpsB1.createBoundary(loc1, loc2, loc3, loc4);
        Field field1 = new Field("Field 1", gpsB1);
        float[] floats1 = {1.1f, 2.8f, 3.5f, 1.2f, 5.2f, 1.1f, 0.1f};
        float[] floats2 = {50.6f, 32.2f, 23.2f, 22.0f, 19.2f, 18.8f, 14.3f};
        float[] floats3 = {102.6f, 100.1f, 99.5f, 90.4f, 88.8f, 84.5f, 77.6f};
        float[] floats4 = {0.60f, 0.65f, 0.66f, 0.65f, 0.69f, 0.71f, 0.74f};
        SensorTypes rainFall = new SensorTypes("Rain Fall", "mm", 600);
        SensorTypes sunshine = new SensorTypes("Sunshine", "mm", 60);
        SensorTypes nutrientSaturation = new SensorTypes("Nutrient Saturation", "mm", 6000);
        SensorTypes temperature = new SensorTypes("Temperature", "f", 300);
        Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
        sensorTypes.add(sunshine);
        sensorTypes.add(rainFall);
        sensorTypes.add(nutrientSaturation);
        sensorTypes.add(temperature);
        DataReading readings1 = new DataReading(floats1);
        DataReading readings2 = new DataReading(floats2);
        DataReading readings3 = new DataReading(floats3);
        DataReading readings4 = new DataReading(floats4);
        Vector<Sensor> sensorList1 = new Vector<Sensor>();
        GPS loc5 = new GPS(870, 70);        
        GPS loc6 = new GPS(900, 70);
        GPS loc7 = new GPS(870, 100);
        GPS loc8 = new GPS(900, 100);
        Sensor rainFallSensor = new Sensor(rainFall, readings1, loc3);
        Sensor sunshineSensor = new Sensor(sunshine, readings2, loc5);
        Sensor nutrientSaturationSensor = new Sensor(nutrientSaturation, readings3, loc6);
        Sensor temperatureSensor = new Sensor(temperature, readings4, loc7);
        sensorList1.add(rainFallSensor);
        sensorList1.add(sunshineSensor);
        sensorList1.add(nutrientSaturationSensor);
        sensorList1.add(temperatureSensor);
        FieldStation fieldStation1 = new FieldStation(sensorList1, "Field Station 1", field1.getGPSBoundary().getCentre());

        CropType carrots = new CropType("Carrots", 10.5f, 40);
        
        LocalDate date1 = LocalDate.parse("2016-02-10");

        Crop crop1 = new Crop(carrots, date1, 54);
        field1.newCrop(crop1);
        Field instance = field1;
        float expResult = 1600.0F;
        float result = instance.size();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getFieldStation method, of class Field.
     */
    @Test
    public void testGetFieldStation() {
        System.out.println("getFieldStation");
        GPS loc1 = new GPS(10, 10);
        GPS loc2 = new GPS(50, 10);
        GPS loc3 = new GPS(10, 50);
        GPS loc4 = new GPS(50, 50);
        GPSBoundary gpsB1 = new GPSBoundary();
        gpsB1.createBoundary(loc1, loc2, loc3, loc4);
        Field field1 = new Field("Field 1", gpsB1);
        float[] floats1 = {1.1f, 2.8f, 3.5f, 1.2f, 5.2f, 1.1f, 0.1f};
        float[] floats2 = {50.6f, 32.2f, 23.2f, 22.0f, 19.2f, 18.8f, 14.3f};
        float[] floats3 = {102.6f, 100.1f, 99.5f, 90.4f, 88.8f, 84.5f, 77.6f};
        float[] floats4 = {0.60f, 0.65f, 0.66f, 0.65f, 0.69f, 0.71f, 0.74f};
        SensorTypes rainFall = new SensorTypes("Rain Fall", "mm", 600);
        SensorTypes sunshine = new SensorTypes("Sunshine", "mm", 60);
        SensorTypes nutrientSaturation = new SensorTypes("Nutrient Saturation", "mm", 6000);
        SensorTypes temperature = new SensorTypes("Temperature", "f", 300);
        Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
        sensorTypes.add(sunshine);
        sensorTypes.add(rainFall);
        sensorTypes.add(nutrientSaturation);
        sensorTypes.add(temperature);
        DataReading readings1 = new DataReading(floats1);
        DataReading readings2 = new DataReading(floats2);
        DataReading readings3 = new DataReading(floats3);
        DataReading readings4 = new DataReading(floats4);
        Vector<Sensor> sensorList1 = new Vector<Sensor>();
        GPS loc5 = new GPS(870, 70);        
        GPS loc6 = new GPS(900, 70);
        GPS loc7 = new GPS(870, 100);
        GPS loc8 = new GPS(900, 100);
        Sensor rainFallSensor = new Sensor(rainFall, readings1, loc3);
        Sensor sunshineSensor = new Sensor(sunshine, readings2, loc5);
        Sensor nutrientSaturationSensor = new Sensor(nutrientSaturation, readings3, loc6);
        Sensor temperatureSensor = new Sensor(temperature, readings4, loc7);
        sensorList1.add(rainFallSensor);
        sensorList1.add(sunshineSensor);
        sensorList1.add(nutrientSaturationSensor);
        sensorList1.add(temperatureSensor);
        FieldStation fieldStation1 = new FieldStation(sensorList1, "Field Station 1", field1.getGPSBoundary().getCentre());

        CropType carrots = new CropType("Carrots", 10.5f, 40);
        
        LocalDate date1 = LocalDate.parse("2016-02-10");

        field1.setFieldStation(fieldStation1);
        Crop crop1 = new Crop(carrots, date1, 54);
        field1.newCrop(crop1);
        Field instance = field1;
        FieldStation expResult = fieldStation1;
        FieldStation result = instance.getFieldStation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFieldStation method, of class Field.
     */
    @Test
    public void testSetFieldStation() {
        System.out.println("setFieldStation");
        GPS loc1 = new GPS(10, 10);
        GPS loc2 = new GPS(50, 10);
        GPS loc3 = new GPS(10, 50);
        GPS loc4 = new GPS(50, 50);
        GPSBoundary gpsB1 = new GPSBoundary();
        gpsB1.createBoundary(loc1, loc2, loc3, loc4);
        float[] floats1 = {1.1f, 2.8f, 3.5f, 1.2f, 5.2f, 1.1f, 0.1f};
        float[] floats2 = {50.6f, 32.2f, 23.2f, 22.0f, 19.2f, 18.8f, 14.3f};
        float[] floats3 = {102.6f, 100.1f, 99.5f, 90.4f, 88.8f, 84.5f, 77.6f};
        float[] floats4 = {0.60f, 0.65f, 0.66f, 0.65f, 0.69f, 0.71f, 0.74f};
        SensorTypes rainFall = new SensorTypes("Rain Fall", "mm", 600);
        SensorTypes sunshine = new SensorTypes("Sunshine", "mm", 60);
        SensorTypes nutrientSaturation = new SensorTypes("Nutrient Saturation", "mm", 6000);
        SensorTypes temperature = new SensorTypes("Temperature", "f", 300);
        Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
        sensorTypes.add(sunshine);
        sensorTypes.add(rainFall);
        sensorTypes.add(nutrientSaturation);
        sensorTypes.add(temperature);
        DataReading readings1 = new DataReading(floats1);
        DataReading readings2 = new DataReading(floats2);
        DataReading readings3 = new DataReading(floats3);
        DataReading readings4 = new DataReading(floats4);
        Vector<Sensor> sensorList1 = new Vector<Sensor>();
        GPS loc5 = new GPS(870, 70);        
        GPS loc6 = new GPS(900, 70);
        GPS loc7 = new GPS(870, 100);
        GPS loc8 = new GPS(900, 100);
        Sensor rainFallSensor = new Sensor(rainFall, readings1, loc3);
        Sensor sunshineSensor = new Sensor(sunshine, readings2, loc5);
        Sensor nutrientSaturationSensor = new Sensor(nutrientSaturation, readings3, loc6);
        Sensor temperatureSensor = new Sensor(temperature, readings4, loc7);
        sensorList1.add(rainFallSensor);
        sensorList1.add(sunshineSensor);
        sensorList1.add(nutrientSaturationSensor);
        sensorList1.add(temperatureSensor);

        CropType carrots = new CropType("Carrots", 10.5f, 40);
        
        LocalDate date1 = LocalDate.parse("2016-02-10");

        Crop crop1 = new Crop(carrots, date1, 54);
        Field instance = new Field("Field 1", gpsB1);

        instance.newCrop(crop1);

        FieldStation theFS = new FieldStation(sensorList1, "Field Station 1", instance.getGPSBoundary().getCentre());
        instance.setFieldStation(theFS);

        instance.setFieldStation(theFS);
    }

    /**
     * Test of getGPSBoundary method, of class Field.
     */
    @Test
    public void testGetGPSBoundary() {
        System.out.println("getGPSBoundary");
        GPS loc1 = new GPS(10, 10);
        GPS loc2 = new GPS(50, 10);
        GPS loc3 = new GPS(10, 50);
        GPS loc4 = new GPS(50, 50);
        
        float[] floats1 = {1.1f, 2.8f, 3.5f, 1.2f, 5.2f, 1.1f, 0.1f};
        float[] floats2 = {50.6f, 32.2f, 23.2f, 22.0f, 19.2f, 18.8f, 14.3f};
        float[] floats3 = {102.6f, 100.1f, 99.5f, 90.4f, 88.8f, 84.5f, 77.6f};
        float[] floats4 = {0.60f, 0.65f, 0.66f, 0.65f, 0.69f, 0.71f, 0.74f};
        SensorTypes rainFall = new SensorTypes("Rain Fall", "mm", 600);
        SensorTypes sunshine = new SensorTypes("Sunshine", "mm", 60);
        SensorTypes nutrientSaturation = new SensorTypes("Nutrient Saturation", "mm", 6000);
        SensorTypes temperature = new SensorTypes("Temperature", "f", 300);
        Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
        sensorTypes.add(sunshine);
        sensorTypes.add(rainFall);
        sensorTypes.add(nutrientSaturation);
        sensorTypes.add(temperature);
        DataReading readings1 = new DataReading(floats1);
        DataReading readings2 = new DataReading(floats2);
        DataReading readings3 = new DataReading(floats3);
        DataReading readings4 = new DataReading(floats4);
        Vector<Sensor> sensorList1 = new Vector<Sensor>();
        GPS loc5 = new GPS(870, 70);        
        GPS loc6 = new GPS(900, 70);
        GPS loc7 = new GPS(870, 100);
        GPS loc8 = new GPS(900, 100);
        Sensor rainFallSensor = new Sensor(rainFall, readings1, loc3);
        Sensor sunshineSensor = new Sensor(sunshine, readings2, loc5);
        Sensor nutrientSaturationSensor = new Sensor(nutrientSaturation, readings3, loc6);
        Sensor temperatureSensor = new Sensor(temperature, readings4, loc7);
        sensorList1.add(rainFallSensor);
        sensorList1.add(sunshineSensor);
        sensorList1.add(nutrientSaturationSensor);
        sensorList1.add(temperatureSensor);

        CropType carrots = new CropType("Carrots", 10.5f, 40);
        
        LocalDate date1 = LocalDate.parse("2016-02-10");

        Crop crop1 = new Crop(carrots, date1, 54);
        GPSBoundary expResult = new GPSBoundary();;
        expResult.createBoundary(loc1, loc2, loc3, loc4);
        Field instance = new Field("Field 1", expResult);
        
        GPSBoundary result = instance.getGPSBoundary();
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Field.
     */
    @Test
    public void testIsInside() {
        System.out.println("isInside");
        GPS theGPS = new GPS(10, 10);

        GPS loc2 = new GPS(50, 10);
        GPS loc3 = new GPS(10, 50);
        GPS loc4 = new GPS(50, 50);
        GPSBoundary gpsB1 = new GPSBoundary();
        gpsB1.createBoundary(theGPS, loc2, loc3, loc4);
        Field field1 = new Field("Field 1", gpsB1);
        float[] floats1 = {1.1f, 2.8f, 3.5f, 1.2f, 5.2f, 1.1f, 0.1f};
        float[] floats2 = {50.6f, 32.2f, 23.2f, 22.0f, 19.2f, 18.8f, 14.3f};
        float[] floats3 = {102.6f, 100.1f, 99.5f, 90.4f, 88.8f, 84.5f, 77.6f};
        float[] floats4 = {0.60f, 0.65f, 0.66f, 0.65f, 0.69f, 0.71f, 0.74f};
        SensorTypes rainFall = new SensorTypes("Rain Fall", "mm", 600);
        SensorTypes sunshine = new SensorTypes("Sunshine", "mm", 60);
        SensorTypes nutrientSaturation = new SensorTypes("Nutrient Saturation", "mm", 6000);
        SensorTypes temperature = new SensorTypes("Temperature", "f", 300);
        Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
        sensorTypes.add(sunshine);
        sensorTypes.add(rainFall);
        sensorTypes.add(nutrientSaturation);
        sensorTypes.add(temperature);
        DataReading readings1 = new DataReading(floats1);
        DataReading readings2 = new DataReading(floats2);
        DataReading readings3 = new DataReading(floats3);
        DataReading readings4 = new DataReading(floats4);
        Vector<Sensor> sensorList1 = new Vector<Sensor>();
        GPS loc5 = new GPS(870, 70);        
        GPS loc6 = new GPS(900, 70);
        GPS loc7 = new GPS(870, 100);
        GPS loc8 = new GPS(900, 100);
        Sensor rainFallSensor = new Sensor(rainFall, readings1, loc3);
        Sensor sunshineSensor = new Sensor(sunshine, readings2, loc5);
        Sensor nutrientSaturationSensor = new Sensor(nutrientSaturation, readings3, loc6);
        Sensor temperatureSensor = new Sensor(temperature, readings4, loc7);
        sensorList1.add(rainFallSensor);
        sensorList1.add(sunshineSensor);
        sensorList1.add(nutrientSaturationSensor);
        sensorList1.add(temperatureSensor);
        FieldStation fieldStation1 = new FieldStation(sensorList1, "Field Station 1", field1.getGPSBoundary().getCentre());

        CropType carrots = new CropType("Carrots", 10.5f, 40);
        
        LocalDate date1 = LocalDate.parse("2016-02-10");

        Crop crop1 = new Crop(carrots, date1, 54);
        field1.newCrop(crop1);
        Field instance = field1;
        boolean expResult = true;
        boolean result = instance.isInside(theGPS);
        assertEquals(expResult, result);
    }
    
}
