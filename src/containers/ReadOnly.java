package containers;

import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));
    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<String>(data));
        //Reading is Ok
        System.out.println(c);
        //Can not change it, through UnsupportOperator exception
        //c.add("one");
        List<String> a = Collections.unmodifiableList(new ArrayList<String>(data));
        ListIterator<String> listIterator = a.listIterator();
        //Reading ok
        System.out.println(listIterator.next());
        //Can not change it, through UnsupportOperatorException
        //listIterator.add("xxx");
        Set<String> b = Collections.unmodifiableSet(new HashSet<>(data));
        System.out.println(b);
        //b.add("xxx");
        // For sortedset
        Set<String> sortedSet = Collections.unmodifiableSortedSet(new TreeSet<String>(data));
        Map<String,String> map = Collections.unmodifiableMap(new HashMap<>(Countries.capitals()));
        System.out.println(map);
        //map.put("xxx","yyy");
        //For sortedMap
        Map<String,String> sortedMap = Collections.unmodifiableSortedMap(new TreeMap<>(Countries.capitals()));
    }
}
