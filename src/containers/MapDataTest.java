package containers;
import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985 on 2/5/2017.
 */
class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer>{
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    public Pair<Integer, String> next(){
        return new Pair<Integer, String>(number++, " " + letter++);
    }
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            public Integer next(){
                return number++;
            }
            public boolean hasNext(){
                return number < size;
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}
public class MapDataTest {
    public static void main(String[] args){

    }
}
