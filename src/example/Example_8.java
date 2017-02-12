package example;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/12/2017.
 */
class Node<T>{
    private T valueNode;
    Node<T> nextNode;
    public Node(T valueNode, Node<T> nextNode){
        this.valueNode = valueNode;
        this.nextNode = nextNode;
    }
    public Node(T valueNode){
        this(valueNode, null);
    }
    public String toString(){
        if(this.valueNode == null){
            return null;
        }else{
            return this.valueNode.toString();
        }
    }
}
//Note: ListIterator and Iterator are same the cursor
class SListIterator<T>{
    private Node<T> currentNode;
    public SListIterator(Node<T> currentNode){
        this.currentNode = currentNode;
    }
    public boolean hasNext(){
        return this.currentNode.nextNode != null;
    }
    public Node<T> next(){
        currentNode = currentNode.nextNode;
        return currentNode;
    }
    public void insert(T t){
        currentNode.nextNode = new Node<T>(t, currentNode);
        currentNode = currentNode.nextNode;
    }
    public void remove(){
        if(currentNode.nextNode != null){
            currentNode.nextNode = currentNode.nextNode.nextNode;
        }
    }
}
class SList<T>{
    private Node<T> node = new Node<T>(null);
    public SListIterator<T> iterator(){
        return new SListIterator<T>(node);
    }
    public String toString(){
        if(node.nextNode == null){
            return "SList: []";
        }else{
            System.out.print("SList: [");
            SListIterator<T> it = this.iterator();
            StringBuilder sb = new StringBuilder();
            while(it.hasNext()){
                sb.append(it.next() + (it.hasNext() ? ", " : " "));
            }
            return sb + "]";
        }
    }
}
public class Example_8 {
    public static void main(String[] args){
        SList<String> sl = new SList<String>();
        SListIterator<String> slIterator = sl.iterator();
        System.out.println("Inserting ....");
        slIterator.insert("Hi");
        System.out.println(sl);
    }
}
