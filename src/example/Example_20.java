package example;
import java.util.*;
import containers.*;

/**
 * This is SimpleHashMap20 Map, it implements Map interafce
 */

class SimpleHashMap_20<K,V> extends SimpleHashMap<K,V>{
     private Set<MapEntry20> mapCollision = new LinkedHashSet<>();
     private class MapEntry20 implements Map.Entry<K,V>{
        private boolean collision = false;
        private K key;
        private V value;
        public MapEntry20(K key, V value){
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
            V oldValue = value;
            this.value = value;
            return oldValue;
        }
        public boolean equals(Object object){
            if (!(object instanceof Map.Entry)){
                return false;
            } else {
                return (this.key == ((Map.Entry)object).getKey()) && (this.value == ((Map.Entry)object).getValue());
            }
        }
        public void checkCollision(Map.Entry<K,V> check){
            if (this.equals(check)){
                collision = true;
            }
        }
        public String toString(){
            return this.getKey() + " = " + this.getValue();
        }
    }
    public V put(K key, V value){
        SimpleHashMap_20.MapEntry20 entry = this.createEntry20(key,value);
        for (Map.Entry<K,V> entryInSet : this.entrySet()){
            entry.checkCollision(entryInSet);
            if (entry.collision == true){
                mapCollision.add(entry);
                return null;
            }
        }
        return super.put(key, value);
    }
    public MapEntry20 createEntry20(K key, V value){
        return new MapEntry20(key, value);
    }
    public void showCollision(){
        System.out.println(this.mapCollision);
    }
}

public class Example_20 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        SimpleHashMap_20 shm = new SimpleHashMap_20();
        shm.put("Terry", 5);
        shm.put("Ronaldo", 9);
        shm.put("Messi", 10);
        shm.put("Canavaro", 3);
        shm.put("Maldini", 3);
        // System.out.println(shm);
        shm.put("Ronaldo", 9);
        shm.showCollision();
        SimpleHashMap_20 shm2 = new SimpleHashMap_20();
        shm2.putAll(Countries.capitals(10));
        shm2.putAll(Countries.capitals(10));
        shm2.showCollision();
    }
}
