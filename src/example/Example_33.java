package example;

import java.util.*;
import net.mindview.util.*;
import sun.nio.cs.FastCharsetProvider;

/**
 * Created by anonymous.vn1985@gmail.com
 */

abstract class Test_33<L> {
    private String name;
    public String getName() {
        return this.name;
    }
    public Test_33(String name){
        this.name = name;
    }
    abstract int test(L list, TestParam_33 tp);
}

class TestParam_33 {
    private int loops;
    private int size;

    public int getLoops() {
        return this.loops;
    }

    public int getSize() {
        return this.size;
    }
    
    public TestParam_33(int loops, int size) {
        this.loops = loops;
        this.size = size;
    }
    
    public static TestParam_33[] createParams(int...values) {
        TestParam_33[] params = new TestParam_33[values.length / 2];
        int n = 0;
        
        for (int i = 0; i < values.length / 2; i++) {
            params[i] = new TestParam_33(values[n++], values[n++]);
        }
        return params;
    }
}

class Tester_33<L> {
    private L list;
    private TestParam_33[] paramList = TestParam_33.createParams(10,5000,100,5000,1000,5000,10000,200);
    private static int sizeWidth = 5;
    static int fieldTestWidth = 10;
    private static String sizeField = "%" + sizeWidth + "s";
    private static String stringField(){
        return "%" + fieldTestWidth + "s";
    }
    private static String numberField() {
        return "%" + fieldTestWidth + "d";
    }
    private List<Test_33<L>> testList;
    private String headLine = " ";
    public Tester_33(L list, List<Test_33<L>> testList) {
        this.list = list;
        this.testList = testList;
        if (list != null) {
            this.headLine = list.getClass().getSimpleName();
        }
    }
    public L initialize(int size) {
        return this.list;
    }
    void setHeadLine(String newHeadLine) {
        this.headLine = newHeadLine;
    }
    private void showHeadLine() {
        int totalWidth = sizeWidth + (testList.size() * fieldTestWidth);
        int dashLength = (totalWidth - headLine.length()) / 2 - 1;
        StringBuilder head = new StringBuilder();
        for (int i = 0; i < dashLength; i++) {
            head.append('-');
        }
        head.append(" ");
        head.append(this.headLine);
        head.append(" ");
        for (int i = 0; i < dashLength; i++) {
            head.append('-');
        }
        System.out.print(head.toString());
        System.out.println();
        System.out.format(sizeField, "size");
        for(Test_33<L> test : testList) {
            System.out.format(stringField(), test.getName());
        }
        System.out.println();
    }
    public void timeTest() {
        this.showHeadLine();
        for(TestParam_33 param : paramList) {
            System.out.format(sizeField, param.getLoops());
            for (Test_33<L> test : testList) {
                long start = System.nanoTime();
                int reps = test.test(list, param);
                long end = System.nanoTime();
                long result = (end - start) / reps;
                System.out.format(numberField(), result);
            }
            System.out.println();
        }
    }

    public static <L> void run(L list, List<Test_33<L>> testList) {
        new Tester_33<L>(list, testList).timeTest();
    }
}

