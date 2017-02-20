package theCollectionFramework;
import java.util.*;

/**
 * Created by anonymous on 2/20/2017.
 */
public class LinkedListDemo {
    public static void main(String[] args){
        //Create Linked List empty
        LinkedList<String> linkedList = new LinkedList<>();
        //Add elements to linked list
        linkedList.add("F");
        linkedList.add("B");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("C");
        linkedList.addLast("Z");
        linkedList.addFirst("A");
        linkedList.add(1,"K");
        System.out.println("Original of linked list: " + linkedList);
        //Remove elements
        linkedList.remove("D");
        linkedList.remove(3);
        System.out.println("Content li.ked list after deletion: " + linkedList);
        //Remove first and remove last:
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("linked list after remove first and last" + linkedList);
        // Get and Set value
        String value = linkedList.get(2);
        linkedList.set(2,value + " changed");
        System.out.println(linkedList);
    }
}
