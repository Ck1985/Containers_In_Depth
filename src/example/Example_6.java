package example;
import java.util.*;

/**
 * Created by anonymous on 2/9/2017.
 */
public class Example_6 {
    public static void test(String msg, List<String> list){
        Collection<String> collection = list;
        Collection<String> subList = list.subList(1,8);
        Collection<String> collection2 = new ArrayList<>(subList);
        try{
            collection.retainAll(collection2);
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            collection.removeAll(collection2);
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            collection.add("X");
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            collection.addAll(collection2);
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            collection.remove("C");
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            list.set(0,"G");
        }catch(Exception e){
            System.out.println(e);
        }
        //Additional optional methods:
        try{
            list.add(2,"ZZZ");
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            list.addAll(3,collection2);
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            list.remove(4);
        }catch(Ex)
    }
    public static void main(String[] args){

    }
}
