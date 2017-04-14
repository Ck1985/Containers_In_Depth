package containers;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class ListSortSearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Utilities.list);
        list.addAll(Utilities.list);
        System.out.println(list);
        Collections.shuffle(list,new Random(47));
        System.out.println("shuffle: " + list);
        //Using listIterator to trim off last element
        ListIterator<String> listIterator = list.listIterator(10);
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.remove();
        }
        System.out.println("Trimmed: " + list);
        Collections.sort(list);
        System.out.println("sort: " + list);
        String key = list.get(7);
        System.out.println("get(7): " + key);
        System.out.println("binarySearch(key): " + Collections.binarySearch(list,key));
        Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
        System.out.println("case insensitive order: " + list);
        key = list.get(7);
        System.out.println(key);
        int index = Collections.binarySearch(list, key, String.CASE_INSENSITIVE_ORDER);
        System.out.println(index);
    }
}
