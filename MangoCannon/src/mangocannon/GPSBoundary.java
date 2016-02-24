package mangocannon;

import java.util.ArrayList;
import java.util.List;

public class GPSBoundary {
    //Private variable initialiers
    //private GPS pointList[];
    List<GPS> pointList = new ArrayList<GPS>(); 
    
    List<GPS> getBoundary() {
        return pointList;
    }
    
    void createBoundary(GPS theGPS1,GPS theGPS2, GPS theGPS3, GPS theGPS4) {
        pointList.add(theGPS1);
        pointList.add(theGPS2);
        pointList.add(theGPS3);
        pointList.add(theGPS4);
    }
    
    void deleteBoundary() {
        pointList.clear();
    }
    
    int getSize() {
        int xLength = 0, yLength = 0;
        xLength = pointList.get(1).getGlobalPosition()[0] - pointList.get(0).getGlobalPosition()[0];
        yLength = pointList.get(3).getGlobalPosition()[1] - pointList.get(0).getGlobalPosition()[1];
        
        return (xLength * yLength);
    }
    
    GPS getCentre() {
        int gpsX, gpsY;
        gpsX = (pointList.get(1).getGlobalPosition()[0] - pointList.get(0).getGlobalPosition()[0]) / 2;
        gpsY = (pointList.get(3).getGlobalPosition()[1] - pointList.get(0).getGlobalPosition()[1]) / 2;        
        GPS gpsCentre = new GPS(gpsX, gpsY);

        return gpsCentre;
    }
}
