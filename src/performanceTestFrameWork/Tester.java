package performanceTestFrameWork;

import java.util.*;

/**
 * Tester.java
 */

public class Tester<C> {
    private TestParam[] defaultParams = TestParam.array(10,5000,100,5000,1000,5000,10000,500);
    private TestParam[] listParam = defaultParams;
    private String headLine = " ";
    private C container;
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

}
