package example;
import java.util.*;

class Node<T>{
    private T valueNode;
    Node<T> nextNode;
    public Node(T valueNode, Node<T> nextNode){
        this.valueNode = valueNode;
        this.nextNode = nextNode;
    }
    public Node(T valueNode){
        this(valueNode,null);
    }
    public String toString(){
        if(this.valueNode == null){
            return null;
        }else{
            return valueNode.toString();
        }
    }
}
class SListIterator<T>{
    Node<T> currentNode;
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
    public void insert(T valueNewNode){
        currentNode.nextNode = new Node<T>(valueNewNode, currentNode.nextNode);
        currentNode = currentNode.nextNode;
    }
    public void remove(){
        if(currentNode.nextNode != null) {
            currentNode.nextNode = currentNode.nextNode.nextNode;
        }
    }
}
class SList<T>{
    Node<T> node = new Node<T>(null);
    SListIterator<T> iterator(){
        return new SListIterator<T>(this.node);
    }
    public String toString(){
        if(node.nextNode == null){
            return "SList: []";
        }else{
            SListIterator<T> sl = this.iterator();
            StringBuilder sb = new StringBuilder("[");
            while(sl.hasNext()){
                sb.append(sl.next() + (sl.hasNext() ? ", " : " "));
            }
            return sb + "]";
        }
    }
}
public class Example_8{
    public static void main(String[] args){
        SList<String> sl = new SList<>();
        SListIterator<String> iterator = sl.iterator();
        System.out.println("sl: "+ sl);
        iterator.insert("Hi");
        System.out.println("sl: " + sl);
        iterator.insert("I am");
        iterator.insert("AI");
        iterator.insert("I known you");
        iterator.insert("You are ck");
        iterator.insert("I am sure....you will live to 80 years old");
        iterator.insert("You are anonymous");
        System.out.println("sl: " + sl);
        iterator.remove();
        System.out.println(sl);
        System.out.println(iterator.currentNode);
        SListIterator<String> iterator2 = sl.iterator();
        System.out.println(iterator2.currentNode);
        iterator2.remove();
        iterator2.remove();
        System.out.println(sl);
        System.out.println(iterator2.currentNode.nextNode);
    }
}