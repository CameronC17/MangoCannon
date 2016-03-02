package mangocannon;

public class CropType {
    private String cropType;
    private float averageYieldPerM;
    private int averageTimeToGrow;
    
    CropType (String theCropType, float theAverageYield, int averageGrowTime) {
        this.cropType = theCropType;
        this.averageYieldPerM = theAverageYield;
        this.averageTimeToGrow = averageGrowTime;
    }
    
    String getCropType(){
        return cropType;
    }
    void setCropType(String theCropType) {
        this.cropType = theCropType;
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
    
    String getCropTypeAtIndex(int i){
        return this.getCropTypeAtIndex(i);
    }
    
}
