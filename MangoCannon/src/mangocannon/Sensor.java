
package mangocannon;

import javax.swing.Timer;

/**
 *
 * @author tomhanson
 */
public class Sensor {
    private Timer timer;
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

    Timer getTimer(){
        return timer;
    }
    void setTimer(Timer theTimer){
        this.timer = theTimer;
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

    void resetTimer(){
        timer.restart();
    }
}
