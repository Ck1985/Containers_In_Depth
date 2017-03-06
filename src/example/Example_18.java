package example;
import java.util.*;
/**
 * Created by anonymous on 3/5/2017.
 */
class SlowSet<K> implements Set<K>{
    private List<K> backedList = new ArrayList<>();
    public Object[] toArray(){

    }
    public int size(){
        return this.backedList.size();
    }
    public Iterator<K> iterator(){
        return new Iterator<K>(){
            private int index = -1;
            public boolean hasNext(){
                return this.index < backedList.size() - 1;
            }
            public K next(){
                return backedList.get(++this.index);
            }
            public void remove(){
                backedList.remove(this.index--);
            }
        };
    }
    public String toString(){
        return this.backedList.toString();
    }
}
public class Example_18 {
    public static void main(String[] args){
        SlowSet<String> slowSet = new SlowSet<>();
        slowSet.add("a");
        slowSet.add("b");
        slowSet.add("c");
        System.out.println(slowSet);
    }
}
