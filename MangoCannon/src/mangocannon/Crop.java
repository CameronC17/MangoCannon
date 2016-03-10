
package mangocannon;

import java.time.LocalDate;
import java.util.Date;

public class Crop {
    private CropType cropType;
    private float estimatedYield;
    private LocalDate plantDate;
    private LocalDate expectedHarvestDate;
    private int fieldArea;

    /**
     * Creates a new instance of a crop 
     * @param theCropType
     * @param thePlantDate
     * @param fieldSizeInM 
     */
    Crop(CropType theCropType, LocalDate thePlantDate, int fieldSizeInM) {
        this.cropType = theCropType;
        this.plantDate = thePlantDate;
        this.fieldArea = fieldSizeInM;
        this.estimatedYield = (fieldSizeInM * theCropType.getAverageYield());
        this.expectedHarvestDate = thePlantDate.plusWeeks(theCropType.getAverageGrowTime());
    }

    /**
     * Returns what type of crop the current crop is
     * @return 
     */
    CropType getCropType(){
        return cropType;
    }
    
    /**
     * Sets the crop type to the new crop type specified in the parameter
     * @param theCrop 
     */
    void setCropType(CropType theCrop) {
        this.cropType = theCrop;
        this.estimatedYield = (this.fieldArea * cropType.getAverageYield());
        this.expectedHarvestDate = this.plantDate.plusWeeks(cropType.getAverageGrowTime());
    }

    /**
     * returns the field area * average yield (per sq m)
     * @return 
     */
    float getEstimatedYield(){
        this.estimatedYield = (this.fieldArea * cropType.getAverageYield());
        return estimatedYield;
    }
    
    /**
     * returns field area, which is set when the field boundary is changed
     * @return 
     */
    int getFieldSize() {
        return fieldArea;
    }

    /**
     * returns the date of when the harvest should be ready. 
     * does this by getting the plant date of the crop and the average grow time of the crop type
     * @return 
     */
    LocalDate getExpectedHarvest(){
        this.expectedHarvestDate = this.plantDate.plusWeeks(cropType.getAverageGrowTime());
        return expectedHarvestDate;
    }
    
    /**
     * changes the plant date of the crop
     * @param theDate 
     */
    void setPlantDate(LocalDate theDate) {
        this.plantDate = theDate;
        this.expectedHarvestDate = this.plantDate.plusWeeks(cropType.getAverageGrowTime());
    }
    
    LocalDate getPlantDate() {
        return plantDate;
    }
}
