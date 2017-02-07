package containers;
import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous on 2/7/2017.
 */
public class CountingIntegerList extends AbstractList<Integer>{
    private int size;
    public CountingIntegerList(int size){
        /*if(size < 0){
            this.size = 0;
        }else{
            this.size = size;
        }*/
        this.size = (size < 0 ? 0 : size);
    }
    public Integer get(int index){
        return Integer.valueOf(index);
    }
    public int size(){
        return this.size;
    }
    public static void main(String[] args){
        System.out.println(new CountingIntegerList(30));
    }
}
