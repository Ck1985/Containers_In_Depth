package formatSpecifiers;

import java.util.*;

/**
 * Receipt.java
 *   %[argument_index$][flags][width][.precision]conversion
 */
public class Receipt {
    private double total = 0;
    private Formatter formatter = new Formatter(System.out);
    public void printTitle(){
        formatter.format("%-15s %5s %10s %n", "Item", "Qty", "Price");
        formatter.format("%-15s %5s %10s %n", "----", "---", "-----");
    }
    public void print(String name, int qty, double price){
        formatter.format("%-15.15s %5d %10.2f %n", name, qty, price);
        total += price;
    }
    public void printTotal(){
        formatter.format("%-15s %5s %10.2f %n", "Tax", " ", total * 0.06);
        formatter.format("%-15s %5s %10s %n", " ", " ", "----");
        formatter.format("%-15s %5s %10.2f %n", "Total", " ", total * 1.6);
    }
    public static void main(String[] args){
        /*System.out.format("%,6.2f \n", 124.000);
        System.out.format("Hi ! %s you owe me: $%9.5f. \n", "Jack", 25.3);
        System.out.format("A number can  formatted as a string \"%1$s\"" + " or a number %1$d  \n", 10);
        System.out.format("The same argument can repeated multiple time in a format string" +
                "Ex: %1$d can repeated: %1$d", 20
        );

        System.out.println();
        System.out.format("%nMixing indexed and unindexed arguments: " +
                "%n%5$s %s %2$s %4$s %s %s %% %n",
                "one", "two", "three", "four", "five"
        );
        System.out.format("%s, %S, %S, %S, %s %n", "String", "String", null, (byte)1, 5.6);
        System.out.format("%b, %B, %B, %b %n", "String", null, (byte)1, 5.6);
        System.out.format("%h, %H, %H, %h, %H %n", "161", null, 161, new Integer(161), 5.6);
        System.out.format("\"%1$s\", \"%1$14s\", \"%1$14.2s\"", "Hello");*/

        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack 's Magic bean", 4, 4.25678);
        receipt.print("Princess 's Pean", 8, 8.9782);
        receipt.print("Cocacola", 19, 9.5);
        receipt.printTotal();
    }
}
