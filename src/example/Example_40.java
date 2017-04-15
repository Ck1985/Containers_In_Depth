package example;

import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

class Employee implements Comparable<Employee>{
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int compareTo(Employee emp) {
        return (this.name.compareTo(emp.name) > 0) ? 1 : ((this.name.compareTo(emp.name)) == 0 ? 0 : -1);
    }

    public String toString() {
        return this.name + " - " + this.id;
    }
}
public class Example_40 {
    private static final int SIZE = 15;
    private static RandomGenerator.String genString = new RandomGenerator.String(7);
    public void showArray(Employee[] arrayEmp) {
        System.out.println(Arrays.toString(arrayEmp));
    }
    public static void main(String[] args) {
        Employee[] arrayEmp = new Employee[SIZE];
        for (int i = 0; i < arrayEmp.length; i++) {
            arrayEmp[i] = new Employee(genString.next(), i);
        }
        ArrayList<Employee> arrayList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(new Employee(genString.next(), i));
        }
        Example_40 exm = new Example_40();
        exm.showArray(arrayEmp);
        System.out.println(arrayList);
        Arrays.sort(arrayEmp);
        Collections.sort(arrayList);
        exm.showArray(arrayEmp);
        System.out.println(arrayList);
        Arrays.sort(arrayEmp, new EmployeeComId());
        Collections.sort(arrayList, new EmployeeComId());
        exm.showArray(arrayEmp);
        System.out.println(arrayList);
        arrayEmp[5].setId(100);
        Employee serachKey = new Employee("anonymous", 100);
        arrayEmp[5] = serachKey;
        System.out.println(Arrays.binarySearch(arrayEmp,serachKey));
    }
}
