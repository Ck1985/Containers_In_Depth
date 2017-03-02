package genericsAndCollections;
import java.util.*;

/**
 * Created by anonymous on 3/2/2017.
 */
public class NaturalOrder {
    public static void main(String[] args){
        String[] strings = {">ff<", "> f<", ">f <", ">FF<"};
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(String string : strings){
            pq.offer(string);
        }
        for(int i = 0; i < strings.length; i++){
            System.out.print(pq.poll() + " ");
        }
    }
}
