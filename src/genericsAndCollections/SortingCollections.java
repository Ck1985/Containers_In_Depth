package genericsAndCollections;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/27/2017.
 */
public class SortingCollections {
    public static void main(String[] args){
        ArrayList<String> stuff = new ArrayList<>();
        stuff.add("Denver");
        stuff.add("Bounder");
        stuff.add("Vail");
        stuff.add("Aspen");
        stuff.add("Telluride");
        System.out.println("Unsorted stuff: " + stuff);
        Collections.sort(stuff);
        System.out.println("Sorted stuff: " + stuff);
    }
}
