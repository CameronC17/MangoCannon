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
public class SensorTypes {
    private String typeName;
    private String readingType;
    private int timeInterval;

    
    public SensorTypes(String theTypeName, String theReadingType, int theTimeInterval){
        typeName = theTypeName;
        readingType = theReadingType;
        timeInterval = theTimeInterval;
    }

    public String getReadingType(){
        return this.readingType;
    }

    public void setReadingType(String unitType){
        this.readingType = unitType;
    }

    public String getTypeName(){
        return this.typeName;
    }

    public void setTypeName(String theTypeName){
        this.typeName = theTypeName;
    }
    
    public int getTimeInterval() {
        return this.timeInterval;
    }
    
    public void setTimeInterval(int theTimeInterval){
        this.timeInterval = theTimeInterval;
    }

}
