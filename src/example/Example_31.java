package example;

import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

class StringContainer {
    private static int sizeArrayBackground = 1000;
    private String[] arrayBackground = new String[sizeArrayBackground];
    private int index = 0;

    public boolean add(String object){
        if (index < sizeArrayBackground) {
            this.arrayBackground[this.index++] = object;
        } else {
            sizeArrayBackground = sizeArrayBackground * 2;
            String[] newArray = Arrays.copyOf(arrayBackground, sizeArrayBackground);
            arrayBackground = newArray;
        }
        return true;
    }

    public String get(int index){
        if (index < 0 || index > this.sizeArrayBackground) {
            throw new IndexOutOfBoundsException();
        } else {
            return this.arrayBackground[index];
        }
    }
    public String toString(){
        return Arrays.toString(this.arrayBackground);
    }
}
public class Example_31 {
    static long addTimeTest(StringContainer sh, int reps){
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            sh.add("anonymous.vn1985");
        }
        long end = System.nanoTime();
        return (end - start) / reps;
    }
    static long addTimeTest(ArrayList<String> arrayList, int reps){
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            arrayList.add("anonymous.vn1985");
        }
        long end = System.nanoTime();
        return (end - start) / reps;
    }
    static long getTimeTest(StringContainer sh, int reps){
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            sh.get(i);
        }
        long end = System.nanoTime();
        return (end - start) / reps;
    }
    static long getTimeTest(ArrayList<String> arrayList, int reps){
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            arrayList.get(i);
        }
        long end = System.nanoTime();
        return (end - start) / reps;
    }
    public static void main(String[] args){
        /*StringContainer container = new StringContainer();
        for (int i = 0; i < 3000; i++) {
            container.add("abc");
        }
        System.out.println(container);*/
        ArrayList<String> arrayList = new ArrayList<>();
        StringContainer sh = new StringContainer();
        System.out.println("Add time (nanosecond)");
        System.out.println("Mean of 1000");
        System.out.println("ArrayList add(): " + addTimeTest(arrayList, 1000));
        System.out.println("sh add(): " +addTimeTest(sh, 1000));
        System.out.println("Mean of 1000");
        System.out.println("ArrayList add(): " + addTimeTest(arrayList, 1000));
        System.out.println("sh add(): " + addTimeTest(sh, 1000));
        System.out.println();
        System.out.println("ArrayList get(): " + getTimeTest(arrayList, 1000));
        System.out.println("sh get(): " + getTimeTest(sh, 1000));
    }
}
