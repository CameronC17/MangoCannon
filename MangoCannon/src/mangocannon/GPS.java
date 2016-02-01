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
public class GPS {
    //Private variable initialisers
    //I have added this gpsCoordinates class to hold the locational data of the FieldStation

//    private float[] gpsCoordinates; //Can only be two columns
    private float[] gpsCoordinates = new float[2];
    
    GPS(float theX, float theY) {
        gpsCoordinates[0] = theX;
        gpsCoordinates[1] = theY;
    }
        
    float[] getGlobalPosition() {
        return gpsCoordinates;
    }
    
    void setGlobalPosition(float theX, float theY) {
        gpsCoordinates[0] = theX;
        gpsCoordinates[1] = theY;
    }

}
