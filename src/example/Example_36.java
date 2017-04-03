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
        for (MapEntry mapEntry : entryList) {
            if (mapEntry.getKey().equals(key)) {
                return (V)mapEntry.getValue();
            }
        }
        return null;
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
        SlowMap_36<String, String> slowMap_36 = new SlowMap_36<>();
        slowMap_36.putAll(Countries.capitals(10));
        for (Map.Entry mapEntry : slowMap_36.entryList) {
            System.out.print(mapEntry.getKey() + " ");
        }
        System.out.println();
        for (Map.Entry entry : slowMap_36.entryList) {
            System.out.print(entry.getKey().hashCode() + " ");
        }
        System.out.println();
        System.out.println(slowMap_36);
        System.out.println(slowMap_36.entrySet());
        System.out.println(slowMap_36.get("CHAD"));
        System.out.println(slowMap_36.entrySet());
        System.out.println("------------------");
        Tester.run(new SlowMap_36<>(), SlowMap_36Performance.testList);
    }
}
