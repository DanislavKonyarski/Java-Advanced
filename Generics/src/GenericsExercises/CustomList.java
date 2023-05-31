package GenericsExercises;

import java.util.ArrayList;
import java.util.List;

public class  CustomList <T extends Comparable> {
    private List<T> customList;

    public CustomList (){
        this.customList = new ArrayList<>();
    }
    
}
