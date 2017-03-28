package performanceTestFrameWork;

import java.util.*;
import net.mindview.util.*;

/**
 * ListPerformance.java
 */

public class ListPerformance {
    private static Random random = new Random();
    private final static int reps = 1000;
    private static List<Test<List<Integer>>> testList = new ArrayList<Test<List<Integer>>>();
    private static List<Test<LinkedList<Integer>>> qTestList = new ArrayList<>();
    static {
        // Test behaviors of List:
        testList.add(new Test<List<Integer>>("add"){
            public int test(List<Integer> container, TestParam tp){
                int listSize = tp.size;
                int loops = tp.loops;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < listSize; j++) {
                        container.add(j);
                    }
                }
                return loops * listSize;
            }
        });
        testList.add(new Test<List<Integer>>("get"){
            public int test(List<Integer> container, TestParam tp){
                int loops = tp.loops * reps;
                int listSize = container.size();
                for (int i = 0; i < loops; i++){
                    container.get(random.nextInt(listSize));
                }
                return loops;
            }
        });
        testList.add(new Test<List<Integer>>("set"){
            public int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = container.size();
                for (int i = 0; i < loops; i++) {
                    container.set(random.nextInt(listSize), 47);
                }
                return loops;
            }
        });
        testList.add(new Test<List<Integer>>("iterAdd"){
            public int test(List<Integer> container, TestParam tp){
                final int LOOPS = 1000000;
                int halfSize = container.size() / 2;
                ListIterator<Integer> iterator = container.listIterator(halfSize);
                for (int i = 0; i < LOOPS; i++){
                    iterator.add(47);
                }
                return LOOPS;
            }
        });
        testList.add(new Test<List<Integer>>("insert"){
            public int test(List<Integer> container, TestParam tp){
                int loops = tp.loops;
                for (int i = 0; i < loops; i++) {
                    container.add(5,47);
                }
                return loops;
            }
        });
        testList.add(new Test<List<Integer>>("remove"){
            public int test(List<Integer> container, TestParam tp){
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(new containers.CountingIntegerList(size));
                    while (container.size() > 5) {
                        container.remove(5);
                    }
                }
                return loops * size;
            }
        });
        qTestList.add(new Test<LinkedList<Integer>>("addFirst"){
            public int test(LinkedList<Integer> container, TestParam tp){
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.addFirst(47);
                    }
                }
                return loops * size;
            }
        });
        qTestList.add(new Test<LinkedList<Integer>>("addLast"){
            public int test(LinkedList<Integer> container, TestParam tp){
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.addLast(47);
                    }
                }
                return loops * size;
            }
        });
        qTestList.add(new Test<LinkedList<Integer>>("removeFirst"){
            public int test(LinkedList<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(new containers.CountingIntegerList(size));
                    while (container.size() > 0) {
                        container.removeFirst();
                    }
                }
                return loops * size;
            }
        });
        qTestList.add(new Test<LinkedList<Integer>>("removeLast"){
            public int test(LinkedList<Integer> container, TestParam tp){
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(new containers.CountingIntegerList(size));
                    while (container.size() > 0) {
                        container.removeLast();
                    }
                }
                return loops * size;
            }
        });
    }
    static class ListTester extends Tester<List<Integer>>{
        public ListTester(List<Integer> container, List<Test<List<Integer>>> listTest){
            super(container, listTest);
        }
        @Override
        protected List<Integer> initialize(int size){
            this.container.clear();
            container.addAll(new containers.CountingIntegerList(size));
            return this.container;
        }
        public static void run(List<Integer> container, List<Test<List<Integer>>> listTest){
            new Tester<List<Integer>>(container, listTest).timeTest();
        }
    }
    public static void main(String[] args){
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null, testList.subList(1,3)){
            @Override
            protected List<Integer> initialize(int size){
                Integer[] ia = Generated.array(Integer.class, new CountingGenerator.Integer(), size);
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadLine("Array as List");
        arrayTest.timeTest();

        Tester.fieldWidth = 12;
        Tester.defaultParams = TestParam.array(10,5000,100,5000,1000,5000,10000,200);
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        ListTester.run(new LinkedList<Integer>(), testList);
        ListTester.run(new ArrayList<Integer>(), testList);
        ListTester.run(new Vector<Integer>(), testList);

        Tester<LinkedList<Integer>> qTest = new Tester<LinkedList<Integer>>(new LinkedList<Integer>(), qTestList);
        qTest.setHeadLine("Queue Test");
        qTest.timeTest();
    }
}
