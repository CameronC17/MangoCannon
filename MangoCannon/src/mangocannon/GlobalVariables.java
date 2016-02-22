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
    public Vector<CropType> cropTypes = new Vector<CropType>();
    public Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
    public Vector<User> user = new Vector<User>();

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
        CropType donuts = new CropType("Donuts", 1.3f, 1);        
        CropType lemons = new CropType("Lemons", 50f, 60);
        CropType apples = new CropType("Apples", 100f, 100); 
        cropTypes.addElement(carrots);
        cropTypes.addElement(donuts);        
        cropTypes.addElement(lemons);
        cropTypes.addElement(apples);
        

        // SensorSettings
        SensorTypes rainFall = new SensorTypes(1.5f, true, true, "Rain Fall", "mm");
        SensorTypes sunshine = new SensorTypes(1.5f, true, true, "Sunshine", "mm");
        SensorTypes nutrientSaturation = new SensorTypes(1.5f, true, true, "Nutrient Saturation", "mm");
        SensorTypes temperature = new SensorTypes(1.5f, true, true, "Temperature", "f");
        sensorTypes.addElement(sunshine);
        sensorTypes.addElement(nutrientSaturation);        
        sensorTypes.addElement(rainFall);
        sensorTypes.addElement(temperature);
        
        //DataReadings Data
        float[] floats1 = {1.1f, 2.8f, 3.5f, 1.2f, 5.2f, 1.1f, 0.1f};
        float[] floats2 = {50.6f, 32.2f, 23.2f, 22.0f, 19.2f, 18.8f, 14.3f};
        float[] floats3 = {102.6f, 100.1f, 99.5f, 90.4f, 88.8f, 84.5f, 77.6f};
        float[] floats4 = {0.60f, 0.65f, 0.66f, 0.65f, 0.69f, 0.71f, 0.74f};
        DataReading readings1 = new DataReading(floats1);
        DataReading readings2 = new DataReading(floats2);
        DataReading readings3 = new DataReading(floats3);
        DataReading readings4 = new DataReading(floats4);
        
        //User credentials
        User user1 = new User("Carlos", "Rodriguez", "carlosr", 5312, 2, "carlos_rodriguez");
        User user2 = new User("Sara", "Ackincacker", "saraa", 5142, 1, "sara_ackicakcer");
        User user3 = new User("John", "Smith", "johns", 5332, 2, "john_smith");

        
        //Sensors
        Sensor rainFallSensor = new Sensor(null, sensorTypes.get(0), 001, readings1);
        Sensor sunshineSensor = new Sensor(null, sensorTypes.get(1), 002, readings2);
        Sensor nutrientSaturationSensor = new Sensor(null, sensorTypes.get(2), 003, readings3);
        Sensor temperatureSensor = new Sensor(null, sensorTypes.get(3), 004, readings4);
        
        //SensorList
        Sensor[] sensorList1 = {rainFallSensor, sunshineSensor, nutrientSaturationSensor, temperatureSensor};
        
        FieldStation fieldStation1 = new FieldStation(sensorList1, "Field Station 1", 001, loc1);
//        FieldStation fieldStation1 = new FieldStation(sensorList1, 'Field Station 1', 001, true, loc1);
        
        
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
        Crop crop2 = new Crop(lemons, date2, 120);        
        field1.newCrop(crop1);
        field2.newCrop(crop2);
        

        
        currentFarm.addField(field1);
        currentFarm.addField(field2);
        currentFarm.addField(field3);
        Crop crop3 = new Crop(apples, date1, 3);
        currentFarm.get(currentFarm.getFieldIndex("Field 3")).newCrop(crop3);
    }
}
