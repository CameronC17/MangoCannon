package mangocannon;

import java.util.ArrayList;
import java.util.List;

public class GPSBoundary {
    List<GPS> pointList = new ArrayList<GPS>(); 
    
    List<GPS> getBoundary() {
        return pointList;
    }
    
    /*
    The boundary is like this:
    
        0         1
    
    
    
        2         3
    
    */
    
    /**
     * Takes 4 GPS positions to form the rectangular boundary
     * @param theGPS1
     * @param theGPS2
     * @param theGPS3
     * @param theGPS4 
     */
    void createBoundary(GPS theGPS1,GPS theGPS2, GPS theGPS3, GPS theGPS4) {
        pointList.add(theGPS1);
        pointList.add(theGPS2);
        pointList.add(theGPS3);
        pointList.add(theGPS4);
    }
    
    void deleteBoundary() {
        pointList.clear();
    }
    
    /**
     * Multiplies the width by the height to work out the field area in sq m
     * @return 
     */
    int getFieldArea() {
        int xLength = 0, yLength = 0;
        xLength = pointList.get(1).getGlobalPosition()[0] - pointList.get(0).getGlobalPosition()[0];
        yLength = pointList.get(3).getGlobalPosition()[1] - pointList.get(0).getGlobalPosition()[1];
        
        return (xLength * yLength);
    }
    
    /**
     * Finds the middle coordinate of the field, and places the field station there
     * @return 
     */
    GPS getCentre() {
        int gpsX, gpsY;
        gpsX = (pointList.get(1).getGlobalPosition()[0] - pointList.get(0).getGlobalPosition()[0]) / 2;
        gpsY = (pointList.get(3).getGlobalPosition()[1] - pointList.get(0).getGlobalPosition()[1]) / 2;        
        GPS gpsCentre = new GPS(gpsX, gpsY);

        return gpsCentre;
    }
    
    /**
     * Checks if the gps point given to it is inside its boundaries
     * @param theGPS
     * @return 
     */
    public boolean isInside(GPS theGPS) {
        if (theGPS.getGlobalPosition()[0] >= pointList.get(0).getGlobalPosition()[0] && theGPS.getGlobalPosition()[0] <= pointList.get(1).getGlobalPosition()[0] && theGPS.getGlobalPosition()[1] >= pointList.get(0).getGlobalPosition()[1] && theGPS.getGlobalPosition()[1] <= pointList.get(3).getGlobalPosition()[1])
            return true;
        else
            return false;
    }
}
