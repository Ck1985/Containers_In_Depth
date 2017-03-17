package example;
import java.util.*;

/**
 * This is SlowMap Map, it implements Map interafce
 */
class CountedString{
    private  static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    private char c;

    public CountedString(String s, char c){
        this.s = s;
        this.c = c;
        this.created.add(this.s);
        for (String s2 : created){
            if (s2.equals(s)){
                this.id++;
            }
        }
    }
    public String toString(){
        return "CountedString: " + this.s + ", c: " + this.c + ", hashCode(): " + this.hashCode();
    }
    public int hashCode(){
        int result = 17;
        result = 37 * result + this.s.hashCode();
        //result = 37 * result + this.id;
        result = 37 * result + (int)this.c;
        return result;
    }
    /*public int hashCode(){
        int result = 17;
        result = 37 * result + this.s.hashCode();
        result = 37 * result + (int)this.c;
        return result;
    }*/
    public boolean equals(Object object){
        return (object instanceof CountedString)
                &&
                (this.s.equals(((CountedString)object).s))
                &&
                (this.c == ((CountedString)object).c)
                &&
                (this.id == ((CountedString)object).id);
    }
}
public class Example_26_27 {
    public static void main(String[] args){
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("anonymous",'x');
            map.put(cs[i],i);
        }

        System.out.println(map);
        for (CountedString cts : cs){
            System.out.println("Lookind up: " + cts);
            System.out.println(map.get(cts));
        }
    }
}