class TestPerformance_33 {
    private static Random random = new Random();
    private static int reps = 1000;
    static List<Test_33<FastTraversalLinkedList<Integer>>> testList = new ArrayList<>();
    static List<Test_33<FastTraversalLinkedList<Integer>>> qTestList = new ArrayList<>();
    static {
        testList.add(new Test_33<FastTraversalLinkedList<Integer>>("add()"){
            int test(FastTraversalLinkedList<Integer> list, TestParam_33 tp) {
                int loops = tp.getLoops();
                int size = tp.getSize();
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++) {
                        list.add(j);
                    }
                }
                return loops * size;
            }
        });
        testList.add(new Test_33<FastTraversalLinkedList<Integer>>("get()"){
            int test(FastTraversalLinkedList<Integer> list, TestParam_33 tp){
                int loops = tp.getLoops() * reps;
                int listSize = tp.getSize();
                for (int i = 0; i < loops; i++) {
                    list.get(random.nextInt(listSize));
                }
                return loops;
            }
        });
        testList.add(new Test_33<FastTraversalLinkedList<Integer>>("set()"){
            int test(FastTraversalLinkedList<Integer> list, TestParam_33 tp) {
                int loops = tp.getLoops() * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++) {
                    list.set(random.nextInt(listSize), 47);
                }
                return loops;
            }
        });
        testList.add(new Test_33<FastTraversalLinkedList<Integer>>("iterAdd"){
            int test(FastTraversalLinkedList<Integer> list, TestParam_33 tp) {
                int LOOPS = 10000;
                int halfSize = list.size() / 2;
                ListIterator<Integer> iterator = list.listIterator(halfSize);
                for(int i = 0; i < LOOPS; i++) {
                    iterator.add(i);
                }
                return LOOPS;
            }
        });
        testList.add(new Test_33<FastTraversalLinkedList<Integer>>("insert"){
            int test(FastTraversalLinkedList<Integer> list, TestParam_33 tp) {
                int loops = tp.getLoops();
                for (int i = 0; i < loops; i++) {
                    list.add(5,47);
                }
                return loops;
            }
        });
        testList.add(new Test_33<FastTraversalLinkedList<Integer>>("remove"){
            int test(FastTraversalLinkedList<Integer> list, TestParam_33 tp) {
                int loops = tp.getLoops();
                int size = tp.getSize();
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while (list.size() > 5) {
                        list.remove();
                    }
                }
                return loops;
            }
        });

        qTestList.add(new Test_33<FastTraversalLinkedList<Integer>>("addFirst"){
            int test(FastTraversalLinkedList<Integer> list, TestParam_33 tp) {
                int loops = tp.getLoops();
                int size = tp.getSize();

                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++) {
                        list.addFirst(47);
                    }
                }
                return loops * size;
            }
        });
        qTestList.add(new Test_33<FastTraversalLinkedList<Integer>>("addLast"){
            int test(FastTraversalLinkedList<Integer> list, TestParam_33 tp) {
                int loops = tp.getLoops();
                int size = tp.getSize();

                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++) {
                        list.addLast(47);
                    }
                }
                return loops * size;
            }
        });
        qTestList.add(new Test_33<FastTraversalLinkedList<Integer>>("removeFirst"){
            int test(FastTraversalLinkedList<Integer> list, TestParam_33 tp) {
                int loops = tp.getLoops();
                int size = tp.getSize();

                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while (list.size() > 5) {
                        list.removeFirst();
                    }
                }
                return loops * size;
            }
        });
        qTestList.add(new Test_33<FastTraversalLinkedList<Integer>>("removeLast"){
            int test(FastTraversalLinkedList<Integer> list, TestParam_33 tp) {
                int loops = tp.getLoops();
                int size = tp.getSize();

                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while (list.size() > 5) {
                        list.removeLast();
                    }
                }
                return loops * size;
            }
        });
    }
}

class FastTraversalLinkedList<E> {
    private LinkedList<E> linkedList = new LinkedList<>();
    private ArrayList<E> arrayList = new ArrayList<>();

    private ArrayList<E> convertToArrayList() {
        this.arrayList.clear();
        this.arrayList.addAll(linkedList);
        this.linkedList.clear();
        return this.arrayList;
    }

    private LinkedList<E> convertToLinkedList() {
        this.linkedList.clear();
        this.linkedList.addAll(arrayList);
        this.arrayList.clear();
        return this.linkedList;
    }

    public int size() {
        if (this.linkedList.size() > this.arrayList.size()) {
            return this.linkedList.size();
        } else {
            return this.arrayList.size();
        }
    }

    // Operations will processed on linkedList for adding and removing fast performance
    public void clear() {
        if (this.linkedList.size() > this.arrayList.size()) {
            this.linkedList.clear();
        } else {
            this.convertToLinkedList();
            this.linkedList.clear();
        }
    }

    public boolean add(E object) {
        if (this.linkedList.size() > this.arrayList.size()) {
            return this.linkedList.add(object);
        } else {
            this.convertToLinkedList();
            return this.linkedList.add(object);
        }
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (this.linkedList.size() > this.arrayList.size()) {
            return this.linkedList.addAll(collection);
        } else {
            this.convertToLinkedList();
            return this.linkedList.addAll(collection);
        }
    }

