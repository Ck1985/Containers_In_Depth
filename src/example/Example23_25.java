package example;

import java.util.*;
import containers.*;

/**
 * This is SimpleHashMap23_25 Map, it implements Map interafce
 */

/*class NodeEntry23_25<K,V> {
    private K key;
    private V value;
    private NodeEntry23_25<K,V> nextNodeEntry;

    public NodeEntry23_25(K key, V value, NodeEntry23_25<K,V> nextNodeEntry){
        this.key = key;
        this.value = value;
        this.nextNodeEntry = nextNodeEntry;
    }
    public NodeEntry23_25(K key, V value){
        this(key, value, null);
    }
    public String toString(){

    }
}*/
class Entry23_25<K,V> implements Map.Entry<K,V> {
    private K key;
    private V value;
    Entry23_25<K,V> nextEntry;
    public Entry23_25(K key, V value, Entry23_25<K,V> nextEntry){
        this.key = key;
        this.value = value;
        this.nextEntry = nextEntry;
    }
    public Entry23_25(K key, V value){
        this(key, value, null);
    }
    public K getKey(){
        return this.key;
    }
    public V getValue(){
        return this.value;
    }
    public Entry23_25<K,V> getNextEntry(){
        return this.nextEntry;
    }
    public V setValue(V value){
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
    public int hashCode(){
        return ((this.key == null) ? 0 : this.key.hashCode())
                ^
                ((this.value == null) ? 0 : this.value.hashCode());
    }
    public boolean equals(Object o){
        if (!(o instanceof Entry23_25)){
            return false;
        } else {
            Entry23_25 entry = (Entry23_25)o;
            return (this.key == null ? entry.getKey() == null : this.key.equals(entry.getKey()))
                    &&
                    (this.value == null ? entry.getValue() == null : this.value.equals(entry.getValue()));
        }
    }
    public String toString(){
        return this.key + " = " + this.value;
    }
}
class EntryListIterator<K,V> {
    Entry23_25<K,V> currentEntry;
    public EntryListIterator(Entry23_25<K,V> currentEntry){
        this.currentEntry = currentEntry;
    }
    public boolean hasNext(){
        return this.currentEntry.nextEntry != null;
    }
    public Entry23_25<K,V> next(){
        currentEntry = currentEntry.nextEntry;
        return currentEntry;
    }
    public void set(Entry23_25<K,V> entry){

    }
    public void insert(K key, V value){
        currentEntry.nextEntry = new Entry23_25<K,V>(key, value, currentEntry.nextEntry);
        currentEntry = currentEntry.nextEntry;
    }
    public void remove(){
        if (currentEntry.nextEntry != null){
            currentEntry.nextEntry = currentEntry.nextEntry.nextEntry;
        }
    }
}
//class SimpleHashMap23_25<K,V> implements Map<K,V>{
    class SimpleHashMap23_25<K,V> extends AbstractMap<K,V> {
    private static final int SIZE = 5;
    private EntryListIterator<K,V>[] buckets = new EntryListIterator[SIZE];
    @SuppressWarnings("unchecked")
    //private LinkedList<Entry23_25<K,V>>[] buckets = new LinkedList[SIZE];
    // private EntryListIterator<K,V>[] buckets = new EntryListIterator[SIZE];
    //private EntrySet entrySet = new EntrySet();
    //private KeySet keySet = new KeySet();
    // Three methods below for properly Iterator:
    /*private int firstNonEmptyLinkedList(){
        if (this.buckets.length < 1){
            return -1;
        }
        for (int i = 0; i < SIZE; i++){
            if (this.buckets[i] != null){
                return i;
            }
        }
        return -1;
    }
    private int start(int i){
        int first = this.firstNonEmptyLinkedList();
        if (i < first){
            return -1;
        } else if (i == first){
            return 0;
        } else {
            int indexI = 0;
            for (int j = first; j < i; j++){
                if (this.buckets[j] != null){
                    indexI += this.buckets[j].size();
                }
            }
            return indexI;
        }
    }
    private int end(int i){
        int first = this.firstNonEmptyLinkedList();
        if (i < first){
            return -1;
        } else {
            return start(i) + ((buckets[i] == null) ? 0 :buckets[i].size());
        }
    }*/
    //--------------------------------------------------------------//
    /*class EntrySet extends AbstractSet<Map.Entry<K,V>>{
        public int size(){
            return SimpleHashMap23_25.this.size();
        }
        public Iterator<Map.Entry<K,V>> iterator(){
            return new Iterator<Map.Entry<K,V>>(){
                private int index = -1;
                public boolean hasNext(){
                    return index < SimpleHashMap23_25.this.size() - 1;
                }
                public Map.Entry<K,V> next(){
                    int j = ++index;
                    for (int i = 0; i < SIZE; i++){
                        if (start(i) <= index && index < end(i)){
                            return new Entry23_25<K,V>(
                                    buckets[i].get(index - start(i)).getKey(),
                                    buckets[i].get(index - start(i)).getValue()
                            );
                        }
                    }
                    return null;
                }
                public void remove(){
                    for (int i = 0; i < SIZE; i++){
                        if (start(i) <= index && index < end(i)){
                            buckets[i].remove(index - start(i));
                            index--;
                        }
                    }
                }
            };
        }
    }*/
    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> entrySet = new HashSet<>();
        /*for (LinkedList<Entry23_25<K,V>> bucket : buckets){
            if (bucket != null){
                for (Entry23_25<K,V> entry : bucket){
                    EntryListIterator<K,V> iterator = new EntryListIterator<K, V>(entry);
                    while (iterator.hasNext()){
                        iterator.insert(entry.getKey(),entry.getValue());
                    }
                }
            }
        }*/
        return entrySet;
    }
    /*public Set<K> keySet(){
        return keySet;
    }
    class KeySet extends AbstractSet<K>{
        public int size(){
            return SimpleHashMap23_25.this.size();
        }
        public Iterator<K> iterator(){
            return new Iterator<K>(){
            private int index = -1;
                public boolean hasNext(){
                    return index < SimpleHashMap23_25.this.size() - 1;
                }
                public K next(){
                    int j = ++index;
                    for (int i = 0; i < SIZE; i++){
                        if (start(i) <= index && index < end(i)){
                            return buckets[i].get(index - start(i)).getKey();
                        }
                    }
                    return null;
                }
            };
        }
    }
    public int size(){
        int result = 0;
        for(LinkedList<Entry23_25<K,V>> bucket : buckets){
            if (bucket != null){
                result = result + bucket.size();
            }
        }
        return result;
    }*/
    public V put(K key, V value){
        int index = Math.abs(key.hashCode()) % SIZE;
        V oldValue = null;
        Entry23_25<K,V> node = new Entry23_25<>(null,null);
        if (this.buckets[index] == null){
            this.buckets[index] = new EntryListIterator<K,V>(node);
            this.buckets[index].insert(key,value);
        }
        EntryListIterator<K,V> bucket = this.buckets[index];
        boolean found = false;
        Entry23_25<K,V> newEntry = new Entry23_25<>(key,value);
        /*ListIterator<Entry23_25<K,V>> iterator = bucket.listIterator();
        while (iterator.hasNext()){
            Entry23_25<K,V> itNext = iterator.next();
            if (itNext.getKey().equals(key)){
                oldValue = itNext.getValue();
                iterator.set(newEntry);
                found = true;
                break;
            }
        }*/
        /*for (Entry23_25<K,V> entry : bucket){
            EntryListIterator<K,V> iterator = new EntryListIterator<>(entry);
            while(iterator.hasNext()){
                Entry23_25<K,V> nextEntry = iterator.next();
                if (nextEntry.getKey().equals(key)){
                    oldValue = nextEntry.getValue();
                    iterator.insert(key, value);
                    found = true;
                    break;
                }
            }
        }*/
        return oldValue;
    }
    public V get(Object key){
        V value = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        // ListIterator<Entry23_25<K,V>> iterator = this.buckets[index].listIterator();
        /*while (iterator.hasNext()){
            Entry23_25<K,V> itNext = iterator.next();
            if (itNext.getKey().equals(key)){
                value = itNext.getValue();
            }
        }*/
        /*LinkedList<Entry23_25<K,V>> bucket = buckets[index];
        for (Entry23_25<K,V> entry : bucket){
            EntryListIterator<K,V> iterator = new EntryListIterator<K, V>(entry);
            while (iterator.hasNext()){
                Entry23_25<K,V> nextEntry = iterator.next();
                if (nextEntry.getKey().equals(key)){
                    value = nextEntry.getValue();
                }
            }
        }*/
        return value;
    }
    /*public void clear(){
        for (LinkedList<Entry23_25<K,V>> bucket : buckets){
            if (bucket != null){
                bucket.clear();
            }
        }
    }
    public void putAll(Map<? extends K, ? extends V> map){
        for (Map.Entry<? extends K,? extends V> entryMap : map.entrySet()){
            K keyMap = entryMap.getKey();
            V valueMap = entryMap.getValue();
            this.put(keyMap, valueMap);
        }
    }
    public int hashCode(){
        return this.entrySet().hashCode();
    }
    public boolean containsValue(Object value){
        boolean found = false;
        for (Map.Entry<K,V> entry : this.entrySet()){
            if (entry.getValue().equals(value)){
                found = true;
            }
        }
        return found;
    }
    public boolean isEmpty(){
        return this.entrySet().isEmpty();
    }
    public boolean equals(Object object){
        boolean result = false;
        if (!(object instanceof SimpleHashMap23_25)){
            return false;
        } else {
            if (this.entrySet().equals(((SimpleHashMap23_25)object).entrySet())){
                result = true;
            }
        }
        return result;
    }
    public boolean containsKey(Object key){
        boolean found = false;
        for (LinkedList<Entry23_25<K,V>> bucket : buckets){
            if (bucket != null){
                for (Entry23_25<K,V> entry : bucket){
                    if (entry.getKey().equals(key)){
                        found = true;
                        break;
                    }
                }
            }
        }
        return found;
    }
    public Collection<V> values(){
        HashSet<V> values = new HashSet<>();
        for (LinkedList<Entry23_25<K,V>> bucket : buckets){
            if (bucket != null){
                for (Entry23_25<K,V> entry : bucket){
                    values.add(entry.getValue());
                }
            }
        }
        return values;
    }
    public V remove(Object key){
        V value = null;
        if (this.get(key) != null){
            int index = Math.abs(key.hashCode()) % SIZE;
            for (Entry23_25<K,V> entry : this.buckets[index]){
                if (entry.getKey().equals(key)){
                    value = entry.getValue();
                    int i = this.buckets[index].indexOf(entry);
                    this.buckets[index].remove(i);
                    break;
                }
            }
        }
        return value;
    }*/
    public String toString(){
        //return this.entrySet().toString();
        return Arrays.asList(buckets).toString();
    }
}
public class Example23_25 {
    public static void main(String[] args){
        /*SimpleHashMap23_25<String, String> shm = new SimpleHashMap23_25<>();
        shm.putAll(Countries.capitals(3));
        System.out.println(shm);
        System.out.println("entrySet: " + shm.entrySet());
        System.out.println("keyset: " + shm.keySet());
        System.out.println("values: " + shm.values());
        System.out.println("isEmpty: " + shm.isEmpty());
        System.out.println("containsKey(ALGERIA): " + shm.containsKey("ALGERIA"));
        System.out.println("containsValue(Porto-novo): " + shm.containsValue("Porto-novo"));
        System.out.println("get(ALGERIA): " + shm.get("ALGERIA"));
        System.out.println("remove(ALGERIA): " + shm.remove("ALGERIA"));
        System.out.println("After removing ALGERIA: " + shm.containsKey("ALGERIA"));
        System.out.println("get(ALGERIA): " + shm.get("ALGERIA"));
        System.out.println("map: " + shm);
        shm.clear();
        System.out.println("After clear(): " + shm + "\nand map: " + shm.isEmpty());
        shm.putAll(Countries.capitals(3));
        SimpleHashMap23_25<String,String> shm2 = new SimpleHashMap23_25<>();
        shm2.putAll(Countries.capitals(4));
        System.out.println("shm.equals(shm2)): " + shm.equals(shm2));
        System.out.println("shm: " + shm);
        System.out.println("shm2: " + shm2);
        shm2.remove("BOTSWANA");
        System.out.println("shm2: " + shm2 + "\nshm.equals(shm2): " + shm2.equals(shm));
        shm.entrySet().clear();
        System.out.println(shm);*/
        SimpleHashMap23_25<String,String> shm = new SimpleHashMap23_25<>();
        //shm.putAll(Countries.capitals(5));
        shm.put("A","A1");
        shm.put("B","B1");
        System.out.println(shm);
    }
}
