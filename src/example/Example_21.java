package example;
import containers.*;
import java.util.*;

/**
 * This is SimpleHashMap_21 Map, it implements Map interafce
 */

class SimpleHashMap_21<K,V> extends SimpleHashMap<K,V>{
    private LinkedHashMap<Map.Entry<K,V>, Integer> mapProbies = new LinkedHashMap<>();
    private int checkCollision(Map.Entry<K,V> mapEntry){
        boolean collision = false;
        int index = 0;
        int probies = 0;
        index = Math.abs(mapEntry.getKey().hashCode()) % SIZE;
        if (buckets[index] == null){
            return probies;
        } else {
            for (Map.Entry<K,V> entry : buckets[index]){
                if (!(entry.getKey().equals(mapEntry.getKey()) && (entry.getValue().equals(mapEntry.getValue())))){
                    return probies;
                } else {
                    probies++;
                }
            }
        }
        /*if (probies == 0){
            System.out.println("No Collision");
        } else {
            System.out.println("Exist Collision");
        }*/
        return probies;
    }
    private Map.Entry<K,V> createEntryCheck(final K keyentry,final V valueEntry){
        return new Map.Entry<K,V>(){
            private K key = keyentry;
            private V value = valueEntry;
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
            public String toString(){
                return this.key + " = " + this.value;
            }
        };
    }
    public V put(K key, V value){
        Map.Entry<K,V> entryCheck = this.createEntryCheck(key, value);
        int resultprobies = 0;
        resultprobies = this.checkCollision(entryCheck);
        if (resultprobies != 0) {
            this.mapProbies.put(entryCheck, this.checkCollision(entryCheck));
        }
        return super.put(key, value);
    }
    public void clearProbies(){
        this.mapProbies.clear();
    }
    public void showProbies(){
        System.out.println(mapProbies);
    }
}

public class Example_21 {
    public static void main(String[] args){
        SimpleHashMap_21 shm = new SimpleHashMap_21();
        shm.put("A",7);
        shm.put("B",9);
        shm.put("C",5);
        shm.put("D",6);
        System.out.println(shm);
        shm.put("C",5);
        shm.put("C",5);
        shm.put("B",9);
        shm.put("B",9);
        shm.put("B",9);
        shm.showProbies();
        SimpleHashMap_21 shm2 = new SimpleHashMap_21();
        shm2.putAll(Countries.capitals(10));
        shm2.putAll(Countries.capitals(10));
        //shm2.showProbies();
    }
}
