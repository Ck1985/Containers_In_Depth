package containers;
import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous on 2/10/2017.
 */
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a){
        a.add(1,"x"); // Add at location 1
        a.add("x"); // Add at end of List
        // Add a collection
        a.addAll(Countries.names(25));
        // Add a collection at location 3
        a.addAll(3,Countries.names(25));
        b = a.contains("1");
        b = a.containsAll(Countries.names(25));
        // List allows access random, which is cheap
        // for ArrayList, but expensive for LinkedList
        s = a.get(1); // Get (typed) object at location 1
        i = a.indexOf("1"); // Tell index of object
        b = a.isEmpty(); // Any elements in list ?
        it = a.iterator(); // Ordinary iterator
        lit = a.listIterator(); // ListIterator
        lit = a.listIterator(3); // start at location 3 iterator
        i = a.lastIndexOf("1"); // last match
        a.remove(1); // remove at location 1
        a.remove("3"); // remove object
        a.set(1,"y"); // set location 1 to "y"
        // Keep everything in argument
        //(Or everything are intersection of two collection)
        a.retainAll(Countries.names(25));
        // Remove everything that 's in the argument
        a.removeAll(Countries.names(25));
        a.size(); // How big is it ?
        a.clear(); // remove everything in colllection
    }
    public static void iterMotion(List<String> a){
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }
    public static void iterManipulation(List<String> a){
        ListIterator<String> li = a.listIterator();
        li.add("47");
        li.next();
        li.remove();
        li.next();
        li.set("47");
    }
    public static void testVisual(List<String> a){
        System.out.println("a: " + a);
        List<String> b = Countries.names(25);
        System.out.println("b: " + b);
        a.addAll(b);
        a.addAll(b);
        System.out.println("a: " + a);
        // Insert, remove, replace elements by using LostIterator
        ListIterator<String> x = a.listIterator(a.size() / 2);
        x.add("One");
        System.out.println("x: " + x);
        System.out.println("x.next(): " + x.next());
        x.remove();
        System.out.println("x.next(): " + x.next());
        x.set("47");
        System.out.println("a: " + a);
        // Traveler list backforward
        x = a.listIterator(a.size());
            while(x.hasPrevious()){
                System.out.print(x.previous() + " ");
            }
            System.out.println();
            System.out.println("testVisual finished");
        }
    //There are somethings, only LinkedList can do that
    public static void testLinkedList(){
        List<String> ll = new LinkedList<>();
        ll.addAll()
    }
    public static void main(String[] args){
        /*List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        ListIterator<Integer> li = list.listIterator();
        System.out.println(list);
        li.add(9);
        System.out.println(list);
        System.out.println(li.next());
        System.out.println(li.next());
        System.out.println(li.next());
        li.add(55);
        System.out.println(list);
        System.out.println(li.next());
        System.out.println(li.next());
        li.remove();
        System.out.println(list);*/


    }
}
