package containers;
import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous on 2/4/2017.
 */
public class CollectionDataGeneration {
    public static void main(String[] args){
        System.out.println(new ArrayList<String>(CollectionData.list(new RandomGenerator.String(10),15)));
        System.out.println(new HashSet<Integer>(new CollectionData<Integer>(new RandomGenerator.Integer(),15)));
    }
}
