package mangocannon;

public class CropType {
    private String cropType;
    private float averageYieldPerM;
    private int averageTimeToGrow;
    
    /**
     * constructor for the crop type
     * @param theCropType
     * @param theAverageYield
     * @param averageGrowTime 
     */
    CropType (String theCropType, float theAverageYield, int averageGrowTime) {
        this.cropType = theCropType;
        this.averageYieldPerM = theAverageYield;
        this.averageTimeToGrow = averageGrowTime;
    }
    
    /**
     * returns the name of the crop type
     * @return 
     */
    String getCropName(){
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
