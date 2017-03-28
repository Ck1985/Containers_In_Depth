package example;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

class IntegerContainer {
    private int sizeArrayBackground = 0;
    private Integer[] arrayBackground = new Integer[sizeArrayBackground];

    //Resizing and copying will be decrease performance container
    public void add(Integer object) {
        sizeArrayBackground += 1;
        Integer[] newArray = new Integer[sizeArrayBackground];
        for (int i = 0; i < arrayBackground.length; i++) {
            newArray[i] = arrayBackground[i];
        }
        newArray[sizeArrayBackground - 1] = object;
        arrayBackground = newArray;
    }

    public Integer get(int index) {
        if (index < -1 || index > sizeArrayBackground) {
            throw new IndexOutOfBoundsException();
        } else {
            return arrayBackground[index];
        }
    }

    public int size(){
        return this.sizeArrayBackground;
    }

    public void incrementAll(){
        for (int i = 0; i < sizeArrayBackground; i++) {
            arrayBackground[i]++;
        }
    }

    public String toString(){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < sizeArrayBackground; i++) {
            sp.append(arrayBackground[i] + " ");
        }
        return sp.toString();
    }
}

class IntegerContainerVer2 {
    private static final int SIZEARRAY = 1000;
    private int index = 0;
    private Integer[] array = new Integer[SIZEARRAY];

    public int size(){
        return SIZEARRAY;
    }

    public void add(Integer object) {
        if (index > SIZEARRAY - 1){
            throw new IndexOutOfBoundsException();
        } else {
            array[index++] = object;
        }
    }

    public Integer get(int index) {
        if (index < 0 || index > SIZEARRAY) {
            throw new IndexOutOfBoundsException();
        } else {
            return this.array[index];
        }
    }

    public void incrementAll(){
        for (int i = 0; i < SIZEARRAY; i++) {
            this.array[i]++;
        }
    }
    public String toString() {
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sp.append(array[i] + " ");
        }
        return sp.toString();
    }
}

public class Example_32 {
    public static long addTimeTest(IntegerContainer ic, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            ic.add(i);
        }
        long end = System.nanoTime();
        return (end - start) / reps;
    }

    public static long addTimeTest(ArrayList<Integer> arrayList, int reps) {
        long start = System.nanoTime();
        for (int i  = 0; i < reps; i++) {
            arrayList.add(i);
        }
        long end = System.nanoTime();
        return (end - start) / reps;
    }

    public static long getTimeTest(IntegerContainer ic, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            ic.get(i);
        }
        long end = System.nanoTime();
        return (end - start) / reps;
    }

    public static long getTimeTest(ArrayList<Integer> arrayList, int reps) {
        long start = System.nanoTime();
         for (int i = 0; i < reps; i++) {
             arrayList.get(i);
         }
         long end = System.nanoTime();
         return (end - start) / reps;
    }

    public static long addTimeTest(IntegerContainerVer2 ic2, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            ic2.add(i);
        }
        long end = System.nanoTime();
        return (end - start) / reps;
    }

    public static long getTimeTest(IntegerContainerVer2 ic2, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            ic2.get(i);
        }
        long end = System.nanoTime();
        return (end - start) / reps;
    }

    public static long incrementTimeTest(IntegerContainer ic, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            ic.incrementAll();
        }
        long end = System.nanoTime();
        return (end - start) / reps;
    }

    public static long incrementTimeTest(ArrayList<Integer> arrayList, int reps) {
        long start = System.nanoTime();
        for (Integer i : arrayList) {
            i++;
        }
        long end = System.nanoTime();
        return (end - start) / reps;
    }

    public static long incrementTimeTest(IntegerContainerVer2 ic2, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            ic2.incrementAll();
        }
        long end = System.nanoTime();
        return (end - start) / reps;
    }

    public static void main(String[] args) {
        IntegerContainer ic = new IntegerContainer();
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println("Add time (nanosecond): ");
        System.out.println("Mean of 1000");
        System.out.println("ic add(): " + addTimeTest(ic, 1000));
        System.out.println("arrayList add(): " + addTimeTest(arrayList, 1000));
        System.out.println();
        System.out.println("Get time (nanosecond)");
        System.out.println("Mean Of 1000");
        System.out.println("ic get(): " + getTimeTest(ic, 1000));
        System.out.println("arrayList get(): " + getTimeTest(arrayList, 1000));
        System.out.println();
        System.out.println("Alternate use IntegerContainerVer2 fixed size");
        IntegerContainerVer2 ic2 = new IntegerContainerVer2();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        System.out.println("Add time (nanosecond)");
        System.out.println("Mean of 1000");
        System.out.println("ic2 add(): " + addTimeTest(ic2, 1000));
        System.out.println("arrayList2 add(): " + addTimeTest(arrayList2, 1000));
        System.out.println();
        System.out.println("Get time (nanosecond)");
        System.out.println("Mean of 1000");
        System.out.println("ic2 get(): " + getTimeTest(ic2, 1000));
        System.out.println("arrayList2 get(): " + getTimeTest(arrayList2, 1000));
        System.out.println();
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            arrayList3.add(1);
        }
        IntegerContainer ic3 = new IntegerContainer();
        for (int i = 0; i < 1000; i++) {
            ic3.add(1);
        }
        IntegerContainerVer2 ic32 = new IntegerContainerVer2();
        for (int i = 0; i < 1000; i++) {
            ic32.add(1);
        }
        System.out.println("increment time Test (1000 times):");
        System.out.println("arrayList3 incrementAll(): " + incrementTimeTest(arrayList3, 1000));
        System.out.println("ic3 incrementAll(): " + incrementTimeTest(ic3, 1000));
        System.out.println("ic32 incrementAll(): " + incrementTimeTest(ic32, 1000));
    }
}
