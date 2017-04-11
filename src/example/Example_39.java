package example;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

class MapEntry_39<K,V> implements Map.Entry<K,V> {
    private K key;
    private V value;
    public MapEntry_39(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public V getValue() {
        return this.value;
    }
    public K getKey() {
        return this.key;
    }
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
    public int hashCode() {
        return ((this.key == null) ? 0 : this.key.hashCode())
                ^
                ((this.value == null) ? 0 : this.value.hashCode());
    }
    public boolean equals(Object object) {
        if (!(object instanceof MapEntry_39)) {
            return false;
        }
        MapEntry_39 me = (MapEntry_39)object;
        return ((this.key == null) ? me.getKey() == null : this.key.equals(me.getKey()))
                &&
                ((this.value == null) ? me.getValue() == null : this.value.equals(me.getValue()));
    }
}
class SimpleHashMap_39<K,V> extends AbstractMap<K,V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int MAX_CAPACITY = 1 << 30;
    private final float loadFactor;
    private float thresHold;
    @SuppressWarnings("unchecked")
    private LinkedList<MapEntry_39<K,V>>[] buckets = new LinkedList[DEFAULT_INITIAL_CAPACITY];

    public SimpleHashMap_39() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }
    public V put(K key, V value) {

    }
    private boolean checkExceedLoadFactor() {
        this.thresHold = (float)DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR;
        if (this.size() > this.thresHold) {
            return true;
        }
        return false;
    }
    public int size() {
        return this.entrySet().size();
    }
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> entrySet = new HashSet<Map.Entry<K,V>>();
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) {
                continue;
            } else {
                LinkedList<MapEntry_39<K,V>> bucket = buckets[i];
                ListIterator<MapEntry_39<K,V>> iterator = bucket.listIterator();
                while (iterator.hasNext()) {
                    entrySet.add(iterator.next());
                }
            }
        }
        return entrySet;
    }
}
public class Example_39 {
    public static void main(String[] args) {

    }
}
