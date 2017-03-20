package containers;

import java.util.*;
import net.mindview.util.*;
/**
 * Demonstrator different performance in Lists.
 */
public class ListPerformance {
    static Random random = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static List<Test<LinkedList<Integer>>> qTests = new ArrayList<>();
    static {
        tests.add(new Test<List<Integer>>("add"){
            int test(List<Integer> list, TestParam tp){
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++){
                    list.clear();
                    for (int j = 0; j < listSize; j++){
                        list.add(j);
                    }
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<Integer>>("get"){
            int test(List<Integer> list, TestParam tp){
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++){
                    list.get(random.nextInt(listSize));
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("set"){
            int test(List<Integer> list, TestParam tp){
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < listSize; i++){
                    list.set(random.nextInt(listSize), 47);
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("iterAdd"){
            int test(List<Integer> list, TestParam tp){
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<Integer> iterator = list.listIterator(half);
                for (int i = 0; i < LOOPS; i++){
                    iterator.add(47);
                }
                return LOOPS;
            }
        });
        tests.add(new Test<List<Integer>>("insert"){
            int test(List<Integer> list, TestParam tp){
                int loops = tp.loops;
                for (int i = 0; i < loops; i++){
                    list.set(5,47);
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("remove"){
            int test(List<Integer> list, TestParam tp){
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++){
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while (list.size() > 5){
                        list.remove(5);
                    }
                }
                return loops * size;
            }
        });

        //Test for queue behavior
        qTests.add(new Test<LinkedList<Integer>>("addFirst"){
            int test(LinkedList<Integer> linkedList, TestParam tp){
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++){
                    linkedList.clear();
                    for (int j = 0; j < size; j++){
                        linkedList.addFirst(47);
                    }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("addLast"){
            int test(LinkedList<Integer> linkedList, TestParam tp){
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++){
                    linkedList.clear();
                    for (int j = 0; j < size; j++){
                        linkedList.addLast(47);
                    }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("removeFirst"){
            int test(LinkedList<Integer> linkedList, TestParam tp){
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++){
                    linkedList.clear();
                    linkedList.addAll(new CountingIntegerList(size));
                        while (linkedList.size() > 0) {
                            linkedList.removeFirst();
                        }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("removeLast"){
            int test(LinkedList<Integer> linkedList, TestParam tp){
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    linkedList.clear();
                    linkedList.addAll(new CountingIntegerList(size));
                        while (linkedList.size() > 0) {
                            linkedList.removeLast();
                        }
                }
                return loops * size;
            }
        });
    }

    static class TesterList extends Tester<List<Integer>> {
        public TesterList(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }

        @Override protected List<Integer> initialize(int size) {
            container.clear();
            container.addAll(new CountingIntegerList(size));
            return container;
        }
        public static void run(List<Integer> list, List<Test<List<Integer>>> tests){
            new TesterList(list, tests).timeTest();
        }
    }

    public static void main(String[] args){
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null, tests.subList(1,3)){
            @Override
            protected List<Integer> initialize(int size){
                Integer[] ia = Generated.array(Integer.class, new CountingGenerator.Integer(), size);
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadLine("Array As List");
        arrayTest.timeTest();

        Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        TesterList.run(new ArrayList<Integer>(), tests);
        TesterList.run(new LinkedList<Integer>(), tests);
        TesterList.run(new Vector<Integer>(), tests);
        Tester.fieldWidth = 12;
        Tester<LinkedList<Integer>> qTest = new Tester<LinkedList<Integer>>(new LinkedList<Integer>(), qTests);
        qTest.setHeadLine("Queue Test");
        qTest.timeTest();
    }
}
