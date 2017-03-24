package example;

import java.util.*;
import performanceTestFrameWork.*;
import arrays.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

class ListPerformance{
    private static final int reps = 1000;
    private static List<Test<List<String>>> testList = new ArrayList<Test<List<String>>>();
    private static List<Test<LinkedList<String>>> qTestList = new ArrayList<Test<LinkedList<String>>>();
    static {
        testList.add(new Test<List<String>>("add"){
            int test(List<String> list, TestParam tp){
                int loops = tp.loops;
                int sizeList = tp.size;
                try {
                    CountingGenerator.String generator = CountingGenerator.String.class.newInstance();
                    for (int i = 0; i < loops; i++) {
                        list.clear();
                        for (int j = 0; j < sizeList; j++) {
                            list.add(generator.next());
                        }
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
                return loops * sizeList;
            }

        });
    }
}
class Example_291 {
    public static void main(String[] args){
        /*try {
            CountingGenerator.String string = CountingGenerator.String.class.newInstance();
            System.out.println(string.next());
        }catch (Exception e){
            System.out.println(e);
        }*/
    }
}
