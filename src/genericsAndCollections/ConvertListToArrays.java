package genericsAndCollections;
import java.util.*;
/**
 * Created by anonymous on 3/1/2017.
 */
public class ConvertListToArrays {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            list.add(i);
        }
        Object[] objectArray = list.toArray();
        Integer[] integerArray = new Integer[3];
        Integer[] intArray = list.toArray(integerArray);
    }
}
