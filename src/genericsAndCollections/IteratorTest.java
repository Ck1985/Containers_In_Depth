package genericsAndCollections;
import java.util.*;

/**
 * Created by anonymous on 3/1/2017.
 */
class Dog{
    private String name;
    public Dog(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
public class IteratorTest {
    public static void main(String[] args){
        List<Dog> dogList = new ArrayList<>();
        Dog dog = new Dog("aiko");
        dogList.add(dog);
        dogList.add(new Dog("clover"));
        dogList.add(new Dog("macdonia"));
        Iterator<Dog> iterator = dogList.iterator();
        Dog dog2 = null;
        while(iterator.hasNext()){
            dog2 = iterator.next();
            System.out.print(dog2.getName() + " ");
        }

        System.out.println("size(): " + dogList.size());
        System.out.println("dogList.get(1): " + dogList.get(1) .getName());
        System.out.println("dogList.indexOf(dog): " + dogList.indexOf(dog));

        dogList.remove(2);
        Object[] dogArray = dogList.toArray();
        for(Object d : dogArray){
            System.out.print(((Dog)d).getName());
        }
    }
}
