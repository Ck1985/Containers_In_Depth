package containers;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/20/2017.
 */
public class MapEntry<K,V> implements Map.Entry<K,V>{
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
        V result = this.value;
        this.value = value;
        return result;
    }
    public int hashCode(){
        return ((this.key == null) ? 0 : this.key.hashCode()) ^ ((this.value == null) ? 0 : this.value.hashCode());
    }
    public boolean equals(Object object){
        if (!(object instanceof MapEntry)){
            return false;
        }else {
            MapEntry mapEntry = (MapEntry)object;
            return (this.key == null ? mapEntry.getKey() == null : this.key.equals(mapEntry.getKey())) &&
                    (this.value == null ? mapEntry.getKey() == null : this.value.equals(mapEntry.getKey()));
        }
    }
    public String toString(){
        return "key = " + this.key + "----" + "value = " + this.value;
    }
}
