package example;

import java.util.*;
import performanceTestFrameWork.*;


/**
 * Created by anonymous.vn1985@gmail.com
 */

class MapEntry_37<K,V> implements Map.Entry<K,V> {
    private K key;
    private V value;
    public MapEntry_37(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return this.key;
    }
    public V getValue() {
        return this.value;
    }
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
    public int hashCode() {
        return ((this.getKey() == null) ? 0 : this.getKey().hashCode())
                ^
                ((this.getValue() == null) ? 0 : this.getValue().hashCode());
    }
    public boolean equals(Object object) {
        if (!(object instanceof MapEntry)) {
            return false;
        }
        MapEntry me = (MapEntry)object;
        return (this.getKey() == null ? me.getKey() == null : this.getKey().equals(me.getKey()))
                &&
                (this.getValue() == null ? me.getValue() == null : this.getValue().equals(me.getValue()));
    }
    public String toString() {
        return this.key + " = " + this.value;
    }
}

class SimpleHashMap_37<K,V> extends AbstractMap<K,V> {
    private static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    ArrayList<MapEntry<K,V>>[] buckets = new ArrayList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            ArrayList<MapEntry<K,V>> bucket = null;
            oldValue = null;
            buckets[index] = new ArrayList<MapEntry<K,V>>();
            bucket  = buckets[index];
            bucket.add(new MapEntry<K,V>(key, value));
            return oldValue;
        } else {
            for (MapEntry<K,V> mapEntry : buckets[index]) {
                if (mapEntry.getKey().equals(key)) {
                    oldValue = (V) mapEntry.getValue();
                    mapEntry.setValue(value);
                    break;
                } else {
                    buckets[index].add(new MapEntry<K, V>(key, value));
                    break;
                }
            }
            return oldValue;
        }
    }
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        for (MapEntry<K,V> mapEntry : buckets[index]) {
            if (mapEntry.getKey().equals(key)) {
                return mapEntry.getValue();
            }
        }
        return null;
    }
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> entrySet = new HashSet<>();
        for (ArrayList<MapEntry<K,V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            } else {
                for (MapEntry<K,V> entry : bucket) {
                    entrySet.add(entry);
                }
            }
        }
        return entrySet;
    }
}

class MapPerformance_37 {
    private static Random random = new Random();
    static List<Test<SimpleHashMap_37<Integer, Integer>>> testList = new ArrayList<>();
    static {
        testList.add(new Test<SimpleHashMap_37<Integer,Integer>>("put") {
            public int test(SimpleHashMap_37<Integer,Integer> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    map.clear();
                    for (int j = 0; j < size; j++) {
                        map.put(i,j);
                    }
                }
                return loops * size;
            }
        });
        testList.add(new Test<SimpleHashMap_37<Integer,Integer>>("get") {
            public int test(SimpleHashMap_37<Integer,Integer> map, TestParam tp) {
                int loops = tp.loops * 10;
                int size = map.size();
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < size; j++) {
                        map.get(j);
                    }
                }
                return loops * size;
            }
        });
        testList.add(new Test<SimpleHashMap_37<Integer,Integer>>("iterate") {
            public int test(SimpleHashMap_37<Integer,Integer> map, TestParam tp) {
                int loops = tp.loops * 10;
                for(int i = 0; i < loops; i ++) {
                    Iterator it = map.entrySet().iterator();
                    while(it.hasNext())
                        it.next();
                }
                return loops * map.size();
            }
        });
    }
}

public class Example_37 {
    public static void main(String[] args) {
        Tester.run(new SimpleHashMap_37<>(), MapPerformance_37.testList);
    }
}
