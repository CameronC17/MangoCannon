
package mangocannon;

import java.sql.Time;


/**
 *
 * @author tomhanson
 */
public class DataReading {

    private float[] readings;

    public DataReading (float[] theReadings){
        readings = theReadings;
    }

    float[] getReadingValues(){
        return readings;
    }
    
    float getReadingValue(int i){
        return readings[i];
    }
    
    int getArrayLength (){
        return readings.length;
    }

}
