
package mangocannon;

import javax.swing.Timer;

/**
 *
 * @author tomhanson
 */
public class Sensor {
    
    private String category;
    private Timer timer;
    private SensorTypes sensorSettings;
    private long uniqueId;
    private DataReading dataReadings[];
    
    public Sensor(){
        
    }
    
    public Sensor(String theCategory, Timer theTimer, SensorTypes theSensorSettings, long theUniqueId, DataReading theDataReadings[]){
        category = theCategory;
        timer = theTimer;
        sensorSettings = theSensorSettings;
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
        return sensorSettings;
    }
    void setSensorSettings(SensorTypes theSensorSettings){
        this.sensorSettings = theSensorSettings;
    }
    
    long getUniqueId(){
        return uniqueId;
    }
    void setUniqueId(long theUniqueId){
        this.uniqueId = theUniqueId;
    }
    
    DataReading[] getReadings(){
        return dataReadings;
    }
    void setDataReadings(DataReading theDataReading){
        
    }
    
    DataReading[] getLatestReading(){
        return dataReadings;
    }
    
    String getSensorType(){
        return sensorSettings.getTypeName();
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
