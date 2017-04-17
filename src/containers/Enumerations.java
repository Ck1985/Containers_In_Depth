package containers;

import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class Enumerations {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(Countries.names(10));
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + ", ");
        }
        //Procedure an Enumeration from Collection /////////////////////
        enumeration = Collections.enumeration(new ArrayList<String>());
    }
}
