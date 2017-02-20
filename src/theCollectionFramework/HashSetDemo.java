package theCollectionFramework;
import java.util.*;

/**
 * Created by anonymous on 2/20/2017.
 */
public class HashSetDemo {
    public static void main(String[] args){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("B");
        hashSet.add("A");
        hashSet.add("D");
        hashSet.add("E");
        hashSet.add("C");
        hashSet.add("F");
        System.out.println(hashSet);
        hashSet.add("G");
        hashSet.add("H");
        System.out.println(hashSet);
        hashSet.add("K");
        hashSet.add("J");
        hashSet.add("W");
        hashSet.add("Q");
        hashSet.add("P");
        System.out.println(hashSet);
    }
}
