package bits;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class BitWise_Operators {
    public static String presentFullBinary(int binary) {
        StringBuilder stringBits = new StringBuilder();
        //This is bit masking
        int bit = 0;
        int count = 0;
        for (int placeBit = 0; placeBit < 32; placeBit++) {
            bit = binary & 1;
            binary >>= 1;
            if (count % 4 == 0) {
                stringBits.append(" ");
            }
            count++;
            stringBits.append(bit);
        }
        String result = stringBits.reverse().toString();
        return result;
    }

    public static void main(String[] args) {
        /*int a = 0b11111010;
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
        int c = 1;
        System.out.println(Integer.toBinaryString(c));*/
        int d = 0b1010;
        System.out.println(Integer.toBinaryString(d));
        int d2 = d << 4;
        System.out.println(Integer.toBinaryString(d2));
        System.out.println(presentFullBinary(0b1010));
        System.out.println(presentFullBinary(d2));
        System.out.println(presentFullBinary(0b000111100001101001011011));
    }
}
