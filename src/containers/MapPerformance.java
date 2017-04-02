package containers;

import performanceTestFrameWork.*;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class MapPerformance {
    private static List<Test<Map<Integer,Integer>>> testsList = new ArrayList<>();

    static {
        testsList.add(new Test<Map<Integer, Integer>>("put") {
            int test(Map<Integer,Integer> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    map.clear();
                    for (int j = 0; j < size; j++) {
                        map.put(i, j);
                    }
                }
                return loops * size;
            }
        });
        testsList.add(new Test<Map<Integer, Integer>>("get") {
            int test(Map<Integer, Integer> map, TestParam tp) {
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
        testsList.add(new Test<Map<Integer, Integer>>("iterator") {
            int test(Map<Integer, Integer> map, TestParam tp) {
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

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        Tester.fieldWidth = 10;
        Tester.run(new HashMap<Integer, Integer>(), testsList);
        Tester.run(new TreeMap<Integer, Integer>(), testsList);
        Tester.run(new LinkedHashMap<>(), testsList);
        Tester.run(new IdentityHashMap<>(), testsList);
        Tester.run(new Hashtable<>(), testsList);
        //Tester.run(new WeakHashMap<Integer, Integer>(), testsList);
    }
}
