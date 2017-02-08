package example;
import java.util.*;
import containers.*;
import java.util.regex.*;

/**
 * Created by anonymous on 2/8/2017.
 */
public class Example_3 {
    public static void main(String[] args){
        Set<String> ls = new LinkedHashSet<>();
        Set<String> hs = new HashSet<>();
        Set<String> ts = new TreeSet<>();
        System.out.println("LinkedHashSet: " + ls);
        System.out.println("HashSet: " + hs);
        System.out.println("TreeSet: " + ts);
        Map<String, String> hm = new HashMap<>();
        Pattern pattern = Pattern.compile("Z[a-zA-Z]*");
        for(int i = 0; i < Countries.DATA.length; i++){
            if(pattern.matcher(Countries.DATA[i][0]).matches()){
                hm.put(Countries.DATA[i][0], Countries.DATA[i][0]);
            }
        }
        System.out.println(hm);
        System.out.println("hm.keySet(): " + hm.keySet());
        System.out.println("Adding hm.keySet()");
        ls.addAll(hm.keySet());
        hs.addAll(hm.keySet());
        ts.addAll(hm.keySet());
        System.out.println(ls);
        System.out.println(hs);
        System.out.println(ts);
        System.out.println("Adding 10 more times");
        for(int i = 0; i < 10; i++){
            ls.addAll(hm.keySet());
            hs.addAll(hm.keySet());
            ts.addAll(hm.keySet());
        }
        System.out.println("LinkedHashSet: " + ls);
        System.out.println("HashSet: " + hs);
        System.out.println("TreeSet: " + ts);
    }
}
