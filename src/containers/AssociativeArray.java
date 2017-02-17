package containers;

/**
 * Created by anonymous on 2/17/2017.
 */
public class AssociativeArray<K,V> {
    private Object[][] pairs;
    private int index = 0;
    public AssociativeArray(int length){
        pairs = new Object[length][2];
    }
    public void put(K key, V value){
        if(this.index >= pairs.length){
            throw new IndexOutOfBoundsException();
        }else{
            this.pairs[index++] = new Object[]{key, value};
        }
    }
    @SuppressWarnings("unchecked")
    public V get(K key){
        for(int i = 0; i < pairs.length; i++){
            if(key.equals(pairs[i][0])){
                return (V)this.pairs[i][1];
            }
        }
        return null;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < pairs.length; i++){
            sb.append(this.pairs[i][0].toString());
            sb.append(": ");
            sb.append(this.pairs[i][1].toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    public static void main(String[] args){
        AssociativeArray<String, String> map = new AssociativeArray<>(5);
        map.put("Sky", "blue");
        map.put("Blood", "red");
        map.put("Glass", "green");
        map.put("Wood", "yellow");
        map.put("Tree", "black");
        System.out.println(map);
        System.out.println("Value of key = Glass: " + map.get("Glass"));
        try{
            map.put("xxx", "yyy");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
