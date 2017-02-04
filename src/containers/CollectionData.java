package containers;

/**
 * Created by anonymous on 2/4/2017.
 */
import java.util.*;
import net.mindview.util.*;

public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity){
        for(int i = 0; i < quantity; i++){
            this.add(gen.next());
        }
    }
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity){
        return new CollectionData<T>(gen,quantity);
    }
}
