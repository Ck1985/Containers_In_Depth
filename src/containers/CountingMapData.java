package containers;
import java.util.*;

/**
 * Created by anonymous on 2/8/2017.
 */
public class CountingMapData extends AbstractMap<Integer, String>{
    private int size;
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
    public CountingMapData(int size){
        this.size = (size < 0 ? 0 : size);
    }
    private static class Entry implements Map.Entry<Integer, String>{
        int index;
        Entry(int index){
            this.index = index;
        }
        public boolean equals(Object object){
            return Integer.valueOf(this.index).equals(object);
        }
        public Integer getKey(){
            return this.index;
        }
        public String getValue(){
            return chars[index % chars.length] + Integer.valueOf(index / chars.length);
        }
        public String setValue(String value){
            throw new UnsupportedOperationException();
        }
        public int hashCode(){
            return Integer.valueOf(index).hashCode();
        }
    }
    public Set<Map.Entry<Integer, String>> entrySet(){
        Set<Map.Entry<Integer, String>> entrySet = new LinkedHashSet<>();
        for(int i = 0; i < size; i++){
            entrySet.add(new Entry(i));
        }
        return entrySet;
    }
    public static void main(String[] args){
        System.out.println(new CountingMapData(60));
    }
}
