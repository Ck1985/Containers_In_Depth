package example;

import java.util.*;
import net.mindview.util.*;
import performanceTestFrameWork.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class Example_34 {
    private static List<Test<Set<String>>> testsList = new ArrayList<>();
    private static CountingGenerator.String generator = new CountingGenerator.String();
    static {
        testsList.add(new Test<Set<String>>("add") {
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                    for (int j = 0; j < size; j++) {
                        set.add(generator.next());
                    }
                }
                return loops * size;
            }
        });
        testsList.add(new Test<Set<String>>("contains") {
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++) {
                        set.contains(generator.next());
                    }
                }
                return loops * span;
            }
        });
        testsList.add(new Test<Set<String>>("iterator") {
            public int test(Set<String> set, TestParam tp){
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<String> iterator = set.iterator();
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
            Tester.listParam = TestParam.array(args);
        }
        Tester.run(new HashSet<>(), testsList);
        Tester.run(new TreeSet<>(), testsList);
        Tester.run(new LinkedHashSet<>(), testsList);
    }
}
