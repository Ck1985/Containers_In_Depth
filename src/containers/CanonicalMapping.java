package containers;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

class Element {
    private String ident;
    public Element(String id) {
        this.ident = id;
    }
    public String toString() {
        return this.ident;
    }
    public int hashCode() {
        return this.ident.hashCode();
    }
    protected void finalize() {
        System.out.println("Finalizing " + this.getClass().getSimpleName() + this.ident);
    }
}

class Key extends Element{
    public Key(String id) {
        super(id);
    }
}

class Value extends Element{
    public Value(String id) {
        super(id);
    }
}

public class CanonicalMapping {
    public static void main(String[] args) {
        int size = 1000;
        if (args.length > 0) {
            size = new Integer(args[0]);
        }
        Key[] keys = new Key[size];
        WeakHashMap<Key,Value> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key key = new Key(Integer.toString(i));
            Value value = new Value(Integer.toString(i));
            if (i % 3 == 0) {
                keys[i] = key;
            }
            map.put(key,value);
        }
        System.gc();
    }
}
