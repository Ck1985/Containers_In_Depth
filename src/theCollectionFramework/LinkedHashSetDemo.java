package theCollectionFramework;
import java.util.*;

/**
 * Created by anonymous on 2/20/2017.
 */
public class LinkedHashSetDemo {
    public static void main(String[] args){
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(7);
        lhs.add(5);
        lhs.add(9);
        lhs.add(1);
        System.out.println(lhs);
    }
}
