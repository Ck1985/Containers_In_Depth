package example;

import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

class TwoString_41 implements Comparable<TwoString_41>{
    private String string1 = null;
    private String string2 = null;

    public TwoString_41(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    public int compareTo(TwoString_41 object) {
        return this.string1.compareTo(object.string1);
    }

    public String toString() {
        return this.string1 + " - " + this.string2;
    }

    static class ComparatorString2 implements Comparator<TwoString_41> {
        public int compare(TwoString_41 object1, TwoString_41 object2) {
            return object1.string2.compareTo(object2.string2);
        }
    }
}
public class Example_41_42 {
    public static void main(String[] args) {
        RandomGenerator.String rgs = new RandomGenerator.String(4);
        RandomGenerator.Integer rgi = new RandomGenerator.Integer(100);
        Set<TwoString_41> hashSet = new HashSet<>();
        Map<TwoString_41, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            String s1 = rgs.next();
            String s2 = rgs.next();
            hashSet.add(new TwoString_41(s1,s2));
            hashMap.put(new TwoString_41(s1,s2), i);
        }
        System.out.println("hashSet: " + hashSet);
        System.out.println("hashMap: " + hashMap);
        System.out.println("hashMap.keySet(): " + hashMap.keySet());
        System.out.println("Sorted by first String:");
        TreeSet<TwoString_41> treeSet = new TreeSet<>(hashSet);
        TreeMap<TwoString_41,Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("TreeSet: " + treeSet);
        System.out.println("TreeMap: " + treeMap);

        System.out.println("Sorted by second String");
        TwoString_41.ComparatorString2 comparator = new TwoString_41.ComparatorString2();
        Set<TwoString_41> treeSet2 = new TreeSet<>(comparator);
        Map<TwoString_41,Integer> treemap2 = new TreeMap<>(comparator);
        treeSet2.addAll(treeSet);
        treemap2.putAll(treeMap);
        System.out.println(treeSet2);
        System.out.println(treemap2);
    }
}
