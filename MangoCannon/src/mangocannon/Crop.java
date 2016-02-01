
package mangocannon;

import java.util.Date;

public class Crop {
    private String cropType;
    private float averageYieldPerM;
    private int averageTimeToGrow;
    
    Crop(String theCropType, float theAverageYield, int averageGrowTime) {
        this.cropType = theCropType;
        this.averageYieldPerM = theAverageYield;
        this.averageTimeToGrow = averageGrowTime;
    }
    
    String getCropType(){
        return cropType;
    }
    
    float getAverageYield(){
        return averageYieldPerM;
    }
    void setAverageYield(float theEstimatedYield){
        this.averageYieldPerM = theEstimatedYield;
    }
    
    int getAverageGrowTime(){
        return averageTimeToGrow;
    }
    void setAverageGrowTime(int theExpectedHarvest){
        this.averageTimeToGrow = theExpectedHarvest;
    }
}
