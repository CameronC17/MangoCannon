package mangocannon;

public class CropType {
    private String cropType;
    private float averageYieldPerM;
    private int averageTimeToGrow;
    private double valuePerM;
    
    /**
     * constructor for the crop type
     * @param theCropType
     * @param theAverageYield
     * @param averageGrowTime 
     */
    CropType (String theCropType, float theAverageYield, int averageGrowTime, double theValue) {
        this.cropType = theCropType;
        this.averageYieldPerM = theAverageYield;
        this.averageTimeToGrow = averageGrowTime;
        this.valuePerM = theValue;
    }
    
    /**
     * returns the name of the crop type
     * @return 
     */
    String getCropName(){
        return cropType;
    }
    
    double getCropValue() {
        return this.valuePerM;
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
