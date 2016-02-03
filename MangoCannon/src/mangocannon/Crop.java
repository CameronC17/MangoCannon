
package mangocannon;

import java.time.LocalDate;
import java.util.Date;

public class Crop {
    private CropType cropType;
    private float estimatedYield;
    private LocalDate plantDate;
    private LocalDate expectedHarvestDate;
    private int fieldArea;
    
    Crop(CropType theCropType, LocalDate thePlantDate, int fieldSizeInM) {
        this.cropType = theCropType;
        this.plantDate = thePlantDate;
        this.fieldArea = fieldSizeInM;
        this.estimatedYield = (fieldSizeInM * theCropType.getAverageYield());
        this.expectedHarvestDate = thePlantDate.plusWeeks(theCropType.getAverageGrowTime());        
    }
    
    String getCropType(){
        return cropType.getCropType();
    }
    void setCropType(CropType theCrop) {
        this.cropType = theCrop;
        this.estimatedYield = (this.fieldArea * cropType.getAverageYield());
        this.expectedHarvestDate = this.plantDate.plusWeeks(cropType.getAverageGrowTime()); 
    }
    
    float getEstimatedYield(){
        this.estimatedYield = (this.fieldArea * cropType.getAverageYield());
        return estimatedYield;
    }
    int getFieldSize() {
        return fieldArea;
    }
    
    LocalDate getExpectedHarvest(){
        this.expectedHarvestDate = this.plantDate.plusWeeks(cropType.getAverageGrowTime());
        return expectedHarvestDate;
    }
    void setPlantDate(LocalDate theDate) {
        this.plantDate = theDate;
        this.expectedHarvestDate = this.plantDate.plusWeeks(cropType.getAverageGrowTime()); 
    }
    LocalDate getPlantDate() {
        return plantDate;
    }
}
