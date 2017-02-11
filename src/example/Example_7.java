package example;
import java.util.*;
import net.mindview.util.*;
/**
 * Created by anonymous.vn1985 on 2/11/2017.
 */
public class Example_7 {
    private static ArrayList<String> arrayList = new ArrayList<>();
    private static LinkedList<String> linkedList = new LinkedList<>();
    public static ArrayList<String> createArrayList(){
        ArrayList<String> arrayList = new ArrayList<>(Countries.names(25));
        return arrayList;
    }
    public static LinkedList<String> createLinkedList(){
        LinkedList<String> linkedList = new LinkedList<>(Countries.names(25));
        return linkedList;
    }
    public static void printList(List<String> list){
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    public static void insertByListIterator(ArrayList<String> arrayList, LinkedList<String> linkedList){
        ListIterator<String> listIterator = linkedList.listIterator();
        while(listIterator.hasNext()){
            arrayList.add(listIterator.next());
        }
    }
    public static void main(String[] args){

    }
}
