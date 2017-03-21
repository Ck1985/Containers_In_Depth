package performanceTestFrameWork;

/**
 * TestParam.java
 */
class TestParam {
    private final int size;
    private final int loops;
    public TestParam(int size, int loops){
        this.size = size;
        this.loops = loops;
    }
    public static TestParam[] array(int...values){
        int size = values.length / 2;
        TestParam[] result = new TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++) {
            result[i] = new TestParam(values[n++], values[n++]);
        }
        return result;
    }
    public static TestParam[] array(String[] values){
        int size = values.length;
        int[] vals = new int[size];
        for (int i = 0; i < size; i++) {
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
}
