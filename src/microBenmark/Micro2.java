package microBenmark;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class Micro2 {
    private static final int REPS = 1000000;
    private static final String PART_1 = "For a real test, make this big";
    private static final String PART_2 = "So that we can see the GC effects";
    private static final String REGEX = "XXX";
    private static final String REPL = " -- ";
    private static final String PATTERN = PART_1 + REGEX + PART_2;

    private enum CodeType { concat, replace };

    private static void executeReplace(String template, String regex, String repl) {
        for (int i = 0; i < REPS; i++) {
            String s = template.replaceAll(regex, repl);
        }
    }

    private static void executeConcat(String part1, String part2, String repl) {
        for (int i = 0; i < REPS; i++) {
            String s = part1 + repl + part2;
        }
    }

    public static void main(String[] args) {
        for (CodeType code : CodeType.values()) {
            long start = System.currentTimeMillis();
            switch (code){
                case concat:
                    executeConcat(PART_1, PART_2, REPL);
                    break;
                case replace:
                    executeReplace(PATTERN, REGEX, REPL);
                    break;
                default:
            }
            long elapse = System.currentTimeMillis() - start;
            System.out.println("Elapse time is: " + elapse + "ms");
            System.out.println((elapse * 1000.0) / 1000000 + " microsecond");
        }
    }
}
