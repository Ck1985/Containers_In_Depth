package bits;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class TwoComplement {
    public static void main(String[] args) {
        /**
         * This is Two 's complement:
         * 1/ Convert 3 to binary:
         *    3 / 2
         *    1   1 / 2
         *        1   0
         *        => 3 = 11
         *  2/ Convert -3 to binary:
         *  Ex: 8 bit:
         *      3 = 0000 0011
         *      reverse: 1111 1100
         *      Add 1:           1
         *               1111 1101
         *      => -3 =  1111 1101
         *  3/ Carry:
         *     Convert -4 to binary:
         *     4 / 2
         *     0   2 / 2
         *         0   1 / 2
         *             1   0
         *     4 = 100
         *     8 bit: 0000 0100
         *     invert:1111 1011
         *       Add 1:       1
         *            1111 1010
         *       carry:      1
         *            1111 1000
         *       carry:     1
         *            1111 1100
         *       => -4 = 1111 1100 (8 bit)
         */
        System.out.println("3 binary: " + Integer.toBinaryString(3));
        System.out.println("-3 binary: " + Integer.toBinaryString(-3));
        System.out.println("4 binary: " + Integer.toBinaryString(4));
        System.out.println("-4 binary: " + Integer.toBinaryString(-4));
        /**
         * Convert binary to decimal (form two 's complement)
         * Ex: 0110 0010 (positive number because the leading bit = 0)
         *     0 * 2^7 + 1 * 2^6 + 1 * 2^5 + 0 * 2^4 + 0 * 2^3 + 0 * 2^2 + 1 * 2^1 + 0 * 2^0
         *     64 + 32 + 2 = 98;
         *     1110  1010 (negative number because leading bit = 1)
         *     invert bit: 0001 0101
         *     Add 1:              1
         *        carry:   0001 0110
         *     1 * 2^4 + 1 * 2^2 + 1 * 2^1
         *     16 + 4 + 2 = 22
         *     Add (-) minus: result = -22;
         */
    }
}
