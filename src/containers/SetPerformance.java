package containers;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class SetPerformance {
    private static List<Test<Set<Integer>>> testList = new ArrayList<>();
    static {
        testList.add(new Test<Set<Integer>>("add"){
            int test(Set<Integer> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                    for (int j = 0; j < size; j++) {
                        set.add(j);
                    }
                }
                return loops * size;
            }
        });
        testList.add(new Test<Set<Integer>>("contains"){
            int test(Set<Integer> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++) {
                        set.contains(j);
                    }
                }
                return loops * span;
            }
        });
        testList.add(new Test<Set<Integer>>("iterator"){
            int test(Set<Integer> set, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<Integer> iterator = set.iterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                    }
                }
                return loops * set.size();
            }
        });
    }
    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.paramList = TestParam.array(args);
        }
        Tester.fieldWidth = 12;
        Tester.run(new HashSet<Integer>(), testList);
        Tester.run(new TreeSet<Integer>(), testList);
        Tester.run(new LinkedHashSet<Integer>(), testList);
    }
}
