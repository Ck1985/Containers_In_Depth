package containers;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class Bits {
    public static void printBitSet(BitSet bitset) {
        System.out.println("bits: " + bitset);
        StringBuilder bbits = new StringBuilder();
        for (int i = 0; i < bitset.size(); i++) {
            bbits.append(bitset.get(i) ? "1" : "0");
        }
        System.out.println("bit pattern: " + bbits.toString());
    }
    public static void main(String[] args) {
        Random random = new Random(47);

        byte bt = (byte)random.nextInt();
        BitSet bb = new BitSet();
        for (int i = 7; i >= 0; i--) {
            if (((1 << i) & bt) != 0) {
                bb.set(i);
            } else {
                bb.clear(i);
            }
        }
        System.out.println("byte value: " + bt);
        printBitSet(bb);

        short st = (short)random.nextInt();
        BitSet bs = new BitSet();
        for (int i = 15; i >= 0; i--) {
            if (((1 << i) & st) != 0) {
                bs.set(i);
            } else {
                bs.clear(i);
            }
        }
        System.out.println("short value: " + st);
        printBitSet(bs);

        int it = random.nextInt();
        BitSet bi = new BitSet();
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & it) != 0) {
                bi.set(i);
            } else {
                bi.clear(i);
            }
        }
        System.out.println("int value:  " + it);
        printBitSet(bi);
        // Testing bitset >= 64 bits:
        BitSet b127 = new BitSet();
        b127.set(127);
        System.out.println("set bit 127: ");
        printBitSet(b127);
        BitSet b255 = new BitSet(65);
        b255.set(255);
        System.out.println("set bit 255");
        printBitSet(b255);
        BitSet b1023 = new BitSet(512);
        b1023.set(1023);
        System.out.println("set bit 1023");
        printBitSet(b1023);
    }
}
