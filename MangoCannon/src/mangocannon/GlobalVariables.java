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
    public UserRegister userRegister = new UserRegister();
    public Vector<CropType> cropTypes = new Vector<CropType>();
    public Vector<SensorTypes> sensorTypes = new Vector<SensorTypes>();
    public Vector<User> user = new Vector<User>();
    public Vector<Sensor> unallocatedSensors = new Vector<Sensor>();
  
    public User currentUser;
    public GPSBoundary workingBoundary;
    public GPS workingGPS;
    public int workingField = -1;   
    public Field editField = null;
    public Sensor workingSensor = null;

    public GlobalVariables()
    {
        GPS loc1 = new GPS(10, 10);
        GPS loc2 = new GPS(50, 10);
        GPS loc3 = new GPS(10, 50);
        GPS loc4 = new GPS(50, 50);
        
        GPS loc5 = new GPS(870, 70);        
        GPS loc6 = new GPS(900, 70);
        GPS loc7 = new GPS(870, 100);
        GPS loc8 = new GPS(900, 100);

        GPSBoundary gpsB1 = new GPSBoundary();
        gpsB1.createBoundary(loc1, loc2, loc3, loc4);

        GPSBoundary gpsB2 = new GPSBoundary();
        gpsB2.createBoundary(loc5, loc6, loc7, loc8);
        
        //CropType (String theCropType, float theAverageYield, int averageGrowTime)
        CropType carrots = new CropType("Carrots", 10.5f, 40);
        CropType donuts = new CropType("Donuts", 1.3f, 1);        
        CropType lemons = new CropType("Lemons", 50f, 60);
        CropType apples = new CropType("Apples", 100f, 100); 
        cropTypes.addElement(carrots);
        cropTypes.addElement(donuts);        
        cropTypes.addElement(lemons);
        cropTypes.addElement(apples);
        

        // SensorSettings (Type, measurements, time interval (in seconds)
        SensorTypes rainFall = new SensorTypes("Rain Fall", "mm", 600);
        SensorTypes sunshine = new SensorTypes("Sunshine", "mm", 60);
        SensorTypes nutrientSaturation = new SensorTypes("Nutrient Saturation", "mm", 6000);
        SensorTypes temperature = new SensorTypes("Temperature", "f", 300);
        
        sensorTypes.add(sunshine);
        sensorTypes.add(rainFall);
        sensorTypes.add(nutrientSaturation);
        sensorTypes.add(temperature);
        
        //DataReadings Data
        float[] floats1 = {1.1f, 2.8f, 3.5f, 1.2f, 5.2f, 1.1f, 0.1f};
        float[] floats2 = {50.6f, 32.2f, 23.2f, 22.0f, 19.2f, 18.8f, 14.3f};
        float[] floats3 = {102.6f, 100.1f, 99.5f, 90.4f, 88.8f, 84.5f, 77.6f};
        float[] floats4 = {0.60f, 0.65f, 0.66f, 0.65f, 0.69f, 0.71f, 0.74f};
        DataReading readings1 = new DataReading(floats1);
        DataReading readings2 = new DataReading(floats2);
        DataReading readings3 = new DataReading(floats3);
        DataReading readings4 = new DataReading(floats4);
        /*dataReadings.addElement(readings1);
        dataReadings.addElement(readings2);
        dataReadings.addElement(readings3);
        dataReadings.addElement(readings4);*/

        
        //User credentials
        // firstName, secondName, password, uniqueId, AccessLevel, username
        User user1 = new User("Carlos", "Adams", "carlosa", 5312, 2, "carlos_adams");
        User user2 = new User("Sara", "James", "saraj", 5142, 1, "sara_james");
        User user3 = new User("John", "Smith", "johns", 5332, 2, "john_smith");
        User user4 = new User("Super", "Admin", "super", 1337, 2, "admin");
        userRegister.addUser(user1);        
        userRegister.addUser(user2);
        userRegister.addUser(user3);
        userRegister.addUser(user4);
        
        //Sensors
        Sensor rainFallSensor = new Sensor(rainFall, readings1, loc3);
        Sensor sunshineSensor = new Sensor(sunshine, readings2, loc5);
        Sensor nutrientSaturationSensor = new Sensor(nutrientSaturation, readings3, loc6);
        Sensor temperatureSensor = new Sensor(temperature, readings4, loc7);
        
        //SensorList
        Vector<Sensor> sensorList1 = new Vector<Sensor>();
        sensorList1.add(rainFallSensor);
        sensorList1.add(sunshineSensor);
        sensorList1.add(nutrientSaturationSensor);
        sensorList1.add(temperatureSensor);
                
        Vector<Sensor> sensorList2 = new Vector<Sensor>();
        sensorList2.add(sunshineSensor);
        sensorList2.add(rainFallSensor);
        sensorList2.add(temperatureSensor);
        sensorList2.add(nutrientSaturationSensor);
        
        
        
        //Date d = new Date("10/02/2016");
        LocalDate date1 = LocalDate.parse("2016-02-10");
        LocalDate date2 = LocalDate.parse("2017-06-29");
        //LocalDate date1 = LocalDate.parse("15-06-2016");
        //LocalDate date2 = LocalDate.parse("29-08-2017");

        Field field1 = new Field("Field 1", gpsB1);
        Field field2 = new Field("Field 2", gpsB2);
        Field field3 = new Field("Field 3", gpsB1);
        
        FieldStation fieldStation1 = new FieldStation(sensorList1, "Field Station 1", 001, field1.getGPSBoundary().getCentre());
        FieldStation fieldStation2 = new FieldStation(sensorList2, "FS2", 002, field2.getGPSBoundary().getCentre());

        //Crop(CropType theCropType, LocalDate thePlantDate, int fieldSizeInM)
        //Evetually change last number to be field1.size() or whatever
        Crop crop1 = new Crop(donuts, date1, 54);
        Crop crop2 = new Crop(lemons, date2, 120);        
        field1.newCrop(crop1);
        field2.newCrop(crop2);
        
        field1.setFieldStation(fieldStation1);
        field2.setFieldStation(fieldStation2);
        
        currentFarm.addField(field1);
        currentFarm.addField(field2);
        
//        currentFarm.addField(field3);
        //Crop crop3 = new Crop(apples, date1, 3);
        //currentFarm.get(currentFarm.getFieldIndex("Field 3")).newCrop(crop3);
    }
    
    void setWorkingBoundary(GPSBoundary theGPSBndry) {
        workingBoundary = theGPSBndry;
    }
        
    GPSBoundary getWorkingBoundary() {
        return workingBoundary;
    }
    
    Field getFieldInFarmIndex(int i) {
        return currentFarm.get(i);
    }
    
    CropType getCropAtIndex(int index){
        return cropTypes.elementAt(index);
    }
    
    int getIndexFromCrop(CropType theCrop){
        return cropTypes.indexOf(theCrop);
    }
}
