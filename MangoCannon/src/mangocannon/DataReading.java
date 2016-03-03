
package mangocannon;

import java.util.Vector;


/**
 *
 * @author tomhanson
 */
public class DataReading {

    private float[] readings;

    public DataReading() {
        
    }
    
    public DataReading (float[] theReadings){
        readings = theReadings;
    }

    float[] getReadingValues(){
        return readings;
    }
    
    public void setReadings(Vector<Float> theReadings) {
        this.readings = theReadings.toArray(new Float[theReadings.size()]);
        
        //Vector<String> vector = new Vector<String>();
        //String[] strings = vector.toArray(new String[vector.size()]);
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
        avgNum = (avgNum / readings.length);
        return avgNum;
    }
    
    int getArrayLength (){
        return readings.length;
    }

}
