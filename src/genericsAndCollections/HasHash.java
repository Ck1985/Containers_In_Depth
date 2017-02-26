package genericsAndCollections;

/**
 * Created by anonymous on 2/26/2017.
 */
public class HasHash {
    public int x;
    HasHash(int xVal){
        this.x = xVal;
    }
    public boolean equals(Object object){
        if((object instanceof HasHash) && ((HasHash)object).x == this.x){
            return true;
        }else{
            return false;
        }
    }
    public int hashCode(){
        return this.x * 17;
    }
}
