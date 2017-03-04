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
    private class MapEntry implements Map.Entry<K,V>{
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
    public Set<K> keySet(){
        Set<K> ks = keySet;
        if (ks == null){
            ks = new KeySet();
            keySet = ks;
        }
        return ks;
    }
    public V remove(Object key){
        V valueRemove = this.values.get(this.keys.indexOf(key));
        this.values.remove(this.keys.indexOf(key));
        this.keys.remove(key);
        return valueRemove;
    }
    public void clear(){
        this.keys.clear();
        this.values.clear();
    }

    final class KeySet extends AbstractSet<K>{
        public int size(){
            return keys.size();
        }
        public final Iterator<K> iterator(){
            return new Iterator<K>(){
                private int index = -1;
                public boolean hasNext(){
                    return index < keys.size() - 1;
                }
                public K next(){
                    int i = ++index;
                    return keys.get(i);
                }
                public void remove(){
                    keys.remove(index--);
                }
            };
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
}
public class Example_16 {
    public static void main(String[] args){
        SlowMap slowMap = new SlowMap();
        Maps.test(slowMap);
    }
}
