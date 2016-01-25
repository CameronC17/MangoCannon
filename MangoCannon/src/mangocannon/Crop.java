
package mangocannon;

import java.util.Date;

/**
 *
 * @author tomhanson
 */
public class Crop {
    
    private String cropType;
    private long uniqueId;
    private float estimatedYield;
    private Date plantDate;
    private Date expectedHarvest;
    
    String getCropType(){
        return cropType;
    }
    void setCropType(String theCropType){
        this.cropType = cropType;
    }
    
    long getUniqueId(){
        return uniqueId;
    }
    void setUniqueId(long theUniqueId){
        this.uniqueId = uniqueId;
    }
    
    float getEstimatedYield(){
        return estimatedYield;
    }
    void setEstimatedYield(float theEstimatedYield){
        this.estimatedYield = theEstimatedYield;
    }
    
    Date getPlantDate(){
        return plantDate;
    }
    void setPlantDate(Date thePlantDate){
        this.plantDate = thePlantDate;
    }
    
    Date getExpectedHarvest(){
        return expectedHarvest;
    }
    void setExpectedHarvest(Date theExpectedHarvest){
        this.expectedHarvest = theExpectedHarvest;
    }
}
