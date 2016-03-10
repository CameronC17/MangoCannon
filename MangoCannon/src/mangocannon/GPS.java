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
    private int[] gpsCoordinates = new int[2];
    
    /**
     * Takes 2 ints to hold the x and y of the position
     * @param theX
     * @param theY 
     */
    GPS(int theX, int theY) {
        gpsCoordinates[0] = theX;
        gpsCoordinates[1] = theY;
    }
        
    public int[] getGlobalPosition() {
        return gpsCoordinates;
    }
    
    /**
     * sets the x and y, and overrides what is already set
     * @param theX
     * @param theY 
     */
    void setGlobalPosition(int theX, int theY) {
        gpsCoordinates[0] = theX;
        gpsCoordinates[1] = theY;
    }

}
