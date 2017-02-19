package containers;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/19/2017.
 */
public class LinkedHashMapDemo {
    public static void main(String[] args){
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(new CountingMapData(9));
        System.out.println(linkedHashMap);
        //Least-recently-used order:
        linkedHashMap = new LinkedHashMap<Integer, String>(16,0.75f,true);
        linkedHashMap.putAll(new CountingMapData(9));
        System.out.println(linkedHashMap);
        // Cause access
        for(int i = 0; i < 6; i++){
            linkedHashMap.get(i);
        }
        System.out.println(linkedHashMap);
        linkedHashMap.get(0);
        System.out.println(linkedHashMap);
    }
}
