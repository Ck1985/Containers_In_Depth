package example;
import java.util.*;

/**
 * Created by anonymous on 2/17/2017.
 */
class Player implements Comparable<Player>{
    private String name;
    private Random random = new Random();
    private int starIndex;
    public Player(String name){
        this.name = name;
        this.starIndex = random.nextInt(100);
    }
    public int compareTo(Player player){
        return this.starIndex > player.starIndex ? 1 : (this.starIndex == player.starIndex ? 0 : -1);
    }
    public String toString(){
        return "Player: " + name + ": star = " + this.starIndex + " ";
    }
}

public class Example_11 {
    public static void main(String[] args){
        PriorityQueue<Player> priorityQueue = new PriorityQueue<Player>();
        priorityQueue.add(new Player("Christiano Ronaldo"));
        priorityQueue.offer(new Player("Juan Mata"));
        priorityQueue.offer(new Player("Eden Harza"));
        priorityQueue.offer(new Player("Rio Ferdinal"));

        while(!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.remove() + " ");
        }
        System.out.println();
    }
}
