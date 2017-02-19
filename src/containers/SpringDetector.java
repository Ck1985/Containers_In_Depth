package containers;
import java.lang.reflect.*;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/19/2017.
 */
public class SpringDetector {
    public static <T extends GroundHog2> void detectSpring(Class<T> type) throws Exception{
        Constructor<T> gHog = type.getConstructor(int.class);
        Map<GroundHog, Prediction> map = new HashMap<>();
        for(int i = 0; i < 10; i++){
            map.put(new GroundHog2(i), new Prediction());
        }
        System.out.println("map: " + map);
        GroundHog2 groundHog = gHog.newInstance(3);
        System.out.println("Looking for Prediction groundHog for:" + groundHog);
        if(map.containsKey(groundHog)){
            System.out.println("found key = " + groundHog + "---" + map.get(groundHog));
        }else{
            System.out.println("Key is not found !!!");
        }
    }
    public static void main(String[] args) throws Exception{
            detectSpring(GroundHog2.class);
    }
}
