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
    private long uniqueId;
    private Sensor[] sensorList;
    private String name;
    private boolean fixed;
    private GPS gps;
    
    public FieldStation(){
        
    }
    
    public FieldStation(Sensor[] theSensorList, String theName, long theUniqueId, GPS theGPS){
        sensorList = theSensorList;
        name = theName;
        uniqueId = theUniqueId;
        gps = theGPS;
    }
    
    public FieldStation(String theName, GPS theGPS) {
        this.name = theName;
        this.gps = theGPS;        
    }
    
    Sensor[] getSensor(){
        return sensorList;
    }
    
    void setSensor(Sensor[] theSensorList){
        /*for (int i = 0; i < theSensorList.length; i++){
            this.sensorList.add(theSensorList[i]);
        }*/

        this.sensorList = theSensorList;
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
