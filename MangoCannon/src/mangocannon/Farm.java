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
    
    int getFieldIndex(String theFieldName) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFieldName() == theFieldName)
                return i;
        }
        return -1;
    }
    
}

