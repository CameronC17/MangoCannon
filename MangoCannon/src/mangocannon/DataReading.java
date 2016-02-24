
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
    
    float getAverageReading() {
        float avgNum = 0;
        for(float theNum : readings)
        {
            avgNum += theNum;
        }
        avgNum /= (avgNum / readings.length);
        return avgNum;
    }
    
    int getArrayLength (){
        return readings.length;
    }

}
