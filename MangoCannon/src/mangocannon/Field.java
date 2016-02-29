package mangocannon;

import java.util.Date;
import java.util.List;

public class Field {
    private String fieldName;
    private GPSBoundary gpsBoundary;
    private FieldStation fieldStation;
    private Crop crop;
    
    Field(String fieldName, Crop theCrop, GPSBoundary theBoundary, FieldStation theFieldStation){
        this.fieldName = fieldName;
        this.crop = theCrop;
        this.gpsBoundary = theBoundary;
        this.fieldStation = theFieldStation;
    }
    
    Field(String fieldName, GPSBoundary theBoundary){
        this.fieldName = fieldName;
        this.gpsBoundary = theBoundary;
    }
    
    public String getFieldName(){
        return this.fieldName;
    }
    
    public void newCrop(Crop theCrop) {
        this.crop = theCrop;
    }
    
    public Crop getCrop() {
        return this.crop;
    }
    
    public List<GPS> getBoundaries() {
        return gpsBoundary.getBoundary();
    }
    
    public float size() {
        return gpsBoundary.getSize();
    }
    
    public FieldStation getFieldStation() {
        return fieldStation;
    }
    
    public void setFieldStation(FieldStation theFS) {
        this.fieldStation = theFS;
    }
}
