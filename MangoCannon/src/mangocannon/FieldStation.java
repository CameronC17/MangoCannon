/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

import java.util.Vector;

/**
 *
 * @author jacobburns
 */
public class FieldStation {
    public Vector<Sensor> sensorList = new Vector<Sensor>();
    private String name;
    private boolean fixed;
    private GPS gps;
    
    /**
     * FieldStation constructor. Takes a list of sensors, the name of the station and the
     * @param theSensorList
     * @param theName
     * @param theGPS 
     */
    public FieldStation(Vector<Sensor> theSensorList, String theName, GPS theGPS){
        sensorList = theSensorList;
        name = theName;
        gps = theGPS;
    }
    
    /**
     * A more basic field constructor to follow factory/builder method
     * @param theName
     * @param theGPS 
     */    
    public FieldStation(String theName, GPS theGPS) {
        this.name = theName;
        this.gps = theGPS;        
    }
    
    Vector<Sensor> getSensors(){
        return sensorList;
    }
    
    void addSensor(Sensor sensor) {
        this.sensorList.add(sensor);
    }
    
    void setSensor(Vector<Sensor> theSensorList){
        this.sensorList = theSensorList;
    }
    
    String getName(){
        return name;
    }
    
    void setName(String theName){
        this.name = theName;
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
