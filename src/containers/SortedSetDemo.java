package containers;

/**
 * Created by anonymous on 2/15/2017.
 */
import java.util.*;

public class SortedSetDemo {
    public static void main(String[] args){
        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(sortedSet,("one two three four five six seven eight").split(" "));
        System.out.println("sortedSet: " + sortedSet);
        String lowest = sortedSet.first();
        String highest = sortedSet.last();
        System.out.println("lowest: " + lowest + "\n" + "highest: " + highest);
        Iterator<String> it = sortedSet.iterator();
        for(int i = 0; i <= 6; i++){
            if(i == 3){
                lowest = it.next();
            }else if(i == 6){
                highest = it.next();
            }else{
                it.next();
            }
        }
        System.out.println("low: " + lowest + ", high: "+ highest);
        System.out.println(sortedSet.subSet(lowest,highest));
        System.out.println(sortedSet.headSet(highest));
        System.out.println(sortedSet.tailSet(lowest));
    }
}
