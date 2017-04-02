package example;

import java.util.*;

import containers.Countries;
import performanceTestFrameWork.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

class SlowMap_36<K,V> extends AbstractMap<K,V> {
    private List<MapEntry<K,V>> entryList = new ArrayList<MapEntry<K,V>>();

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
        Set<Map.Entry<K,V>> entrySet = new HashSet<>();
        entrySet.addAll(entryList);
        return entrySet;
    }
}

public class Example_36 {
    public static void main(String[] args) {
        SlowMap_36<String, String> slowMap_36 = new SlowMap_36<>();
        slowMap_36.putAll(Countries.capitals(10));
        System.out.println(slowMap_36);
        System.out.println(slowMap_36.get("CHAD"));
        System.out.println(slowMap_36.entrySet());
    }
}
