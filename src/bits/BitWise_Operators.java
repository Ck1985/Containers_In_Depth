package bits;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class BitWise_Operators {
    public static void main(String[] args) {
        int a = 0b11111010;
        int a2 = 0b11111100;
        int result = a & a2;
        System.out.println("a & a2 = " + result + " equals " + Integer.toBinaryString(result));

        int b = 0b11111010;
        int b2 = 0b11111100;
        int result2 = b | b2;
        System.out.println("b | b2 = " + result2 + " equals " + Integer.toBinaryString(result2));
        b2 = ~b;
        System.out.println("~b = " + b2 + " equals " + Integer.toBinaryString(b2));
        b2 = 0b11111100;
        b2 = b2 ^ b;
        System.out.println("b2 ^ b: " + b2 + " equals " + Integer.toBinaryString(b2));
    }
}
