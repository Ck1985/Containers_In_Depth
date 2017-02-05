package containers;
import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985 on 2/5/2017.
 */
public class MapData<K,V> extends LinkedHashMap<K,V>{
    //A single Pair generator:
    public MapData(Generator<Pair<K,V>> generator, int quantity){
        for(int i = 0; i < quantity; i++){
            Pair<K,V> p = generator.next();
            this.put(p.key, p.value);
        }
    }
    //Two separate generators:
    public MapData(Generator<K> genK, Generator<V> genV, int quantity){
        for(int i = 0; i < quantity; i++){
            this.put(genK.next(), genV.next());
        }
    }
    //A key Generator and a single value
    public MapData(Generator<K> genK, V value, int quantity){
        for(int i = 0; i < quantity; i++){
            this.put(genK.next(), value);
        }
    }
    //A Iterable and a value Generator
    public MapData(Iterable<K> keyK, Generator<V> genV){
        for(K key : keyK){
            this.put(key,genV.next());
        }
    }
    //A Iterable and a single value
    public MapData(Iterable<K> genK, V value){
        for(K key : genK){
            this.put(key, value);
        }
    }
    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> generator, int quantity){
        return new MapData<K, V>(generator, quantity);
    }
    public static <K,V> MapData<K,V> map(Generator<K> genK, Generator<V> genV, int quantity){
        return new MapData<K,V>(genK, genV, quantity);
    }
    public static <K,V> MapData<K,V> map(Generator<K> genK, V value, int quantity){
        return new MapData<K,V>(genK, value, quantity);
    }
    public static <K,V> MapData<K,V> map(Iterable<K> genK, Generator<V> genV){
        return new MapData<K,V>(genK, genV);
    }
    public static <K,V> MapData<K,V> map(Iterable<K> genK, V value){
        return new MapData<K,V>(genK, value);
    }
}
