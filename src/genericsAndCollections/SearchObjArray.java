package genericsAndCollections;
import java.util.*;

/**
 * Created by anonymous on 3/1/2017.
 */
public class SearchObjArray {
    public static void main(String[] args){
        String[] sa = {"one","two","three","four"};
        Arrays.sort(sa);
        for(String s : sa){
            System.out.print(s + " ");
        }
        System.out.println("\nbinarySearch(\"one\"): " + Arrays.binarySearch(sa,"one"));
        System.out.println("binarySearch(\"two\"): " + Arrays.binarySearch(sa,"two"));
        Arrays.sort(sa,new ReverseSortComparator());
        System.out.println("After reverse sort sa: ");
        for(String s : sa){
            System.out.print(s + " ");
        }
        System.out.println("\n" + Arrays.binarySearch(sa,"one"));
        System.out.println("\none ReverseSort search: " + Arrays.binarySearch(sa,"one",new ReverseSortComparator()));
    }
}
