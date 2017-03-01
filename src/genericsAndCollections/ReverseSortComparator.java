package genericsAndCollections;
import java.util.*;

/**
 * Created by anonymous on 3/1/2017.
 */
public class ReverseSortComparator implements Comparator<String>{
    public int compare(String a,String b){
        return b.compareTo(a);
    }
}
