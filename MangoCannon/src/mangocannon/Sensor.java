
package mangocannon;

import javax.swing.Timer;

/**
 *
 * @author tomhanson
 */
public class Sensor {
    private String category;
    private Timer timer;
    private SensorTypes sensorTypes;
    private long uniqueId;
    
    private DataReading dataReadings;

    public Sensor(){

    }

//    public Sensor(String theCategory, Timer theTimer, SensorTypes theSensorSettings, long theUniqueId, DataReading theDataReadings[]){
//        Sensor rainFallSensor = new Sensor(null, sensorTypes.get(0), 001, readings1);

    public Sensor(Timer theTimer, SensorTypes theSensorTypes, long theUniqueId, DataReading theDataReadings){
        timer = theTimer;
        sensorTypes = theSensorTypes;
        uniqueId = theUniqueId;
        dataReadings = theDataReadings;
    }
    
    public Sensor(String theCategory, Timer theTimer, SensorTypes theSensorTypes, long theUniqueId, DataReading theDataReadings){
        category = theCategory;
        timer = theTimer;
        sensorTypes = theSensorTypes;
        uniqueId = theUniqueId;
        dataReadings = theDataReadings;
    }

    String getCategory(){
        return category;
    }
    void setCategory(String theCategory){
        this.category = theCategory;
    }

    Timer getTimer(){
        return timer;
    }
    void setTimer(Timer theTimer){
        this.timer = theTimer;
    }

    SensorTypes getSensorSettings(){
        return sensorTypes;
    }
    void setSensorSettings(SensorTypes theSensorSettings){
        this.sensorTypes = theSensorSettings;
    }

    long getUniqueId(){
        return uniqueId;
    }
    void setUniqueId(long theUniqueId){
        this.uniqueId = theUniqueId;
    }
    

//    DataReading[] getReadings(){
//        return dataReadings;
//    }
//    void setDataReadings(DataReading theDataReading){
//
//    }
//
//    DataReading[] getLatestReading(){
//        return dataReadings;
//    }

    String getSensorType(){
        return sensorTypes.getTypeName();
    }

    void startPolling(){
        // SensorSettings.getTimeInterval();

        SensorTypes sensorSettings = new SensorTypes();
        boolean deltaBased = sensorSettings.getDeltaBased();
        float valDelta = sensorSettings.getValDelta();
    }

    DataReading saveReading(DataReading dataReading){
        // save reading - needs to be implemented
        return dataReading;
    }

    void resetTimer(){
        timer.restart();
    }
}
