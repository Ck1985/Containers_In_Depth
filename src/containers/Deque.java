package containers;
import java.util.*;

/**
 * Created by anonymous on 2/17/2017.
 */
public class Deque {
    static void fillTest(java.util.Deque<Integer> deque){
        for(int i = 20; i < 28; i++){
            deque.addFirst(i);
        }
        for(int i = 50; i < 56; i++){
            deque.addLast(i);
        }
    }
    public static void main(String[] args){
        java.util.Deque<Integer> deque = new LinkedList<>();
        fillTest(deque);
        System.out.println(deque);
        while(deque.size() != 0){
            System.out.print(deque.removeFirst() + " ");
        }
        fillTest(deque);
        while(deque.size() != 0){
            System.out.print(deque.removeLast() + " ");
        }
    }
}
