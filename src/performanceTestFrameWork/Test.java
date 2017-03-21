package performanceTestFrameWork;

/**
 * Test.java
 */
abstract class Test<C> {
    String name;
    public Test(String name){
        this.name = name;
    }
    abstract C test(C container, TestParam tp);
}
