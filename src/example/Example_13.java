package example;
import java.util.*;
import net.mindview.util.TextFile;
import java.util.regex.*;

/**
 * Created by anonymous.vn1985 on 2/18/2017.
 */
class AssociativeArray extends LinkedHashMap<String, Integer>{
    String readFile(String fileName){
        return TextFile.read(fileName);
    }
    String[] arrayWords(String sourceString){
        return sourceString.split("\\W+");
    }
    public Map<String, Integer> createMap(String[] source){
        int count = 0;
        for(int i = 0; i < source.length; i++){
            this.put(source[i], 0);
        }
        Set<String> keySet = this.keySet();
        System.out.println(keySet);
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            count = this.get(element);
            for(int i = 0; i < source.length; i++){
                if(element.equals(source[i])){
                    count++;
                }
            }
            this.put(element, count);
        }
        return this;
    }
}
public class Example_13 {
    public static void main(String[] args){
        /*String[] arrayString = new String[]{"aaa", "bbb", "ccc", "ddd", "eee", "fff", "bbb", "ddd", "ggg", "ccc", "ccc"
        , "aaa", "eee", "ccc", "fff", "fff", "fff", "fff"};
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for(int i = 0; i < arrayString.length; i++){
            linkedHashMap.put(arrayString[i], 0);
        }
        int count = 0;
        Set<String> set = linkedHashMap.keySet();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            count = linkedHashMap.get(element);
            for(int i = 0; i < arrayString.length; i++){
                if(element.equals(arrayString[i])){
                    count++;
                }
                linkedHashMap.put(element,count);
            }
        }
        System.out.println(linkedHashMap);*/
        //--------------------------------------------------------------------//

        AssociativeArray wordsMap = new AssociativeArray();
        String source = wordsMap.readFile("C:\\Users\\caoxu\\IdeaProjects\\Containers_In_Depth\\src\\example\\TestFile.txt");
        System.out.println(source);
        String[] sourceArray = wordsMap.arrayWords(source);
        System.out.println(wordsMap.createMap(sourceArray));
    }
}
