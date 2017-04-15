package containers;

import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FailFast {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Iterator<String> iterator = c.iterator();
        c.add("An object");
        try {
            String s = iterator.next();
        } catch (ConcurrentModificationException e) {
            System.out.println(e);
        }
    }
}
