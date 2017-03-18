package containers;

import java.util.*;

/**
 * Demonstrator different performance in Lists.
 */
public class ListPerformance {
    static Random random = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static List<Test<LinkedList<Integer>>> qTest = new ArrayList<>();
}
