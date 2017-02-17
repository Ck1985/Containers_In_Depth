package containers;
import java.util.*;
import containers.ToDoList.*;

/**
 * Created by anonymous on 2/17/2017.
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem>{
    static class ToDoItem implements Comparable<ToDoItem>{
        private char primary;
        private int secondary;
        private String item;
        public ToDoItem(String item, char primary, int secondary){
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }
        public int compareTo(ToDoItem arg){
            if(this.primary > arg.primary){
                return +1;
            }else{
                if(this.primary == arg.primary){
                    if(this.secondary > arg.secondary){
                        return +1;
                    }else if(this.secondary == arg.secondary){
                        return 0;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }
        }
        public String toString(){
            return Character.toString(primary) + this.secondary + ": " + this.item;
        }
    }
    public boolean add(String item, char primary, int secondary){
        return this.add(new ToDoItem(item, primary, secondary));
    }
    public static void main(String[] args){
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty Trash",'C',4);
        toDoList.add("Free Dog",'A',2);
        toDoList.add("Feed Bird",'B',7);
        toDoList.add("Wow lawn",'C',3);
        toDoList.add("Water lawn",'A',1);
        toDoList.add("Feed Cat",'B',1);

        while(!toDoList.isEmpty()){
            System.out.println(toDoList.remove() + " ");
        }
        System.out.println();
    }
}
