package example;

import java.util.*;

/**
 * This is SlowMap Map, it implements Map interafce
 */

class Entry_25<K,V> implements Map.Entry<K,V>{
    private K key;
    private V value;
    private Entry_25 nextEntry;

    public Entry_25(K key, V value, Entry_25<K,V> nextEntry){
        this.key = key;
        this.value = value;
    }
    public Entry_25(K key, V value){
        this(key, value, null);
    }

    public K getKey(){
         return this.key;
    }
    public V getValue(){
        return this.value;
    }
    public Entry_25 getNextEntry(){
        return this.nextEntry;
    }
    public V setValue(V value){
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
    public Entry_25 setNextEntry(Entry_25<K,V> nextEntry){
        Entry_25<K,V> oldNextEntry = this.nextEntry;
        this.nextEntry = nextEntry;
        return oldNextEntry;
    }
    public int hashCode(){
        return ((this.key == null) ? 0 : this.key.hashCode()) ^ ((this.value == null) ? 0 : this.value.hashCode());
    }
    @SuppressWarnings("unchecked")
    public boolean equals(Object o){
        if (!(o instanceof Entry_25)){
            return false;
        } else {
            Entry_25<K,V> eo = (Entry_25)o;
            return  (this.key == null) ? (eo.getKey() == null) : (this.key.equals(eo.getKey()))
                    &&
                    (this.value == null) ? (eo.getValue() == null) : (this.value.equals(eo.getValue()));
        }
    }
    public String toString(){
        return this.key + " = " + this.value;
    }
}
class SimpleHashMap_25<K,V> extends AbstractMap<K,V> {
    private static final int SIZE = 5;
    @SuppressWarnings("unchecked")
    private LinkedList<Entry_25<K,V>>[] buckets = new LinkedList[SIZE];
    Set<Map.Entry<K,V>> entrySet = new HashSet<>();
    public V put(K key, V value){
        V oldValue = null;
        boolean found = false;
        int index = Math.abs(key.hashCode()) % SIZE;
        //@SuppressWarnings("unchecked")
        // LinkedList<Entry_25<K,V>> bucket = this.buckets[index];
        Entry_25<K,V> newEntry_25 = null;
        if (this.buckets[index] == null){
            this.buckets[index] = new LinkedList<Entry_25<K,V>>();
            newEntry_25 = new Entry_25<K, V>(key, value);
            this.buckets[index].add(newEntry_25);
            found = true;
        } else {
            for (Entry_25<K,V> entry_25 : this.buckets[index]) {
                if (entry_25.getKey().equals(key)) {
                    oldValue = entry_25.getValue();
                    found = true;
                    int indexCurrent = this.buckets[index].indexOf(entry_25);
                    //bucket.add(indexCurrent,newEntry_25);
                    if (indexCurrent == 0){
                        int indexNextEntry = indexCurrent + 1;
                        Entry_25<K,V> nextEntry = this.buckets[index].get(indexNextEntry);
                        this.buckets[index].set(indexCurrent, new Entry_25<K,V>(key, value, nextEntry));
                    } else if (indexCurrent > 1 || indexCurrent == 1){
                        int indexPrevEntry = indexCurrent - 1;
                        int indexNextEntry = indexCurrent + 1;
                        Entry_25<K,V> prevEntry = this.buckets[index].get(indexPrevEntry);
                        Entry_25<K,V> nextEntry = this.buckets[index].get(indexNextEntry);
                        newEntry_25 = new Entry_25<K,V>(key, value, nextEntry);
                        this.buckets[index].set(indexCurrent, newEntry_25);
                        newEntry_25 = prevEntry.getNextEntry();
                    }
                }
            }
        }
        if (!found){
            newEntry_25 = new Entry_25<K,V>(key, value);
            this.buckets[index].add(newEntry_25);
            int indexCurrent = this.buckets[index].indexOf(newEntry_25);
            int indexPrev = indexCurrent - 1;
            Entry_25<K,V> prevEntry = this.buckets[index].get(indexPrev);
            prevEntry.setNextEntry(newEntry_25);
        }
        return oldValue;
    }
    public V get(Object key){
        int index = Math.abs(key.hashCode()) % SIZE;
        V value = null;
        if (this.buckets[index] == null){
            return null;
        } else {
            for (Entry_25<K,V> entry_25 : this.buckets[index]){
                if (entry_25.getKey().equals(key)){
                    value = entry_25.getValue();
                    break;
                }
            }
        }
        return value;
    }
    public Set<Map.Entry<K,V>> entrySet(){
        for (LinkedList<Entry_25<K,V>> bucket : buckets){
            if (bucket == null){
                continue;
            } else {
                for (Entry_25<K,V> entry_25 : bucket){
                    entrySet.add(entry_25);
                }
            }
        }
        return entrySet;
    }
    public String toString(){
        StringBuilder sp = new StringBuilder(" ");
        for (LinkedList<Entry_25<K,V>> bucket : buckets){
            if (bucket != null) {
                for (Entry_25<K, V> entry : bucket) {
                    sp.append(entry.toString() + ", ");
                }
            }
        }
        return sp.toString();
    }
}
public class Example_25 {
    public static void main(String[] args){
        SimpleHashMap_25<String, Integer> shm = new SimpleHashMap_25<>();
        shm.put("AB", 1);
        shm.put("C", 2);
        shm.put("BA", 3);
        // shm.put("AB",4);
        System.out.println(shm);
        System.out.println(shm.entrySet());
        Set<Map.Entry<String, Integer>> entrySet = shm.entrySet();
        for (Map.Entry<String, Integer> entry_25 : entrySet){
            if (entry_25.getKey().equals("AB")) {
                System.out.println(((Entry_25)entry_25).getNextEntry());
                break;
            }
        }
    }
}
