
package mangocannon;

import java.sql.Time;


/**
 *
 * @author tomhanson
 */
public class DataReading {
    
    private Time time;
    private float[] readings;
    private String readingType;
    private long createdBy;
    
    public DataReading (Time theTime, float[] theReadings, String theReadingType, long theCreatedBy){
        time = theTime;
        readings = theReadings;
        readingType = theReadingType;
        createdBy = theCreatedBy;
    }
    
    Time getTime(){
        return time;
    }
    
    float[] getReadingValues(){
        return readings;
    }
    
    String getReadingType(){
        return readingType;
    }
    
    long getCreatorId(){
        return createdBy;
    }
}
