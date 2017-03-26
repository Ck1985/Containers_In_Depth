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
    abstract int testSort(L list, TestParam tp);
}
class TestParam{
    final int loops;
    final int size;
    public TestParam(int loops, int size){
        this.loops = loops;
        this.size = size;
    }
    public static TestParam[] createArrayParam(int...values){
        int sizeArray = values.length / 2;
        int n = 0;
        TestParam[] arrayParam = new TestParam[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            arrayParam[i] = new TestParam(values[n++],values[n++]);
        }
        return arrayParam;
    }
}
class Tester<L>{
    private static int fieldWidth = 8;
    private static int sizeWidth = 5;
    private static TestParam[] defaultParam = TestParam.createArrayParam(10,5000,100,5000,1000,5000,10000,200);
    private static TestParam[] listParam = defaultParam;
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
    public Tester(L list, List<TestSort<L>> testSortList){
        this.list = list;
        this.testSortList = testSortList;
    }
    public static <L> void run(L list, List<TestSort<L>> testSortList){
        new Tester<L>(list, testSortList).timeTest();
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
        for (TestParam param : listParam) {
            System.out.format(sizeField, param.size);
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

}
public class Example_30 {
    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        CountingGenerator.Integer generator = new CountingGenerator.Integer();
        for (int i = 0; i < 20; i++){
            arrayList.add(generator.next());
        }
        System.out.println(arrayList);
    }
}
