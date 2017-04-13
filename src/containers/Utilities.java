package containers;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class Utilities {
    static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));
    public static void main(String[] args) {
        System.out.println("list: " + list);
        boolean disjoint = Collections.disjoint(list, Collections.singletonList("Four"));
        System.out.println("list disjoint(Four): " + disjoint);
        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));
        System.out.println("max w/ comparator: " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        System.out.println("min w/ comparator: " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));
        List<String> subList = Arrays.asList("Four five six".split(" "));
        System.out.println("index of subList: " + Collections.indexOfSubList(list,subList));
        System.out.println("last index of subList: " + Collections.lastIndexOfSubList(list,subList));
    }
}
