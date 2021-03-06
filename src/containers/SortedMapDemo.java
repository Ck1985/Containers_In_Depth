package containers;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/19/2017.
 */
public class SortedMapDemo {
    public static void main(String[] args){
        TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>(new CountingMapData(10));
        System.out.println(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        System.out.println("low: " + low);
        System.out.println("high: " + high);
        Iterator<Integer> iterator = sortedMap.keySet().iterator();
        for(int i = 0; i <= 6; i++){
            if(i == 3) low = iterator.next();
            if(i == 6) high = iterator.next();
            else iterator.next();
        }
        System.out.println(low);
        System.out.println(high);
        System.out.println(sortedMap.subMap(low, high));
        System.out.println(sortedMap.tailMap(low));
        System.out.println(sortedMap.headMap(high));
    }
}
