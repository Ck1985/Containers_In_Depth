package genericsAndCollections;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 3/1/2017.
 */
public class SetTest {
    public static void main(String[] args){
        boolean[] ba = new boolean[6];
        Set s = new HashSet();
        //Set s = new TreeSet();
        ba[0] = s.add("a");
        ba[5] = s.add(new Object());
        ba[1] = s.add(new Integer(10));
        ba[2] = s.add("b");
        ba[3] = s.add("a");
        ba[4] = s.add(new Object());
        for(int i = 0; i < ba.length; i++){
            System.out.print(ba[i] + " ");
        }
        System.out.println("\n");

        for(Object object : s){
            System.out.print(object + " ");
        }
    }
}
