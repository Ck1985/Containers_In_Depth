package containers;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum Month {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER }

public class Stacks {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (Month month : Month.values()) {
            stack.push(month.toString());
        }
        System.out.println("Stack: " + stack);
        //Treating stack as a vector:
        stack.addElement("The last line");
        System.out.println("Element At index 5: " + stack.elementAt(5));
        System.out.println("Poping elements: ");
        while (!(stack.isEmpty())) {
            System.out.print(stack.pop() + ", ");
        }
        System.out.println();
        //Using linkedlist as a stack:
        LinkedList<String> linkedList = new LinkedList<>();
        for (Month month : Month.values()) {
            linkedList.addFirst(month.toString());
        }
        System.out.println("linkedList: " + linkedList);
        while (!linkedList.isEmpty()) {
            System.out.print(linkedList.removeFirst() + ", ");
        }
        System.out.println();
        //Using Stack from Holding your object chapter:
        net.mindview.util.Stack<String> stack2  = new net.mindview.util.Stack<>();
        for (Month month : Month.values()) {
            stack2.push(month.toString());
        }
        while (!stack2.empty()) {
            System.out.print(stack2.pop() +", ");
        }
        System.out.println();
    }
}
