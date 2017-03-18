package containers;

import java.util.*;
/**
 * This is SlowMap Map, it implements Map interafce
 */

class TwoTuple<A,B> implements Comparable{
    final A first;
    final B second;
    public TwoTuple(A a, B b){
        this.first = a;
        this.second = b;
    }
    public int hashCode(){
        int result = 17;
        result = 37 * result + this.first.hashCode();
        result = 37 * result + this.second.hashCode();
        return result;
    }
    public boolean equals(Object object){
        if (!(object instanceof TwoTuple)){
            return false;
        }
        return (this.first.equals(((TwoTuple)object).first))
                &&
                (this.second.equals(((TwoTuple)object).second));
    }
    public int compareTo(Object object){
        if (!(object instanceof TwoTuple)){
            throw new ClassCastException();
        }
        TwoTuple tt = (TwoTuple)object;
        int compareFirst = this.first.hashCode() - tt.first.hashCode();
        int compareSecond = this.second.hashCode() - tt.second.hashCode();
        if (compareFirst != 0){
            return compareFirst > 0 ? 1 : -1;
        } else {
            return (compareSecond == 0) ? 0 : ((compareSecond > 0) ? 1 : -1);
        }
    }
    public String toString(){
        return "(" + this.first + ", " + this.second + ")";
    }
}
class ThreeTuple<A,B,C> extends TwoTuple<A,B> implements Comparable{
    final C third;
    public ThreeTuple(A a,B b,C c){
        super(a,b);
        this.third = c;
    }
    public int hashCode(){
        int result = super.hashCode();
        result = 37 * result + third.hashCode();
        return result;
    }
    public boolean equals(Object object){
        if (!(object instanceof ThreeTuple)){
            return false;
        } else {
            return (first.equals(((ThreeTuple)object).first))
                    &&
                    (second.equals(((ThreeTuple)object).second))
                    &&
                    (third.equals(((ThreeTuple)object).third));

        }
    }
    public int compareTo(Object object){
        if (!(object instanceof ThreeTuple)){
            throw new ClassCastException();
        }
        ThreeTuple tt = (ThreeTuple)object;
        int compareFirst = first.hashCode() - tt.first.hashCode();
        int compareSecond = second.hashCode() - tt.second.hashCode();
        int compareThird = third.hashCode() - tt.third.hashCode();

        if (compareFirst != 0){
            return (compareFirst > 0) ? 1 : -1;
        } else {
            if (compareSecond != 0){
                return (compareSecond > 0) ? 1 : -1;
            } else {
                if (compareThird != 0){
                    return (compareThird > 0) ? 1 : -1;
                } else {
                    return 0;
                }
            }
        }
    }
    public String toString(){
        return "(" + first + ", " + second + ", " + third + ")";
    }
}
class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C> implements Comparable{
    final D four;
    public FourTuple(A a, B b, C c, D d){
        super(a,b,c);
        this.four = d;
    }
    public int hashCode(){
        int result = super.hashCode();
        result = 37 * result + this.four.hashCode();
        return result;
    }
    public boolean equals(Object object){
        if (!(object instanceof FourTuple)){
            return false;
        } else {
            FourTuple ft = (FourTuple)object;
            return (first.equals(ft.first))
                    &&
                    (second.equals(ft.second))
                    &&
                    (third.equals(ft.third))
                    &&
                    (this.four.equals(ft.four));
        }
    }
    public int compareTo(Object object){
        if (!(object instanceof FourTuple)){
            throw new ClassCastException();
        }
        FourTuple ft = (FourTuple)object;
        int compareFirst = first.hashCode() - ft.first.hashCode();
        int compareSecond = second.hashCode() - ft.second.hashCode();
        int compareThird = third.hashCode() - ft.third.hashCode();
        int compareFour = four.hashCode() - ft.four.hashCode();

        if (compareFirst != 0){
            return (compareFirst > 0) ? 1 : -1;
        } else {
            if (compareSecond != 0){
                return (compareSecond > 0) ? 1 : -1;
            } else {
                if (compareThird != 0){
                    return (compareThird > 0) ? 1 : -1;
                } else {
                    if (compareFour != 0){
                        return (compareFour > 0) ? 1 : -1;
                    } else{
                        return 0;
                    }
                }
            }
        }
    }
    public String toString(){
        return "(" + first + ", " + second + ", " + third + ", " + this.four + ")";
    }
}
class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D> implements Comparable{
    final E five;
    public FiveTuple(A a,B b,C c,D d,E e){
        super(a,b,c,d);
        this.five = e;
    }
    public int hashCode(){
        int result = super.hashCode();
        result = 37 * result + five.hashCode();
        return result;
    }
    public boolean equals(Object object){
        if (!(object instanceof FiveTuple)){
            return false;
        } else {
            FiveTuple ft = (FiveTuple)object;
            return (first.equals(ft.first))
                    &&
                    (second.equals(ft.second))
                    &&
                    (third.equals(ft.third))
                    &&
                    (four.equals(ft.four))
                    &&
                    (five.equals(ft.five));
        }
    }
    public int compareTo(Object object){
        if (!(object instanceof FiveTuple)){
            throw new ClassCastException();
        }
        FiveTuple ft = (FiveTuple)object;
        int compareFirst = first.hashCode() - ft.first.hashCode();
        int compareSecond = second.hashCode() - ft.second.hashCode();
        int compareThird = third.hashCode() - ft.third.hashCode();
        int compareFour = four.hashCode() - ft.four.hashCode();
        int compareFive = five.hashCode() - ft.five.hashCode();

        if (compareFirst != 0){
            return (compareFirst > 0) ? 1 : -1;
        } else {
            if (compareSecond != 0){
                return (compareSecond > 0) ? 1 : -1;
            } else {
                if (compareThird != 0){
                    return (compareThird > 0) ? 1 : -1;
                } else {
                    if (compareFour != 0){
                        return (compareFour > 0) ? 1 : -1;
                    } else{
                        if (compareFive != 0){
                            return (compareFive > 0) ? 1 : -1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        }
    }
    public String toString(){
        return "(" + first + ", " + second + ", " + third + ", " + four + ", " + this.five + ")";
    }
}
public class Tuple {
    public static <A,B> TwoTuple<A,B> twoTuple(A a, B b){
        return new TwoTuple<>(a,b);
    }
    public static <A,B,C> ThreeTuple<A,B,C> threeTuple(A a, B b, C c){
        return new ThreeTuple<>(a,b,c);
    }
    public static <A,B,C,D> FourTuple<A,B,C,D> fourTuple(A a, B b, C c, D d){
        return new FourTuple<>(a,b,c,d);
    }
    public static <A,B,C,D,E> FiveTuple<A,B,C,D,E> fiveTuple(A a, B b, C c, D d, E e){
        return new FiveTuple<>(a,b,c,d,e);
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        Tuple tupel = new Tuple();
        FiveTuple t1b = new FiveTuple(1,1,1,1,1);
        FiveTuple t2b = new FiveTuple(1,1,1,2,1);
        FiveTuple t3b = new FiveTuple(1,1,1,1,1);
        FiveTuple t4b = new FiveTuple(1,1,1,1,0);

        System.out.println(t1b.compareTo(t1b));
        System.out.println(t1b.compareTo(t2b));
        System.out.println(t1b.compareTo(t3b));
        System.out.println(t1b.compareTo(t4b));

        List<FiveTuple> list = Arrays.asList(t1b,t2b,t3b,t4b);
        Set<FiveTuple> set = new TreeSet<>();
        set.addAll(list);
        System.out.println(set);
    }
}


