package example;

import java.util.*;
import performanceTestFrameWork.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

class MapPerformance_35 {
    static List<Test<Map<Integer, Integer>>> testList = new ArrayList<>();
    static {
        testList.add(new Test<Map<Integer, Integer>>("put") {
            @Override
            public int test(Map<Integer, Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i  = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.put(i, j);
                    }
                }
                return loops * size;
            }
        });
        testList.add(new Test<Map<Integer, Integer>>("get") {
            @Override
            public int test(Map<Integer, Integer> container, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++) {
                        container.get(j);
                    }
                }
                return loops * span;
            }
        });
        testList.add(new Test<Map<Integer, Integer>>("iterator") {
            public int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                    }
                }
                return loops * map.size();
            }
        });
    }
}

public class Example_35 {
    public static void main(String[] args) {
        Tester.fieldWidth = 10;
        Tester.run(new SlowMap<Integer, Integer>(), MapPerformance_35.testList);
    }
}
