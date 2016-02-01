package mangocannon;

import java.util.Vector;

public class Farm extends Vector<Field>{
    //private Field fields[];
    
    void addField(Field theField){
        super.add(theField);
    }
    
    void removeField(Field theField){
        super.remove(theField);
    }
       
    
}

