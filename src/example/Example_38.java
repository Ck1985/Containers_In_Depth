package example;

import java.util.*;
import performanceTestFrameWork.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

class MapPerformance_38 {
    static List<Test<Map<Integer,String>>> testList = new ArrayList<>();
    static CountingGenerator.String generator = new CountingGenerator.String(5);
    static {
        testList.add(new Test<Map<Integer,String>>("put") {
            public int test(Map<Integer,String> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;

                for (int i = 0; i < loops; i++) {
                    map.clear();
                    for (int j = 0; j < size; j++) {
                        map.put(j, generator.next());
                    }
                }
                return loops * size;
            }
        });
        testList.add(new Test<Map<Integer,String>>("get") {
            public int test(Map<Integer,String> map, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++) {
                        map.get(j);
                    }
                }
                return loops * span;
            }
        });
        testList
    }
}
public class Example_38 {
    public static void main(String[] args) {

    }
}
