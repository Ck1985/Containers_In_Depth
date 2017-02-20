package theCollectionFramework;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/20/2017.
 */
public class ArrayListDemo {
    public static void main(String[] args){
        //Create an array list:
        ArrayList<String> al = new ArrayList<>();
        System.out.println("Initialize size of al: " + al.size());
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1,"A2");
        System.out.println("Size of al after additional: " + al.size());
        //Display the array List
        System.out.println("al: " + al);
        //Remove elements from array list:
        al.remove("F");
        al.remove(2);
        System.out.println("Size of Array List after remove: " + al.size());
        System.out.println("Content of Array List: " + al);
    }
}
