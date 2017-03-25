package performanceTestFrameWork;

import java.util.*;

/**
 * Tester.java
 */

public class Tester<C> {
    public static int fieldWidth = 8;
    public static int sizeWidth = 5;
    public static TestParam[] defaultParams = TestParam.array(10,5000,100,5000,1000,5000,10000,500);
    public static TestParam[] listParam = defaultParams;
    private String sizeField = "%" + sizeWidth + "s";
    private static String stringField(){
        return "%" + fieldWidth + "s";
    }
    private static String numberField(){
        return "%" + fieldWidth + "d";
    }
    private String headLine = " ";
    protected C container;
    protected C initialize(int size){
        return this.container;
    }
    private List<Test<C>> listTest;
    public Tester(C container, List<Test<C>> listTest){
        this.container = container;
        this.listTest = listTest;
        if (container != null){
            this.headLine = container.getClass().getSimpleName();
        }
    }
    public Tester(C container, List<Test<C>> listTest, TestParam[] listParam){
        this(container, listTest);
        this.listParam = listParam;
    }
    public void setHeadLine(String newHeadLine) {
        this.headLine = newHeadLine;
    }
    public static <C> void run(C container, List<Test<C>> listTest){
        new Tester<C>(container, listTest).timeTest();
    }
    public static <C> void run(C container, List<Test<C>> listTest, TestParam[] listParam){
        new Tester<C>(container, listTest, listParam);
    }
    private void displayHeadLine(){
        int totalWidth = 0;
        int dashLength = 0;
        totalWidth = fieldWidth * listTest.size() + sizeWidth;
        dashLength = totalWidth - headLine.length() - 1;
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
        for (Test<C> test : listTest) {
            System.out.format(stringField(), test.name);
        }
        System.out.println();
    }
    public void timeTest(){
        this.displayHeadLine();
        for (TestParam param : listParam) {
            System.out.format(sizeField, param.size);
            for (Test<C> test : listTest) {
                C kontainer = this.initialize(param.size);
                long start = System.nanoTime();
                int reps = test.test(kontainer,param);
                long duration = System.nanoTime() - start;
                long timePerReps = duration / reps;
                System.out.format(numberField(), timePerReps);
            }
            System.out.println();
        }
    }
}
