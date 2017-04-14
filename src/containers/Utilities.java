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
        System.out.println("index of subList: " + Collections.indexOfSubList(list, subList));
        System.out.println("last index of subList: " + Collections.lastIndexOfSubList(list, subList));
        Collections.replaceAll(list, "one", "Yo");
        System.out.println("replaceAll: " + list);
        Collections.reverse(list);
        System.out.println("reverse: " + list);
        System.out.println(list);
        Collections.rotate(list, 3);
        System.out.println("rotate: " + list);
        List<String> source = Arrays.asList("in the matrix".split(" "));
        Collections.copy(list, source);
        System.out.println("copy: " + list);
        Collections.swap(list, 0, list.size() - 1);
        System.out.println("swap: " + list);
        Collections.shuffle(list, new Random(47));
        System.out.println("shuffle: " + list);
        Collections.fill(list, "pop");
        System.out.println("fill: " + list);
        System.out.println("frequently: " + Collections.frequency(list, "pop"));
        List<String> dups = Collections.nCopies(3, "snap");
        System.out.println("dups: " + dups);
        System.out.println("list disjoint dups: " + Collections.disjoint(list, dups));
        // Get old style Enumration
        Enumeration<String> enumeration = Collections.enumeration(dups);
        Vector<String> vector = new Vector<>();
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
        //Converting a old style vector to List through Enumeration
        ArrayList<String> list = Collections.list(vector.elements());
        System.out.println(list);
    }
}
