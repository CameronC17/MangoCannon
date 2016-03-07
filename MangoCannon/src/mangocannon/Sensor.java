
package mangocannon;

import javax.swing.Timer;

/**
 *
 * @author tomhanson
 */
public class Sensor {
    private SensorTypes sensorType;
    private long uniqueId;    
    private DataReading dataReadings;
    private GPS location;

    public Sensor(SensorTypes theSensorTypes, GPS theGPS){
        float[] emptyArray = {0};
        DataReading emptyData = new DataReading(emptyArray);
        sensorType = theSensorTypes;
        dataReadings = emptyData;
        location = theGPS;
    }

//    public Sensor(String theCategory, Timer theTimer, SensorTypes theSensorSettings, long theUniqueId, DataReading theDataReadings[]){
//        Sensor rainFallSensor = new Sensor(null, sensorTypes.get(0), 001, readings1);

    public Sensor(SensorTypes theSensorTypes, DataReading theDataReadings, GPS theGPS){
        sensorType = theSensorTypes;
        dataReadings = theDataReadings;
        location = theGPS;
    }

    SensorTypes getSensorType(){
        return sensorType;
    }
    void setSensorType(SensorTypes theSensorType){
        this.sensorType = theSensorType;
    }

    long getUniqueId(){
        return uniqueId;
    }
    void setUniqueId(long theUniqueId){
        this.uniqueId = theUniqueId;
    }    

    DataReading getReadings(){
        return dataReadings;
    }
    
    public void setDataReadings(DataReading theData) {
        this.dataReadings = theData;
    }
    
    GPS getLocation() {
        return location;
    }
    
//    void setDataReadings(DataReading theDataReading){
//
//    }
//
//    DataReading[] getLatestReading(){
//        return dataReadings;
//    }

    String getSensorTypeName(){
        return sensorType.getTypeName();
    }

    void startPolling(){
        // SensorSettings.getTimeInterval();

        //SensorTypes sensorSettings = new SensorTypes();
        //boolean deltaBased = sensorSettings.getDeltaBased();
        //float valDelta = sensorSettings.getValDelta();
    }

    DataReading saveReading(DataReading dataReading){
        // save reading - needs to be implemented
        return dataReading;
    }
}
