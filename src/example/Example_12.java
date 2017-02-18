package example;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/18/2017.
 */
public class Example_12 {
    public static void main(String[] args){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(5, "Blue");
        hashMap.put(2, "Blue");
        hashMap.put(70, "Green");
        hashMap.put(10, "Yellow");
        hashMap.put(8, "Black");
        hashMap.put(9, "Red");
        hashMap.put(6, "White");
        System.out.println(hashMap);
        System.out.println(hashMap.get(4));
        System.out.println(hashMap.get(6));
        System.out.println("-----------------------");
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5, "Blue");
        treeMap.put(2, "Blue");
        treeMap.put(70, "Green");
        treeMap.put(10, "Yellow");
        treeMap.put(8, "Black");
        treeMap.put(9, "Red");
        treeMap.put(66, "White");
        System.out.println(treeMap);
        System.out.println(treeMap.get(5));
        System.out.println(treeMap.get(9));
        System.out.println("--------------------------");
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(4, "bbbb");
        linkedHashMap.put(3, "eeeee");
        linkedHashMap.put(1, "wwwwwwww");
        linkedHashMap.put(9, "tttttttttttt");
        System.out.println(linkedHashMap);
    }
}
