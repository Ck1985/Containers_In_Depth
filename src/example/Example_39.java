package example;

import java.util.*;
import net.mindview.util.*;

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
    public String toString() {
        return this.key + " = " + this.value;
    }
}
class SimpleHashMap_39<K,V> extends AbstractMap<K,V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int MAX_CAPACITY = 1 << 30;
    private int capacity;
    private final float loadFactor;
    private float thresHold;
    @SuppressWarnings("unchecked")
    private LinkedList<MapEntry_39<K,V>>[] buckets = new LinkedList[DEFAULT_INITIAL_CAPACITY];

    public SimpleHashMap_39() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        this.thresHold = (float)capacity * loadFactor;
    }
    private V putVal(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % capacity;
        if (buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry_39<K,V>>();
        }
        LinkedList<MapEntry_39<K,V>> bucket = buckets[index];
        MapEntry_39<K,V> pair = new MapEntry_39<>(key,value);
        boolean found = false;
        ListIterator<MapEntry_39<K,V>> iterator = bucket.listIterator();
        while(iterator.hasNext()){
            MapEntry_39<K,V> iPair = iterator.next();
            if(iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                iterator.set(pair);
                found = true;
                break;
            }
        }
        if (!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }
    public V put(K key, V value) {
        V oldValue = null;
        if (checkExceedLoadFactor()) {
            reHash();
            oldValue = this.putVal(key, value);
        } else {
            oldValue = this.putVal(key, value);
        }
        return oldValue;
    }
    public V get(Object key){
        int index = Math.abs(key.hashCode()) % this.capacity;
        V value = null;
        if (buckets[index] == null){
            return null;
        } else {
            LinkedList<MapEntry_39<K,V>> entries = buckets[index];
            ListIterator<MapEntry_39<K,V>> itEntry = entries.listIterator();
            while (itEntry.hasNext()){
                Map.Entry<K,V> entry = itEntry.next();
                if (entry.getKey().equals(key)){
                    value = entry.getValue();
                    break;
                }
            }
            return value;
        }
    }

    @SuppressWarnings("unchecked")
    private void reHash() {
        this.capacity <<= 1;
        this.thresHold = (float)this.capacity * this.loadFactor;
        LinkedList<MapEntry_39<K,V>>[] newBuckets = new LinkedList[this.capacity];
        int index = 0;
        for (LinkedList<MapEntry_39<K,V>> bucket : buckets) {
            if (bucket == null) {
                index++;
                continue;
            }
            newBuckets[index] = new LinkedList<MapEntry_39<K,V>>();
            for (MapEntry_39<K,V> entry : bucket) {
                newBuckets[index].add(entry);
            }
            index++;
        }
        this.buckets = newBuckets;
    }
    private boolean checkExceedLoadFactor() {
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
    public int capacity() {
        return capacity;
    }
}
public class Example_39 {
    public static void main(String[] args) {
        System.out.println("Testing SimpleHashMap_39 basic: ");
        SimpleHashMap_39<String,String> shm = new SimpleHashMap_39<>();
        shm.putAll(Countries.capitals(10));
        System.out.println("shm: \n" + shm);
        System.out.println("shm.get(CHAD): " + shm.get("CHAD"));
        System.out.println("shm.size(): " + shm.size());
        System.out.println("shm.capacity(): " + shm.capacity());
        System.out.println("Testing reHash(): ");
        SimpleHashMap_39<Integer,Integer> shm2 = new SimpleHashMap_39<>();
        System.out.println("shm2: ");
        System.out.println("shm2.size(): " + shm2.size());
        System.out.println("shm2.capacity(): " + shm2.capacity());
        RandomGenerator.Integer rgi = new RandomGenerator.Integer(10000);
        shm2.putAll(MapData.map(rgi,rgi,10));
        System.out.println("shm2.size(): " + shm2.size());
        System.out.println("shm2.capacity(): " + shm2.capacity());
        shm2.putAll(MapData.map(rgi,rgi,20));
        System.out.println("shm2.size(): " + shm2.size());
        System.out.println("shm2.capacity(): " + shm2.capacity());
        shm2.putAll(MapData.map(rgi,rgi,40));
        System.out.println("shm2.size(): " + shm2.size());
        System.out.println("shm2.capacity(): " + shm2.capacity());

    }
}
