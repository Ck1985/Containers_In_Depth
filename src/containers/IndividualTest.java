package containers;

import java.util.*;
import holding.MapOfList;
import pets.Pet;

/**
 * This is created by anonymous.vn1985@gmail.com
 */
public class IndividualTest {
    public static void main(String[] args){
        Set<Individual> pets = new TreeSet<>();
        for (List<? extends Pet> lp : MapOfList.petPeople.values()){
            for (Pet p : lp){
                pets.add(p);
            }
        }
        System.out.println(pets);
    }
}
