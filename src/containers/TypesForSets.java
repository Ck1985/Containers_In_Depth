package containers;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/13/2017.
 */
class SetType{
    int i;
    public SetType(int n){
        this.i = n;
    }
    public boolean equals(Object object){
        return (object instanceof SetType) && (this.i == ((SetType)object).i);
    }
    public String toString(){
        return Integer.toString(i);
    }
}
class HashType extends SetType{
    public HashType(int n){
        super(n);
    }
    public int hasCode(){
        return i;
    }
}
class TreeType extends SetType implements Comparable<TreeType>{
    public TreeType(int n){
        super(n);
    }
    public int compareTo(TreeType arg){
        return this.i < arg.i ? 1 : (this.i == arg.i ? 0 : -1);
    }
}
public class TypesForSets {
    public <T> Set<T> fill(Set<T> set, Class<T> type){
        try {
            for (int i = 0; i < 10; i++) {
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return set;
    }
    public static void main(String[] args){

    }
}
