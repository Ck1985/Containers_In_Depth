package example;
import java.util.*;
import containers.*;

/**
 * This is SlowMap Map, it implements Map interface
 */

class SlowMap17<K,V> implements Map<K,V>{
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    private Set<Map.Entry<K,V>> entrySet = null;
    private Set<K> keySet = null;

    SlowMap17(){
        this.keySet = this.keySet();
    }

    private class MapEntry implements Map.Entry<K,V>{
        private K key;
        private V value;
        MapEntry(K key, V value){
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
        @SuppressWarnings("unchecked")
        public boolean equals(Object object){
            if (!MapEntry.class.isInstance(object)){
                return false;
            } else {
                MapEntry me = (MapEntry)object;
                return (this.key == null) ? me.key == null : this.key.equals(me.key)
                        &&
                        (this.value == null) ? me.value == null : this.value.equals(me.value);
            }
        }
        public int hashCode(){
            return this.key == null ? 0 : this.key.hashCode();
        }
        public String toString(){
            return this.key + " = " + this.value;
        }
    }
    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> updateEntrySet = new HashSet<>();
        Iterator<K> itKey = this.keys.iterator();
        Iterator<V> itValue = this.values.iterator();
        while(itKey.hasNext()){
            updateEntrySet.add(new MapEntry(itKey.next(), itValue.next()));
        }
        this.entrySet = updateEntrySet;
        return entrySet;
    }
    private class KeySet extends AbstractSet<K>{
        public int size(){
            return keys.size();
        }
        public Iterator<K> iterator(){
            return new Iterator<K>(){
                int index = -1;
                public boolean hasNext(){
                    return index < keys.size() - 1;
                }
                public K next(){
                    return keys.get(++index);
                }
                public void remove(){
                    keys.remove(index--);
                }
            };
        }
    }
    public Set<K> keySet(){
        keySet = new KeySet();
        return keySet;
    }
    @SuppressWarnings("unchecked")
    public V get(Object key){
        if (!this.keys.contains((K)key)){
            return null;
        } else {
            return this.values.get(this.keys.indexOf(key));
        }
    }
    public void clear(){
        this.keys.clear();
        this.values.clear();
    }
    @SuppressWarnings("unchecked")
    public boolean containsKey(Object key){
        return keySet.contains((K)key);
    }
    public V put(K key, V value){
        V oldValue = this.get(key);
       if (!this.containsKey(key)){
           this.keys.add(key);
           this.values.add(value);
       } else {
           this.values.set(this.keys.indexOf(key),value);
       }
       return oldValue;
    }

    public void putAll(Map<? extends K, ? extends V> map){
        Set<? extends K> keySet = map.keySet();
        Collection<? extends V> values = map.values();
        Iterator<? extends K> iterator = keySet.iterator();
        Iterator<? extends V> iterator2 = values.iterator();
        while(iterator.hasNext()){
            this.put(iterator.next(),iterator2.next());
        }
    }
    public int size(){
        return this.keys.size();
    }
    @SuppressWarnings("unchecked")
    public boolean containsValue(Object value){
        return this.values.contains((V)value);
    }
    public boolean isEmpty(){
        return this.keys.size() == 0;
    }
    public Collection<V> values(){
        return this.values;
    }
    @SuppressWarnings("unchecked")
    public V remove(Object key){
        if (!this.keys.contains((K)key) || this.values.get(this.keys.indexOf((K)key)) == null){
            return null;
        } else {
            V removeValue = this.values.get(this.keys.indexOf(key));
            this.values.remove(this.keys.indexOf(key));
            this.keys.remove(key);
            return removeValue;
        }
    }
    public String toString(){
        return this.entrySet().toString();
    }
}
public class Example_17 {
    private static void testSlowMap17(SlowMap17<String,String> slowMap){
        Map<String,String> countriesMap = Countries.capitals(10);
        slowMap.putAll(countriesMap);
        System.out.println("slowMap17: \n" + slowMap);
        slowMap.put("MacOs", "Steve Job");
        slowMap.put("Window", "Bill Gate");
        slowMap.put("Linux","???");
        System.out.println("slowMap17: size = " + slowMap.size() + "\n" + slowMap);
        slowMap.remove("Window");
        slowMap.remove("Linux");
        System.out.println("slowMap17: size = " + slowMap.size() + "\n" + slowMap);
        System.out.println("slowMap17.containsKey(\"MacOs\"): " + slowMap.containsKey("MacOs"));
        System.out.println("slowMap17.containsValue(\"Luanda\"): " + slowMap.containsValue("Luanda"));
        System.out.println("slowMap17.containsKey(xxx): " + slowMap.containsKey("xxx"));
        slowMap.clear();
        System.out.println(slowMap);
    }
    public static void main(String[] args){
        testSlowMap17(new SlowMap17<String,String>());
    }
}
