package example;
import java.util.*;

/**
 * This is SlowMap Map, it implements Map interafce
 */
class SimpleHashSet<K> implements Set<K> {
    private static final int SIZE = 97;
    @SuppressWarnings("unchecked")
    private LinkedList<K>[] buckets = new LinkedList[SIZE];

    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        List arrayList = new ArrayList();
        for (LinkedList<K> bucket : this.buckets) {
            if (bucket == null) {
                continue;
            } else {
                int index = -1;
                for (K element : bucket) {
                    arrayList.add(element);
                }
            }
        }
        Object[] objectArray = arrayList.toArray();
        return objectArray;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] arrayT) {
        T[] newArray = null;
        List<T> arrayList = new ArrayList<>();
        for (LinkedList<K> bucket : this.buckets) {
            if (bucket == null) {
                continue;
            } else {
                for (K element : bucket) {
                    arrayList.add((T) element);
                }
            }
        }
        newArray = arrayList.toArray(arrayT);
        return newArray;
    }

    public void clear() {
        for (LinkedList<K> bucket : this.buckets) {
            if (bucket == null) {
                continue;
            } else {
                bucket.clear();
            }
        }
    }

    public int size(){
        int size = 0;
        for (LinkedList<K> bucket : buckets){
            if (bucket == null){
                continue;
            } else {
                size = size + bucket.size();
            }
        }
        return size;
    }

    public boolean remove(Object object) {
        int index = Math.abs(object.hashCode()) % SIZE;
        boolean result = false;
        if (this.buckets[index] == null) {
            return result;
        } else {
            result = this.buckets[index].remove(object);
            return result;
        }
    }

    public boolean removeAll(Collection<?> collection) {
        boolean result = false;
        int n = this.size();
        for (Object object : collection) {
            this.remove(object);
        }
        if (n != this.size()){
            result = true;
        }
        return result;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean result = false;
        int n = this.size();
        for (LinkedList<K> bucket : buckets){
            if (bucket == null){
                continue;
            } else {
                bucket.retainAll(collection);
            }
        }
        if (n != this.size()){
            result = true;
        }
        return result;
    }

    private int indexFirstNonEmptyBucket(){
        int first = 0;
        for (int i = 0; i < SIZE; i++){
            if (this.buckets[i] != null){
                first = i;
            }
        }
        return first;
    }

    private int startOfNonEmptyBucket(int i){
        int first = indexFirstNonEmptyBucket();
        int length = 0;
        for (int j = first; j < i; j++){
            if (this.buckets[j] == null){
                continue;
            } else {
                length = length + this.buckets[j].size();
            }
        }
        return length;
    }

    private int endOfNonEmptyBucket(int i){
        return startOfNonEmptyBucket(i) + this.buckets[i].size();
    }

    public Iterator<K> iterator(){
        return new Iterator<K>(){
            int marker = -1;
            public boolean hasNext(){
                return marker < size() - 1;
            }
            public K next(){
                K value = null;
                for (int i = 0; i < SIZE; i++){
                    if (buckets[i] == null){
                        continue;
                    } else {
                        ++marker;
                        if ((startOfNonEmptyBucket(i) <= marker) && (marker < endOfNonEmptyBucket(i))) {
                            value = buckets[i].get(marker - startOfNonEmptyBucket(i));
                        }
                    }
                }
                return value;
            }
        };
    }

    public boolean add(K object){
        int n = this.size();
        int index = Math.abs(object.hashCode()) % SIZE;
        if (this.contains(object)){
            return false;
        } else {
            if (this.buckets[index] == null) {
                this.buckets[index] = new LinkedList<K>();
            }
            this.buckets[index].add(object);
        }
        if (n < this.size()){
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public boolean contains(Object object){
        boolean found = false;
        for (LinkedList<K> bucket : buckets){
            if (bucket == null){
                continue;
            } else {
                for (K element : bucket){
                    if (element.equals((K)object)){
                        found = true;
                    }
                }
            }
        }
        return found;
    }

    public boolean isEmpty(){
        boolean isEmpty = true;
        for (LinkedList<K> bucket : buckets){
            if (bucket == null){
                continue;
            } else {
                if (!bucket.isEmpty()){
                    isEmpty = false;
                    return isEmpty;
                }
            }
        }
        return isEmpty;
    }

    public boolean containsAll(Collection<?> collection){
        boolean result = true;
        for (Object object : collection){
            if (!this.contains(object)){
                result = false;
                return result;
            }
        }
        return result;
    }

    public boolean addAll(Collection<? extends K> collection){
        int n = this.size();
        for (K object : collection){
            this.add(object);
        }
        if(n < this.size()){
            return true;
        }
        return false;
    }

    public int hashCode(){
        int hashCode = 0;
        for (LinkedList<K> bucket : buckets){
            if (bucket == null){
                continue;
            } else {
                for (K element : bucket){
                    if (element == null){
                        continue;
                    } else {
                        hashCode = hashCode + element.hashCode();
                    }
                }
            }
        }
        return hashCode;
    }

    public boolean equals(Object objectSet){
        if (!(objectSet instanceof SimpleHashSet)){
            return false;
        } else if (this.size() != ((SimpleHashSet)objectSet).size()){
            return false;
        } else {
            Iterator<K> iteratorThis = this.iterator();
            Iterator<K> iteratorObject = ((SimpleHashSet)objectSet).iterator();
            while (iteratorThis.hasNext()){
                if (!iteratorThis.next().equals(iteratorObject.next()))
                    return false;
            }
        }
        return true;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (LinkedList<K> bucket : buckets){
            if (bucket == null){
                continue;
            } else {
                for (K element : bucket){
                    sb.append(element + ", ");
                }
            }
        }
        return sb.toString();
    }
}
public class Example_24 {
    public static void main(String[] args){
        SimpleHashSet<String> shs = new SimpleHashSet<>();
        System.out.println("shs: " + shs);
        shs.add("Hi");
        shs.add("There");
        System.out.println("shs: " + shs);
        List<String> list = Arrays.asList("You", "Cute", "Pie");
        shs.addAll(list);
        System.out.println("shs " + shs);
        System.out.println("size(): " + shs.size());
        System.out.println("shs.contains(You): " + shs.contains("You"));
        System.out.println("shs.contains(me): " + shs.contains("me"));
        System.out.println("shs.containAll(list): " + shs.containsAll(list));
        SimpleHashSet<String> shs2 = new SimpleHashSet<>();
        System.out.println("shs2: " + shs2);
        System.out.println("shs2.containsAll(list): " + shs2.containsAll(list));
        System.out.println("shs.containsAll(shs2): " + shs.containsAll(shs2));
        shs2.addAll(list);
        //shs.clear();
        SimpleHashSet<String> shs3 = new SimpleHashSet<>();
        shs3.addAll(list);
        System.out.println("shs3: " + shs3);
        System.out.println("shs3.equals(shs2): " + shs3.equals(shs2));
        shs2.add("aaa");
        shs3.add("aaa");
        System.out.println("shs2.equals(shs3): " + shs2.equals(shs3));
        shs3.add("bbb");
        System.out.println(shs2.equals(shs3));
    }
}
