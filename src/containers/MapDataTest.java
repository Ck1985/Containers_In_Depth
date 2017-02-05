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
    public Pair<Integer, String> next() {
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
        // A Pair Generator
        System.out.println(MapData.map(new Letters(),10));
        //Two separate generator
        System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(5),10));
        // A key generator and a single value
        System.out.println(MapData.map(new CountingGenerator.Character(), "Value",6));
        // A Iterable and a value generator
        System.out.println(MapData.map(new Letters(), new RandomGenerator.String(3)));
        // A Iterable and single value
        System.out.println(MapData.map(new Letters(), "value"));
    }
}
