package containers;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/5/2017.
 */
public class Pair<K,V> {
    public final K key;
    public final V value;
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
}
