/*package containers;
import java.util.*;

/**
 * Created by anonymous on 2/19/2017.
 */
/*public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    public V put(K key, V value){
        V oldValue = this.get(key);
        if (!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }
    public V get(Object key){
        if (!keys.contains(key)){
            return null;
        }else {
            return values.get(keys.indexOf(key));
        }
    }
    public Set<Entry<K,V>> entrySet(){
        Set<Entry<K,V>> entries = new HashSet<>();
        Iterator<K> ik = keys.iterator();
        Iterator<V> iv = values.iterator();
        while(ik.hasNext()){
            entries.add(new MapEntry<K,V>())
        }
    }
    public static void main(String[] args){

    }
}*/
