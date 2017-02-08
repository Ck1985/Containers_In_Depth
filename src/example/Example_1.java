package example;
import java.util.*;
import containers.*;

/**
 * Created by anonymous on 2/8/2017.
 */
public class Example_1 {
    public static void main(String[] args){
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        for(int i = 0; i < Countries.DATA.length; i++){
            arrayList.add(Countries.DATA[i][0]);
            linkedList.add(Countries.DATA[i][1]);
        }
        System.out.println(arrayList);
        System.out.println(linkedList);
        Collections.sort(arrayList);
        Collections.sort(linkedList);
        System.out.println(arrayList);
        System.out.println(linkedList);
        for(int i = 1; i < 2; i++){
            Collections.shuffle(arrayList);
            Collections.shuffle(linkedList);
            System.out.println(arrayList);
            System.out.println(linkedList);
        }
        System.out.println("-----------------");
        List<String> al2 = new ArrayList<>();
        List<String> ll2 = new LinkedList<>();
        for(int i = 0; i < Countries.DATA.length; i++){
            al2.add(Countries.DATA[i][0]);
            ll2.add(Countries.DATA[i][1]);
        }
        Collections.shuffle(al2);
        Collections.shuffle(ll2);
        System.out.println("Countries: " + al2);
        System.out.println("Capitals: " + ll2);
        Collections.sort(al2);
        Collections.sort(ll2);
        System.out.println("Cpuntries: " + al2);
        System.out.println("Capitals: " + ll2);
    }
}
