package example;
import java.util.*;

/**
 * Created by anonymous on 2/16/2017.
 */
class MyClass{
    private static long count = 0;
    private final long id = count++;
    public String toString(){
        return "MyClass: " + this.id + "hashcode: " + this.hashCode();
    }
}
class MySortedSet<T> extends LinkedList<T>{
    private int compare(T object1, T object2){
        int com = object1.hashCode() - object2.hashCode();
        return (com > 0) ? 1 : (com == 0) ? 0 : -1;
    }
    public boolean add(T objectT){
    Iterator<T> iterator = this.iterator();
        if(!this.contains(objectT)) {
            int index = 0;
            while (iterator.hasNext()) {
                if(compare(iterator.next(),objectT) < 1){
                    index++;
                }
            }
            this.add(index,objectT);
            return true;
        }
        return false;
    }
}
public class Example_10 {
    public static void main(String[] args){
        MySortedSet<Integer> sortedSetInt = new MySortedSet<>();
        for(int i = 10; i >= 1; i--){
            sortedSetInt.add(i);
        }
        System.out.println(sortedSetInt);
        MySortedSet<MyClass> sortedSet2 = new MySortedSet<>();
        sortedSet2.add(new MyClass());
        sortedSet2.add(new MyClass());
        sortedSet2.add(new MyClass());
        sortedSet2.add(new MyClass());
        System.out.println(sortedSet2);
    }
}
