package theCollectionFramework;
import java.util.*;

/**
 * Created by anonymous on 2/20/2017.
 */
public class ArrayListToArray {
    public static void main(String[] args){
        // Create an array list:
        ArrayList<Integer> arrayList = new ArrayList<>();
        // Add elements to array list
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println("Content ArrayList: " + arrayList);
        //Get array from ArrayList:
        Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
        //Sum of array:
        int sum = 0;
        for(Integer i : array){
            sum += i;
        }
        System.out.println("Sum of array: " + sum);
    }
}
