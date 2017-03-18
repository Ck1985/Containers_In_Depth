package containers;

import java.util.*;

/**
 * Demonstrator different performance in Lists.
 */
public class ListPerformance {
    static Random random = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static List<Test<LinkedList<Integer>>> qTest = new ArrayList<>();
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
                int listSize = list.size();
                for (int i = 0; i < loops; i++){
                    list.clear();
                    list.addAll(new CountingIntegerList(listSize));
                    while (listSize > 5){
                        list.remove(5);
                    }
                }
                return loops * listSize;
            }
        });

        //Test for queue behavior
        qTest.add(new Test<LinkedList<Integer>>("addFirst"){
            int test(LinkedList<Integer> linkedList, TestParam tp){
                int loops = tp.loops;
                int listSize = linkedList.size();
                for (int i = 0; i < loops; i++){
                    linkedList.clear();
                    for (int j = 0; j < listSize; j++){
                        linkedList.addFirst(47);
                    }
                }
                return loops * listSize;
            }
        });
        qTest.add(new Test<LinkedList<Integer>>("addLast"){
            int test(LinkedList<Integer> linkedList, TestParam tp){
                int loops = tp.loops;
                int listSize = linkedList.size();
                for (int i = 0; i < loops; i++){
                    linkedList.clear();
                    for (int j = 0; j < listSize; j++){

                    }
                }
            }
        });
    }
}