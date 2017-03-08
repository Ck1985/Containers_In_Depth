package example;
import containers.*;
import net.mindview.util.*;
import java.util.*;
/**
 * This is SimpleHashMap_19
 */
class SimpleHashMap_19 extends SimpleHashMap<String,Integer>{
    String readFile(String fileName){
        return TextFile.read(fileName);
    }
    String[] arrayWords(String source){
        return source.split("\\W+");
    }
    java.util.Map<String,Integer> createMap(String[] source){
        for(int i = 0; i < source.length; i++){
            this.put(source[i],0);
        }
        System.out.println(this);
        Set<String> keySet = this.keySet();
        System.out.println(keySet);
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()){
            int count = 0;
            String itNext = it.next();
            for (String string : source){
                if(itNext.equals(string)){
                    count++;
                }
            }
            this.put(itNext,count);
        }
        return this;
    }
}
public class Example_19 {
    public static void main(String[] args){
        SimpleHashMap_19 shm = new SimpleHashMap_19();
        String source = shm.readFile("C:\\Users\\caoxu\\IdeaProjects\\Containers_In_Depth\\src\\example\\TestFile.txt");
        System.out.println(source);
        String[] sourceArray = shm.arrayWords(source);
        for(String string : sourceArray){
            System.out.print(string + ", ");
        }
        System.out.println(shm.createMap(sourceArray));
    }
}
