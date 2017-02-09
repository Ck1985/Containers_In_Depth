package containers;
import java.util.*;

/**
 * Created by anonymous on 2/9/2017.
 */
public class CollectionMethod {
    public static void main(String[] args){
        Collection<String> collection = new ArrayList<>();
        collection.addAll(Countries.names(6));
        collection.add("ten");
        collection.add("eleven");
        System.out.println("Collection: " + collection);
        //Make an array from List:
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        //Make a String array from List:
        String[] stringArray = collection.toArray(new String[0]);
        System.out.println(Arrays.toString(stringArray));
        System.out.println("Collection.max(): " + Collections.max(collection));
        System.out.println("Collections.min(): " + Collections.min(collection));

        Collection<String> collection2 = new ArrayList<>();
        collection2.addAll(Countries.names(6));
        collection.addAll(collection2);
        System.out.println(collection);
        collection.remove(Countries.DATA[0][0]);
        collection.remove(Countries.DATA[1][0]);
        System.out.println(collection);
        collection.removeAll(collection2);
        System.out.println(collection);
        collection.addAll(collection2);
        System.out.println(collection);

        String val = Countries.DATA[3][0];
        System.out.println("collection.contains(val): " + collection.contains(val));
        Collection<String> collection3 = ((List<String>)collection).subList(3,5);
        System.out.println("collection3: " + collection3);
        System.out.println("collection.containsAll(collection3): " + collection.containsAll(collection3));
        Collection<String> collection5 = new ArrayList<>();
        collection5.add(Countries.DATA[0][0]);
        collection5.add(Countries.DATA[2][0]);
        collection5.add(Countries.DATA[5][0]);
        System.out.println("collection.containsAll(collection5): " + collection.containsAll(collection5));
        collection2.retainAll(collection3);
        System.out.println("collection2: " + collection2);
        collection2.removeAll(collection3);
        System.out.println(collection2);
        System.out.println("collection2.isEmpty(): " + collection2.isEmpty());
        collection.clear();
        System.out.println("collection.clear(): " + collection);

        Collection<String> a = new ArrayList<>();
        a.add("one");
        a.add("two");
        a.add("three");
        Collection<String> b = new ArrayList<>();
        b.add("one");
        b.add("three");
        a.retainAll(b);
        System.out.println(a);
        System.out.println(b);
    }
}
