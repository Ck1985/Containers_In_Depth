package containers;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by anonymous on 2/18/2017.
 */
public class Maps {
    public static void printKeys(Map<Integer, String> map){
        System.out.println("Size: " + map.size());
        System.out.println("Keys: ");
        System.out.println(map.keySet());
    }
    public static void test(Map<Integer, String> map){
        System.out.println("SimpleName of Map: " + map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        // Map has 'Set' behavior for keys
        map.putAll(new CountingMapData(25));
        printKeys(map);
        // Producing a Collection of values:
        System.out.println("Values: ");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11): " + map.get(11));
        System.out.println("map.containsValue(\"F0\"): " + map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        System.out.println("The first key of map: " + key);
        System.out.println("map.remove(): " + map.remove(key));
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        //Operators on Set change map:
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty(): " + map.isEmpty());
    }
    public static void main(String[] args){
        test(new HashMap<>());
        test(new TreeMap<>());
        test(new LinkedHashMap<>());
        test(new IdentityHashMap<>());
        test(new ConcurrentHashMap<>());
        test(new WeakHashMap<>());
    }
}
