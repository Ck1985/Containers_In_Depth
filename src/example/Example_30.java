package example;

import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

abstract class TestSort<L> {
    String name;
    public TestSort(String name){
        this.name = name;
    }
    abstract int testSort(L list, TestParam_30 tp);
}
class TestParam_30{
    final int loops;
    final int size;
    public TestParam_30(int loops, int size){
        this.loops = loops;
        this.size = size;
    }
    public static TestParam_30[] createArrayParam(int...values){
        int sizeArray = values.length / 2;
        int n = 0;
        TestParam_30[] arrayParam = new TestParam_30[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            arrayParam[i] = new TestParam_30(values[n++],values[n++]);
        }
        return arrayParam;
    }
}
class Tester_30<L>{
    private static int fieldWidth = 8;
    private static int sizeWidth = 5;
    private static TestParam_30[] defaultParam = TestParam_30.createArrayParam(10,5000,100,5000,1000,5000,10000,200);
    private static TestParam_30[] listParam = defaultParam;
    private String sizeField = "%" + sizeWidth + "s";
    private static String stringField(){
        return "%" + fieldWidth + "s";
    }
    private static String numberField(){
        return "%" + fieldWidth + "s";
    }
    private String headLine = "";
    protected L list;
    protected L initialize(int size){
        return this.list;
    }
    private List<TestSort<L>> testSortList;
    public Tester_30(L list, List<TestSort<L>> testSortList){
        this.list = list;
        this.testSortList = testSortList;
        if (list != null) {
            headLine = list.getClass().getSimpleName();
        }
    }
    public static <L> void run(L list, List<TestSort<L>> testSortList){
        new Tester_30<L>(list, testSortList).timeTest();
    }
    public void setHeadLine(String newHeadLine){
        this.headLine = newHeadLine;
    }
    private void displayHeadLine(){
        int totalWidth = 0, dashLength = 0;
        totalWidth = fieldWidth + testSortList.size() + sizeWidth;
        dashLength = totalWidth - headLine.length() -1;
        StringBuilder head = new StringBuilder();
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        head.append(' ');
        head.append(headLine);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        System.out.println(head);
        System.out.format(sizeField, "size");
        for (TestSort<L> testSort : testSortList) {
            System.out.format(stringField(), testSort.name);
        }
    }
    public void timeTest(){
        this.displayHeadLine();
        System.out.println();
        for (TestParam_30 param : listParam) {
            System.out.format(sizeField, param.loops);
            for (TestSort<L> testSort : testSortList) {
                L list = this.initialize(param.size);
                long start = System.nanoTime();
                int reps = testSort.testSort(list, param);
                long duration = System.nanoTime() - start;
                long timePerReps = duration / reps;
                System.out.format(numberField(), timePerReps);
            }
            System.out.println();
        }
    }
}
class SortPerformance{
    private static Random random = new Random();
    private final static int reps = 1000;
    static List<TestSort<List<Integer>>> testSortList = new ArrayList<>();

    static {
        testSortList.add(new TestSort<List<Integer>>("sort()"){
            int testSort(List<Integer> list, TestParam_30 tp){
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < size; j++){
                        list.clear();
                        list.add(random.nextInt(size));
                    }
                    Collections.sort(list);
                }
                return loops * size;
            }
        });
    }
}
public class Example_30 {
    public static void main(String[] args){
        Tester_30<List<Integer>> tester_ArrayList = new Tester_30<List<Integer>>(new ArrayList<Integer>(), SortPerformance.testSortList);
        tester_ArrayList.timeTest();
        Tester_30<List<Integer>> tester_LinkedList = new Tester_30<>(new LinkedList<>(), SortPerformance.testSortList);
        tester_LinkedList.timeTest();
    }
}
