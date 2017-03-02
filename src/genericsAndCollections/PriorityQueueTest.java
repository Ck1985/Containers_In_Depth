package genericsAndCollections;
import java.util.*;

/**
 * Created by anonymous on 3/2/2017.
 */
public class PriorityQueueTest {
    private static class PQComparator implements Comparator<Integer>{
        public int compare(Integer object1, Integer object2){
            return object2 - object1;
        }
    }
    public static void main(String[] args){
        int[] array = new int[]{1,5,3,8,7,9,6,4,2};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : array){
            pq.offer(num);
        }
        System.out.println(pq);
        for(Integer num : pq){
            System.out.print(num + " ");
        }
        System.out.println();
        //System.out.println("----");
        Iterator<Integer> it = pq.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
        for(int num : array){
            System.out.print(pq.poll() + " ");
        }
        //System.out.println("---");
        // System.out.println("\npq: " + pq);
        PQComparator pqc = new PQComparator();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(9,pqc);
        for(int num : array){
            pq2.offer(num);
        }
        System.out.println("size(): " + pq2.size());
        System.out.println("peek(): " + pq2.peek());
        System.out.println("size(): " + pq2.size());
        System.out.println("poll(): " + pq2.poll());
        System.out.println("size(): " + pq2.poll());
        System.out.println(pq2);
        for(Integer num : pq2){
            System.out.print(num + " ");
        }
        System.out.println();
        for(int num : array){
            System.out.print(pq2.poll() + " ");
        }
    }
}
