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
    //private TimeInterval interval;
    private float valDelta;
    //private Unit units;
    private boolean enabled;
    private boolean deltaBased;
    private String typeName;
    private String readingType;

    public SensorTypes()
    {
        // blank constructor
    }

    public SensorTypes(float theValDelta, boolean theEnabled, boolean theDeltaBased, String theTypeName, String theReadingType){
        valDelta = theValDelta;
        enabled = theEnabled;
        deltaBased = theDeltaBased;
        typeName = theTypeName;
        readingType = theReadingType;

    }

    /*public getTimeInterval getInterval(){
        return interval;
    }

    public void setTimeInterval(TimeInterval theInterval){
        this.interval = theInterval;
    }*/

    public float getValDelta(){
        return valDelta;
    }

    public void setValDelta(float theValDelta){
        this.valDelta = theValDelta;
    }

    /*public Unit getUnits(){
        return this.units;
    }

    public void setUnits(Unit theUnits){
        this.units = theUnits;
    }*/

    public boolean getEnabled(){
        return this.enabled;
    }

    public void setEnabled(boolean theEnabled){
        this.enabled = theEnabled;
    }

    public boolean getDeltaBased(){
        return this.deltaBased;
    }

    public void setDeltaBased(boolean theDeltaBased){
        this.deltaBased = theDeltaBased;
    }

    public String getTypeName(){
        return this.typeName;
    }

    public void setTypeName(String theTypeName){
        this.typeName = theTypeName;
    }


}
