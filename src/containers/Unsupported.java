package containers;
import java.util.*;

/**
 * Created by anonymous on 2/9/2017.
 */
public class Unsupported {
    static void test(String msg, List<String> list){
        System.out.println("-------" + msg + "-------");
        Collection<String> collection = list;
        Collection<String> subList = list.subList(1,8);
        // Copy subList
        Collection<String> collection2 = new ArrayList<>(subList);
        try{
            collection.retainAll(collection2);
        }catch(Exception e){
            System.out.println("retainAll(): " + e);
        }
        try{
            collection.removeAll(collection2);
        }catch(Exception e){
            System.out.println("removeAll(): " + e);
        }
        try{
            collection.clear();
        }catch(Exception e){
            System.out.println("clear(): " + e);
        }
        try{
            collection.add("X");
        }catch(Exception e){
            System.out.println("add(): " + e);
        }
        try{
            collection.addAll(collection2);
        }catch(Exception e){
            System.out.println("addAll(): " + e);
        }
        try{
            collection.remove("C");
        }catch(Exception e){
            System.out.println("remove(): " + e);
        }
        try{
            list.set(0, "X");
        }catch(Exception e){
            System.out.println("set(): " + e);
        }
    }
    public static void main(String[] args){
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        /*test("Modifiable Copy", new ArrayList<String>(list));
        test("Array.asList()", list);
        test("UnmodifiableList()", Collections.unmodifiableList(list));*/
        System.out.println(list);
        System.out.println(list.size());
        list.set(1,"W");
        System.out.println(list);
        System.out.println(list.size());
    }
}
