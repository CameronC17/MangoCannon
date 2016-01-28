package mangocannon;
import java.util.List;
import java.util.ArrayList;

public class Farm {
    //private Field fields[];
    List<Field> fieldList = new ArrayList<Field>();
    
    Farm(){
        Field field1 = new Field();
        fieldList.add(field1);
    }
    
    List<Field> getFieldList(){
        return fieldList;
    }
    
    
}

