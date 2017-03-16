package containers;

import java.util.*;
import typeinfo.pets.*;
import holding.*;
/**
 * This is created by anonymous.vn1985@gmail.com, it implements Map interafce
 */

public class Individual implements Comparable<Individual>{
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public Individual(String name){
        this.name = name;
    }

    public Individual(){}

    public String toString(){
        return this.getClass().getSimpleName() + ((this.name == null) ? " " : this.name);
    }

    public long id(){
        return this.id;
    }

    public boolean equals(Object object){
        if (!(object instanceof Individual)){
            return false;
        }
        if (this.id == ((Individual)object).id()){
            return true;
        }
        return false;
    }

    public int hashCode(){
        int result = 17;
        result = 37 * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = 37 * result + (int)this.id;
        return result;
    }

    public int compareTo(Individual arg) {
        String thisNameClass = this.getClass().getSimpleName();
        String argNameclass = arg.getClass().getSimpleName();
        int firstCondition;
        firstCondition = thisNameClass.compareTo(argNameclass);
        if (firstCondition != 0) {
            return firstCondition;
        }
        if (this.name != null && arg.name != null) {
            int secondCondition = this.name.compareTo(arg.name);
            if (secondCondition != 0) {
                return secondCondition;
            }
        }
        return (this.id > arg.id) ? -1 : ((this.id == arg.id) ? 0 : 1);
    }
}
