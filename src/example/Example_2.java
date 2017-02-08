package example;
import containers.Countries;

import java.util.*;
import java.util.regex.*;

/**
 * Created by anonymous on 2/8/2017.
 */
public class Example_2 {
    public static void main(String[] args){
        Map<String, String> mc = new HashMap<>();
        Set<String> sc = mc.keySet();
        Pattern pattern = Pattern.compile("A[a-zA-Z]*");
        for(int i = 0; i < Countries.DATA.length; i++){
            if(pattern.matcher(Countries.DATA[i][0]).matches()){
                mc.put(Countries.DATA[i][0], Countries.DATA[i][1]);
            }
        }
        System.out.println(mc);
    }
}