    public void addFirst(E object) {
        if (this.linkedList.size() > this.arrayList.size()) {
            this.linkedList.addFirst(object);
        } else {
            this.convertToLinkedList();
            this.linkedList.addFirst(object);
        }
    }

    public void addLast(E object) {
        if (this.linkedList.size() > this.arrayList.size()) {
            this.linkedList.addLast(object);
        } else {
            this.convertToLinkedList();
            this.linkedList.addLast(object);
        }
    }

    public void add(int index, E object) {
        if (this.linkedList.size() > this.arrayList.size()) {
            this.linkedList.add(index, object);
        } else {
            this.linkedList.add(index, object);
        }
    }

    public void addAll(int index, Collection<? extends E> collection) {
        if (this.linkedList.size() > this.arrayList.size()) {
            this.linkedList.addAll(collection);
        } else {
            this.convertToLinkedList();
            this.linkedList.addAll(collection);
        }
    }

    public E remove() {
        if (this.linkedList.size() > this.arrayList.size()) {
            return this.linkedList.remove();
        } else {
            this.convertToLinkedList();
            return this.linkedList.remove();
        }
    }

    public E remove(int index) {
        if (this.linkedList.size() > this.arrayList.size()) {
            return this.linkedList.remove(index);
        } else {
            this.convertToLinkedList();
            return this.linkedList.remove(index);
        }
    }

    public boolean remove(Object object) {
        if (this.linkedList.size() > this.arrayList.size()) {
            return this.linkedList.remove(object);
        } else {
            this.convertToLinkedList();
            return this.linkedList.remove(object);
        }
    }

    public boolean removeAll(Collection<?> collection){
        if (this.linkedList.size() > this.arrayList.size()) {
            return this.linkedList.removeAll(collection);
        } else {
            this.convertToLinkedList();
            return this.linkedList.removeAll(collection);
        }
    }

    public E removeFirst() {
        if (this.linkedList.size() > this.arrayList.size()) {
            return this.linkedList.removeFirst();
        } else {
            this.convertToLinkedList();
            return this.linkedList.removeFirst();
        }
    }

    public E removeLast() {
        if (this.linkedList.size() > this.arrayList.size()) {
            return this.linkedList.removeLast();
        } else {
            this.convertToLinkedList();
            return this.linkedList.removeLast();
        }
    }

    public ListIterator<E> listIterator() {
        if (this.linkedList.size() > this.arrayList.size()) {
            return this.linkedList.listIterator();
        } else {
            this.convertToLinkedList();
            return this.linkedList.listIterator();
        }
    }

    public ListIterator<E> listIterator(int index) {
        if (this.linkedList.size() > this.arrayList.size()) {
            return this.linkedList.listIterator(index);
        } else {
            this.convertToLinkedList();
            return this.linkedList.listIterator(index);
        }
    }

    // Operations performed on ArrayList for fast access random
    public E get(int index) {
        if (this.arrayList.size() > this.linkedList.size()) {
            return this.arrayList.get(index);
        } else {
            this.convertToArrayList();
            return this.arrayList.get(index);
        }
    }
    public E set(int index, E object) {
        if (this.arrayList.size() > this.linkedList.size()) {
            return this.arrayList.set(index, object);
        } else {
            this.convertToArrayList();
            return this.arrayList.set(index, object);
        }
    }
    public Iterator<E> iterator() {
        if (this.arrayList.size() > this.linkedList.size()) {
            return this.arrayList.iterator();
        } else {
            this.convertToArrayList();
            return this.arrayList.iterator();
        }
    }
}

public class Example_33 {
    public static void main(String[] args) {
        Tester_33<FastTraversalLinkedList<Integer>> tester1 =
                new Tester_33<>(new FastTraversalLinkedList<>(), TestPerformance_33.testList);
        Tester_33.run(new FastTraversalLinkedList<Integer>(), TestPerformance_33.testList);
        System.out.println();
        Tester_33.fieldTestWidth = 15;
        Tester_33.run(new FastTraversalLinkedList<Integer>(), TestPerformance_33.qTestList);
    }
}
