package containers;
import java.util.*;

/**
 * Created by anonymous on 2/19/2017.
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {
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
    public Set<Map.Entry<K, V>> entrySet(){
         Set<Map.Entry<K, V>> entrySet = new HashSet<>();
         Iterator<K> iteratorK = keys.iterator();
         Iterator<V> iteratorV = values.iterator();
         while(iteratorK.hasNext()){
             entrySet.add(new MapEntry<K, V>(iteratorK.next(), iteratorV.next()));
         }
         return entrySet;
    }
    public static void main(String[] args){
        SlowMap<String, String> slowMap = new SlowMap<>();
        slowMap.putAll(Countries.capitals(10));
        System.out.println(slowMap);
        System.out.println(slowMap.get("CHAD"));
        System.out.println(slowMap.entrySet());
    }
}
