package genericsAndCollections;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by anonymous.vn1985 on 2/27/2017.
 */
public class ArrayListBasic {
    public static void main(String[] args){
        // List myList = new ArrayList();
        //List<String> myList = new ArrayList<String>();
        List<String> stringList = new ArrayList<>();
        String s = "Hi";
        stringList.add("String");
        stringList.add(s);
        stringList.add(s + s);
        System.out.println(stringList);
        System.out.println(stringList.size());
        System.out.println(stringList.contains(42));
        System.out.println(stringList.contains("HiHi"));
        stringList.remove("Hi");
        System.out.println(stringList.size());

        List intList = new ArrayList();
        intList.add(new Integer(45));
        intList.add(90);
    }
}
