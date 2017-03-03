package example;
import java.util.*;
import containers.*;

/**
 * Created by anonymous on 3/2/2017.
 */
class SlowMap<K, V> extends AbstractMap<K, V>{
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    private Set<Map.Entry<K,V>> entrySet = null;
    private Set<K> keySet = null;
    private class MapEntry implements Map.Entry<K, V>{
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
        public V setValue(V newValue){
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }
        public int hashCode(){
            return (this.key == null) ? 0 : this.key.hashCode();
        }
        @SuppressWarnings("unchecked")
        public boolean equals(Object object){
            if (!(MapEntry.class.isInstance(object))){
                return false;
            } else {
                MapEntry me = (MapEntry)object;
                return (this.key == null ? me.getKey() == null : this.key.equals(me.getKey()))
                        &&
                        (this.value == null ? me.getValue() == null : this.value.equals(me.getValue()));
            }
        }
    }
    public V get(Object key){
        if(!this.keys.contains(key)){
            return null;
        }else{
            return this.values.get(this.keys.indexOf(key));
        }
    }
    public V put(K key, V value){
        V oldValue = this.get(key);
        if(!this.keys.contains(key)){
            this.keys.add(key);
            this.values.add(value);
        }else{
            this.values.set(this.keys.indexOf(key),value);
        }
        return oldValue;
    }
    public Set<Map.Entry<K,V>> entrySet(){
        this.entrySet = new HashSet<>();
        Iterator<K> iteratorKey = this.keys.iterator();
        Iterator<V> iteratorValue = this.values.iterator();
        SlowMap<K, V> slowMap = new SlowMap<>();
        while(iteratorKey.hasNext()){
            // entrySet.add(new MapEntry(iteratorKey.next(), iteratorValue.next()));
            entrySet.add(slowMap.new MapEntry(iteratorKey.next(), iteratorValue.next()));
        }
        return entrySet;
    }

    /*private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    private EntrySet entries = new EntrySet();
    public Set<Map.Entry<K,V>> entrySet() { return entries; }
    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }
    public V get(Object key) { // key is type Object, not K
        if(!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }
    private class MapEntry implements Map.Entry<K, V>{
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
        public V setValue(V newValue){
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }
        public int hashCode(){
            return (this.key == null) ? 0 : this.key.hashCode();
        }
        @SuppressWarnings("unchecked")
        public boolean equals(Object object){
            if (!(MapEntry.class.isInstance(object))){
                return false;
            } else {
                MapEntry me = (MapEntry)object;
                return (this.key == null ? me.getKey() == null : this.key.equals(me.getKey()))
                        &&
                        (this.value == null ? me.getValue() == null : this.value.equals(me.getValue()));
            }
        }
    }
    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        public int size() { return keys.size(); }
        public Iterator<Map.Entry<K,V>> iterator() {
            return new Iterator<Map.Entry<K,V>>() {
                private int index = -1;
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }
                @SuppressWarnings("unchecked")
                public Map.Entry<K,V> next() {
                    int i = ++index;
                    return new MapEntry(
                            keys.get(i), values.get(i));
                }
                public void remove() {
                    keys.remove(index);
                    values.remove(index--);
                }
            };
        }
    }*/
}
public class Example_16 {
    public static void main(String[] args){
        SlowMap<Integer, String> slowMap = new SlowMap<>();
        Maps.test(slowMap);
        //slowMap.putAll(new CountingMapData(25));
        //System.out.println(slowMap);
        //System.out.println(slowMap.keySet());
    }
}
