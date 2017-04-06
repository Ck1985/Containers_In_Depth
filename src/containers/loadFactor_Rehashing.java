package containers;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class loadFactor_Rehashing {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("1", "one");
        hashMap.put("2", "two");
        hashMap.put("3", "three");
        hashMap.put("4", "four");
        hashMap.put("5", "five");
        hashMap.put("6", "six");
        hashMap.put("7", "seven");
        hashMap.put("8", "eight");
        hashMap.put("9", "nine");
        hashMap.put("10", "ten");
        hashMap.put("11", "eleven");
        hashMap.put("12", "twelve");
        System.out.println(hashMap);
        System.out.println(hashMap);
        System.out.println("------Rehashing-------");
        hashMap.put("13", "thirteen");
        System.out.println(hashMap);
    }
}
