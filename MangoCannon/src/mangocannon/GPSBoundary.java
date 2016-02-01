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
    
    void addBoundary(GPS theGPS) {
        pointList.add(theGPS);
    }
    
    void setBoundary(List<GPS> theBoundaries) {
        this.pointList = theBoundaries;
    }
}
