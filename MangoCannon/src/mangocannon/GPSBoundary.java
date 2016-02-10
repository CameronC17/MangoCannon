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
    
    void addMultipleBoundaries(GPS gpsArray[]) {
        
    }
    
    void setBoundary(List<GPS> theBoundaries) {
        this.pointList = theBoundaries;
    }
    
    float getSize() {
        float fullArea = 0;
        //float highestX = 0, highestY = 0, lowestX = 0, lowestY = 0;
        /*float highestX, highestY, lowestX, lowestY;
        //This code draws a rectangle around the borders of the boundary and sees if each point is inside it
        highestX = pointList.get(0).getGlobalPosition()[0];
        lowestX = pointList.get(0).getGlobalPosition()[0];
        highestY = pointList.get(0).getGlobalPosition()[1];
        lowestY = pointList.get(0).getGlobalPosition()[1];
        for(int i = 1; i < pointList.size(); i++)
        {
            float[] currCoord = pointList.get(i).getGlobalPosition();
            if (currCoord[0] > highestX)
                highestX = currCoord[0];
            if (currCoord[0] < lowestX)
                lowestX = currCoord[0];
            if (currCoord[1] > highestY)
                highestY = currCoord[1];
            if (currCoord[1] < lowestY)
                lowestY = currCoord[1];
        }*/
        
        return fullArea;
    }
}
