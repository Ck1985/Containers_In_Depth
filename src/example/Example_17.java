package example;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 3/4/2017.
 */
class SlowMap17<K,V> implements Map<K,V>{
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
    }

}
public class Example_17 {
    public static void main(String[] args){

    }
}
