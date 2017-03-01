package genericsAndCollections;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 3/1/2017.
 */
public class MapTest {
    public static void main(String[] args){
        Map<Object,Object> map = new HashMap<>();
        map.put("k1",new Dog("akido"));
        map.put("k2",Pets.DOG);
        map.put(Pets.CAT, "CAT Key");
        Dog d1 = new Dog("Clover");
        map.put(d1, "DOG Key");
        map.put(new Cat(), "Cat Key");

        System.out.println("map.get(\"k1\"):" + map.get("k1"));
        String k2 = "k2";
        System.out.println("map.get(\"k2\"): " + map.get(k2));
        Pets p = Pets.CAT;
        System.out.println("map.get(p): " + map.get(p));
        System.out.println("map.get(d1): " + map.get(d1));
        System.out.println("map.get(new Cat()): " + map.get(new Cat()));
        System.out.println(map.size());
    }
}
