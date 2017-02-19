package containers;
import java.lang.reflect.*;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/19/2017.
 */
public class SpringDetector {
    public static <T extends GroundHog> void detectSpring(Class<T> type) throws Exception{
        Constructor<T> gHog = type.getConstructor(int.class);
        Map<GroundHog, Prediction> map = new HashMap<>();
        for(int i = 0; i < 10; i++){
            map.put(new GroundHog(i), new Prediction());
        }
        System.out.println("map: " + map);
        GroundHog groundHog = gHog.newInstance(3);
        System.out.println("Looking for Prediction groundHog for:" + groundHog);
        if(map.containsKey(groundHog)){
            System.out.println(map.get(groundHog));
        }else{
            System.out.println("Key is not found !!!");
        }
    }
    public static void main(String[] args) throws Exception{
            detectSpring(GroundHog.class);
    }
}
