package example;
import java.util.*;

/**
 * This is SlowMap Map, it implements Map interafce
 */

class MapEntry<K,V> implements Map.Entry<K,V>, Comparable<MapEntry<K,V>>{
    private K key;
    private V value;

    public MapEntry(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){
        return this.key;
    }
    public V getValue(){
        return this.value;
    }
    public V setValue(V value){
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
    public int hashCode(){
        return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
    }
    public boolean equals(Object object){
        if (!(object instanceof containers.MapEntry)){
            return false;
        } else {
            return (this.key == null ? ((MapEntry)object).getKey() == null : this.getKey().equals(((MapEntry)object).getKey()))
                    &&
                    (this.value == null ? ((MapEntry)object).getValue() == null : this.getValue().equals(((MapEntry)object).getValue()));
        }
    }

    public int compareTo(MapEntry<K,V> object) {
        return (this.getKey().hashCode() > object.getKey().hashCode()) ? 1 : ((this.getKey().hashCode() == object.getKey().hashCode()) ? 0 : -1);
    }

    public String toString() {
        return this.key + " = " + this.value;
    }
}
class SimpleHashMap<K,V> extends AbstractMap<K,V>{
    private static final int SIZE = 97;
    @SuppressWarnings("unchecked")
    protected LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
    public V put(K key, V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (this.buckets[index] == null){
            this.buckets[index] = new LinkedList<MapEntry<K,V>>();
        }
        LinkedList<MapEntry<K,V>> bucket = this.buckets[index];
        MapEntry<K,V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> iterator = bucket.listIterator();
        while(iterator.hasNext()){
            MapEntry<K,V> iPair = iterator.next();
            if (iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                iterator.set(pair);
                found = true;
                break;
            }
        }
        if (!found){
            this.buckets[index].add(pair);
        }
        return oldValue;
    }
    public V get(Object key){
        int index = Math.abs(key.hashCode()) % SIZE;
        if (this.buckets[index] == null){
            return null;
        }
        for (MapEntry<K,V> entry : this.buckets[index]){
            if (entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }
    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> entrySet = new HashSet<>();
        for (LinkedList<MapEntry<K,V>> bucket : buckets){
            if (bucket == null){
                continue;
            }
            for (MapEntry<K,V> entry : bucket){
                entrySet.add(entry);
            }
        }
        return entrySet;
    }
    public void clear(){
        this.entrySet().clear();
    }
    public V remove(Object key){
        V value = null;
        if (this.get(key) != null){
            int index = Math.abs(key.hashCode()) % SIZE;
            for (MapEntry<K,V> entry : buckets[index]){
                if (entry.getKey().equals(key)){
                    value = entry.getValue();
                    int i = buckets[index].indexOf(entry);
                    buckets[index].remove(i);
                    break;
                }
            }
        }
        return value;
    }
}
public class Example_22 {
    public static void main(String[] args){
        SimpleHashMap<String,String> m =
                new SimpleHashMap<String,String>();
        m.putAll(containers.Countries.capitals(5));
        System.out.println(m);
        System.out.println(m.get("ALGERIA"));
        System.out.println(m.remove("ALGERIA"));
        System.out.println(m.get("ALGERIA"));
        System.out.println(m.remove("ANGOLA"));
        System.out.println(m);
        m.clear();
        System.out.println(m);
    }
}
