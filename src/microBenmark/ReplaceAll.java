package microBenmark;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class ReplaceAll {
    public static void replaceAll() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            String s = "This xxx a test.".replaceAll("xxx", "is");
        }
        long eclapsed = System.currentTimeMillis() - start;
        System.out.println("Time ecplased is : " + eclapsed + "ms");
        System.out.println((eclapsed * 1000.0) / 1000000 + " microsecond per excution");
    }
    public static void concatenation() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            String s = "This " + "is" + "a test";
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Time elapsed is: " + elapsed + "ms");
        System.out.println((elapsed * 1000.0) / 1000000 + " microsecond per excution");
    }
    public static void concatenation2() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            String s1 = "This";
            String s2 = "is";
            String s3 = "a Test";
            String s = s1 + s2 + s3;
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("elapsed is : " + elapsed + "ms");
        System.out.println((elapsed * 1000.0) / 1000000 + " microsecond per excution");
    }
    public static void main(String[] args) {
        replaceAll();
        System.out.println();
        concatenation();
        System.out.println();
        concatenation2();
    }
}
