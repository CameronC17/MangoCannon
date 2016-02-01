/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

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
    
    Field(String fieldName, Crop theCrop){
        this.fieldName = fieldName;
        this.crop = theCrop;
    }
    
    public String getFieldName(){
        return this.fieldName;
    }
    
    public Crop getCrop() {
        return this.crop;
    }
    
    @Override
    public String toString(){
        return (fieldName);
    }
}
