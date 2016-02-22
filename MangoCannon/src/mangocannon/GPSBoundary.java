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
    
    int getSize() {
        //int fullArea = pointList.get(0) * pointList.get(2);
        
        
        return 0;
    }
}
