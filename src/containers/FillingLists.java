package containers;

/**
 * Created by anonymous on 2/4/2017.
 */
import java.util.*;

class StringAddress{
    private String s;
    public StringAddress(String s){
        this.s = s;
    }
    public String toString(){
        return super.toString() + " " + this.s;
    }
}
public class FillingLists {
    public static void main(String[] args){
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(6,new StringAddress("Hello")));
        System.out.println(list);
        Collections.fill(list,new StringAddress("World"));
        System.out.println(list);
    }
}
