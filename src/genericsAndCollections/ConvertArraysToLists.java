package genericsAndCollections;
import java.util.*;

/**
 * Created by anonymous on 3/1/2017.
 */
public class ConvertArraysToLists {
    public static void main(String[] arsg){
        String[] array = new String[]{"one","two","three","four"};
        List list = Arrays.asList(array);
        System.out.println("size: " + list.size());
        System.out.println("idx2: " + list.get(2));

        list.set(2,"five");
        array[1] = "six";
        for(String s : array){
            System.out.print(s + " ");
        }
        System.out.println("\n list.get(2): " + list.get(2));
    }
}
