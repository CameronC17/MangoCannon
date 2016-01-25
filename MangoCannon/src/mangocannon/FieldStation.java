/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

/**
 *
 * @author jacobburns
 */
public class FieldStation {
    private Sensor sensorList[];
    private String name;
    private long uniqueId;
    private boolean fixed;
    private GPS gps;
    
    Sensor getSensor(){
        return sensorList[];
    }
    
    void setSensor(Sensor theSensorList[]){
        this.sensorList = this.sensorList + theSensorList;
    }
    
    String getName(){
        return name;
    }
    
    void setName(String theName){
        this.name = theName;
    }
    
    long getUniqueId(){
        return uniqueId;
    }
    
    void setUniqueId(long theUniqueId){
        this.uniqueId = theUniqueId;
    }
    
    boolean getFixed(){
        return fixed;
    }
    
    void setFixed(boolean theFixed){
        this.fixed = theFixed;
    }
    
    GPS getGPS(){
        return gps;
    }
    
    void setGPS(GPS theGps){
        this.gps = theGps;
    }
}
