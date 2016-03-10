
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
    
    /**
     * Converts the sent vector into an array of floats and replaces its current list of readings
     * @param theReadings 
     */
    public void setReadings(Vector<Float> theReadings) {
        float[] myFloatArr = new float[theReadings.size()];
        for (int i = 0; i < theReadings.size(); i++)
        {
            myFloatArr[i] = theReadings.get(i);
        }
        
        this.readings = myFloatArr;
    }
    
    
    float getReadingValue(int i){
        return readings[i];
    }
    
    /**
     * Gets the average value of all the readings in this objects list
     * @return 
     */
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
