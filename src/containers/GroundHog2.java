package containers;

/**
 * Created by anonymous.vn1985 on 2/19/2017.
 */
public class GroundHog2 extends GroundHog {
    public GroundHog2(int num){
        super(num);
    }
    public int hashCode(){
        return number;
    }
    public boolean equals(Object object){
        return object instanceof GroundHog2 && (number == ((GroundHog2)object).number);
    }
}
