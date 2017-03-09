package example;
import java.util.*;

/**
 * This is SlowMap Map, it implements Map interafce
 */

class MapEntry<K,V> implements Map.Entry<K,V>{
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
        return (this.key.hashCode()) ^ (this.value.hashCode());
    }
    public boolean equals(Object object){
        if (!(object instanceof containers.MapEntry)){
            return false;
        } else {
            return (this.getKey().equals(((MapEntry)object).getKey()))
                    &&
                    (this.getValue().equals(((MapEntry)object).getValue()));
        }
    }
}
class SimpleHashMap<K,V> extends AbstractMap<K,V>{
    private static final int SIZE = 97;
    @SuppressWarnings("unchecked")
    protected LinkedList<Map.Entry<K,V>>[] buckets = new LinkedList[SIZE];
    public V put(K key, V value){
        int index = Math.abs(key.hashCode()) % SIZE;
        if (this.buckets[index] == null){
            this.buckets[index] = new LinkedList<Map.Entry<K,V>>();
        }
    }
}
public class Example_22 {
    public static void main(String[] args){

    }
}
