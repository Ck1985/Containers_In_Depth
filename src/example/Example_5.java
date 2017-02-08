package example;
import java.util.*;
import containers.*;

/**
 * Created by anonymous.vn1985 on 2/8/2017.
 */
class CountingMapData extends AbstractMap<Integer, String>{
    private int size;
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
    public CountingMapData(int size){
        this.size = (size < 0 ? 0 : size);
    }
    static class Entry implements Map.Entry<Integer, String>{
        private int index;
        public Entry(int index){
            this.index = index;
        }
        public boolean equals(Object object){
            return Integer.valueOf(index).equals(object);
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
    static class EntrySet extends AbstractSet<Map.Entry<Integer, String>>{
        private int size;
        public EntrySet(int size){
            if(size < 0){
                this.size = 0;
            }else if(size > chars.length){
                this.size = chars.length;
            }else{
                this.size = size;
            }
        }
        public int size(){
            return this.size;
        }
        private class Iter implements Iterator<Map.Entry<Integer, String>>{
            private Entry entry = new Entry(-1);
            public Map.Entry<Integer, String> next(){
                entry.index++;
                return entry;
            }
            public boolean hasNext(){
                return entry.index < size - 1;
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        }
        public Iterator<Map.Entry<Integer, String>> iterator(){
            return new Iter();
        }
    }
    private static Set<Map.Entry<Integer, String>> entries = new EntrySet(chars.length);
    public Set<Map.Entry<Integer, String>> entrySet(){
        return entries;
    }
}
public class Example_5 {
    public static void main(String[] args){
        System.out.println(new CountingMapData(60));
    }
}
