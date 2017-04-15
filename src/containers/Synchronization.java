package containers;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class Synchronization {
    public static void main(String[] args) {
        Collection<String> c = Collections.synchronizedCollection(new ArrayList<>());
        List<String> l = Collections.synchronizedList(new ArrayList<>());
        Set<String> s = Collections.synchronizedSet(new HashSet<>());
        Set<String> ss = Collections.synchronizedSortedSet(new TreeSet<>());
        Map<String,String> m = Collections.synchronizedMap(new HashMap<>());
        Map<String,String> sm = Collections.synchronizedSortedMap(new TreeMap<>());
    }
}
