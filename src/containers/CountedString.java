package containers;
import java.util.*;

/**
 * This is good hashCode, it implements Map interafce
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;

    public CountedString(String str){
        this.s = str;
        created.add(s);
        for (String s2 : created) {
            if (s2.equals(s)){
                id++;
            }
        }
    }

    public String toString(){
        return "CountedString: " + this.s + ", id: " + this.id + ", hashCode: " + this.hashCode();
    }

    public int hashCode(){
         int result = 17;
         result = 37 * result + this.s.hashCode();
         result = 37 * result + this.id;
         return result;
    }

    public boolean equals(Object object){
        return (object instanceof CountedString)
                &&
                (this.s.equals(((CountedString)object).s))
                &&
                (this.id == ((CountedString)object).id);
    }

    public static void main(String[] args){
        Map<CountedString,Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("Hi");
            map.put(cs[i],i);
        }
        System.out.println(map);
        for (CountedString c : cs){
            System.out.println("Looking up: " + c);
            System.out.println(map.get(c));
        }
    }
}
