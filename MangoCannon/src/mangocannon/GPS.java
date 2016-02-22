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
    private int[] gpsCoordinates = new int[2];
    
    GPS(int theX, int theY) {
        gpsCoordinates[0] = theX;
        gpsCoordinates[1] = theY;
    }
        
    public int[] getGlobalPosition() {
        return gpsCoordinates;
    }
    
    void setGlobalPosition(int theX, int theY) {
        gpsCoordinates[0] = theX;
        gpsCoordinates[1] = theY;
    }

}
