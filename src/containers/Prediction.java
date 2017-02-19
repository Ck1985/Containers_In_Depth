package containers;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/19/2017.
 */
public class Prediction {
    private Random random = new Random(47);
    private boolean shadow = random.nextDouble() > 0.5;
    public String toString(){
        if(shadow){
            return "Six more weeks of winter !";
        }else{
            return "Early Spring !";
        }
    }
}
