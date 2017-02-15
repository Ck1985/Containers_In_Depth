package example;
import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous on 2/15/2017.
 */
public class Example_9 {
    public static void main(String[] args){
        TreeSet<String> sortedSet = new TreeSet<String>();
        RandomGenerator.String string = new RandomGenerator.String(7);
        for(int i = 0; i < 10; i++){
            sortedSet.add(string.next());
        }
        System.out.println(sortedSet);
    }
}
