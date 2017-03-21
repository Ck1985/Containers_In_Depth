package performanceTestFrameWork;

import java.util.*;

/**
 * Tester.java
 */

public class Tester<C> {
    private static int dashLength = 0;
    private static int totalWidth = 0;
    private static int fieldWidth = 8;
    private static int sizeWidth = 5;
    private TestParam[] defaultParams = TestParam.array(10,5000,100,5000,1000,5000,10000,500);
    private TestParam[] listParam = defaultParams;
    private String sizeField = "%" + sizeWidth + "s";
    private static String stringField(){
        return "%" + fieldWidth + "s";
    }
    private static String numberField(){
        return "%" + fieldWidth + "d";
    }
    private String headLine = " ";
    private C container;
    private C initialize(int size){
        return this.container;
    }
    private List<Test<C>> listTest;
    public Tester(C container, List<Test<C>> listTest){
        this.container = container;
        this.listTest = listTest;
        if (container == null){
            this.headLine = this.getClass().getSimpleName();
        }
    }
    public Tester(C container, List<Test<C>> listTest, TestParam[] listParam){
        this(container, listTest);
        this.listParam = listParam;
    }
    private void displayHeadLine(){
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
    private void timeTest(){
        this.displayHeadLine();
        for (TestParam param : listParam) {
            System.out.format(numberField(), param.size);
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
