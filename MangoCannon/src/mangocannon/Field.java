/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

import java.util.Date;

/**
 *
 * @author jacobburns
 */
public class Field {
    private String fieldName;
    private long uniqueId;
    //private GPSBoudary gpsBoundary;
    private GPSBoundary gpsBoundary;
    private FieldStation fieldStation;
    private Crop crop;    
    private Date plantDate;
    
    Field(String fieldName, Crop theCrop, GPSBoundary theBoundary){
        this.fieldName = fieldName;
        this.crop = theCrop;
        this.gpsBoundary = theBoundary;
    }
    
    Field(String fieldName, GPSBoundary theBoundary){
        this.fieldName = fieldName;
        this.gpsBoundary = theBoundary;
    }
    
    public String getFieldName(){
        return this.fieldName;
    }
    
    public Crop getCrop() {
        return this.crop;
    }
    
    public Date getPlantDate() {
        return this.plantDate;
    }
    
//    public Date getExpectedDate() {
//        return this.crop.getAverageGrowTime();
//    }
    
    
}
