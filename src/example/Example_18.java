package example;
import java.util.*;
/**
 * Created by anonymous on 3/5/2017.
 */
class SlowSet<K> implements Set<K>{
    private List<K> backedList = new ArrayList<>();

    public int hashCode(){
        return this.backedList.hashCode();
    }
    public Object[] toArray(){
        return this.backedList.toArray();
    }
    public <T> T[] toArray(T[] newArray){
        return this.backedList.toArray(newArray);
    }
    public boolean removeAll(Collection<?> collection){
        return this.backedList.removeAll(collection);
    }
    public boolean retainAll(Collection<?> collection){
        return this.backedList.retainAll(collection);
    }
    public boolean add(K e){
        return this.backedList.add(e);
    }
    public void clear(){
        this.backedList.clear();
    }
    public boolean contains(Object object){
        return this.backedList.contains(object);
    }
    public boolean isEmpty(){
        return this.backedList.isEmpty();
    }
    public boolean containsAll(Collection<?> collection){
        return this.backedList.containsAll(collection);
    }
    public boolean addAll(Collection<? extends K> collection){
        return this.backedList.addAll(collection);
    }
    public boolean remove(Object object){
        return this.backedList.remove(object);
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
        slowSet.add("Hi");
        System.out.println(slowSet);
        slowSet.add("There");
        System.out.println(slowSet);
        List<String> list = Arrays.asList("You", "cute", "pie");
        slowSet.addAll(list);
        System.out.println(slowSet);
        System.out.println("size(): " + slowSet.size());
        System.out.println("slowSet.contains(\"You\"): " + slowSet.contains("You"));
        System.out.println("slowSet.contains(\"me\"): " + slowSet.contains("me"));
        System.out.println("slowSet.containsAll(list): " + slowSet.contains(list));
        SlowSet<String> ss2 = new SlowSet<>();
        System.out.println("slowSet.containsAll(ss2): " + slowSet.containsAll(ss2));
        System.out.println("ss2.containsAll(slowset): " + ss2.containsAll(slowSet));
        ss2.add("You");
        ss2.add("cute");
        slowSet.removeAll(ss2);
        System.out.println(slowSet);
        System.out.println("slowset.hashCode(): " + slowSet.hashCode());
        List<String> list2 = Arrays.asList("Hi", "There", "pie");
        ss2.remove("You");
        System.out.println(ss2);
        System.out.println("ss2.isEmpty(): " + ss2.isEmpty());
        ss2.addAll(list2);
        System.out.println("ss2: " + ss2);
        String[] newArray = new String[3];
        System.out.println("slowSet.toArray(newArray): " + slowSet.toArray(newArray));
        for(int i = 0; i < newArray.length; i++){
            System.out.print(newArray[i] + " ");
        }
    }
}
