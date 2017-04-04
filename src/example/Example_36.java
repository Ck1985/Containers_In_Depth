package example;

import java.util.*;

import containers.Countries;
import performanceTestFrameWork.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

class SlowMap_36Performance {
    static List<Test<SlowMap_36<Integer, Integer>>> testList = new ArrayList<>();
    static {
        testList.add(new Test<SlowMap_36<Integer, Integer>>("put") {
            public int test(SlowMap_36<Integer, Integer> slowMap_36, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    slowMap_36.clear();
                    for (int j = 0; j < size; j++) {
                        slowMap_36.put(i, j);
                    }
                }
                return loops * size;
            }
        });
        testList.add(new Test<SlowMap_36<Integer, Integer>>("get") {
            public int test(SlowMap_36<Integer, Integer> slowMap_36, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j ++) {
                        slowMap_36.get(j);
                    }
                }
                return loops * span;
            }
        });
        testList.add(new Test<SlowMap_36<Integer, Integer>>("iterator") {
            public int test(SlowMap_36<Integer, Integer> slowMap_36, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<Map.Entry<Integer, Integer>> iterator = slowMap_36.entrySet().iterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                    }
                }
                return loops * slowMap_36.size();
            }
        });
    }
}

class SlowMap_36<K,V> extends AbstractMap<K,V> {
    List<MapEntry<K,V>> entryList = new ArrayList<MapEntry<K,V>>();

    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        V oldValue = this.get(key);
        MapEntry<K,V> newMapEntry = new MapEntry<>(key, value);
        for (MapEntry mapEntry : entryList) {
            if (mapEntry.getKey().equals(newMapEntry.getKey())) {
                mapEntry.setValue(value);
                break;
            }
        }
        entryList.add(newMapEntry);
        Collections.sort(entryList);
        return oldValue;
    }


    @SuppressWarnings("unchecked")
    public V get(Object key) {
        /*for (MapEntry mapEntry : entryList) {
            if (mapEntry.getKey().equals(key)) {
                return (V)mapEntry.getValue();
            }
        }
        return null;*/

        MapEntry<K,V> searchEntry = null;
        int resultIndex = 0;
        V resultValue = null;
        for (MapEntry mapEntry : entryList) {
            if (mapEntry.getKey().equals(key)) {
                searchEntry = new MapEntry(key, mapEntry.getValue());
                resultIndex = Collections.binarySearch(entryList, searchEntry);
                resultValue = entryList.get(resultIndex).getValue();
                break;
            }
        }
        return resultValue;
    }

    @SuppressWarnings("unchecked")
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> entrySet = new LinkedHashSet<>();
        entrySet.addAll(entryList);
        return entrySet;
    }
}

public class Example_36 {
    public static void main(String[] args) {
        if(args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        else
            Tester.defaultParams = TestParam.array(10, 100, 50, 50, 100, 20);
        System.out.println("Tesing SlowMap_36:");
        SlowMap_36<String,String> m = new SlowMap_36<String,String>();
        m.putAll(Countries.capitals(15));
        System.out.println("m: " + m);
        System.out.println("m.get(\"BURUNDI\"): " + m.get("BURUNDI"));
        System.out.println("m.entrySet(): " + m.entrySet());
        System.out.println("m.keySet(): " + m.keySet());
        System.out.println("m.values() = " + m.values());
        System.out.println("Two different maps: ");
        SlowMap_36<String,String> m2 = new SlowMap_36<String,String>();
        System.out.println("m.equals(m2): " + m.equals(m2));
        m2.putAll(Countries.capitals(15));
        System.out.println("Maps with same entries: ");
        System.out.println("m.equals(m2): " + m.equals(m2));
        m.clear();
        System.out.println("After m.clear(), m.isEmpty(): " +
                m.isEmpty() + ", m = " + m);
        m2.keySet().clear();
        System.out.println("After m2.keySet().clear(), m2.isEmpty(): "
                + m2.isEmpty() + ", m2 = " + m2);
        System.out.println();
        System.out.println("Testing SlowMap_36:");
        SlowMap_36<String,String> m3 = new SlowMap_36<String,String>();
        m3.putAll(Countries.capitals(15));
        System.out.println("m3: " + m3);
        System.out.println("m3.get(\"BURUNDI\"): " + m3.get("BURUNDI"));
        System.out.println("m3.entrySet(): " + m3.entrySet());
       // System.out.println("m3.hashEntryList(): " + m3.hashEntryList());
        m3.clear();
        System.out.println("After m3.clear(), m3.isEmpty(): " +
                m3.isEmpty() + ", m3 = " + m3);
        m3.keySet().clear();
        System.out.println("After m3.keySet().clear(), m3.isEmpty(): "
                + m3.isEmpty() + ", m3 = " + m3);
        System.out.println();
        System.out.println("Comparative time SlowMap_36Perforrmance.testList:");
        Tester.run(new SlowMap_36<Integer,Integer>(), SlowMap_36Performance.testList);
        //Tester.run(new SlowMap17<Integer,Integer>(), SlowMap_36Perforrmance.testList);
       // Tester.run(new SlowMap36a<Integer,Integer>(), SlowMap_36Perforrmance.testList);
        //Tester.run(new SlowMap36b<Integer,Integer>(), SlowMap_36Perforrmance.testList);
        /*Tester.run(new HashMap<Integer,Integer>(), SlowMap_36Perforrmance.testList);
        Tester.run(new TreeMap<Integer,Integer>(), SlowMap_36Perforrmance.testList);
        Tester.run(new LinkedHashMap<Integer,Integer>(), SlowMap_36Perforrmance.testList);
        Tester.run(new IdentityHashMap<Integer,Integer>(), SlowMap_36Perforrmance.testList);
        Tester.run(new WeakHashMap<Integer,Integer>(), SlowMap_36Perforrmance.testList);
        Tester.run(new Hashtable<Integer,Integer>(), SlowMap_36Perforrmance.testList);*/
    }
}
