package example;
import java.util.*;
import containers.*;
import net.mindview.util.TextFile;

/**
 * Created by anonymous on 3/2/2017.
 */
class AssociativeArray15 extends SlowMap<String, Integer>{
    String readFile(String fileName){
        return TextFile.read(fileName);
    }
    String[] arrayWords(String sourceString){
        return sourceString.split("\\W+");
    }
    public Map<String, Integer> createMap(String[] source){
        int count = 0;
        for(int i = 0; i < source.length; i++){
            this.put(source[i],0);
        }
        Set<Map.Entry<String, Integer>> entrySet = this.entrySet();
        Set<String> keySet = new HashSet<>();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while(iterator.hasNext()){
            String key = iterator.next().getKey();
            keySet.add(key);
        }
        Iterator<String> itKey = keySet.iterator();
        String compare;
        while(itKey.hasNext()){
            compare = itKey.next();
            for(int i = 0; i < source.length; i++){
                if(compare.equals(source[i])){
                    this.put(source[i],this.get(source[i]) + 1);
                }
            }
        }
        return this;
    }
}
public class Example_15 {
    public static void main(String[] args){
        AssociativeArray15 wordsMap = new AssociativeArray15();
        String source = wordsMap.readFile("C:\\Users\\caoxu\\IdeaProjects\\Containers_In_Depth\\src\\genericsAndCollections\\dvdinfo.txt");
        System.out.println(source);
        String[] sourceArray = wordsMap.arrayWords(source);
        System.out.println(wordsMap.createMap(sourceArray));
    }
}
