/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

import java.time.LocalDate;
import java.util.Vector;

/**
 *
 * @author cameron
 */
public class GlobalVariables {
    public Farm currentFarm = new Farm();
    public Vector<CropType> cropNames = new Vector<CropType>();
    public Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
    
    public GlobalVariables() 
    {
        GPS loc1 = new GPS(10.4f, 3.6f);
        GPS loc2 = new GPS(20.2f, 3.6f);
        GPS loc3 = new GPS(20.2f, 12.9f);
        GPS loc4 = new GPS(10.4f, 12.9f);
        
        GPSBoundary gpsB1 = new GPSBoundary();
        gpsB1.addBoundary(loc1);
        gpsB1.addBoundary(loc2);
        gpsB1.addBoundary(loc3);
        gpsB1.addBoundary(loc4);
        
        //CropType (String theCropType, float theAverageYield, int averageGrowTime)
        CropType carrots = new CropType("Carrots", 10.5f, 40);
        cropNames.addElement(carrots);
        CropType donuts = new CropType("Donuts", 1.3f, 1);
        cropNames.addElement(donuts);        
        CropType lemons = new CropType("Lemons", 50f, 60);
        cropNames.addElement(lemons);
        CropType apples = new CropType("Apples", 100f, 100);
        cropNames.addElement(apples);
        
        // SensorSettings
        SensorTypes rainFall = new SensorTypes(1.5f, true, true, "Rain Fall", "mm");
        sensorTypes.addElement(rainFall);
        SensorTypes sunshine = new SensorTypes(1.5f, true, true, "Sunshine", "mm");
        sensorTypes.addElement(sunshine);
        SensorTypes nutrientSaturation = new SensorTypes(1.5f, true, true, "Nutrient Saturation", "mm");
        sensorTypes.addElement(nutrientSaturation);
        SensorTypes temperature = new SensorTypes(1.5f, true, true, "Temperature", "f");
        sensorTypes.addElement(temperature);
        
        //Date d = new Date("10/02/2016");
        LocalDate date1 = LocalDate.parse("2016-02-10");
        LocalDate date2 = LocalDate.parse("2017-06-29");
        //LocalDate date1 = LocalDate.parse("15-06-2016");
        //LocalDate date2 = LocalDate.parse("29-08-2017");
        
        Field field1 = new Field("Field 1", gpsB1);
        Field field2 = new Field("Field 2", gpsB1);
        Field field3 = new Field("Field 3", gpsB1);
        
        //Crop(CropType theCropType, LocalDate thePlantDate, int fieldSizeInM)
        //Evetually change last number to be field1.size() or whatever
        Crop crop1 = new Crop(donuts, date1, 54);
        field1.newCrop(crop1);
        Crop crop2 = new Crop(lemons, date2, 120);
        field2.newCrop(crop2);
        
        currentFarm.addField(field1);
        currentFarm.addField(field2);
        currentFarm.addField(field3);
        Crop crop3 = new Crop(apples, date1, 3);
        currentFarm.get(currentFarm.getFieldIndex("Field 3")).newCrop(crop3);
    }
}