
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
        //int[] myIntArray = new int[3];
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
