package bits;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class IntegerBinary {
    public static String convertByteToBinary(byte i) {
        StringBuilder sp = new StringBuilder();
        int bit = 0;
        for (int placeBit = 0; placeBit < 8; placeBit++) {
            bit = i & 1;
            i = (byte)(i >> 1);
            if (placeBit % 4 == 0) {
                sp.append(" ");
            }
            sp.append(bit);
        }
        String binary = sp.reverse().toString();
        return binary;
    }
    public static void main(String[] args) {
        //System.out.println(convertByteToBinary((byte)98));
        for (int i = 10; i > -11; i--) {
            System.out.println(convertByteToBinary((byte)i));
        }
    }
}
