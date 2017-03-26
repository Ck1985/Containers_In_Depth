package example;

import java.util.*;
import performanceTestFrameWork.*;
import arrays.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

class ListPerformance{
    private static CountingGenerator.String generator = new CountingGenerator.String();
    private static final Random random = new Random();
    private static final int reps = 1000;
    private static class CountingStringList extends AbstractList<String>{
        private List<String> list = new ArrayList<>();
        private CountingGenerator.String generator = new CountingGenerator.String();
        private int size = 0;
        public CountingStringList(int size){
            this.size = size;
            for (int i = 0; i < size; i++){
                list.add(generator.next());
            }
        }
        public String get(int index){
            return String.valueOf(index);
        }
        public int size(){
            return this.size;
        }
    }
    static List<Test<List<String>>> testList = new ArrayList<Test<List<String>>>();
    static List<Test<LinkedList<String>>> qTestList = new ArrayList<Test<LinkedList<String>>>();
    static {
        testList.add(new Test<List<String>>("add"){
            public int test(List<String> list, TestParam tp){
                int loops = tp.loops;
                int sizeList = tp.size;
                    for (int i = 0; i < loops; i++) {
                        list.clear();
                        for (int j = 0; j < sizeList; j++) {
                            list.add(generator.next());
                        }
                    }
                return loops * sizeList;
            }
        });
        testList.add(new Test<List<String>>("get"){
            public int test(List<String> list, TestParam tp){
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++) {
                    list.get(random.nextInt(listSize));
                }
                return loops;
            }
        });
        testList.add(new Test<List<String>>("set"){
            public int test(List<String> list, TestParam tp){
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++) {
                        list.set(random.nextInt(listSize),generator.next());
                    }
                return loops;
            }
        });
        testList.add(new Test<List<String>>("iterAdd"){
            public int test(List<String> list, TestParam tp){
                final int LOOPS = 1000000;
                int halfSize = list.size() / 2;
                ListIterator<String> listIterator = list.listIterator(halfSize);
                for (int i = 0; i < LOOPS; i++) {
                        listIterator.add(generator.next());
                    }
                return LOOPS;
            }
        });
        testList.add(new Test<List<String>>("insert"){
            public int test(List<String> list, TestParam tp){
                int loops = tp.loops;
                for (int i = 0; i < loops; i++) {
                        list.add(5,generator.next());
                    }
                return loops;
            }
        });
        testList.add(new Test<List<String>>("remove"){
            public int test(List<String> list, TestParam tp){
                int loops = tp.loops;
                int listSize = tp.size;
                    for (int i = 0; i < loops; i++) {
                        list.clear();
                        list.addAll(new CountingStringList(listSize));
                        while (list.size() > 5) {
                            list.remove(5);
                        }
                    }
                return loops * listSize;
            }
        });
        qTestList.add(new Test<LinkedList<String>>("addFirst"){
            public int test(LinkedList<String> list, TestParam tp){
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                        list.clear();
                        for (int j = 0; j < size; j++) {
                            list.addFirst(generator.next());
                        }
                    }
                return loops * size;
            }
        });
        qTestList.add(new Test<LinkedList<String>>("addLast"){
            public int test(LinkedList<String> list, TestParam tp){
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                        list.clear();
                        list.addAll(new CountingStringList(listSize));
                        for (int j = 0; j < listSize; j++) {
                            list.addLast(generator.next());
                        }
                    }
                return loops * listSize;
            }
        });
        qTestList.add(new Test<LinkedList<String>>("removeFirst"){
            public int test(LinkedList<String> list, TestParam tp){
                int loops = tp.loops;
                int listSize = tp.size;
                    for (int i = 0; i < loops; i++) {
                        list.clear();
                        list.addAll(new CountingStringList(listSize));
                        while (list.size() > 0) {
                            list.removeFirst();
                        }
                    }
                return loops * listSize;
            }
        });
        qTestList.add(new Test<LinkedList<String>>("removeLast"){
            public int test(LinkedList<String> list, TestParam tp){
                int loops = tp.loops;
                int listSize = tp.size;
                    for (int i = 0; i < loops; i++) {
                        list.clear();
                        list.addAll(new CountingStringList(listSize));
                        while (list.size() > 0) {
                            list.removeLast();
                        }
                    }
                return loops * listSize;
            }
        });
    }
    static class ListTester extends Tester<List<String>>{
        public ListTester(List<String> container, List<Test<List<String>>> listTest){
            super(container, listTest);
        }
        @Override
        protected List<String> initialize(int size){
            try {
                container.clear();
                container.addAll(new CountingStringList(size));
            } catch (Exception e){
                System.err.println(e);
            }
            return container;
        }
        public static void run(List<String> list, List<Test<List<String>>> testList){
            new Tester<>(list, testList).timeTest();
        }
    }
}
class Example_29 {
    public static void main(String[] args){
        Tester<List<String>> arrayTest = new Tester<List<String>>(null, ListPerformance.testList.subList(1,3)){
            public List<String> initialize(int size){
                String[] strings = Generated.array(String.class, new CountingGenerator.String(), size);
                return Arrays.asList(strings);
            }
        };
        arrayTest.setHeadLine("Array as List");
        arrayTest.timeTest();

        Tester.fieldWidth = 12;
        Tester.defaultParams = TestParam.array(10,5000,100,5000,1000,5000,10000,200);
        ListPerformance.ListTester.run(new ArrayList<String>(), ListPerformance.testList);
        ListPerformance.ListTester.run(new LinkedList<String>(), ListPerformance.testList);
        ListPerformance.ListTester.run(new Vector<String>(), ListPerformance.testList);

        Tester<LinkedList<String>> qTest = new Tester<>(new LinkedList<String>(), ListPerformance.qTestList);
        qTest.setHeadLine("queue Test");
        qTest.timeTest();
    }
}
