package containers;
import java.util.*;

/**
 * This is SlowMap Map, it implements Map interafce
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V>{
    // Choose a prime number for hash table
    //Size, to achieve a uniform distribution
    private static final int SIZE = 97;
    @SuppressWarnings("unchecked")
    // We can not have a physical of array generic, but we can upcast to it
    LinkedList<Map.Entry<K,V>>[] buckets = new LinkedList[this.SIZE];
    public V put(K key, V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null){
            buckets[index] = new LinkedList<Map.Entry<K,V>>();
        }
        LinkedList<Map.Entry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<>(key,value);
        boolean found = false;
        ListIterator<Map.Entry<K,V>> iterator = bucket.listIterator();
        while(iterator.hasNext()){
            Map.Entry<K,V> iPair = iterator.next();
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
    public V get(Object key){
        int index = Math.abs(key.hashCode()) % SIZE;
        V value = null;
        if (buckets[index] == null){
            return null;
        } else {
            LinkedList<Map.Entry<K,V>> entries = buckets[index];
            ListIterator<Map.Entry<K,V>> itEntry = entries.listIterator();
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
    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> entrySet = new HashSet<>();
        for (LinkedList<Map.Entry<K,V>> bucket : buckets){
            if (bucket == null){
                continue;
            } else {
                for (Map.Entry<K,V> entry : bucket){
                    entrySet.add(entry);
                }
            }
        }
        return entrySet;
    }
    public static void main(String[] args){
        SimpleHashMap<String,String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.putAll(Countries.capitals(25));
        System.out.println(simpleHashMap);
        System.out.println(simpleHashMap.get("ERITREA"));
        System.out.println(simpleHashMap.entrySet());
    }
}
